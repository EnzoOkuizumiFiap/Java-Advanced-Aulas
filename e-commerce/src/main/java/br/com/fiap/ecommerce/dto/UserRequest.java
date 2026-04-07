package br.com.fiap.ecommerce.dto;

import br.com.fiap.ecommerce.entity.Role;
import br.com.fiap.ecommerce.entity.User;
import br.com.fiap.ecommerce.validation.Adult;
import br.com.fiap.ecommerce.validation.UserRoleValidation;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

//Classe imutável
@UserRoleValidation
public record UserRequest(
        @NotBlank
        String name,

        @CPF
        String cpf,

        @CNPJ
        String cnpj,

        @Email
        String email,

        @Size(min = 8, message = "A senha deve ter pelo 8 caracteres") // AVISO: i18n
        String password,

        @Adult
        LocalDate birthDate,

        @Min(1) @Max(5)
        Integer rating,

        @NotNull
        Role role
) {
    public User toEntity() {
        return User.builder()
                .name(name)
                .cpf(cpf)
                .cnpj(cnpj)
                .email(email)
                .password(password)
                .birthDate(birthDate)
                .rating(rating)
                .role(role)
                .build();
    }
}
