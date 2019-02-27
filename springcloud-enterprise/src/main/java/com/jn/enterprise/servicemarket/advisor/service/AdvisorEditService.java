package com.jn.enterprise.servicemarket.advisor.service;

import com.jn.enterprise.servicemarket.advisor.model.AdvisorBaseInfo;
import com.jn.enterprise.servicemarket.advisor.model.ServiceExperience;
import com.jn.enterprise.servicemarket.advisor.model.ServiceHonor;
import com.jn.enterprise.servicemarket.advisor.model.ServiceProjectExperience;

/**
 * 编辑顾问资料
 * @Author: yangph
 * @Date: 2019/2/27 10:12
 * @Version v1.0
 * @modified By:
 */
public interface AdvisorEditService {
    /**
     * 基本信息保存并更新
     * @param advisorBaseInfo  顾问资料基本信息
     */
    void saveOrUpdateAdvisorBaseInfo(AdvisorBaseInfo advisorBaseInfo);

    /**
     * 荣誉资质保存并更新
     * @param serviceHonor  荣誉资质信息
     */
    void saveOrUpdateAdvisorHonor(ServiceHonor serviceHonor);

    /**
     * 服务经历保存并更新
     * @param serviceExperience 服务经历信息
     */
    void saveOrUpdateAdvisorExperience(ServiceExperience serviceExperience);

    /**
     * 项目经验保存并更新
     * @param serviceProjectExperience  项目经验信息
     */
    void saveOrUpdateAdvisorProjectExperience(ServiceProjectExperience serviceProjectExperience);
}
