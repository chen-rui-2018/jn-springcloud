package com.jn.enterprise.technologyfinancial.investors.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorInfoListParam;
import com.jn.enterprise.technologyfinancial.investors.vo.InvestorInfoDetailsVo;

/**
 * 科技金融投资人
 * @Author: yangph
 * @Date: 2019/3/9 16:40
 * @Version v1.0
 * @modified By:
 */
public interface InvestorService {
    /**
     * 投资人列表查询
     * @param investorInfoListParam  投资人列表查询入参
     * @return
     */
    PaginationData getInvestorInfoList(InvestorInfoListParam investorInfoListParam);

    /**
     * 投资人详情
     * @param investorAccount 投资人账号
     * @return
     */
    InvestorInfoDetailsVo getInvestorInfoDetails(String investorAccount);
}
