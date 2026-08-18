package br.com.fiap.fiapmovies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class FiapMoviesApplication {

    public static void main(String[] args) {
        SpringApplication.run(FiapMoviesApplication.class, args);
    }

}
