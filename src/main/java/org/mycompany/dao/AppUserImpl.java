package org.mycompany.dao;

import org.mycompany.beans.AppUser;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

@Repository
public class AppUserImpl implements AppUserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long save(AppUser appUser) {
        entityManager.persist(appUser);//todo: merge vs persist
        return appUser.getId();
    }

    @Override
    public AppUser find(Long id) {
        return entityManager.find(AppUser.class, id);
    }

    @Override
    public List<AppUser> find(String qlString, Map<String, String> params) {
        Query query = entityManager.createQuery(qlString);
        params.forEach(query::setParameter);
        return (List<AppUser>) query.getResultList();
    }

    @Override
    public AppUser findSingle(String query, Map<String, String> params) {
        List<AppUser> appUsers = find(query, params);
        if (appUsers.size() > 1) {
            throw new RuntimeException("Found more then 1 application user");
        }

        return appUsers.isEmpty() ? null : appUsers.get(0);
    }

    @Override
    public AppUser update(AppUser appUser) {
        return entityManager.merge(appUser);
    }
}
