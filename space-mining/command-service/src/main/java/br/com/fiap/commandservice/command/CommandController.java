package br.com.fiap.commandservice.command;

import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class CommandController {
    private final RestTemplate restTemplate;

    public record CommandRequest(@NotBlank String command) {}

    @PostMapping({"", "/command"})
    @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody CommandRequest command) {

        // Envia uma requisição POST para o endpoint de validação
        return restTemplate.postForObject(
                "http://VALIDATOR-SERVICE/validate", // URL do serviço que irá validar o comando
                command, // Dados enviados no corpo da requisição
                String.class // Tipo do dado que esperamos receber como resposta
        );

    }
}
