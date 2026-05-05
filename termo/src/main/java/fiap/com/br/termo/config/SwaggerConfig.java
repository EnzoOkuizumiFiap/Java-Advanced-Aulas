package fiap.com.br.termo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Termo API",
                description = "API do Jogo Termo",
                version = "1.0"
        )
)
public class SwaggerConfig {

}
