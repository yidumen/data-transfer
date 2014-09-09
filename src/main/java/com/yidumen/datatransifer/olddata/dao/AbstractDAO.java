package com.yidumen.datatransifer.olddata.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 蔡迪旻 <yidumen.com>
 * @param <T>
 */
@Transactional
public abstract class AbstractDAO<T> {

    private final Class<T> entityClass;

    public AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract SessionFactory getSessionFactory();

    @Transactional(value = "otm", readOnly = true)
    public T find(int id) {
        return (T) getSessionFactory().getCurrentSession().get(entityClass, id);
    }

    @Transactional(value = "otm", readOnly = true)
    public List<T> findAll() {
        Criteria cq = getSessionFactory().getCurrentSession().createCriteria(entityClass);
        return cq.list();
    }

}
