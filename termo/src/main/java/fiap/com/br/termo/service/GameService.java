package fiap.com.br.termo.service;

import fiap.com.br.termo.entity.Game;
import fiap.com.br.termo.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    public Game addGame(Game game) {
        return gameRepository.save(game);
    }

}
