package org.mycompany.managers;

import org.mycompany.beans.ApplicationUser;

public interface EmailService {
    void sendEmailVerification(ApplicationUser applicationUser);
}
