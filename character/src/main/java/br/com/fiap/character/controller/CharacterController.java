package br.com.fiap.character.controller;

import br.com.fiap.character.dto.CharacterRequest;
import br.com.fiap.character.dto.CharacterResponse;
import br.com.fiap.character.entity.Character;
import br.com.fiap.character.service.CharacterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping
    public List<CharacterResponse> findAll() {
        return characterService.findALl()
                .stream()
                .map(CharacterResponse::fromEntity)
                .toList();
    }

    @PostMapping
    public Character create(@RequestBody @Valid CharacterRequest characterRequest) {
        return characterService.create(characterRequest.toEntity());
    }
}
