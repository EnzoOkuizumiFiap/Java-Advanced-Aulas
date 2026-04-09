package br.com.fiap.character.dto;
import br.com.fiap.character.entity.Character;

import br.com.fiap.character.validation.CharacterValidation;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@CharacterValidation
public record CharacterRequest(
        @NotBlank
        @Size(min = 3, max = 50)
        String name,

        @Email
        String email,

        @Min(12) @Max(120)
        @NotNull
        Integer age,

        @NotBlank
        @Pattern(regexp = "^(?i)(Warrior|Mage|Rogue|Paladin|Archer)$", message = "Você está inserindo uma classe INVÁLIDA!")
        String className,

        @Min(1) @Max(100)
        @NotNull
        Integer level,

        @Min(value = 0, message = "Digite corretamente o HP, digite em formato Decimal, ex: 10.50")
        @NotNull
        double hp,

        @PastOrPresent
        @NotNull
        LocalDate createdAt,

        @Pattern(regexp = "^[A-Z]{4}-\\d{4}$", message = "O formato deve ser CHAR-1234")
        String characterCode
) {
    public Character toEntity() {
        return Character.builder()
                .name(name)
                .email(email)
                .age(age)
                .className(className)
                .level(level)
                .hp(hp)
                .createdAt(createdAt)
                .characterCode(characterCode)
                .build();
    }
}
