package fiap.com.br.cervejaria.controller;

import fiap.com.br.cervejaria.dto.BeerRequest;
import fiap.com.br.cervejaria.dto.BeerResponse;
import fiap.com.br.cervejaria.entity.Beer;
import fiap.com.br.cervejaria.service.BeerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beers")
@RequiredArgsConstructor
@Tag(name = "Beer", description = "Endpoints para gerenciamento de cervejas")
public class BeerController {
    private final BeerService beerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Lista todas as cervejas", description = "Retorna uma lista de todas as cervejas disponíveis")
    public List<Beer> getAll() {
        return beerService.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca cerveja por ID", description = "Retorna os detalhes de uma cerveja específica")
    public BeerResponse findById(@PathVariable Long id) {
        return BeerResponse.fromEntity(beerService.findById(id));
    }

    @GetMapping("brewery/{id}")
    @Operation(summary = "Lista cervejas por cervejaria", description = "Retorna todas as cervejas associadas a uma cervejaria específica")
    public List<Beer> getByBrewery(@PathVariable Long id) {
        return beerService.findByBreweryId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastra nova cerveja", description = "Cria um novo registro de cerveja no sistema")
    public BeerResponse addBeer(@RequestBody BeerRequest beerRequest) {
        return BeerResponse.fromEntity(beerService.addBeer(beerRequest));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualiza cerveja", description = "Altera os dados de uma cerveja existente")
    public BeerResponse update(@PathVariable Long id, @RequestBody @Valid BeerRequest beerRequest) {
        return BeerResponse.fromEntity(beerService.updateBeer(id, beerRequest));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Remove cerveja", description = "Exclui uma cerveja do sistema pelo ID")
    public void deleteBeer(@PathVariable Long id) {
        beerService.deleteBeer(id);
    }
}
