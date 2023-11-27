package com.raunak.bus.Service;

import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidationException;

import java.util.Set;

@Service
public class ValidationService {

    private static LocalValidatorFactoryBean validator;

    public ValidationService(LocalValidatorFactoryBean validator) {
        ValidationService.validator = validator;
    }

    public static String validate(Object object) {
        Set<ConstraintViolation<Object>> violations = validator.validate(object);
        if (!violations.isEmpty()) {
            throw new ValidationException(buildErrorMessage(violations));
        }
        try {
			return buildErrorMessage(violations);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buildErrorMessage(violations);
    }

    private static String buildErrorMessage(Set<ConstraintViolation<Object>> violations) {
        StringBuilder errorMessage = new StringBuilder();
        for (ConstraintViolation<Object> violation : violations) {
            errorMessage.append(violation.getMessage())
                    .append("; ");
        }	
        return errorMessage.toString();
    }
}
