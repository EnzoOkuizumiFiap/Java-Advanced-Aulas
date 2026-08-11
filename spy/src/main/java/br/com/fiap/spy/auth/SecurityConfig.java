package br.com.fiap.spy.auth;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    /*
        SecurityFilterChain:
        É a cadeia de filtros do Spring Security responsável por interceptar
        requisições antes que elas cheguem ao Controller.

        Segue o padrão Chain of Responsibility: em vez de concentrar muitas
        verificações em vários ifs, cada filtro possui uma responsabilidade,
        como autenticação, autorização e validação de tokens.

        A requisição passa por cada filtro da cadeia. Se for aprovada, ela pode
        seguir para o Controller; caso contrário, a cadeia interrompe o fluxo e
        retorna uma resposta de erro, como 401 ou 403.

        Chain of Responsibility (Cadeia de Responsabilidade): box -> box -> box -> box
        E ele é um design pattern (Padrão de projetos) ^^
    */

    @ConfigurationProperties(prefix = "rsa")
    public record RsaKeyProperties(RSAPublicKey publicKey, RSAPrivateKey privateKey) {}

    @Bean
    SecurityFilterChain config(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable()) // Desabilitamos o CSRF, pois ele acha que nossas requisições são um ataque
                .httpBasic(withDefaults()) // Colocando Auth Básica
                .oauth2ResourceServer(auth -> auth.jwt(withDefaults())) // Define que o servidor aceitará e validará JWT como mecanismo de autenticação
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Gerencia a sessão, no caso estamos dizendo para ele ser STATELESS, não manter os dados da sessão no Spring Boot
                .build();
    }

    @Bean // vv Gerente de usuários em memória vv
    UserDetailsManager users () {
        // Construindo um usuário com build / Usar {noop} somente em desenvolvimento
        UserDetails enzo = User.withUsername("enzo").password("{noop}123456").build();
        UserDetails maria = User.withUsername("maria").password("{noop}123456").build();

        // Retornando usuário em memória
        return new InMemoryUserDetailsManager(enzo, maria);
    }

    // JSON Web Token (JWT) -> é um padrão aberto (RFC 7519) usado para transmitir informações de forma segura e compacta entre sistemas como um objeto JSON.

    @Bean // Bean responsável por validar os tokens JWT recebidos pela aplicação
    JwtDecoder jwtDecoder(RsaKeyProperties rsaKeyProperties) {
        // O Decoder utiliza a chave pública para verificar se a assinatura do token JWT é válida
        return NimbusJwtDecoder
                .withPublicKey(rsaKeyProperties.publicKey)
                .build();
    }

    // OBS: A chave pública não cria o token; ela apenas confirma que o token foi assinado pela chave privada correspondente.

    @Bean // Bean responsável por criar e assinar novos tokens JWT
    JwtEncoder jwtEncoder(RsaKeyProperties rsaKeyProperties) {
        var privateKey = rsaKeyProperties.privateKey(); // A chave privada é utilizada para assinar o token JWT
        var publicKey = rsaKeyProperties.publicKey(); // A chave pública identifica a chave usada para validar a assinatura

        /*
            Agrupamos as chaves pública e privada em uma RSAKey.
            O Builder facilita a criação dessa configuração de chave RSA.
        */
        RSAKey rsaKey = new RSAKey.Builder(publicKey).privateKey(privateKey).build();

        /*
            JWKSet representa um conjunto de chaves no formato JWK (JSON Web Key).
            ImmutableJWKSet transforma esse conjunto em uma fonte de chaves
            que pode ser utilizada pelo NimbusJwtEncoder.
        */
        ImmutableJWKSet<SecurityContext> jwtSource = new ImmutableJWKSet<>(new JWKSet(rsaKey));

        return new NimbusJwtEncoder(jwtSource); // O encoder utiliza a chave privada para assinar os tokens JWT
    }
}
