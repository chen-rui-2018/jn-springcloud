package com.jn.user.userinfo.controller;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.user.enums.UserExtensionExceptionEnum;
import com.jn.user.userinfo.model.UserDeviceParam;
import com.jn.user.userinfo.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息
 * @Author: jiangyl
 * @Date: 2018/12/10 11:29
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "用户信息")
@RestController
@RequestMapping("/user/userInfo")
public class UserPersonController {

    @Autowired
    public UserInfoService userInfoService;

    @ControllerLog(doAction = "保存用户极光推送注册ID")
    @ApiOperation(value = "保存用户极光推送注册ID", notes = "正常返回结果为1")
    @RequestMapping(value = "/saveRegistrationId",method = RequestMethod.POST)
    public Result<Integer> saveRegistrationId(@Validated @RequestBody UserDeviceParam userDeviceParam) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user == null) {
            throw new JnSpringCloudException(UserExtensionExceptionEnum.USER_LOGIN_IS_INVALID);
        }
        userDeviceParam.setAccount(user.getAccount());
        int i = userInfoService.saveRegistrationId(userDeviceParam);
        return new Result(i);
    }
}
