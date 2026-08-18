package br.com.fiap.fiapmovies.domain.movies;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieRepository movieRepository;

    @GetMapping
    public List<Movie> listAll(){
        return movieRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')") // Só consegue fazer requisição POST se Role for ADMIN (Outra forma de Fazer)
    public Movie save(@RequestBody @Valid Movie movie) {
        return movieRepository.save(movie);
    }

}