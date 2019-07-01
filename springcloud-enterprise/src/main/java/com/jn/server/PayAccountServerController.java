package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.pay.service.MyPayAccountService;
import com.jn.enterprise.pay.service.MyPayBillService;
import com.jn.pay.api.PayAccountClient;
import com.jn.pay.api.PayClient;
import com.jn.pay.model.*;
import com.jn.pay.vo.PayAccountAndAccountBookVo;
import com.jn.pay.vo.PayBillCreateParamVo;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author： wzy
 * @date： Created on 2019/5/9 17:44
 * @version： v1.0
 * @modified By:
 */
@RestController
public class PayAccountServerController extends BaseController implements PayAccountClient {

    @Autowired
    private MyPayAccountService myPayAccountService;

    @Autowired
    private MyPayBillService myPayBillService;


    @ControllerLog(doAction = "我的账户-查询当前账户下所有账本信息")
    @Override
    public Result<PayAccountAndAccountBookVo> queryPayAccountBook(@RequestParam(value = "userId") String userId) {
        PayAccountAndAccountBookVo data = myPayAccountService.queryPayAccountBook(userId);
        return new Result(data);
    }

    @Override
    @ControllerLog(doAction = "我的账本-预缴充值支付回调接口")
    public Result payAccountCallBack(@RequestBody PayOrderNotify callBackParam) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return new Result(myPayBillService.payAccountCallBack(callBackParam,user));
    }

    @Override
    public Result<PayOrderRsp> createOrderAndPay(@RequestBody CreateOrderAndPayReqModel createOrderAndPayReqModel) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return myPayBillService.insertPrepaidRecharge(createOrderAndPayReqModel,user);
    }

    @Override
    @ControllerLog(doAction = "我的账户-通过企业ID和账本类型查询账号余额")
    public Result<PayAccountBook> queryPayAccountBookMoney(@RequestBody @Validated PayAccountBookMoney payAccountBookMoney) {
        PayAccountBook payAccountBook = myPayAccountService.queryPayAccountBookMoney(payAccountBookMoney);
        return new Result(payAccountBook);
    }

    @Override
    @ControllerLog(doAction = "我的账本-创建账户和账本【企业注册时调用】")
    public Result createPayAccountBook(@RequestBody @Validated PayAccountBookCreateParam payAccountBookCreateParam){
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Assert.notNull(payAccountBookCreateParam.getEnterId(),"企业ID不能为空");
        Assert.notNull(payAccountBookCreateParam.getComAdmin(),"企业管理员账号不能为空");
        return myPayAccountService.createPayAccountBook(payAccountBookCreateParam,user);
    }

    @Override
    public Result automaticDeduction(@RequestBody @Validated PayAutoDeduParam payAutoDeduParam) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Assert.notNull(payAutoDeduParam.getAcBookId(),"账本ID不能为空");
        return myPayAccountService.automaticDeduction(payAutoDeduParam,user);
    }

    @Override
    @ControllerLog(doAction = "通过企业或用户ID查询账户下账本信息")
    public Result<List<PayAccountBook>> queryAccountBook(@RequestBody @Validated PayAccountBookEntIdOrUserIdParam payAccountBookEntIdOrUserIdParam) {
        Assert.notNull(payAccountBookEntIdOrUserIdParam.getObjId(),"对象ID不能为空");
        Assert.notNull(payAccountBookEntIdOrUserIdParam.getObjType(),"对象类型不能为空");
        return myPayAccountService.queryAccountBook(payAccountBookEntIdOrUserIdParam);
    }

}
