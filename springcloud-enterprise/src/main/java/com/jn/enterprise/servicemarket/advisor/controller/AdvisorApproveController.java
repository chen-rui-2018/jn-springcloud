package com.jn.enterprise.servicemarket.advisor.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.enterprise.servicemarket.advisor.model.OrgInfoShow;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorApproveService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/4/9 9:46
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "用户中心--角色认证--服务专员认证--选择机构")
@RestController
@RequestMapping(value = "/serviceMarket/advisorApproveController")
public class AdvisorApproveController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(AdvisorApproveController.class);

    @Autowired
    private AdvisorApproveService advisorApproveService;

    @ControllerLog(doAction = "选择机构")
    @RequiresPermissions("/serviceMarket/advisorApproveController/selectOrgInfo")
    @ApiOperation(value = "选择机构",notes = "根据输入的机构名称模糊查询系统中可供选择的机构")
    @RequestMapping(value = "/selectOrgInfo",method = RequestMethod.GET)
    public Result<List<OrgInfoShow>> selectOrgInfo(@ApiParam(value = "服务机构名称" ,example = "xxx机构") @RequestParam("orgName") String orgName){
        return  new Result(advisorApproveService.selectOrgInfo(orgName));
    }



}
