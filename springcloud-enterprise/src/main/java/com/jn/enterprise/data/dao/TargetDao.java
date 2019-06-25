package com.jn.enterprise.data.dao;


import com.jn.enterprise.data.entity.*;
import com.jn.enterprise.data.model.*;
import com.jn.enterprise.data.vo.ModelDataVO;
import com.jn.enterprise.data.vo.TabVO;
import com.jn.enterprise.data.vo.TargetVO;
import com.jn.enterprise.model.DataTargetModel;
import com.jn.enterprise.model.LoadCompanyDataTargetReq;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    void updateCalling(@Param("taskBatch") String taskBatch,@Param("fillId") String fillId,@Param("fileType") String fileType);

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
     * 获取整个园区的任务批次，用于获取广告
     */

    List<String> getAllGardenBatch(@Param("lastMon") String lastMon,@Param("lastYear") String lastYear);

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
     */
    void updateTask();

    /**
     * 预警任务获取
     */
    List<WarningTaskModel> getWarningTask(@Param("fillId") String fillId,@Param("taskBatch") String taskBatch);


    /**
     * 保存园区任务可填报部门的信息
     * @param fillerList
     */
    void saveFillerList(@Param("fillerList") List<TbDataReportingGardenFiller> fillerList);


    /**
     * 通过任务ID查询指标
     * @return
     */
    List<TbDataReportingSnapshotTarget> getTargetByFillId (@Param("fillId") String fillId);

    /**
     * 通过任务ID查询填报格式
     * @param fillId
     * @return
     */

    List<TbDataReportingSnapshotTargetGroup> getTargetGroupByFillId (@Param("fillId") String fillId);


/**
 *   数据统计--导出模块
 *   获取数据
 */

   // List<CompanyTree> getExcel(Map map);


List<CompanyTree> getExcel (@Param("taskbatch") String taskbatch,@Param("modelid") String modelid);

    /**
     * 检测本次任务中是否存在缴纳税收总额字段
     * @param fillId
     * @return
     */
    List<TbDataReportingSnapshotTargetGroup>  checkIsHaveTaxiProperty(@Param("fillId") String fillId);

    /**
     * 将缴纳税收总额更新到科技园任务中
     * @param data 值
     * @param fillId 科技园模板任务Id
     * @param formId 填报格式Id
     * @param targetId 指标Id
     * @param companyName 企业名称
     */
    int  updateTaxiToScientTarget(@Param("data") String data,@Param("fillId") String fillId,@Param("formId") String formId,@Param("targetId") String targetId,@Param("companyName") String  companyName);

    /**
     * 通过科技园任务Id,查询出纳税总额的指标Id,和填报格式Id
     * @return
     */
    List<TbDataReportingSnapshotTargetGroup>  getScientTaxiTargetByFillId(@Param("fillId") String fillId);

    /**
     * 检测科技园任务是否已经导入
     * @param formTime
     * @return
     */
    List<TbDataReportingTask>  checkThisFormTimeScientIsImport(@Param("formTime") String formTime);

    /**
     * 科技园查询接口-分组企业
     * @param companyName
     * @param fillId
     * @return
     */
    List<String> getCompanyList(@Param("companyName") String companyName,@Param("fillId") String fillId);

    /**
     * 科技园查询接口-按照企业进行查询
     * @param companyName
     * @param fillId
     * @return
     */
    List<ScientModel> getValues(@Param("companyName") String companyName,@Param("fillId") String fillId);

    /**
     * 科技园表头指标获取
     * @param fillId
     * @return
     */
    List<TbDataReportingSnapshotTarget> getScientTabHeaderTarget(@Param("fillId") String fillId);

    /**
     * 科技园表头填报格式获取
     * @param fillId
     * @return
     */
    List<TbDataReportingSnapshotTargetGroup> getScientTabHeaderTargetGroup(@Param("fillId") String fillId);

    List<DataTargetModel> loadCompanyDataTarget(LoadCompanyDataTargetReq loadCompanyDataTargetReq);

    List<String> getTargetIdByName(@Param("targetName") String targetName);

    List<TargetAndFormModel> getFormIdByTargetIds(@Param("targetIds") List<String> targetIds);

    List<InMoneyModel> getValueAndYear(@Param("targetIds") List<TargetAndFormModel> targetIds);

    void insertDataUploadResultSet(@Param("fillId") String fillId);
}
