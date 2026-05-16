package fiap.com.br.gamefinder.game;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public PagedModel<EntityModel<Game>> findAll(Pageable pageable, PagedResourcesAssembler<Game> assembler) {
        return assembler.toModel(gameService.findAll(pageable), Game::toEntityModel);
    }


    @GetMapping("/{id}")
    public EntityModel<Game> findById(@PathVariable Long id) {
        return gameService.findGameById(id).toEntityModel();
    }

    @GetMapping("/genre/{genreId}")
    public List<EntityModel<Game>> findByGenreId(@PathVariable Long genreId) {
        return gameService.findGameByGenreId(genreId)
                .stream()
                .map(Game::toEntityModel)
                .toList();
    }

    @GetMapping("/platform/{platformId}")
    public List<EntityModel<Game>> findByPlatformId(@PathVariable Long platformId) {
        return gameService.findGameByPlatformId(platformId)
                .stream()
                .map(Game::toEntityModel)
                .toList();
    }
}
