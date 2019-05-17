package com.jn.park.customer.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.park.customer.service.ClientRoleAndExecutePersonService;
import com.jn.park.enums.CustomerCenterExceptionEnum;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangph
 * @Date: 2019/5/16 22:33
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "客服中心--添加执行部门和执行人（管理员使用）")
@RestController
@RequestMapping("/guest/clientRoleAndExecutePersonController")
public class ClientRoleAndExecutePersonController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ClientRoleAndExecutePersonController.class);

    @Autowired
    private ClientRoleAndExecutePersonService clientService;

    @ControllerLog(doAction = "添加角色和用户信息")
    @ApiOperation(value = "添加角色和用户信息")
    @RequestMapping(value = "/addRoleAndExecutePersonInfo",method = RequestMethod.POST)
    public Result<Integer> addRoleAndExecutePersonInfo(String roleName) {
        //获取当前登录用户基本信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("园区用户咨询客服获取当前登录用户信息失败");
            return new Result(CustomerCenterExceptionEnum.NETWORK_ANOMALY.getCode(),CustomerCenterExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        int  result=clientService.addRoleAndExecutePersonInfo(roleName,user.getAccount());
        logger.info("----------添加角色和用户信息成功，数据响应条数：{}-----------",result);
        return new Result<>(result);
    }
}
