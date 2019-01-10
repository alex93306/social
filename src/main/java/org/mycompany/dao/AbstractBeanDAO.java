package org.mycompany.dao;

import org.mycompany.beans.AbstractBean;
import org.mycompany.beans.AppUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractBeanDAO<T extends AbstractBean> implements BeanDAO<T> {
    private Class<T> clazz;

    public AbstractBeanDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long save(T bean) {
        entityManager.persist(bean);//todo: merge vs persist
        return bean.getId();
    }

    @Override
    public T find(Long id) {
        return entityManager.find(clazz, id);
    }
}
