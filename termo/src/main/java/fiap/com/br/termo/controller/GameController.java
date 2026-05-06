package fiap.com.br.termo.controller;

import fiap.com.br.termo.entity.Game;
import fiap.com.br.termo.entity.Player;
import fiap.com.br.termo.entity.Word;
import fiap.com.br.termo.repository.GameRepository;
import fiap.com.br.termo.service.GameService;
import fiap.com.br.termo.service.PlayerService;
import fiap.com.br.termo.service.WordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {
    private final WordService wordService;
    private final PlayerService playerService;
    private final GameService gameService;
    private final GameRepository gameRepository;

    // DTOs
    public record GameStartRequest(Long playerId) {}
    public record GuessRequest(String word) {}
    public record GuessResponse(String feedback, boolean won, int attempts) {}

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

    @PostMapping("/{id}/guess")
    public ResponseEntity<GuessResponse> makeGuess(@PathVariable Long id, @RequestBody GuessRequest request) {
        Game game = gameRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found"));

        if (game.isWon()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Game already won");
        }

        game.setAttempts(game.getAttempts() + 1);

        String feedback = generateFeedback(request.word(), game.getWord().getWord());

        if (request.word().equalsIgnoreCase(game.getWord().getWord())) {
            game.setWon(true);
        }

        gameRepository.save(game);
        return ResponseEntity.ok(new GuessResponse(feedback, game.isWon(), game.getAttempts()));
    }

    private String generateFeedback(String guess, String word) {

        if (guess.length() != word.length()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Guess lengths do not match");
        }

        StringBuilder feedback = new StringBuilder();
        guess = guess.toUpperCase();
        word = word.toUpperCase();

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == word.charAt(i)) {
                feedback.append("V"); // verde
                continue;
            }
            if (word.contains(String.valueOf(guess.charAt(i)))) {
                feedback.append("A"); // amarelo
                continue;
            }
            feedback.append("C"); // cinza
        }

        return feedback.toString();
    }

}
