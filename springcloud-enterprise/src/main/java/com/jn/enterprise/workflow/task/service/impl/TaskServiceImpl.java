package com.jn.enterprise.workflow.task.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.common.enums.EnterpriseStatusEnums;
import com.jn.enterprise.workflow.task.dao.TaskMapper;
import com.jn.enterprise.workflow.task.dao.TbWorkflowTaskMapper;
import com.jn.enterprise.workflow.task.entity.TbWorkflowTask;
import com.jn.enterprise.workflow.task.enums.EnterpriseWorkFlowTaskStatusEnums;
import com.jn.enterprise.workflow.task.model.TaskPage;
import com.jn.enterprise.workflow.task.model.TaskType;
import com.jn.enterprise.workflow.task.service.TaskService;
import com.jn.enterprise.workflow.task.vo.TaskTypeVo;
import com.jn.enterprise.workflow.task.vo.TaskVo;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.task.model.WorkflowTaskAdd;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 事项任务service
 *
 * @author： yuanyy
 * @date： Created on 2019/4/18 14:17
 * @version： v1.0
 * @modified By:
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TbWorkflowTaskMapper tbWorkflowTaskMapper;

    @Autowired
    private TaskMapper taskMapper;

    /**
     * 根据条件查询事项任务列表（待办事项、已办事项）
     * @param taskType 事项状态，1：代办、2：结办
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据条件查询事项任务列表（待办事项、已办事项）")
    public List<TaskTypeVo>  searchWorkflowTaskTypeListByCondition(TaskType taskType){
        List<TaskTypeVo> taskTypeVos=taskMapper.selectTaskTypeByCondition(taskType);
        for(int i=0;i<taskTypeVos.size();i++){
            TaskPage taskPage =new TaskPage();
            taskPage.setStatus(taskType.getType());
            taskPage.setUserId(taskType.getUserId());
            taskPage.setRowCount(taskType.getRowCount());
            taskTypeVos.get(i).setTaskList(taskMapper.selectTaskListByCondition(taskPage));
        }
        return taskTypeVos;
    }

    /**
     * 分页根据条件查询事项任务列表
     *
     * @param taskPage
     * @return
     */
    @Override
    @ServiceLog(doAction = "分页根据条件查询事项任务列表")
    public PaginationData searchWorkflowTaskListByPage(TaskPage taskPage) {
        Page<Object> objects = PageHelper.startPage(taskPage.getPage(), taskPage.getRows());
        return  new PaginationData( taskMapper.selectTaskListByCondition(taskPage)
                , objects.getTotal());
    }

    /**
     * 新增事项任务
     *
     * @param workflowTaskAdd
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @ServiceLog(doAction = "新增事项任务")
    public int insertWorkflowTask(WorkflowTaskAdd workflowTaskAdd) {
        TbWorkflowTask tbWorkflowTask = new TbWorkflowTask();
        BeanUtils.copyProperties(workflowTaskAdd, tbWorkflowTask);
        //设计基本信息
        tbWorkflowTask.setCreatedTime(new Date());
        //设置有效
        tbWorkflowTask.setRecordStatus(EnterpriseStatusEnums.EFFECTIVE.getCode());
        //默认设计为待办事项
        tbWorkflowTask.setStatus(EnterpriseWorkFlowTaskStatusEnums.TASK_TO_DO.getCode());

        return tbWorkflowTaskMapper.insert(tbWorkflowTask);
    }

    /**
     * 修改事项任务
     *
     * @param workflowTaskAd
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @ServiceLog(doAction = "修改事项任务")
    public void updateWorkflowTask(WorkflowTaskAdd workflowTaskAd) {
        TbWorkflowTask tbWorkflowTask = new TbWorkflowTask();
        BeanUtils.copyProperties(workflowTaskAd, tbWorkflowTask);

        tbWorkflowTask.setModifiedTime(new Date());
        tbWorkflowTaskMapper.updateByPrimaryKey(tbWorkflowTask);
    }

    /**
     * 根据ids批量删除事项任务
     *
     * @param ids
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @ServiceLog(doAction = "根据ids批量删除事项任务")
    public void deleteWorkflowTask(String[] ids,String userAccount) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("ids", ids);
        map.put("account", userAccount);
        taskMapper.deleteBranchByIds(map);
    }
}
