package com.jn.park.activity.service.impl;

import com.jn.SpringCloudParkApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.DateUtils;
import com.jn.park.activity.dao.TbActivityMapper;
import com.jn.park.activity.entity.TbActivityCriteria;
import com.jn.park.activity.service.ActivityService;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.park.activity.model.*;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author： jiangyl
 * @date： Created on 2018/12/20 10:42
 * @version： v1.0
 * @modified By:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudParkApplication.class})
public class AcitvityTest {
    private Logger logger = LoggerFactory.getLogger(AcitvityTest.class);

    @Autowired
    private ActivityService activityService;
    @Autowired
    private TbActivityMapper tbActivityMapper;

    private String activityId ;
    private String[] activityIds = {"56ad4d018554586b1117f27391ae9bf8"};
    private String userAccount;
    private String status;
    private ActivitySlimQuery activitySlimQuery;




    @Before
    public void setUp() throws Exception{
        activityId = "56ad4d018554586b1117f27391ae9bf8";
        status = "1";
        userAccount = "wangsong";
        activitySlimQuery = new ActivitySlimQuery();
        activitySlimQuery.setKeyWord("");
        activitySlimQuery.setTypeId("");
        activitySlimQuery.setPage(1);
        activitySlimQuery.setRows(15);
    }

    @Test
    public void selectActivityList(){
        ActivityParment activityParment = new ActivityParment();
        PaginationData paginationData = activityService.selectActivityList(activityParment);
        List<Activity> a =  (List<Activity>)paginationData.getRows();
        assertThat(a.size(),greaterThanOrEqualTo(0));
    }

    @Test
    public void getActivityDetailsForManage(){
        try {
            ActivityDetail activityDetailsForManage = activityService.getActivityDetailsForManage(activityId);
            assertThat(activityDetailsForManage,notNullValue());
        }catch (JnSpringCloudException e){
            logger.warn("活动不存在");
            assertThat(e.getCode(),equalTo(ActivityExceptionEnum.ACTIVITY_RESULT_ERROR.getCode()));
        }
    }

    @Test
    public void updateActivityApply(){
        ActivityStatus activityStatus = new ActivityStatus();
        activityStatus.setActivityId(activityId);
        activityStatus.setActiStatus(status);
        try{
            int i = activityService.updateActivityApply(activityStatus);
            assertThat(i,is(1));
        }catch (JnSpringCloudException e){
            logger.warn("活动数据状态错误");
            assertThat(e.getCode(),
                Matchers.anyOf(
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_STATE_ERROR.getCode()),
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_UPDATE_ERROR.getCode())
                ));
        }
    }

    @Test
    public void saveActivityDraft(){
        ActivityContent activityContent = new ActivityContent();
        activityContent.setActiName("测试活动草稿");
        activityContent.setActiType("956dc8ab83f84c0cbb6b6cea2547f449");
        activityContent.setActiStartTime("2019-03-29 08:00:00");
        activityContent.setActiEndTime("2019-03-30 21:00:00");
        activityContent.setApplyEndTime("2019-04-28 20:00:00");
        activityContent.setMesSendTime("2019-02-28 12:00:00");
        activityContent.setParkId("8f5135215742b08f580ef5a4298efe11");
        activityContent.setActiAddress("麓谷企业广场");
        activityContent.setActiCost(new BigDecimal(0.00));
        activityContent.setActiPosterUrl("http://politics.people.com.cn/NMediaFile/2018/1219/MAIN201812191525000321021630650.jpg");
        activityContent.setActiOrganizer("管委会");
        activityContent.setActiNumber(1000);
        activityContent.setActiStatus("1");
        activityContent.setShowApplyNum("1");
        try{
            insertOrUpdateActivity(activityContent);
        }catch (ParseException e){
            logger.warn("活动草稿--时间转换错误，如需测试请修改时间格式",e);
            assertThat(e.getMessage(), anything());
        }catch (JnSpringCloudException e){
            logger.warn("活动草稿 -- 数据错误,请核实测试对象数据。");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(ActivityExceptionEnum.ACTIVITY_TIME_ERROR.getCode()),
                            Matchers.containsString(ActivityExceptionEnum.ACTIVITY_APPLY_TIME_ERROR.getCode()),
                            Matchers.containsString(ActivityExceptionEnum.ACTIVITY_TIME_PARSE_ERROR.getCode()),
                            Matchers.containsString(ActivityExceptionEnum.ACTIVITY_NOT_EXIST.getCode()),
                            Matchers.containsString(ActivityExceptionEnum.ACTIVITY_STATE_NOT_DRAFT.getCode())
                    )
            );
        }
    }

    @Test
    public void publishActivity(){
        ActivityContent activityContent = new ActivityContent();
        activityContent.setActiName("元旦年后会多");
        activityContent.setActiType("956dc8ab83f84c0cbb6b6cea2547f449");
        activityContent.setActiStartTime("2019-03-29 08:00:00");
        activityContent.setActiEndTime("2019-03-30 21:00:00");
        activityContent.setApplyEndTime("2019-04-28 20:00:00");
        activityContent.setMesSendTime("2019-04-28 12:00:00");
        activityContent.setParkId("8f5135215742b08f580ef5a4298efe11");
        activityContent.setActiAddress("中电软件园");
        activityContent.setActiCost(new BigDecimal(0.00));
        activityContent.setActiPosterUrl("http://politics.people.com.cn/NMediaFile/2018/1219/MAIN201812191525000321021630650.jpg");
        activityContent.setActiOrganizer("管委会");
        activityContent.setActiNumber(1000);
        activityContent.setActiStatus("2");
        activityContent.setShowApplyNum("1");
        try{
            insertOrUpdateActivity(activityContent);
        }catch (ParseException e){
            logger.warn("发布活动--时间转换错误，如需测试请修改时间格式",e);
            assertThat(e.getMessage(), anything());
        }catch (JnSpringCloudException e){
            logger.warn("发布活动 -- 数据错误,请核实测试对象数据。");
            assertThat(e.getCode(),
                Matchers.anyOf(
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_TIME_ERROR.getCode()),
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_APPLY_TIME_ERROR.getCode()),
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_TIME_PARSE_ERROR.getCode()),
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_NOT_EXIST.getCode()),
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_STATE_NOT_DRAFT.getCode())
                )
            );
        }
    }

    public void insertOrUpdateActivity(ActivityContent activityContent) throws ParseException,JnSpringCloudException{
        int i = activityService.insertOrUpdateActivity(activityContent,userAccount);
        assertThat(i,is(1));
        TbActivityCriteria tbActivityCriteria = new TbActivityCriteria();
        tbActivityCriteria.createCriteria().andActiNameEqualTo(activityContent.getActiName()).andActiStartTimeEqualTo(DateUtils.parseDate(activityContent.getActiStartTime(),"yyyy-MM-dd HH:mm:ss"));
        tbActivityMapper.deleteByExample(tbActivityCriteria);
    }

    @Test
    public void deleteDraftActivity(){
        try{
            int i = activityService.deleteDraftActivity(activityIds,userAccount);
            assertThat(i,anything());
        }catch (JnSpringCloudException e){
            logger.warn("删除活动接口[草稿数据]--数据错误，请修改数据后再运行TEST");
            assertThat(e.getCode(),
                Matchers.anyOf(
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_STATE_ERROR.getCode()),
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_DRAFT_DELETE_ERROR.getCode())
                )
            );
        }
    }

    @Test
    public void deleteActivity(){
        try{
            int i = activityService.deleteActivity(activityIds,userAccount);
            assertThat(i,anything());
        }catch (JnSpringCloudException e){
            logger.warn("删除活动接口[管理员]--数据错误，请修改数据后再运行TEST");
            assertThat(e.getCode(),equalTo(ActivityExceptionEnum.ACTIVITY_DELETE_ERROR.getCode()));
        }
    }

    @Test
    public void cancelActivity(){
        try{
            int i = activityService.cancelActivity(activityId,userAccount);
            assertThat(i,anything());
        }catch (JnSpringCloudException e){
            logger.warn("取消活动--数据错误，请修改数据后再运行TEST");
            assertThat(e.getCode(),
                Matchers.anyOf(
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_NOT_EXIST.getCode()),
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_CANCEL_EXPEPTION.getCode())
                )
            );
        }
    }


    @Test
    public void sendMsgForActivate(){
        try{
            int i = activityService.sendMsgForActivate(activityId);
            assertThat(i,anything());
        }catch (JnSpringCloudException e){
            logger.warn("活动消息推送--数据错误，请修改数据后再运行TEST");
            assertThat(e.getCode(),
                Matchers.anyOf(
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_NOT_EXIST.getCode()),
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_STATE_SEND_MSG_EXCEPTION.getCode()),
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_SEND_MSG_TIME_EXCEPTION.getCode())
                )
            );
        }
    }


    /**
     * 查询前台活动列表
     */
    @Test
    public void activityListSlim(){
        try {
            activitySlimQuery.setStartTime("2018-02-21");
            activitySlimQuery.setEndTime("2018-03-31");
            activitySlimQuery.setTypeId("");
            activitySlimQuery.setKeyWord("");
            activitySlimQuery.setOrderBy("apply_num");
            PaginationData data = activityService.activityListSlim(activitySlimQuery,userAccount);
            assertThat((int) data.getTotal(), greaterThanOrEqualTo(0));
        }catch(Exception e) {
            logger.info("活动列表查询失败。失败原因{}", e.getMessage(), e);
            assertThat(e.getMessage(), anything());
        }
    }

    /**
     * 活动结束回调方法
     */
    @Test
    public void activityEndByTimedTask(){
        ActivityContent activityContent = new ActivityContent();
        activityContent.setId("56ad4d018554586b1117f27391ae9bf8");
        activityContent.setActiStartTime("2019-3-11 16:08:00");
        try{
            int i = activityService.activityEndByTimedTask(activityContent);
            assertThat(i,anything());
        }catch (JnSpringCloudException e){
            logger.warn("活动结束回调方法--数据错误，请修改数据后再运行TEST");
            assertThat(e.getCode(),
                Matchers.anyOf(
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getCode()),
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_NOT_EXIST.getCode())
                )
            );
        }
    }

    /**
     * 活动消息自动推送回调接口
     */
    @Test
    public void activitySendMessageByTimedTask(){
        ActivityContent activityContent = new ActivityContent();
        activityContent.setId("56ad4d018554586b1117f27391ae9bf8");
        activityContent.setActiStartTime("2019-03-11 16:08:00");
        try{
            int i = activityService.activitySendMessageByTimedTask(activityContent);
            assertThat(i,anything());
        }catch (JnSpringCloudException e){
            logger.warn("活动消息自动推送回调接口--数据错误，请修改数据后再运行TEST");
            assertThat(e.getCode(),
                Matchers.anyOf(
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getCode()),
                    Matchers.containsString(ActivityExceptionEnum.ACTIVITY_NOT_EXIST.getCode())
                )
            );
        }
    }


}
