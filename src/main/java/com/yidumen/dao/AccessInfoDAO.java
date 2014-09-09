package com.yidumen.dao;

import com.yidumen.dao.entity.AccessInfo;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 蔡迪旻 <yidumen.com>
 */
@Repository
public class AccessInfoDAO extends AbstractDAO<AccessInfo> {

    @Resource
    private SessionFactory sessionFactory;

    public AccessInfoDAO() {
        super(AccessInfo.class);
    }

    @Override
    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
