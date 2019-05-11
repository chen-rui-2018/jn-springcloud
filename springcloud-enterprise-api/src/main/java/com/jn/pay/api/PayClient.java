package com.jn.pay.api;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.pay.model.PayBIllInitiateParam;
import com.jn.pay.model.PayBill;
import com.jn.pay.model.PayCheckReminder;
import com.jn.pay.model.PayOrderNotify;
import com.jn.pay.vo.PayBillCreateParamVo;
import com.jn.pay.vo.PayBillVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 统一缴费-我的账单客户端
 *
 * @author： wzy
 * @date： Created on 2019/4/28 15:00
 * @version： v1.0
 * @modified By:
 */
@FeignClient("springcloud-enterprise")
public interface PayClient {


    /*@ApiOperation(value = "我的账单-查询列表",notes = "我的账单-查询列表")
    @RequestMapping(value = "/api/payment/payBill/billQuery",method = RequestMethod.GET)
    Result<PaginationData<List<PayBillVo>>> billQuery(PayBill payBill);*/


    @ApiOperation(value = "我的账单-账单催缴次数更新",notes = "我的账单-账单催缴次数更新")
    @RequestMapping(value = "/api/payment/payBill/updateBillNumber",method = RequestMethod.POST)
    Result updateBillNumber(@ApiParam(name = "billId", value = "账单ID或编号", required = true) @RequestParam(value = "billId") String billId,
                            @ApiParam(name = "reminderNumber", value = "催缴次数", required = true) @RequestParam(value = "reminderNumber") int reminderNumber);


    @ApiOperation(value = "我的账单-核查提醒录入",notes = "我的账单-核查提醒录入")
    @RequestMapping(value = "/api/payment/payBill/billCheckReminder",method = RequestMethod.POST)
    Result billCheckReminder(@RequestBody @Validated PayCheckReminder payCheckReminder);

    @ApiOperation(value = "我的账单-创建账单",notes = "我的账单-创建账单")
    @RequestMapping(value = "/api/payment/payBill/billCreate",method = RequestMethod.POST)
    Result bilCreate(@RequestBody @Validated PayBillCreateParamVo payBillCreateParamVo);

    @ApiOperation(value = "统一缴费-发起支付")
    @RequestMapping(value = "/api/payment/payBill/startPayment",method = RequestMethod.POST)
    Result startPayment(@RequestBody PayBIllInitiateParam payBIllInitiateParam);


    @ApiOperation(value = "统一缴费-支付回调接口", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/api/payment/payBill/payCallBack")
    void ayCallBack(HttpServletResponse response, @RequestBody PayOrderNotify callBackParam);
}
