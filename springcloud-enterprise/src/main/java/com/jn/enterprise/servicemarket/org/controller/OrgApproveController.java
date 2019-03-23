package com.jn.enterprise.servicemarket.org.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.servicemarket.org.model.OrgApplyCheckData;
import com.jn.enterprise.servicemarket.org.model.OrgApplyParameter;
import com.jn.enterprise.servicemarket.org.service.OrgApproveService;
import com.jn.enterprise.servicemarket.org.vo.OrgApplyCountVo;
import com.jn.enterprise.servicemarket.org.vo.OrgApplyDetailVo;
import com.jn.enterprise.servicemarket.org.vo.OrgApplyVo;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation(value = "查询机构审核认证列表",notes = "返回数据响应条数，正常情况为1")
    @RequestMapping(value = "/getOrgApplyList",method = RequestMethod.GET)
    @RequiresPermissions("/serviceMarket/OrgApproveController/getOrgApplyList")
    public Result<PaginationData<List<OrgApplyVo>>> getOrgApplyList(@Validated OrgApplyParameter orgApplyParameter){
        PaginationData<List<OrgApplyVo>> orgApplyList = orgApproveService.getOrgApplyList(orgApplyParameter);
        logger.info("查询机构审核认证列表成功，响应条数："+orgApplyList.getTotal());
        return new Result<>(orgApplyList);
    }

    @ControllerLog(doAction = "查询机构入驻数据")
    @ApiOperation(value = "查询机构入驻数据")
    @RequestMapping(value = "/getOrgCount",method = RequestMethod.GET)
    @RequiresPermissions("/serviceMarket/OrgApproveController/getOrgCount")
    public Result<OrgApplyCountVo> getOrgCount(){
        OrgApplyCountVo orgCount = orgApproveService.getOrgCount();
        return new Result<>(orgCount);
    }

    @ControllerLog(doAction = "查询机构审核详情")
    @ApiOperation(value = "查询机构审核详情")
    @RequestMapping(value = "/getOrgApplyDetail",method = RequestMethod.GET)
    @RequiresPermissions("/serviceMarket/OrgApproveController/getOrgApplyDetail")
    public Result<OrgApplyDetailVo> getOrgApplyDetail(@ApiParam(name="orgId",value = "orgId:机构ID",required = true)@RequestParam(value = "orgId") String orgId){
        Assert.notNull(orgId, OrgExceptionEnum.ORG_ID_IS_NOT_NULL.getMessage());
        OrgApplyDetailVo orgApplyDetailVo = orgApproveService.getOrgApplyDetail(orgId);
        return new Result<>(orgApplyDetailVo);
    }

    @ControllerLog(doAction = "服务机构申请审核")
    @ApiOperation(value = "服务机构申请审核")
    @RequestMapping(value = "/checkOrgApply",method = RequestMethod.POST)
    @RequiresPermissions("/serviceMarket/OrgApproveController/checkOrgApply")
    public Result<Boolean> checkOrgApply(@RequestBody OrgApplyCheckData orgApplyCheckData){
        Boolean aBoolean = orgApproveService.checkOrgApply(orgApplyCheckData);
        return new Result<>(aBoolean);
    }

}
