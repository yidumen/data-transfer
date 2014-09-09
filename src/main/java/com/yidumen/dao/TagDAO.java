package com.yidumen.dao;

import com.yidumen.dao.entity.Tag;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 蔡迪旻 <yidumen.com>
 */
@Repository
public class TagDAO extends AbstractDAO<Tag> {

    @Autowired
    private SessionFactory sessionFactory;

    public TagDAO() {
        super(Tag.class);
    }

    @Transactional(value = "transactionManager", readOnly = true)
    public List<Tag> findTags(int limit) {
        return sessionFactory.getCurrentSession().getNamedQuery("Tag.OrderByHints")
                .setMaxResults(limit)
                .list();
    }
    
    public Tag find(String tagName) {
        return (Tag) sessionFactory.getCurrentSession().getNamedQuery("Tag.findByname")
                .setString("tagname", tagName)
                .uniqueResult();
    }

    @Override
    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
