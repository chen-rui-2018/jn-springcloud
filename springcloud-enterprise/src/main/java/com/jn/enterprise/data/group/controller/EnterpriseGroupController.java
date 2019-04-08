package com.jn.enterprise.data.group.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.data.vo.GroupCompanyList;
import com.jn.enterprise.data.vo.GroupCompanyParam;
import com.jn.enterprise.data.vo.GroupInfo;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author： yangh
 * @date： Created on 2019/4/4 10:48
 * @version： v1.0
 * @modified By:
 */
@Api(tags="数据上报-企业群组维护")
@RestController
@RequestMapping(value="/data/group")
public class EnterpriseGroupController  extends BaseController {

    @ControllerLog(doAction = "数据上报-企业群组-树形列获取")
    @ApiOperation(value = "企业群组树形列获取",notes = "返回群组树")
    @GetMapping(value = "/getTree")
    @RequiresPermissions("/data/group/getTree")
    public Result getTree(){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-企业群组-信息获取")
    @GetMapping(path = "/getGoupInfo")
    @ApiOperation(value = "获取群组的基本信息" ,notes="返回群组的基本信息")
    @RequiresPermissions("/data/group/getGoupInfo")
    @ApiImplicitParams({
            @ApiImplicitParam( name="groupId" ,value = "群组ID",dataType = "String",paramType = "query",example = "1" )
    })
    public Result<GroupInfo> getGroupInfo(String groupId){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-企业群组-树中添加群组")
    @PostMapping(path = "/saveTreeLeaf")
    @ApiOperation(value = "企业群组树中添加群组",notes = "返回保存结果")
    @RequiresPermissions("/data/group/saveTreeLeaf")
    public Result<GroupInfo> saveTreeLeaf(){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-企业群组-模板录入下载")
    @GetMapping(path = "/downloadTemp")
    @ApiOperation(value = "企业群组模板录入下载",notes = "返回模板文件")
    @RequiresPermissions("/data/group/downloadTemp")
    public Result downloadTemp(){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-企业群组-企业列表获取")
    @GetMapping(path = "/getGroupCompanies")
    @ApiOperation(value = "企业群组企业列表获取",notes = "返回企业列表")
    @RequiresPermissions("/data/group/getGroupCompanies")
    public Result<PaginationData<List<GroupCompanyList>>> getGroupCompanies(@ModelAttribute GroupCompanyParam param){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-企业群组-企业批量作废")
    @PostMapping(path = "/invalidCompanyFromGroup")
    @ApiOperation(value = "企业群组企业批量作废",notes = "返回作废结果")
    @RequiresPermissions("/data/group/invalidCompanyFromGroup")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", dataType = "String" ,value = "群组ID",paramType = "query",example = "123"),
            @ApiImplicitParam(name = "companyId", dataType = "String" ,allowMultiple=true,value = "企业ID",paramType = "query",example = "123")
    })
    public Result invalidCompanyFromGroup(String groupId,String companyId[]){
        return new Result();
    }


    @ControllerLog(doAction = "数据上报-企业群组-企业恢复")
    @PostMapping(path = "/invalidCompanyFromGroup")
    @ApiOperation(value = "企业恢复",notes = "返回恢复结果")
    @RequiresPermissions("/data/group/invalidCompanyFromGroup")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", dataType = "String" ,value = "群组ID",paramType = "query",example = "123"),
            @ApiImplicitParam(name = "companyId", dataType = "String" ,value = "企业ID",paramType = "query",example = "123")
    })
    public Result validCompanyFromGroup(String groupId,String companyId){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-企业群组-企业导出")
    @GetMapping(path = "/exportCompany")
    @ApiOperation(value = "企业导出",notes = "返回excel文件")
    @RequiresPermissions("/data/group/exportCompany")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId",dataType = "String" ,value = "群组ID" ,paramType = "query",example = "123"),
    })
    public Result exportCompany(String groupId){
        return new Result();
    }

}
