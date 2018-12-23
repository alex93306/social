package org.mycompany.validators;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.mycompany.dto.CreateChatDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.List;

@Component
public class CreateChatDTOValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(CreateChatDTO.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CreateChatDTO dto = (CreateChatDTO) target;
        ValidationUtils.rejectIfEmpty(errors, "title", "Tile", "Title is empty");
        validateMembers(dto, errors);
    }

    private void validateMembers(CreateChatDTO dto, Errors errors) {
//        List<Long> membersIDs = (List<Long>) errors.getFieldValue("membersIDs");
        List<Long> membersIDs = dto.getMembersIDs();
        if (membersIDs == null || membersIDs.isEmpty()) {
            errors.rejectValue("membersIDs", "", "Member list is empty");
        } else {
            for (Long userID : membersIDs) {
//                if(friendManager.isFriend(userID)) {
                if(true) {
                    errors.rejectValue("membersIDs", "", new Object[]{userID}, "User with id = ? isn't friend.");
                }
            }
        }

    }
}
