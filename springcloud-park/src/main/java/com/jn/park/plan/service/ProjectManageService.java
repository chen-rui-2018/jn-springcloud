package com.jn.park.plan.service;

import com.jn.park.plan.model.ProjectCompleteRatioModel;
import com.jn.park.plan.model.ProjectManageModel;
import com.jn.park.plan.model.ProjectPlanModel;
import com.jn.park.plan.model.ProjectTaskModel;

import java.util.List;

/**
 * @Author: tangry
 * @Date: 2019/5/11
 * @Version 1.0
 */
public interface ProjectManageService {

    /**
     * 工程项目管理
     * @param projectState 工程状态
     * @param progress 项目进度
     * @param projectName 项目名称
     * @param orderByClause 排序字段
     * @return
     */
    List<ProjectManageModel> findAll(String projectState, String progress, String projectName, String orderByClause);

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
