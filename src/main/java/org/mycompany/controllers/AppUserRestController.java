package org.mycompany.controllers;

import org.mycompany.beans.AppUser;
import org.mycompany.dto.AppUserDTO;
import org.mycompany.dto.AppUserResponseDTO;
import org.mycompany.managers.AppUserManager;
import org.mycompany.transformers.AppUserTransformer;
import org.mycompany.validators.AppUserCreateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
public class AppUserRestController {
    @Autowired
    private AppUserManager appUserManager;
    @Autowired
    private AppUserTransformer appUserTransformer;

    @Autowired
    private AppUserCreateValidator appUserCreateValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(appUserCreateValidator);
    }

    @GetMapping("/{userID}")
    @ResponseBody
    public AppUserResponseDTO getUser(@PathVariable Long userID) {
        AppUser appUser = appUserManager.find(userID);
        appUser.setId(appUser.getId());
        appUser.setEmail(appUser.getEmail());
        appUser.setFirstName(appUser.getFirstName());
        appUser.setLastName(appUser.getLastName());
        return appUserTransformer.populateDTO(appUser);
    }

    @PostMapping
    @ResponseBody
    public Object createUser(@Validated @RequestBody AppUserDTO appUserDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getCode).collect(Collectors.toList());
        }


        // todo: validate permissions
        // todo: validate

        AppUser appUser = appUserTransformer.populateEntity(appUserDTO);

        return appUserManager.save(appUser);
    }
}
