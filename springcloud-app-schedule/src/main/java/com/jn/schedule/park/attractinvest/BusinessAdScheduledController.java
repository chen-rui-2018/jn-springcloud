package com.jn.schedule.park.attractinvest;


import com.jn.park.api.BusinessAdClient;
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
public class BusinessAdScheduledController {

    @Autowired
    private BusinessAdClient businessAdClient;

    private static Logger logger = LoggerFactory.getLogger(BusinessAdScheduledController.class);

    /**
     * 每天凌晨两点执行执行,更新工作计划是否延期
     */
    @Scheduled(cron = " 0 0 2 * * ? ")
    public void updateWorkPlanStatus() {
        //更新会议状态
        logger.info("凌晨两点执行更新招商信息,招商动态,招商政策状态功能");
        businessAdClient.updateBusinessAdStatus();
    }


}
