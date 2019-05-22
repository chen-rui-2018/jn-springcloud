package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.pay.entity.TbPayBillDetails;
import com.jn.enterprise.pay.service.MyPayBillService;
import com.jn.pay.vo.PayBillDetailsVo;
import com.jn.pay.vo.PayBillVo;
import com.jn.pay.api.PayClient;
import com.jn.pay.model.*;
import com.jn.pay.vo.PayBillCreateParamVo;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author： wzy
 * @date： Created on 2019/5/9 17:44
 * @version： v1.0
 * @modified By:
 */
@RestController
public class PayServerController extends BaseController implements PayClient {

    @Autowired
    private MyPayBillService myPayBillService;

    @Override
    @ControllerLog(doAction = "我的账单-通过账单ID查询账单【基础】信息(包含账单支付状态)")
    public PayBill getBillBasicInfo(String billId) {
        return myPayBillService.getBillBasicInfo(billId);
    }

    @ControllerLog(doAction = "我的账单-通过账单ID查询账单详情信息")
    @Override
    public Result<PaginationData<List<PayBillDetailsVo>>> getBillInfo(String billId) {
        Assert.notNull(billId,"账单ID或编号不能为空");
        PaginationData<List<PayBillDetailsVo>> data = myPayBillService.getBillInfo(billId);
        return new Result<>(data);
    }

    @ControllerLog(doAction = "我的账单-账单催缴次数更新")
    @Override
    public Result updateBillNumber(@RequestBody PayCheckReminderParam payCheckReminderParam) {
        Assert.notNull(payCheckReminderParam.getBillId(),"账单ID或编号不能为空");
        Assert.notNull(payCheckReminderParam.getReminderNumber(),"催缴次数不能为空");
        Assert.notNull(payCheckReminderParam.getModifiedReminderTime(),"最新催缴时间不能为空");
        myPayBillService.updateBillNumber(payCheckReminderParam);
        return new Result();
    }

    @ControllerLog(doAction = "我的账单-核查提醒录入")
    @Override
    public Result billCheckReminder(@RequestBody PayCheckReminder payCheckReminder) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        myPayBillService.billCheckReminder(payCheckReminder,user);
        return new Result();
    }

    @ControllerLog(doAction = "我的账单-创建账单")
    @Override
    public Result billCreate(@RequestBody PayBillCreateParamVo payBillCreateParamVo) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Assert.notNull(payBillCreateParamVo.getAcBookType(),"账本类型ID不能为空");
        Assert.notNull(payBillCreateParamVo.getObjName(),"对象名称不能为空");
        Assert.notNull(payBillCreateParamVo.getBillExpense(),"账本费用不能为空");
        Assert.notNull(payBillCreateParamVo.getBillId(),"账本编号不能为空");
        Assert.notNull(payBillCreateParamVo.getLatePayment(),"最迟缴费时间不能为空");
        Assert.notNull(payBillCreateParamVo.getObjType(),"对象类型不能为空");
        myPayBillService.billCreate(payBillCreateParamVo,user);
        return new Result();
    }

    @ControllerLog(doAction = "统一缴费-->发起支付")
    @Override
    public Result<PayOrderRsp> createOrderAndPay(@RequestBody CreateOrderAndPayReqModel createOrderAndPayReqModel) {
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        return new Result(myPayBillService.startPayment(createOrderAndPayReqModel,user));
    }

    @ControllerLog(doAction = "支付回调接口")
    @Override
    public Result payCallBack(@RequestBody PayOrderNotify callBackParam) {
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        return new Result(myPayBillService.payCallBack(callBackParam,user));
    }
}
