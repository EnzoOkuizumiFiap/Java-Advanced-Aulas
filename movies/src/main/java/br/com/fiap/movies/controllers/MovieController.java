package br.com.fiap.movies.controllers;

import br.com.fiap.movies.models.Movie;
import br.com.fiap.movies.services.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@Slf4j //Para escrever logs
@RequestMapping("movies")
public class MovieController { //Beans - Controller é um componente

    public record HealthStatus(String status, String message) {} //record é como uma classe imutável

    @Autowired //crie um objeto do service e entregue para o controller
    private MovieService service; //Injeção de dependência - IoC

    @GetMapping
    public List<Movie> listAll() {
        return service.getAllMovies();
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) { //binding
        //return service.addMovie(movie); Antigo

        //Novo com ResponseEntity
        return ResponseEntity
                .status(HttpStatus.CREATED) //.status(201) - Magic Number (RUIM)
                .body(service.addMovie(movie)); // adicionando filme
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        log.info("Obtendo dados do filme {}", id);

        return ResponseEntity
                .ok(service.getMovieById(id).orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                ));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        log.info("Deletando filme com id {}", id);
        service.deleteMovie(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        log.info("Atualizando Filme com id {} com os dados {}",  id, movie);

        return ResponseEntity.ok(service.updateMovie(id, movie));
    }

}
