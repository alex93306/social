package org.mycompany.managers;

import org.mycompany.beans.AbstractBean;
import org.mycompany.dao.BeanDAO;
import org.springframework.transaction.annotation.Transactional;

public class AbstractManager<T extends AbstractBean, R extends BeanDAO<T>> {
    private R dao; // todo: investigate

    public AbstractManager(R dao) {
        this.dao = dao;
    }

    public T find(Long id) {
        return dao.find(id);
    }
    @Transactional
    public Long save(T t) {
        return dao.save(t);
    }
}
