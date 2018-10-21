package org.mycompany.managers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.mycompany.beans.AppUser;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class EmailManagerImplTest {

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private EmailManagerImpl emailManager;

    @Test
    public void testSendAccountActivateMail_success() {
        AppUser appUser = new AppUser();
        emailManager.sendAccountActivateMail(appUser);

        Assert.assertNotNull(appUser.getUuid());
    }

    @Test
    public void testSendAccountActivateMail_success2() {
        AppUser appUser = new AppUser();
        appUser.setEmail("testEmail@gmail.com");

        emailManager.sendAccountActivateMail(appUser);

        ArgumentCaptor<SimpleMailMessage> simpleMailMessageArgumentCaptor = ArgumentCaptor.forClass(SimpleMailMessage.class);
        verify(mailSender).send(simpleMailMessageArgumentCaptor.capture());

        Assert.assertEquals("testEmail@gmail.com" , simpleMailMessageArgumentCaptor.getValue().getTo()[0]); //todo:
        Assert.assertTrue(simpleMailMessageArgumentCaptor.getValue().getText().contains(appUser.getUuid()));
    }

    @Test
    public void testSendRestorePasswordMail_() {
        AppUser appUser = new AppUser();
        appUser.setEmail("testEmail@gmail.com");
        appUser.setPassword("newPassword123");

        emailManager.sendRestorePasswordMail(appUser);

        ArgumentCaptor<SimpleMailMessage> simpleMailMessageArgumentCaptor = ArgumentCaptor.forClass(SimpleMailMessage.class);
        verify(mailSender).send(simpleMailMessageArgumentCaptor.capture());

        Assert.assertEquals("testEmail@gmail.com" , simpleMailMessageArgumentCaptor.getValue().getTo()[0]); //todo
        Assert.assertTrue(simpleMailMessageArgumentCaptor.getValue().getText().contains(appUser.getPassword()));
    }
}