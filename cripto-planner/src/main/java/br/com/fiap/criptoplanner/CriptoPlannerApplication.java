package br.com.fiap.criptoplanner;

import br.com.fiap.criptoplanner.coin.CoinService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.service.registry.ImportHttpServices;

@SpringBootApplication
@ImportHttpServices(CoinService.class)
public class CriptoPlannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CriptoPlannerApplication.class, args);
    }

}
