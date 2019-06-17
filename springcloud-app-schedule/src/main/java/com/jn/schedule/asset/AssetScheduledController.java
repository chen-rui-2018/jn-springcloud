package com.jn.schedule.asset;

import com.jn.park.api.ActivityClient;
import com.jn.park.api.ArticleOrderClient;
import com.jn.park.api.RoomOrderClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * asset定时调度
 */
@Component
public class AssetScheduledController {
    private static Logger logger = LoggerFactory.getLogger(AssetScheduledController.class);

    @Autowired
    private ArticleOrderClient articleOrderClient;

    @Autowired
    private RoomOrderClient roomOrderClient;

    /**
     * 每天凌晨两点执行执行,更新物品租借是否逾期
     */
    @Scheduled(cron = "0 0 2 * * ?")
    public void updateAssetArticleStatus(){
        //更新租借物品逾期状态
        logger.info("更新租借物品是否逾期,修改状态");
        articleOrderClient.updateAssetArticleStatus();
    }

    /**
     * 每天凌晨两点执行执行,生成缴费单
     */
    @Scheduled(cron = "0 0 0 1 * ?")
    public void createOrderBill(){
        logger.info("生成缴费单");
        roomOrderClient.createOrderBill();
    }

}
