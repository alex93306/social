package org.mycompany.managers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mycompany.beans.AppUser;
import org.mycompany.dao.AppUserDao;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AppUserManagerImplTest {
    private static final String QUERY = "from AppUser au where au.uuid = :uuid";
    @Mock
    private AppUserDao appUserDao;
    @InjectMocks
    private AppUserManager manager = new AppUserManagerImpl();

    @Test
    public void testActivateAccount_uuidExists() {
        String verifyKey = UUID.randomUUID().toString();
        AppUser appUser = new AppUser();
        appUser.setUuid(verifyKey);

        Map<String, String> params = new HashMap<>();
        params.put("uuid", appUser.getUuid());

        when(appUserDao.findSingle(QUERY, params)).thenReturn(appUser);

        assertTrue(manager.activateAccount(appUser.getUuid()));
        assertTrue(appUser.isEnable());
    }

    @Test
    public void testActivateAccount_uuidNotExist() {
        assertFalse(manager.activateAccount(UUID.randomUUID().toString()));
    }

    @Test
    public void testActivateAccount_uuidIsNull() {
        assertFalse(manager.activateAccount(null));
    }
}