package org.mycompany.managers;

import org.mycompany.beans.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EmailManagerImpl implements EmailManager {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private AppUserManager appUserManager;

    @Override
    public void sendAccountActivateMail(AppUser appUser) {
        appUser.setUuid(UUID.randomUUID().toString());
////        appUserManager.save(appUser);//todo: save it
//
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(appUser.getEmail());
        String verificationUrl = "http://localhost:8080/user/activate" + appUser.getUuid(); //todo: rename and placeholder
        String link = "<a href='%s'>Link</a>";
        msg.setText("To veriry click next link " + String.format(link, verificationUrl) );

        try {
//            mailSender.send(msg);
        } catch (MailException e) {
            e.printStackTrace(); //todo
        }
    }

    @Override
    public void sendRestorePasswordMail(AppUser appUser) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(appUser.getEmail());
        msg.setText("Your new password is " + appUser.getPassword()); //todo:

        try {
            mailSender.send(msg);
        } catch (MailException e) {
            e.printStackTrace(); //todo
        }
    }
}
