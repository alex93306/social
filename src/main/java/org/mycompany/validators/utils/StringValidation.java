package org.mycompany.validators.utils;

import org.springframework.validation.Errors;

public interface StringValidation {
    void rejectInvalidEmail(String email, String fieldName, Errors errors);
    void rejectBlank(String value, String fieldName, Errors errors);

    void rejectMinLength(String value, long minLength, String fieldName, Errors errors);
}
