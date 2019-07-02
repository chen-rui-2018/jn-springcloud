package com.jn.enterprise.servicemarket.advisor.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorManagementPortalParam;
import com.jn.enterprise.servicemarket.advisor.vo.AdvisorManagementDetailsVo;

/**
 * 服务专员管理(后台门户管理)
 * @Author: yangph
 * @Date: 2019/2/28 9:51
 * @Version v1.0
 * @modified By:
 */
public interface AdvisorManagementPortalService {
    /**
     * 服务专员管理列表查询
     * @param advisorManagementParam  服务专员管理列表查询入参
     * @return
     */
    PaginationData getAdvisorManagementInfoList(AdvisorManagementPortalParam advisorManagementParam);

    /**
     * 服务专员详情
     * @param advisorAccount  专员账号
     * @return
     */
    AdvisorManagementDetailsVo getAdvisorManagementDetails(String advisorAccount);
}
