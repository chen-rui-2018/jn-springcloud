package com.jn.enterprise.servicemarket.product.service.impl;

import com.google.gson.annotations.SerializedName;
import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.ServiceProductExceptionEnum;
import com.jn.enterprise.servicemarket.product.model.CommonServiceShelf;
import com.jn.enterprise.servicemarket.product.model.ServiceContent;
import com.jn.enterprise.servicemarket.product.model.ServiceSelectConstraint;
import com.jn.enterprise.servicemarket.product.service.ServiceProductService;
import com.jn.system.model.User;
import org.apache.shiro.SecurityUtils;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.assertThat;

/**
 * 服务产品测试
 *
 * @Author: chenr
 * @Date: 2019/2/28 16:37
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudEnterpriseApplication.class})
public class ServiceProductServiceImplTest {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ServiceProductServiceImplTest.class);

    private static String productId;
    private static String commonProductId;
    private static String featureProductId;
    private static String serialNumber;
    private static String productName;
    private static String referPrice;
    private static String signoryId;
    private static String signoryName;
    private static String orgId;
    private static String serviceCycle;
    private static String pictureUrl;
    private static String productType;
    private static String advisorAccount;
    private static String serviceDetails;
    private static String account;

    @Autowired
    private ServiceProductService productService;
    @Before
    public void setUp() throws Exception {

        productId = UUID.randomUUID().toString().replaceAll("-","");
        commonProductId = UUID.randomUUID().toString().replaceAll("-","");
        featureProductId = UUID.randomUUID().toString().replaceAll("-","");
        serialNumber=  "PT123456789";
        productName = "招聘外包";
        referPrice = "1000-20000";
        serviceCycle= "猎头服务：2-8周，特殊岗位试具体情况而定； 招聘流程外包（RPO）：1-2周完成推荐数位合格的候选人。";
        signoryId = "rlzy110110";
        signoryName = "人力资源";
        orgId = "1001211";
        pictureUrl="https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2828282156,4161557038&fm=26&gp=0.jpg";
        productType = "0";
        advisorAccount = "wangsong,qianqi";
        serviceDetails = "莫听穿林打叶声,何妨吟啸且徐行.竹杖芒鞋轻胜马,一蓑烟雨任平生";
        account = "wangsong";
    }

    /**
     * 新增常规服务产品信息
     */
    @Test
    public void addServiceProduct() {
        ServiceContent content = new ServiceContent();
        content.setProductId(productId);
        content.setProductName(productName);
        content.setAdvisorAccount(advisorAccount);
        content.setOrgId(orgId);
        content.setProductType(productType);
        content.setPictureUrl(pictureUrl);
        content.setReferPrice(referPrice);
        content.setSerialNumber(serialNumber);
        content.setSignoryName(signoryName);
        content.setServiceCycle(serviceCycle);
        content.setServiceDetails(serviceDetails);
        content.setSignoryId(signoryId);
        try {
          productId =  productService.addServiceProduct(content,account);
        }catch (JnSpringCloudException e){
            logger.info("info>>>>>>>>>>>code:" + e.getCode() + "- - - -message:" + e.getMsg());
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(ServiceProductExceptionEnum.SERVICE_PRODUCT_ORG_ID_EMPTY.getCode()),
                            Matchers.containsString(ServiceProductExceptionEnum.SERVICE_PRODUCT_NAME_DUPLICATE.getCode())
                    )
            );
        }

    }

    /**
     * 后台服务产品管理-服务产品列表
     */
    @Test
    public void findServiceList() {
        ServiceSelectConstraint constraint = new ServiceSelectConstraint();
        constraint.setOrgName("机构1");
        constraint.setOrgType("");
        constraint.setProductName("");
        constraint.setProductType("");
        constraint.setSignoryName("");
        constraint.setStatus("0");
        constraint.setStartTime("");
        constraint.setEndTime("");
        PaginationData data =  productService.findServiceList(constraint);
        logger.info("满足条件的服务产品数量:"+data.getTotal());
    }

    /**
     *机构上架常规服务产品
     */
    @Test
    public void upShelfCommonService() {
        CommonServiceShelf commonService = new CommonServiceShelf();
        commonService.setAdvisorAccount(advisorAccount);
        commonService.setProductId(productId);
        commonService.setOrgId("1001211");
        productService.upShelfCommonService(commonService,account);
    }

    @Test
    public void findServiceDetail() {
    }

    @Test
    public void productApproval() {
    }

    @Test
    public void productShelf() {
    }

    @Test
    public void featuredProductRelease() {
    }

    @Test
    public void modifyCommonService() {
    }

    @Test
    public void findHotProducts() {
    }

    @Test
    public void findWebProductDetails() {
    }

    @Test
    public void findWebProductList() {
    }

    @Test
    public void findOrgProductList() {
    }

    @Test
    public void findShelfProductList() {
    }

    @Test
    public void productQueryList() {
    }

    @Test
    public void updateCommonProduct() {
    }

    @Test
    public void updateFeatureProduct() {
    }

    @Test
    public void advisorProductList() {
    }
//    @Test
//    public void zDeleteTest() {
//        sysDepartmentService.delete(departmenId,user);
//    }
}