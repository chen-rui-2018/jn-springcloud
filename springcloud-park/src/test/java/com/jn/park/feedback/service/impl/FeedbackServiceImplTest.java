package com.jn.park.feedback.service.impl;

import com.jn.SpringCloudParkApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.park.enums.GamTopicExceptionEnum;
import com.jn.park.feedback.dao.TbUserFeedbackMapper;
import com.jn.park.feedback.entity.TbUserFeedbackCriteria;
import com.jn.park.feedback.model.Feedback;
import com.jn.park.feedback.model.FeedbackParam;
import com.jn.park.feedback.model.FeedbackVO;
import com.jn.park.feedback.service.FeedbackService;
import com.jn.park.fileimg.dao.TbFileImgMapper;
import com.jn.park.fileimg.entity.TbFileImgCriteria;
import com.jn.park.fileimg.model.FileImg;
import com.jn.park.gamtopic.entity.TbGamTopicCriteria;
import org.checkerframework.checker.units.qual.A;
import org.hamcrest.Matchers;
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
 * 用户反馈接口测试类型
 *
 * @author： jiangyl
 * @date： Created on 2019/3/29 9:48
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudParkApplication.class})
public class FeedbackServiceImplTest {
    private static Logger logger = LoggerFactory.getLogger(FeedbackServiceImplTest.class);

    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private TbFileImgMapper tbFileImgMapper;
    @Autowired
    private TbUserFeedbackMapper tbUserFeedbackMapper;

    private String account;
    private String topicId;

    @Before
    public void setUp() throws Exception {
        account = "wangsong";
        topicId = "8bc6ec3b468c4262b2366baf7158a955";
    }

    @Test
    public void saveFeedback() {
        Feedback feedback = new Feedback();
        feedback.setFeedContent("有bug有bug111有bug_test_test_1");
        feedback.setFeedTypeId("user_feed_001");
        feedback.setFeedTypeName("功能异常");
        List<FileImg> imgs = new ArrayList<>(16);
        FileImg fileImg = new FileImg();
        fileImg.setImgRemark("-1-1-");
        fileImg.setImgUrl("888---/www_23i/oo.png");
        imgs.add(fileImg);
        feedback.setFileImgs(imgs);

        try {
            int i = feedbackService.saveFeedback(feedback, account);
            assertThat(i, is(1));
        } catch (JnSpringCloudException e) {
            logger.warn("保存反馈信息异常", e);
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(GamTopicExceptionEnum.NETWORK_ANOMALY.getCode())
                    ));
        }
        TbUserFeedbackCriteria tbUserFeedbackCriteria = new TbUserFeedbackCriteria();
        tbUserFeedbackCriteria.createCriteria().andFeedContentEqualTo("有bug有bug111有bug_test_test_1").andFeedTypeIdEqualTo("user_feed_001");
        int i = tbUserFeedbackMapper.deleteByExample(tbUserFeedbackCriteria);
        logger.info("删除saveGamTopic保存数据响应条数{}", i);
        TbFileImgCriteria fileImgCriteria = new TbFileImgCriteria();
        fileImgCriteria.createCriteria().andImgRemarkEqualTo("-1-1-").andImgUrlEqualTo("888---/www_23i/oo.png");
        int i2 = tbFileImgMapper.deleteByExample(fileImgCriteria);
        logger.info("删除saveGamTopic保存图片响应条数{}", i2);

    }

    @Test
    public void getUserFeedbackList() {
        FeedbackParam feedbackParam = new FeedbackParam();
        feedbackParam.setFeedContent("有bug有bug111有bug_test_test_1");
        feedbackParam.setFeedTypeId("user_feed_001");
        feedbackParam.setFeedTypeName("功能异常");
        try {
            PaginationData<List<FeedbackVO>> userFeedbackList = feedbackService.getUserFeedbackList(feedbackParam);
            assertThat(userFeedbackList.getRows().size(),greaterThanOrEqualTo(0));
        } catch (JnSpringCloudException e) {
            logger.warn("保存反馈信息异常", e);
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(GamTopicExceptionEnum.NETWORK_ANOMALY.getCode())
                    ));
        }

    }
}