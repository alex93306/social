package org.mycompany.validators;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.mycompany.beans.AppUser;
import org.mycompany.validators.utils.StringValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AppUserValidator implements Validator {
//    String invalid.email = "Please input correct email";
//    String global.blank = "{} is blank.";
    @Autowired private StringValidation stringValidation;

    @Override
    public boolean supports(Class<?> clazz) {
        return AppUser.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AppUser appUser = (AppUser) target;

        stringValidation.rejectBlank(appUser.getFirstName(), "First Name", errors);
        stringValidation.rejectMinLength(appUser.getFirstName(), 2,"firstName", errors);
        stringValidation.rejectInvalidEmail(appUser.getEmail(), errors);
    }

}
