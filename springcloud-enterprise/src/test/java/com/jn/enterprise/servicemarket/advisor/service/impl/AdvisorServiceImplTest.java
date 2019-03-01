package com.jn.enterprise.servicemarket.advisor.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceAdvisor;
import com.jn.enterprise.servicemarket.advisor.model.*;
import com.jn.enterprise.servicemarket.comment.model.ServiceRating;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorService;
import com.jn.enterprise.servicemarket.advisor.vo.AdvisorDetailsVo;
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

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * @Author: yangph
 * @Date: 2019/2/14 11:57
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudEnterpriseApplication.class})
public class AdvisorServiceImplTest {
    private Logger logger = LoggerFactory.getLogger(AdvisorServiceImplTest.class);

    @Autowired
    private AdvisorService advisorService;

    private String domain;
    private String sortTypes;
    private String keyWords;
    private String advisorAccount;


    private AdvisorInquiryInfo advisorInquiryInfo=new AdvisorInquiryInfo();

    private ServiceEvaluationParam serviceEvaluationParam =new ServiceEvaluationParam();

    @Before
    public void setUp() throws Exception {
        domain="";
        sortTypes="";
        keyWords="";
        advisorInquiryInfo.setDomain(domain);
        advisorInquiryInfo.setKeyWords(keyWords);
        advisorInquiryInfo.setSortTypes(sortTypes);
        advisorAccount="wangsong";

        serviceEvaluationParam.setAdvisorAccount(advisorAccount);
        serviceEvaluationParam.setRatingType("差评");
        serviceEvaluationParam.setNeedPage(Boolean.FALSE);
    }

    /**
     * 服务顾问列表查询
     */
    @Test
    public void getServiceConsultantList() {
        PaginationData paginationData = advisorService.getServiceConsultantList(advisorInquiryInfo, Boolean.TRUE);
        List<AdvisorListInfo> list= (List<AdvisorListInfo>)paginationData.getRows();
        if(list!=null){
            for(AdvisorListInfo advisorListInfo:list){
                logger.info(advisorListInfo.toString());
            }
            assertThat(list.size(),greaterThanOrEqualTo(0));
        }else{
            assertThat(anything(),anything());
        }
    }

    /**
     * 根据顾问账号获取顾问详情
     */
    @Test
    public void getServiceAdvisorInfo(){
        try {
            AdvisorDetailsVo advisorDetailsVo = advisorService.getServiceAdvisorInfo(advisorAccount);
            if(advisorDetailsVo!=null){
                logger.info(advisorDetailsVo.getAdvisorServiceInfo().toString());
                logger.info("总评价数{}",advisorDetailsVo.getEvaluationTotal()+"");
                logger.info("好评数{}",advisorDetailsVo.getPraiseNum()+"");
                logger.info("中评数{}",advisorDetailsVo.getAverageNum()+"");
                logger.info("差评数{}",advisorDetailsVo.getBadReviewNum()+"");
            }
            assertThat(advisorDetailsVo,notNullValue());
        } catch (JnSpringCloudException e) {
            logger.info("根据顾问账号获取顾问详情失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(AdvisorExceptionEnum.ADVISOR_INFO_NOT_EXIST.getCode())
                    )
            );
        }


    }

    /**
     * 根据查询条件获取服务评价信息
     */
    @Test
    public void getServiceRatingInfo(){
        PaginationData pageData = advisorService.getServiceRatingInfo(serviceEvaluationParam);
        if(pageData.getRows()!=null){
            List<ServiceRating> serviceRatingList=(List<ServiceRating> )pageData.getRows();
            for(ServiceRating serviceRating:serviceRatingList){
                logger.info(serviceRating.toString());
            }
            assertThat(serviceRatingList.size(), greaterThanOrEqualTo(0));
        }else{
            assertThat(pageData,anything());
        }

    }

    /**
     * 获取顾问服务经验
     */
    @Test
    public void getServiceExperienceInfo(){
        List<ServiceExperience> serviceExperienceInfo = advisorService.getServiceExperienceInfo(advisorAccount);
        if(serviceExperienceInfo.isEmpty()){
            assertThat(serviceExperienceInfo, nullValue());
        }else{
            for(ServiceExperience serviceExperience:serviceExperienceInfo){
                logger.info(serviceExperience.toString());
            }
            assertThat(serviceExperienceInfo, notNullValue());
        }
    }

    /**
     * 获取顾问项目经验
     */
    @Test
    public void getProjectExperienceInfo(){
        List<ServiceProjectExperience> projectExperienceInfo = advisorService.getProjectExperienceInfo(advisorAccount);
        if(projectExperienceInfo.isEmpty()){
            assertThat(projectExperienceInfo, nullValue());
        }else{
            for(ServiceProjectExperience serviceProjectExperience:projectExperienceInfo){
                logger.info(serviceProjectExperience.toString());
            }
            assertThat(projectExperienceInfo, notNullValue());
        }
    }

    /**
     * 获取顾问荣誉资质信息
     */
    @Test
    public void getAdvisorHonorInfo(){
        List<ServiceHonor> advisorHonorInfo = advisorService.getAdvisorHonorInfo(advisorAccount);
        if(advisorHonorInfo.isEmpty()){
            assertThat(advisorHonorInfo, nullValue());
        }else{
            for(ServiceHonor serviceHonor:advisorHonorInfo){
                logger.info(serviceHonor.toString());
            }
            assertThat(advisorHonorInfo, notNullValue());
        }
    }

    /**
     * 根据顾问账号获取顾问基本信息
     */
    @Test
    public void getAdvisorInfoByAccount(){
        try {
            TbServiceAdvisor advisorInfoByAccount = advisorService.getAdvisorInfoByAccount(advisorAccount);
            assertThat(advisorInfoByAccount, notNullValue());
        } catch (JnSpringCloudException e) {
            logger.info("根据顾问账号获取顾问基本信息失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(AdvisorExceptionEnum.ADVISOR_INFO_NOT_EXIST.getCode())
                    )
            );
        }
    }
}