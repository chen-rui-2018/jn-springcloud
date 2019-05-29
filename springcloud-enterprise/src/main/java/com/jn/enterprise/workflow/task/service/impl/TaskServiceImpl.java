package com.jn.enterprise.workflow.task.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.company.model.IBPSResult;
import com.jn.enterprise.common.config.TaskStatisticsConfig;
import com.jn.enterprise.common.enums.EnterpriseStatusEnums;
import com.jn.enterprise.enums.IBPSMyTaskParamEnum;
import com.jn.enterprise.model.IBPSMyTasksParam;
import com.jn.enterprise.model.MyTasksResult;
import com.jn.enterprise.utils.IBPSUtils;
import com.jn.enterprise.workflow.task.dao.TaskMapper;
import com.jn.enterprise.workflow.task.dao.TbWorkflowTaskMapper;
import com.jn.enterprise.workflow.task.entity.TbWorkflowTask;
import com.jn.enterprise.workflow.task.enums.EnterpriseWorkFlowTaskStatusEnums;
import com.jn.enterprise.workflow.task.model.CommonTaskPage;
import com.jn.enterprise.workflow.task.model.TaskPage;
import com.jn.enterprise.workflow.task.model.TaskStatistics;
import com.jn.enterprise.workflow.task.model.TaskType;
import com.jn.enterprise.workflow.task.service.TaskService;
import com.jn.enterprise.workflow.task.vo.*;
import com.jn.park.enums.CustomerCenterExceptionEnum;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.task.model.WorkflowTaskAdd;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @modified By: huxw
 */
@Service
public class TaskServiceImpl implements TaskService {

    private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired
    private TbWorkflowTaskMapper tbWorkflowTaskMapper;

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private TaskStatisticsConfig taskStatisticsConfig;

    @Override
    @ServiceLog(doAction = "时效性待办事项预警数据统计")
    public TaskStatisticsVO getWorkflowTaskStatistics(String userId) {
        TaskStatisticsVO taskStatisticsVO = new TaskStatisticsVO();

        TaskStatistics taskStatistics = new TaskStatistics();
        taskStatistics.setUserId(userId);
        taskStatistics.setWarnHour(taskStatisticsConfig.getWarn());
        taskStatistics.setEarlyWarnHour(taskStatisticsConfig.getEarlyWarn());

        List<WarnStatisticsVO> workflowTaskList = taskMapper.getWorkflowTaskStatistics(taskStatistics);
        if (workflowTaskList != null && !workflowTaskList.isEmpty()) {
            for (WarnStatisticsVO statisticsVO : workflowTaskList) {
                if (statisticsVO.getWarnType().equals(EnterpriseWorkFlowTaskStatusEnums.TASK_WARNING.getCode())) {
                    taskStatisticsVO.setWarnNum(statisticsVO.getWarnNum());
                } else if (statisticsVO.getWarnType().equals(EnterpriseWorkFlowTaskStatusEnums.TASK_EARLY_WARNING.getCode())) {
                    taskStatisticsVO.setEarlyWarnNum(statisticsVO.getWarnNum());
                } else {
                    taskStatisticsVO.setNormalNum(statisticsVO.getWarnNum());
                }
            }
        }
        taskStatisticsVO.setTotalNum(taskStatisticsVO.getWarnNum() + taskStatisticsVO.getEarlyWarnNum() + taskStatisticsVO.getNormalNum());
        return taskStatisticsVO;
    }

    /**
     * 根据条件查询事项任务列表（待办事项、已办事项）
     * @param taskType 事项状态，1：代办、2：结办
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据条件查询事项任务列表（待办事项、已办事项）")
    public List<TaskTypeVo>  searchWorkflowTaskTypeListByCondition(TaskType taskType){
        // 设置报警时间
        taskType.setWarnHour(taskStatisticsConfig.getWarn());
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

    @Override
    @ServiceLog(doAction = "查询常规待办事项")
    public List<CommonTaskListVO> searchCommonWorkflowTaskList(String account) {
        IBPSMyTasksParam ibpsMyTasksParam = setIBPSMyTaskParamIfo(null);
        JSONObject jsonObject = IBPSUtils.myTasks(account, ibpsMyTasksParam);
        IBPSResult ibpsResult = new Gson().fromJson(jsonObject.toString(), IBPSResult.class);

        //获取我的待办事项
        if("200".equals(ibpsResult.getState())){
            logger.info("----------------根据查询条件获取我的待办事项成功------------");
            //解析封装数据
            return processResultData(ibpsResult);
        }else{
            logger.warn("获取我的待办事项失败，{}", ibpsResult.getMessage());
            throw new JnSpringCloudException(CustomerCenterExceptionEnum.NETWORK_ANOMALY);
        }
    }

    @Override
    @ServiceLog(doAction = "根据待办类型查询常规待办事项")
    public List<CommonTaskVO> searchCommonWorkflowTaskListByTaskId(CommonTaskPage commonTaskPage) {
        IBPSMyTasksParam ibpsMyTasksParam = setIBPSMyTaskParamIfo(commonTaskPage);
        JSONObject jsonObject = IBPSUtils.myTasks(commonTaskPage.getAccount(), ibpsMyTasksParam);
        IBPSResult ibpsResult = new Gson().fromJson(jsonObject.toString(), IBPSResult.class);

        //获取我的待办事项
        if("200".equals(ibpsResult.getState())){
            logger.info("----------------根据查询条件获取我的待办事项成功------------");
            //解析封装数据
            List<MyTasksResult> resultList = getMyTasksResults(ibpsResult);
            List<CommonTaskVO> commonTaskVOList = new ArrayList<>();
            for (MyTasksResult tasksResult : resultList) {
                CommonTaskVO commonTaskVO = new CommonTaskVO();
                BeanUtils.copyProperties(tasksResult, commonTaskVO);
                commonTaskVOList.add(commonTaskVO);
            }
            return commonTaskVOList;
        }else{
            logger.warn("获取我的待办事项失败，{}", ibpsResult.getMessage());
            throw new JnSpringCloudException(CustomerCenterExceptionEnum.NETWORK_ANOMALY);
        }
    }

    /**
     * 设置待办事项的动态参数
     * @param commonTaskPage 入参为null查询流程待办列表
     * @return
     */
    @ServiceLog(doAction = "设置待办事项的动态参数")
    private IBPSMyTasksParam setIBPSMyTaskParamIfo(CommonTaskPage commonTaskPage) {
        List<Map<String,String>> dynamicParams = new ArrayList<>(16);
        Map<String,String> dynamicMap = new HashMap<>();
        if(commonTaskPage != null){
            dynamicMap.put(IBPSMyTaskParamEnum.PROC_DEF_ID.getCode(), commonTaskPage.getTaskId());
        }
        if(!dynamicMap.isEmpty()){
            dynamicParams.add(dynamicMap);
        }

        int pageNo = 1;
        int limit = 5000;
        List<Map<String,String>> sortsParam = new ArrayList<>(2);
        //设置排序参数
        Map<String,String> sortMap = new HashMap<>(2);
        if (commonTaskPage != null) {
            pageNo = commonTaskPage.getPage();
            limit = commonTaskPage.getRows();
            sortMap.put("createTime", "DESC");
        } else {
            sortMap.put("PROC_DEF_ID_", "DESC");
        }
        sortsParam.add(sortMap);
        return new IBPSMyTasksParam(dynamicParams, limit, pageNo, sortsParam);
    }

    /**
     * 解析待办/已办事项数据
     * @param ibpsResult
     * @return
     */
    @ServiceLog(doAction = "解析待办/已办事项数据")
    private List<MyTasksResult> getMyTasksResults(IBPSResult ibpsResult) {
        Object data = ibpsResult.getData();
        LinkedTreeMap dataMap = (LinkedTreeMap) data;
        List<LinkedTreeMap> dataResult = (List<LinkedTreeMap>)dataMap.get("dataResult");
        List<MyTasksResult> resultList = new ArrayList<>(16);
        for(LinkedTreeMap linkedTreeMap : dataResult){
            ObjectMapper objectMapper = new ObjectMapper();
            MyTasksResult myTasksResult = objectMapper.convertValue(linkedTreeMap, MyTasksResult.class);
            resultList.add(myTasksResult);
        }
        return resultList;
    }

    /**
     * 解析并封装返回数据
     * @param ibpsResult
     * @return
     */
    @ServiceLog(doAction = "解析并封装返回数据")
    private List<CommonTaskListVO> processResultData(IBPSResult ibpsResult) {
        List<MyTasksResult> resultList = getMyTasksResults(ibpsResult);

        String taskId = "";
        String taskName = "";
        int taskNum = 0;
        List<CommonTaskListVO> commonTaskList = new ArrayList<>();
        CommonTaskListVO commonTaskListVO = new CommonTaskListVO();
        for (MyTasksResult task : resultList) {
            String tempProcDefId = task.getProcDefId();
            if (tempProcDefId.equals(taskId)) {
                taskNum++;
            } else {
                if (StringUtils.isNotBlank(taskId)) {
                    commonTaskListVO.setTaskId(taskId);
                    commonTaskListVO.setTaskName(taskName);
                    commonTaskListVO.setTaskNum(taskNum);
                    commonTaskList.add(commonTaskListVO);
                }
                commonTaskListVO = new CommonTaskListVO();
                taskId = tempProcDefId;
                taskName = task.getProcDefName();
                taskNum = 1;
            }
        }
        return commonTaskList;
    }
}
