package com.jn.schedule.hardware.eletric;

import com.jn.hardware.api.ElectricMeterClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author： chenr
 * @date： Created on 2019/4/24 11:44
 * @version： v1.0
 * @modified By:
 */
@Component
public class ElectricMeterScheduledController {
    Logger logger = LoggerFactory.getLogger(ElectricMeterScheduledController.class);
    @Autowired
    ElectricMeterClient electricMeterClient;

    /**
     * 每小时强制刷新access_token
     */
    @Scheduled(cron = "0 0 * * * ?")
    public void refreshAccessToken() {
        logger.info("执行电表token定时任务开始");
        electricMeterClient.getElectricMeterAccessToken();
        logger.info("执行电表token定时任务结束");
    }
}
