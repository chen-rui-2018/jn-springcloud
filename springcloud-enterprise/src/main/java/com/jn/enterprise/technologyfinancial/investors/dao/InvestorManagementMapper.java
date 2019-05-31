package com.jn.enterprise.technologyfinancial.investors.dao;

import com.jn.enterprise.technologyfinancial.investors.model.InvestorManagementListParam;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorManagementListShow;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorManagementNameParam;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 投资人管理列表查询
 * @Author: yangph
 * @Date: 2019/3/9 17:13
 * @Version v1.0
 * @modified By:
 */
@Repository
public interface InvestorManagementMapper {
    /**
     * 投资人管理列表查询
     * @param investorManagementListParam
     * @return
     */
    List<InvestorManagementListShow> getInvestorManagementList(InvestorManagementListParam investorManagementListParam);

    /**
     * 投资人管理姓名查询
     * @param investorManagementNameParam
     * @return
     */
    List<String> getInvestorManagementNames(InvestorManagementNameParam investorManagementNameParam);

}
