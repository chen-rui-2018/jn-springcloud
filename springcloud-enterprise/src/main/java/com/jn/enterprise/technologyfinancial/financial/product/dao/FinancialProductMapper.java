package com.jn.enterprise.technologyfinancial.financial.product.dao;

import com.jn.enterprise.technologyfinancial.financial.product.model.FinancialProductListInfo;
import com.jn.enterprise.technologyfinancial.financial.product.model.FinancialProductListParam;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/3/18 20:18
 * @Version v1.0
 * @modified By:
 */
@Repository
public interface FinancialProductMapper {
    /**
     * 金融产品列表查询
     * @param financialProductListParam 查询条件
     * @return
     */
    List<FinancialProductListInfo> getFinancialProductList(FinancialProductListParam financialProductListParam);

}
