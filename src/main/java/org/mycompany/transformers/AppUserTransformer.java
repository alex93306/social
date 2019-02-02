package org.mycompany.transformers;


import org.mycompany.beans.AppUser;
import org.mycompany.beans.Gender;
import org.mycompany.dto.AppUserDTO;
import org.mycompany.dto.AppUserResponseDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AppUserTransformer implements DTOTransformer<AppUser, AppUserDTO, AppUserResponseDTO> {
    @Override
    public AppUserResponseDTO populateDTO(AppUser appUser) {
        AppUserResponseDTO appUserResponseDTO = new AppUserResponseDTO();
        appUserResponseDTO.setFirstName(appUser.getFirstName());
        appUserResponseDTO.setLastName(appUser.getLastName());
        appUserResponseDTO.setEmail(appUser.getEmail());
        appUserResponseDTO.setGender(String.valueOf(appUser.getGender()));
        appUserResponseDTO.setBirthDate(appUser.getBirthDate().toString()); //todo: check format
//        appUserResponseDTO.setPassword(); //todo: I'm not sure

        return appUserResponseDTO;
    }

    @Override
    public AppUser populateEntity(AppUserDTO dto) {
        AppUser appUser = new AppUser();
        appUser.setFirstName(dto.getFirstName());
        appUser.setLastName(dto.getLastName());
        appUser.setEmail(dto.getEmail());
        appUser.setPassword(dto.getPassword());
        appUser.setGender(Gender.valueOf(dto.getGender()));
        appUser.setBirthDate(LocalDate.parse(dto.getBirthDate()));

        return appUser;
    }
}
