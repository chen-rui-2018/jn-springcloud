package com.jn.park.activity.service.impl;

import com.jn.SpringCloudParkApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.park.activity.dao.TbActivityApplyMapper;
import com.jn.park.activity.entity.TbActivityApplyCriteria;
import com.jn.park.activity.service.ActivityApplyService;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.park.activity.model.ActivityApplyDetail;
import com.jn.park.activity.model.ActivityApplyParam;
import com.jn.park.activity.model.ActivityPagingParam;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

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

    @Autowired
    private TbActivityApplyMapper tbActivityApplyMapper;

    /**
     * 活动id
     */
    private  String activityId;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 生成二维码数据
     */
    private String url;

    private String applyId;

    @Before
    public void setUp() throws Exception {
        //活动id
        activityId="4b761c29c00a49cdaa3c3d8d3bb0e440";
        //用户账号
         account="qianqi";
        url =  "/activity/signInActivity?activityId=56ad4d018554586b1117f27391ae9bf8" ;
        applyId = "7ee42b23c1a0484e885b262976d2fb87";
    }


    /**
     * 快速报名
     */

    @Test
    public void quickApply() {
        try {
            activityApplyService.quickApply(activityId, account);
            assertThat(anything(),anything());
        } catch (JnSpringCloudException e) {
            logger.info("快速报名失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(ActivityExceptionEnum.INCOMPLETE_INFORMATION.getCode()),
                            Matchers.containsString(ActivityExceptionEnum.ACTIVITY_NOT_EXIST.getCode()),
                            Matchers.containsString(ActivityExceptionEnum.ACTIVITY_CANNOT_EMPTY.getCode()),
                            Matchers.containsString(ActivityExceptionEnum.ACTIVITY_CUTOFF.getCode())
                    )
            );
        }
    }

    /**
     * 取消报名
     */
    @Test
    public void cancelApply() {
        try {
            activityApplyService.cancelApply(activityId, account);
            assertThat(anything(),anything());
        } catch (JnSpringCloudException e) {
            logger.info("取消报名失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(ActivityExceptionEnum.INCOMPLETE_INFORMATION.getCode()),
                            Matchers.containsString(ActivityExceptionEnum.ACTIVITY_NOT_EXIST.getCode()),
                            Matchers.containsString(ActivityExceptionEnum.ACTIVITY_CANNOT_EMPTY.getCode()),
                            Matchers.containsString(ActivityExceptionEnum.ACTIVITY_CUTOFF.getCode())
                    )
            );
        }

    }

    /**
     * 新增活动报名信息
     */
    @Test
    public void addApplyInfo() {
        activityApplyService.addApplyInfo(activityId, account,"1");
        assertThat(anything(),anything());
    }

    /**
     * 删除活动报名信息
     */
    @Test
    public void delApplyInfo(){
        TbActivityApplyCriteria example =new TbActivityApplyCriteria();
        example.createCriteria().andActivityIdEqualTo(activityId).andCreatorAccountEqualTo(account);
        tbActivityApplyMapper.deleteByExample(example);
    }


    /**
     * 查询表名信息列表（后台）
     */
    @Test
    public void applyActivityList() {
        ActivityApplyParam activityApplyParam = new ActivityApplyParam();
        PaginationData paginationData = activityApplyService.applyActivityList(activityApplyParam,true);
        List<ActivityApplyDetail> a =  (List<ActivityApplyDetail>)paginationData.getRows();
        assertThat(a.size(),greaterThanOrEqualTo(0));
    }

    /**
     * 二维码生成
     */
    @Test
    public void getQrCode() {
        //TODO jiangyl 二维码下载断言及处理
        OutputStream outputStream = new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
        };

        try{
            activityApplyService.getQrCode(outputStream, url);
        }catch (Exception e){
            logger.error("二维码导出异常",e);
        }
    }

    /**
     * 前台用户签到
     */
    @Test
    public void signInActivity() {
        try{
            int i = activityApplyService.signInActivity(account, activityId);
            assertThat(i, Matchers.anything());
        }catch (JnSpringCloudException e){
            logger.warn("前台用户签到--活动数据状态异常，请先处理数据再运行Test");
            assertThat(e.getCode(),
                Matchers.anyOf(
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_USER_LOGIN_EXCEPTION.getCode()),
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_APPLY_INFO_IS_NULL.getCode()),
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_USER_NOT_APPLY.getCode()),
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_APPLYED_CODE_EXCEPTION.getCode()),
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_APPLYED_SIGN_CODE_EXCEPTION.getCode())
                )
            );
        }
    }

    /**
     * 报名人列表信息(前台)
     */
    @Test
    public void findApplyActivityList() {
        ActivityPagingParam activityPagingParam = new ActivityPagingParam();
        try {
            activityPagingParam.setActivityId("4b761c29c00a49cdaa3c3d8d3bb0e440");
            PaginationData data = activityApplyService.findApplyActivityList(activityPagingParam, true);
            assertThat((int) data.getTotal(), greaterThanOrEqualTo(0));
        }catch(JnSpringCloudException e){
            logger.info("活动报名人列表查询失败。失败原因{}", ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage(),e);
            assertThat(e.getMsg(),anything());
        }
    }

    /**
     * 后台管理报名审核接口
     */
    @Test
    public void signInActivityCheck() {
        try{
            int i =  activityApplyService.signInActivityCheck(applyId,account);
            assertThat(i, Matchers.anything());
        }catch (JnSpringCloudException e){
            logger.warn("后台管理报名审核接口--活动数据状态异常，请先处理数据再运行Test");
            assertThat(e.getCode(),
                Matchers.anyOf(
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_APPLY_IS_NULL.getCode()),
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_APPLYED_NOT_CHECKED.getCode())
                )
            );
        }
    }

    /**
     * 后台管理签到接口
     */
    @Test
    public void signInActivityBackend(){
        try{
            int i = activityApplyService.signInActivityBackend(applyId,account);
            assertThat(i, Matchers.anything());
        }catch (JnSpringCloudException e){
            logger.warn("后台管理签到接口--活动数据状态异常，请先处理数据再运行Test");
            assertThat(e.getCode(),
                Matchers.anyOf(
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_APPLY_IS_NULL.getCode()),
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_APPLYED_CODE_EXCEPTION.getCode()),
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_APPLYED_SIGN_CODE_EXCEPTION.getCode())
                )
            );
        }
    }

}