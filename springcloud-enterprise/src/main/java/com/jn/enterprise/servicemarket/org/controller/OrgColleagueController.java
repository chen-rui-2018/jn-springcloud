package com.jn.enterprise.servicemarket.org.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.servicemarket.model.OrgColleagueQuery;
import com.jn.enterprise.servicemarket.org.service.OrgColleagueService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    public Result getOrgColleagueList(@RequestBody OrgColleagueQuery orgColleagueQuery){
        //获取当前登录用户基本信息
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user==null){
            logger.warn("机构同事查询获取当前登录用户信息失败");
            return new Result(OrgExceptionEnum.NETWORK_ANOMALY.getCode(),OrgExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        orgColleagueService.getOrgColleagueList(user.getAccount(),orgColleagueQuery);
        return new Result();
    }
}
