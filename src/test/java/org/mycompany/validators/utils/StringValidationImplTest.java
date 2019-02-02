package org.mycompany.validators.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mycompany.beans.AppUser;
import org.springframework.validation.*;

import java.util.Objects;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class StringValidationImplTest {

    private StringValidation stringValidation = new StringValidationImpl();
//    @Test
//    public void testRejectBlank_emptyValue() {
//        Errors errors = new BeanPropertyBindingResult();
//
//        // Method call
//        stringValidation.rejectBlank("", "testField", errors);
//
//        // Assert
//        assertEquals("testField is blank.", errors.getFieldError("testField").get
//    }

    @Test
    public void testRejectInvalidEmail()
    {
        Errors errors = new DirectFieldBindingResult(new AppUser(), "objName"); //todo: investigate param

        // Method call
        stringValidation.rejectInvalidEmail("testValidEmail@gmail.com", "firstName", errors);

        assertFalse(errors.hasFieldErrors("firstName"));
    }

    @Test
    public void testRejectInvalidEmail2()
    {
        Errors errors = new DirectFieldBindingResult(new AppUser(), "objName"); //todo: investigate param

        // Method call
        stringValidation.rejectInvalidEmail("testValidEmail@gmail.com", "firstName", errors);

        stringValidation.rejectInvalidEmail("joe1blow@apache.org", "firstName", errors);

        stringValidation.rejectInvalidEmail("joe$blow@apache.org", "firstName", errors);

        stringValidation.rejectInvalidEmail("joe-@apache.org", "firstName", errors);

        stringValidation.rejectInvalidEmail("joe_@apache.org", "firstName", errors);

        assertFalse(errors.hasFieldErrors("firstName"));
    }

    @Test
    public void testRejectBlank_notBlank() {
        Errors errors = new DirectFieldBindingResult(new AppUser(), "objName"); //todo: investigate param

        // Method call
        stringValidation.rejectBlank("testStringValue", "firstName", errors);

        // Assert
        assertFalse(errors.hasFieldErrors("firstName"));
    }


    @Test
    public void testRejectBlank_null() {
        Errors errors = new DirectFieldBindingResult(new AppUser(), "objName"); //todo: investigate param

        // Method call
        stringValidation.rejectBlank(null, "firstName", errors);

        // Assert
        assertEquals("global.blank", errors.getFieldError("firstName").getCode());
    }

    @Test
    public void testRejectBlank_emptyString() {
        Errors errors = new DirectFieldBindingResult(new AppUser(), "objName"); //todo: investigate param

        // Method call
        stringValidation.rejectBlank("", "firstName", errors);

        // Assert
        assertEquals("global.blank", errors.getFieldError("firstName").getCode());
    }

    @Test
    public void testRejectMinLength_lessThanMinLength() {
        String value = "al"; //todo: random string
        Errors errors = new DirectFieldBindingResult(new AppUser(), "objName"); //todo: investigate param
        // Method call
        stringValidation.rejectMinLength(value, 3, "firstName", errors); // todo: field

        // Assert
        assertEquals("global.minLength", errors.getFieldError("firstName").getCode()); //todo: NPE
    }

    @Test
    public void testRejectMinLength_equalMinLength() {
        String value = "ale"; //todo: random string
        Errors errors = new DirectFieldBindingResult(new AppUser(), "objName"); //todo: investigate param
        // Method call
        stringValidation.rejectMinLength(value, 3, "firstName", errors); // todo: field

        // Assert
        assertFalse(errors.hasFieldErrors("firstName"));
    }

    @Test
    public void testRejectMinLength_moreThanMinLength() {
        String value = "ale34"; //todo: random string
        Errors errors = new DirectFieldBindingResult(new AppUser(), "objName"); //todo: investigate param
        // Method call
        stringValidation.rejectMinLength(value, 3, "firstName", errors); // todo: field

        // Assert
        assertFalse(errors.hasFieldErrors("firstName"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRejectMinLength_minLengthIsZero_excetion() {
        String value = "ale34"; //todo: random string
        Errors errors = new DirectFieldBindingResult(new AppUser(), "objName"); //todo: investigate param
        // Method call
        stringValidation.rejectMinLength(value, 0, "firstName", errors); // todo: field
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRejectMinLength_minLengthIsNegative_excetion() {
        String value = "ale34"; //todo: random string
        Errors errors = new DirectFieldBindingResult(new AppUser(), "objName"); //todo: investigate param
        // Method call
        stringValidation.rejectMinLength(value, 0, "firstName", errors); // todo: field
    }

    //todo: investigate param values what if value null or empty, what if minLenth is negative, fieldname is null ....
}