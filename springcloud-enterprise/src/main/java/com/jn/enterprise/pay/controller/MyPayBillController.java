package com.jn.enterprise.pay.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.pay.entity.TbPayBillDetails;
import com.jn.enterprise.pay.enums.PaymentBillEnum;
import com.jn.enterprise.pay.service.MyPayBillService;
import com.jn.pay.vo.PayBillDetailsVo;
import com.jn.pay.vo.PayBillVo;
import com.jn.pay.model.*;
import com.jn.pay.vo.PayBillCreateParamVo;
import com.jn.pay.vo.PayRecordVo;
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
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        PaginationData<List<PayBillVo>> data = myPayBillService.getBillQueryList(payBill,user);
        return new Result<>(data);
    }

    @ControllerLog(doAction = "我的账单-查询缴费记录信息")
    @ApiOperation(value = "我的账单-查询缴费记录信息",notes = "我的账单-查询缴费记录信息")
    @RequestMapping(value = "/billPaymentRecord",method = RequestMethod.POST)
    @RequiresPermissions("/payment/payBill/billPaymentRecord")
    public Result<PaginationData<List<PayRecordVo>>> billPaymentRecord(@RequestBody @Validated PayRecordParam payRecordParam){
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        PaginationData<List<PayRecordVo>> data = myPayBillService.billPaymentRecord(payRecordParam,user);
        return new Result<>(data);
    }

    @ControllerLog(doAction = "我的账单-通过账单ID查询账单详情信息")
    @ApiOperation(value = "我的账单-通过账单ID查询账单详情信息",notes = "我的账单-通过账单ID查询账单详情信息")
    @RequestMapping(value = "/getBillInfo",method = RequestMethod.GET)
    @RequiresPermissions("/payment/payBill/getBillInfo")
    public Result<PaginationData<List<PayBillDetailsVo>>> getBillInfo(@ApiParam(name="billId",value = "账单ID或编号",required = true,example = "2019050600025") @RequestParam(value = "billId") String billId){
        Assert.notNull(billId,"账单ID或编号不能为空");
        PaginationData<List<PayBillDetailsVo>> data = myPayBillService.getBillInfo(billId);
        return new Result<>(data);
    }


    @ControllerLog(doAction = "我的账单-核查提醒录入")
    @ApiOperation(value = "我的账单-核查提醒录入",notes = "我的账单-核查提醒录入")
    @RequestMapping(value = "/billCheckReminder",method = RequestMethod.POST)
    @RequiresPermissions("/payment/payBill/billCheckReminder")
    public Result billCheckReminder(@RequestBody @Validated PayCheckReminder payCheckReminder){
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Assert.notNull(payCheckReminder.getBillIds(),"账单ID或编号不能为空");
        return new Result(myPayBillService.billCheckReminder(payCheckReminder,user));
    }

    @ControllerLog(doAction = "我的账单-创建账单")
    @ApiOperation(value = "我的账单-创建账单",notes = "我的账单-创建账单")
    @RequestMapping(value = "/billCreate",method = RequestMethod.POST)
    @RequiresPermissions("/payment/payBill/billCreate")
    public Result billCreate(@RequestBody PayBillCreateParamVo payBillCreateParamVo) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Assert.notNull(payBillCreateParamVo.getAcBookType(),"账本类型ID不能为空");
        Assert.notNull(payBillCreateParamVo.getObjName(),"对象名称不能为空");
        Assert.notNull(payBillCreateParamVo.getBillExpense(),"账本费用不能为空");
        Assert.notNull(payBillCreateParamVo.getBillId(),"账本编号不能为空");
        Assert.notNull(payBillCreateParamVo.getLatePayment(),"最迟缴费时间不能为空");
        Assert.notNull(payBillCreateParamVo.getObjType(),"对象类型不能为空");
        if(PaymentBillEnum.BILL_AC_BOOK_TYPE_1.getCode().equals(payBillCreateParamVo.getAcBookType())){
            Assert.notNull(payBillCreateParamVo.getMeterCode(),"电表编号不能为空");
        }
        Result result=myPayBillService.billCreate(payBillCreateParamVo);
        return result;
    }

    @ControllerLog(doAction = "我的账单-插入流水记录")
    @ApiOperation(value = "我的账单-插入流水记录",notes = "我的账单-插入流水记录")
    @RequestMapping(value = "/insertRecord",method = RequestMethod.POST)
    @RequiresPermissions("/payment/payBill/insertRecord")
    public Result insertRecord(@RequestBody PayAccountBookMoneyRecord payAccountBookMoneyRecord) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Result result=myPayBillService.insertRecord(payAccountBookMoneyRecord);
        return result;
    }

    @ControllerLog(doAction = "我的账单-线下缴费确认回调各业务侧接口")
    @ApiOperation(value = "我的账单-线下缴费确认回调各业务侧接口",notes = "我的账单-线下缴费确认回调各业务侧接口")
    @RequestMapping(value = "/callbackServiceSide",method = RequestMethod.POST)
    @RequiresPermissions("/payment/payBill/callbackServiceSide")
    public Result callbackServiceSide(@RequestBody @Validated PayCallbackServiceSideParam payCallbackServiceSideParam){
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Assert.notNull(payCallbackServiceSideParam.getBillId(),"账单编号不能为空");
        return myPayBillService.callbackServiceSide(payCallbackServiceSideParam,user);
    }

    @ControllerLog(doAction = "我的账单-账单状态变更（已撤销）,各业务调用")
    @ApiOperation(value = "我的账单-账单状态变更（已撤销）,各业务调用",notes = "我的账单-账单状态变更（已撤销）,各业务调用")
    @RequestMapping(value = "/cancelBill",method = RequestMethod.POST)
    @RequiresPermissions("/payment/payBill/cancelBill")
    public Result cancelBill(@ApiParam(name="billId",value = "账单编号",required = true,example = "201905090000001") @RequestParam(value = "billId") String billId){
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Assert.notNull(billId,"账单编号不能为空");
        return myPayBillService.cancelBill(billId,user);
    }

}
