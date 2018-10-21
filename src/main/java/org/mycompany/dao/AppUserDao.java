package org.mycompany.dao;

import org.mycompany.beans.AppUser;

import java.util.List;
import java.util.Map;

public interface AppUserDao {
    Long save(AppUser appUser);
    AppUser find(Long id);
    List<AppUser> find(String query, Map<String, String> params);
    AppUser findSingle(String query, Map<String, String> params);

    AppUser update(AppUser appUser);
}
