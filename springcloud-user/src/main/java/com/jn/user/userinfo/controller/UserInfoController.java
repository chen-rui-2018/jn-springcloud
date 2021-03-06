package com.jn.user.userinfo.controller;

import com.jn.common.model.Result;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.user.model.UserExtensionInfo;
import com.jn.user.userinfo.model.UserInfoParam;
import com.jn.user.userinfo.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
 * @modified By:yangph 把guest请求修改为需要登录认证的请求
 */
@Api(tags = "用户信息")
@RestController
@RequestMapping("/user/userInfo")
public class UserInfoController {
    @Autowired
    public UserInfoService userInfoService;

    @ControllerLog(doAction = "保存用户资料")
    @ApiOperation(value = "保存用户资料")
    @RequiresPermissions("/user/userInfo/saveUserInfo")
    @RequestMapping(value = "/saveUserInfo",method = RequestMethod.POST)
    public Result<Integer> saveUserInfo(@RequestBody @Validated UserInfoParam userInfoParam) {
        User currentUser=(User) SecurityUtils.getSubject().getPrincipal();
        User user = new User();
        user.setAccount(currentUser.getAccount());
        int i = userInfoService.saveOrUpdateUserInfo(userInfoParam,user);
        return new Result(i);
    }

    @ControllerLog(doAction = "获取当前前户资料")
    @ApiOperation(value = "获取当前用户资料")
    @RequiresPermissions("/user/userInfo/getUserExtension")
    @RequestMapping(value = "/getUserExtension",method = RequestMethod.GET)
    public Result<UserExtensionInfo> getUserExtension(){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        UserExtensionInfo userExtension = userInfoService.getUserExtension(null==user?null:user.getAccount());
        return new Result(userExtension);
    }

}
