package com.yidumen.datatransifer;

import com.yidumen.dao.SutraDAO;
import com.yidumen.dao.SutraMarkDAO;
import com.yidumen.dao.TagDAO;
import com.yidumen.dao.VideoDAO;
import com.yidumen.dao.constant.TagType;
import com.yidumen.dao.constant.VideoResolution;
import com.yidumen.dao.constant.VideoStatus;
import com.yidumen.dao.entity.Sutra;
import com.yidumen.dao.entity.SutraMark;
import com.yidumen.dao.entity.Tag;
import com.yidumen.dao.entity.Video;
import com.yidumen.dao.entity.VideoInfo;
import com.yidumen.datatransifer.olddata.dao.BuddhismDAO;
import com.yidumen.datatransifer.olddata.dao.OldTagDAO;
import com.yidumen.datatransifer.olddata.dao.OldVideoDAO;
import com.yidumen.datatransifer.olddata.dao.entity.Buddhism;
import com.yidumen.datatransifer.olddata.dao.entity.OldTag;
import com.yidumen.datatransifer.olddata.dao.entity.OldVideo;
import java.util.ArrayList;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pholance
 */
@Service
public class Transfer {

    private static final Logger LOG = Logger.getLogger(Transfer.class.getName());

    @Autowired
    private OldVideoDAO oldVideoDao;
    @Autowired
    private OldTagDAO oldTagDao;
    @Autowired
    private BuddhismDAO buddhismDao;

    @Autowired
    private TagDAO tagDao;
    @Autowired
    private VideoDAO videoDao;
    @Autowired
    private SutraDAO sutraDao;
    @Autowired
    private SutraMarkDAO sutraMarkDao;

    private final Map<String, String> videos;
    private final Map<String, Integer> pagecount;
    private final Pattern pattern = Pattern.compile("[１２３４５６７８９０]*");
    private final char[] numquerys = {'０', '１', '２', '３', '４', '５', '６', '７', '８', '９',};
    private int nodeValue;

    public Transfer() {
        this.videos = new HashMap<>();
        this.pagecount = new HashMap<>();
        pagecount.put("buddhism_001_023_001", 3);
        pagecount.put("buddhism_001_025_001", 3);
        pagecount.put("buddhism_001_026_001", 2);
        pagecount.put("buddhism_001_027_001", 2);
        pagecount.put("buddhism_001_029_001", 3);
        pagecount.put("buddhism_001_030_001", 3);
        pagecount.put("buddhism_001_031_001", 6);
        pagecount.put("buddhism_001_036_001", 2);
        pagecount.put("buddhism_001_037_001", 3);
        pagecount.put("buddhism_002_008_001", 3);
        pagecount.put("buddhism_003_001_001", 2);
        pagecount.put("buddhism_003_002_001", 3);
        pagecount.put("buddhism_003_003_001", 3);

        videos.put("buddhism_001_001_001", "C1000");
        videos.put("buddhism_001_002_001", "C1001");
        videos.put("buddhism_001_003_001", "C1002");
        videos.put("buddhism_001_004_001", "C1003");
        videos.put("buddhism_001_005_001", "C1004");
        videos.put("buddhism_001_006_001", "C1005");
        videos.put("buddhism_001_007_001", "C1006");
        videos.put("buddhism_001_008_001", "C1007");
        videos.put("buddhism_001_009_001", "C1008");
        videos.put("buddhism_001_010_001", "C1009");
        videos.put("buddhism_001_011_001", "C1010");
        videos.put("buddhism_001_012_001", "C1011");
        videos.put("buddhism_001_013_001", "C1012");
        videos.put("buddhism_001_014_001", "C1013");
        videos.put("buddhism_001_015_001", "C1014");
        videos.put("buddhism_001_016_001", "C1015");
        videos.put("buddhism_001_017_001", "C1016");
        videos.put("buddhism_001_018_001", "C1017");
        videos.put("buddhism_001_019_001", "C1018");
        videos.put("buddhism_001_020_001", "C1019");
        videos.put("buddhism_001_021_001", "C1020");
        videos.put("buddhism_001_022_001", "C1021");
        videos.put("buddhism_001_023_001", "C1022");
        videos.put("buddhism_001_024_001", "C1023");
        videos.put("buddhism_001_025_001", "C1024");
        videos.put("buddhism_001_026_001", "C1025");
        videos.put("buddhism_001_027_001", "C1026");
        videos.put("buddhism_001_028_001", "C1027");
        videos.put("buddhism_001_029_001", "C1028");
        videos.put("buddhism_001_030_001", "C1029");
        videos.put("buddhism_001_031_001", "C1030");
        videos.put("buddhism_001_032_001", "C1031");
        videos.put("buddhism_001_033_001", "C1032");
        videos.put("buddhism_001_034_001", "C1033");
        videos.put("buddhism_001_035_001", "C1034");
        videos.put("buddhism_001_036_001", "C1035");
        videos.put("buddhism_001_037_001", "C1036");
        videos.put("buddhism_001_038_001", "C1037");
    }

    public void transferTag() {
        List<OldTag> oldTags = oldTagDao.findAll();
        oldTags.stream().forEach((OldTag oldTag) -> {
            Tag tag = new Tag();
            tag.setTagname(oldTag.getTagname());
            tag.setType(TagType.Content);
            tagDao.create(tag);
            LOG.log(Level.INFO, "Trasfer Tag {0}", tag.getTagname());
        });
    }

    public void transferVideo() throws ParseException {
        List<OldVideo> oldVideos = oldVideoDao.findAll();
        for (OldVideo oldVideo : oldVideos) {
            Video video = new Video();
            String title = oldVideo.getTitle();
            long sortNum = 0;
            String[] st = title.split("　");
            String num = st[st.length - 1];
            if (pattern.matcher(num).matches()) {
                char[] numchars = num.toCharArray();
                StringBuilder viewValue = new StringBuilder("0");
                for (char numchar : numchars) {
                    for (int j = 0, c = numquerys.length; j < c; j++) {
                        char numquery = numquerys[j];
                        if (numchar == numquery) {
                            viewValue.append(j);
                        }
                    }
                }
                for (int j = 0, c = st.length - 1; j < c; j++) {
                    title = (st[j] + "　");
                }
                sortNum = Long.parseLong(viewValue.toString());
            }

            video.setTitle(title);
            video.setSort(sortNum);
            video.setFile(oldVideo.getFile());

            List<VideoInfo> videoInfos = new ArrayList<>();
            //<editor-fold defaultstate="collapsed" desc="解析文件大小信息">
            String vSize = oldVideo.getSize();
            String[] splitSize = vSize.split(",");

            if (splitSize.length == 4) {
                VideoInfo info = new VideoInfo();
                info.setResolution(VideoResolution.FLOW);
                info.setWidth(0);
                info.setHeight(0);
                info.setVideo(video);
                info.setFileSize(Integer.valueOf(splitSize[0].trim()));
                videoInfos.add(info);

                info = new VideoInfo();
                info.setResolution(VideoResolution.SD);
                info.setWidth(0);
                info.setHeight(0);
                info.setVideo(video);
                info.setFileSize(Integer.valueOf(splitSize[1].trim()));
                videoInfos.add(info);

                info = new VideoInfo();
                info.setResolution(VideoResolution.HD);
                info.setWidth(0);
                info.setHeight(0);
                info.setVideo(video);
                info.setFileSize(Integer.valueOf(splitSize[2].trim()));
                videoInfos.add(info);

                info = new VideoInfo();
                info.setResolution(VideoResolution.SHD);
                info.setWidth(0);
                info.setHeight(0);
                info.setVideo(video);
                info.setFileSize(Integer.valueOf(splitSize[3].trim()));
                videoInfos.add(info);
            } else {
                VideoInfo info = new VideoInfo();
                info.setResolution(VideoResolution.FLOW);
                info.setWidth(0);
                info.setHeight(0);
                info.setVideo(video);
                info.setFileSize(0);
                videoInfos.add(info);

                info = new VideoInfo();
                info.setResolution(VideoResolution.SD);
                info.setWidth(0);
                info.setHeight(0);
                info.setVideo(video);
                info.setFileSize(0);
                videoInfos.add(info);

                info = new VideoInfo();
                info.setResolution(VideoResolution.HD);
                info.setWidth(0);
                info.setHeight(0);
                info.setVideo(video);
                info.setFileSize(0);
                videoInfos.add(info);

                info = new VideoInfo();
                info.setResolution(VideoResolution.SHD);
                info.setWidth(0);
                info.setHeight(0);
                info.setVideo(video);
                info.setFileSize(0);
                videoInfos.add(info);
            }
            //</editor-fold>
            video.setExtInfo(videoInfos);

            List<Tag> tags = new ArrayList<>();
            String strTag = oldVideo.getTag();
            String[] splitTag = strTag.split(" ");
            for (String t : splitTag) {
                final String trim = t.trim();
                if (trim.isEmpty() || trim.equals("0")) {
                    continue;
                }
                Tag tag = tagDao.find(trim);
                LOG.log(Level.INFO, "Tag is {0}", tag);
                if (tag == null) {
                    tag = new Tag();
                    tag.setTagname(trim);
                    tag.setType(TagType.Content);
//                    tagDao.create(tag);
//                    tag = tagDao.find(trim);
                } else {
                    LOG.log(Level.INFO, "Tag.hits is {0}", tag.getHits());
                    tag.setHits(tag.getHits() + 1);
                    tagDao.edit(tag);
                    LOG.log(Level.INFO, "Tag.video is {0}", tag.getVideos());
                }
                tags.add(tag);
            }
            video.setTags(tags);

            video.setDescrpition(oldVideo.getDescription());
            String[] splitLength = oldVideo.getLength().split(",");
            if (splitLength.length == 3) {
                final int hour = splitLength[0].trim().isEmpty() ? 0 : Integer.parseInt(splitLength[0].trim());
                final int minute = splitLength[1].trim().isEmpty() ? 0 : Integer.parseInt(splitLength[1].trim());
                final int second = splitLength[2].trim().isEmpty() ? 0 : Integer.parseInt(splitLength[2].trim());
                video.setDuration(String.format("%02d", hour * 60 + minute)
                                  + "'"
                                  + String.format("%02d", second)
                                  + "\"");
            } else {
                video.setDuration("0'0\"");
            }
            SimpleDateFormat format = new SimpleDateFormat("yyyy,MM,dd");
            video.setShootTime(new Date(format.parse(oldVideo.getShoottime()).getTime()));
            switch (oldVideo.getStatus()) {
                case 1:
                    if (oldVideo.getPublishstatus() == 1) {
                        video.setRecommend(true);
                    }
                    video.setStatus(VideoStatus.PUBLISH);
                    break;
                default:
                    video.setStatus(VideoStatus.ARCHIVE);
            }
            video.setPubDate(new java.sql.Date(oldVideo.getCreatetime()));
            video.setChatroomVideo(true);
            videoDao.create(video);
            LOG.log(Level.INFO, "transfer video {0} {1}", new Object[]{oldVideo.getId(), oldVideo.getTitle()});
        }
    }

    public void transferLotus() {
        /*
         由于佛经的ID是固定的，经查看莲华经没有分页信息并且ID号是连续的。所以采用一种看似不太靠谱
         的办法，通过一个个查询ID来得到信息，这样数据的顺序不会打乱。
         节点的左右值参照节点示意图，必须与其一一对应。
         */
        List<Sutra> nodes = new ArrayList<>();
        //1.声明变量nodeValue用于计算节点的左右值，初始值为1；
        nodeValue = 1;
        //2.按图向SutraNode插入一个"莲华经"节点,设置左值,暂不设置右值
        Sutra lotusNode = new Sutra();
        lotusNode.setLeftValue(nodeValue++);
        lotusNode.setTitle("莲华经");
        nodes.add(lotusNode);
        //3.按图插入“妙法莲华经在说什么”节点,旧ID为1995
        Sutra preface = new Sutra();
        preface.setTitle("前言");
        preface.setLeftValue(nodeValue++);

        Sutra lotusSayWhat = new Sutra();
        {
            lotusSayWhat.setLeftValue(nodeValue++);
            lotusSayWhat.setRightValue(nodeValue++);
            lotusSayWhat.setTitle("妙法莲华经在说什么？妙法莲华经在佛法中的地位和价值");
            Buddhism buddhism = buddhismDao.find(1995);
            lotusSayWhat.setContent(buddhism.getContent());

            nodes.add(lotusSayWhat);

        }
        //4.按图插入"妙法莲华经对现代众生的意义"节点,旧ID为2054
        Sutra lotusMean = new Sutra();
        {
            lotusMean.setLeftValue(nodeValue++);
            lotusMean.setRightValue(nodeValue++);
            lotusMean.setTitle("妙法莲华经对现代众生的意义");
            Buddhism buddhism = buddhismDao.find(2054);
            lotusMean.setContent(buddhism.getContent());

            nodes.add(lotusMean);
        }
        preface.setRightValue(nodeValue++);
        //5.按图插入"原经文"节点
        Sutra lotusOriginal = new Sutra();
        lotusOriginal.setTitle("原经文");
        lotusOriginal.setLeftValue(nodeValue++);

        nodes.add(lotusOriginal);
        //6.循环查找ID,转换原经文数据,ID范围1996到2023
        List<Buddhism> originals = buddhismDao.getLotusSutrasOriginal();
        for (int i = 1996; i <= 2023; i++) {
            for (Buddhism buddhism : originals) {
                if (buddhism.getId() == i) {
                    Sutra sutraNode = new Sutra();
                    sutraNode.setLeftValue(nodeValue++);
                    sutraNode.setRightValue(nodeValue++);
                    String[] splitTitle = buddhism.getTitle().split("•");
                    sutraNode.setPartIdentifier(splitTitle[0].trim());
                    sutraNode.setTitle(splitTitle[1].trim());
                    sutraNode.setContent(buddhism.getContent());

                    nodes.add(sutraNode);
                }
            }
        }
        //设置“原经文”节点的右值
        lotusOriginal.setRightValue(nodeValue++);
        //7.按图插入"释义"节点
        Sutra lotusVernacular = new Sutra();
        lotusVernacular.setTitle("释义");
        lotusVernacular.setLeftValue(nodeValue++);

        nodes.add(lotusVernacular);
        List<Buddhism> vernaculars = buddhismDao.getLotusSutrasVernacular();
        for (int i = 2024; i <= 2051; i++) {
            //8.循环查找ID,转换释义数据,ID范围2024到2051
            for (Buddhism vernacular : vernaculars) {
                if (i == vernacular.getId()) {
                    Sutra sutra = new Sutra();
                    sutra.setLeftValue(nodeValue++);
                    sutra.setRightValue(nodeValue++);
                    String[] splitTitle = vernacular.getTitle().split("•");
                    sutra.setPartIdentifier(splitTitle[0].trim());
                    sutra.setTitle(splitTitle[1].trim());
                    sutra.setContent(vernacular.getContent());

                    nodes.add(sutra);
                }
            }
        }
        //设置“释义”节点的右值
        lotusVernacular.setRightValue(nodeValue++);
        //最后设置“莲华经”节点的右值
        lotusNode.setRightValue(nodeValue);
        nodes.stream().forEach(node -> {
            sutraDao.create(node);
            LOG.log(Level.INFO, "transfer sutra: {0}", node.getTitle());
        });
        //顺便加个书签
        SutraMark mark = new SutraMark();
        mark.setId(1995L);
        mark.setNode(lotusSayWhat);
        sutraMarkDao.create(mark);
        mark = new SutraMark();
        mark.setId(2052L);
        mark.setNode(lotusMean);
        sutraMarkDao.create(mark);

    }

    public void transferKnownBuddhism() {
        List<Sutra> nodes = new ArrayList<>();
        //1.插入“了解佛教”节点。在其下插入2个节点：“目录”和"正文“
        Sutra knownBuddhism = new Sutra();
        knownBuddhism.setTitle("了解佛教");
        knownBuddhism.setLeftValue(nodeValue++);
        nodes.add(knownBuddhism);

        Sutra directory = new Sutra();
        directory.setTitle("目录");
        directory.setContent(buddhismDao.find(1934).getContent());
        directory.setLeftValue(nodeValue++);
        directory.setRightValue(nodeValue++);
        nodes.add(directory);

        Sutra content = new Sutra();
        content.setTitle("正文");
        content.setLeftValue(nodeValue++);
        nodes.add(content);

        //2.查找ID范围1794到1849，把它们作为正文节点的子节点插入，分页信息作为该节点的子节点插入
        for (int i = 1794; i <= 1849; i++) {
            Sutra sutra = new Sutra();
            Buddhism buddhism = buddhismDao.find(i);
            String[] splitTitle = buddhism.getTitleCss().split("•");
            sutra.setPartIdentifier(splitTitle[0].trim().substring(10));
            sutra.setTitle(buddhism.getTitle());
            sutra.setContent(buddhism.getContent());
            sutra.setLeftValue(nodeValue++);
            String videofile = videos.get(buddhism.getPartid());
            if (videofile != null) {
                sutra.setVideo(videoDao.find(videofile));
            }

            nodes.add(sutra);
            Integer pcount = pagecount.get(buddhism.getPartid());
            if (pcount == null) {
                sutra.setRightValue(nodeValue++);
                continue;
            }
            for (int j = 0; j < pcount - 1; j++) {
                Sutra pageSutra = new Sutra();
                pageSutra.setTitle("第" + (j + 2) + "页");
                Buddhism b = buddhismDao.find(++i);
                pageSutra.setContent(b.getContent());
                pageSutra.setLeftValue(nodeValue++);
                pageSutra.setRightValue(nodeValue++);
                nodes.add(pageSutra);
            }
            sutra.setRightValue(nodeValue++);
        }
        content.setRightValue(nodeValue++);
        knownBuddhism.setRightValue(nodeValue++);
        nodes.stream().forEach((node) -> {
            sutraDao.create(node);
            LOG.log(Level.INFO, "transfer sutra: {0}", node.getTitle());
        });
        SutraMark dir = new SutraMark();
        dir.setId(1934L);
        dir.setNode(directory);
        sutraMarkDao.create(dir);
    }

    public void transferStudyBuddhism() {
        List<Sutra> nodes = new ArrayList<>();
        //1.插入“学习佛法”节点
        Sutra studyBuddhism = new Sutra();
        studyBuddhism.setTitle("学习佛法");
        studyBuddhism.setLeftValue(nodeValue++);

        nodes.add(studyBuddhism);
        //2.插入"目录"和”序“子节点,ID分别为1935和2055
        Sutra directory = new Sutra();
        {
            directory.setTitle("目录");
            directory.setContent(buddhismDao.find(1935).getContent());
            directory.setLeftValue(nodeValue++);
            directory.setRightValue(nodeValue++);

            nodes.add(directory);

            Sutra preface = new Sutra();
            preface.setTitle("序言");
            preface.setContent(buddhismDao.find(2055).getContent());
            preface.setLeftValue(nodeValue++);
            preface.setRightValue(nodeValue++);

            nodes.add(preface);
        }
        //3.插入”第一部分“子节点
        Sutra partOne = new Sutra();
        partOne.setPartIdentifier("第一部分");
        partOne.setTitle("断疑与了解");
        partOne.setLeftValue(nodeValue++);

        nodes.add(partOne);
        //3.1 插入”前言“子节点,ID为1850
        {
            Sutra introduction = new Sutra();
            introduction.setTitle("前言");
            introduction.setContent(buddhismDao.find(1850).getContent());
            introduction.setLeftValue(nodeValue++);
            introduction.setRightValue(nodeValue++);

            nodes.add(introduction);
        }
        //3.2 插入其它子节点,范围1851到1863,1853作废
        for (int i = 1851; i <= 1863; i++) {
            if (i == 1853) {
                continue;
            }
            Buddhism buddhism = buddhismDao.find(i);
            Sutra sutra = new Sutra();
            String titleCss = buddhism.getTitleCss();
            sutra.setPartIdentifier(titleCss.substring(29, 32));
            sutra.setTitle(titleCss.substring(titleCss.indexOf("</span>") + 7, titleCss.length() - 5));
            sutra.setContent(buddhism.getContent());
            sutra.setLeftValue(nodeValue++);

            nodes.add(sutra);

            Integer pcount = pagecount.get(buddhism.getPartid());
            if (pcount == null) {
                sutra.setRightValue(nodeValue++);
                LOG.log(Level.INFO, "transfer sutra: {0}", sutra.getTitle());
                continue;
            }
            for (int j = 0; j < pcount - 1; j++) {
                Sutra pageSutra = new Sutra();
                pageSutra.setTitle("第" + (j + 2) + "页");
                Buddhism b = buddhismDao.find(++i);
                pageSutra.setContent(b.getContent());
                pageSutra.setLeftValue(nodeValue++);
                pageSutra.setRightValue(nodeValue++);
                nodes.add(pageSutra);
            }
            sutra.setRightValue(nodeValue++);
            LOG.log(Level.INFO, "transfer sutra: {0}", sutra.getTitle());
        }
        partOne.setRightValue(nodeValue++);
        //4.插入"第二部分"子节点
        Sutra partTwo = new Sutra();
        partTwo.setPartIdentifier("第二部分");
        partTwo.setTitle("佛学基础知识");
        partTwo.setLeftValue(nodeValue++);
        nodes.add(partTwo);
        //4.1 插入“大乘佛法”节点和其下子节点,前言1864,其它1865到1872,无分页
        Sutra mahayana = new Sutra();
        mahayana.setTitle("大乘佛法");
        mahayana.setLeftValue(nodeValue++);
        nodes.add(mahayana);
        {
            Sutra preface = new Sutra();
            preface.setTitle("前言");
            preface.setContent(buddhismDao.find(1864).getContent());
            preface.setLeftValue(nodeValue++);
            preface.setRightValue(nodeValue++);
            nodes.add(preface);
        }
        for (int i = 1865; i <= 1872; i++) {
            Buddhism buddhism = buddhismDao.find(i);
            Sutra sutra = new Sutra();
            String titleCss = buddhism.getTitleCss();
            sutra.setPartIdentifier(titleCss.substring(35, 38));
            sutra.setTitle(titleCss.substring(titleCss.indexOf("</span>") + 7, titleCss.length() - 5));
            sutra.setContent(buddhism.getContent());
            sutra.setLeftValue(nodeValue++);
            sutra.setRightValue(nodeValue++);
            nodes.add(sutra);
        }
        mahayana.setRightValue(nodeValue++);
        //4.2 插入"密乘佛法“及其子节点，ID为1873，1874
        Sutra trantrayana = new Sutra();
        trantrayana.setTitle("密乘佛法");
        trantrayana.setLeftValue(nodeValue++);
        nodes.add(trantrayana);

        for (int i = 1873; i <= 1874; i++) {
            Buddhism buddhism = buddhismDao.find(i);
            Sutra sutra = new Sutra();
            String titleCss = buddhism.getTitleCss();
            sutra.setPartIdentifier(titleCss.substring(35, 38));
            sutra.setTitle(titleCss.substring(titleCss.indexOf("</span>") + 7, titleCss.length() - 5));
            sutra.setContent(buddhism.getContent());
            sutra.setLeftValue(nodeValue++);
            sutra.setRightValue(nodeValue++);
            nodes.add(sutra);
        }
        trantrayana.setRightValue(nodeValue++);
        //4.3 插入"小乘佛法"及其子节点,ID从1875到1879
        Sutra hinayana = new Sutra();
        hinayana.setTitle("小乘佛法");
        hinayana.setLeftValue(nodeValue++);

        for (int i = 1875; i <= 1879; i++) {
            Buddhism buddhism = buddhismDao.find(i);
            Sutra sutra = new Sutra();
            String titleCss = buddhism.getTitleCss();
            sutra.setPartIdentifier(titleCss.substring(35, 38));
            sutra.setTitle(titleCss.substring(titleCss.indexOf("</span>") + 7, titleCss.length() - 5));
            sutra.setContent(buddhism.getContent());
            sutra.setLeftValue(nodeValue++);
            sutra.setRightValue(nodeValue++);
            nodes.add(sutra);
        }
        hinayana.setRightValue(nodeValue++);
        //4.4 插入"附录"及其子节点,ID为1880
        Sutra addenda = new Sutra();
        addenda.setTitle("附录");
        addenda.setLeftValue(nodeValue++);
        nodes.add(addenda);
        {
            Sutra sutra = new Sutra();
            sutra.setPartIdentifier("经典导读");
            sutra.setTitle("《阿含经》");
            sutra.setContent(buddhismDao.find(1880).getContent());
            sutra.setLeftValue(nodeValue++);
            sutra.setRightValue(nodeValue++);
            nodes.add(sutra);
        }
        addenda.setRightValue(nodeValue++);
        partTwo.setRightValue(nodeValue++);
        
        //5.插入“第三部分”节点及其子节点，ID从1915到1925,无分页
        Sutra partThree = new Sutra();
        partThree.setPartIdentifier("第三部分");
        partThree.setTitle("在家人修行的体会");
        partThree.setLeftValue(nodeValue++);
        nodes.add(partThree);

        for (int i = 1915; i <= 1925; i++) {
            Buddhism buddhism = buddhismDao.find(i);
            Sutra sutra = new Sutra();
            String titleCss = buddhism.getTitleCss();
            sutra.setPartIdentifier(titleCss.substring(32, titleCss.indexOf(" •</span>")));
            sutra.setTitle(titleCss.substring(titleCss.indexOf("</span>") + 7, titleCss.length() - 5));
            sutra.setContent(buddhism.getContent());
            sutra.setLeftValue(nodeValue++);
            sutra.setRightValue(nodeValue++);
            nodes.add(sutra);
        }
        partThree.setRightValue(nodeValue++);
        //6.插入"第四部分"节点及其子节点,ID从1881到1914,无分页
        Sutra partFour = new Sutra();
        partFour.setPartIdentifier("第四部分");
        partFour.setTitle("佛学基础概念");
        partFour.setLeftValue(nodeValue++);
        nodes.add(partFour);

        for (int i = 1881; i <= 1914; i++) {
            Buddhism buddhism = buddhismDao.find(i);
            Sutra sutra = new Sutra();
            String titleCss = buddhism.getTitleCss();
            int indexOf = titleCss.indexOf(" &#8226;</span>");
            if (indexOf < 0) {
                indexOf = titleCss.indexOf(" •</span>");
            }
            sutra.setPartIdentifier(titleCss.substring(titleCss.indexOf("<span>") + 6, indexOf));
            sutra.setTitle(titleCss.substring(titleCss.indexOf("</span>") + 7, titleCss.indexOf("</h3>")));
            sutra.setContent(buddhism.getContent());
            sutra.setLeftValue(nodeValue++);
            sutra.setRightValue(nodeValue++);
            nodes.add(sutra);
        }
        partFour.setRightValue(nodeValue++);
        studyBuddhism.setRightValue(nodeValue++);
        nodes.stream().forEach((node) -> {
            sutraDao.create(node);
            LOG.log(Level.INFO, "transfer sutra: {0}", node.getTitle());
        });
        SutraMark dir = new SutraMark();
        dir.setId(1935L);
        dir.setNode(directory);
        sutraMarkDao.create(dir);
    }

    public void transferBuddhist() throws Exception {
        List<Sutra> nodes = new ArrayList<>();
        Sutra buddhist = new Sutra();
        buddhist.setTitle("修证佛法");
        buddhist.setLeftValue(nodeValue++);
        nodes.add(buddhist);

        Sutra directory = new Sutra();
        directory.setTitle("目录");
        directory.setContent(buddhismDao.find(1936).getContent());
        directory.setLeftValue(nodeValue++);
        directory.setRightValue(nodeValue++);
        nodes.add(directory);

        for (int i = 1926; i <= 1930; i++) {
            Sutra sutra = new Sutra();
            Buddhism buddhism = buddhismDao.find(i);
            sutra.setPartIdentifier(buddhism.getTitleCss().substring(10, 11));
            sutra.setTitle(buddhism.getTitle());
            sutra.setContent(buddhism.getContent());
            sutra.setLeftValue(nodeValue++);

            nodes.add(sutra);
            Integer pcount = pagecount.get(buddhism.getPartid());
            if (pcount == null) {
                sutra.setRightValue(nodeValue++);
                continue;
            }
            for (int j = 0; j < pcount - 1; j++) {
                Sutra pageSutra = new Sutra();
                pageSutra.setTitle("第" + (j + 2) + "页");
                Buddhism b = buddhismDao.find(++i);
                pageSutra.setContent(b.getContent());
                pageSutra.setLeftValue(nodeValue++);
                pageSutra.setRightValue(nodeValue++);
                nodes.add(pageSutra);
            }
            sutra.setRightValue(nodeValue++);
        }
        buddhist.setRightValue(nodeValue++);
        nodes.stream().forEach((Sutra node) -> {
            sutraDao.create(node);
            LOG.log(Level.INFO, "transfer sutra: {0}", node.getTitle());
        });
        SutraMark dir = new SutraMark();
        dir.setId(1936L);
        dir.setNode(directory);
        sutraMarkDao.create(dir);
    }

    public void transferAwakenJourney() {
        //ID从1148到1154
        List<Sutra> nodes = new ArrayList<>();

        Sutra awakenJourney = new Sutra();
        awakenJourney.setTitle("星路");
        awakenJourney.setLeftValue(nodeValue++);
        nodes.add(awakenJourney);

        for (int i = 1148; i <= 1154; i++) {
            Buddhism buddhism = buddhismDao.find(i);
            Sutra sutra = new Sutra();
            String titleCss = buddhism.getTitleCss();
            sutra.setPartIdentifier(titleCss.substring(10, 13));
            sutra.setTitle(buddhism.getTitle());
            sutra.setContent(buddhism.getContent());
            sutra.setLeftValue(nodeValue++);
            sutra.setRightValue(nodeValue++);
            nodes.add(sutra);
        }

        awakenJourney.setRightValue(nodeValue++);
        nodes.stream().forEach((node) -> {
            sutraDao.create(node);
            LOG.log(Level.INFO, "transfer sutra: {0}", node.getTitle());
        });
    }

    public void transferHeartOfDharmaRealm() {
        List<Sutra> nodes = new ArrayList<>();
        Sutra hodr = new Sutra();
        hodr.setTitle("法界之心");
        hodr.setLeftValue(nodeValue++);
        nodes.add(hodr);

        Sutra partOne = new Sutra();
        partOne.setPartIdentifier("第一部分");
        partOne.setTitle("空花");
        partOne.setLeftValue(nodeValue++);
        nodes.add(partOne);

        for (int i = 1314; i <= 1339; i++) {
            Sutra sutra = new Sutra();
            Buddhism buddhism = buddhismDao.find(i);
            sutra.setPartIdentifier(buddhism.getTitleCss().substring(26, 29));
            sutra.setTitle(buddhism.getTitle());
            sutra.setContent(buddhism.getContent());
            sutra.setLeftValue(nodeValue++);
            sutra.setRightValue(nodeValue++);

            nodes.add(sutra);
        }
        partOne.setRightValue(nodeValue++);

        Sutra partTwo = new Sutra();
        partTwo.setPartIdentifier("第二部分");
        partTwo.setTitle("如月");
        partTwo.setLeftValue(nodeValue++);
        nodes.add(partTwo);

        Sutra partTwo1 = new Sutra();
        partTwo1.setTitle("四十九天闭关日记");
        partTwo1.setLeftValue(nodeValue++);
        nodes.add(partTwo1);

        for (int i = 1340; i <= 1347; i++) {
            Sutra sutra = new Sutra();
            Buddhism buddhism = buddhismDao.find(i);
            sutra.setTitle(buddhism.getTitle().split(" • ")[1].trim());
            sutra.setContent(buddhism.getContent());
            sutra.setLeftValue(nodeValue++);
            sutra.setRightValue(nodeValue++);

            nodes.add(sutra);
        }
        partTwo1.setRightValue(nodeValue++);

        Sutra partTwo2 = new Sutra();
        partTwo2.setTitle("西藏之旅");
        partTwo2.setLeftValue(nodeValue++);
        nodes.add(partTwo2);

        for (int i = 1348; i <= 1361; i++) {
            if (i == 1359) {
                continue;
            }
            Sutra sutra = new Sutra();
            Buddhism buddhism = buddhismDao.find(i);
            sutra.setTitle(buddhism.getTitle().split(" • ")[1].trim());
            sutra.setContent(buddhism.getContent());
            sutra.setLeftValue(nodeValue++);
            sutra.setRightValue(nodeValue++);

            nodes.add(sutra);
        }
        partTwo2.setRightValue(nodeValue++);

        Sutra partTwo3 = new Sutra();
        partTwo3.setTitle("终南山百日闭关纪实");
        partTwo3.setLeftValue(nodeValue++);
        nodes.add(partTwo3);

        for (int i = 1362; i <= 1371; i++) {
            Sutra sutra = new Sutra();
            Buddhism buddhism = buddhismDao.find(i);
            sutra.setTitle(buddhism.getTitle().split(" • ")[1].trim());
            sutra.setContent(buddhism.getContent());
            sutra.setLeftValue(nodeValue++);
            sutra.setRightValue(nodeValue++);

            nodes.add(sutra);
        }
        partTwo3.setRightValue(nodeValue++);

        Sutra hope = new Sutra();
        hope.setTitle("如愿");
        hope.setContent(buddhismDao.find(1372).getContent());
        hope.setLeftValue(nodeValue++);
        hope.setRightValue(nodeValue++);
        nodes.add(hope);

        partTwo.setRightValue(nodeValue++);

        Sutra postscript = new Sutra();
        postscript.setTitle("后记");
        postscript.setContent(buddhismDao.find(1373).getContent());
        postscript.setLeftValue(nodeValue++);
        postscript.setRightValue(nodeValue++);
        nodes.add(postscript);

        hodr.setRightValue(nodeValue++);

        nodes.stream().forEach((Sutra node) -> {
            sutraDao.create(node);
            LOG.log(Level.INFO, "transfer sutra: {0}", node.getTitle());
        });
    }

    public OldVideoDAO getOldVideoDao() {
        return oldVideoDao;
    }

    public OldTagDAO getOldTagDao() {
        return oldTagDao;
    }

    public BuddhismDAO getBuddhismDao() {
        return buddhismDao;
    }

    public TagDAO getTagDao() {
        return tagDao;
    }

    public VideoDAO getVideoDao() {
        return videoDao;
    }

    public SutraDAO getSutraDao() {
        return sutraDao;
    }

    public SutraMarkDAO getSutraMarkDao() {
        return sutraMarkDao;
    }

    public Map<String, String> getVideos() {
        return videos;
    }

    public Map<String, Integer> getPagecount() {
        return pagecount;
    }

    public char[] getNumquerys() {
        return numquerys;
    }

    public int getNodeValue() {
        return nodeValue;
    }
}
