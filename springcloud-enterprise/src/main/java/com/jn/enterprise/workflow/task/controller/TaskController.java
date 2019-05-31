package com.jn.enterprise.workflow.task.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.company.enums.CompanyExceptionEnum;
import com.jn.enterprise.workflow.task.model.CommonTaskPage;
import com.jn.enterprise.workflow.task.model.TaskPage;
import com.jn.enterprise.workflow.task.model.TaskType;
import com.jn.enterprise.workflow.task.service.TaskService;
import com.jn.enterprise.workflow.task.vo.*;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 事项任务controller
 * @author： yuanyy
 * @date： Created on 2019/4/18 10:40
 * @version： v1.0
 * @modified By: huxw
 */
@Api(tags = "流程管理-事项任务")
@RestController
@RequestMapping("/enterprise/workflow/task")
public class TaskController extends BaseController {

    @Autowired
    private TaskService taskService;

    @ControllerLog(doAction = "时效性待办事项预警统计")
    @ApiOperation(value = "时效性待办事项预警统计", notes = "时效性待办事项预警数据统计")
    @PostMapping(value = "/getWorkflowTaskStatistics")
    @RequiresPermissions("/enterprise/workflow/task/getWorkflowTaskStatistics")
    public Result<TaskStatisticsVO> getWorkflowTaskStatistics() {
        User user = checkUserValid();
        return new Result(taskService.getWorkflowTaskStatistics(user.getId()));
    }

    @ControllerLog(doAction = "查询时效性事项任务列表")
    @ApiOperation(value = "查询时效性事项任务列表", notes = "根据事项状态查询待办事项、已办事项，1：待办，2：已办")
    @PostMapping(value = "/searchWorkflowTaskListByUser")
    @RequiresPermissions("/enterprise/workflow/task/searchWorkflowTaskListByUser")
    public Result<List<TaskTypeVo> > searchWorkflowTaskListByUser(@Validated @RequestBody TaskType taskType) {
        User user = checkUserValid();
        taskType.setUserId(user.getId());
        List<TaskTypeVo>  data =taskService.searchWorkflowTaskTypeListByCondition(taskType);
        return new Result(data);
    }

    @ControllerLog(doAction = "分页查询时效性事项任务列表")
    @ApiOperation(value = "分页查询时效性事项任务列表", notes = "根据用户与事项分类分页查询事项任务列表")
    @PostMapping(value = "/searchWorkflowTaskListByPage")
    @RequiresPermissions("/enterprise/workflow/task/searchWorkflowTaskListByPage")
    public Result<List<TaskVo>> searchWorkflowTaskListByPage(@Validated @RequestBody TaskPage taskPage) {
        User user = checkUserValid();
        taskPage.setUserId(user.getId());
        PaginationData data = taskService.searchWorkflowTaskListByPage(taskPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "查询常规待办事项")
    @ApiOperation(value = "查询常规待办事项",notes = "查询常规待办事项列表")
    @PostMapping(value = "/searchCommonWorkflowTaskList")
    @RequiresPermissions("/enterprise/workflow/task/searchCommonWorkflowTaskList")
    public Result<List<CommonTaskListVO>> searchCommonWorkflowTaskList() {
        User user = checkUserValid();
        return new Result(taskService.searchCommonWorkflowTaskList(user.getAccount()));
    }

    @ControllerLog(doAction = "分页查询常规具体待办事项")
    @ApiOperation(value = "分页查询常规具体待办事项",notes = "分页查询常规具体待办事项列表")
    @PostMapping(value = "/searchCommonWorkflowTaskListByTaskId")
    @RequiresPermissions("/enterprise/workflow/task/searchCommonWorkflowTaskListByTaskId")
    public Result<List<CommonTaskVO>> searchCommonWorkflowTaskListByTaskId(@Validated CommonTaskPage commonTaskPage) {
        User user = checkUserValid();
        commonTaskPage.setAccount(user.getAccount());
        return new Result(taskService.searchCommonWorkflowTaskListByTaskId(commonTaskPage));
    }

    /**
     * 判断当前账号是否有效
     * @return
     */
    public User checkUserValid() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user == null){
            throw new JnSpringCloudException(CompanyExceptionEnum.USER_LOGIN_IS_INVALID);
        }
        return user;
    }

}
