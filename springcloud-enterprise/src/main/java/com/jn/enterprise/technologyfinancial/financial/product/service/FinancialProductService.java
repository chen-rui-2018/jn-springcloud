package com.jn.enterprise.technologyfinancial.financial.product.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.technologyfinancial.financial.product.model.*;

import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/3/18 19:36
 * @Version v1.0
 * @modified By:
 */
public interface FinancialProductService {
    /**
     * 金融产品列表查询
     * @param financialProductListParam 查询条件
     * @return
     */
    PaginationData getFinancialProductList(FinancialProductListParam financialProductListParam);

    /**
     * 金融产品详情
     * @param productId 产品id
     * @return
     */
    FinacialProductDetails getFinancialProductDetails(String productId);

    /**
     * 金融产品贷款类别
     * @return
     */
    List<FinacialProductLoanType> getFinancialProductLoanType();

    /**
     * 金融产品担保方式
     * @return
     */
    List<FinancialProductAssureType> getFinancialProductAssureType();

    /**
     * 科技金融首页投资人数，金融产品数，金融机构数
     * @return
     */
    TechnologyInfoNum getTechnologyInfoNum();
}
