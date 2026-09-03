package br.com.fiap.boardvault.boardgame;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boardgames")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class BoardGameController {
    private final BoardGameRepository gameRepository;

    @GetMapping
    public List<BoardGame> getAll() {
        return gameRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardGame> getOne(@PathVariable Long id) {
        return ResponseEntity.of(gameRepository.findById(id));
    }

}
