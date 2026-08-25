package br.com.fiap.weatherplanner.log;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogService {
    private final LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public Log create(String activity, String result) {
        var log = Log.builder()
                .activity(activity)
                .result(result)
                .timestamp(LocalDateTime.now())
                .location("São Paulo")
                .build();

        return logRepository.save(log);
    }
}
