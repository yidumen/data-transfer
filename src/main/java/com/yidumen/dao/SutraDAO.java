package com.yidumen.dao;

import com.yidumen.dao.entity.Sutra;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 蔡迪旻 <yidumen.com>
 */
@Repository
public class SutraDAO extends AbstractDAO<Sutra> {

    @Resource
    private SessionFactory sessionFactory;

    public SutraDAO() {
        super(Sutra.class);
    }

    @Transactional(value = "transactionManager", readOnly = true)
    public List<Sutra> find(long leftValue, long rightValue) {
        final Query q = sessionFactory.getCurrentSession().getNamedQuery("Sutra.findNodes")
                .setLong("leftValue", leftValue)
                .setLong("rightValue", rightValue);
        return q.list();
    }

    @Transactional(value = "transactionManager", readOnly = true)
    public Sutra findByLeftvalue(long leftValue) {
        return (Sutra) sessionFactory.getCurrentSession().getNamedQuery("Sutra.findByLeftValue")
                .setLong(1, leftValue)
                .uniqueResult();
    }

    public Sutra findByRightvalue(long rightValue) {
        return (Sutra) sessionFactory.getCurrentSession().getNamedQuery("Sutra.findByLeftValue")
                .setLong(1, rightValue)
                .uniqueResult();
    }

    public List<Sutra> findParents(Sutra sutra) {
        return sessionFactory.getCurrentSession().getNamedQuery("Sutra.findParents")
                .setLong(1, sutra.getLeftValue())
                .setLong(2, sutra.getRightValue())
                .list();
    }

    @Override
    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
