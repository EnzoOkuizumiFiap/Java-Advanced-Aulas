package br.com.fiap.ecommerce.dto;

import br.com.fiap.ecommerce.entity.User;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

//Classe imutável
public record UserRequest(
        @NotBlank
        String name,

        @CPF
        String cpf,

        @Email
        String email,

        @Size(min = 8, message = "A senha deve ter pelo 8 caracteres") // AVISO: i18n
        String password,

        @Past
        LocalDate birthDate,

        @Min(1) @Max(5)
        Integer rating
) {
    public User toEntity() {
        return User.builder()
                .name(name)
                .cpf(cpf)
                .email(email)
                .password(password)
                .birthDate(birthDate)
                .rating(rating)
                .build();
    }
}
