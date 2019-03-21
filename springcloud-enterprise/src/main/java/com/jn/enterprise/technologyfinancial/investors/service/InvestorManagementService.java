package com.jn.enterprise.technologyfinancial.investors.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorManagementListParam;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorManagementNameParam;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorManagementUpOrDownParam;

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

    /**
     * 投资人管理姓名查询
     * @param investorManagementNameParam
     * @return
     */
    PaginationData getInvestorManagementNames(InvestorManagementNameParam investorManagementNameParam);

    /**
     * 投资人上架/下架
     * @param investorManagementUpOrDownPara
     * @param account  用户账号
     * @return
     */
    int investorUpOrDown(InvestorManagementUpOrDownParam investorManagementUpOrDownPara,String account);

}
