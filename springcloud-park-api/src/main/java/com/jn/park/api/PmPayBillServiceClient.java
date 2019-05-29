package com.jn.park.api;

import com.jn.common.model.Result;
import com.jn.park.property.model.PayCallBackNotify;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 物业费管理client层
 *
 * @author： shaobao
 * @date： Created on 2019/5/26 21:20
 * @version： v1.0
 * @modified By:
 **/
@FeignClient("springcloud-park")
public interface PmPayBillServiceClient {


    /**
     * 定时月初生成物业费缴费单
     *
     * @return
     */
    @RequestMapping(value = "/api/pm/autoGeneratePmPayBillDeatils", method = RequestMethod.POST)
    Result<Boolean> autoGeneratePmPayBillDeatils();

    /**
     * 每月16号凌晨更新缴费单条目是否逾期状态
     *
     * @return
     */
    @RequestMapping(value = "/api/pm/updatePmPayBillItemPayStatus", method = RequestMethod.POST)
    Result<Boolean> updatePmPayBillItemExpireStatus();

    /**
     * 每半小时执行一次,为企业发送物业费账单
     *
     * @return
     */
    @RequestMapping(value = "/api/pm/generatePmBill", method = RequestMethod.POST)
    Result<Boolean> generatePmBill();

    /**
     * 缴费单物业费支付成功回调接口
     * @param payCallBackNotify
     * @return
     */
    @RequestMapping(value = "/api/pm/pmPayBillCallBack", method = RequestMethod.POST)
    Result<Boolean> pmPayBillCallBack(@RequestBody PayCallBackNotify payCallBackNotify);


}
