package com.jn.oa.message.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.hr.model.VacationManagement;
import com.jn.oa.leave.service.LeaveService;
import com.jn.oa.message.model.MessageCode;
import com.jn.oa.message.service.MessageService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 信息管理controller
 *
 * @author： yuanyy
 * @date： Created on 2019/6/22 10:40
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "信息管理")
@RestController
@RequestMapping("/guest/message")
public class MessageController extends BaseController {

    @Autowired
    private MessageService messageService;


    @ControllerLog(doAction = "发送指定验证码")
    @ApiOperation(value = "发送指定验证码", notes = "发送指定验证码")
    @PostMapping(value = "/sendMessageCode")
    public Result sendMessageCode(@Validated @RequestBody MessageCode messageCode) {
        messageService.sendMessageCode(messageCode);
        return new Result<>();
    }







}
