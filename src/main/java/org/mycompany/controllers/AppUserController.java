package org.mycompany.controllers;

import org.mycompany.beans.AppUser;
import org.mycompany.beans.Profile;
import org.mycompany.dto.ApplicationUserDTO;
import org.mycompany.exceptions.UserNotFoundException;
import org.mycompany.managers.AppUserManager;
import org.mycompany.managers.EmailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppUserController {

    @Autowired
    AppUserManager appUserManager;
    @Autowired
    EmailManager emailManager;

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
        AppUser appUser = new AppUser();
        appUser.setEmail(applicationUserDTO.email);
        appUser.setPassword(applicationUserDTO.password);
        Profile profile = new Profile();
        profile.setFirstName(applicationUserDTO.getFirstName());
        profile.setLastName(applicationUserDTO.getLastName());
        appUser.setProfile(profile);

        appUserManager.save(appUser);

        emailManager.sendAccountActivateMail(appUser);

        return new ModelAndView("login");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/activate/{uuid}") // email-verification
    public String activateAccount(@PathVariable String uuid) {
        return appUserManager.activateAccount(uuid) ? "userProfile" : "activationFailure"; //todo;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/password/restore")
    public String showRestorePasswordPage()
    {
        return "restorePassword";
    }

    @RequestMapping(value = "/password/restore", method = RequestMethod.POST)
    public String restorePasswordPage(@RequestParam String email)
    {
        try {
            appUserManager.restorePassword(email);
        } catch (UserNotFoundException e) {
            return "passRecoveryFailure"; // todo
        }
        return "restorePassword";
    }
}
