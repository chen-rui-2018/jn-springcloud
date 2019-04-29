package com.jn.enterprise.data.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.data.enums.DataUploadConstants;
import com.jn.enterprise.data.model.CompanyDataModel;
import com.jn.enterprise.data.model.CompanyDataParamModel;
import com.jn.enterprise.data.model.CompanyDataStatisticsModel;
import com.jn.enterprise.data.model.CompanyDataStatisticsParamModel;
import com.jn.enterprise.data.vo.ModelDataVO;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author： yangh
 * @date： Created on 2019/4/11 11:50
 * @version： v1.0
 * @modified By:
 */
public interface DataUploadService {

    /**园区、企业的数据上报入口接口功能*/

    /**
     * 获取企业数据上报页面广告
     * @param user
     * @return
     */
    Map<String, Set<String>> getCompanyAd(User user);

    /**
     * 获取园区数据上报页面广告
     * @param user
     * @return
     */
    Map<String, Set<String>> getGardenAd(User user);
    /**
     * 企业本月上报任务获取
     * @param user
     * @return
     */
    List<CompanyDataModel> getNeedFormList(User user);

    /**
     * 园区本月上报任务获取
     * @param user
     * @return
     */
    List<CompanyDataModel> getCurrentMonthTasks(User user);


    /**
     * 企业获取未填的任务的表单
     * @param fileId
     * @param user
     * @return
     */
    ModelDataVO getFormStruct(String fileId,User user);

    /**
     * 园区获取未填的任务的表单
     * @param fileId
     * @param user
     * @return
     */
    ModelDataVO getCurrentMonthForm(String fileId,User user);

    /**
     * 企业历史填报任务详情
     * @param fileId
     * @param user
     * @return
     */
    ModelDataVO getCompanyFormedStruct(String fileId,User user);

    /**
     * 园区历史填报任务详情
     * @param fileId
     * @param user
     * @return
     */
    ModelDataVO getGardenFormStruct(String fileId,User user);


    /**
     * 获取企业填报历史
     * @param param
     * @param user
     * @return
     */
    PaginationData<List<CompanyDataModel>> getFormedHistory(CompanyDataParamModel param,User user);


    /**
     * 获取园区填报历史
     * @param param
     * @param user
     * @return
     */
    PaginationData<List<CompanyDataModel>> getHostoryTask(CompanyDataParamModel param,User user);




    /**
     * 园区填报任务数据进行保存
     * @param data
     * @param user
     * @return
     */
    int saveTaskData(ModelDataVO data,User user);

    /**
     * 企业填报任务数据进行保存
     * @param data
     * @param user
     * @return
     */
    int saveCompanyFormData(ModelDataVO data,User user);


    /**
     * 企业填报数据保存为草稿
     * @param data
     * @param user
     * @return
     */
    int saveTaskDataAsDraft(ModelDataVO data,User user);

    /**
     * 企业填报数据保存为草稿
     * @param data
     * @param user
     * @return
     */
    int saveCompanyFormDataAsDraft(ModelDataVO data,User user);





    /**园区、企业的数据上报统计接口功能*/

    /**
     * 企业统计
     * @param param
     * @return
     */
    PaginationData<List<CompanyDataStatisticsModel>> getFormView(CompanyDataStatisticsParamModel param);

    /**
     * 园区数据统计
     * @param param
     * @return
     */
    PaginationData<List<CompanyDataStatisticsModel>> getStatisticsList(CompanyDataStatisticsParamModel param);


    /**
     * 企业统计详细列表
     * @param param
     * @return
     */
    PaginationData<List<CompanyDataModel>> getFormList(CompanyDataParamModel param);

    /**
     * 获取园区数据统计信息的详细数据列
     * @param param
     * @return
     */
    PaginationData<List<CompanyDataModel>> getStatisticsListInfo(CompanyDataParamModel param);


    /**
     * 企业修改截至日期
     * @param taskBatch
     * @param newDeadLine
     * @param modelId
     * @return
     */
    int setDeadlineCompany(String taskBatch,String newDeadLine,String modelId);
    /**
     * 园区修改截至日期
     * @param taskBatch
     * @param newDeadLine
     * @param modelId
     * @return
     */
    int setDeadline(String taskBatch,String newDeadLine,String modelId);


    /**
     * 企业催报
     * @param taskBatch
     * @param fillId
     * @return
     */
    int setStatisticsListUrgeCompany(String taskBatch,String fillId);
    /**
     * 园区催报
     * @param taskBatch
     * @param fillId
     * @return
     */
    int setStatisticsListUrge(String taskBatch,String fillId);

    /**
     * 企业数据统计-填报任务详细信息获取
     * @param user
     * @param fillId
     * @return
     */
    ModelDataVO getFormedStruct(User user,String fillId);

    /**
     * 园区数据统计-填报任务详细信息获取
     * @param user
     * @param fillId
     * @return
     */
    ModelDataVO getStruct(User user,String fillId);


}
