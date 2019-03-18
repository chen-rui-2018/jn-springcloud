package com.jn.enterprise.technologyfinancial.financial.product.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.technologyfinancial.financial.product.model.FinancialProductListParam;

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
}
