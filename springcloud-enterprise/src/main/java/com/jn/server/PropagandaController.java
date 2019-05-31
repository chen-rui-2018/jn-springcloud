package com.jn.server;

import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.BusinessPromotionExceptionEnum;
import com.jn.enterprise.propaganda.controller.BusinessPromotionController;
import com.jn.enterprise.propaganda.service.BusinessPromotionService;
import com.jn.pay.api.PropagandaClient;
import com.jn.system.log.annotation.ControllerLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 宣传费用支付成功回调修改支付状态
 * @Author: yangph
 * @Date: 2019/5/27 16:33
 * @Version v1.0
 * @modified By:
 */
@RestController
public class PropagandaController implements PropagandaClient {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(BusinessPromotionController.class);

    @Autowired
    private BusinessPromotionService businessPromotionService;

    @ControllerLog(doAction = "根据账单号修改支付状态")
    @Override
    public Result<Integer> updatePayStatus(String orderCode) {
        logger.info("根据账单号修改支付状态API,入参：{}",orderCode);
        Assert.notNull(orderCode, BusinessPromotionExceptionEnum.ORDER_CODE_NOT_NULL.getMessage());
        int resNum= businessPromotionService.updatePayStatus(orderCode);
        logger.info("-------------根据账单号修改支付状态成功，数据响应条数：{}---------------",resNum);
        return  new Result(resNum);
    }
}
