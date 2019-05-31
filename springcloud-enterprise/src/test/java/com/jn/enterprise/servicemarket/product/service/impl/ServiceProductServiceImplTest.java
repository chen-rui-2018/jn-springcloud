package com.jn.enterprise.servicemarket.product.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.enums.ServiceProductExceptionEnum;
import com.jn.enterprise.servicemarket.product.dao.TbServiceAndAdvisorMapper;
import com.jn.enterprise.servicemarket.product.dao.TbServiceDetailsMapper;
import com.jn.enterprise.servicemarket.product.dao.TbServiceProductMapper;
import com.jn.enterprise.servicemarket.product.entity.TbServiceAndAdvisorCriteria;
import com.jn.enterprise.servicemarket.product.entity.TbServiceDetails;
import com.jn.enterprise.servicemarket.product.entity.TbServiceDetailsCriteria;
import com.jn.enterprise.servicemarket.product.entity.TbServiceProduct;
import com.jn.enterprise.servicemarket.product.model.*;
import com.jn.enterprise.servicemarket.product.service.ServiceProductService;
import com.jn.enterprise.servicemarket.product.vo.WebServiceProductDetails;
import org.hamcrest.Matchers;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
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
@FixMethodOrder(MethodSorters.JVM)
public class ServiceProductServiceImplTest {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ServiceProductServiceImplTest.class);

    private static  String productId;
    private static  String commonProductId;
    private static  String featureProductId;
    private static String serialNumber;
    private static String productName;
    private static String referPrice;
    private static String signoryId;
    private static String signoryName;
    private static String orgId;
    private static String orgName;
    private static String serviceCycle;
    private static String pictureUrl;
    private static String productType;
    private static String advisorAccount;
    private static String productDetails;
    private static String account;
    private static String comments;

    @Autowired
    private ServiceProductService productService;

    @Autowired
    private TbServiceProductMapper productMapper;
    @Autowired
    private TbServiceAndAdvisorMapper  producAdvisorMapper;
    @Autowired
    private TbServiceDetailsMapper detailsMapper;


    @BeforeClass
    public static void init(){

        productId = "ca5bfde1a9cd4d9d8a9d1f41763d820c";
        commonProductId =  "ca5bfde1a9cd4d9d8a9d1f41763d820d";
        featureProductId =  "ca5bfde1a9cd4d9d8a9d1f41763d820e";

        serialNumber=  "PT123456789";
        productName = "招聘外包";

        referPrice = "1000-20000";
        serviceCycle= "猎头服务：2-8周，特殊岗位试具体情况而定； 招聘流程外包（RPO）：1-2周完成推荐数位合格的候选人。";
        signoryId = "rlzy110110";
        signoryName = "人力资源";
        orgId = "1001211";
        orgName = "机构1";
        pictureUrl="https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2828282156,4161557038&fm=26&gp=0.jpg";
        productType = "0";
        advisorAccount = "wangsong,qianqi";
        productDetails = "莫听穿林打叶声,何妨吟啸且徐行.竹杖芒鞋轻胜马,一蓑烟雨任平生";
        account = "wangsong";
        comments = productDetails;
    }

    /**
     * 新增常规服务产品信息
     */
    @Test
    @Ignore
    public void addServiceProduct() {
        ServiceContent content = new ServiceContent();
        content.setProductId(productId);
        content.setProductName(productName);
        content.setProductType(productType);
        content.setPictureUrl(pictureUrl);
        content.setReferPrice(referPrice);
        content.setSerialNumber(serialNumber);
        content.setSignoryName(signoryName);
        content.setServiceCycle(serviceCycle);
        content.setProductDetails(productDetails);
        content.setSignoryId(signoryId);
        try {
          productId =  productService.addServiceProduct(content,account,null);
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
        constraint.setOrgName("orgName");
        constraint.setOrgType("");
        constraint.setProductName("");
        constraint.setProductType("");
        constraint.setSignoryName("");
        constraint.setStatus("0");
        constraint.setStartTime("");
        constraint.setEndTime("");
        PaginationData data =  productService.findServiceList(constraint);
        logger.info(" 查询后台产品列表成功----满足条件的服务产品数量:"+data.getTotal());
    }

    /**
     *机构上架常规服务产品
     */
    @Test
    @Ignore
    public void upShelfCommonService() {
        CommonServiceShelf commonService = new CommonServiceShelf();
        commonService.setProductId(commonProductId);
        commonService.setTemplateId(productId);
        commonService.setAdvisorAccount(advisorAccount);
        commonService.setOrgId(orgId);
        try{
            productService.upShelfCommonService(commonService,account);
        }catch(JnSpringCloudException e){
            logger.info("info>>>>>>>>>>>code:" + e.getCode() + "- - - -message:" + e.getMsg());
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(ServiceProductExceptionEnum.SERVICE_PRODUCT_ORG_ID_EMPTY.getCode()),
                            Matchers.containsString(ServiceProductExceptionEnum.SERVICE_PRODUCT_ID_EMPTY.getCode())
                    )
            );
        }
        logger.info("上架常规产品成功");
    }

    /**
     * 后台查询产品详情
     */
    @Test
    public void findServiceDetail() {
        try{
            ServiceProductDetail detail =  productService.findServiceDetail("228043fd4f37438ea34e5a9ccdea2271");
            logger.info("产品详情查询成功,产品id="+detail.getContent().getProductId()+"产品名称="+detail.getContent().getProductName());
        }catch(JnSpringCloudException e){
            logger.info("info>>>>>>>>>>>code:" + e.getCode() + "- - - -message:" + e.getMsg());
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(ServiceProductExceptionEnum.SERVICE_PRODUCT_ID_EMPTY.getCode())
                    )
            );
        }
    }
    /**
     *审核特色产品
     */
    @Test
    public void productApproval() {
        ServiceProductApproval approval =  new ServiceProductApproval();
        approval.setProductId("");
        approval.setStatus("2");
        approval.setApprovalComments(comments);

        productService.productApproval(approval,account);

    }

    /**
     * 后台服务产品上架/下架
     */
    @Test
    public void productShelf() {
        ProductShelfOperation approval = new ProductShelfOperation();
        approval.setProductId("228043fd4f37438ea34e5a9ccdea2271");
        approval.setStatus("-1");
        productService.productShelf(approval,account);
        logger.info("服务产品上架/下架成功产品id="+approval.getProductId());
    }

    /**
     * 特色产品发布,特色服务产品列表
     */
    @Test
    public void featuredProductRelease() {
        ServiceSelectConstraint constraint = new  ServiceSelectConstraint();
        constraint.setOrgName("机构1");
        constraint.setOrgType("");
        constraint.setProductName("");
        constraint.setProductType("");
        constraint.setSignoryName("");
        constraint.setStatus("");
        constraint.setStartTime("");
        constraint.setEndTime("");
        PaginationData data =  productService.featuredProductRelease(constraint);
        logger.info("特色服务产品发布列表查询成功,满足条件产品数="+data.getTotal());
    }

    /**
     *  后台-修改常规服务产品
     */
    @Test
    public void modifyCommonService() {
        ServiceContent content = new ServiceContent();
        content.setProductId(productId);
        content.setServiceCycle("三年起步,最高无期");
        try{
            productService.modifyCommonService(content,account);
        }catch(JnSpringCloudException e){
            logger.info("info>>>>>>>>>>>code:" + e.getCode() + "- - - -message:" + e.getMsg());
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(ServiceProductExceptionEnum.SERVICE_PRODUCT_PRODUCT_SHELF.getCode())
                    )
            );
        }
    }

    /**
     * 热门产品列表
     */
    @Test
    public void findHotProducts() {
        Page page = new Page();
        page.setRows(15);
        page.setPage(1);
        PaginationData data=   productService.findHotProducts(page);
        logger.info("热门服务产品列表查询成功! 符合条件数据条数="+data.getTotal());
    }

    /**
     * 前台服务产品详情
     */
    @Test
    public void findWebProductDetails() {
        WebServiceProductDetails productDetails =  productService.findWebProductDetails(commonProductId);
        logger.info("热前台服务产品详情查询成功!");
    }

    /**
     * 前台服务产品列表
     */
    @Test
    public void findWebProductList() {
        ProductInquiryInfo  info = new ProductInquiryInfo();
        info.setKeyWords("");
        info.setOrgId("");
        info.setSignoryId("");
        info.setSortTypes("");
        info.setProductType("");
         PaginationData data =   productService.findWebProductList(info, true);
        logger.info("特前台服务产品列表查询成功,满足条件产品数="+data.getTotal());
    }

    /**
     * 前台机构的服务产品列表
     */
    @Test
    public void findOrgProductList() {
        OrgProductQuery  info = new OrgProductQuery();
        info.setProductType("0");
        info.setOrgId("1001211");
        info.setKeyWords("");
        PaginationData data = productService.findOrgProductList(info, true);
        logger.info("前台机构的服务产品列表查询成功! 符合条件数据条数="+data.getTotal());
    }

    /**
     * 用于机构上架常规服务产品的 服务产品列表
     */
    @Test
    public void findShelfProductList() {
        List<ProductShelf> serviceList =  productService.findShelfProductList(orgId);
        logger.info("前台机构的服务产品列表查询成功! 符合条件数据条数="+(serviceList==null?0:serviceList.size()));
    }
    /**
     *服务产品列表,只包含服务Id和服务名称,用于评价的筛选条件
     */
    @Test
    public void productQueryList() {
        List<ProductShelf>  serviceList = productService.productQueryList("招聘");
        logger.info("前台机构的服务产品列表查询成功! 符合条件数据条数="+(serviceList==null?0:serviceList.size()));
    }

    /**
     *机构更新常规服务产品
     */
    @Test
    public void updateCommonProduct() {
        OrgUpdateCommonProduct product = new OrgUpdateCommonProduct();
        product.setProductId(commonProductId);
        product.setAdvisorAccount("zhaoliu");
        productService.updateCommonProduct(  product,"wangsong");
        logger.info("机构更新服常规务产品成功!");
    }
    /**
     *机构更新特色服务产品
     */
    @Test
    public void updateFeatureProduct() {
        OrgUpdateFeatureProduct content = new OrgUpdateFeatureProduct();
        content.setProductId(featureProductId);
        content.setProductName("法律咨询");
        content.setServiceCycle("1次");
        content.setReferPrice("100-1000");
        content.setPictureUrl(pictureUrl);
        content.setAdvisorAccount("wangsong,zhaoliu");
        content.setProductDetails(productDetails);
        content.setProductType("1");
        try{
            productService.updateFeatureProduct(  content,"wangsong");
            logger.info("机构更新特色产品成功!");
        }catch(JnSpringCloudException e){
            logger.info("info>>>>>>>>>>>code:" + e.getCode() + "- - - -message:" + e.getMsg());
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(ServiceProductExceptionEnum.SERVICE_PRODUCT_REFER_PRICE_WRONG_FORMAT.getCode()),
                            Matchers.containsString(ServiceProductExceptionEnum.SERVICE_PRODUCT_REFER_PRICE_NUMBER_EXCEPTION.getCode())
                    )
            );
        }
    }

    /**
     * 顾问关联的服务产品列表
     */
    @Test
    public void advisorProductList() {
        AdvisorProductQuery query =  new AdvisorProductQuery();
        query.setAdvisorAccount("wangsong");
        query.setProductType("");
        query.setPraise("");
        PaginationData data= productService.advisorProductList(query,true);
        logger.info("前台机构的服务产品列表查询成功! 符合条件数据条数="+(data==null?0:data.getTotal()));
    }
    @Test
    public void zDeleteTest() {
        productMapper.deleteByPrimaryKey(productId);
        productMapper.deleteByPrimaryKey(commonProductId);
        productMapper.deleteByPrimaryKey(featureProductId);
        List<String> list = new ArrayList<>();
        list.add(productId);
        list.add(commonProductId);
        list.add(featureProductId);
        TbServiceAndAdvisorCriteria criteria =new TbServiceAndAdvisorCriteria();
        criteria.createCriteria().andProductIdIn(list);
        producAdvisorMapper.deleteByExample(criteria);
        TbServiceDetailsCriteria criteria1Details = new TbServiceDetailsCriteria();
        criteria1Details.createCriteria().andProductIdIn(list);
        detailsMapper.deleteByExample(criteria1Details);
        logger.info("删除数据成功!");
    }
}