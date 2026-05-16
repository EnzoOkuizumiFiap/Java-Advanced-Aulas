package fiap.com.br.gamefinder.game;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByGenreId(Long genreId);

    List<Game> findByPlatformId(Long platformId);
}

