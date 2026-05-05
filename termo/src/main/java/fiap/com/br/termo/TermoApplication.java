package fiap.com.br.termo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TermoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TermoApplication.class, args);
    }

}
