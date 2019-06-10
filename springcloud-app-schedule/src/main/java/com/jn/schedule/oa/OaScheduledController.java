package com.jn.schedule.oa;


import com.jn.oa.api.OaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * oa定时调度
 *
 * @Author： cm
 * @Date： Created on 2019/1/23 16:17
 * @Version： v1.0
 * @Modified By:
 */
@Component
public class OaScheduledController {

    @Autowired
    private OaClient oaClient;

    private static Logger logger = LoggerFactory.getLogger(OaScheduledController.class);


    /**
     * 每5分钟执行一次提醒会议申请人
     */
    @Scheduled(cron = "0 0/5 * * * ? ")
    public void noticesApplicationMeeting() {
        logger.info("每5分钟执行一次提醒会议申请人");
        oaClient.noticesApplicationMeeting();
    }

    /**
     * 每2分钟执行一次更新
     */
    @Scheduled(cron = "0 0/2 * * * ? ")
    public void updateMeetingStatusByTime() {
        //更新会议状态
        logger.info("每2分钟执行一次更新会议状态");
        oaClient.updateMeetingStatusByTime();
    }

    /**
     * 每天八点半执行工作计划任务提醒功能
     */
    @Scheduled(cron = " 0 30 8 * * ? ")
    public void workPlanRemindEveryDay() {
        //更新会议状态
        logger.info("执行工作计划任务提醒功能");
        oaClient.workPlanRemindEveryDay();
    }


    /**
     * 每天凌晨两点执行执行,更新工作计划是否延期
     */
    @Scheduled(cron = " 0 0 2 * * ? ")
    public void updateWorkPlanStatus() {
        //更新会议状态
        logger.info("更新工作计划是否延期,修改状态");
        oaClient.updateWorkPlanStatus();
    }

    /**
     * 每天凌晨一点点执行执行,更新多部门协同任务状态
     */
    @Scheduled(cron = " 0 0 1 * * ? ")
    public void updateMultiDeptOfficeStatus() {
        //更新会议状态
        logger.info("更新做部门协同任务,修改状态");
        oaClient.updateMultiDeptOfficeStatus();
    }

    /**
     * 每5分钟刷新多部门协同,进行任务提醒
     */
    @Scheduled(cron = "0 0/5 * * * ? ")
    public void multiDeptOfficeStatusRemind() {
        //更新会议状态
        logger.info("执行多部门协同提醒功能");
        oaClient.multiDeptOfficeStatusRemind();
    }

}
