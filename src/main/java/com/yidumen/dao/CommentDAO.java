package com.yidumen.dao;

import com.yidumen.dao.entity.Comment;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 蔡迪旻 <yidumen.com>
 */
@Repository
public class CommentDAO extends AbstractDAO<Comment> {

    @Resource
    private SessionFactory sessionFactory;


    public CommentDAO() {
        super(Comment.class);
    }

    @Override
    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
