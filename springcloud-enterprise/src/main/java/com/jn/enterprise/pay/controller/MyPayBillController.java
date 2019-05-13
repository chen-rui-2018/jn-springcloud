package com.jn.enterprise.pay.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.pay.entity.TbPayBillDetails;
import com.jn.enterprise.pay.service.MyPayBillService;
import com.jn.pay.vo.PayBillVo;
import com.jn.pay.model.*;
import com.jn.pay.vo.PayBillCreateParamVo;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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

    @ControllerLog(doAction = "我的账单-查询账单信息列表")
    @ApiOperation(value = "我的账单-查询账单信息列表",notes = "我的账单-查询账单信息列表")
    @RequestMapping(value = "/billQuery",method = RequestMethod.GET)
    @RequiresPermissions("/payment/payBill/billQuery")
    public Result<PaginationData<List<PayBillVo>>> billQuery(@Param("payBill")PayBillParams payBill){
        Assert.notNull(payBill.getObjId(),"对象ID不能为空");
        PaginationData<List<PayBillVo>> data = myPayBillService.getBillQueryList(payBill);
        return new Result<>(data);
    }

    @ControllerLog(doAction = "我的账单-通过账单ID查询账单详情信息")
    @ApiOperation(value = "我的账单-通过账单ID查询账单详情信息",notes = "我的账单-通过账单ID查询账单详情信息")
    @RequestMapping(value = "/getBillInfo",method = RequestMethod.GET)
    @RequiresPermissions("/payment/payBill/getBillInfo")
    public Result<List<PayBillDetails>> getBillInfo(@ApiParam(name="billId",value = "账单ID或编号",required = true,example = "2019050600025") @RequestParam(value = "billId") String billId){
        Assert.notNull(billId,"账单ID或编号不能为空");
        List<PayBillDetails> data = myPayBillService.getBillInfo(billId);
        return new Result<>(data);
    }


    @ControllerLog(doAction = "我的账单-核查提醒录入")
    @ApiOperation(value = "我的账单-核查提醒录入",notes = "我的账单-核查提醒录入")
    @RequestMapping(value = "/billCheckReminder",method = RequestMethod.POST)
    @RequiresPermissions("/payment/payBill/billCheckReminder")
    public Result billCheckReminder(@RequestBody @Validated PayCheckReminder payCheckReminder){
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        myPayBillService.billCheckReminder(payCheckReminder,user);
        return new Result();
    }

    @ControllerLog(doAction = "统一缴费--发起支付")
    @ApiOperation(value = "统一缴费-发起支付")
    @RequestMapping(value = "/startPayment",method = RequestMethod.POST)
    @RequiresPermissions("/payment/payBill/startPayment")
    public Result startPayment(@RequestBody PayBIllInitiateParam payBIllInitiateParam){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        return new Result(myPayBillService.startPayment(payBIllInitiateParam,user));
    }


}
