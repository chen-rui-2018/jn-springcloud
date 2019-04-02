package com.jn.unionpay.payremind.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.unionpay.payremind.model.PayRemindParam;
import com.jn.unionpay.payremind.service.PayRemindService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 账单核对
 * @author： jiangyl
 * @date： Created on 2019/3/15 16:55
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "账单核对")
@RestController
@RequestMapping("/guest/pay/remind")
public class PayRemindController extends BaseController {

    @Autowired
    private PayRemindService payRemindService;

    @ControllerLog(doAction = "保存账单核对提醒信息")
    @ApiOperation(value = "保存账单核对提醒信息",notes = "返回结果为响应条数")
    @RequestMapping(value = "/saveCheckRemind",method = RequestMethod.POST)
    public Result<Integer> saveCheckRemind(@RequestBody PayRemindParam payRemindParam){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(payRemindService.saveCheckRemind(payRemindParam,user.getAccount()));
    }

}
