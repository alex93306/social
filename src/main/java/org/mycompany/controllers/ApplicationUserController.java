package org.mycompany.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.mycompany.beans.ApplicationUser;
import org.mycompany.beans.Profile;
import org.mycompany.dto.ApplicationUserDTO;
import org.mycompany.managers.ApplicationUserManager;
import org.mycompany.managers.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationUserController {

    @Autowired
    ApplicationUserManager applicationUserManager;
    @Autowired
    EmailService emailService;

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signUp() {
        return new ModelAndView("signUp");
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView createAccount(@ModelAttribute ApplicationUserDTO applicationUserDTO)
    {
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setEmail(applicationUserDTO.email);
        applicationUser.setPassword(applicationUserDTO.password);
        Profile profile = new Profile();
        profile.setFirstName(applicationUserDTO.getFirstName());
        profile.setLastName(applicationUserDTO.getLastName());
        applicationUser.setProfile(profile);

        Long userID = applicationUserManager.save(applicationUser);

        emailService.sendEmailVerification(applicationUser);

        return new ModelAndView("login");
    }
}
