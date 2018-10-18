package org.mycompany.managers;

import org.mycompany.beans.ApplicationUser;
import org.mycompany.dao.ApplicationUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ApplicationUserManagerImpl implements ApplicationUserManager {

    @Autowired
    private ApplicationUserDao applicationUserDao;

    @Override
    @Transactional
    public Long save(ApplicationUser applicationUser) {
        return applicationUserDao.save(applicationUser);
    }

    @Override
    public ApplicationUser find(Long id) {
        return null;
    }

    @Override
    public List<ApplicationUser> findByUsername(String username) {
        Map<String, String> params = new HashMap<>();
        params.put("email", username);
        return applicationUserDao.find("from ApplicationUser au where au.email = :email", params);
    }

    @Override
    public void verifyEmail(String verificationKey) {
        Map<String, String> params = new HashMap<>();
        params.put("verificationKey", verificationKey);
        List<ApplicationUser> applicationUsers = applicationUserDao.find("from ApplicationUser au where au.verificationKey = :verificationKey", params);
        //todo: if several users
        ApplicationUser applicationUser = applicationUsers.get(0);
        applicationUser.set
    }
}
