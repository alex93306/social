package org.mycompany.managers;

import org.mycompany.beans.AppUser;

public interface EmailManager {
    void sendAccountActivateMail(AppUser appUser);

    void sendRestorePasswordMail(AppUser appUser);

}
