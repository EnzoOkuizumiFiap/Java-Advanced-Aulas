package br.com.fiap.spy.auth;

import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class TokenService {
    private final JwtEncoder jwtEncoder;

    public TokenService(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    // Gera um token JWT contendo as informações do usuário autenticado
    String generateToken(String username) {
        Instant now = Instant.now();

        // Claims são as informações armazenadas dentro do token JWT
        JwtClaimsSet param = JwtClaimsSet.builder()
                .subject(username)
                .issuedAt(now)
                .expiresAt(now.plus(10, ChronoUnit.MINUTES))
                .claim("role", "ADMIN")
                .build();

        JwtEncoderParameters jwtClaimsSet = JwtEncoderParameters.from(param); // Converte as claims para o formato que o JwtEncoder utiliza
        return jwtEncoder.encode(jwtClaimsSet).getTokenValue(); // Cria, assina o token e retorna apenas seu valor em formato String
    }
}
