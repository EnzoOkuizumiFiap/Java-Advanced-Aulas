package br.com.fiap.spy.auth;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    // Nossos "DTOs"
    record LoginRequest(String username, String password) {}
    record LoginResponse(String token) {}

    // Endpoint para login na aplicação - Agora usando credenciais do Authorization (api.http)
    @PostMapping("login")
    public LoginResponse login (Authentication authentication) {
        var jwt = tokenService.generateToken(authentication.getName()); // Recupera Nome do user autenticado e gera um JWT
        return new LoginResponse(jwt); // O record LoginResponse vira a resposta JSON: { "token": "..." }
    }
}
