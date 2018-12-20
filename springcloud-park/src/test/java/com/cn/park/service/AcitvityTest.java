package com.cn.park.service;

import com.jn.SpringCloudParkApplication;
import com.jn.common.model.PaginationData;
import com.jn.park.activity.model.ActivityApplyDetail;
import com.jn.park.activity.model.ActivityContentBean;
import com.jn.park.activity.model.ActivityDetail;
import com.jn.park.activity.service.ActivityApplyService;
import com.jn.park.activity.service.ActivityService;
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
import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

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
    private ActivityApplyService activityApplyService;

    private String activityId ;
    private String userAccount;
    private String state;
    private String url;

    @Before
    public void setUp() throws Exception{
        activityId = "56ad4d018554586b1117f27391ae9bf8";
        state = "1";
        userAccount = "wangsong";
        url =  "/activity/signInActivity?activityId=56ad4d018554586b1117f27391ae9bf8" ;
    }

    @Test
    public void selectActivityList(){
        String actiType = "";
        String state = "";
        String actiName = "";
        String isIndex = "";
        Integer page = 1;
        Integer rows = 15;
        PaginationData paginationData = activityService.selectActivityList(actiType,state,actiName,isIndex,page,rows);
        List<ActivityApplyDetail> a =  (List<ActivityApplyDetail>)paginationData.getRows();
        assertThat(a.size(),greaterThanOrEqualTo(0));
    }

    @Test
    public void getActivityDetailsForManage(){
        ActivityDetail activityDetailsForManage = activityService.getActivityDetailsForManage(activityId);
        assertThat(activityDetailsForManage,notNullValue());
    }

    @Test
    public void updateActivityApply(){
        int i = activityService.updateActivityApply(activityId, state);
        assertThat(i,is(1));
    }

    @Test
    public void insertOrUpdateActivity(){
        ActivityContentBean activityContent = new ActivityContentBean();
        activityContent.setActiName("活动名称");
        activityContent.setActiType("956dc8ab83f84c0cbb6b6cea2547f449");
        activityContent.setActiStartTime("2018-12-30 18:00:00");
        activityContent.setActiEndTime("2018-12-30 21:00:00");
        activityContent.setApplyEndTime("2018-12-28 20:00:00");
        activityContent.setMesSendTime("2018-12-28 12:00:00");
        activityContent.setParkId("0b8f5135-2157-42b0-8f58-0ef5a429322er3");
        activityContent.setActiAddress("中电软件园");
        activityContent.setActiCost(new BigDecimal(0.00));
        activityContent.setActiPosterUrl("http://politics.people.com.cn/NMediaFile/2018/1219/MAIN201812191525000321021630650.jpg");
        activityContent.setActiOrganizer("管委会");
        activityContent.setActiNumber(1000);
        activityContent.setState("2");
        activityContent.setShowApplyNum("1");
        int i = activityService.insertOrUpdateActivity(activityContent,userAccount);
        assertThat(i,is(1));
    }

    @Test
    public void deleteDraftActivity(){
        int i = activityService.deleteDraftActivity(activityId);
        assertThat(i,is(1));
    }

    @Test
    public void deleteActivity(){
        int i = activityService.deleteActivity(activityId);
        assertThat(i,is(1));
    }

    @Test
    public void cancelActivity(){
        int i = activityService.cancelActivity(activityId);
        assertThat(i,is(1));
    }

    @Test
    public void applyActivityList(){
        Integer page = 1;
        Integer rows = 15;
        PaginationData paginationData = activityApplyService.applyActivityList(activityId,true, page,rows);
        List<ActivityApplyDetail> a =  (List<ActivityApplyDetail>)paginationData.getRows();
        assertThat(a.size(),greaterThanOrEqualTo(0));
    }

    @Test
    public void sendMsgForActivate(){
        int i = activityService.sendMsgForActivate(activityId);
        assertThat(i,is(1));
    }

    @Test
    public void downloadSignCodeImg(){
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

}
