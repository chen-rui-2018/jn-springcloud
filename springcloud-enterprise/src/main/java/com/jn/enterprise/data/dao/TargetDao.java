package com.jn.enterprise.data.dao;


import com.jn.enterprise.data.entity.*;
import com.jn.enterprise.data.model.*;
import com.jn.enterprise.data.vo.ModelDataVO;
import com.jn.enterprise.data.vo.TabVO;
import com.jn.enterprise.data.vo.TargetVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author： yangh
 * @date： Created on 2019/4/10 10:38
 * @version： v1.0
 * @modified By:
 */
@Repository
public interface TargetDao {
    List<TbDataReportingTarget> getTargetFromTab(String tabId);

    void createTab(List<TbDataReportingModelTab> list);

    void createRelation(List<TbDataReportingModelStruct> list);

    void createInputFormater(@Param("inputFormatModelList") List<TbDataReportingTargetGroup> inputFormatModelList);

    /**
     * 查询历史
     * @param param
     * @return
     */
    List<CompanyDataModel> getHistoryTaskList(@Param("param") CompanyDataParamModel param,@Param("fillInFormId") List<String> fillInFormId,@Param("fileType") Byte fileType);

    /**
     * 查询园区上报历史
     * @param param
     * @return
     */
    List<CompanyDataModel> getHistoryGardenTaskList(@Param("param") CompanyDataParamModel param,@Param("fileType") Byte fileType);



    /**
     * 查询本月需要填写的任务列表
     * @param formTimeList
     * @param fillInFormId
     * @param fileType
     * @return
     */
    List<CompanyDataModel> getThisMonthTask(@Param("formTimeList") List<String> formTimeList,@Param("fillInFormId") List<String> fillInFormId,@Param("fileType") Byte fileType);
    /**
     * 修改截至日期
     * @param taskBatch
     * @param modelId
     */
    void updateDeadline(@Param("taskBatch") String taskBatch,@Param("dealLine") String dealLine,@Param("modelId") String modelId,@Param("fileType") String fileType);


    /**
     * 催报，未上报的数据
     */
    void updateCalling(@Param("taskBatch") String taskBatch,@Param("modelId") String modelId,@Param("fileType") String fileType);

    /**
     * 企业统计数据查询
     * @param param
     * @return
     */
    List<CompanyDataStatisticsModel> getStatisticsModel(@Param("param") CompanyDataStatisticsParamModel param,@Param("fileType") String fileType);

    /**
     * 保存数据
     * @param list
     */
    void saveData(@Param("list") List<TbDataReportingTaskData> list);

    /**
     * 获取园区审核数据
     * @param param
     * @return
     */
    List<GardenCheckModel> getGardenCheckList(@Param("param") GardenCheckParamModel param);


    /**
     * 园区该用户的task_Batch获取
     * @param lastMon
     * @param lastYear
     * @param list
     * @return
     */
    List<String> getGardenTaskBatch(@Param("lastMon") String lastMon,@Param("lastYear") String lastYear,@Param("list") List<String> list );

    /**
     * 获取园区填报任务
     * @param list
     * @return
     */
    List<CompanyDataModel> getGardenTask(@Param("list") List<String> list);

    /**
     *
     * @return
     */
    List <DepartementModel>  getDepartmentFromTarget(@Param("fileId") String fileId);



    /**定时器*/
    /**
     * 批量保存任务
     * @param tasks
     */
    void saveTaskList(@Param("tasks") List<TbDataReportingTask> tasks);

    /**
     * 固化tab信息
     * @param tabSnapList
     */
    void saveSnapTablist(@Param("tabSnapList") List<TbDataReportingSnapshotModelTab> tabSnapList);

    /**
     * 固化关系
     * @param relations
     */
    void saveSnapshotModelStruct(@Param("relations") List<TbDataReportingSnapshotModelStruct> relations);

    /**
     * 固化指标
     * @param targets
     */
    void saveSnapshotTarget(@Param("targets") List<TbDataReportingSnapshotTarget> targets);

    /**
     * 指标填写
     * @param targetGroups
     */
    void saveSnapshotTargetGroup(@Param("targetGroups") List<TbDataReportingSnapshotTargetGroup> targetGroups);

    /**
     * 更新任务状态
     * @param nowDate
     */
    void updateTask(String nowDate);

    /**
     * 预警任务获取
     * @param nowDate
     */
    List<WarningTaskModel> getWarningTask(String nowDate);


    /**
     * 保存园区任务可填报部门的信息
     * @param fillerList
     */
    void saveFillerList(@Param("fillerList") List<TbDataReportingGardenFiller> fillerList);


}
