package com.jn.schedule.oa;


import com.jn.common.util.LoadBalancerUtil;
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
    private LoadBalancerUtil loadBalancerUtils;
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



}
