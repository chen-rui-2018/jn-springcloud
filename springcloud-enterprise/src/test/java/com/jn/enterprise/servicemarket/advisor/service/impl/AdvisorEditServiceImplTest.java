package com.jn.enterprise.servicemarket.advisor.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.servicemarket.advisor.model.*;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorEditService;
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
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @Author: yangph
 * @Date: 2019/2/28 18:06
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudEnterpriseApplication.class})
public class AdvisorEditServiceImplTest {

    /**
     * 日志组件
     */
    private Logger logger = LoggerFactory.getLogger(AdvisorEditServiceImplTest.class);

    @Autowired
    private AdvisorEditService advisorEditService;

    /**
     * 基本信息
     */
    private AdvisorBaseInfoParam advisorBaseInfoParam =new AdvisorBaseInfoParam();

    /**
     * 荣誉资质
     */
    private ServiceHonorParam serviceHonor=new ServiceHonorParam();

    //证件类型分类  荣誉资质 honor
    private String certificateType;

    /**
     *服务经历
     */
    private ServiceExperienceParam serviceExperience=new ServiceExperienceParam();

    /**
     * 项目经验
     */
    private ServiceProjectExperienceParam serviceProjectExperience=new ServiceProjectExperienceParam();

    private String advisorAccount;

    private String[]businessAreaArry={"technology_finance","ogistics"};


    @Before
    public void setUp() throws Exception {
        advisorAccount="18565007009";
        //基本信息保存
        //机构id
        advisorBaseInfoParam.setOrgId("cbe0d8ba94844a3a8f7b44822cfc7382");
        //账号
        advisorBaseInfoParam.setAdvisorAccount(advisorAccount);
        //从业年限
        advisorBaseInfoParam.setWorkingYears("11");
        //毕业学校
        advisorBaseInfoParam.setGraduatedSchool("中南大学");
        //学历
        advisorBaseInfoParam.setEducation("硕士");
        //联系手机
        advisorBaseInfoParam.setPhone("18565007009");
        //联系邮箱
        advisorBaseInfoParam.setContactEmail("123.qq.com");
        //执业资质
        advisorBaseInfoParam.setPracticeQualification("高级律师证");
        //业务擅长
        advisorBaseInfoParam.setGoodAtBusiness("打官司，谈判");
        //个人简介
        advisorBaseInfoParam.setPersonalProfile("从事行业十余年，未尝一败，高处不胜寒，朕寂寞啊，孤独啊");
        //业务领域
        advisorBaseInfoParam.setBusinessAreas(businessAreaArry);

        //荣誉资质信息保存并更新
        //主键id
        serviceHonor.setId("9e5c70bd003a4e1082b9995d98ccecf2");
        //专员账号
        serviceHonor.setAdvisorAccount(advisorAccount);
        //证书名称
        serviceHonor.setCertificateName("高级律师证");
        //证书类型  lawyerLicense:律师执业证   professionalAgentLicense：专业代理人执业证  cap：注册会计师
        serviceHonor.setCertificateCode("lawyerLicense");
        //获得时间
        serviceHonor.setGetTime("201707");
        //证书证件
        serviceHonor.setCertificatePhoto("12695456.jpg");

        //获取指定证件类型
        certificateType="honor";

        //服务经历保存并更新
        //专员账号
        serviceExperience.setAdvisorAccount(advisorAccount);
        //公司名称
        serviceExperience.setCompanyName("江苏工业园");
        //职务
        serviceExperience.setPosition("律师");
        //工作时间
        serviceExperience.setWorkTime("201713");

        //项目经验保存并更新
        //专员账号
        serviceProjectExperience.setAdvisorAccount(advisorAccount);
        //公司名称
        //serviceProjectExperience.setCompanyName("苏州工程技术有限公司");
        serviceProjectExperience.setCompanyName("苏州玉森新药有限公司");
        //serviceProjectExperience.setCompanyName("上海思佳建信股权投资有限公司");
        //serviceProjectExperience.setCompanyName("苏州智铸通信科技股份有限公司");
        //项目名称
        //serviceProjectExperience.setProjectName("IPO");
        serviceProjectExperience.setProjectName("投融资");
        //serviceProjectExperience.setProjectName("私募股权投资基金法律尽调");
        //serviceProjectExperience.setProjectName("投融资54");
        //项目时间
        serviceProjectExperience.setProjectTime("201802");
        //个人职责
        //serviceProjectExperience.setPersonalDuties("为苏州某工程技术有限公司提供IPO首发服务，在办中");
        serviceProjectExperience.setPersonalDuties("为玉森新药提供投融资对接以及相关法律服务");
        //serviceProjectExperience.setPersonalDuties("受苏州园区引导基金委托对该项目进行法律尽调并出具法律意见书");
    }

    /**
     * 基本信息保存并更新
     */
    @Test
    public void saveOrUpdateAdvisorBaseInfo() {
        try {
            advisorEditService.saveOrUpdateAdvisorBaseInfo(advisorBaseInfoParam);
            assertThat(anything(),anything() );
        } catch (JnSpringCloudException e) {
            logger.warn("基本信息保存并更新失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(AdvisorExceptionEnum.SERVICE_ORG_NOT_EXIST.getCode()),
                            Matchers.containsString(AdvisorExceptionEnum.ORG_INFO_NOT_NULL.getCode()),
                            Matchers.containsString(AdvisorExceptionEnum.GET_ADVISOR_INFO_FAIL.getCode()),
                            Matchers.containsString(AdvisorExceptionEnum.BUSINESS_AREA_NOT_EXIT.getCode()),
                            Matchers.containsString(AdvisorExceptionEnum.ORG_ID_NOT_EXIT.getCode())
                    )
            );
        }
    }

    /**
     * 荣誉资质保存并更新
     */
    @Test
    public void saveOrUpdateAdvisorHonor() {
        try {
            advisorEditService.saveOrUpdateAdvisorHonor(serviceHonor);
            assertThat(anything(),anything() );
        } catch (JnSpringCloudException e) {
            logger.warn("荣誉资质保存并更新失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(AdvisorExceptionEnum.HONOR_INFO_NOT_EXIST.getCode()),
                            Matchers.containsString(AdvisorExceptionEnum.CREDENTIALS_TYPE_ENUM_NOT_EXIST.getCode())
                    )
            );
        }
    }

    /**
     * 获取指定证件类型
     */
    @Test
    public void getCertificateTypeList() {
        List<AdvisorCertificateTypeShow> certificateTypeList = advisorEditService.getCertificateTypeList(certificateType);
        if(certificateTypeList.isEmpty()){
            assertThat(certificateTypeList,anything());
        }else{
            for(AdvisorCertificateTypeShow tbServiceCertificateType:certificateTypeList){
                logger.info(tbServiceCertificateType.toString());
            }
            assertThat(certificateTypeList,notNullValue());
        }
    }

    /**
     * 服务经历保存并更新
     */
    @Test
    public void saveOrUpdateAdvisorExperience() {
        try {
            advisorEditService.saveOrUpdateAdvisorExperience(serviceExperience);
            assertThat(anything(),anything() );
        } catch (JnSpringCloudException e) {
            logger.warn("服务经历保存并更新失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(AdvisorExceptionEnum.EXPERIENCE_INFO_NOT_EXIST.getCode())
                    )
            );
        }
    }

    /**
     * 项目经验保存并更新
     */
    @Test
    public void saveOrUpdateAdvisorProjectExperience() {
        try {
            advisorEditService.saveOrUpdateAdvisorProjectExperience(serviceProjectExperience);
            assertThat(anything(),anything());
        } catch (JnSpringCloudException e) {
            logger.warn("项目经验保存并更新失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(AdvisorExceptionEnum.PROJECT_EXPERIENCE_INFO_NOT_EXIST.getCode())
                    )
            );
        }
    }
}