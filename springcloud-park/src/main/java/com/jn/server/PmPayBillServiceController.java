package com.jn.server;

import com.jn.common.model.Result;
import com.jn.park.api.PmPayBillServiceClient;
import com.jn.park.pmpaybill.service.PmPayBillService;
import com.jn.park.property.model.PayCallBackNotify;
import com.jn.system.log.annotation.ControllerLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 物业费管理sever
 *
 * @author： shaobao
 * @date： Created on 2019/5/26 21:21
 * @version： v1.0
 * @modified By:
 **/
@RestController
public class PmPayBillServiceController implements PmPayBillServiceClient {

    @Autowired
    private PmPayBillService pmPayBillService;

    @Override
    @ControllerLog(doAction = "每月初1号凌晨两点生成物业费缴费单")
    public Result<Boolean> autoGeneratePmPayBillDeatils() {
        pmPayBillService.autoGeneratePmPayBillDeatils();
        return new Result<>(true);
    }

    /**
     * 每月16凌晨更新物业费缴费单是否逾期状态
     *
     * @return
     */
    @Override
    @ControllerLog(doAction = "每月16号凌晨更新缴费单条目是否逾期状态")
    public Result<Boolean> updatePmPayBillItemExpireStatus() {
        pmPayBillService.updatePmPayBillItemExpireStatus();
        return new Result<>(true);
    }

    /**
     * 缴费单物业费支付成功回调接口
     * @param payCallBackNotify
     * @return
     */
    @Override
    @ControllerLog(doAction = "缴费单物业费支付成功回调接口")
    public Result<Boolean> pmPayBillCallBack(@RequestBody PayCallBackNotify payCallBackNotify) {
        pmPayBillService.pmPayBillCallBack(payCallBackNotify);
        return new Result<>(true);
    }
}

