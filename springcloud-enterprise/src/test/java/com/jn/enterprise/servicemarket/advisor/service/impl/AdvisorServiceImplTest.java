package com.jn.enterprise.servicemarket.advisor.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.servicemarket.advisor.model.*;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorService;
import com.jn.enterprise.servicemarket.advisor.vo.AdvisorDetailsVo;
import com.jn.enterprise.servicemarket.comment.model.ServiceRating;
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


    private AdvisorListParam advisorListParam =new AdvisorListParam();

    private ServiceEvaluationParam serviceEvaluationParam =new ServiceEvaluationParam();

    @Before
    public void setUp() throws Exception {
        domain="";
        sortTypes="";
        keyWords="";
        advisorListParam.setDomain(domain);
        advisorListParam.setKeyWords(keyWords);
        advisorListParam.setSortTypes(sortTypes);
        advisorListParam.setTemplateId("6fda8a513cd64070925625521fa6a53a");
        //advisorListParam.setOrgId("1001211");
        //advisorAccount="wangsong";

        serviceEvaluationParam.setIsPublicPage("0");
        serviceEvaluationParam.setAdvisorAccount(advisorAccount);
        //serviceEvaluationParam.setRatingType("??????");
        serviceEvaluationParam.setNeedPage("0");
    }

    /**
     * ????????????????????????
     */
    @Test
    public void getServiceConsultantList() {
        PaginationData paginationData = advisorService.getServiceConsultantList(advisorListParam, Boolean.TRUE);
        List<AdvisorListInfo> list= (List<AdvisorListInfo>)paginationData.getRows();
        if(list!=null){
            for(AdvisorListInfo advisorListInfo:list){
                logger.info("????????????????????????{}",advisorListInfo.toString());
            }
            assertThat(list.size(),greaterThanOrEqualTo(0));
        }else{
            assertThat(anything(),anything());
        }
    }

    /**
     * ????????????????????????????????????
     */
    @Test
    public void getServiceAdvisorInfo(){
        try {
            AdvisorDetailsVo advisorDetailsVo = advisorService.getServiceAdvisorInfo(advisorAccount,"2");
            if(advisorDetailsVo!=null){
                logger.info(advisorDetailsVo.getAdvisorServiceInfo().toString());
                logger.info("????????????{}",advisorDetailsVo.getEvaluationTotal()+"");
                logger.info("?????????{}",advisorDetailsVo.getPraiseNum()+"");
                logger.info("?????????{}",advisorDetailsVo.getAverageNum()+"");
                logger.info("?????????{}",advisorDetailsVo.getBadReviewNum()+"");
            }
            assertThat(advisorDetailsVo,notNullValue());
        } catch (JnSpringCloudException e) {
            logger.info("??????????????????????????????????????????");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(AdvisorExceptionEnum.ADVISOR_INFO_NOT_EXIST.getCode())
                    )
            );
        }


    }

    /**
     * ??????????????????????????????????????????
     */
    @Test
    public void getServiceRatingInfo(){
        try {
            PaginationData pageData = advisorService.getServiceRatingInfo(serviceEvaluationParam);
            if(pageData.getRows()!=null){
                List<ServiceRating> serviceRatingList=(List<ServiceRating> )pageData.getRows();
                for(ServiceRating serviceRating:serviceRatingList){
                    logger.info("??????????????????????????????????????????:{}",serviceRating.toString());
                }
                assertThat(serviceRatingList.size(), greaterThanOrEqualTo(0));
            }else{
                assertThat(pageData,anything());
            }
        } catch (JnSpringCloudException e) {

            logger.info("????????????????????????????????????????????????");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(AdvisorExceptionEnum.EVALUATION_ID_NOT_NULL.getCode())
                    )
            );
        }

    }

    /**
     * ????????????????????????
     */
    @Test
    public void getServiceExperienceInfo(){
        List<ServiceExperience> serviceExperienceInfo = advisorService.getServiceExperienceInfo(advisorAccount);
        if(serviceExperienceInfo.isEmpty()){
            assertThat(serviceExperienceInfo, anything());
        }else{
            for(ServiceExperience serviceExperience:serviceExperienceInfo){
                logger.info(serviceExperience.toString());
            }
            assertThat(serviceExperienceInfo, notNullValue());
        }
    }

    /**
     * ????????????????????????
     */
    @Test
    public void getProjectExperienceInfo(){
        List<ServiceProjectExperience> projectExperienceInfo = advisorService.getProjectExperienceInfo(advisorAccount);
        if(projectExperienceInfo.isEmpty()){
            assertThat(projectExperienceInfo, anything());
        }else{
            for(ServiceProjectExperience serviceProjectExperience:projectExperienceInfo){
                logger.info(serviceProjectExperience.toString());
            }
            assertThat(projectExperienceInfo, notNullValue());
        }
    }

    /**
     * ??????????????????????????????
     */
    @Test
    public void getAdvisorHonorInfo(){
        List<ServiceHonor> advisorHonorInfo = advisorService.getAdvisorHonorInfo(advisorAccount);
        if(advisorHonorInfo.isEmpty()){
            assertThat(advisorHonorInfo, anything());
        }else{
            for(ServiceHonor serviceHonor:advisorHonorInfo){
                logger.info(serviceHonor.toString());
            }
            assertThat(advisorHonorInfo, notNullValue());
        }
    }

    /**
     * ??????????????????????????????????????????
     */
    @Test
    public void getAdvisorInfoByAccount(){
        try {
            AdvisorServiceInfo advisorInfoByAccount = advisorService.getAdvisorInfoByAccount(advisorAccount,"2");
            assertThat(advisorInfoByAccount, notNullValue());
        } catch (JnSpringCloudException e) {
            logger.info("????????????????????????????????????????????????");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(AdvisorExceptionEnum.ADVISOR_INFO_NOT_EXIST.getCode())
                    )
            );
        }
    }

    /**
     * ????????????????????????
     */
    @Test
    public void getEvaluationCountInfo(){
        try {
            EvaluationCountInfo evaluationCountInfo = advisorService.getEvaluationCountInfo(serviceEvaluationParam);
            if(evaluationCountInfo!=null){
                logger.info("????????????????????????{}",evaluationCountInfo.toString());
            }
            assertThat(evaluationCountInfo, anything());
        } catch (JnSpringCloudException e) {
            logger.info("??????????????????????????????????????????????????????");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(AdvisorExceptionEnum.EVALUATION_ID_NOT_NULL.getCode())
                    )
            );
        }
    }
}