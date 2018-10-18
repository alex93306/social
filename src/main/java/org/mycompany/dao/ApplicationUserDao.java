package org.mycompany.dao;

import org.mycompany.beans.ApplicationUser;

import java.util.List;
import java.util.Map;

public interface ApplicationUserDao {
    Long save(ApplicationUser applicationUser);
    ApplicationUser find(Long id);
    List<ApplicationUser> find(String query, Map<String, String> params);
}
