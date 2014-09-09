package com.yidumen.datatransifer.olddata.dao;

import com.yidumen.datatransifer.olddata.dao.entity.Buddhism;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BuddhismDAO extends AbstractDAO<Buddhism> {

    @Resource
    private SessionFactory oldSession;

    @Override
    protected SessionFactory getSessionFactory() {
        return oldSession;
    }

    public BuddhismDAO() {
        super(Buddhism.class);
    }

    @Transactional(value = "otm", readOnly = true)
    public List<Buddhism> getLotusSutrasOriginal() {
        return getSessionFactory().getCurrentSession().getNamedQuery("Buddhism.getByPartId")
                .setString("patten", "lotus_sutra_original_%")
                .list();
    }

    @Transactional(value = "otm", readOnly = true)
    public List<Buddhism> getLotusSutrasVernacular() {
        return getSessionFactory().getCurrentSession().getNamedQuery("Buddhism.getByPartId")
                .setString("patten", "lotus_sutra_vernacular_%")
                .list();
    }

}
