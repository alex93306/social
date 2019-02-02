package org.mycompany.validators.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;

@Component
public class StringValidationImpl implements StringValidation {

    @Override
    public void rejectInvalidEmail(String email, String fieldName, Errors errors) {
        if (!CStringUtils.isValidEmail(email))
            errors.rejectValue("email", "invalid.email", fieldName);
    }

     
    public void rejectBlank(String value, String fieldName, Errors errors) {
        if (StringUtils.isBlank(value)) {
            errors.rejectValue(fieldName, "global.blank", new Object[]{fieldName}, null);
        }
    }

    @Override
    public void rejectMinLength(String value, long minLength, String fieldName, Errors errors) {
        Assert.isTrue(minLength > 0, "Min length cannot be less than 1"); //todo: investigate assert vs expection and message
        //todo: param null check
        if (StringUtils.length(value) < minLength)
        {
            errors.rejectValue(fieldName, "global.minLength");
        }
    }
}
