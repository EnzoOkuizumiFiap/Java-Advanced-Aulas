package br.com.fiap.miningservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
@RequiredArgsConstructor
public class CommandCountConsumer {
    private final CommandCountRepository repository;
    public static final String QUEUE_NAME = "command-queue";

    private final ConcurrentHashMap<String, Integer> commands = new ConcurrentHashMap<>();

    @RabbitListener(queues = QUEUE_NAME)
    public void consumeCommand(String command) {
        log.info("Executando comando no robô: {}", command);
        commands.merge(command, 1, Integer::sum);
    }

    @Scheduled(fixedDelay = 3_000)
    public void flush() {
        log.info("Flush dos comandos para o banco de dados");
        commands.forEach(this::persiste);
        commands.clear();
    }

    private void persiste(String command, Integer totalCommands) {
        var commandCount = repository.findById(command).orElseGet(
                () -> new CommandCount(command, 0)
        );

        commandCount.setTotal(commandCount.getTotal() + totalCommands);

        repository.save(commandCount);
    }

}
