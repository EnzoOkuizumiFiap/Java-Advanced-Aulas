package br.com.fiap.voteaggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VoteAggregatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoteAggregatorApplication.class, args);
    }

}
