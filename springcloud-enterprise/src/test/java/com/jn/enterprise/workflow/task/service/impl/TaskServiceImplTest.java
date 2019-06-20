package com.jn.enterprise.workflow.task.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.enterprise.workflow.task.enums.EnterpriseWorkFlowTaskStatusEnums;
import com.jn.enterprise.workflow.task.model.TaskPage;
import com.jn.enterprise.workflow.task.model.TaskType;
import com.jn.enterprise.workflow.task.service.TaskService;
import com.jn.system.model.User;
import com.jn.task.model.WorkflowTaskAdd;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

/**
 * 请假管理service单元测试
 *
 * @author： yuanyy
 * @date： Created on 2019/2/17 17:03
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TaskServiceImplTest {

    @Autowired
    public TaskService taskService;

    private static WorkflowTaskAdd  workflowTaskAdd;

    private static User user;

    private static String id;



    @BeforeClass
    public static void init() {

        id=UUID.randomUUID().toString();
        workflowTaskAdd.setId(id);
        //初始化添加用户
        user=new User();
        user.setId("10000");
        user.setAccount("wangsong");

        workflowTaskAdd =new WorkflowTaskAdd();
        workflowTaskAdd.setUserId(user.getId());
        workflowTaskAdd.setUserName(user.getAccount());

        //事项分类：1：数据上报、2：综合缴费、3：综合租赁
        workflowTaskAdd.setType(EnterpriseWorkFlowTaskStatusEnums.TASK_TO_DO.getCode());
        workflowTaskAdd.setTitle("数据上报代办");
        workflowTaskAdd.setEndTime(new Date());



    }

    /**
     * 新增事项任务
     */
    @Test
    public void insertWorkflowTask() {
        try {
            taskService.insertWorkflowTask(workflowTaskAdd);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }
    /**
     * 修改事项任务
     */
    @Test
    public void updateWorkflowTask() {
        try {
            workflowTaskAdd.setId(id);
            workflowTaskAdd.setType(EnterpriseWorkFlowTaskStatusEnums.TASK_COMPLETED.getCode());
            taskService.updateWorkflowTask(workflowTaskAdd);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }
    /**
     * 批量删除事项任务
     */
    @Test
    public void deleteWorkflowTask() {
        try {
            String [] ids={id};
            taskService.deleteWorkflowTask(ids,user.getAccount());
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    /**
     * 根据用户查询事项任务列表（待办事项、已办事项）
     */
    @Test
    public void searchWorkflowTaskTypeListByCondition() {
        try {
            TaskType taskType=new TaskType();
            //初始化3条数据
            taskType.setRowCount(3);
            //设置查询待办
            taskType.setStatus(EnterpriseWorkFlowTaskStatusEnums.TASK_TO_DO.getCode());
            taskType.setUserId(user.getId());
            taskService.searchWorkflowTaskTypeListByCondition(taskType);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    /**
     * 分页根据条件查询事项任务列表
     */
    @Test
    public void searchWorkflowTaskListByPage() {
        try {
            TaskPage taskPage=new TaskPage();
            //设置查询待办
            taskPage.setStatus(EnterpriseWorkFlowTaskStatusEnums.TASK_TO_DO.getCode());
            taskPage.setUserId(user.getId());
            taskService.searchWorkflowTaskListByPage(taskPage);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }


}
