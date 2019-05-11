package com.jn.enterprise.pay.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.pay.model.PayAccountBookMoneyRecord;
import com.jn.enterprise.pay.model.PayBill;
import com.jn.enterprise.pay.service.MyPayAccountService;
import com.jn.enterprise.pay.vo.PayAccountAndAccountBookVo;
import com.jn.enterprise.pay.vo.PayBillVo;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 我的账户管理（视图层）
 *
 * @author： wzy
 * @date： Created on 2019/5/5 11:43
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "统一缴费-我的账户")
@RestController
@RequestMapping("/guest/payment/payAccount")
public class MyPayAccountController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(MyPayAccountController.class);

    @Autowired
    private MyPayAccountService myPayAccountService;

    @ControllerLog(doAction = "我的账户-查询当前账户下所有账本信息")
    @ApiOperation(value = "我的账户-查询当前账户下所有账本信息",notes = "我的账户-查询当前账户下所有账本信息")
    @RequestMapping(value = "/queryPayAccountBook",method = RequestMethod.GET)
    public Result<PayAccountAndAccountBookVo> queryPayAccountBook(){
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        PayAccountAndAccountBookVo data = myPayAccountService.queryPayAccountBook(user);
        return new Result(data);
    }

    @ControllerLog(doAction = "我的账本-查询当前账本下所有明细信息")
    @ApiOperation(value = "我的账本-查询当前账本下所有明细信息",notes = "我的账本-查询当前账本下所有明细信息")
    @RequestMapping(value = "/queryPayAccountDetails",method = RequestMethod.POST)
    public Result<PaginationData<List<PayAccountBookMoneyRecord>>> queryPayAccountDetails(@RequestBody @Validated PayAccountBookMoneyRecord payAccountBookMoneyRecord){
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        PaginationData<List<PayAccountBookMoneyRecord>> data = myPayAccountService.queryPayAccountDetails(user,payAccountBookMoneyRecord);
        return new Result(data);
    }


}
