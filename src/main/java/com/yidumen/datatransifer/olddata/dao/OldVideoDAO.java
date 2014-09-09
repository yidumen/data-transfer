package com.yidumen.datatransifer.olddata.dao;

import com.yidumen.datatransifer.olddata.dao.entity.OldVideo;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class OldVideoDAO extends AbstractDAO<OldVideo> {

    @Resource
    private SessionFactory oldSession;

    @Override
    protected SessionFactory getSessionFactory() {
        return oldSession;
    }


    public OldVideoDAO() {
        super(OldVideo.class);
    }

}
