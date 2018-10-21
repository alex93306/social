package org.mycompany.managers;

import org.mycompany.beans.AppUser;

public interface AppUserManager {
    Long save(AppUser appUser);
    AppUser update(AppUser appUser);
    AppUser find(Long id);

    AppUser findByUsername(String username);

    boolean activateAccount(String uuid);

    void restorePassword(String email);
}
