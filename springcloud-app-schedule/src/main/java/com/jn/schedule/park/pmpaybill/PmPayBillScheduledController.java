package com.jn.schedule.park.pmpaybill;


import com.jn.park.api.PmPayBillServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 园区服务物业费定时调度
 *
 * @Author： cm
 * @Date： Created on 2019/1/23 16:17
 * @Version： v1.0
 * @Modified By:
 */
@Component
public class PmPayBillScheduledController {

    @Autowired
    private PmPayBillServiceClient pmPayBillServiceClient;

    private static Logger logger = LoggerFactory.getLogger(PmPayBillScheduledController.class);

    /**
     * 每季度第一天凌晨,为企业生成物业费账单
     */
    @Scheduled(cron = " 0 0 1  1 1,4,7,10 ? ")
    public void createPmPayBillByQuarter() {
        logger.info("每季度第一天凌晨,为企业生成物业费账单");
        pmPayBillServiceClient.createPmPayBillByQuarter();
    }

    /**
     * 每月16号凌晨1点更新物业管理缴费单条目是否逾期状态
     */
    @Scheduled(cron = " 0 0 1 15 * ? ")
    public void updatePmPayBillItemExpireStatus() {
        //更新会议状态
        logger.info("每月初1号凌晨两点生成物业费缴费单");
        pmPayBillServiceClient.updatePmPayBillItemExpireStatus();
    }

}
