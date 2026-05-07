package fiap.com.br.cervejaria.service;

import fiap.com.br.cervejaria.dto.BeerRequest;
import fiap.com.br.cervejaria.entity.Beer;
import fiap.com.br.cervejaria.entity.Brewery;
import fiap.com.br.cervejaria.repository.BeerRepository;
import fiap.com.br.cervejaria.repository.BreweryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BeerService {
    private final BeerRepository beerRepository;
    private final BreweryRepository breweryRepository;

    @Cacheable("beers")
    public List<Beer> findAll() {
        return beerRepository.findAll();
    }

    public Beer findById(Long id) {
        return findBeerById(id);
    }

    @Cacheable(value = "beers")
    public List<Beer> findByBreweryId(Long breweryId) {
        return beerRepository.findByBreweryId(breweryId);
    }

    @CacheEvict(value = "beers", allEntries = true)
    public Beer addBeer(BeerRequest beerRequest) {
        Brewery breweryFound = findBreweryId(beerRequest.breweryId());
        return beerRepository.save(beerRequest.toEntity(breweryFound));
    }

    @CacheEvict(value = "beers", allEntries = true)
    public Beer updateBeer(Long id, BeerRequest beerRequest) {
        findBeerById(id);
        Brewery breweryFound = findBreweryId(beerRequest.breweryId());
        Beer beer = beerRequest.toEntity(breweryFound);
        beer.setId(id);
        return beerRepository.save(beer);
    }

    public void deleteBeer(Long id) {
        findBeerById(id);
        beerRepository.deleteById(id);
    }

    private Beer findBeerById(Long id) {
        return beerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cerveja com id " + id + " não encontrado." ));
    }

    private Brewery findBreweryId(Long breweryId) {
        return breweryRepository.findById(breweryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Brewery com id " + breweryId + " não encontrado"));
    }
}
