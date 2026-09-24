package br.com.fiap.validatorservice;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String EXCHANGE_NAME = "command-exchange";
    public static final String QUEUE_NAME = "command-queue";
    public static final String ROUTING_KEY = "command-key";

    @Bean
    public Queue commandQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public TopicExchange commandExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding commandBinding() {
        return BindingBuilder
                .bind(commandQueue())
                .to(commandExchange())
                .with(ROUTING_KEY);
    }
}