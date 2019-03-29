package com.jn.park.gamtopic.service.impl;

import com.jn.SpringCloudParkApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.park.enums.GamTopicExceptionEnum;
import com.jn.park.fileimg.dao.TbFileImgMapper;
import com.jn.park.fileimg.entity.TbFileImgCriteria;
import com.jn.park.fileimg.model.FileImg;
import com.jn.park.gamtopic.dao.TbGamTopicMapper;
import com.jn.park.gamtopic.entity.TbGamTopicCriteria;
import com.jn.park.gamtopic.model.GamTopic;
import com.jn.park.gamtopic.model.GamTopicParam;
import com.jn.park.gamtopic.model.GamTopicVO;
import com.jn.park.gamtopic.service.GamTopicService;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/29 9:16
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudParkApplication.class})
public class GamTopicServiceImplTest {
    private static Logger logger = LoggerFactory.getLogger(GamTopicServiceImplTest.class);

    @Autowired
    private GamTopicService gamTopicService;
    @Autowired
    private TbGamTopicMapper tbGamTopicMapper;
    @Autowired
    private TbFileImgMapper tbFileImgMapper;

    private String account;
    private String topicId;

    @Before
    public void setUp() throws Exception {
        account = "wangsong";
        topicId = "8bc6ec3b468c4262b2366baf7158a955";
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveGamTopic() {
        GamTopic gamTopic = new GamTopic();
        gamTopic.setTopicContent("画图话题--.._..--");
        gamTopic.setTopicType("1");
        List<FileImg> imgs = new ArrayList<>(16);
        FileImg fileImg = new FileImg();
        fileImg.setImgRemark("-1-1-");
        fileImg.setImgUrl("888---/www_23i/oo.png");
        imgs.add(fileImg);
        gamTopic.setImgs(imgs);
        try{
            int i = gamTopicService.saveGamTopic(gamTopic, account);
            assertThat(i,is(1));
        }catch (JnSpringCloudException e){
            logger.warn("活动数据状态错误");
            assertThat(e.getCode(),
                Matchers.anyOf(
                        Matchers.containsString(GamTopicExceptionEnum.NETWORK_ANOMALY.getCode())
                ));
        }
        TbGamTopicCriteria tbGamTopicCriteria = new TbGamTopicCriteria();
        tbGamTopicCriteria.createCriteria().andTopicContentEqualTo("画图话题--.._..--");
        int i1 = tbGamTopicMapper.deleteByExample(tbGamTopicCriteria);
        logger.info("删除saveGamTopic保存数据响应条数{}",i1);
        TbFileImgCriteria  fileImgCriteria = new TbFileImgCriteria();
        fileImgCriteria.createCriteria().andImgRemarkEqualTo("-1-1-").andImgUrlEqualTo("888---/www_23i/oo.png");
        int i2 = tbFileImgMapper.deleteByExample(fileImgCriteria);
        logger.info("删除saveGamTopic保存图片响应条数{}",i2);

    }

    @Test
    public void deleteGamTopic() {
        try{
            int i = gamTopicService.deleteGamTopic(topicId, account);
            assertThat(i,is(1));
        }catch (JnSpringCloudException e){
            logger.warn("删除数据错误",e);
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(GamTopicExceptionEnum.USER_GAM_TOPIC_IS_NOT_EXIST.getCode()),
                            Matchers.containsString(GamTopicExceptionEnum.GAM_TOPIC_IS_NOT_NOW_USER.getCode())
                    ));
        }
    }

    @Test
    public void getMyGamTopicList() {
        Page page =new Page();
        page.setPage(1);
        page.setRows(10);
        try{
            PaginationData<List<GamTopicVO>> myGamTopicList = gamTopicService.getMyGamTopicList(page, account);
            assertThat(myGamTopicList.getRows().size(),greaterThanOrEqualTo(0));
        }catch (JnSpringCloudException e){
            logger.warn("查询我的话题信息数据失败",e);
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(GamTopicExceptionEnum.NETWORK_ANOMALY.getCode())
                    ));
        }
    }

    @Test
    public void getGamTopicListByParam() {
        GamTopicParam gamTopicParam = new GamTopicParam();
        gamTopicParam.setTopicContent("画图话题");
        gamTopicParam.setTopicType("1");
        gamTopicParam.setCreatorAcount("wangsong");
        try{
            PaginationData<List<GamTopicVO>> myGamTopicList = gamTopicService.getGamTopicListByParam(gamTopicParam);
            assertThat(myGamTopicList.getRows().size(),greaterThanOrEqualTo(0));
        }catch (JnSpringCloudException e){
            logger.warn("查询话题信息数据失败",e);
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(GamTopicExceptionEnum.NETWORK_ANOMALY.getCode())
                    ));
        }
    }

    @Test
    public void deleteGamTopicForAdmin() {
        try{
            int i = gamTopicService.deleteGamTopicForAdmin(topicId, account);
            assertThat(i,is(1));
        }catch (JnSpringCloudException e){
            logger.warn("删除数据错误",e);
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(GamTopicExceptionEnum.USER_GAM_TOPIC_IS_NOT_EXIST.getCode()),
                            Matchers.containsString(GamTopicExceptionEnum.GAM_TOPIC_IS_NOT_NOW_USER.getCode())
                    ));
        }
    }
}