package com.jn.enterprise.servicemarket.advisor.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceAdvisor;
import com.jn.enterprise.servicemarket.advisor.model.*;
import com.jn.enterprise.servicemarket.advisor.vo.AdvisorDetailsVo;

import java.util.List;

/**
 * 服务顾问
 * @Author: yangph
 * @Date: 2019/2/12 16:37
 * @Version v1.0
 * @modified By:
 */
public interface AdvisorService {
    /**
     * 服务顾问列表查询
     * @param advisorInquiryInfo 查询条件
     * @param needPage           是否需要分页
     * @return
     */
    PaginationData getServiceConsultantList(AdvisorInquiryInfo advisorInquiryInfo ,Boolean needPage);

    /**
     * 根据顾问账号获取顾问详情
     * @param advisorAccount 顾问账号
     * @return
     */
    AdvisorDetailsVo getServiceAdvisorInfo(String advisorAccount);

    /**
     * 根据查询条件获取服务评价信息
     * @param serviceEvaluationParam   服务评价信息查询入参
     * @return
     */
    PaginationData getServiceRatingInfo(ServiceEvaluationParam serviceEvaluationParam);

    /**
     * 根据顾问账号获取顾问基本信息
     * @param advisorAccount 顾问账号
     * @return
     */
    TbServiceAdvisor getAdvisorInfoByAccount(String advisorAccount);

    /**
     * 获取顾问荣誉资质信息
     * @param advisorAccount 顾问账号
     */
    List<ServiceHonor> getAdvisorHonorInfo(String advisorAccount);

    /**
     * 获取顾问项目经验
     * @param advisorAccount 顾问账号
     * @return
     */
    List<ServiceProjectExperience> getProjectExperienceInfo(String advisorAccount);

    /**
     * 获取顾问服务经验
     * @param advisorAccount
     * @return
     */
    List<ServiceExperience> getServiceExperienceInfo(String advisorAccount);

}
