package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.pay.service.MyPayAccountService;
import com.jn.enterprise.pay.service.MyPayBillService;
import com.jn.pay.api.PayAccountClient;
import com.jn.pay.api.PayClient;
import com.jn.pay.model.PayAccountBookMoneyRecord;
import com.jn.pay.model.PayBIllInitiateParam;
import com.jn.pay.model.PayCheckReminder;
import com.jn.pay.model.PayOrderNotify;
import com.jn.pay.vo.PayAccountAndAccountBookVo;
import com.jn.pay.vo.PayBillCreateParamVo;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class PayAccountServerController extends BaseController implements PayAccountClient {

    @Autowired
    private MyPayAccountService myPayAccountService;

    @Autowired
    private MyPayBillService myPayBillService;


    @ControllerLog(doAction = "我的账户-查询当前账户下所有账本信息")
    @Override
    public Result<PayAccountAndAccountBookVo> queryPayAccountBook(String userId) {
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

}
