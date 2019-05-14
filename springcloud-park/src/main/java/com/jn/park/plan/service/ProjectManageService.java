package com.jn.park.plan.service;

import com.jn.common.model.PaginationData;
import com.jn.park.message.model.FindAllMessageListVo;
import com.jn.park.plan.model.*;

import java.util.List;

/**
 * @Author: tangry
 * @Date: 2019/5/11
 * @Version 1.0
 */
public interface ProjectManageService {

    /**
     * 工程项目管理
     * @param projectModel 工程状态
     * @return
     */
    PaginationData<PaginationData<List<ProjectManageModel>>>  findAll(ProjectModel projectModel);

    /**
     * 工程项目查看-任务信息
     * @param projectNo 工程项目编号
     * @return
     */
    List<ProjectTaskModel> findProjectTask(String projectNo);

    /**
     * 工程项目查看-任务进展
     * @param projectNo
     * @return
     */
    ProjectPlanModel findTaskPlan(String projectNo);

    /**
     * 工程项目查看-完成及时率
     * @param projectNo
     * @return
     */
    ProjectCompleteRatioModel findCompleteRatio(String projectNo);
}
