package br.com.fiap.votinggateway;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String EXCHANGE_NAME = "voting-exchange"; // Exchange: recebe e encaminha as mensagens de votação.
    public static final String QUEUE_NAME = "voting-queue"; // Queue: armazena as mensagens até que um consumidor processe.
    public static final String ROUTING_KEY = "voting-key"; // Routing Key: identifica como a mensagem será roteada da Exchange para a Queue.

    // Queue (Fila) que irá armazenar as mensagens de votação. (Cuidado com Collection Queue, pois É DIFERENTE o que usamos)
    @Bean
    public Queue votingQueue() {
        return new Queue(QUEUE_NAME, true); // 1° Parâmetro: Nome da Fila, 2° Parâmtro: Se essa fila é durável, ou seja, persiste a fila!
    }

    // Exchange (Central de Triagem) que irá receber as mensagens enviadas pelo produtor.
    @Bean
    public TopicExchange votingExchange() {
        return new TopicExchange(EXCHANGE_NAME); // Nome da Exchange
    }

    // Cria o Binding, que estabelece a ligação entre a Queue e a Exchange.
    // Routing Key definida aqui será utilizada pela Exchange para encaminhar as mensagens para a Queue.
    @Bean
    public Binding votingBinding() {
        return BindingBuilder
                .bind(votingQueue()) // Define qual Queue receberá as mensagens.
                .to(votingExchange()) // Define em qual Exchange a Queue (Fila) será conectada.
                .with(ROUTING_KEY); // Define a Routing Key utilizada para realizar o roteamento.
    }

    /*
            PRODUTOR (VoteController)
               │
               │ envia mensagem
               │ routingKey = "voting-key"
               ▼
    ┌────────────────────┐
    │  voting-exchange   │
    │      Exchange      │
    └──────────┬─────────┘
               │
               │ verifica o Binding
               │ "voting-key"
               ▼
    ┌────────────────────┐
    │    voting-queue    │
    │       Queue        │
    └──────────┬─────────┘
               │
               │ mensagem fica armazenada
               │ até ser consumida
               ▼
            CONSUMIDOR
    */

}
