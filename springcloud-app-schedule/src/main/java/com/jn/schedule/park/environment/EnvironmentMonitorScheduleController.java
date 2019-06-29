package com.jn.schedule.park.environment;

import com.jn.common.model.Result;
import com.jn.park.api.EnvironmentMonitorClient;
import com.jn.schedule.park.attractinvest.BusinessAdScheduledController;
import com.jn.send.api.DelaySendMessageClient;
import com.jn.send.model.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 环境监测定时器
 *
 * @author： shaobao
 * @date： Created on 2019/6/28 14:25
 * @version： v1.0
 * @modified By:
 **/
@Component
public class EnvironmentMonitorScheduleController {

    private static Logger logger = LoggerFactory.getLogger(EnvironmentMonitorScheduleController.class);

    @Autowired
    private DelaySendMessageClient delaySendMessageClient;

    /**
     * 定时每小时获取环境监测数据
     */
    @Scheduled(cron = " 0 0 0/1 * * ? ")
    public void updateWorkPlanStatus() {
        //更新会议状态
        logger.info("每小时自动获取环境监测数据");
        Delay delay = new Delay();
        delay.setServiceId("springcloud-park");
        delay.setServiceUrl("/api/park/getEnvironmentMonitorRealTimeDate");
        //设置延时10分钟
        delay.setTtl("30");
        delay.setDataString("-1");
        logger.info("开始回调");
        Result<Boolean> delayResult = delaySendMessageClient.delaySend(delay);
        logger.info("结束回调,返回结果，【{}】", delayResult.toString());
    }
}
