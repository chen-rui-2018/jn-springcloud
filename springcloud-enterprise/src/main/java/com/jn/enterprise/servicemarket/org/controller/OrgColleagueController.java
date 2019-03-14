package com.jn.enterprise.servicemarket.org.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.servicemarket.org.model.OrgColleagueParam;
import com.jn.enterprise.servicemarket.org.service.OrgColleagueService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangph
 * @Date: 2019/2/26 9:44
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "机构同事")
@RestController
@RequestMapping(value = "/serviceMarket/orgColleagueController")
public class OrgColleagueController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(OrgColleagueController.class);

    @Autowired
    private OrgColleagueService orgColleagueService;

    @ControllerLog(doAction = "机构同事列表查询")
    @ApiOperation(value = "机构同事列表查询", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getOrgColleagueList")
    @RequiresPermissions("/serviceMarket/orgColleagueController/getOrgColleagueList")
    public Result getOrgColleagueList(@RequestBody OrgColleagueParam orgColleagueParam){
        //获取当前登录用户基本信息
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user==null){
            logger.warn("机构同事查询获取当前登录用户信息失败");
            return new Result(OrgExceptionEnum.NETWORK_ANOMALY.getCode(),OrgExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        orgColleagueService.getOrgColleagueList(user.getAccount(), orgColleagueParam);
        return new Result();
    }

    @ControllerLog(doAction = "设置为联系人")
    @ApiOperation(value = "设置为联系人", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/setAsContact")
    @RequiresPermissions("/serviceMarket/orgColleagueController/setAsContact")
    public Result setAsContact(@ApiParam(value = "设置为联系人的账号" ,required = true) @RequestBody  String account){
        Assert.notNull(account, OrgExceptionEnum.ACCOUNT_NOT_NULL.getMessage());
        orgColleagueService.setAsContact(account);
        return new Result();
    }

    @ControllerLog(doAction = "取消为联系人")
    @ApiOperation(value = "取消为联系人", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/cancelAsContact")
    @RequiresPermissions("/serviceMarket/orgColleagueController/cancelAsContact")
    public Result cancelAsContact(@ApiParam(value = "取消联系人的账号" ,required = true) @RequestBody  String account){
        Assert.notNull(account, OrgExceptionEnum.ACCOUNT_NOT_NULL.getMessage());
        orgColleagueService.cancelAsContact(account);
        return new Result();
    }

    @ControllerLog(doAction = "删除联系人或顾问")
    @ApiOperation(value = "删除联系人或顾问", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/deleteContactOrAdvisor")
    @RequiresPermissions("/serviceMarket/orgColleagueController/deleteContactOrAdvisor")
    public Result deleteContactOrAdvisor(@ApiParam(value = "删除联系人或顾问的账号" ,required = true) @RequestBody  String account){
        Assert.notNull(account, OrgExceptionEnum.ACCOUNT_NOT_NULL.getMessage());
        //获取当前登录用户基本信息
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user==null){
            logger.warn("机构同事查询获取当前登录用户信息失败");
            return new Result(OrgExceptionEnum.NETWORK_ANOMALY.getCode(),OrgExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        orgColleagueService.deleteContactOrAdvisor(user.getAccount(),account);
        return new Result();
    }


}
