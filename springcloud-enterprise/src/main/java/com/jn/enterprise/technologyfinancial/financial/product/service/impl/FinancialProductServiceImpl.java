package com.jn.enterprise.technologyfinancial.financial.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.technologyfinancial.financial.product.dao.FinancialProductMapper;
import com.jn.enterprise.technologyfinancial.financial.product.model.FinancialProductListInfo;
import com.jn.enterprise.technologyfinancial.financial.product.model.FinancialProductListParam;
import com.jn.enterprise.technologyfinancial.financial.product.service.FinancialProductService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/3/18 19:36
 * @Version v1.0
 * @modified By:
 */
@Service
public class FinancialProductServiceImpl implements FinancialProductService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(FinancialProductServiceImpl.class);

    @Autowired
    private FinancialProductMapper financialProductMapper;

    /**
     * 金融产品列表查询
     * @param financialProductListParam 查询条件
     * @return
     */
    @ServiceLog(doAction = "金融产品列表查询")
    @Override
    public PaginationData getFinancialProductList(FinancialProductListParam financialProductListParam) {
        com.github.pagehelper.Page<Object> objects = null;
        if(financialProductListParam==null || StringUtils.isBlank(financialProductListParam.getNeedPage())){
            //默认查询第1页的15条数据
            int pageNum=1;
            int pageSize=15;
            objects = PageHelper.startPage(pageNum,pageSize, true);
            List<FinancialProductListInfo> financialProductList = financialProductMapper.getFinancialProductList(financialProductListParam);
            return new PaginationData(financialProductList, objects == null ? 0 : objects.getTotal());
        }
        //需要分页标识
        String isPage="1";
        if(isPage.equals(financialProductListParam.getNeedPage())){
            objects = PageHelper.startPage(financialProductListParam.getPage(),
                    financialProductListParam.getRows() == 0 ? 15 : financialProductListParam.getRows(), true);
        }
        List<FinancialProductListInfo> financialProductList = financialProductMapper.getFinancialProductList(financialProductListParam);
        return new PaginationData(financialProductList, objects == null ? 0 : objects.getTotal());
    }
}
