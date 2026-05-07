package fiap.com.br.cervejaria.dto;

import fiap.com.br.cervejaria.entity.Beer;
import fiap.com.br.cervejaria.entity.Brewery;

public record BeerResponse (
        Long id,
        String name,
        String description,
        Double alcoholContent,
        String harmonization,
        Brewery brewery
) {
    public static BeerResponse fromEntity(Beer beer) {
        return  new BeerResponse(
                beer.getId(),
                beer.getName(),
                beer.getDescription(),
                beer.getAlcoholContent(),
                beer.getHarmonization(),
                beer.getBrewery()
        );
    }
}
