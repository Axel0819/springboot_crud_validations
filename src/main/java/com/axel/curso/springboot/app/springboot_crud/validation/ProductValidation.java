package com.axel.curso.springboot.app.springboot_crud.validation;

import com.axel.curso.springboot.app.springboot_crud.entities.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null, "campo requerido");

        if (product.getDescription() == null || product.getDescription().isBlank()) {
            errors.rejectValue("description", null, "es requerido");
        }

        if (product.getPrice() == null) {
            errors.rejectValue("price", null, "no puede ser nulo");
        } else if (product.getPrice() < 500) {
            errors.rejectValue("price", null, "debe ser un valor numérico mayor o igual a 500");
        }
    }
}
