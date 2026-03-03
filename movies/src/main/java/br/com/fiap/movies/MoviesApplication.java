package br.com.fiap.movies;

import br.com.fiap.movies.controllers.MovieController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	@GetMapping("/") //REST
	//@ResponseBody //Para indicar que a resposta não é uma página web, mas sim um texto - como colocamos RestController, não precisamos de ResponseBody
	public MovieController.HealthStatus healthCheck() {
		return new MovieController.HealthStatus("OK", "API is Running");
	}

}
