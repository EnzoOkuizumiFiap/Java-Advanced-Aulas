package fiap.com.br.gamefinder.game;

import fiap.com.br.gamefinder.genre.Genre;
import fiap.com.br.gamefinder.plataform.Platform;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.core.Relation;

import java.time.LocalDate;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate releaseDate;
    private Double rating;

    @ManyToOne
    private Genre genre;

    @ManyToOne
    private Platform platform;

    private String coverUrl;
    private String backdropUrl;
    private boolean inWishlist;

    public EntityModel<Game> toEntityModel() {
        var linkAllGames = linkTo(methodOn(GameController.class).findAll(null, null)).withRel("all-games").withTitle("All games");
        var linkSelf = linkTo(methodOn(GameController.class).findById(id)).withSelfRel().withTitle("Games details");
        var linkGenre = linkTo(methodOn(GameController.class).findByGenreId(this.genre.getId())).withRel("same-genre").withTitle("Same Games");
        var linkPlataform = linkTo(methodOn(GameController.class).findByPlatformId(this.platform.getId())).withRel("same-platform").withTitle("Same Platform");

        return EntityModel.of(this, linkSelf, linkAllGames, linkGenre, linkPlataform);
    }

}