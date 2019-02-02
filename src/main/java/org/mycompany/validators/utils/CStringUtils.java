package org.mycompany.validators.utils;

import org.apache.commons.validator.routines.EmailValidator;

public class CStringUtils {

    public static boolean isValidEmail(String email) {
        return EmailValidator.getInstance().isValid(email);
    }
}

