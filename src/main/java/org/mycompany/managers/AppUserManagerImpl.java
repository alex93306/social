package org.mycompany.managers;

import org.mycompany.beans.AppUser;
import org.mycompany.dao.AppUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppUserManagerImpl extends AbstractManager<AppUser, AppUserDAO> implements AppUserManager {
    @Autowired
    public AppUserManagerImpl(AppUserDAO dao) {
        super(dao);
    }
}
