package com.yidumen;

import com.yidumen.dao.constant.TagType;
import com.yidumen.dao.constant.VideoStatus;
import com.yidumen.dao.entity.Tag;
import com.yidumen.dao.entity.Video;
import com.yidumen.datatransifer.Transfer;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author pholance
 */
public class App {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("daoContext.xml","applicationContext.xml");
        Transfer transfer = ctx.getBean(Transfer.class);
        //        transfer.transferTag();
        transfer.transferVideo();
        transfer.transferLotus();
        transfer.transferKnownBuddhism();
        transfer.transferStudyBuddhism();
        transfer.transferBuddhist();
        transfer.transferAwakenJourney();
        transfer.transferHeartOfDharmaRealm();
    }

    private static void testCasfade(Transfer transfer) {
        Video v = new Video();
        v.setChatroomVideo(true);
        v.setFile("11111");
        v.setTitle("级联测试记录");
        v.setDuration("1'0\"");
        v.setShootTime(new Date(System.currentTimeMillis()));
        v.setStatus(VideoStatus.ARCHIVE);
        
        List<Tag> ts = new ArrayList<>();
        v.setTags(ts);
        Tag t = new Tag();
        t.setHits(1);
        t.setTagname("测试");
        t.setType(TagType.Content);
        
        ts.add(t);
        
        transfer.getVideoDao().create(v);
    }
    
}
