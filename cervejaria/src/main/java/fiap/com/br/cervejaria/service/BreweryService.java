package fiap.com.br.cervejaria.service;

import fiap.com.br.cervejaria.dto.BreweryRequest;
import fiap.com.br.cervejaria.entity.Brewery;
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
public class BreweryService {
    private final BreweryRepository breweryRepository;

    @Cacheable("breweries")
    public List<Brewery> findAll() {
        return breweryRepository.findAll();
    }

    @Cacheable(value = "breweries")
    public Brewery getBeerById(Long id) {
        return findBreweryById(id);
    }

    @CacheEvict(value = "breweries", allEntries = true)
    public Brewery addBrewery(Brewery brewery) {
        return breweryRepository.save(brewery);
    }

    @CacheEvict(value = "breweries", allEntries = true)
    public Brewery updateBeer(Long id, BreweryRequest breweryRequest) {
        findBreweryById(id);
        Brewery brewery = breweryRequest.toEntity();
        brewery.setId(id);
        return breweryRepository.save(brewery);
    }

    public void deleteBeer(Long id) {
        findBreweryById(id);
        breweryRepository.deleteById(id);
    }

    private Brewery findBreweryById(Long id) {
        return breweryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cervejaria com id " + id + " não encontrado." ));
    }
}
