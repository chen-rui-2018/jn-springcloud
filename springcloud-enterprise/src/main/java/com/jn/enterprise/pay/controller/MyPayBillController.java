package com.jn.enterprise.pay.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.pay.model.*;
import com.jn.enterprise.pay.service.MyPayBillService;
import com.jn.enterprise.pay.vo.PayBillVo;
import com.jn.pay.model.PayOrderNotify;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 我的账单管理（视图层）
 *
 * @author： wzy
 * @date： Created on 2019/4/29 20:09
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "统一缴费-我的账单")
@RestController
@RequestMapping("/payment/payBill")
public class MyPayBillController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(MyPayBillController.class);

    @Autowired
    private MyPayBillService myPayBillService;

    @ControllerLog(doAction = "我的账单-查询列表")
    @ApiOperation(value = "我的账单-查询列表",notes = "我的账单-查询列表")
    @RequestMapping(value = "/billQuery",method = RequestMethod.GET)
    public Result<PaginationData<List<PayBillVo>>> billQuery(PayBill payBill){
        PaginationData<List<PayBillVo>> data = myPayBillService.getBillQueryList(payBill);
        return new Result<>(data);
    }

    @ControllerLog(doAction = "我的账单-账单催缴次数更新")
    @ApiOperation(value = "我的账单-账单催缴次数更新",notes = "我的账单-账单催缴次数更新")
    @RequestMapping(value = "/updateBillNumber",method = RequestMethod.POST)
    public Result updateBillNumber(@ApiParam(name="billId",value = "账单ID或编号",required = true) @RequestParam(value = "billId") String billId,
                                   @ApiParam(name="reminderNumber",value = "催缴次数",required = true) @RequestParam(value = "reminderNumber") int reminderNumber){
        myPayBillService.updateBillNumber(billId,reminderNumber);
        return new Result();
    }

    @ControllerLog(doAction = "我的账单-核查提醒录入")
    @ApiOperation(value = "我的账单-核查提醒录入",notes = "我的账单-核查提醒录入")
    @RequestMapping(value = "/billCheckReminder",method = RequestMethod.POST)
    public Result billCheckReminder(@RequestBody @Validated PayCheckReminder payCheckReminder){
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        myPayBillService.billCheckReminder(payCheckReminder,user);
        return new Result();
    }

    /**
     * 支付发起接口
     * @param payBIllInitiateParam
     * @return
     */
    @ControllerLog(doAction = "统一缴费--发起支付")
    @ApiOperation(value = "统一缴费-发起支付")
    @RequestMapping(value = "/startPayment",method = RequestMethod.POST)
    public Result startPayment(@RequestBody PayBIllInitiateParam payBIllInitiateParam){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        return new Result(myPayBillService.startPayment(payBIllInitiateParam,user));
    }

    @ControllerLog(doAction = "支付回调接口")
    @ApiOperation(value = "统一缴费-支付回调接口", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/payCallBack")
    public Result<String> ayCallBack(@RequestBody PayOrderNotify callBackParam){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(myPayBillService.payCallBack(callBackParam,user));
    }

}
