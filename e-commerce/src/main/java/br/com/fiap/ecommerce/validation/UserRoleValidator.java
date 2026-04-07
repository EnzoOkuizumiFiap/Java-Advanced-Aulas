package br.com.fiap.ecommerce.validation;

import br.com.fiap.ecommerce.dto.UserRequest;
import br.com.fiap.ecommerce.entity.Role;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserRoleValidator implements ConstraintValidator<UserRoleValidation, UserRequest> {

    @Override
    public boolean isValid(UserRequest userRequest, ConstraintValidatorContext context) {
        var valid = true;

        if(userRequest.role() == Role.CLIENT && !fieldIsValid(userRequest.cpf())) {
                valid = false;
                addViolation(context, "cpf", "CPF é obrigatório para clientes");
        }

        if(userRequest.role() == Role.SUPPLIER && !fieldIsValid(userRequest.cnpj())) {
                valid = false;
                addViolation(context, "cnpj", "CNPJ é obrigatório para fornecedores");
        }

        return valid;
    }

    private boolean fieldIsValid(String value) {
        return value != null && !value.isBlank();
    }

    private void addViolation(ConstraintValidatorContext context, String field, String message) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message)
                .addPropertyNode(field)
                .addConstraintViolation();
    }
}
