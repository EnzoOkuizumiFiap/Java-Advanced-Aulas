package br.com.fiap.movies.services;

import br.com.fiap.movies.models.Movie;
import br.com.fiap.movies.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    //private List<Movie> repository = new ArrayList<>(); - Antigo / Usando uma List para armazenar os dados

    public List<Movie> getAllMovies() {
        return repository.findAll();
    }

    public Movie addMovie(Movie movie) {
        return repository.save(movie);
    }

    public Movie getMovieById(Long id) {
        return findMovieById(id);
    }

    public void deleteMovie(Long id) {
        findMovieById(id);
        repository.deleteById(id);
    }

    public Movie updateMovie(Long id, Movie newMovie) {
        findMovieById(id);
        //BeanUtils.copyProperties(newMovie, movie, "id"); -> pega o newMovie, joga para o movie e ignora o id
        newMovie.setId(id);
        return repository.save(newMovie);
    }

    private Movie findMovieById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme com id " + id + " não encontrado")
        );
    }
}
