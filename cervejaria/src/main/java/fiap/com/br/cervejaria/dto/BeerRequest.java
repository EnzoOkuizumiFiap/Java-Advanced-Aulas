package fiap.com.br.cervejaria.dto;

import fiap.com.br.cervejaria.entity.Beer;
import fiap.com.br.cervejaria.entity.Brewery;

public record BeerRequest(
        String name,
        String description,
        Double alcoholContent,
        String harmonization,
        Long breweryId

) {
    public Beer toEntity(Brewery brewery) {
        return Beer.builder()
                .name(name)
                .description(description)
                .alcoholContent(alcoholContent)
                .harmonization(harmonization)
                .brewery(brewery)
                .build();
    }
}
