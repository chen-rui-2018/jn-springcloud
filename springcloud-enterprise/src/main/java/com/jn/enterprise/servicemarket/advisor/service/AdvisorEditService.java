package com.jn.enterprise.servicemarket.advisor.service;

import com.jn.enterprise.servicemarket.advisor.model.*;

import java.util.List;

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
     * @param advisorBaseInfoParam  顾问资料基本信息
     * @return
     */
    int saveOrUpdateAdvisorBaseInfo(AdvisorBaseInfoParam advisorBaseInfoParam);

    /**
     * 荣誉资质保存并更新
     * @param serviceHonorParam  荣誉资质信息
     * @return
     */
    int saveOrUpdateAdvisorHonor(ServiceHonorParam serviceHonorParam);

    /**
     * 服务经历保存并更新
     * @param serviceExperienceParam 服务经历信息
     * @return
     */
    int saveOrUpdateAdvisorExperience(ServiceExperienceParam serviceExperienceParam);

    /**
     * 项目经验保存并更新
     * @param serviceProjectExperienceParam  项目经验信息
     * @return
     */
    int saveOrUpdateAdvisorProjectExperience(ServiceProjectExperienceParam serviceProjectExperienceParam);

    /**
     * 获取指定证件类型
     * @param certificateType 证件类型分类
     * @return
     */
    List<AdvisorCertificateTypeShow> getCertificateTypeList(String certificateType);

    /**
     * 判断当前登录用户是否为顾问
     * @param loginAccount  用户账号
     */
    void currentUserIsAdvisor(String loginAccount);
}
