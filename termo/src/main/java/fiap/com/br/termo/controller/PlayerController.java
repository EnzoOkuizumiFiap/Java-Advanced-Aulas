package fiap.com.br.termo.controller;

import fiap.com.br.termo.entity.Player;
import fiap.com.br.termo.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    public record PlayerRequest(String name){}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Player createPlayer(@RequestBody PlayerRequest playerRequest) {
        return playerService.addPlayer(Player.builder()
                .name(playerRequest.name)
                .build()
        );
    }

}
