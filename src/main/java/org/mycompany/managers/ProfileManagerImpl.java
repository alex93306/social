package org.mycompany.managers;

import org.mycompany.beans.Profile;
import org.mycompany.dao.ProfileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileManagerImpl implements ProfileManager {

    @Autowired
    ProfileDao profileDao;

    @Override
    public Profile find(Long id) {
        return profileDao.find(id);
    }

    @Override
    public Long update(Profile profile) {
        return profileDao.update(profile);
    }
}
