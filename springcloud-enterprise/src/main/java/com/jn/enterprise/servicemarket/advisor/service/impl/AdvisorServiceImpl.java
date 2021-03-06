package com.jn.enterprise.servicemarket.advisor.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.servicemarket.advisor.dao.*;
import com.jn.enterprise.servicemarket.advisor.entity.*;
import com.jn.enterprise.servicemarket.advisor.enums.ServiceSortTypeEnum;
import com.jn.enterprise.servicemarket.advisor.model.*;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorEditService;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorService;
import com.jn.enterprise.servicemarket.advisor.vo.AdvisorDetailsVo;
import com.jn.enterprise.servicemarket.comment.model.ServiceRating;
import com.jn.enterprise.servicemarket.industryarea.model.IndustryDictParameter;
import com.jn.enterprise.servicemarket.industryarea.model.IndustryDictionary;
import com.jn.enterprise.servicemarket.industryarea.service.IndustryService;
import com.jn.enterprise.servicemarket.product.model.AdvisorProductInfo;
import com.jn.enterprise.servicemarket.product.model.AdvisorProductQuery;
import com.jn.enterprise.servicemarket.product.service.ServiceProductService;
import com.jn.enterprise.utils.IBPSFileUtils;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ζε‘δΈε
 * @Author: yangph
 * @Date: 2019/2/12 16:40
 * @Version v1.0
 * @modified By:
 */
@Service
public class AdvisorServiceImpl implements AdvisorService {
    /**
     * ζ₯εΏη»δ»Ά
     */
    private static Logger logger = LoggerFactory.getLogger(AdvisorServiceImpl.class);

    @Autowired
    private AdvisorMapper advisorMapper;

    @Autowired
    private TbServiceAdvisorMapper tbServiceAdvisorMapper;

    @Autowired
    private TbServiceHonorMapper tbServiceHonorMapper;

    @Autowired
    private TbServiceProExperMapper tbServiceProExperMapper;

    @Autowired
    private TbServiceExperienceMapper tbServiceExperienceMapper;

    @Autowired
    private ServiceProductService serviceProductService;

    @Autowired
    private UserExtensionClient userExtensionClient;

    @Autowired
    private IndustryService industryService;

    @Autowired
    private AdvisorEditService advisorEditService;

    /**
     * ζε‘δΈεεθ‘¨ζ₯θ―’
     * @param advisorListParam ζ₯θ―’ζ‘δ»Ά
     * @param needPage           ζ―ε¦ιθ¦ει‘΅
     * @return
     */
    @Override
    @ServiceLog(doAction = "ζε‘δΈεεθ‘¨ζ₯θ―’")
    public PaginationData getServiceConsultantList(AdvisorListParam advisorListParam, Boolean needPage) {
        com.github.pagehelper.Page<Object> objects = null;
        if(needPage){
            objects = PageHelper.startPage(advisorListParam.getPage(), advisorListParam.getRows() == 0 ? 15 : advisorListParam.getRows(), true);
        }else{
            objects = PageHelper.startPage(1, 100, true);
        }
        AdvisorQueryConditions queryConditions=new AdvisorQueryConditions();
        BeanUtils.copyProperties(advisorListParam, queryConditions);
        if(StringUtils.isBlank(queryConditions.getSortTypes()) ){
            //ι»θ?€η»ΌεζεΊ
            queryConditions.setSortTypes(ServiceSortTypeEnum.INTEGRATE.getCode());
        }
        if(ServiceSortTypeEnum.INTEGRATE.getCode().equals(queryConditions.getSortTypes())) {
            //
        }
        List<AdvisorListInfo> advisorListInfoList=advisorMapper.getServiceConsultantList(queryConditions);
        return new PaginationData(advisorListInfoList, objects == null ? 0 : objects.getTotal());
    }

    /**
     * ζ Ήζ?δΈεθ΄¦ε·θ·εδΈεθ―¦ζ
     * @param advisorAccount δΈεθ΄¦ε·
     * @param approvalStatus ε?‘ζΉηΆζ ( - 1οΌε·²ζη»    0οΌζͺει¦   1οΌεΎε?‘ζΉ     2οΌε?‘ζΉιθΏ    3οΌε?‘ζΉδΈιθΏ    4οΌε·²θ§£ι€)
     * @return
     */
    @ServiceLog(doAction = "ζ Ήζ?δΈεθ΄¦ε·θ·εδΈεθ―¦ζ")
    @Override
    public AdvisorDetailsVo getServiceAdvisorInfo(String advisorAccount,String approvalStatus) {
        AdvisorDetailsVo advisorDetailsVo=new AdvisorDetailsVo();
        //1.θ·εη¨ζ·εΊζ¬δΏ‘ζ―
        AdvisorServiceInfo advisorServiceInfo= getAdvisorInfoByAccount(advisorAccount,approvalStatus);
        if(advisorServiceInfo==null){
            return null;
        }
        //θ?Ύη½?δΈεεΊη‘δΏ‘ζ―
        advisorDetailsVo.setAdvisorServiceInfo(advisorServiceInfo);
        //εε»ΊδΈεθ―¦ζη?δ»ε―Ήθ±‘
        AdvisorIntroduction advisorIntroduction=new AdvisorIntroduction();
        BeanUtils.copyProperties(advisorServiceInfo, advisorIntroduction);
        //θ?Ύη½?δΈεη?δ»δΏ‘ζ―
        advisorDetailsVo.setAdvisorIntroduction(advisorIntroduction);
        //2.θ·εδΈεθ£θͺθ΅θ΄¨
        List<ServiceHonor> advisorHonorInfoList = getAdvisorHonorInfo(advisorAccount);
        //θ?Ύη½?δΈεθ£θͺθ΅θ΄¨δΏ‘ζ―
        advisorDetailsVo.setServiceHonorList(advisorHonorInfoList);
        //3.θ·εδΈει‘Ήη?η»ιͺ
        List<ServiceProjectExperience> serviceProjectExperienceList = getProjectExperienceInfo(advisorAccount);
        //θ?Ύη½?δΈει‘Ήη?η»ιͺ
        advisorDetailsVo.setServiceProjectExperienceList(serviceProjectExperienceList);
        //4.θ·εδΈεζε‘η»ε
        List<ServiceExperience> serviceExperienceList = getServiceExperienceInfo(advisorAccount);
        //θ?Ύη½?δΈεζε‘η»ε
        advisorDetailsVo.setServiceExperienceList(serviceExperienceList);
        //5.θ·εζε‘δΊ§ε
        AdvisorProductQuery advisorProductQuery=new AdvisorProductQuery();
        advisorProductQuery.setAdvisorAccount(advisorAccount);
        PaginationData paginationData = serviceProductService.advisorProductList(advisorProductQuery, Boolean.FALSE);
        List<AdvisorProductInfo> advisorProductInfoList =(List<AdvisorProductInfo> )paginationData.getRows();
        //θ?Ύη½?ζε‘δΊ§ε
        advisorDetailsVo.setAdvisorProductInfoList(advisorProductInfoList);
        //6.θ·εζε‘θ―δ»·  //ι»θ?€ζ₯ε¨ι¨
        String ratingType="ε¨ι¨";
        ServiceEvaluationParam serviceEvaluationParam =new ServiceEvaluationParam();
        serviceEvaluationParam.setAdvisorAccount(advisorAccount);
        serviceEvaluationParam.setRatingType(ratingType);
        serviceEvaluationParam.setNeedPage("0");
        PaginationData pageData = getServiceRatingInfo(serviceEvaluationParam);
        List<ServiceRating> serviceRatingInfoList =(List<ServiceRating>) pageData.getRows();
        if(!serviceRatingInfoList.isEmpty()){
            setRatingNum(advisorDetailsVo, advisorIntroduction, serviceRatingInfoList);
            advisorDetailsVo.setServiceRatingList(serviceRatingInfoList);
        }

        //7.ζ΄ζ°δΈεδΏ‘ζ―ζ΅θ§ι
        updateAdvisorPageviews(advisorAccount);
        return advisorDetailsVo;
    }

    /**
     * θ?Ύη½?δΈεθ―¦ζδΈ­ζε‘θ―δ»·ηθ―δ»·ζ°ι
     * @param advisorDetailsVo      δΈεθ―¦ζθΏεεη«―ε―Ήθ±‘
     * @param advisorIntroduction   δΈεθ―¦ζη?δ»ε―Ήθ±‘
     * @param serviceRatingInfoList ζε‘θ―δ»·ζ₯θ―’η»ζι
     */
    @ServiceLog(doAction = "θ?Ύη½?δΈεθ―¦ζδΈ­ζε‘θ―δ»·ηθ―δ»·ζ°ι")
    private void setRatingNum(AdvisorDetailsVo advisorDetailsVo, AdvisorIntroduction advisorIntroduction, List<ServiceRating> serviceRatingInfoList) {
        //ε₯½θ―εΎε
        int praiseScore=5;
        //δΈ­θ―ζδ½ε
        int averageScore=3;
        //ε·?θ―ζδ½ε
        int badReviewScore=1;
        //ζε‘θ―ε
        float evaluationScore=0f;
        for(ServiceRating serviceRating:serviceRatingInfoList){
            if(serviceRating.getEvaluationScore()==null){
                continue;
            }
            float score = Float.parseFloat(serviceRating.getEvaluationScore());
            if(score==praiseScore){
                //ε₯½θ―ζ°ε 1
                advisorDetailsVo.setPraiseNum(advisorDetailsVo.getPraiseNum()+1);
            }else if(score>=averageScore && score<praiseScore){
                //δΈ­θ―ζ°ε 1
                advisorDetailsVo.setAverageNum(advisorDetailsVo.getAverageNum()+1);
            }else if(score>=badReviewScore && score<averageScore){
                //ε·?θ―ζ°ε 1
                advisorDetailsVo.setAverageNum(advisorDetailsVo.getAverageNum()+1);
            }
            evaluationScore+=score;
        }
        //θ―δ»·ζ»ζ°
        advisorDetailsVo.setEvaluationTotal(advisorDetailsVo.getPraiseNum()+advisorDetailsVo.getAverageNum()+advisorDetailsVo.getBadReviewNum());

        //θ?‘η?δΈεζη»ζε‘θ―ε
        evaluationScore=evaluationScore/serviceRatingInfoList.size();
        if(evaluationScore>0){
            //δΈεθ―¦ζη?δ»θ?Ύη½?ζε‘θ―ε
            advisorIntroduction.setEvaluationScore(evaluationScore+"");
        }
    }

    /**
     * ζ Ήζ?ζ₯θ―’ζ‘δ»Άθ·εζε‘θ―δ»·δΏ‘ζ―
     * @param serviceEvaluationParam   ζε‘θ―δ»·δΏ‘ζ―ζ₯θ―’ε₯ε
     * @return
     */
    @ServiceLog(doAction = "ζ Ήζ?ζ₯θ―’ζ‘δ»Άθ·εζε‘θ―δ»·δΏ‘ζ―")
    @Override
    public PaginationData getServiceRatingInfo(ServiceEvaluationParam serviceEvaluationParam) {
        //ζ―ε¦ε¬ε±ι‘΅ι’  1οΌζ―  0οΌε¦
        Page<Object> objects = evaluationDataProcessing(serviceEvaluationParam);
        List<ServiceRating> serviceRatingInfo = advisorMapper.getServiceRatingInfo(serviceEvaluationParam);
        return getEvaluationPaginationData(objects, serviceRatingInfo);
    }

    /**
     * ζε‘θ―δ»·ε₯εζ°ζ?ε€η
     * @param serviceEvaluationParam
     * @return
     */
    @ServiceLog(doAction = "ζε‘θ―δ»·ε₯εζ°ζ?ε€η")
    private Page<Object> evaluationDataProcessing(ServiceEvaluationParam serviceEvaluationParam) {
        String isPublicPage="0";
        if(isPublicPage.equals(serviceEvaluationParam.getIsPublicPage()) && StringUtils.isBlank(serviceEvaluationParam.getOrgId())
                && StringUtils.isBlank(serviceEvaluationParam.getProductId()) && StringUtils.isBlank(serviceEvaluationParam.getAdvisorAccount())){
            logger.warn("ζ Ήζ?ζ₯θ―’ζ‘δ»Άθ·εζε‘θ―δ»·δΏ‘ζ―ηζΊζid,δΊ§εid,δΈεθ΄¦ε·δΈθ½ι½δΈΊη©Ί");
            throw new JnSpringCloudException(AdvisorExceptionEnum.EVALUATION_ID_NOT_NULL);
        }
        Page<Object> objects = null;
        //ιθ¦ει‘΅ζ θ―
        String isPage="1";
        if(isPage.equals(serviceEvaluationParam.getNeedPage())){
            objects = PageHelper.startPage(serviceEvaluationParam.getPage(),
                    serviceEvaluationParam.getRows() == 0 ? 15 : serviceEvaluationParam.getRows(), true);
        }
        return objects;
    }

    /**
     * ε°θ£ε€ηθ―δ»·δΏ‘ζ―
     * @param objects
     * @param serviceRatingInfo
     * @return
     */
    @ServiceLog(doAction = "ε°θ£ε€ηθ―δ»·δΏ‘ζ―")
    private PaginationData getEvaluationPaginationData(Page<Object> objects, List<ServiceRating> serviceRatingInfo) {
        if(serviceRatingInfo.isEmpty()){
            return new PaginationData(serviceRatingInfo, objects == null ? 0 : objects.getTotal());
        }
        List<String> accountList=new ArrayList<>(16);
        //θ·εθ―δ»·δΊΊε§εοΌε€΄ε
        for(ServiceRating serviceRating:serviceRatingInfo){
            accountList.add(serviceRating.getEvaluationAccount());
        }
        Result<List<UserExtensionInfo>> moreUserExtension = userExtensionClient.getMoreUserExtension(accountList);
        if(moreUserExtension!=null &&  moreUserExtension.getData()!=null){
            List<UserExtensionInfo>userExtensionInfoList= moreUserExtension.getData();
            for(ServiceRating serviceRating:serviceRatingInfo){
                //ε€ηδΊ§εεΎη
                serviceRating.setPictureUrl(IBPSFileUtils.getFilePath(serviceRating.getPictureUrl()));
                for(UserExtensionInfo userExtensionInfo:userExtensionInfoList){
                    if(StringUtils.equals(serviceRating.getEvaluationAccount(),userExtensionInfo.getAccount())){
                        //ε€΄ε
                        serviceRating.setEvaluationAvatar(userExtensionInfo.getAvatar());
                        //ε§ε
                        serviceRating.setEvaluationName(userExtensionInfo.getName());
                        //ε€ηθ΄¦ε·
                        String advisorAccount = serviceRating.getEvaluationAccount();
                        int length=advisorAccount.length();
                        String subAccount="";
                        if(length>4){
                            subAccount=advisorAccount.substring(0, 3)+"***"+advisorAccount.substring(length-2, length);
                        }else if(advisorAccount.length()>0){
                            subAccount=advisorAccount.substring(0, 1)+"***"+advisorAccount.substring(length-2, length);
                        }
                        serviceRating.setEvaluationAccount(subAccount);
                        break;
                    }
                }
            }
        }
        return new PaginationData(serviceRatingInfo, objects == null ? 0 : objects.getTotal());
    }

    /**
     * ζ΄ζ°δΈεδΏ‘ζ―ηζ΅θ§ι
     * @param advisorAccount
     */
    @ServiceLog(doAction = "ζ΄ζ°δΈεδΏ‘ζ―ηζ΅θ§ι")
    private void updateAdvisorPageviews(String advisorAccount) {
        TbServiceAdvisorCriteria example=new TbServiceAdvisorCriteria();
        example.createCriteria().andAdvisorAccountEqualTo(advisorAccount);
        List<TbServiceAdvisor> tbServiceAdvisors = tbServiceAdvisorMapper.selectByExample(example);
        if(tbServiceAdvisors.isEmpty()){
            logger.warn("ε½εδΈε[{}]δΏ‘ζ―δΈε­ε¨",advisorAccount);
            throw new JnSpringCloudException(AdvisorExceptionEnum.ADVISOR_INFO_NOT_EXIST);
        }
        TbServiceAdvisor advisorInfo=new TbServiceAdvisor();
        //ζ΅θ§ιε 1
        int num = tbServiceAdvisors.get(0).getPageViews() == null ? 0 : tbServiceAdvisors.get(0).getPageViews();
        advisorInfo.setPageViews(num+1);
        tbServiceAdvisorMapper.updateByExampleSelective(advisorInfo,example);
    }

    /**
     * θ·εδΈεζε‘η»ιͺ
     * @param advisorAccount
     * @return
     */
    @ServiceLog(doAction = "θ·εδΈεζε‘η»ιͺ")
    @Override
    public List<ServiceExperience> getServiceExperienceInfo(String advisorAccount) {
        List<ServiceExperience>serviceExperienceList=new ArrayList<>(16);
        TbServiceExperienceCriteria example=new TbServiceExperienceCriteria();
        example.createCriteria().andAdvisorAccountEqualTo(advisorAccount);
        //ζη§ζε‘ε·₯δ½ζΆι΄ιεΊζεΊ
        example.setOrderByClause("work_time desc");
        List<TbServiceExperience> tbServiceExperienceList = tbServiceExperienceMapper.selectByExample(example);
        if(tbServiceExperienceList.isEmpty()){
            return serviceExperienceList;
        }
        for(TbServiceExperience tbServiceExperience:tbServiceExperienceList){
            ServiceExperience serviceExperience=new ServiceExperience();
            BeanUtils.copyProperties(tbServiceExperience, serviceExperience);
            serviceExperienceList.add(serviceExperience);
        }
        return serviceExperienceList;
    }

    /**
     * ζε‘θ―δ»·η»θ?‘δΏ‘ζ―
     * @param serviceEvaluationParam
     * @return
     */
    @ServiceLog(doAction = "ζε‘θ―δ»·η»θ?‘δΏ‘ζ―")
    @Override
    public EvaluationCountInfo getEvaluationCountInfo(ServiceEvaluationParam serviceEvaluationParam) {
        evaluationDataProcessing(serviceEvaluationParam);
        return advisorMapper.getEvaluationInfo(serviceEvaluationParam);
    }

    /**
     * θ·εδΈει‘Ήη?η»ιͺ
     * @param advisorAccount δΈεθ΄¦ε·
     * @return
     */
    @ServiceLog(doAction = "θ·εδΈει‘Ήη?η»ιͺ")
    @Override
    public List<ServiceProjectExperience> getProjectExperienceInfo(String advisorAccount) {
        List<ServiceProjectExperience> serviceProjectExperienceList=new ArrayList<>(16);
        TbServiceProExperCriteria example=new TbServiceProExperCriteria();
        example.createCriteria().andAdvisorAccountEqualTo(advisorAccount);
        //ζι‘Ήη?ζΆι΄ιεΊζεΊ
        example.setOrderByClause("project_time desc");
        List<TbServiceProExper> tbServiceProExperList = tbServiceProExperMapper.selectByExample(example);
        if(tbServiceProExperList.isEmpty()){
            return serviceProjectExperienceList;
        }
        for(TbServiceProExper tbServiceProExper: tbServiceProExperList){
            ServiceProjectExperience serviceProjectExperience=new ServiceProjectExperience();
            BeanUtils.copyProperties(tbServiceProExper, serviceProjectExperience);
            serviceProjectExperienceList.add(serviceProjectExperience);
        }
        return serviceProjectExperienceList;
    }

    /**
     * θ·εδΈεθ£θͺθ΅θ΄¨δΏ‘ζ―
     * @param advisorAccount δΈεθ΄¦ε·
     */
    @ServiceLog(doAction = "θ·εδΈεθ£θͺθ΅θ΄¨δΏ‘ζ―")
    @Override
    public List<ServiceHonor> getAdvisorHonorInfo(String advisorAccount) {
        List<ServiceHonor>serviceHonorList=new ArrayList<>(16);
        TbServiceHonorCriteria example=new TbServiceHonorCriteria();
        example.createCriteria().andAdvisorAccountEqualTo(advisorAccount);
        List<TbServiceHonor> tbServiceHonorList = tbServiceHonorMapper.selectByExample(example);
        if(tbServiceHonorList.isEmpty()){
            return serviceHonorList;
        }
        List<AdvisorCertificateTypeShow> certificateTypeList = advisorEditService.getCertificateTypeList("");
        List<AdvisorCertificateTypeShow>resultList=certificateTypeList==null? Collections.EMPTY_LIST:certificateTypeList;
        for(TbServiceHonor tbServiceHonor:tbServiceHonorList){
            ServiceHonor serviceHonor=new ServiceHonor();
            BeanUtils.copyProperties(tbServiceHonor, serviceHonor);
            for(AdvisorCertificateTypeShow act:resultList){
                if(StringUtils.equals(tbServiceHonor.getCertificateType(),act.getCertificateCode())){
                    serviceHonor.setCertificateTypeName(act.getCertificateName());
                    break;
                }
            }
            serviceHonorList.add(serviceHonor);
        }
        return serviceHonorList;
    }

    /**
     * ζ Ήζ?δΈεθ΄¦ε·θ·εδΈεεΊζ¬δΏ‘ζ―
     * @param advisorAccount δΈεθ΄¦ε·
     * @param approvalStatus ε?‘ζΉηΆζ ( - 1οΌε·²ζη»    0οΌζͺει¦   1οΌεΎε?‘ζΉ     2οΌε?‘ζΉιθΏ    3οΌε?‘ζΉδΈιθΏ    4οΌε·²θ§£ι€)
     */
    @ServiceLog(doAction = "ζ Ήζ?δΈεθ΄¦ε·θ·εδΈεεΊζ¬δΏ‘ζ―")
    @Override
    public AdvisorServiceInfo getAdvisorInfoByAccount(String advisorAccount,String approvalStatus) {
        TbServiceAdvisorCriteria example=new TbServiceAdvisorCriteria();
        if(StringUtils.isBlank(approvalStatus)){
            example.createCriteria().andAdvisorAccountEqualTo(advisorAccount)
                    .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        }else{
            example.createCriteria().andAdvisorAccountEqualTo(advisorAccount).andApprovalStatusEqualTo(approvalStatus)
                    .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        }
        List<TbServiceAdvisor> tbServiceAdvisors = tbServiceAdvisorMapper.selectByExample(example);
        if(tbServiceAdvisors.isEmpty()){
          return null;
        }
        TbServiceAdvisor tbServiceAdvisor = tbServiceAdvisors.get(0);
        //θ·εη³»η»ζζδΈε‘ι’ε
        IndustryDictParameter industryDictParameter=new IndustryDictParameter();
        //ι’εη±»ε[0δΈε‘ι’ε1θ‘δΈι’ε2εε±ιΆζ?΅3δΌδΈζ§θ΄¨]
        industryDictParameter.setPreType("0");
        List<IndustryDictionary> industryDictionaryList = industryService.getIndustryDictionary(industryDictParameter);
        AdvisorServiceInfo advisorServiceInfo=new AdvisorServiceInfo();
        BeanUtils.copyProperties(tbServiceAdvisor, advisorServiceInfo);
        if(StringUtils.isNotBlank(tbServiceAdvisor.getBusinessArea())){
            String []businessAreaArray=tbServiceAdvisor.getBusinessArea().split(",");
            List<String> businessAreaBul=new ArrayList<>();
            for(IndustryDictionary industryDictionary:industryDictionaryList){
                for(String businessArea:businessAreaArray){
                    if(StringUtils.equals(industryDictionary.getId(), businessArea)){
                        businessAreaBul.add(industryDictionary.getPreValue());
                        break;
                    }
                }
            }
            advisorServiceInfo.setBusinessAreaName(StringUtils.join(businessAreaBul,","));
        }
        return advisorServiceInfo;
    }
}
