package com.cn.park.service;

import com.jn.SpringCloudParkApplication;
import com.jn.common.model.PaginationData;
import com.jn.park.activity.service.ActivityApplyService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.IsAnything.anything;
import static org.junit.Assert.assertThat;

/**
 * 活动报名测试类
 * @Author: yangph
 * @Date: 2018/12/20 16:51
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringCloudParkApplication.class})
public class ActivityApplyServiceImplTest {
    /**
     * 日志组件
     */
    private Logger logger = LoggerFactory.getLogger(ActivityApplyServiceImplTest.class);

    @Autowired
    private ActivityApplyService activityApplyService;

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
     * 快速报名
     */

    @Test
    public void quickApply() {
        activityApplyService.quickApply(activityId, account);
        //todo:返回为空的断言未确定怎么写，待确认后完善 yangph
        assertThat(anything(),anything());
    }

    /**
     * 取消报名
     */
    @Test
    public void cancelApply() {
        activityApplyService.cancelApply(activityId, account);
        //todo:返回为空的断言未确定怎么写，待确认后完善 yangph
    }

    /**
     * 新增活动报名信息
     */
    @Test
    public void addApplyInfo() {
        activityApplyService.addApplyInfo(activityId, account);
        //todo:返回为空的断言未确定怎么写，待确认后完善 yangph
    }

    /**
     * 查询表名信息列表（后台）
     */
    @Test
    public void applyActivityList() {
    }

    /**
     * 二维码生成
     */
    @Test
    public void getQrCode() {
    }

    /**
     * 前台用户签到
     */
    @Test
    public void signInActivity() {
    }

    /**
     * 报名人列表信息
     */
    @Test
    public void findApplyActivityList() {
        PaginationData data =  activityApplyService.applyActivityList(activityId,true,1,15);
        assertThat((int)data.getTotal(),greaterThanOrEqualTo(0));

    }

}