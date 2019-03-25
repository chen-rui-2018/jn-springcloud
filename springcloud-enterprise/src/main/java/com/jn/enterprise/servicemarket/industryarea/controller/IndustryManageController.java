package com.jn.enterprise.servicemarket.industryarea.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.servicemarket.industryarea.model.Industry;
import com.jn.enterprise.servicemarket.industryarea.model.IndustryData;
import com.jn.enterprise.servicemarket.industryarea.model.IndustryParameter;
import com.jn.enterprise.servicemarket.industryarea.service.IndustryService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 行业领域管理
 * @author： jiangyl
 * @date： Created on 2019/2/27 11:01
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "行业领域管理")
@RestController
@RequestMapping(value = "/serviceMarket/industryManage")
public class IndustryManageController extends BaseController {

    @Autowired
    private IndustryService industryService;

    @ControllerLog(doAction = "行业领域列表")
    @ApiOperation(value = "行业领域列表")
    @RequestMapping(value = "/selectIndustryList",method = RequestMethod.GET)
    @RequiresPermissions("/serviceMarket/industryManage/selectIndustryList")
    public Result<PaginationData<List<Industry>>> selectIndustryList(@Validated IndustryParameter industryParameter){
        PaginationData paginationData = industryService.selectIndustryList(industryParameter);
        return new Result(paginationData);
    }


    @ControllerLog(doAction = "新增行业领域")
    @ApiOperation(value = "新增行业领域")
    @RequestMapping(value = "/saveIndustry",method = RequestMethod.POST)
    @RequiresPermissions("/serviceMarket/industryManage/saveIndustry")
    public Result<Boolean> saveIndustry(@RequestBody @Validated IndustryData industryData){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        Boolean b = industryService.saveOrUpdateIndustry(industryData,user.getAccount());
        return new Result(b);
    }

    @ControllerLog(doAction = "修改行业领域")
    @ApiOperation(value = "修改行业领域")
    @RequestMapping(value = "/updateIndustry",method = RequestMethod.POST)
    @RequiresPermissions("/serviceMarket/industryManage/updateIndustry")
    public Result<Boolean> updateIndustry(@RequestBody @Validated IndustryData industryData){
        Assert.notNull(industryData.getId(), OrgExceptionEnum.PRE_ID_IS_NOT_NULL.getMessage());
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        Boolean b = industryService.saveOrUpdateIndustry(industryData,user.getAccount());
        return new Result(b);
    }

    @ControllerLog(doAction = "行业领域详情")
    @ApiOperation(value = "行业领域详情")
    @RequestMapping(value = "/getIndustryDetail",method = RequestMethod.GET)
    @RequiresPermissions("/serviceMarket/industryManage/getIndustryDetail")
    public Result<Industry> getIndustryDetail(@ApiParam(value = "领域id" ,required = true,example = "ogistics") @RequestParam(value = "id") String id){
        Assert.notNull(id, OrgExceptionEnum.PRE_ID_IS_NOT_NULL.getMessage());
        Industry industryDetail = industryService.getIndustryDetail(id);
        return new Result(industryDetail);
    }

}
