package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.pay.service.MyPayBillService;
import com.jn.pay.api.PayClient;
import com.jn.pay.model.PayBIllInitiateParam;
import com.jn.pay.model.PayBill;
import com.jn.pay.model.PayCheckReminder;
import com.jn.pay.model.PayOrderNotify;
import com.jn.pay.vo.PayBillCreateParamVo;
import com.jn.pay.vo.PayBillVo;
import com.jn.system.model.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
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


    /*@Override
    public Result<PaginationData<List<PayBillVo>>> billQuery(PayBill payBill) {
        PaginationData<List<PayBillVo>> data = myPayBillService.getBillQueryList(payBill);
        return new Result(data);
    }*/

    @Override
    public Result updateBillNumber(String billId, int reminderNumber) {
        myPayBillService.updateBillNumber(billId,reminderNumber);
        return new Result();
    }

    @Override
    public Result billCheckReminder(PayCheckReminder payCheckReminder) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        myPayBillService.billCheckReminder(payCheckReminder,user);
        return new Result();
    }

    @Override
    public Result bilCreate(PayBillCreateParamVo payBillCreateParamVo) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        myPayBillService.billCreate(payBillCreateParamVo,user);
        return new Result();
    }

    @Override
    public Result startPayment(PayBIllInitiateParam payBIllInitiateParam) {
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        return new Result(myPayBillService.startPayment(payBIllInitiateParam,user));
    }

    @Override
    public void ayCallBack(HttpServletResponse response, PayOrderNotify callBackParam) {
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        myPayBillService.payCallBack(response,callBackParam,user);
    }
}
