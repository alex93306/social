//package org.mycompany.validators;
//
//import org.apache.commons.lang3.EnumUtils;
//import org.apache.commons.lang3.CustomStringUtils;
//import org.mycompany.beans.Gender;
//import org.mycompany.beans.Profile;
//import org.mycompany.dto.ProfileUpdateDTO;
//import org.springframework.stereotype.Component;
//import org.springframework.util.Assert;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
//@Component
//public class ProfileUpdateDTOValidator implements Validator {
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return clazz.isAssignableFrom(ProfileUpdateDTO.class);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        ProfileUpdateDTO dto = (ProfileUpdateDTO) target;
//        ValidationUtils.rejectIfEmpty(errors, "firstName", "kdsfj", "atata");
//    }
//}
