package com.jn.enterprise.workflow.task.service;


import com.jn.common.model.PaginationData;
import com.jn.enterprise.workflow.task.model.CommonTaskPage;
import com.jn.enterprise.workflow.task.model.TaskPage;
import com.jn.enterprise.workflow.task.model.TaskType;
import com.jn.enterprise.workflow.task.vo.CommonTaskListVO;
import com.jn.enterprise.workflow.task.vo.CommonTaskVO;
import com.jn.enterprise.workflow.task.vo.TaskStatisticsVO;
import com.jn.enterprise.workflow.task.vo.TaskTypeVo;
import com.jn.task.model.WorkflowTaskAdd;

import java.util.List;

/**
 * 事项任务service
 * @author： yuanyy
 * @date： Created on 2019/4/18 15:32
 * @version： v1.0
 * @modified By:
 **/
public interface TaskService {

    /**
     * 时效性待办事项预警数据统计
     * @param userId 用户ID
     * @return
     */
    TaskStatisticsVO getWorkflowTaskStatistics(String userId);

    /**
     * 根据用户查询事项任务列表（待办事项、已办事项）
     * @param taskType 事项状态，1：代办、2：结办
     * @return
     */
    List<TaskTypeVo> searchWorkflowTaskTypeListByCondition(TaskType taskType);

    /**
     * 分页根据条件查询事项任务列表
     * @param taskPage
     * @return
     */
    PaginationData searchWorkflowTaskListByPage(TaskPage taskPage);


    /**
     * 新增事项任务
     * @param workflowTaskAdd
     */
    int insertWorkflowTask(WorkflowTaskAdd workflowTaskAdd);

    /**
     * 修改事项任务
     * @param workflowTaskAdd
     */
    void updateWorkflowTask(WorkflowTaskAdd workflowTaskAdd);

    /**
     * 批量删除事项任务
     * @param ids
     */
    void deleteWorkflowTask(String[] ids,String userAccount);

    /**
     * 查询常规待办事项
     * @param account 账号
     * @return
     */
    List<CommonTaskListVO> searchCommonWorkflowTaskList(String account);

    /**
     * 根据待办类型查询常规待办事项
     * @param commonTaskPage 入参
     * @return
     */
    List<CommonTaskVO> searchCommonWorkflowTaskListByTaskId(CommonTaskPage commonTaskPage);

}
