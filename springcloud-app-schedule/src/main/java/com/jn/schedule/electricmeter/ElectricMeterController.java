package com.jn.schedule.electricmeter;

import com.jn.park.api.ElectricMeterClient;
import com.jn.schedule.parking.ParkingScheduledController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author： yangh
 * @date： Created on 2019/5/18 13:05
 * @version： v1.0
 * @modified By:
 */
@Component
public class ElectricMeterController {
    @Autowired
    private ElectricMeterClient electricMeterClient;
    private static Logger logger = LoggerFactory.getLogger(ElectricMeterController.class);
    @Scheduled(cron = "0 0 * * * ?")
    public void getDataFromHardare(){
        electricMeterClient.getDataFromHardare();
    }

    @Scheduled(cron = "0 0 1 * * ?")
    public void calcCostEverday(){
        electricMeterClient.calcCostEverday();
    }

    @Scheduled(cron = "0 0 1 * * ?")
    public void setHostForMeter(){
        electricMeterClient.setHostForMeter();
    }
    @Scheduled(cron = "0 0 1 * * ?")
    public void setRulesInDayForCompany(){
        electricMeterClient.setRulesInDayForCompany();
    }

    @Scheduled(cron = "0 0 1 * * ?")
    public void setWarning(){
        electricMeterClient.setWarning();
    }

    @Scheduled(cron = "0 0 1 * * ?")
    public void setSwitchMeterTimer(){
        electricMeterClient.setSwitchMeterTimer();
    }

}
