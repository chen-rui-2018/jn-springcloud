package com.cn.park.service;

import com.jn.SpringCloudParkApplication;
import com.jn.common.model.PaginationData;
import com.jn.park.activity.entity.TbActivity;
import com.jn.park.activity.entity.TbParkLike;
import com.jn.park.activity.service.ActivityDetailsService;
import com.jn.park.activity.vo.ActivityDetailVO;
import com.jn.park.model.ActivityApply;
import com.jn.park.model.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * 活动详情测试类
 * @Author: yangph
 * @Date: 2018/12/20 19:33
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringCloudParkApplication.class})
public class ActivityDetailsServiceImplTest {
    /**
     * 日志组件
     */
    private Logger logger = LoggerFactory.getLogger(ActivityDetailsServiceImplTest.class);

    @Autowired
    private ActivityDetailsService activityDetailsService;

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
     * 根据活动id获取活动详情
     */
    @Test
    public void findActivityDetails() {
        ActivityDetailVO activityDetails = activityDetailsService.findActivityDetails(activityId, account);
        assertThat(activityDetails,notNullValue());
    }

    /**
     * 根据活动id获取活动点评信息
     */
    @Test
    public void getCommentInfo() {
        PaginationData commentInfo = activityDetailsService.getCommentInfo(activityId, 0, 0, true);
        List<Comment> list= (List<Comment>)commentInfo.getRows();
        assertThat(list.size(), greaterThan(0));
    }

    /**
     * 根据活动id获取活动点赞信息
     */
    @Test
    public void getActivityLikeInfo() {
        List<TbParkLike> activityLikeInfo = activityDetailsService.getActivityLikeInfo(activityId);
        assertThat(activityLikeInfo.size(), greaterThanOrEqualTo(0));
    }

    /**
     * 根据活动id,account查询活动报名信息
     */
    @Test
    public void getActivityApplyInfo() {
        List<ActivityApply> activityApplyInfo = activityDetailsService.getActivityApplyInfo(activityId, account);
        assertThat(activityApplyInfo.size(), greaterThanOrEqualTo(0));
    }

    /**
     * 根据活动id获取园区活动信息
     */
    @Test
    public void getActivityInfo() {
        TbActivity activityInfo = activityDetailsService.getActivityInfo(activityId);
        assertThat(activityInfo,notNullValue());
    }
}