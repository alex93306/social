package org.mycompany.dao;

import org.mycompany.beans.AppUser;
import org.springframework.stereotype.Repository;

@Repository
public class AppUserDAOImpl extends AbstractBeanDAO<AppUser> implements AppUserDAO {
    public AppUserDAOImpl() {
        super(AppUser.class);
    }
}
