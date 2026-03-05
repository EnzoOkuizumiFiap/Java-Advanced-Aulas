package br.com.fiap.heroes.controllers;

import br.com.fiap.heroes.models.Hero;
import br.com.fiap.heroes.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("heroes")
public class HeroControllers {

    @Autowired
    private HeroService service;

    @GetMapping
    public List<Hero> listALl() {
        return service.getAllHeroes();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Hero createHero(@RequestBody Hero hero) {
        return service.addHero(hero);
    }

}
