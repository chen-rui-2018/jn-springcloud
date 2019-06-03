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
     * 每30分钟查询物品支付订单状态,未付款取消订单
     */
    @Scheduled(cron = "0 0/30 * * * ?")
    public void updateArticlePayStatus(){
        logger.info("是否支付,未支付取消订单");
        articleOrderClient.updateArticlePayStatus();
    }

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
     * 每30分钟查询房间支付订单状态,未付款取消订单
     */
    @Scheduled(cron = "0 0/30 * * * ?")
    public void updateRoomPayStatus(){
        logger.info("是否支付,未支付取消订单");
        roomOrderClient.updateRoomPayStatus();
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
