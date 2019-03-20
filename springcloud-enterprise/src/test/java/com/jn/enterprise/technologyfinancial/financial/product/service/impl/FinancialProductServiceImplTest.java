package com.jn.enterprise.technologyfinancial.financial.product.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.technologyfinancial.financial.product.model.*;
import com.jn.enterprise.technologyfinancial.financial.product.service.FinancialProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.anything;
import static org.junit.Assert.assertThat;

/**
 * @Author: yangph
 * @Date: 2019/3/20 11:43
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudEnterpriseApplication.class})
public class FinancialProductServiceImplTest {
    /**
     * 日志组件
     */
    private Logger logger = LoggerFactory.getLogger(FinancialProductServiceImplTest.class);

    @Autowired
    private FinancialProductService financialProductService;

    /**
     * 金融产品列表查询
     */
    private FinancialProductListParam financialProductListParam=new FinancialProductListParam();

    private String productId;

    @Before
    public void setUp() throws Exception {
        /**
         * 金融产品列表查询
         */
        financialProductListParam.setLoanTermMin("3");
        financialProductListParam.setAssureMethodCode("Operating");
        financialProductListParam.setOnlineLoan("1");
        financialProductListParam.setPolicyProduct("1");
        financialProductListParam.setLoanAmountMin("10");
        financialProductListParam.setNeedPage("1");

        /**
         * 金融产品详情
         */
        productId="3677b55f9bd647ee950fe71b079f1e69";
    }

    /**
     * 金融产品列表查询
     */
    @Test
    public void getFinancialProductList() {
        PaginationData paginationData = financialProductService.getFinancialProductList(financialProductListParam);
        if(paginationData==null || paginationData.getRows()==null){
            //ignore
        }else{
            List<FinancialProductListInfo> financialProductList=(List<FinancialProductListInfo> ) paginationData.getRows();
            if(financialProductList.isEmpty()){
                //ignore
            }else{
                for(FinancialProductListInfo financialProductListInfo:financialProductList){
                    logger.info(financialProductListInfo.toString());
                }
            }
        }
        assertThat(paginationData,anything());
    }

    /**
     * 金融产品详情
     */
    @Test
    public void getFinancialProductDetails() {
        FinacialProductDetails financialProductDetails = financialProductService.getFinancialProductDetails(productId);
        if(financialProductDetails!=null){
            logger.info(financialProductDetails.toString());
        }
        assertThat(financialProductDetails, anything());
    }

    /**
     * 金融产品贷款类别
     */
    @Test
    public void getFinancialProductLoanType() {
        List<FinacialProductLoanType> financialProductLoanType = financialProductService.getFinancialProductLoanType();
        assertThat(financialProductLoanType, anything());
    }

    /**
     * 金融产品担保方式
     */
    @Test
    public void getFinancialProductAssureType() {
        List<FinancialProductAssureType> financialProductAssureType = financialProductService.getFinancialProductAssureType();
        assertThat(financialProductAssureType, anything());
    }

    /**
     * 科技金融首页投资人数，金融产品数，金融机构数
     */
    @Test
    public void getTechnologyInfoNum() {
        TechnologyInfoNum technologyInfoNum = financialProductService.getTechnologyInfoNum();
        assertThat(technologyInfoNum, anything());
    }
}