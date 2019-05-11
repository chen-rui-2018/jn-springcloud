package com.jn.schedule.enterprise;

import com.jn.enterprise.api.EnterpriseClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时器，创建任务
 * @author： yangh
 * @date： Created on 2019/5/10 18:05
 * @version： v1.0
 * @modified By:
 */
@Component
public class EnterpriseScheduledController {
    @Autowired
    private EnterpriseClient businessAdClient;

    private static Logger logger = LoggerFactory.getLogger(EnterpriseScheduledController.class);

    /**
     * 创建任务
     */
    @Scheduled(cron = " 0 0 1 * * ? ")
    public void createTask(){
        //更新会议状态
        logger.info("创建任务");
        businessAdClient.createTask();
    }

    /**
     * 更新任务状态
     */
    @Scheduled(cron = " 0 0 1 * * ? ")
    public void updateTask(){
        logger.info("更新任务状态");
        businessAdClient.updateTask();
    }


    /**
     * 任务预警
     */
    @Scheduled(cron = " 0 0 1 * * ? ")
    public void taskWarning(){
        logger.info("任务预警");
        businessAdClient.taskWarning();
    }
}
