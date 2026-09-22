package br.com.fiap.votinggateway;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VoteController {

    private final RabbitTemplate rabbitTemplate;

    @PostMapping("/vote/{participanteId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void vote(@PathVariable String participanteId) {
        // Envia a mensagem para o RabbitMQ - convertAndSend() serializa o Objeto para um formato que possa ser enviado pela rede e publica a mensagem na Exchange.
        rabbitTemplate.convertAndSend(
                RabbitConfig.EXCHANGE_NAME, // 1° Parâmetro: Exchange que receberá a mensagem.
                RabbitConfig.ROUTING_KEY, // 2° Parâmetro: Routing Key usada pela Exchange para realizar o roteamento.
                participanteId // 3° Parâmetro: Conteúdo da mensagem, Objeto que será mandando.
        );
    }
}
