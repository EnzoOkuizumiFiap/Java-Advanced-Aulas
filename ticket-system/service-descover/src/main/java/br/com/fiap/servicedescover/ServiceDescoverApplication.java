package br.com.fiap.servicedescover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceDescoverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDescoverApplication.class, args);
    }

}
