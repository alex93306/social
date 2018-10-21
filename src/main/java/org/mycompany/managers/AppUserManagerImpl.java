package org.mycompany.managers;

import org.apache.commons.lang3.RandomStringUtils;
import org.mycompany.beans.AppUser;
import org.mycompany.dao.AppUserDao;
import org.mycompany.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Component
public class AppUserManagerImpl implements AppUserManager {

    @Autowired
    private AppUserDao appUserDao;

    @Autowired
    private EmailManager emailManager;

    @Override
    @Transactional
    public Long save(AppUser appUser) {
        return appUserDao.save(appUser);
    }

    @Override
    public AppUser update(AppUser appUser) {
       return appUserDao.update(appUser);
    }

    @Override
    public AppUser find(Long id) {
        return appUserDao.find(id);
    }

    @Override
    public AppUser findByUsername(String username) {
        Map<String, String> params = new HashMap<>();
        params.put("email", username);
        return appUserDao.findSingle("from AppUser au where au.email = :email", params);
    }

    @Override
    public boolean activateAccount(String uuid) {
        Map<String, String> params = new HashMap<>();
        params.put("uuid", uuid);
        AppUser appUser = appUserDao.findSingle("from AppUser au where au.uuid = :uuid", params); // todo: findSingle
        if (appUser != null) {
            appUser.setEnable(true);
        }
        appUserDao.update(appUser);
        return appUser != null;
    }

    @Override
    public void restorePassword(String email) {
        AppUser appUser = findByUsername(email); //todo:
        if (appUser == null) {
            throw new UserNotFoundException(); //todo;
        }

        updatePassword(appUser);

        emailManager.sendRestorePasswordMail(appUser);
    }

    private void updatePassword(AppUser appUser) {
        String newPassword = RandomStringUtils.random(7); //todo:
        appUser.setPassword(newPassword);
        update(appUser); //todo:
    }

    public AppUserDao getAppUserDao() {
        return appUserDao;
    }

    public void setAppUserDao(AppUserDao appUserDao) {
        this.appUserDao = appUserDao;
    }
}
