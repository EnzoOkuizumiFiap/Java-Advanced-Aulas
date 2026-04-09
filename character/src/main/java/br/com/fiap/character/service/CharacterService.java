package br.com.fiap.character.service;

import br.com.fiap.character.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import br.com.fiap.character.entity.Character;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;

    public Character create(Character character) {
        return characterRepository.save(character);
    }

    public List<Character> findALl() {
        return characterRepository.findAll();
    }

}
