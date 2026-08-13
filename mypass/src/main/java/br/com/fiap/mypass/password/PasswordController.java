package br.com.fiap.mypass.password;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pass")
public class PasswordController {
    private final PasswordRepository passwordRepository;

    public PasswordController(PasswordRepository passwordRepository) {
        this.passwordRepository = passwordRepository;
    }

    @GetMapping
    public List<Password> findAll() {
        return passwordRepository.findAll();
    }
}
