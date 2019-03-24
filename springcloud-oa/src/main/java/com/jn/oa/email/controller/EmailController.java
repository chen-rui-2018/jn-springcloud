package com.jn.oa.email.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.common.util.StringUtils;
import com.jn.oa.email.model.EmailAdd;
import com.jn.oa.email.model.EmailPage;
import com.jn.oa.email.service.EmailService;
import com.jn.oa.email.vo.EmailVO;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author： shaobao
 * @date： Created on 2019/3/9 11:24
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "一键Email管理")
@RestController
@RequestMapping("/oa/email")
public class EmailController extends BaseController {

    @Autowired
    private EmailService emailService;

    @ControllerLog(doAction = "一键Email添加/编辑功能")
    @RequiresPermissions("/oa/email/addOrUpdate")
    @ApiOperation(value = "一键Email添加/编辑功能", httpMethod = "POST", response = Result.class)
    @RequestMapping("/addOrUpdate")
    public Result addOrUpdate(@Validated @RequestBody EmailAdd emailAdd) {
        //获取当前用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        //判断是添加操作还是编辑操作
        Boolean isAdd = StringUtils.isBlank(emailAdd.getId()) ? true : false;
        if (isAdd) {
            //设置id
            emailAdd.setId(UUID.randomUUID().toString());
        }

        emailService.addOrUpdate(emailAdd, user, isAdd);
        return new Result();
    }

    @ControllerLog(doAction = "用户手动一键发送邮件")
    @RequiresPermissions("/oa/email/sendEmailManual")
    @ApiOperation(value = "用户手动一键发送邮件", httpMethod = "POST", response = Result.class)
    @RequestMapping("/sendEmailManual")
    public Result sendEmailManual(String emailId) {
        //获取当前用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        emailService.sendEmailManual(emailId, user);
        return new Result();
    }

    @ControllerLog(doAction = "一键Email列表功能")
    @RequiresPermissions("/oa/email/list")
    @ApiOperation(value = "一键Email列表功能", httpMethod = "POST", response = Result.class)
    @RequestMapping("/list")
    public Result list(@Validated @RequestBody EmailPage emailPage) {
        PaginationData data = emailService.list(emailPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "查看邮件任务详情功能")
    @RequiresPermissions("/oa/email/getEmailDetails")
    @ApiOperation(value = "查看邮件任务详情功能", httpMethod = "POST", response = Result.class)
    @RequestMapping("/getEmailDetails")
    public Result getEmailDetails(String emailId) {
        EmailVO emailVO = emailService.getEmailDetails(emailId);
        return new Result(emailVO);
    }

    @ControllerLog(doAction = "(逻辑)批量删除邮件任务")
    @RequiresPermissions("/oa/email/deleteBatch")
    @ApiOperation(value = "(逻辑)批量删除邮件任务", httpMethod = "POST", response = Result.class)
    @RequestMapping("/deleteBatch")
    public Result deleteBatch(@RequestParam("emailIds") String[] emailIds) {
        Assert.noNullElements(emailIds, "删除邮件不能为空");

        //获取当前用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        emailService.deleteBatch(emailIds, user);
        return new Result();
    }

}
