package com.jn.enterprise.servicemarket.org.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.model.ServiceOrg;
import com.jn.enterprise.servicemarket.org.model.*;
import com.jn.enterprise.servicemarket.org.service.OrgService;
import com.jn.enterprise.servicemarket.org.vo.OrgDetailVo;
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

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

/**
 * @author： jiangyl
 * @date： Created on 2019/2/18 16:43
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudEnterpriseApplication.class})
public class OrgServiceImplTest {
    private Logger logger = LoggerFactory.getLogger(OrgServiceImplTest.class);

    @Autowired
    private OrgService orgService;

    private String orgId;
    private String account;

    @Before
    public void setUp() throws Exception {

        orgId = "1001211";
        account = "wangsong";
        
    }

    @Test
    public void selectServiceOrgList() {
        OrgParameter orgParameter = new OrgParameter();
        PaginationData paginationData = orgService.selectServiceOrgList(orgParameter);
        List<ServiceOrg> a = (List<ServiceOrg>)paginationData.getRows();
        assertThat(a.size(),greaterThanOrEqualTo(0));
    }

    @Test
    public void getServiceOrgDetail() {
        try{
            OrgDetailVo serviceOrgDetailVo = orgService.getServiceOrgDetail(orgId);
            assertThat(serviceOrgDetailVo,notNullValue());
        }catch (JnSpringCloudException e){
            logger.warn("机构不存在");
            assertThat(e.getCode(),equalTo(OrgExceptionEnum.ORG_IS_NOT_EXIT.getCode()));
        }

    }

    @Test
    public void saveOrUpdateOrgBasicData() {
        OrgBasicData orgBasicData = new OrgBasicData();
        orgBasicData.setOrgName("湖南鑫欧宇");
        orgBasicData.setOrgCode("430002521515151");
        orgBasicData.setOrgRegisterTime("2018-10-11");
        orgBasicData.setOrgSynopsis("服务商简介服务商简介服务商简介服务商简介");
        orgBasicData.setOrgBusiness("主营业务主营业务主营业务");
        orgBasicData.setOrgSpeciality(new String[]{"业务擅长业务","擅长业务擅长"});
        orgBasicData.setIndustrySector(new String[]{"行业领域1","行业领域2"});
        orgBasicData.setOrgLogo("机构LOGO机构LOGO---URL");
        orgBasicData.setDevelopmentStage(new String[]{"发展阶段2","发展阶段3","发展阶段4"});
        orgBasicData.setCompanyNature(new String[]{"企业性质1","企业性质2"});
        try{
            String s = orgService.saveOrUpdateOrgBasicData(orgBasicData, account);
            assertThat(s,notNullValue());
        }catch (JnSpringCloudException e){
            logger.warn("时间转换错误");
            assertThat(e.getCode(),equalTo(OrgExceptionEnum.ORG_TIME_PARSE_ERROR.getCode()));
        }
    }

    @Test
    public void saveOrgLicenseData() {
        OrgLicenseData orgLicenseData = new OrgLicenseData();
        orgLicenseData.setOrgId(orgId);
        orgLicenseData.setBusinessType("1242");
        List<OrgLicense> l = new ArrayList<>();
        OrgLicense orgLicense = new OrgLicense();
        orgLicense.setOrgId(orgId);
        orgLicense.setCertName("营业执照");
        orgLicense.setFileUrl("*****/test.png");
        orgLicense.setIsFeatures("0");
        orgLicense.setAwardTime("2018-01-01");
        orgLicense.setAwardDepart("长沙市工商管理局");
        orgLicense.setCertType("1");
        l.add(orgLicense);
        orgLicenseData.setLicenses(l);
        try{
            int i = orgService.saveOrgLicenseData(orgLicenseData,account);
            assertThat(i,equalTo(1));
        }catch (JnSpringCloudException e){
            logger.warn("时间转换错误");
            assertThat(e.getCode(),equalTo(OrgExceptionEnum.ORG_TIME_PARSE_ERROR.getCode()));
        }


    }

    @Test
    public void saveOrUpdateOrgTeamData() {
        OrgTeamData orgTeamData = new OrgTeamData();
        orgTeamData.setOrgId(orgId);
        orgTeamData.setStaffCount(100);
        orgTeamData.setProfessionNum(20);
        orgTeamData.setBachelorNum(20);
        orgTeamData.setMasterNum(20);
        orgTeamData.setDoctorNum(20);
        orgTeamData.setReturneeNum(20);
        List<OrgTeam> list = new ArrayList<>();
        OrgTeam team = new OrgTeam();
        team.setOrgId(orgId);
        team.setConName("张桑");
        team.setConPosition("财务主管");
        team.setConQuali("高级会计");
        team.setConTime("2015-01-01");
        team.setConSpeciality("业务特长业务特长业务特长");
        orgTeamData.setOrgTeams(list);
        try {
            int i = orgService.saveOrUpdateOrgTeamData(orgTeamData, account);
            assertThat(i,equalTo(1));
        }catch (JnSpringCloudException e){
            logger.warn("时间转换错误");
            assertThat(e.getCode(),equalTo(OrgExceptionEnum.ORG_TIME_PARSE_ERROR.getCode()));
        }
    }

    @Test
    public void saveOrUpdateOrgContactData() {
        OrgContactData contact = new OrgContactData();
        contact.setOrgProvince("湖南");
        contact.setOrgCity("长沙");
        contact.setOrgArea("岳麓");
        contact.setOrgAddress("麓谷企业广场");
        contact.setOrgPhone("42222111");
        contact.setConName("王五");
        contact.setOrgWeb("www.baidu.com");
        contact.setConPhone("1817555555");
        contact.setConEmail("123456@qq.com");
        int i = orgService.saveOrUpdateOrgContactData(contact, account);
        assertThat(i,equalTo(1));
    }


}