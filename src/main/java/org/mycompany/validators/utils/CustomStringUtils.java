package org.mycompany.validators.utils;

import org.apache.commons.validator.routines.EmailValidator;

public class CustomStringUtils {
    public static boolean isValidEmail(String email) {
        return EmailValidator.getInstance().isValid(email);
    }
}
