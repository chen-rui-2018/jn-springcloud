package com.jn.pay.api;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.pay.model.PayAccountBookMoneyRecord;
import com.jn.pay.model.PayBIllInitiateParam;
import com.jn.pay.model.PayCheckReminder;
import com.jn.pay.model.PayOrderNotify;
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


}
