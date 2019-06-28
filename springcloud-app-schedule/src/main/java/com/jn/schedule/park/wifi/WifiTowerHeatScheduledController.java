package com.jn.schedule.park.wifi;

import com.jn.park.api.WifiTowerHeatClient;
import com.jn.send.api.DelaySendMessageClient;
import com.jn.send.model.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/6/28 16:23
 * </pre>
 */
@Component
public class WifiTowerHeatScheduledController {
    private static Logger logger = LoggerFactory.getLogger(WifiTowerHeatScheduledController.class);
    @Autowired
    private DelaySendMessageClient delaySendMessageClient;


    @Scheduled(cron = "0 0/2 * * * ?")
    public void  collectionHeatInfo(){
        logger.info("定时采集 wifi热力图信息");
        Delay delay = new Delay();
        delay.setServiceId("springcloud-park");
        delay.setServiceUrl("/api/wifi/collectionHeatInfo");
        delaySendMessageClient.delaySend(delay);
    }
}
