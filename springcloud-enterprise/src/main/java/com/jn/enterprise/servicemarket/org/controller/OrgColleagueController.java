package com.jn.enterprise.servicemarket.org.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.servicemarket.org.model.OrgColleagueInfo;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @ApiOperation(value = "机构同事列表查询")
    @RequestMapping(value = "/getOrgColleagueList",method = RequestMethod.GET)
    @RequiresPermissions("/serviceMarket/orgColleagueController/getOrgColleagueList")
    public Result<PaginationData<List<OrgColleagueInfo>>> getOrgColleagueList(OrgColleagueParam orgColleagueParam){
        //获取当前登录用户基本信息
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user==null){
            logger.warn("机构同事查询获取当前登录用户信息失败");
            return new Result(OrgExceptionEnum.NETWORK_ANOMALY.getCode(),OrgExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        PaginationData orgColleagueList = orgColleagueService.getOrgColleagueList(user.getAccount(), orgColleagueParam);
        return new Result(orgColleagueList);
    }

    @ControllerLog(doAction = "设置为联系人")
    @ApiOperation(value = "设置为联系人",notes = "返回数据响应条数，正常情况为1")
    @RequestMapping(value = "/setAsContact",method = RequestMethod.POST)
    @RequiresPermissions("/serviceMarket/orgColleagueController/setAsContact")
    public Result setAsContact(@ApiParam(value = "设置为联系人的账号" ,required = true,example = "wangsong")String account){
        Assert.notNull(account, OrgExceptionEnum.ACCOUNT_NOT_NULL.getMessage());
        int responseNum = orgColleagueService.setAsContact(account);
        logger.info("------设置为联系人成功，数据响应条数：{}-------",responseNum);
        return  new Result(responseNum);
    }

    @ControllerLog(doAction = "取消联系人")
    @ApiOperation(value = "取消联系人",notes = "返回数据响应条数，正常情况为1")
    @RequestMapping(value = "/cancelAsContact",method = RequestMethod.POST)
    @RequiresPermissions("/serviceMarket/orgColleagueController/cancelAsContact")
    public Result cancelAsContact(@ApiParam(value = "取消联系人的账号" ,required = true,example = "wangsong")String account){
        Assert.notNull(account, OrgExceptionEnum.ACCOUNT_NOT_NULL.getMessage());
        int responseNum = orgColleagueService.cancelAsContact(account);
        logger.info("------取消联系人成功，数据响应条数：{}-------",responseNum);
        return  new Result(responseNum);
    }

    @ControllerLog(doAction = "删除联系人或顾问")
    @ApiOperation(value = "删除联系人或顾问",notes = "返回数据响应条数，正常情况为1")
    @RequestMapping(value = "/deleteContactOrAdvisor",method = RequestMethod.POST)
    @RequiresPermissions("/serviceMarket/orgColleagueController/deleteContactOrAdvisor")
    public Result deleteContactOrAdvisor(@ApiParam(value = "删除联系人或顾问的账号" ,required = true,example = "wangsong")String account){
        Assert.notNull(account, OrgExceptionEnum.ACCOUNT_NOT_NULL.getMessage());
        //获取当前登录用户基本信息
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user==null){
            logger.warn("机构同事查询获取当前登录用户信息失败");
            return new Result(OrgExceptionEnum.NETWORK_ANOMALY.getCode(),OrgExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        int responseNum = orgColleagueService.deleteContactOrAdvisor(user.getAccount(), account);
        logger.info("------删除联系人或顾问成功，数据响应条数：{}-------",responseNum);
        return  new Result(responseNum);
    }


}
