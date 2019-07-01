package com.jn.enterprise.servicemarket.advisor.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.advisor.model.*;
import com.jn.enterprise.servicemarket.advisor.vo.AdvisorDetailsVo;

import java.util.List;

/**
 * 服务专员
 * @Author: yangph
 * @Date: 2019/2/12 16:37
 * @Version v1.0
 * @modified By:
 */
public interface AdvisorService {
    /**
     * 服务专员列表查询
     * @param advisorListParam 查询条件
     * @param needPage           是否需要分页
     * @return
     */
    PaginationData getServiceConsultantList(AdvisorListParam advisorListParam, Boolean needPage);

    /**
     * 根据专员账号获取专员详情
     * @param advisorAccount 专员账号
     * @param approvalStatus 审批状态 ( - 1：已拒绝    0：未反馈   1：待审批     2：审批通过    3：审批不通过    4：已解除)
     * @return
     */
    AdvisorDetailsVo getServiceAdvisorInfo(String advisorAccount,String approvalStatus);

    /**
     * 根据查询条件获取服务评价信息
     * @param serviceEvaluationParam   服务评价信息查询入参
     * @return
     */
    PaginationData getServiceRatingInfo(ServiceEvaluationParam serviceEvaluationParam);

    /**
     * 根据专员账号获取专员基本信息
     * @param advisorAccount 专员账号
     * @param approvalStatus 审批状态 ( - 1：已拒绝    0：未反馈   1：待审批     2：审批通过    3：审批不通过    4：已解除)
     * @return
     */
    AdvisorServiceInfo getAdvisorInfoByAccount(String advisorAccount,String approvalStatus);

    /**
     * 获取专员荣誉资质信息
     * @param advisorAccount 专员账号
     */
    List<ServiceHonor> getAdvisorHonorInfo(String advisorAccount);

    /**
     * 获取专员项目经验
     * @param advisorAccount 专员账号
     * @return
     */
    List<ServiceProjectExperience> getProjectExperienceInfo(String advisorAccount);

    /**
     * 获取专员服务经验
     * @param advisorAccount
     * @return
     */
    List<ServiceExperience> getServiceExperienceInfo(String advisorAccount);

    /**
     * 服务评价统计信息
     * @param serviceEvaluationParam
     * @return
     */
    EvaluationCountInfo getEvaluationCountInfo(ServiceEvaluationParam serviceEvaluationParam);

}
