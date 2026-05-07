package fiap.com.br.cervejaria.dto;

import fiap.com.br.cervejaria.entity.Beer;
import fiap.com.br.cervejaria.entity.Brewery;

public record BreweryResponse (
        Long id,
        String name,
        String country
) {
    public static BreweryResponse fromEntity(Brewery brewery) {
        return new BreweryResponse(
                brewery.getId(),
                brewery.getName(),
                brewery.getCountry()
        );
    }
}
