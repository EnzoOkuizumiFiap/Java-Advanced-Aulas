package br.com.fiap.spy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SpyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpyApplication.class, args);
    }

}
