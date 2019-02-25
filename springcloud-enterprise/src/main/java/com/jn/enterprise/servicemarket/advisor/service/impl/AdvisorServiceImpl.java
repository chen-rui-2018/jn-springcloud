package com.jn.enterprise.servicemarket.advisor.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.servicemarket.advisor.enums.ServiceRatingTypeEnum;
import com.jn.enterprise.servicemarket.advisor.enums.ServiceSortTypeEnum;
import com.jn.enterprise.servicemarket.advisor.dao.*;
import com.jn.enterprise.servicemarket.advisor.entity.*;
import com.jn.enterprise.servicemarket.advisor.model.*;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorService;
import com.jn.enterprise.servicemarket.advisor.vo.AdvisorDetailsVo;
import com.jn.enterprise.servicemarket.product.service.ServiceProductService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    /**
     * 服务顾问列表查询
     * @param advisorInquiryInfo 查询条件
     * @param needPage           是否需要分页
     * @return
     */
    @Override
    @ServiceLog(doAction = "服务顾问列表查询")
    public PaginationData getServiceConsultantList(AdvisorInquiryInfo advisorInquiryInfo, Boolean needPage) {
        com.github.pagehelper.Page<Object> objects = null;
        if(needPage){
            objects = PageHelper.startPage(advisorInquiryInfo.getPage(), advisorInquiryInfo.getRows() == 0 ? 15 : advisorInquiryInfo.getRows(), true);
        }
        AdvisorQueryConditions queryConditions=new AdvisorQueryConditions();
        BeanUtils.copyProperties(advisorInquiryInfo, queryConditions);
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
     * @return
     */
    @ServiceLog(doAction = "根据顾问账号获取顾问详情")
    @Override
    public AdvisorDetailsVo getServiceAdvisorInfo(String advisorAccount) {
        AdvisorDetailsVo advisorDetailsVo=new AdvisorDetailsVo();
        //1.获取用户基本信息
        TbServiceAdvisor tbServiceAdvisor = getAdvisorInfoByAccount(advisorAccount);
        AdvisorServiceInfo advisorServiceInfo=new AdvisorServiceInfo();
        BeanUtils.copyProperties(tbServiceAdvisor, advisorServiceInfo);
        //设置顾问基础信息
        advisorDetailsVo.setAdvisorServiceInfo(advisorServiceInfo);
        //创建顾问详情简介对象
        AdvisorIntroduction advisorIntroduction=new AdvisorIntroduction();
        BeanUtils.copyProperties(tbServiceAdvisor, advisorIntroduction);
        //设置顾问简介信息
        advisorDetailsVo.setAdvisorIntroduction(advisorIntroduction);
        //2.获取顾问荣誉资质
        List<ServiceHonor> advisorHonorInfoList = getAdvisorHonorInfo(advisorAccount);
        //设置顾问荣誉资质信息
        advisorDetailsVo.setServiceHonorList(advisorHonorInfoList);
        //3.获取顾问项目经验
        List<ServiceProjectExperience> serviceProjectExperienceList = getProductExperienceInfo(advisorAccount);
        //设置顾问项目经验
        advisorDetailsVo.setServiceProjectExperienceList(serviceProjectExperienceList);
        //4.获取顾问服务经历
        List<ServiceExperience> serviceExperienceList = getServiceExperienceInfo(advisorAccount);
        //设置顾问服务经历
        advisorDetailsVo.setServiceExperienceList(serviceExperienceList);
        //5.todo:获取服务产品,待陈蕊完成后再调用  yangph

        //6.获取服务评价  //默认查全部
        String ratingType="全部";
        ServiceEvaluationQuery serviceEvaluationQuery=new ServiceEvaluationQuery();
        serviceEvaluationQuery.setAdvisorAccount(advisorAccount);
        serviceEvaluationQuery.setRatingType(ratingType);
        serviceEvaluationQuery.setNeedPage(Boolean.FALSE);
        PaginationData pageData = getServiceRatingInfo(serviceEvaluationQuery);
        List<ServiceRating> servcieRatingInfoList =(List<ServiceRating>) pageData.getRows();
        if(!servcieRatingInfoList.isEmpty()){
            setRatingNum(advisorDetailsVo, advisorIntroduction, servcieRatingInfoList);
            advisorDetailsVo.setServiceRatingList(servcieRatingInfoList);
        }

        //7.更新顾问信息浏览量
        updateAdvisorPageviews(advisorAccount);
        return advisorDetailsVo;
    }

    /**
     * 设置顾问详情中服务评价的评价数量
     * @param advisorDetailsVo      顾问详情返回前端对象
     * @param advisorIntroduction   顾问详情简介对象
     * @param servcieRatingInfoList 服务评价查询结果集
     */
    @ServiceLog(doAction = "设置顾问详情中服务评价的评价数量")
    private void setRatingNum(AdvisorDetailsVo advisorDetailsVo, AdvisorIntroduction advisorIntroduction, List<ServiceRating> servcieRatingInfoList) {
        //好评得分
        int praiseScore=5;
        //中评最低分
        int averageScore=3;
        //差评最低分
        int badReviewScore=1;
        //服务评分
        float evaluationScore=0f;
        for(ServiceRating serviceRating:servcieRatingInfoList){
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
        evaluationScore=evaluationScore/servcieRatingInfoList.size();
        if(evaluationScore>0){
            //顾问详情简介设置服务评分
            advisorIntroduction.setEvaluationScore(evaluationScore+"");
        }
    }

    /**
     * 根据查询条件获取服务评价信息
     * @param serviceEvaluationQuery   服务评价信息查询入参
     * @return
     */
    @ServiceLog(doAction = "根据查询条件获取服务评价信息")
    @Override
    public PaginationData getServiceRatingInfo(ServiceEvaluationQuery serviceEvaluationQuery) {
        com.github.pagehelper.Page<Object> objects = null;
        if(serviceEvaluationQuery.getNeedPage()){
            objects = PageHelper.startPage(serviceEvaluationQuery.getPage(),
                    serviceEvaluationQuery.getRows() == 0 ? 15 : serviceEvaluationQuery.getRows(), true);
        }
        String ratingType=serviceEvaluationQuery.getRatingType();
        if(ServiceRatingTypeEnum.PRAISE.getMessage().equals(ratingType)){
            //好评
            ratingType=ServiceRatingTypeEnum.PRAISE.getCode();
        }else if(ServiceRatingTypeEnum.AVERAGE.getMessage().equals(ratingType)){
            //中评
            ratingType=ServiceRatingTypeEnum.AVERAGE.getCode();
        }else if(ServiceRatingTypeEnum.BAD_REVIEW.getMessage().equals(ratingType)){
            //差评
            ratingType=ServiceRatingTypeEnum.BAD_REVIEW.getCode();
        }else{
            //全部
            ratingType="";
        }
        List<ServiceRating> servcieRatingInfo = advisorMapper.getServcieRatingInfo(serviceEvaluationQuery.getAdvisorAccount(), ratingType);
        return new PaginationData(servcieRatingInfo, objects == null ? 0 : objects.getTotal());
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
        advisorInfo.setPageViews(tbServiceAdvisors.get(0).getPageViews()+1);
        tbServiceAdvisorMapper.updateByExampleSelective(advisorInfo,example);
    }

    /**
     * 获取顾问服务经验
     * @param advisorAccount
     * @return
     */
    @ServiceLog(doAction = "获取顾问服务经验")
    private List<ServiceExperience> getServiceExperienceInfo(String advisorAccount) {
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
     * 获取顾问项目经验
     * @param advisorAccount
     * @return
     */
    @ServiceLog(doAction = "获取顾问项目经验")
    private List<ServiceProjectExperience> getProductExperienceInfo(String advisorAccount) {
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
     * @param advisorAccount
     */
    @ServiceLog(doAction = "获取顾问荣誉资质信息")
    private List<ServiceHonor> getAdvisorHonorInfo(String advisorAccount) {
        List<ServiceHonor>serviceHonorList=new ArrayList<>(16);
        TbServiceHonorCriteria example=new TbServiceHonorCriteria();
        example.createCriteria().andAdvisorAccountEqualTo(advisorAccount);
        List<TbServiceHonor> tbServiceHonorList = tbServiceHonorMapper.selectByExample(example);
        if(tbServiceHonorList.isEmpty()){
            return serviceHonorList;
        }
        for(TbServiceHonor tbServiceHonor:tbServiceHonorList){
            ServiceHonor serviceHonor=new ServiceHonor();
            BeanUtils.copyProperties(tbServiceHonor, serviceHonor);
            serviceHonorList.add(serviceHonor);
        }
        return serviceHonorList;
    }

    /**
     * 根据顾问账号获取顾问基本信息
     * @param advisorAccount
     */
    @ServiceLog(doAction = "根据顾问账号获取顾问基本信息")
    private TbServiceAdvisor getAdvisorInfoByAccount(String advisorAccount) {
        TbServiceAdvisorCriteria example=new TbServiceAdvisorCriteria();
        example.createCriteria().andAdvisorAccountEqualTo(advisorAccount);
        List<TbServiceAdvisor> tbServiceAdvisors = tbServiceAdvisorMapper.selectByExample(example);
        if(tbServiceAdvisors.isEmpty()){
            logger.warn("当前顾问[{}]信息不存在",advisorAccount);
            throw new JnSpringCloudException(AdvisorExceptionEnum.ADVISOR_INFO_NOT_EXIST);
        }
        return tbServiceAdvisors.get(0);
    }
}
