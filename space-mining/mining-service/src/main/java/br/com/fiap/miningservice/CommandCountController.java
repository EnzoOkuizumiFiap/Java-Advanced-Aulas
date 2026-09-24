package br.com.fiap.miningservice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/commands")
@RequiredArgsConstructor
public class CommandCountController {
    private final CommandCountRepository repository;

    @GetMapping
    public Map<String, Integer> getCommandCounts() {
        return repository.findAll().stream()
                .collect(Collectors.toMap(CommandCount::getCommand, CommandCount::getTotal));
    }

}
