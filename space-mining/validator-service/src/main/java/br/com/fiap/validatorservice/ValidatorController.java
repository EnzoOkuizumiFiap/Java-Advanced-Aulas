package br.com.fiap.validatorservice;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ValidatorController {
    private final ValidatorPublisher validator;

    public record CommandRequest(@NotNull CommandEnum command) {}

    @PostMapping("/validate")
    public ResponseEntity<String> validate(@Valid @RequestBody CommandRequest request) {
        try {
            validator.publish(request.command().name());
            return ResponseEntity.ok("Comando validado e publicado: " + request.command());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Falha de comunicação após tentativas de retry: " + e.getMessage());
        }
    }

}
