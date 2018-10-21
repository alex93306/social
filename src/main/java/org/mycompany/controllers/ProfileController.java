package org.mycompany.controllers;

import org.mycompany.beans.AppUser;
import org.mycompany.managers.AppUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

    @Autowired
    private AppUserManager appUserManager;

    @RequestMapping(value = "/users/{userID}", method = RequestMethod.GET)
    public ModelAndView showUserProfile(@PathVariable Long userID){
        // validate user todo
        AppUser appUser = appUserManager.find(userID);

        return new ModelAndView("userProfile", "profile", appUser.getProfile());
    }
}
