package org.mycompany.managers;

import org.mycompany.beans.AbstractBean;

public interface BeanManager<T extends AbstractBean> {
    T find(Long id);
    Long save(T t);
}
