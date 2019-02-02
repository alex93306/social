package org.mycompany.validators.utils;

import org.apache.commons.validator.routines.EmailValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmailValidator.class)
public class CStringUtilsTest {
    @Mock
    private EmailValidator emailValidator;

    @Test
    public void testIsValidEmail_blankString() {

        PowerMockito.mockStatic(EmailValidator.class);
        when(EmailValidator.getInstance()).thenReturn(emailValidator);

        CStringUtils.isValidEmail("test@test.com");

        verify(emailValidator).isValid("test@test.com");
    }

}