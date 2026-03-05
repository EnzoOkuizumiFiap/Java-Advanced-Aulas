package br.com.fiap.heroes.services;

import br.com.fiap.heroes.models.Hero;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class HeroService {

    private List<Hero>repository = new ArrayList<>();

    public List<Hero> getAllHeroes() {
        return repository;
    }

    public Hero addHero(Hero hero) {
        hero.setId(Math.abs(new Random().nextLong()));
        repository.add(hero);
        return hero;
    }

}
