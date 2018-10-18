package org.mycompany.validators;

import org.mycompany.beans.ApplicationUser;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ApplicationUserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return ApplicationUser.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "firstName", "name.empty");
    }
}
