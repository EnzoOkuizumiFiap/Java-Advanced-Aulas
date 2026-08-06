package br.com.fiap.spy.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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

    @Bean
    SecurityFilterChain config(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable()) // Desabilitamos o CSRF, pois ele acha que nossas requisições são um ataque
                .httpBasic(Customizer.withDefaults()) // Colocando Auth Básica
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Gerencia a sessão, no caso estamos dizendo para ele ser STATELESS, não manter os dados da sessão no Spring Boot
                .build();
    }

    @Bean // vv Gerente de usuários em memória vv
    UserDetailsManager users () {
        // Construindo um usuário com build / Usar {noop} somente em desenvolvimento
        UserDetails user = User.withUsername("enzo").password("{noop}123456").build();

        // Retornando usuário em memória
        return new InMemoryUserDetailsManager(user);
    }
}
