package com.jn.schedule.parking;


import com.jn.oa.api.OaClient;
import com.jn.park.api.ParkingClient;
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
public class ParkingScheduledController {

    @Autowired
    private ParkingClient parkingClient;

    private static Logger logger = LoggerFactory.getLogger(ParkingScheduledController.class);


    /**
     * 每5分钟执行一次同步匝道数据
     */
    @Scheduled(cron = "0 0/5 * * * ? ")
    public void inParkingCarInfoList() {
        logger.info("每5分钟执行一次同步匝道数据");
        parkingClient.getInParkingCarInfoList();
    }

    /**
     * 每5分钟执行一次同车辆出场数据
     */
    @Scheduled(cron = "0 0/5 * * * ? ")
    public void outParkingCarInfoList() {
        logger.info("每5分钟执行一次同车辆出场数据");
        parkingClient.getOutParkingCarInfoList();
    }

}
