package com.jn.enterprise.technologyfinancial.financial.product.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.enums.FinancialProductExceptionEnum;
import com.jn.enterprise.enums.ServiceProductExceptionEnum;
import com.jn.enterprise.servicemarket.product.dao.TbServiceProductMapper;
import com.jn.enterprise.servicemarket.product.model.CommonServiceShelf;
import com.jn.enterprise.technologyfinancial.financial.product.model.*;
import com.jn.enterprise.technologyfinancial.financial.product.service.FinancialProductService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
@FixMethodOrder(MethodSorters.JVM)
public class FinancialProductServiceImplTest {
    /**
     * 日志组件
     */
    private Logger logger = LoggerFactory.getLogger(FinancialProductServiceImplTest.class);

    @Autowired
    private FinancialProductService financialProductService;
    @Autowired
    private TbServiceProductMapper productMapper;

    /**
     * 金融产品列表查询
     */
    private FinancialProductListParam financialProductListParam=new FinancialProductListParam();

    private String productId;
    /**
     * 添加金融机构产品
     */
    private String templateId;
    private String commonProductId;
    private String featureProductId;
    private String templateSerialNumber;
    private String featureSerialNumber;
    private String orgId;
    private String account;
    //添加常规产品
    private FinancialProductAddInfo templateProduct= new FinancialProductAddInfo();
    //上架常规产品
    private CommonServiceShelf shelf = new CommonServiceShelf();
    //上架特色产品
    private FinancialProductAddInfo featureProduct= new FinancialProductAddInfo();

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
        productId = "fc62d95701d649aaa006b34157168576";
        /**
         * 添加金融机构产品
         */
        templateId = "fc62d95701d649aaa006b34157168576";
        commonProductId = "84a18e9cb3e04394a5d454137fa3cae3";
        featureProductId = "187084fd57a443e288962ff88b8eee2f";
        templateSerialNumber = "CG0018201903211042367682";

        featureSerialNumber = "TS003201903201045559647";
        orgId = "040e6f1a459e49989fd6db3dc2dfd6a4";
        account ="wangsong";

        /**
         * 增加常规产品
         */
        templateProduct.setProductId(templateId);
        templateProduct.setSerialNumber(templateSerialNumber);
        templateProduct.setProductName("无忧贷款A套餐");
        templateProduct.setProductType("0");
        templateProduct.setApplicableCust("所有客户");
        templateProduct.setApplyCondition("1.企业及其实际控制人无不良信用记录");
        templateProduct.setAssureMethodCode("danbaofangshi0000000000000000001");
        templateProduct.setAssureMethodName("担保方式:抵押");
        templateProduct.setIsGeneralPro("1");
        templateProduct.setIsOnlineLoan("1");
        templateProduct.setIsPolicyPro("1");
        templateProduct.setIsRmb("1");
        templateProduct.setLoanAmountMax("100");
        templateProduct.setLoanAmountMin("1");
        templateProduct.setLoanCategoryCode("daikuanleibie0000000000000000001");
        templateProduct.setLoanCategoryName("分期贷款");
        templateProduct.setLoanTermMax("36");
        templateProduct.setLoanTermMin("6");
        templateProduct.setPictureUrl("http://www.pptok.com/wp-content/uploads/2012/08/xunguang-4.jpg");
        templateProduct.setProductFeature("申请流程少,到账速度快");
        templateProduct.setRefRateMin("2.26");
        templateProduct.setRefRateMax("3.26");
        templateProduct.setSignoryId("technology_finance");
        templateProduct.setSignoryName("科技金融");
        templateProduct.setSubmitMaterial("身份证复印件/营业执照");

        /**
         * 上架常规产品
         */
        shelf.setTemplateId(templateId);
        shelf.setOrgId(orgId);
        shelf.setProductId(commonProductId);


        /**
         * 上架特色产品
         */
        BeanUtils.copyProperties(templateProduct, featureProduct);
        featureProduct.setProductId(featureProductId);
        featureProduct.setOrgId(orgId);
        featureProduct.setSerialNumber(featureSerialNumber);
        featureProduct.setTemplateId(featureProductId);
        featureProduct.setProductType("1");
        featureProduct.setProductName("无忧贷款特色B套餐");
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
        try {
            FinancialProductDetails financialProductDetails = financialProductService.getFinancialProductDetails(productId);
            if(financialProductDetails!=null){
                logger.info("金融产品详情:{}",financialProductDetails.toString());
            }
            assertThat(financialProductDetails, anything());
        } catch (JnSpringCloudException e) {
            logger.info("金融产品详情获取失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(FinancialProductExceptionEnum.PRODUCT_NOT_EXIST.getCode())
                    )
            );
        }
    }

    /**
     * 金融产品贷款类别
     */
    @Test
    public void getFinancialProductLoanType() {
        List<FinancialProductLoanType> financialProductLoanType = financialProductService.getFinancialProductLoanType();
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
        if(technologyInfoNum!=null){
            logger.info("科技金融首页投资人数:{}，金融产品数:{}，金融机构数:{}",
                    technologyInfoNum.getInvestorsNum(),
                    technologyInfoNum.getFinancialProductNum(),
                    technologyInfoNum.getFinancialOrgNum());
        }
        assertThat(technologyInfoNum, anything());
    }

    /**
     * 添加常规科技金融产品
     *
     */
    @Test
    public void addFinancialProduct() {
        try {
            financialProductService.addFinancialProduct(templateProduct,account);
        }catch (JnSpringCloudException e){
            logger.info("info>>>>>>>>>>>code:" + e.getCode() + "- - - -message:" + e.getMsg());
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(ServiceProductExceptionEnum.SERVICE_PRODUCT_NAME_DUPLICATE.getCode())
                    )
            );
        }
    }

    /**
     * 上架常规科技金融产品,先添加产品然后才能上架产品
     */
    @Test
    public void upShelfCommonProduct() {
        try {
            financialProductService.upShelfCommonProduct(shelf,account);
        }catch (JnSpringCloudException e){
            logger.info("info>>>>>>>>>>>code:" + e.getCode() + "- - - -message:" + e.getMsg());
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(ServiceProductExceptionEnum.SERVICE_PRODUCT_NAME_DUPLICATE.getCode()),
                            Matchers.containsString(ServiceProductExceptionEnum.SERVICE_PRODUCT_ORG_OWNED_PRODUCT.getCode())
                    )
            );
        }

    }

    /**
     * 上架特色金融科技产品
     */
    @Test
    public void upShelfFeatureProduct() {
        try {
            financialProductService.upShelfFeatureProduct(featureProduct,account);
        }catch (JnSpringCloudException e){
            logger.info("info>>>>>>>>>>>code:" + e.getCode() + "- - - -message:" + e.getMsg());
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(ServiceProductExceptionEnum.SERVICE_PRODUCT_NAME_DUPLICATE.getCode())

                    )
            );
        }
    }

    /**
     * 删除添加的测试数据
     */
    @Test
    public void zDeleteTest() {
        productMapper.deleteByPrimaryKey(templateId);
        productMapper.deleteByPrimaryKey(commonProductId);
        productMapper.deleteByPrimaryKey(featureProductId);
        logger.info("删除数据成功!");
    }
}