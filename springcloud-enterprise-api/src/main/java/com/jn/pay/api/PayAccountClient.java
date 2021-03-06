package com.jn.pay.api;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.pay.model.*;
import com.jn.pay.vo.PayAccountAndAccountBookVo;
import com.jn.pay.vo.PayBillCreateParamVo;
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
 * 统一缴费-我的账户客户端
 *
 * @author： wzy
 * @date： Created on 2019/4/28 15:00
 * @version： v1.0
 * @modified By:
 */
@FeignClient("springcloud-enterprise")
public interface PayAccountClient {

    @ApiOperation(value = "我的账户-查询当前账户下所有账本信息",notes = "我的账户-查询当前账户下所有账本信息")
    @RequestMapping(value = "/api/payment/payAccount/queryPayAccountBook",method = RequestMethod.GET)
    Result<PayAccountAndAccountBookVo> queryPayAccountBook(@ApiParam(name="userId",value = "登录人账号",required = true,example = "wangsong") @RequestParam(value = "userId") String userId);

    @ApiOperation(value = "预缴充值-支付回调接口")
    @RequestMapping(value = "/api/payment/payAccount/payAccountCallBack",method = RequestMethod.POST)
    Result payAccountCallBack(@RequestBody PayOrderNotify callBackParam);

    /**
     * 发起支付-我的账本-预缴充值(电费)
     * @param createOrderAndPayReqModel
     * @return
     */
    @RequestMapping(value = "/api/payment/payAccount/createOrderAndPay", method = RequestMethod.POST)
    Result<PayOrderRsp> createOrderAndPay(@RequestBody CreateOrderAndPayReqModel createOrderAndPayReqModel);


    @ApiOperation(value = "我的账户-通过账本ID查询账本余额",notes = "我的账户-通过账本ID查询账本余额")
    @RequestMapping(value = "/api/payment/payAccount/queryPayAccountBookMoney",method = RequestMethod.POST)
    Result<PayAccountBook> queryPayAccountBookMoney(@RequestBody @Validated PayAccountBookMoney payAccountBookMoney);

    @ApiOperation(value = "我的账本-创建账户和账本【企业注册时调用】",notes = "我的账本-创建账户和账本【企业注册时调用】")
    @RequestMapping(value = "/api/payment/payAccount/createPayAccountBook",method = RequestMethod.POST)
    Result createPayAccountBook(@RequestBody @Validated PayAccountBookCreateParam payAccountBookCreateParam);


    @ApiOperation(value = "我的账本-用户充值后自动扣费",notes = "我的账本-用户充值后自动扣费")
    @RequestMapping(value = "/api/payment/payAccount/automaticDeduction",method = RequestMethod.POST)
    Result automaticDeduction(@RequestBody @Validated PayAutoDeduParam payAutoDeduParam);

    @ApiOperation(value = "我的账本-通过企业或用户ID查询账户下账本信息",notes = "我的账本-通过企业或用户ID查询账户下账本信息")
    @RequestMapping(value = "/api/payment/payAccount/queryAccountBook",method = RequestMethod.POST)
    Result<List<PayAccountBook>> queryAccountBook(@RequestBody @Validated PayAccountBookEntIdOrUserIdParam payAccountBookEntIdOrUserIdParam);


}
