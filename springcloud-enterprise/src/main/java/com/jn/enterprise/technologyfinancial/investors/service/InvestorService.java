package com.jn.enterprise.technologyfinancial.investors.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.technologyfinancial.investors.model.*;
import com.jn.enterprise.technologyfinancial.investors.vo.InvestorInfoDetailsVo;

import java.util.List;

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

    /**
     * 查询所属单位
     * @param affiliationUnitInfoParam
     * @return
     */
    PaginationData getAffiliationUnit(AffiliationUnitInfoParam affiliationUnitInfoParam);

    /**
     * 新增投资人认证信息
     * @param investorAuthenticateParam 投资人认证信息
     * @param investorAccount           投资人账号
     * @return
     */
    int addInvestorInfo(InvestorAuthenticateParam investorAuthenticateParam,String investorAccount);

    /**
     * 查询投资人主投领域
     * @return
     */
    List<InvestorMainArea> getInvestorMainArea();

    /**
     * 查询投资人主投轮次
     * @return
     */
    List<InvestorMainRound> getInvestorMainRound();
}
