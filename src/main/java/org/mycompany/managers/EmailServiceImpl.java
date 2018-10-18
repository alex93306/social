package org.mycompany.managers;

import org.mycompany.beans.ApplicationUser;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EmailServiceImpl implements EmailService {
    private MailSender mailSender;

    @Override
    public void sendEmailVerification(ApplicationUser applicationUser) {
        applicationUser.setEmailVerificationKey(UUID.randomUUID().toString()); //todo: save it

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(applicationUser.getEmail());
        String verificationUrl = "http://localhost:8080/email-verification/" + applicationUser.getEmailVerificationKey(); //todo: rename and placeholder
        String link = "<a href='%s'>Link</a>";
        msg.setText("To veriry click next link " + String.format(link, verificationUrl) );

        try {
            mailSender.send(msg);
        } catch (MailException e) {
            e.printStackTrace(); //todo
        }
    }
}
