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
import com.jn.enterprise.servicemarket.advisor.enums.ServiceRatingTypeEnum;
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
 * 服务顾问
 * @Author: yangph
 * @Date: 2019/2/12 16:40
 * @Version v1.0
 * @modified By:
 */
@Service
public class AdvisorServiceImpl implements AdvisorService {
    /**
     * 日志组件
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
     * 服务顾问列表查询
     * @param advisorListParam 查询条件
     * @param needPage           是否需要分页
     * @return
     */
    @Override
    @ServiceLog(doAction = "服务顾问列表查询")
    public PaginationData getServiceConsultantList(AdvisorListParam advisorListParam, Boolean needPage) {
        com.github.pagehelper.Page<Object> objects = null;
        if(needPage){
            objects = PageHelper.startPage(advisorListParam.getPage(), advisorListParam.getRows() == 0 ? 15 : advisorListParam.getRows(), true);
        }
        AdvisorQueryConditions queryConditions=new AdvisorQueryConditions();
        BeanUtils.copyProperties(advisorListParam, queryConditions);
        if(StringUtils.isBlank(queryConditions.getSortTypes()) ){
            //默认综合排序
            queryConditions.setSortTypes(ServiceSortTypeEnum.INTEGRATE.getCode());
        }
        if(ServiceSortTypeEnum.INTEGRATE.getCode().equals(queryConditions.getSortTypes())) {
            //todo：从数据字典表获取综合排序各个因素的权重并给相应元素赋值  yangph
        }
        List<AdvisorListInfo> advisorListInfoList=advisorMapper.getServiceConsultantList(queryConditions);
        return new PaginationData(advisorListInfoList, objects == null ? 0 : objects.getTotal());
    }

    /**
     * 根据顾问账号获取顾问详情
     * @param advisorAccount 顾问账号
     * @param approvalStatus 审批状态 ( - 1：已拒绝    0：未反馈   1：待审批     2：审批通过    3：审批不通过    4：已解除)
     * @return
     */
    @ServiceLog(doAction = "根据顾问账号获取顾问详情")
    @Override
    public AdvisorDetailsVo getServiceAdvisorInfo(String advisorAccount,String approvalStatus) {
        AdvisorDetailsVo advisorDetailsVo=new AdvisorDetailsVo();
        //1.获取用户基本信息
        AdvisorServiceInfo advisorServiceInfo= getAdvisorInfoByAccount(advisorAccount,approvalStatus);
        //设置顾问基础信息
        advisorDetailsVo.setAdvisorServiceInfo(advisorServiceInfo);
        //创建顾问详情简介对象
        AdvisorIntroduction advisorIntroduction=new AdvisorIntroduction();
        BeanUtils.copyProperties(advisorServiceInfo, advisorIntroduction);
        //设置顾问简介信息
        advisorDetailsVo.setAdvisorIntroduction(advisorIntroduction);
        //2.获取顾问荣誉资质
        List<ServiceHonor> advisorHonorInfoList = getAdvisorHonorInfo(advisorAccount);
        //设置顾问荣誉资质信息
        advisorDetailsVo.setServiceHonorList(advisorHonorInfoList);
        //3.获取顾问项目经验
        List<ServiceProjectExperience> serviceProjectExperienceList = getProjectExperienceInfo(advisorAccount);
        //设置顾问项目经验
        advisorDetailsVo.setServiceProjectExperienceList(serviceProjectExperienceList);
        //4.获取顾问服务经历
        List<ServiceExperience> serviceExperienceList = getServiceExperienceInfo(advisorAccount);
        //设置顾问服务经历
        advisorDetailsVo.setServiceExperienceList(serviceExperienceList);
        //5.获取服务产品
        AdvisorProductQuery advisorProductQuery=new AdvisorProductQuery();
        advisorProductQuery.setAdvisorAccount(advisorAccount);
        PaginationData paginationData = serviceProductService.advisorProductList(advisorProductQuery, Boolean.FALSE);
        List<AdvisorProductInfo> advisorProductInfoList =(List<AdvisorProductInfo> )paginationData.getRows();
        //设置服务产品
        advisorDetailsVo.setAdvisorProductInfoList(advisorProductInfoList);
        //6.获取服务评价  //默认查全部
        String ratingType="全部";
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

        //7.更新顾问信息浏览量
        updateAdvisorPageviews(advisorAccount);
        return advisorDetailsVo;
    }

    /**
     * 设置顾问详情中服务评价的评价数量
     * @param advisorDetailsVo      顾问详情返回前端对象
     * @param advisorIntroduction   顾问详情简介对象
     * @param serviceRatingInfoList 服务评价查询结果集
     */
    @ServiceLog(doAction = "设置顾问详情中服务评价的评价数量")
    private void setRatingNum(AdvisorDetailsVo advisorDetailsVo, AdvisorIntroduction advisorIntroduction, List<ServiceRating> serviceRatingInfoList) {
        //好评得分
        int praiseScore=5;
        //中评最低分
        int averageScore=3;
        //差评最低分
        int badReviewScore=1;
        //服务评分
        float evaluationScore=0f;
        for(ServiceRating serviceRating:serviceRatingInfoList){
            if(serviceRating.getEvaluationScore()==null){
                continue;
            }
            float score = Float.parseFloat(serviceRating.getEvaluationScore());
            if(score==praiseScore){
                //好评数加1
                advisorDetailsVo.setPraiseNum(advisorDetailsVo.getPraiseNum()+1);
            }else if(score>=averageScore && score<praiseScore){
                //中评数加1
                advisorDetailsVo.setAverageNum(advisorDetailsVo.getAverageNum()+1);
            }else if(score>=badReviewScore && score<averageScore){
                //差评数加1
                advisorDetailsVo.setAverageNum(advisorDetailsVo.getAverageNum()+1);
            }
            evaluationScore+=score;
        }
        //评价总数
        advisorDetailsVo.setEvaluationTotal(advisorDetailsVo.getPraiseNum()+advisorDetailsVo.getAverageNum()+advisorDetailsVo.getBadReviewNum());

        //计算顾问最终服务评分
        evaluationScore=evaluationScore/serviceRatingInfoList.size();
        if(evaluationScore>0){
            //顾问详情简介设置服务评分
            advisorIntroduction.setEvaluationScore(evaluationScore+"");
        }
    }

    /**
     * 根据查询条件获取服务评价信息
     * @param serviceEvaluationParam   服务评价信息查询入参
     * @return
     */
    @ServiceLog(doAction = "根据查询条件获取服务评价信息")
    @Override
    public PaginationData getServiceRatingInfo(ServiceEvaluationParam serviceEvaluationParam) {
        //是否公共页面  1：是  0：否
        Page<Object> objects = evaluationDataProcessing(serviceEvaluationParam);
        List<ServiceRating> serviceRatingInfo = advisorMapper.getServiceRatingInfo(serviceEvaluationParam);
        return getEvaluationPaginationData(objects, serviceRatingInfo);
    }

    /**
     * 服务评价入参数据处理
     * @param serviceEvaluationParam
     * @return
     */
    @ServiceLog(doAction = "服务评价入参数据处理")
    private Page<Object> evaluationDataProcessing(ServiceEvaluationParam serviceEvaluationParam) {
        String isPublicPage="0";
        if(isPublicPage.equals(serviceEvaluationParam.getIsPublicPage()) && StringUtils.isBlank(serviceEvaluationParam.getOrgId())
                && StringUtils.isBlank(serviceEvaluationParam.getProductId()) && StringUtils.isBlank(serviceEvaluationParam.getAdvisorAccount())){
            logger.warn("根据查询条件获取服务评价信息的机构id,产品id,顾问账号不能都为空");
            throw new JnSpringCloudException(AdvisorExceptionEnum.EVALUATION_ID_NOT_NULL);
        }
        Page<Object> objects = null;
        //需要分页标识
        String isPage="1";
        if(isPage.equals(serviceEvaluationParam.getNeedPage())){
            objects = PageHelper.startPage(serviceEvaluationParam.getPage(),
                    serviceEvaluationParam.getRows() == 0 ? 15 : serviceEvaluationParam.getRows(), true);
        }
        return objects;
    }

    /**
     * 封装处理评价信息
     * @param objects
     * @param serviceRatingInfo
     * @return
     */
    @ServiceLog(doAction = "封装处理评价信息")
    private PaginationData getEvaluationPaginationData(Page<Object> objects, List<ServiceRating> serviceRatingInfo) {
        if(serviceRatingInfo.isEmpty()){
            return new PaginationData(serviceRatingInfo, objects == null ? 0 : objects.getTotal());
        }
        List<String> accountList=new ArrayList<>(16);
        //获取评价人姓名，头像
        for(ServiceRating serviceRating:serviceRatingInfo){
            accountList.add(serviceRating.getEvaluationAccount());
        }
        Result<List<UserExtensionInfo>> moreUserExtension = userExtensionClient.getMoreUserExtension(accountList);
        if(moreUserExtension!=null &&  moreUserExtension.getData()!=null){
            List<UserExtensionInfo>userExtensionInfoList= moreUserExtension.getData();
            for(ServiceRating serviceRating:serviceRatingInfo){
                for(UserExtensionInfo userExtensionInfo:userExtensionInfoList){
                    if(StringUtils.equals(serviceRating.getEvaluationAccount(),userExtensionInfo.getAccount())){
                        //头像
                        serviceRating.setEvaluationAvatar(userExtensionInfo.getAvatar());
                        //姓名
                        serviceRating.setEvaluationName(userExtensionInfo.getName());
                        break;
                    }
                }
            }
        }
        return new PaginationData(serviceRatingInfo, objects == null ? 0 : objects.getTotal());
    }

    /**
     * 更新顾问信息的浏览量
     * @param advisorAccount
     */
    @ServiceLog(doAction = "更新顾问信息的浏览量")
    private void updateAdvisorPageviews(String advisorAccount) {
        TbServiceAdvisorCriteria example=new TbServiceAdvisorCriteria();
        example.createCriteria().andAdvisorAccountEqualTo(advisorAccount);
        List<TbServiceAdvisor> tbServiceAdvisors = tbServiceAdvisorMapper.selectByExample(example);
        if(tbServiceAdvisors.isEmpty()){
            logger.warn("当前顾问[{}]信息不存在",advisorAccount);
            throw new JnSpringCloudException(AdvisorExceptionEnum.ADVISOR_INFO_NOT_EXIST);
        }
        TbServiceAdvisor advisorInfo=new TbServiceAdvisor();
        //浏览量加1
        int num = tbServiceAdvisors.get(0).getPageViews() == null ? 0 : tbServiceAdvisors.get(0).getPageViews();
        advisorInfo.setPageViews(num+1);
        tbServiceAdvisorMapper.updateByExampleSelective(advisorInfo,example);
    }

    /**
     * 获取顾问服务经验
     * @param advisorAccount
     * @return
     */
    @ServiceLog(doAction = "获取顾问服务经验")
    @Override
    public List<ServiceExperience> getServiceExperienceInfo(String advisorAccount) {
        List<ServiceExperience>serviceExperienceList=new ArrayList<>(16);
        TbServiceExperienceCriteria example=new TbServiceExperienceCriteria();
        example.createCriteria().andAdvisorAccountEqualTo(advisorAccount);
        //按照服务工作时间降序排序
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
     * 服务评价统计信息
     * @param serviceEvaluationParam
     * @return
     */
    @ServiceLog(doAction = "服务评价统计信息")
    @Override
    public EvaluationCountInfo getEvaluationCountInfo(ServiceEvaluationParam serviceEvaluationParam) {
        evaluationDataProcessing(serviceEvaluationParam);
        return advisorMapper.getEvaluationInfo(serviceEvaluationParam);
    }

    /**
     * 获取顾问项目经验
     * @param advisorAccount 顾问账号
     * @return
     */
    @ServiceLog(doAction = "获取顾问项目经验")
    @Override
    public List<ServiceProjectExperience> getProjectExperienceInfo(String advisorAccount) {
        List<ServiceProjectExperience> serviceProjectExperienceList=new ArrayList<>(16);
        TbServiceProExperCriteria example=new TbServiceProExperCriteria();
        example.createCriteria().andAdvisorAccountEqualTo(advisorAccount);
        //按项目时间降序排序
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
     * 获取顾问荣誉资质信息
     * @param advisorAccount 顾问账号
     */
    @ServiceLog(doAction = "获取顾问荣誉资质信息")
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
     * 根据顾问账号获取顾问基本信息
     * @param advisorAccount 顾问账号
     * @param approvalStatus 审批状态 ( - 1：已拒绝    0：未反馈   1：待审批     2：审批通过    3：审批不通过    4：已解除)
     */
    @ServiceLog(doAction = "根据顾问账号获取顾问基本信息")
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
            logger.warn("当前顾问[{}]信息不存在",advisorAccount);
            throw new JnSpringCloudException(AdvisorExceptionEnum.ADVISOR_INFO_NOT_EXIST);
        }
        TbServiceAdvisor tbServiceAdvisor = tbServiceAdvisors.get(0);
        //获取系统所有业务领域
        IndustryDictParameter industryDictParameter=new IndustryDictParameter();
        //领域类型[0业务领域1行业领域2发展阶段3企业性质]
        industryDictParameter.setPreType("0");
        List<IndustryDictionary> industryDictionaryList = industryService.getIndustryDictionary(industryDictParameter);
        AdvisorServiceInfo advisorServiceInfo=new AdvisorServiceInfo();
        BeanUtils.copyProperties(tbServiceAdvisor, advisorServiceInfo);
        if(tbServiceAdvisor.getBusinessArea()!=null){
            String []businessAreaArray=tbServiceAdvisor.getBusinessArea().split(",");
            StringBuilder businessAreaBul=new StringBuilder();
            for(IndustryDictionary industryDictionary:industryDictionaryList){
                for(String businessArea:businessAreaArray){
                    if(StringUtils.equals(industryDictionary.getId(), businessArea)){
                        businessAreaBul.append(industryDictionary.getPreValue());
                        businessAreaBul.append(",");
                        break;
                    }
                }
            }
            int length = businessAreaBul.length()-1;
            advisorServiceInfo.setBusinessAreaName(businessAreaBul.toString().substring(0, length));
        }
        return advisorServiceInfo;
    }
}
