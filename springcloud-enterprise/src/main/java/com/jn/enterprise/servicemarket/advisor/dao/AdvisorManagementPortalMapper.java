package com.jn.enterprise.servicemarket.advisor.dao;

import com.jn.enterprise.servicemarket.advisor.model.AdvisorManagementPortalParam;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorServiceManagementInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 服务顾问管理(后台门户管理)
 * @Author: yangph
 * @Date: 2019/2/28 11:14
 * @Version v1.0
 * @modified By:
 */
@Repository
public interface AdvisorManagementPortalMapper {
    /**
     * 服务顾问管理列表查询
     * @param advisorManagementParam 查询条件
     * @return
     */
    List<AdvisorServiceManagementInfo> getAdvisorManagementInfoList(AdvisorManagementPortalParam advisorManagementParam);

    /**
     * 根据顾问账号获取顾问简介信息
     * @param advisorAccount 顾问账号
     * @return
     */
    AdvisorServiceManagementInfo getAdvisorIntroduction(@Param("advisorAccount") String advisorAccount);
}
