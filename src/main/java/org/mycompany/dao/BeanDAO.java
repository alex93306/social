package org.mycompany.dao;

import org.mycompany.beans.AbstractBean;

public interface BeanDAO<T extends AbstractBean> {
    T find(Long id);
    Long save(T t);
}
