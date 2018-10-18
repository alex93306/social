package org.mycompany.managers;

import org.mycompany.beans.ApplicationUser;

import java.util.List;

public interface ApplicationUserManager {
    Long save(ApplicationUser applicationUser);
    ApplicationUser find(Long id);

    List<ApplicationUser> findByUsername(String username);

    void verifyEmail(String verificationKey);
}
