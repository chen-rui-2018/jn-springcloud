package com.cn.park.service;

import com.jn.common.model.PaginationData;
import com.jn.park.activity.model.Activity;
import com.jn.park.activity.model.ActivityApplyDetail;
import com.jn.park.activity.model.ActivityContentBean;
import com.jn.park.activity.model.ActivityDetail;
import com.jn.park.activity.service.ActivityApplyService;
import com.jn.park.activity.service.ActivityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2018/12/20 10:42
 * @version： v1.0
 * @modified By:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AcitvityTest {
    private Logger logger = LoggerFactory.getLogger(AcitvityTest.class);

    @Autowired
    public ActivityService activityService;
    @Autowired
    public ActivityApplyService activityApplyService;

    @Test
    public void selectActivityList(){
        String actiType = "";
        String state = "";
        String actiName = "";
        String isIndex = "";
        Integer page = 1;
        Integer rows = 15;
        PaginationData paginationData = activityService.selectActivityList(actiType,state,actiName,isIndex,page,rows);
        Object rows1 = paginationData.getRows();
    }

    @Test
    public void getActivityDetailsForManage(){
        String activityId = "56ad4d018554586b1117f27391ae9bf8";
        ActivityDetail activityDetailsForManage = activityService.getActivityDetailsForManage(activityId);
        logger.info(activityDetailsForManage.getActivityName());
    }

    @Test
    public void updateActivityApply(){
        String activityId = "56ad4d018554586b1117f27391ae9bf8";
        String state = "1";
        int i = activityService.updateActivityApply(activityId, state);
        logger.info(i+"");
    }

    @Test
    public void insertOrUpdateActivity(){
        ActivityContentBean activityContent = new ActivityContentBean();

        String userAccount = "wangsong";
        int i = activityService.insertOrUpdateActivity(activityContent,userAccount);
    }

    @Test
    public void deleteDraftActivity(){
        String activityId = "56ad4d018554586b1117f27391ae9bf8";
        int i = activityService.deleteDraftActivity(activityId);
        logger.info(i+"");
    }

    @Test
    public void deleteActivity(){
        String activityId = "56ad4d018554586b1117f27391ae9bf8";
        int i = activityService.deleteActivity(activityId);
        logger.info(i+"");
    }

    @Test
    public void cancelActivity(){
        String activityId = "56ad4d018554586b1117f27391ae9bf8";
        int i = activityService.cancelActivity(activityId);
        logger.info(i+"");
    }

    @Test
    public void applyActivityList(){
        String activityId = "56ad4d018554586b1117f27391ae9bf8";
        Integer page = 1;
        Integer rows = 15;
        PaginationData paginationData = activityApplyService.applyActivityList(activityId,true, page,rows);
        List<ActivityApplyDetail> a =  (List<ActivityApplyDetail>)paginationData.getRows();
        logger.info(a.size()+"");
    }

    @Test
    public void sendMsgForActivate(){
        String activityId = "56ad4d018554586b1117f27391ae9bf8";
        int i = activityService.sendMsgForActivate(activityId);
        logger.info(i+"");
    }

    @Test
    public void downloadSignCodeImg(){
        OutputStream outputStream = new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
        };
        String url =  "/activity/signInActivity?activityId=56ad4d018554586b1117f27391ae9bf8" ;
        try{
            activityApplyService.getQrCode(outputStream, url);
        }catch (Exception e){
            logger.error("二维码导出异常",e);
        }
    }

    public void signInActivity(){

    }

}
