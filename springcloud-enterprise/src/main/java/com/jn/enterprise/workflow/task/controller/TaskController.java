package com.jn.enterprise.workflow.task.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.workflow.task.model.TaskPage;
import com.jn.enterprise.workflow.task.model.TaskType;
import com.jn.enterprise.workflow.task.service.TaskService;
import com.jn.enterprise.workflow.task.vo.TaskTypeVo;
import com.jn.enterprise.workflow.task.vo.TaskVo;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 事项任务controller
 *
 * @author： yuanyy
 * @date： Created on 2019/4/18 10:40
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "流程管理-事项任务")
@RestController
@RequestMapping("/enterprise/workflow/task")
public class TaskController extends BaseController {

    @Autowired
    private TaskService taskService;


    @ControllerLog(doAction = "根据用户查询事项任务列表")
    @ApiOperation(value = "根据用户查询事项任务列表", notes = "根据事项状态查询待办事项、已办事项，1：代办，2：已办")
    @PostMapping(value = "/searchWorkflowTaskListByUser")
    @RequiresPermissions("/enterprise/workflow/task/searchWorkflowTaskListByUser")
    public Result<List<TaskTypeVo> > searchWorkflowTaskListByUser(@RequestBody TaskType taskType) {
        List<TaskTypeVo>  data =taskService.searchWorkflowTaskTypeListByCondition(taskType);
        return new Result(data);
    }


    @ControllerLog(doAction = "分页查询事项任务列表")
    @ApiOperation(value = "分页查询事项任务列表",notes = "根据用户与事项分类分页查询事项任务列表")
    @PostMapping(value = "/searchWorkflowTaskListByPage")
    @RequiresPermissions("/enterprise/workflow/task/searchWorkflowTaskListByPage")
    public Result<List<TaskVo>> searchWorkflowTaskListByPage(@RequestBody TaskPage taskPage) {
        Assert.isNull(taskPage.getRowCount(),"初始化每个分类条数rowCount必须为空");
        PaginationData data = taskService.searchWorkflowTaskListByPage(taskPage);
        return new Result(data);
    }





}
