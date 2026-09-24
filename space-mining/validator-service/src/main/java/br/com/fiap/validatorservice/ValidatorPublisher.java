package br.com.fiap.validatorservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.resilience.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Component
@RequiredArgsConstructor
public class ValidatorPublisher {
    private final RabbitTemplate rabbitTemplate;

    @Retryable(
            includes = {ResponseStatusException.class},
            maxRetries = 3,
            delay = 500,
            jitter = 200,
            multiplier = 2,
            maxDelay = 5_000
    )
    public void publish(String command) {
        if (Math.random() > 0.5) {
            log.warn("EXPLODIU TUDO!! Falha na validação!!");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "🔴 COMMAND processing failed. Please try again.");
        }

        log.info("COMANDO processado com sucesso!");
        rabbitTemplate.convertAndSend(
                RabbitConfig.EXCHANGE_NAME,
                RabbitConfig.ROUTING_KEY,
                command
        );
    }
}
