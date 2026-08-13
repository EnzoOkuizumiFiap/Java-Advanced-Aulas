package br.com.fiap.mypass.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    public AuthController(TokenService tokenService, AuthenticationManager authenticationManager) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    public record LoginRequest(String username, String password) {}
    public record LoginResponse(String username, String type, String token) {}

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        // Cria as credenciais com o usuário e senha recebidos no JSON
        var credentials = new UsernamePasswordAuthenticationToken(loginRequest.username, loginRequest.password);
        // AuthenticationManager valida se o usuário e senha estão corretos
        // (Se password estiver errado, Spring lança erro de autenticação 401)
        var authentication = authenticationManager.authenticate(credentials);

        var jwt = tokenService.generateToken(authentication.getName());
        return new LoginResponse(authentication.getName(), "Bearer", jwt);
    }
}
