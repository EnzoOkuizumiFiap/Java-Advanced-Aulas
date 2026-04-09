package br.com.fiap.character.validation;

import br.com.fiap.character.dto.CharacterRequest;
import br.com.fiap.character.repository.CharacterRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CharacterValidator implements ConstraintValidator<CharacterValidation, CharacterRequest> {

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public boolean isValid(CharacterRequest characterRequest, ConstraintValidatorContext context) {
        boolean valid = true;
        String code = characterRequest.characterCode();

        if(characterRepository.existsByCharacterCode(code)) {
            valid = false;
            addViolation(context, "characterCode", "Esse código já existe!");
        }

        return valid;
    }

    private void addViolation(ConstraintValidatorContext context, String field, String message) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message)
                .addPropertyNode(field)
                .addConstraintViolation();
    }
}
