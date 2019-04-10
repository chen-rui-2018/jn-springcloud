package com.jn.enterprise.technologyfinancial.investors.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.enums.InvestorExceptionEnum;
import com.jn.enterprise.technologyfinancial.investors.model.*;
import com.jn.enterprise.technologyfinancial.investors.service.InvestorService;
import com.jn.enterprise.technologyfinancial.investors.vo.InvestorInfoDetailsVo;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @Author: yangph
 * @Date: 2019/3/20 11:46
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudEnterpriseApplication.class})
public class InvestorServiceImplTest {
    /**
     * 日志组件
     */
    private Logger logger = LoggerFactory.getLogger(InvestorServiceImplTest.class);

    @Autowired
    private InvestorService investorService;

    /**
     * 投资人列表查询入参
     */
    private InvestorInfoListParam investorInfoListParam=new InvestorInfoListParam();

    /**
     * 投资人账号
     */
    private String investorAccount;

    /**
     * 查询所属单位
     */
    private AffiliationUnitInfoParam affiliationUnitInfoParam=new AffiliationUnitInfoParam();

    /**
     * 投资人认证信息
     */
    private InvestorAuthenticateParam investorAuthenticateParam=new InvestorAuthenticateParam();

    /**
     * 主投领域
     */
    private List<InvestorMainArea> investorMainAreaList=new ArrayList<>(16);
    private InvestorMainArea investorMainArea1=new InvestorMainArea();
    private InvestorMainArea investorMainArea2=new InvestorMainArea();

    /**
     * 主投轮次
     */
    private List<InvestorMainRound> investorMainRoundList=new ArrayList<>(16);
    private InvestorMainRound investorMainRound1=new InvestorMainRound();
    private InvestorMainRound investorMainRound2=new InvestorMainRound();

    /**
     * 工作经历
     */
    private List<InvestorWorkExperienceParam> investorWorkExperienceParamList =new ArrayList<>(16);
    private InvestorWorkExperienceParam investorWorkExperienceParam1 =new InvestorWorkExperienceParam();
    private InvestorWorkExperienceParam investorWorkExperienceParam2 =new InvestorWorkExperienceParam();

    /**
     * 教育经历
     */
    private List<InvestorEducationExperienceParam> investorEduExperienceParamList =new ArrayList<>(16);
    private InvestorEducationExperienceParam investorEduExperienceParam1 =new InvestorEducationExperienceParam();
    private InvestorEducationExperienceParam investorEduExperienceParam2 =new InvestorEducationExperienceParam();


    @Before
    public void setUp() throws Exception {
        //主投领域id
        investorInfoListParam.setMainCode("biomedicine");
        investorInfoListParam.setKeyWords("湖南鑫欧宇");
        investorInfoListParam.setNeedPage("1");

        //投资人详情
        investorAccount="wangsong";

        //查询所属单位
        affiliationUnitInfoParam.setOrgName("湖南鑫欧宇");
        affiliationUnitInfoParam.setNeedPage("0");

        //投资人认证信息
        //投资人姓名
        investorAuthenticateParam.setInvestorName("王松");
        investorAuthenticateParam.setAvatar("投资人1.jpg");
        investorAuthenticateParam.setSex("1");
        investorAuthenticateParam.setOrgId("040e6f1a459e49989fd6db3dc2dfd6a4");
        investorAuthenticateParam.setOrgName("湖南鑫欧宇");
        investorAuthenticateParam.setPosition("律师顾问");
        investorAuthenticateParam.setAddressProvince("湖南省");
        investorAuthenticateParam.setAddressCity("长沙市");
        investorAuthenticateParam.setAddressArea("岳麓区");
        investorAuthenticateParam.setPhone("18674398766");
        investorAuthenticateParam.setEmail("123456@163.com");
        investorAuthenticateParam.setPersonalProfile("我爱唱歌跳舞打豆豆");
        //主投领域
        investorMainArea1.setMainCode("biomedicine");
        investorMainArea1.setMainName("生物医药");
        investorMainAreaList.add(investorMainArea1);
        investorMainArea2.setMainCode("artificial_intelligence");
        investorMainArea2.setMainName("人工智能(大数据、云计算)");
        investorMainAreaList.add(investorMainArea2);
        investorAuthenticateParam.setInvestorMainAreaList(investorMainAreaList);
        //主投轮次
        investorMainRound1.setMainRoundCode("angel_wheel");
        investorMainRound1.setMainRoundName("天使轮");
        investorMainRoundList.add(investorMainRound1);
        investorMainRound2.setMainRoundCode("a_round");
        investorMainRound2.setMainRoundName("A轮");
        investorMainRoundList.add(investorMainRound2);
        investorAuthenticateParam.setInvestorMainRoundList(investorMainRoundList);
        //工作经历
        investorWorkExperienceParam1.setStartTime("2014-09-01");
        investorWorkExperienceParam1.setEndTime("2018-06-30");
        investorWorkExperienceParam1.setCompanyName("湖南律师事务所");
        investorWorkExperienceParam1.setPosition("高级律师");
        investorWorkExperienceParamList.add(investorWorkExperienceParam1);
        investorWorkExperienceParam2.setStartTime("2018-07-15");
        investorWorkExperienceParam2.setEndTime("2019-03-30");
        investorWorkExperienceParam2.setCompanyName("长沙高新律师事务所");
        investorWorkExperienceParam2.setPosition("主任律师");
        investorWorkExperienceParamList.add(investorWorkExperienceParam2);
        investorAuthenticateParam.setInvestorWorkExperienceParamList(investorWorkExperienceParamList);
        //教育经历
        investorEduExperienceParam1.setStartTime("2008-09-01");
        investorEduExperienceParam1.setEndTime("2012-06-30");
        investorEduExperienceParam1.setSchoolName("湖南大学");
        investorEduExperienceParam1.setProfessionTitle("律师专业");
        investorEduExperienceParamList.add(investorEduExperienceParam1);
        investorEduExperienceParam2.setStartTime("2014-09-01");
        investorEduExperienceParam2.setEndTime("2016-06-30");
        investorEduExperienceParam2.setSchoolName("中南大学");
        investorEduExperienceParam2.setProfessionTitle("高级律师专业");
        investorEduExperienceParamList.add(investorEduExperienceParam2);
        investorAuthenticateParam.setInvestorEducationExperienceParamList(investorEduExperienceParamList);
    }

    /**
     * 投资人列表查询
     */
    @Test
    public void getInvestorInfoList() {
        PaginationData paginationData = investorService.getInvestorInfoList(investorInfoListParam);
        if(paginationData==null || paginationData.getRows()==null){
            //ignore
        }else{
            List<InvestorInfoListShow> investorInfoList=(List<InvestorInfoListShow>) paginationData.getRows();
            if(investorInfoList.isEmpty()){
                //ignore
            }else{
                for(InvestorInfoListShow investorInfoListShow:investorInfoList){
                    logger.info(investorInfoListShow.toString());
                }
            }
        }
        assertThat(paginationData,anything());
    }

    /**
     * 投资人详情
     */
    @Test
    public void getInvestorInfoDetails() {
        try {
            InvestorInfoDetailsVo investorInfoDetails = investorService.getInvestorInfoDetails(investorAccount);
            assertThat(investorInfoDetails,notNullValue());
        } catch (JnSpringCloudException e) {
            logger.warn("投资人详情查询失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(InvestorExceptionEnum.INVESTOR_INFO_NOT_EXIST.getCode())
                    )
            );
        }
    }

    /**
     * 查询所属单位
     */
    @Test
    public void getAffiliationUnit() {
        PaginationData paginationData = investorService.getAffiliationUnit(affiliationUnitInfoParam);
        if(paginationData == null || paginationData.getRows()==null){
            //ignore
        }else{
            List<AffiliationUnitShow> affiliationUnitList=(List<AffiliationUnitShow> )paginationData.getRows();
            for(AffiliationUnitShow affiliationUnitShow :affiliationUnitList){
                logger.info(affiliationUnitShow.toString());
            }
        }
        assertThat(paginationData,anything());
    }

    /**
     * 新增投资人认证信息
     */
    @Test
    public void addInvestorInfo() {
        try {
            investorService.addInvestorInfo(investorAuthenticateParam, investorAccount);
        } catch (JnSpringCloudException e) {
            logger.warn("新增投资人认证信息失败");
            assertThat(e.getMsg(),
                    Matchers.anyOf(
                            Matchers.containsString(InvestorExceptionEnum.INVESTOR_ACCOUNT_NOT_NULL.getMessage()),
                            Matchers.containsString(InvestorExceptionEnum.INVESTOR_INFO_NOT_NULL.getMessage()),
                            Matchers.containsString(InvestorExceptionEnum.INVESTOR_MAIN_AREA_NOT_NULL.getMessage()),
                            Matchers.containsString(InvestorExceptionEnum.INVESTOR_MAIN_ROUND_NOT_NULL.getMessage()),
                            Matchers.containsString(InvestorExceptionEnum.INVESTOR_INFO_EXIST.getMessage())
                    )
            );
        }
    }

    /**
     * 查询投资人主投领域
     */
    @Test
    public void getInvestorMainArea(){
        try {
            List<InvestorMainArea> investorMainAreaList = investorService.getInvestorMainArea();
            if(investorMainAreaList.isEmpty()){
                //ignore
            }else{
                for(InvestorMainArea investorMainArea :investorMainAreaList){
                   logger.info(investorMainArea.toString());
                }
            }
            assertThat(investorMainAreaList, anything());
        } catch (JnSpringCloudException e) {
            logger.warn("查询投资人主投领域失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(InvestorExceptionEnum.MAIN_AREA_INFO_NOT_EXIST.getCode())
                    )
            );
        }
    }

    /**
     * 查询投资人主投轮次
     */
    @Test
    public void getInvestorMainRound(){
        try {
            List<InvestorMainRound> investorMainRoundList = investorService.getInvestorMainRound();
            if(investorMainRoundList.isEmpty()){
                //ignore
            }else{
                for(InvestorMainRound  investorMainRound: investorMainRoundList){
                    logger.info(investorMainRound.toString());
                }
            }
            assertThat(investorMainRoundList, anything());
        } catch (JnSpringCloudException e) {
            logger.warn("查询投资人主投轮次失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(InvestorExceptionEnum.MAIN_ROUND_INFO_NOT_EXIST.getCode())
                    )
            );
        }
    }
}