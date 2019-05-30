package com.jn.schedule.electricmeter;

import com.jn.park.api.ElectricMeterClient;
import com.jn.schedule.parking.ParkingScheduledController;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.log.annotation.ServiceLog;
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
    @ControllerLog(doAction = "进入采集电表数据的方法")
    public void getDataFromHardare(){
        logger.info("进入采集电表数据的方法");
        electricMeterClient.getDataFromHardare();
    }

    @Scheduled(cron = "0 0 1 * * ?")
    @ControllerLog(doAction = "进入定时计价的方法")
    public void calcCostEverday(){
        logger.info("进入定时计价的方法");
        electricMeterClient.calcCostEverday();
    }

    @Scheduled(cron = "0 0 1 * * ?")
    @ControllerLog(doAction = "进入定时入库企业每日的电表业主信息的方法")
    public void setHostForMeter(){
        logger.info("进入定时入库企业每日的电表业主信息的方法");
        electricMeterClient.setHostForMeter();
    }
    @Scheduled(cron = "0 0 1 * * ?")
    @ControllerLog(doAction = "进入定时入库企业每日的企业的计价规则信息的方法")
    public void setRulesInDayForCompany(){
        logger.info("进入定时入库企业每日的企业的计价规则信息的方法");
        electricMeterClient.setRulesInDayForCompany();
    }

    @Scheduled(cron = "0 0 1 * * ?")
    @ControllerLog(doAction = "进入企业电费低于规则时进行预警的方法")
    public void setWarning(){
        logger.info("进入企业电费低于规则时进行预警的方法");
        electricMeterClient.setWarning();
    }

    @Scheduled(cron = "0 0 1 * * ?")
    @ControllerLog(doAction = "进入电表的阀门的开启和关闭方法")
    public void setSwitchMeterTimer(){
        logger.info("进入电表的阀门的开启和关闭方法");
        electricMeterClient.setSwitchMeterTimer();
    }

}
