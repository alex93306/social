package org.mycompany.controllers;

import org.mycompany.beans.AppUser;
import org.mycompany.dto.AppUserCreateDTO;
import org.mycompany.dto.AppUserResponseDTO;
import org.mycompany.managers.AppUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class AppUserRestController {
    @Autowired
    private AppUserManager appUserManager;
//
//    @Autowired
//    private ProfileUpdateDTOValidator profileUpdateDTOValidator;
//
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.addValidators(profileUpdateDTOValidator);
//    }

    @GetMapping("/{userID}")
    @ResponseBody
    public AppUserResponseDTO getUser(@PathVariable Long userID) {
        AppUser appUser1 = appUserManager.find(1L);
        AppUserResponseDTO appUser = new AppUserResponseDTO();
        appUser.setId(appUser1.getId());
        appUser.setEmail(appUser1.getEmail());
        appUser.setFirstName(appUser1.getFirstName());
        appUser.setLastName(appUser1.getLastName());
//        return profileTransformer.populateDTO(profile);
        return appUser;
    }

//    @PutMapping("/{userID}")
//    @ResponseBody
//    public Long updateProfile(@PathVariable Long userID, @Validated @RequestBody ProfileUpdateDTO updateProfileDTO, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            System.out.println();
//        }
//        Profile profile = profileTransformer.populateEntity(updateProfileDTO);
//        return 1L;
////        return profileManager.update(profile);
//    }

    @PostMapping
    @ResponseBody
    public Long createUser(@Validated @RequestBody AppUserCreateDTO appUserCreateDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){

        }
        // todo: validate permissions
        // todo: validate
        // todo: transform
        // todo: save

        AppUser appUser = new AppUser();
        appUser.setEmail(appUserCreateDTO.getEmail());;
        return appUserManager.save(appUser);
    }
}
