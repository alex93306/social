package org.mycompany.controllers;

import org.mycompany.managers.ApplicationUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailVerificationController {
    @Autowired
    private ApplicationUserManager applicationUserManager;

    @RequestMapping(method = RequestMethod.GET, value = "/send-code")
    public ModelAndView sendVerificationKey() {

    }

    @RequestMapping(method = RequestMethod.GET, value = "/email-verification/{verificationKey}")
    public ModelAndView verifyEmail(@PathVariable String verificationKey)
    {
        applicationUserManager.verifyEmail(verificationKey);
    }
}
