package org.mycompany.dao;

import org.mycompany.beans.ApplicationUser;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

@Repository
public class ApplicationUserImpl implements ApplicationUserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long save(ApplicationUser applicationUser) {
        entityManager.persist(applicationUser);//todo: merge vs persist
        return applicationUser.getId();
    }

    @Override
    public ApplicationUser find(Long id) {
        return null;
    }

    @Override
    public List<ApplicationUser> find(String qlString, Map<String, String> params) {
        Query query = entityManager.createQuery(qlString);
        params.forEach(query::setParameter);
        return (List<ApplicationUser>) query.getResultList();
    }
}
