package com.yidumen.datatransifer.olddata.dao;

import com.yidumen.datatransifer.olddata.dao.entity.OldTag;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class OldTagDAO extends AbstractDAO<OldTag> {

    @Resource
    private SessionFactory oldSession;

    @Override
    protected SessionFactory getSessionFactory() {
        return oldSession;
    }

    public OldTagDAO() {
        super(OldTag.class);
    }

}
