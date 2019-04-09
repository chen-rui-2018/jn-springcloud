package com.jn.enterprise.data.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.data.model.*;
import com.jn.enterprise.data.vo.GroupInfoVO;
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
@Api(tags="数据上报-企业群组/园区预警人维护")
@RestController
@RequestMapping(value="/data")
public class EnterpriseGroupController  extends BaseController {


    @ControllerLog(doAction = "数据上报-企业群组-树形列获取")
    @ApiOperation(value = "企业群组树形列获取",notes = "返回群组树")
    @GetMapping(value = "/group/getTree")
    @RequiresPermissions("/data/group/getTree")
    public Result<List<GroupModel>> getTree(){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-企业群组-信息获取")
    @GetMapping(path = "/group/getGoupInfo")
    @ApiOperation(value = "获取群组的基本信息" ,notes="返回群组的基本信息")
    @RequiresPermissions("/data/group/getGoupInfo")
    @ApiImplicitParams({
            @ApiImplicitParam( name="groupId" ,value = "群组ID",dataType = "String",paramType = "query",example = "1" )
    })
    public Result<GroupInfoVO> getGroupInfo(String groupId){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-企业群组-树中添加群组")
    @PostMapping(path = "/group/saveTreeLeaf")
    @ApiOperation(value = "企业群组树中添加群组",notes = "返回保存结果")
    @RequiresPermissions("/data/group/saveTreeLeaf")
    public Result<GroupInfoVO> saveTreeLeaf(){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-企业群组-模板录入下载")
    @GetMapping(path = "/group/downloadTemp")
    @ApiOperation(value = "企业群组模板录入下载",notes = "返回模板文件")
    @RequiresPermissions("/data/group/downloadTemp")
    public Result downloadTemp(){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-企业群组-企业列表获取")
    @GetMapping(path = "/group/getGroupCompanies")
    @ApiOperation(value = "企业群组企业列表获取",notes = "返回企业列表")
    @RequiresPermissions("/data/group/getGroupCompanies")
    public Result<PaginationData<List<GroupCompanyModel>>> getGroupCompanies(@ModelAttribute GroupCompanyParamModel param){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-企业群组-企业批量作废")
    @PostMapping(path = "/group/invalidCompanyFromGroup")
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
    @PostMapping(path = "/group/validCompanyFromGroup")
    @ApiOperation(value = "企业恢复",notes = "返回恢复结果")
    @RequiresPermissions("/data/group/validCompanyFromGroup")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", dataType = "String" ,value = "群组ID",paramType = "query",example = "123"),
            @ApiImplicitParam(name = "companyId", dataType = "String" ,value = "企业ID",paramType = "query",example = "123")
    })
    public Result validCompanyFromGroup(String groupId,String companyId){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-企业群组-企业导出")
    @GetMapping(path = "/group/exportCompany")
    @ApiOperation(value = "企业导出",notes = "返回excel文件")
    @RequiresPermissions("/data/group/exportCompany")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId",dataType = "String" ,value = "群组ID" ,paramType = "query",example = "123"),
    })
    public Result exportCompany(String groupId){
        return new Result();
    }


    @ControllerLog(doAction = "数据上报-园区预警人维护-部门预警人列表")
    @GetMapping(value="/reminder/getList")
    @ApiOperation(value = "部门预警人列表", notes = "返回部门预警人列表")
    @RequiresPermissions("/finance/reminder/getList")
    public Result<PaginationData<List<ReminderModel>>> getList(@ModelAttribute ReminderParamModel reminder){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-园区预警人维护-预警人添加")
    @PostMapping(path="/reminder/saveReminder")
    @ApiOperation(value="预警人添加",notes = "返回成功与否")
    @ApiImplicitParams({
            @ApiImplicitParam(name="linkName",value = "预警人名称",dataType = "String",paramType = "query",example = "张三"),
            @ApiImplicitParam(name="departmentId",value = "部门ID",dataType = "String",paramType = "query",example = "1"),
            @ApiImplicitParam(name="departmentName",value = "部门名称",dataType = "String",paramType = "query",example = "1"),
            @ApiImplicitParam(name="linkAccount",value = "联系人账号",dataType = "String",paramType = "query",example = "101")
    })
    @RequiresPermissions("/finance/reminder/saveReminder")
    public Result saveReminder(String linkName,String departmentId,String linkAccount,String departmentName){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-园区预警人维护-作废/批量作废预警人")
    @PostMapping(path="/reminder/invalidReminder")
    @ApiOperation(value="预警人添加",notes = "返回成功与否")
    @ApiImplicitParams({
            @ApiImplicitParam(name="linkName",value = "预警人名称",dataType = "String",paramType = "query",example = "张三"),
            @ApiImplicitParam(name="departmentId",value = "部门ID",dataType = "String",paramType = "query",example = "1"),
            @ApiImplicitParam(name="linkAccount",value = "联系人账号",dataType = "String",paramType = "query",example = "101")
    })
    @RequiresPermissions("/finance/reminder/invalidReminder")
    public Result invalidReminder(String[] linkName,String departmentId,String linkAccount){
        return new Result();
    }


}
