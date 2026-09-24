package br.com.fiap.validatorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.resilience.annotation.EnableResilientMethods;

@SpringBootApplication
@EnableDiscoveryClient
@EnableResilientMethods
public class ValidatorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidatorServiceApplication.class, args);
    }

}
