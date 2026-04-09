package br.com.fiap.character.dto;

import br.com.fiap.character.entity.Character;

import java.time.LocalDate;

public record CharacterResponse(
        String name,
        String email,
        Integer age,
        String className,
        Integer level,
        double hp,
        LocalDate createdAt,
        String characterCode
) {
    public static CharacterResponse fromEntity(Character character) {
        return new CharacterResponse(
                character.getName(),
                character.getEmail(),
                character.getAge(),
                character.getClassName(),
                character.getLevel(),
                character.getHp(),
                character.getCreatedAt(),
                character.getCharacterCode()
        );
    }
}
