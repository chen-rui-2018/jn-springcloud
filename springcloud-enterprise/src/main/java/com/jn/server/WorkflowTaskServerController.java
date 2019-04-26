package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.workflow.task.service.TaskService;
import com.jn.task.api.WorkflowTaskClient;
import com.jn.task.model.WorkflowTaskAdd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


/**
 * @author： yuanyy
 * @date： Created on 2019/4/18 17:44
 * @version： v1.0
 * @modified By:
 */
@RestController
public class WorkflowTaskServerController extends BaseController implements WorkflowTaskClient {

    @Autowired
    private TaskService taskService;

    /**
     * 新增事项任务
     * @param workflowTaskAdd
     * @return
     */
    @Override
    public Result insertWorkflowTask(@RequestBody WorkflowTaskAdd workflowTaskAdd){
        workflowTaskAdd.setId(UUID.randomUUID().toString());
        taskService.insertWorkflowTask(workflowTaskAdd);
        return new Result();
    }

    /**
     * 修改事项任务
     * @param workflowTaskAdd
     * @return
     */
    @Override
    public Result updateWorkflowTask(@RequestBody WorkflowTaskAdd workflowTaskAdd){
        Assert.notNull(workflowTaskAdd.getId(),"id不能为空");
        taskService.updateWorkflowTask(workflowTaskAdd);
        return new Result();
    }

    /**
     * 批量删除事项任务
     * @param ids
     * @return
     */
    @Override
    public Result deleteWorkflowTask(@RequestParam(value = "ids")  String[] ids, String userAccount){
        Assert.noNullElements(ids,"ids不能为空");
        taskService.deleteWorkflowTask(ids,userAccount);
        return new Result();
    }

}
