package br.com.fiap.weatherplanner;

import br.com.fiap.weatherplanner.weather.WeatherService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.service.registry.ImportHttpServices;

@SpringBootApplication
@ImportHttpServices(WeatherService.class)
public class WeatherPlannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherPlannerApplication.class, args);
    }

}
