package br.com.fiap.spy.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    // Nossos "DTOs"
    record LoginRequest(String username, String password) {}
    record LoginResponse(String token) {}

    // Endpoint para login na aplicação
    @PostMapping("login")
    public LoginResponse login (@RequestBody LoginRequest request) {
        return new LoginResponse("token-falso-so-pra-testar");
    }
}
