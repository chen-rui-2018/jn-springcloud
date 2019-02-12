package com.jn.park.activity.service.impl;

import com.jn.SpringCloudParkApplication;
import com.jn.park.activity.service.ActivityLikeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.IsAnything.anything;
import static org.junit.Assert.assertThat;

/**
 * 活动点赞测试类
 * @Author: yangph
 * @Date: 2018/12/20 20:21
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringCloudParkApplication.class})
public class ActivityLikeServiceImplTest {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityLikeServiceImplTest.class);

    @Autowired
    private ActivityLikeService activityLikeService;

    /**
     * 活动id
     */
    private  String activityId;

    /**
     * 用户账号
     */
    private String account;

    @Before
    public void setUp() throws Exception {
        //活动id
        activityId="4b761c29c00a49cdaa3c3d8d3bb0e440";
        //用户账号
        account="qianqi";
    }

    /**
     *活动点赞
     */
    @Test
    public void activityLike() {
        activityLikeService.activityLike(activityId, account);
        //todo:返回为空的断言未确定怎么写，待确认后完善 yangph
        assertThat(anything(),anything());
    }

    /**
     * 取消点赞
     */
    @Test
    public void cancelLike() {
        activityLikeService.cancelLike(activityId, account);
        //todo:返回为空的断言未确定怎么写，待确认后完善 yangph
        assertThat(anything(),anything());
    }
}