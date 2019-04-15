package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.enums.UserExtensionExceptionEnum;
import com.jn.user.model.*;
import com.jn.user.userinfo.service.UserInfoService;
import com.jn.user.userjoin.service.UserJoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
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
public class UserExtensionController extends BaseController implements UserExtensionClient {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(UserExtensionController.class);

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserJoinService userJoinService;

    @ControllerLog(doAction = "获取登录用户扩展信息")
    @Override
    public Result<UserExtensionInfo> getUserExtension(@RequestBody String account) {
        Assert.notNull(account, UserExtensionExceptionEnum.USER_ACCOUNT_NOT_NULL.getMessage());
        Result<UserExtensionInfo> result=new Result();
        UserExtensionInfo userExtension = userInfoService.getUserExtension(account);
        if(userExtension!=null){
            result.setData(userExtension);
        }
        return result;
    }


    @ControllerLog(doAction = "批量获取用户的扩展信息")
    @Override
    public Result<List<UserExtensionInfo>>getMoreUserExtension(@RequestBody List<String> accountList){
        Assert.notNull(accountList, UserExtensionExceptionEnum.USER_ACCOUNT_NOT_NULL.getMessage());
        Result<List<UserExtensionInfo>> result=new Result();
        List<UserExtensionInfo> userExtensionList=userInfoService.getMoreUserExtension(accountList);
        if(userExtensionList!=null) {
            result.setData(userExtensionList);
        }
        return result;
    }

    @ControllerLog(doAction = "更新用户所属机构信息")
    @Override
    public Result updateAffiliateInfo(@RequestBody @Validated UserAffiliateInfo userAffiliateInfo) {
        boolean updateSuccess = userInfoService.updateAffiliateInfo(userAffiliateInfo);
        return new Result(updateSuccess);
    }

    @ControllerLog(doAction = "更新用户所属企业信息")
    @Override
    public Result updateCompanyInfo(@RequestBody @Validated UserCompanyInfo userCompanyInfo) {
        boolean updateSuccess = userInfoService.updateCompanyInfo(userCompanyInfo);
        return new Result(updateSuccess);
    }

    @ControllerLog(doAction = "根据所属机构编码批量获取用户信息")
    @Override
    public Result getUserExtensionByAffiliateCode(@RequestBody @Validated AffiliateParam affiliateParam) {
        PaginationData paginationData=userInfoService.getUserExtensionByAffiliateCode(affiliateParam);
        return new Result(paginationData);
    }

    @ControllerLog(doAction = "根据所属机构编码批量获取用户信息")
    @Override
    public Result getUserExtensionByCompanyCode(@RequestBody @Validated CompanyParam companyParam) {
        PaginationData paginationData=userInfoService.getUserExtensionByCompanyCode(companyParam);
        return new Result(paginationData);
    }

    @ControllerLog(doAction = "通过手机号获取已发送的验证码")
    @Override
    public Result<String> getSendCodeByPhone(@RequestBody String phone){
        return new Result<>(userJoinService.getSendCodeByPhone(phone));
    }

}
