package com.jn.enterprise.technologyfinancial.investors.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorManagementListParam;

/**
 * 科技金融管理投资人管理
 * @Author: yangph
 * @Date: 2019/3/21 15:26
 * @Version v1.0
 * @modified By:
 */
public interface InvestorManagementService {
    /**
     * 投资人管理列表查询
     * @param investorManagementListParam 投资人管理列表查询入参
     * @return
     */
    PaginationData getInvestorManagementList(InvestorManagementListParam investorManagementListParam);

}
