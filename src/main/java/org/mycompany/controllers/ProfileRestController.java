package org.mycompany.controllers;

import org.mycompany.beans.Gender;
import org.mycompany.beans.Profile;
import org.mycompany.beans.RelationshipStatus;
import org.mycompany.dto.AppUserCreateDTO;
import org.mycompany.dto.ProfileResponseDTO;
import org.mycompany.dto.ProfileUpdateDTO;
import org.mycompany.managers.ProfileManager;
import org.mycompany.transformers.ProfileTransformer;
import org.mycompany.validators.ProfileUpdateDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/users")
public class ProfileRestController {

    @Autowired
    private ProfileUpdateDTOValidator profileUpdateDTOValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(profileUpdateDTOValidator);
    }

    @Autowired
    private ProfileManager profileManager;
    @Autowired
    private ProfileTransformer profileTransformer;

    @GetMapping("/{userID}")
    @ResponseBody
    public ProfileResponseDTO getProfile(@PathVariable Long userID) {
        Profile profile = profileManager.find(userID);
        // todo: validate permissions
        return profileTransformer.populateDTO(profile);
    }

    @PutMapping("/{userID}")
    @ResponseBody
    public Long updateProfile(@PathVariable Long userID, @Validated @RequestBody ProfileUpdateDTO updateProfileDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println();
        }
        Profile profile = profileTransformer.populateEntity(updateProfileDTO);
        return 1L;
//        return profileManager.update(profile);
    }

    @PostMapping
    @ResponseBody
    public Long createUser(@Validated @RequestBody AppUserCreateDTO appUserCreateDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){

        }

        return null;
    }
}
