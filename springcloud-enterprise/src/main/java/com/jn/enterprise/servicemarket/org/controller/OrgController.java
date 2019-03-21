package com.jn.enterprise.servicemarket.org.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.servicemarket.org.model.OrgDetail;
import com.jn.enterprise.servicemarket.org.model.OrgParameter;
import com.jn.enterprise.servicemarket.org.service.OrgService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务机构
 * @Author: jiangyl
 * @Date: 2019/2/13 10:43
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "服务机构(前台用户)")
@RestController
@RequestMapping(value = "/guest/serviceMarket/org")
public class OrgController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(OrgController.class);

    @Autowired
    private OrgService orgService;


    @ControllerLog(doAction = "获取服务机构列表(app+pc)")
    @ApiOperation(value = "获取服务机构列表", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/selectServiceOrgList")
    @RequiresPermissions("/serviceMarket/org/selectServiceOrgList")
    public Result selectServiceOrgList(@RequestBody @Validated OrgParameter orgParameter){
        PaginationData paginationData = orgService.selectServiceOrgList(orgParameter);
        return new Result(paginationData);
    }

    @ControllerLog(doAction = "获取服务机构详情")
    @ApiOperation(value = "获取服务机构详情,(app机构详情)", httpMethod = "POST", response = Result.class,
            notes = "查询条件orgId")
    @RequestMapping(value = "/getActivityDetailsForManage")
    @RequiresPermissions("/serviceMarket/org/getActivityDetailsForManage")
    public Result getServiceOrgDetail(@ApiParam(name="orgId",value = "服务机构ID",required = true)@RequestParam(value = "orgId")  String orgId){
        Assert.notNull(orgId, OrgExceptionEnum.ORG_ID_IS_NOT_NULL.getMessage());
        return new Result(orgService.getServiceOrgDetail(orgId));
    }

    @ControllerLog(doAction = "获取服务机构详情+产品列表")
    @ApiOperation(value = "获取服机构信息(app机构信息)", httpMethod = "POST", response = Result.class,
            notes = "查询条件orgId")
    @RequestMapping(value = "/getOrgInfoForManage")
    @RequiresPermissions("/serviceMarket/org/getOrgInfoForManage")
    public Result getOrgInfoForManage(@ApiParam(name="orgId",value = "服务机构ID",required = true)@RequestParam(value = "orgId")  String orgId){
        Assert.notNull(orgId, OrgExceptionEnum.ORG_ID_IS_NOT_NULL.getMessage());
        OrgDetail orgDetail = orgService.getServiceOrgDetail(orgId);

        return new Result(orgService.getServiceOrgDetail(orgId));
    }

}
