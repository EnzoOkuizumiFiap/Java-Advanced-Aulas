package fiap.com.br.cervejaria.controller;

import fiap.com.br.cervejaria.dto.BreweryRequest;
import fiap.com.br.cervejaria.dto.BreweryResponse;
import fiap.com.br.cervejaria.entity.Brewery;
import fiap.com.br.cervejaria.service.BreweryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/breweries")
@RequiredArgsConstructor
@Tag(name = "Brewery", description = "Endpoints para gerenciamento de cervejarias")
public class BreweryController {
    private final BreweryService breweryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Lista todas as cervejarias", description = "Retorna uma lista com todas as cervejarias cadastradas")
    public List<Brewery> getBreweries() {
        return breweryService.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca cervejaria por ID", description = "Retorna os detalhes de uma cervejaria específica")
    public BreweryResponse findById(@PathVariable Long id) {
        return BreweryResponse.fromEntity(breweryService.getBeerById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastra nova cervejaria", description = "Cria um novo registro de cervejaria no sistema")
    public BreweryResponse addBrewerey(@RequestBody Brewery brewery) {
        return BreweryResponse.fromEntity(breweryService.addBrewery(brewery));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualiza cervejaria", description = "Altera os dados de uma cervejaria existente")
    public BreweryResponse update(@PathVariable Long id, @RequestBody @Valid BreweryRequest breweryRequest) {
        return BreweryResponse.fromEntity(breweryService.updateBeer(id, breweryRequest));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Remove cervejaria", description = "Exclui uma cervejaria do sistema pelo ID")
    public void deleteBeer(@PathVariable Long id) {
        breweryService.deleteBeer(id);
    }
}
