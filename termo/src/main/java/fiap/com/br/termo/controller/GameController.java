package fiap.com.br.termo.controller;

import fiap.com.br.termo.entity.Game;
import fiap.com.br.termo.entity.Player;
import fiap.com.br.termo.entity.Word;
import fiap.com.br.termo.service.GameService;
import fiap.com.br.termo.service.PlayerService;
import fiap.com.br.termo.service.WordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {

    private final WordService wordService;
    private final GameService gameService;
    private final PlayerService playerService;

    public record GameStartRequest(Long playerId) {}
    public record GuessRequest(String word) {}
    public record GuessReponse() {}

    @PostMapping("/start")
    @Operation(
            summary = "Start a new Game",
            //hidden = true, Esconder endpoint
            //deprecated = true, Dizer que endpoint vai ser descontinuado
            description = "Start a new game, recive a Player ID and return the game with the word of the day and the player information",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Sucess"),
                    @ApiResponse(responseCode = "404", description = "Player not found")
            }
    )
    public Game startGame(@RequestBody GameStartRequest gameStartRequest) {
        // buscar o player
        Player player = playerService.getPlayerById(gameStartRequest.playerId());

        // buscar a palavra do dia
        Word word = wordService.getWordOfToday();

        // inserir o game no Banco de Dados
        var game = Game.builder()
                .word(word)
                .player(player)
                .build();

        return gameService.addGame(game);
    }



}
