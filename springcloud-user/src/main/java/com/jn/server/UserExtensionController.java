package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserAffiliateInfo;
import com.jn.user.model.UserCompanyInfo;
import com.jn.user.model.UserExtensionInfo;
import com.jn.user.userinfo.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public Result<UserExtensionInfo> getUserExtension(@RequestBody String account) {
        Assert.notNull(account,"用户账号不能为空");
        Result<UserExtensionInfo> result=new Result();
        UserExtensionInfo userExtension = userInfoService.getUserExtension(account);
        if(userExtension!=null){
            result.setData(userExtension);
        }
        return result;
    }


    @ControllerLog(doAction = "批量获取用户的扩展信息")
    @ApiOperation(value = "批量获取用户的扩展信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getMoreUserExtension")
    @Override
    public Result<List<UserExtensionInfo>>getMoreUserExtension(@RequestBody List<String> accountList){
        Assert.notNull(accountList, "用户账号不能为空");
        Result<List<UserExtensionInfo>> result=new Result();
        List<UserExtensionInfo> userExtensionList=userInfoService.getMoreUserExtension(accountList);
        if(userExtensionList!=null) {
            result.setData(userExtensionList);
        }
        return result;
    }

    @ControllerLog(doAction = "更新用户所属机构信息")
    @ApiOperation(value = "更新用户所属机构信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/updateAffiliateInfo")
    @Override
    public Result updateAffiliateInfo(UserAffiliateInfo userAffiliateInfo) {
        boolean updateSuccess = userInfoService.updateAffiliateInfo(userAffiliateInfo);
        return new Result(updateSuccess);
    }

    @ControllerLog(doAction = "更新用户所属企业信息")
    @ApiOperation(value = "更新用户所属企业信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/updateCompanyInfo")
    @Override
    public Result updateCompanyInfo(UserCompanyInfo userCompanyInfo) {
        boolean updateSuccess = userInfoService.updateCompanyInfo(userCompanyInfo);
        return new Result(updateSuccess);
    }
}
