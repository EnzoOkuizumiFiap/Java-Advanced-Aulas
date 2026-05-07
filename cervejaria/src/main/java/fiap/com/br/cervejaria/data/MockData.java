package fiap.com.br.cervejaria.data;

import fiap.com.br.cervejaria.dto.BeerRequest;
import fiap.com.br.cervejaria.entity.Brewery;
import fiap.com.br.cervejaria.service.BeerService;
import fiap.com.br.cervejaria.service.BreweryService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MockData {

    private final BreweryService breweryService;
    private final BeerService beerService;

    @PostConstruct
    public void init() {
        // 1. Criar as Cervejarias
        Brewery serraAlta = Brewery.builder()
                .name("Serra Alta")
                .country("Brasil")
                .build();

        Brewery rioNegro = Brewery.builder()
                .name("Rio Negro")
                .country("Brasil")
                .build();

        Brewery valeVerde = Brewery.builder()
                .name("Vale Verde")
                .country("Brasil")
                .build();

        serraAlta = breweryService.addBrewery(serraAlta);
        rioNegro = breweryService.addBrewery(rioNegro);
        valeVerde = breweryService.addBrewery(valeVerde);

        // 2. Criar as Cervejas associadas às cervejarias

        // Cervejas da Serra Alta
        beerService.addBeer(new BeerRequest(
                "Primavera IPA",
                "IPA refrescante com notas cítricas",
                6.5,
                "Frango grelhado, queijos",
                serraAlta.getId()
        ));

        beerService.addBeer(new BeerRequest(
                "Serra Inverno",
                "Strong Ale encorpada",
                8.0,
                "Carnes vermelhas",
                serraAlta.getId()
        ));

        // Cervejas da Rio Negro
        beerService.addBeer(new BeerRequest(
                "Noite Stout",
                "Cerveja escura com notas de café",
                7.2,
                "Chocolate amargo, carne",
                rioNegro.getId()
        ));

        beerService.addBeer(new BeerRequest(
                "Rio Porter",
                "Suave com toque de malte torrado",
                5.5,
                "Sobremesas de baunilha",
                rioNegro.getId()
        ));

        // Cervejas da Vale Verde
        beerService.addBeer(new BeerRequest(
                "Lager do Sol",
                "Leve e ideal para dias quentes",
                4.8,
                "Petiscos, saladas leves",
                valeVerde.getId()
        ));

        beerService.addBeer(new BeerRequest(
                "Vale Weiss",
                "Cerveja de trigo clássica",
                5.2,
                "Comida alemã, salsichas",
                valeVerde.getId()
        ));
    }
}