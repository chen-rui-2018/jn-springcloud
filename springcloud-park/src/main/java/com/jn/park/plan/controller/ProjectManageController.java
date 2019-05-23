package com.jn.park.plan.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.park.finance.enums.FinanceBudgetExceptionEnums;
import com.jn.park.message.model.AddMessageModel;
import com.jn.park.message.model.FindAllMessageListVo;
import com.jn.park.message.model.MessageListModel;
import com.jn.park.message.service.MessageListService;
import com.jn.park.plan.model.*;
import com.jn.park.plan.service.ProjectManageService;
import com.jn.park.plan.vo.ProjectPlanVo;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author： tangry
 * @date： Created on 2019/4/19
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "规划建设-工程项目管理")
@RestController
@RequestMapping("/planning/project")
public class ProjectManageController extends BaseController {

    protected User getUser(){
        return  (User) SecurityUtils.getSubject().getPrincipal();
    }

    @Autowired
    private ProjectManageService projectManageService;

    @ControllerLog(doAction = "工程项目管理")
    @ApiOperation(value = "工程项目管理",notes = "工程项目管理页面小方块中的数据", httpMethod = "GET")
    @GetMapping(value = "/findAll")
    @RequiresPermissions("/planning/project/findAll")
    public Result<PaginationData<List<ProjectManageModel>> > findAll(ProjectModel projectModel){
        //输入类型限制只能输入 0 1 2
        if(StringUtils.isNotBlank(projectModel.getProjectState())){
            checkIsType(projectModel.getProjectState());
        }
        if(StringUtils.isNotBlank(projectModel.getProgress())){
            checkIsType(projectModel.getProgress());
        }
        PaginationData findAll=projectManageService.findAll(projectModel);

       return new Result(findAll);
    }

    @ControllerLog(doAction = "工程项目查看-任务信息")
    @ApiOperation(value = "工程项目查看-任务信息",notes = "工程项目查看页面最上面模块的子任务信息", httpMethod = "GET")
    @GetMapping(value = "/findProjectTask")
    @RequiresPermissions("/planning/project/findProjectTask")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "projectNo",value = "工程项目编号",dataType = "String",paramType = "query",example = "CS201904230001")
    })
    public Result<ProjectTaskModel> findProjectTask(String projectNo){

        List<ProjectTaskModel> findProjectTask=projectManageService.findProjectTask(projectNo);

        return new Result(findProjectTask);
    }


    @ControllerLog(doAction = "工程项目查看-任务进展")
    @ApiOperation(value = "工程项目查看-任务进展",notes = "工程项目查看页面中左放饼图", httpMethod = "GET")
    @GetMapping(value = "/findTaskPlan")
    @RequiresPermissions("/planning/project/findTaskPlan")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "projectNo",value = "工程项目编号",dataType = "String",paramType = "query",example = "CS201904230001")
    })
    public Result<List<ProjectPlanVo>> findTaskPlan(String projectNo){

        List<ProjectPlanVo> findTaskPlan=projectManageService.findTaskPlan(projectNo);

        return new Result(findTaskPlan);
    }

    @ControllerLog(doAction = "工程项目查看-完成及时率")
    @ApiOperation(value = "工程项目查看-完成及时率",notes = "工程项目查看页面中右柱状图", httpMethod = "GET")
    @GetMapping(value = "/findCompleteRatio")
    @RequiresPermissions("/planning/project/findCompleteRatio")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "projectNo",value = "工程项目编号",dataType = "String",paramType = "query",example = "CS201904230001")
    })
    public Result<ProjectCompleteRatioArrayModel> findCompleteRatio(String projectNo){

        ProjectCompleteRatioArrayModel findCompleteRatio=projectManageService.findCompleteRatio(projectNo);

        return new Result(findCompleteRatio);
    }




    /**
     * 检验输入的类型
     * @param type
     */
    private void checkIsType(String type){
        int i =Integer.parseInt(type);
        switch(i){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            default:
                throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"输入类型不正确,请确认");
        }

    }


}
