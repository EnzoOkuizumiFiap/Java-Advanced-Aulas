package br.com.fiap.movies.repositories;

import br.com.fiap.movies.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    //CRUD - ANTIGO, usamos JpaRepository - ele tem todos os métodos CRUD
    //public Movie createMovie(Movie movie);
    //public void deleteById(Long id);
}
