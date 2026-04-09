package br.com.fiap.character.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = CharacterValidator.class)
public @interface CharacterValidation {
    String message() default "Verifique os campos e corrija o erro!!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
}
