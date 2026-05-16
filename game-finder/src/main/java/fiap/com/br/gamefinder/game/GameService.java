package fiap.com.br.gamefinder.game;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    public Page<Game> findAll(Pageable pageable) {
        return gameRepository.findAll(pageable);
    }

    public Game findGameById(Long id){
        return gameRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo não encontrado")
        );
    }

    public List<Game> findGameByGenreId(Long genreId){
        return gameRepository.findByGenreId(genreId);
    }

    public List<Game> findGameByPlatformId(Long platformId){
        return gameRepository.findByPlatformId(platformId);
    }
}
