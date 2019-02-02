package org.mycompany.validators;

import org.mycompany.dto.AppUserDTO;
import org.mycompany.validators.utils.StringValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AppUserCreateValidator implements Validator {

    @Autowired private StringValidation stringValidation;

    @Override
    public boolean supports(Class<?> clazz) {
        return AppUserDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AppUserDTO appUser = (AppUserDTO) target;

        stringValidation.rejectBlank(appUser.getFirstName(), "firstName", errors);
        if (!errors.hasFieldErrors()) //todo: better condition
            stringValidation.rejectMinLength(appUser.getFirstName(), 2,"firstName", errors);

        stringValidation.rejectBlank(appUser.getLastName(), "lastName", errors);
        stringValidation.rejectMinLength(appUser.getLastName(), 2,"lastName", errors);
    }

}
