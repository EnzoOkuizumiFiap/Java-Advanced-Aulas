package fiap.com.br.termo.service;

import fiap.com.br.termo.entity.Player;
import fiap.com.br.termo.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player getPlayerById(Long playerId) {
        return playerRepository.findById(playerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Player not found with id: " + playerId));
    }

}
