package br.com.fiap.ecommerce.dto;

import br.com.fiap.ecommerce.entity.User;

import java.time.LocalDate;

public record UserResponse(
        Long id,
        String name,
        String cpf,
        String email,
        LocalDate birthDate,
        Integer rating
) {

    public static UserResponse fromEntity(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getCpf(),
                user.getEmail(),
                user.getBirthDate(),
                user.getRating()
        );
    }
}
