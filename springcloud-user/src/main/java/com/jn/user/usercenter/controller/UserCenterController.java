package com.jn.user.usercenter.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.user.model.UserExtensionInfo;
import com.jn.user.usercenter.model.ModifyPassword;
import com.jn.user.usercenter.service.UserCenterService;
import com.jn.user.usercenter.vo.UserCenterInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户中心
 *
 * @author： chenr
 * @date： Created on 2019/3/5 19:41
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "用户中心")
@RestController
@RequestMapping(value = "/user/center")
public class UserCenterController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(UserCenterController.class);
    @Autowired
    private UserCenterService userCenterService;

    @ControllerLog(doAction = "根据用户账号获取用户资料信息")
    @ApiOperation(value = "根据用户账号获取用户资料信息")
    @RequiresPermissions("/user/center/getUserPersonInfo")
    @RequestMapping(value = "/getUserPersonInfo",method = RequestMethod.GET)
    public Result<UserCenterInfoVo> getUserPersonInfo(@ApiParam(name = "account", value = "用户账号", required = true ,example = "wangsong") @RequestParam(value ="account") String account) {
        UserExtensionInfo userInfo = userCenterService.getUserExtension(account);
        if(userInfo == null ){
            return new Result();
        }
        UserCenterInfoVo vo= new UserCenterInfoVo();
        BeanUtils.copyProperties(userInfo,vo);
        return new Result(vo);
    }

    @ControllerLog(doAction = "修改用户密码")
    @ApiOperation(value = "修改用户密码", httpMethod = "POST", response = Result.class)
    @RequiresPermissions("/user/center/modifyUserPassword")
    @RequestMapping(value = "/modifyUserPassword")
    public Result modifyUserPassword(@Validated @RequestBody ModifyPassword user) {
        userCenterService.modifyUserPassword(user);
        return new Result();
    }
}
