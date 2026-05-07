package fiap.com.br.cervejaria.dto;

import fiap.com.br.cervejaria.entity.Brewery;

public record BreweryRequest (
        String name,
        String country
) {
    public Brewery toEntity() {
        return Brewery.builder()
                .name(name)
                .country(country)
                .build();
    }
}
