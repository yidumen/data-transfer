package com.yidumen.dao;

import com.yidumen.dao.entity.SutraMark;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 蔡迪旻 <yidumen.com>
 */
@Repository
public class SutraMarkDAO extends AbstractDAO<SutraMark> {

    @Resource
    private SessionFactory sessionFactory;

    public SutraMarkDAO() {
        super(SutraMark.class);
    }

    @Override
    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
