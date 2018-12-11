package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.user.userinfo.api.UserExtensionClient;
import com.jn.user.userinfo.model.UserExtension;
import com.jn.user.userinfo.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供内部使用的API接口
 * @Author: yangph
 * @Date: 2018/11/28 19:32
 * @Version v1.0
 * @modified By:
 */
@RestController
@RequestMapping("/api/user")
public class UserExtensionController extends BaseController implements UserExtensionClient {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(UserExtensionController.class);

    @Autowired
    private UserInfoService userInfoService;



    @ControllerLog(doAction = "获取登录用户扩展信息")
    @ApiOperation(value = "获取登录用户扩展信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getUserExtension")
    @Override
    public Result<UserExtension> getUserExtension(@RequestBody String account) {
        Assert.notNull(account,"用户账号不能为空");
        Result<UserExtension> result=new Result();
        UserExtension userExtension = userInfoService.getUserInfo(account);
        result.setData(userExtension);
        return result;
    }
}
