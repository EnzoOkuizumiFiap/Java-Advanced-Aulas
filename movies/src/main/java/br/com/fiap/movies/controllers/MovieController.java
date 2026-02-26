package br.com.fiap.movies.controllers;

import br.com.fiap.movies.models.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j //Para escrever logs
public class MovieController { //Beans - Controller é um componente

    public record HealthStatus(String status, String message) {} //record é como uma classe imutável

    @GetMapping("/") //REST
    //@ResponseBody //Para indicar que a resposta não é uma página web, mas sim um texto - como colocamos RestController, não precisamos de ResponseBody
    public HealthStatus healthCheck() {
        return new HealthStatus("OK", "API is Running");
    }

    //Jackson vai converter o objeto Movie para JSON automaticamente
    @GetMapping("/movies") //Para fazer get
    public List<Movie> listAll() {
        return List.of( new Movie(
                "Titanic",
                5,
                "Todos morrem no final",
                LocalDate.of(1997, 12, 1),
                "2h30",
                "Romance"
        ));
    }

    @PostMapping("/movies")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Movie createMovie(@RequestBody Movie movie) { //biding - converter o JSON para objeto
        log.info("Cadastrando Filme... " + movie);
        return movie;
    }

}
