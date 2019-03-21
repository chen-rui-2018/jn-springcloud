package com.jn.enterprise.servicemarket.advisor.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorManagementPortalParam;
import com.jn.enterprise.servicemarket.advisor.vo.AdvisroManagementDetailsVo;

/**
 * 服务顾问管理(后台门户管理)
 * @Author: yangph
 * @Date: 2019/2/28 9:51
 * @Version v1.0
 * @modified By:
 */
public interface AdvisorManagementPortalService {
    /**
     * 服务顾问管理列表查询
     * @param advisorManagementParam  服务顾问管理列表查询入参
     * @return
     */
    PaginationData getAdvisorManagementInfoList(AdvisorManagementPortalParam advisorManagementParam);

    /**
     * 服务顾问详情
     * @param advisorAccount  顾问账号
     * @return
     */
    AdvisroManagementDetailsVo getAdvisorManagementDetails(String advisorAccount);
}
