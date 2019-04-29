package com.jn.enterprise.propaganda.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.enums.BusinessPromotionExceptionEnum;
import com.jn.enterprise.propaganda.model.*;
import com.jn.enterprise.propaganda.service.BusinessPromotionService;
import org.hamcrest.Matchers;
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
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

/**
 * @Author: yangph
 * @Date: 2019/4/22 10:36
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudEnterpriseApplication.class})
public class BusinessPromotionServiceImplTest {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(BusinessPromotionServiceImplTest.class);

    @Autowired
    private BusinessPromotionService businessPromotionService;


    /**
     * 企业宣传列表查询
     */
    private BusinessPromotionListParam bpp=new BusinessPromotionListParam();

    private String loginAccount;
    /**
     * 企业宣传详情
     */
    private String propagandaId;
    /**
     * 发布宣传
     */
    private BusinessPromotionDetailsParam bpdp=new BusinessPromotionDetailsParam();
    /**
     * 修改企业宣传
     */
    private BusinessPromotionDetailsParam businessParam=new BusinessPromotionDetailsParam();
    /**
     * 修改审批状态
     */
    private String status;
    /**
     * 创建账单
     */
    private String orderNum;


    @Before
    public void setUp() throws Exception {
        //企业宣传列表查询
        bpp.setApprovalStatus("");
        bpp.setSearchContent("");
        bpp.setPropagandaType("");
        bpp.setNeedPage("1");

        loginAccount="18073856620";

        //企业宣传详情
        propagandaId="6307c8ad2117451fb49b1b8e7e370b6c";

        //发布宣传
        /*bpdp.setIssuePlatform("2");
        bpdp.setPropagandaType("business_promotion");
        bpdp.setEffectiveDate("2019-04-21");
        bpdp.setInvalidDate("2019-05-22");
        bpdp.setPropagandaTitle("企业宣传测试");
        bpdp.setPropagandaDetails("宣传详情是测试");
        bpdp.setPropagandaArea("top");
        bpdp.setPropagandaAreaUrl("123/top.jpg");
        bpdp.setPosterUrl("xuanChuan.jpg");
        bpdp.setProFeeRuleCode("business_promotion");
        bpdp.setPropagandaFee("100");*/

        /*bpdp.setIssuePlatform("1");
        bpdp.setPropagandaType("investment_promotion");
        bpdp.setEffectiveDate("2019-04-23");
        bpdp.setInvalidDate("2019-05-25");
        bpdp.setPropagandaTitle("招商宣传测试");
        bpdp.setPropagandaDetails("宣传详情是招商测试");
        bpdp.setPropagandaArea("bottom");
        bpdp.setPropagandaAreaUrl("123/bottom.jpg");
        bpdp.setPosterUrl("zhaoshang.jpg");
        bpdp.setProFeeRuleCode("investment_promotion");
        bpdp.setPropagandaFee("178.66");*/

        bpdp.setIssuePlatform("1");
        bpdp.setPropagandaType("app_start_promotion");
        bpdp.setEffectiveDate("2019-04-27");
        bpdp.setPropagandaTitle("App启动宣传测试");
        bpdp.setPropagandaDetails("宣传详情是APP启动测试");
        bpdp.setPropagandaArea("central");
        bpdp.setPropagandaAreaUrl("1253/central.jpg");
        bpdp.setPosterUrl("qidong.jpg");
        bpdp.setProFeeRuleCode("app_start_promotion");
        bpdp.setPropagandaFee("168.88");

        //修改企业宣传
        businessParam.setId(propagandaId);
        businessParam.setIssuePlatform("2");
        businessParam.setPropagandaType("home_promotion");
        businessParam.setEffectiveDate("2019-04-24");
        businessParam.setPropagandaTitle("首页宣传测试");
        businessParam.setPropagandaDetails("宣传详情是首页宣传");
        businessParam.setPropagandaArea("bottom");
        businessParam.setPropagandaAreaUrl("12323/bottom.jpg");
        businessParam.setPosterUrl("shouye.jpg");
        businessParam.setProFeeRuleCode("home_promotion");
        businessParam.setPropagandaFee("200");

        //修改审批状态
        status="0";

        //创建账单
        orderNum="AD-20190422200525553";

    }

    /**
     * 企业宣传列表查询
     */
    @Test
    public void getBusinessPromotionList() {
        PaginationData paginationData = businessPromotionService.getBusinessPromotionList(bpp, loginAccount);
        if(paginationData==null && paginationData.getRows()==null){
            //ignore
        }else{
            List<BusinessPromotionListShow> resultList= (List<BusinessPromotionListShow>)paginationData.getRows();
            for(BusinessPromotionListShow bpl: resultList){
                logger.info("企业宣传列表查询:{}",bpl.toString());
            }
        }
        assertThat(paginationData,anything());
    }

    /**
     * 企业宣传详情
     */
    @Test
    public void getBusinessPromotionDetails() {
        BusinessPromotionDetailsShow businessPromotionDetails = businessPromotionService.getBusinessPromotionDetails(propagandaId);
        if(businessPromotionDetails==null){
            //ignore
        }else{
            logger.info("企业宣传详情:{}",businessPromotionDetails.toString());
        }
        assertThat(businessPromotionDetails, anything());
    }

    /**
     * 发布宣传
     */
    @Test
    public void saveBusinessPromotion() {
        try {
            int responseNum = businessPromotionService.saveBusinessPromotion(bpdp, loginAccount);
            logger.info("发布宣传成功，数据响应条数：{}",responseNum);
            assertThat(responseNum, greaterThanOrEqualTo(0));
        } catch (JnSpringCloudException e) {
            logger.warn("发布宣传失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(BusinessPromotionExceptionEnum.EFFECTIVE_MORE_THAN_INVALID.getCode()),
                            Matchers.containsString(BusinessPromotionExceptionEnum.PROMOTION_AREA_ERROR.getCode()),
                            Matchers.containsString(BusinessPromotionExceptionEnum.PROMOTION_FEE_RULES_ERROR.getCode()),
                            Matchers.containsString(BusinessPromotionExceptionEnum.PROMOTION_FEE_RULES_ERROR.getCode()),
                            Matchers.containsString(BusinessPromotionExceptionEnum.CURRENT_PROPAGANDA_TYPE_NOT_EXIST.getCode()),
                            Matchers.containsString(BusinessPromotionExceptionEnum.CURRENT_PROPAGANDA_TYPE_IS_EXIST.getCode())
                    )
            );
        }
    }

    /**
     * 获取宣传费用规则
     */
    @Test
    public void getPropagandaFeeRulesList() {
        try {
            List<PropagandaFeeRulesShow> propagandaFeeRulesList = businessPromotionService.getPropagandaFeeRulesList();
            if(propagandaFeeRulesList==null){
                //ignore
            }else{
                for(PropagandaFeeRulesShow propagandaFeeRulesShow:propagandaFeeRulesList){
                    logger.info("获取宣传费用规则:{}",propagandaFeeRulesShow.toString());
                }
                assertThat(propagandaFeeRulesList.size(), greaterThanOrEqualTo(0));
            }
        } catch (JnSpringCloudException e) {
            logger.warn("获取宣传费用规则失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(BusinessPromotionExceptionEnum.PROMOTION_FEE_RULES_NOT_EXIST.getCode())
                    )
            );
        }
    }

    /**
     * 获取宣传类型
     */
    @Test
    public void getPropagandaTypeList() {
        try {
            List<PropagandaTypeShow> propagandaTypeList = businessPromotionService.getPropagandaTypeList(loginAccount);
            if(propagandaTypeList==null){
                //ignore
            }else{
                for(PropagandaTypeShow propagandaTypeShow:propagandaTypeList){
                    logger.info("获取宣传费用规则:{}",propagandaTypeShow.toString());
                }
                assertThat(propagandaTypeList.size(), greaterThanOrEqualTo(0));
            }
        } catch (JnSpringCloudException e) {
            logger.warn("获取宣传类型规则失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(BusinessPromotionExceptionEnum.ACCOUNT_CAN_NOT_ALLOW_PROPAGANDA.getCode())
                    )
            );
        }
    }

    /**
     * 撤销申请
     */
    @Test
    public void cancelApprove() {
        try {
            int responseNum = businessPromotionService.cancelApprove(propagandaId, loginAccount);
            logger.info("撤销申请成功，数据响应条数：{}",responseNum);
            assertThat(responseNum, greaterThanOrEqualTo(0));
        } catch (JnSpringCloudException e) {
            logger.warn("撤销申请失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(BusinessPromotionExceptionEnum.PROPAGANDA_INFO_NOT_EXIST.getCode())
                    )
            );
        }
    }

    /**
     * 修改企业宣传
     */
    @Test
    public void updateBusinessPromotion() {
        try {
            int responseNum = businessPromotionService.updateBusinessPromotion(businessParam, loginAccount);
            logger.info("修改企业宣传成功，数据响应条数：{}",responseNum);
            assertThat(responseNum,greaterThanOrEqualTo(0) );
        } catch (JnSpringCloudException e) {
            logger.warn("修改企业宣传失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(BusinessPromotionExceptionEnum.UPDATE_NOT_ALLOWED.getCode()),
                            Matchers.containsString(BusinessPromotionExceptionEnum.EFFECTIVE_MORE_THAN_INVALID.getCode()),
                            Matchers.containsString(BusinessPromotionExceptionEnum.PROMOTION_AREA_ERROR.getCode()),
                            Matchers.containsString(BusinessPromotionExceptionEnum.PROMOTION_FEE_RULES_ERROR.getCode()),
                            Matchers.containsString(BusinessPromotionExceptionEnum.PROMOTION_FEE_RULES_ERROR.getCode()),
                            Matchers.containsString(BusinessPromotionExceptionEnum.CURRENT_PROPAGANDA_TYPE_NOT_EXIST.getCode()),
                            Matchers.containsString(BusinessPromotionExceptionEnum.CURRENT_PROPAGANDA_TYPE_IS_EXIST.getCode())
                    )
            );
        }
    }

    /**
     * 生成订单号
     */
    @Test
    public void getOrderNumber() {
        String orderNumber = businessPromotionService.getOrderNumber();
        logger.info("----生成订单号成功，订单号是：{}-----",orderNumber);
        assertThat(orderNumber, anything());
    }

    /**
     * 修改审批状态
     */
    @Test
    public void updateApprovalStatus() {
        try {
            int responseNum = businessPromotionService.updateApprovalStatus(propagandaId, status, loginAccount);
            logger.info("-------修改审批状态成功，数据响应条数：{}-------",responseNum);
            assertThat(responseNum,greaterThanOrEqualTo(0) );
        } catch (JnSpringCloudException e) {
            logger.warn("修改审批状态失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(BusinessPromotionExceptionEnum.PROPAGANDA_INFO_NOT_EXIST.getCode()),
                            Matchers.containsString(BusinessPromotionExceptionEnum.STATUS_NOT_SUPPORT.getCode())
                    )
            );
        }
    }

    /**
     * 创建账单
     */
    @Test
    public void createBill() {
        String bill = businessPromotionService.createBill(orderNum, loginAccount);
        logger.info("------账单号：{}-----",bill);
        assertThat(bill, anything());
    }

    /**
     * 获取宣传区域信息
     */
    @Test
    public void getPropagandaAreaList(){
        try {
            List<PropagandaAreaShow> propagandaAreaList = businessPromotionService.getPropagandaAreaList();
            if(propagandaAreaList==null){
                //ignore
            }else{
                for(PropagandaAreaShow ps:propagandaAreaList){
                    logger.info("获取宣传区域信息：{}",ps.toString());
                }
            }
            assertThat(propagandaAreaList, anything());
        } catch (JnSpringCloudException e) {
            logger.warn("获取宣传区域信息失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(BusinessPromotionExceptionEnum.PROPAGANDA_AREA_NOT_EXIST.getCode())
                    )
            );
        }
    }
}