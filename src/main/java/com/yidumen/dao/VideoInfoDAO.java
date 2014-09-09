package com.yidumen.dao;

import com.yidumen.dao.entity.VideoInfo;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 蔡迪旻 <yidumen.com>
 */
@Repository
public class VideoInfoDAO extends AbstractDAO<VideoInfo> {

    @Resource
    private SessionFactory sessionFactory;

    public VideoInfoDAO() {
        super(VideoInfo.class);
    }

    @Override
    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
