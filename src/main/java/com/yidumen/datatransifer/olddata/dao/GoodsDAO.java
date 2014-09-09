package com.yidumen.datatransifer.olddata.dao;

import com.yidumen.datatransifer.olddata.dao.entity.Goods;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsDAO extends AbstractDAO<Goods> {

    @Resource
    private SessionFactory oldSession;

    @Override
    protected SessionFactory getSessionFactory() {
        return oldSession;
    }

    public GoodsDAO() {
        super(Goods.class);
    }

}
