package com.jn.user.userjoin.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.common.util.StringUtils;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.user.userjoin.enums.UserJoinExceptionEnum;
import com.jn.user.userjoin.model.UserRegister;
import com.jn.user.userjoin.service.UserJoinService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户注册
 *
 * @author： lijun
 * @date： Created on 2019/2/27 21:19
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "加入园区")
@RestController
@RequestMapping("/guest/userJoin")
public class UserJoinController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(UserJoinController.class);

    @Autowired
    private UserJoinService userJoinService;

    @ControllerLog(doAction = "获取短信验证码")
    @ApiOperation(value = "获取短信验证码",httpMethod = "POST",response = Result.class)
    @RequestMapping(value = "/getCode")
    public Result getCode(@ApiParam(value = "手机号",required = true) @RequestParam String phone){
        Assert.notNull(phone, UserJoinExceptionEnum.MESSAGE_CODE_IS_WRONG.getMessage());
        userJoinService.getCode(phone);
        return new Result();
    }

    @ControllerLog(doAction = "用户注册")
    @ApiOperation(value = "用户注册",httpMethod = "POST",response = Result.class)
    @RequestMapping(value = "/addUser")
    public Result addUser(@RequestBody @Validated UserRegister userRegister){
        return userJoinService.addUser(userRegister);
    }


    @ControllerLog(doAction = "修改密码")
    @ApiOperation(value = "修改密码",httpMethod = "POST",response = Result.class)
    @RequestMapping(value = "/updatePassword")
    public Result updatePassword(@RequestBody @Validated UserRegister userRegister){
        return userJoinService.updateUser(userRegister);
    }

    @ControllerLog(doAction = "获取短信验证码[当前用户]")
    @ApiOperation(value = "获取短信验证码[当前用户]",httpMethod = "POST",response = Result.class)
    @RequestMapping(value = "/getUserCode")
    public Result getUserCode(){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        String phone = user.getPhone();
        userJoinService.getCode(phone);
        Result<String> result = new Result<>();
        result.setData("验证码发送成功。接收尾号:"+phone.substring((phone.length()>4)?phone.length()-4:0,phone.length()));
        return result;
    }

}
