package com.jn.schedule.eletric;

import com.jn.hardware.api.ElectricMeterClient;
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
    @Autowired
    ElectricMeterClient electricMeterClient;

    /**
     * 每两小时强制刷新access_token
     */
    @Scheduled(cron = "0 0 */2 * * ?")
    public void refreshAccessToken() {
        electricMeterClient.getElectricMeterAccessToken();
    }
}
