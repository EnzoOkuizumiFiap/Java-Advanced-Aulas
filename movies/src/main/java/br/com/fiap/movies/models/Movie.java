package br.com.fiap.movies.models;

import lombok.*;

import java.time.LocalDate;

//@Getter
//@Setter
//@EqualsAndHashCode
//Tudo isso se transforma em Data
@Data
@AllArgsConstructor
public class Movie {
    private String title;
    private int rating;
    private String synopsis;
    private LocalDate releaseDate;
    private String duration;
    private String genre;

}
