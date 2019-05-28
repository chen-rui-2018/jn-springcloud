package com.jn.enterprise.workflow.task.dao;

import com.jn.enterprise.workflow.task.model.TaskPage;
import com.jn.enterprise.workflow.task.model.TaskStatistics;
import com.jn.enterprise.workflow.task.model.TaskType;
import com.jn.enterprise.workflow.task.vo.TaskTypeVo;
import com.jn.enterprise.workflow.task.vo.TaskVo;

import java.util.List;
import java.util.Map;

/**
 * 事项任务Mapper
 *
 * @author： yuanyy
 * @date： Created on 2019/4/18 17:41
 * @version： v1.0
 * @modified By:
 */
public interface TaskMapper {
    /**
     *（逻辑删除） 批量删除任务事项
     * @param map
     */
    void  deleteBranchByIds(Map map);

    /**
     *
     * @param taskType
     * @return
     */
    List<TaskTypeVo> selectTaskTypeByCondition(TaskType taskType);

    /**
     *
     * @param taskPage
     * @return
     */
    List<TaskVo> selectTaskListByCondition(TaskPage taskPage);

    /**
     * 时效性待办事项预警数据统计
     * @param taskStatistics
     * @return
     */
    String getWorkflowTaskStatistics(TaskStatistics taskStatistics);

}
