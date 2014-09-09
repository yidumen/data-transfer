package com.yidumen.dao;

import com.yidumen.dao.entity.Account;
import java.io.Serializable;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 蔡迪旻 <yidumen.com>
 */
@Repository
public class AccountDAO extends AbstractDAO<Account> implements Serializable {

    @Resource
    private SessionFactory sessionFactory;

    public AccountDAO() {
        super(Account.class);
    }

    @Transactional(value = "transactionManager", readOnly = true)
    public Account find(String emailOrPhone) {
        return (Account) sessionFactory.getCurrentSession().getNamedQuery("Account.findByName")
                .setString("username", emailOrPhone)
                .uniqueResult();
    }

    @Override
    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
