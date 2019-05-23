package com.jn.task.api;


import com.jn.common.model.Result;
import com.jn.task.model.WorkflowTaskAdd;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 事项任务客户端
 *
 * @Author: yuanyy
 * @Date: 2019/04/18 19:30
 * @Version v1.0
 * @modified By:
 */
@FeignClient("springcloud-enterprise")
public interface WorkflowTaskClient {


    /**
     * 新增事项任务
     * @param workflowTaskAdd
     * @return
     */
    @RequestMapping(value = "/api/workflow/task/insertWorkflowTask", method = RequestMethod.POST)
    Result insertWorkflowTask(@RequestBody WorkflowTaskAdd workflowTaskAdd);

    /**
     * 修改事项任务
     * @param workflowTaskAdd
     * @return
     */
    @RequestMapping(value = "/api/workflow/task/updateWorkflowTask", method = RequestMethod.POST)
    Result updateWorkflowTask(@RequestBody WorkflowTaskAdd workflowTaskAdd);

    /**
     * 批量删除事项任务
     * @param ids
     * @return
     */
    @RequestMapping(value = "/api/workflow/task/deleteWorkflowTask", method = RequestMethod.POST)
    Result deleteWorkflowTask(@RequestParam(value = "ids")  String[] ids,String userAccount);


}
