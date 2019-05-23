package com.jn.enterprise.pay.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.pay.service.MyPayAccountService;
import com.jn.enterprise.pay.service.MyPayBillService;
import com.jn.pay.model.PayAccountBookParam;
import com.jn.pay.vo.PayAccountAndAccountBookVo;
import com.jn.pay.vo.PayAccountBookMoneyRecordVo;
import com.jn.pay.vo.PayAccountBookRecordVo;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.SysDictInvoke;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/payment/payAccount")
public class MyPayAccountController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(MyPayAccountController.class);

    @Autowired
    private MyPayAccountService myPayAccountService;

    @Autowired
    private MyPayBillService myPayBillService;

    @ControllerLog(doAction = "我的账户-查询当前账户下所有账本信息")
    @ApiOperation(value = "我的账户-查询当前账户下所有账本信息",notes = "我的账户-查询当前账户下所有账本信息")
    @RequestMapping(value = "/queryPayAccountBook",method = RequestMethod.GET)
    @RequiresPermissions("/payment/payAccount/queryPayAccountBook")
    public Result<PayAccountAndAccountBookVo> queryPayAccountBook(){
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Assert.notNull(user,"用户信息获取异常");
        Assert.notNull(user.getAccount(),"账号获取异常");
        PayAccountAndAccountBookVo data = myPayAccountService.queryPayAccountBook(user.getAccount());
        return new Result(data);
    }

    @ControllerLog(doAction = "我的账本-查询账本明细")
    @ApiOperation(value = "我的账本-查询账本明细",notes = "我的账本-查询账本明细")
    @RequestMapping(value = "/queryPayAccountBookInfo",method = RequestMethod.POST)
    @RequiresPermissions("/payment/payAccount/queryPayAccountBookInfo")
    public Result<PaginationData<List<PayAccountBookRecordVo>>> queryPayAccountBookInfo(@RequestBody PayAccountBookParam payAccountBookParam){
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        PaginationData<List<PayAccountBookRecordVo>> data = myPayAccountService.queryPayAccountBookInfo(payAccountBookParam);
        return new Result<>(data);
    }

    @ControllerLog(doAction = "我的账本-账本明细详情查询")
    @ApiOperation(value = "我的账本-账本明细详情查询",notes = "我的账本-账本明细详情查询")
    @RequestMapping(value = "/queryPayAccountDetails",method = RequestMethod.POST)
    @RequiresPermissions("/payment/payAccount/queryPayAccountDetails")
    public Result<PaginationData<PayAccountBookMoneyRecordVo>> queryPayAccountDetails(@ApiParam(name="deductionId",value = "流水号",required = true,example = "0619e44f712048b7b2c49ac2d7769ee6") @RequestParam(value = "deductionId") String deductionId){
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        PaginationData<PayAccountBookMoneyRecordVo> data = myPayAccountService.queryPayAccountDetails(deductionId,user);
        return new Result<>(data);
    }

    @ControllerLog(doAction = "我的账本-获取费用预缴协议")
    @ApiOperation(value = "我的账本-获取费用预缴协议",notes = "我的账本-获取费用预缴协议")
    @RequestMapping(value = "/getFeeAdvanceAgreement",method = RequestMethod.POST)
    @RequiresPermissions("/payment/payAccount/getFeeAdvanceAgreement")
    public Result<String> getFeeAdvanceAgreement(@RequestBody @Validated SysDictInvoke sysDictInvoke){
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Assert.notNull(sysDictInvoke.getKey(),"数据字典键不能为空");
        Assert.notNull(sysDictInvoke.getParentGroupCode(),"父分组不能为空");
        Assert.notNull(sysDictInvoke.getGroupCode(),"分组不能为空");
        Assert.notNull(sysDictInvoke.getModuleCode(),"模块编码不能为空");
        Result<String> data = myPayAccountService.getFeeAdvanceAgreement(sysDictInvoke,user);
        return new Result(data);
    }

}
