package br.com.fiap.character.repository;

import br.com.fiap.character.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, String> {
    boolean existsByCharacterCode(String characterCode);
}
