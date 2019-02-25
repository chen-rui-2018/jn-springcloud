package com.jn.enterprise.servicemarket.org.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.servicemarket.model.*;
import com.jn.enterprise.servicemarket.org.service.OrgApproveService;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 服务机构认证(后台管理审核)
 * @author： jiangyl
 * @date： Created on 2019/2/21 15:40
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "服务机构认证(后台管理审核)")
@RestController
@RequestMapping(value = "/serviceMarket/OrgApproveController")
public class OrgApproveController extends BaseController{
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(OrgApproveController.class);

    @Autowired
    private OrgApproveService orgApproveService;

    @ControllerLog(doAction = "查询机构审核认证列表")
    @ApiOperation(value = "查询机构审核认证列表", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getOrgApplyList")
    @RequiresPermissions("/serviceMarket/OrgApproveController/getOrgApplyList")
    public Result getOrgApplyList(@RequestBody @Validated OrgApplyParameter orgApplyParameter){
        PaginationData orgApplyList = orgApproveService.getOrgApplyList(orgApplyParameter);
        logger.info("查询机构审核认证列表成功，响应条数："+orgApplyList.getTotal());
        return new Result(orgApplyList);
    }

    @ControllerLog(doAction = "查询机构入驻数据")
    @ApiOperation(value = "查询机构入驻数据", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getOrgCount")
    @RequiresPermissions("/serviceMarket/OrgApproveController/getOrgCount")
    public Result getOrgCount(){
        OrgApplyCount orgCount = orgApproveService.getOrgCount();
        return new Result(orgCount);
    }

    @ControllerLog(doAction = "查询机构审核详情")
    @ApiOperation(value = "查询机构审核详情", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getOrgApplyDetail")
    @RequiresPermissions("/serviceMarket/OrgApproveController/getOrgApplyDetail")
    public Result getOrgApplyDetail(@ApiParam(name="orgId",value = "orgId:机构ID",required = true)@RequestBody String orgId){
        Assert.notNull(orgId, OrgExceptionEnum.ORG_ID_IS_NOT_NULL.getMessage());
        OrgApplyDetail orgApplyDetail = orgApproveService.getOrgApplyDetail(orgId);
        return new Result(orgApplyDetail);
    }

}
