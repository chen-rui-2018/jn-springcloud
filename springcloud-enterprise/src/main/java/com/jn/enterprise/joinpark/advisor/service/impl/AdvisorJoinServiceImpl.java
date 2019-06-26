package com.jn.enterprise.joinpark.advisor.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.common.enums.CommonExceptionEnum;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.company.vo.InviteUpgradeStatusVO;
import com.jn.enterprise.company.vo.UpgradeStatusVO;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.joinpark.advisor.service.AdvisorJoinService;
import com.jn.enterprise.servicemarket.advisor.model.*;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorEditService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 顾问认证
 * @author： jiangyl
 * @date： Created on 2019/3/4 16:33
 * @version： v1.0
 * @modified By: yangph 2019/6/3
 */
@Service
public class AdvisorJoinServiceImpl implements AdvisorJoinService {
    private static Logger logger = LoggerFactory.getLogger(AdvisorJoinServiceImpl.class);
    @Autowired
    private AdvisorEditService advisorEditService;

    @Autowired
    private CompanyService companyService;
    /**
     * 荣誉资质颁发机构长度
     */
    private static final int ISSUING_AGENCY_LENGTH=64;

    @Override
    @ServiceLog(doAction = "顾问认证保存/更新")
    @Transactional(rollbackFor = Exception.class)
    public int saveOrUpdateAdvisorDetail(AdvisorDetailParam advisorDetailParam, String account){
        //判断当前用户是否可以认证
        InviteUpgradeStatusVO joinParkStatus = companyService.getJoinParkStatus(account);
        String allowStatus="0";
        if(!StringUtils.equals(allowStatus,joinParkStatus.getCode())){
            logger.warn(joinParkStatus.getMessage());
            throw new JnSpringCloudException(CommonExceptionEnum.UPGRADE_COMMON, account + joinParkStatus.getInviteMessage());
        }
        AdvisorBaseInfoParam advisorBaseInfoParam=new AdvisorBaseInfoParam();
        //基本信息保存
        BeanUtils.copyProperties(advisorDetailParam, advisorBaseInfoParam);
        String []businessAreas={advisorDetailParam.getBusinessArea()};
        advisorBaseInfoParam.setBusinessAreas(businessAreas);
        advisorBaseInfoParam.setAdvisorAccount(account);
        int resNum=advisorEditService.saveOrUpdateAdvisorBaseInfo(advisorBaseInfoParam);
        logger.info("顾问认证基本信息保存成功，数据响应条数：{}",resNum);
        //荣誉资质保存
        List<ServiceHonorParam> serviceHonorList = advisorDetailParam.getServiceHonors();
        if(!serviceHonorList.isEmpty()){
            resNum=0;
            for(ServiceHonorParam  serviceHonorParam:serviceHonorList){
                //校验荣誉资质信息
                checkHonorsParam(serviceHonorParam);
                serviceHonorParam.setAdvisorAccount(account);
                resNum+=advisorEditService.saveOrUpdateAdvisorHonor(serviceHonorParam);
            }
            logger.info("顾问认证荣誉资质保存成功，数据响应条数：{}",resNum);
        }
        //服务经历保存
        List<ServiceExperienceParam> serviceExperienceList= advisorDetailParam.getServiceExperiences();
        if(!serviceExperienceList.isEmpty()){
            resNum=0;
            for(ServiceExperienceParam experienceParam:serviceExperienceList){
                //校验服务经历
                checkExperienceParam(experienceParam);
                experienceParam.setAdvisorAccount(account);
                resNum+=advisorEditService.saveOrUpdateAdvisorExperience(experienceParam);
            }
            logger.info("顾问认证服务经历保存成功，数据响应条数：{}",resNum);
        }
        //项目经验保存
        List<ServiceProjectExperienceParam> projectExperienceList = advisorDetailParam.getProjectExperiences();
        if(!projectExperienceList.isEmpty()){
            resNum=0;
            for(ServiceProjectExperienceParam projectExperienceParam:projectExperienceList){
                checkWorkExperienceParam(projectExperienceParam);
                projectExperienceParam.setAdvisorAccount(account);
                resNum+=advisorEditService.saveOrUpdateAdvisorProjectExperience(projectExperienceParam);
            }
            logger.info("顾问认证项目经验保存成功，数据响应条数：{}",resNum);
        }
        //调用发送申请接口，把状态改为待审批
        return advisorEditService.sendApproval(account);
    }


    /**
     * 校验前端传递的项目经验信息
     * @param projectExperienceParam
     */
    @ServiceLog(doAction = "校验前端传递的项目经验信息")
    private void checkWorkExperienceParam(ServiceProjectExperienceParam projectExperienceParam) {
        String regexp = "(^(19[2-9][0-9])|(20[0-3][0-9]))((0[1-9])|(1[0-2])$)";
        if(!projectExperienceParam.getProjectTime().matches(regexp)){
            logger.warn("项目经验开始时间：[{}]的格式不正确",projectExperienceParam.getProjectTime());
            throw new JnSpringCloudException(AdvisorExceptionEnum.WORK_TIME_FORMAT_ERROR);
        }
        if(!projectExperienceParam.getProjectEndTime().matches(regexp)){
            logger.warn("项目经验结束时间：[{}]的格式不正确",projectExperienceParam.getProjectEndTime());
            throw new JnSpringCloudException(AdvisorExceptionEnum.WORK_END_TIME_FORMAT_ERROR);
        }
        int startTime=Integer.parseInt(projectExperienceParam.getProjectTime());
        int endTime=Integer.parseInt(projectExperienceParam.getProjectEndTime());
        if(startTime>endTime){
            logger.warn("项目经验开始时间：[{}]晚于项目经验结束时间：[{}]",projectExperienceParam.getProjectTime(),projectExperienceParam.getProjectEndTime());
            throw new JnSpringCloudException(AdvisorExceptionEnum.WORK_TIME_MORE_THAN_END_TIME);
        }
    }


    /**
     * 校验前端传递的服务经历信息
     * @param experienceParam
     */
    @ServiceLog(doAction = "校验前端传递的服务经历信息")
    private void checkExperienceParam(ServiceExperienceParam experienceParam) {
        String regexp = "(^(19[2-9][0-9])|(20[0-3][0-9]))((0[1-9])|(1[0-2])$)";
        if(!experienceParam.getWorkTime().matches(regexp)){
            logger.warn("服务经历工作开始时间：[{}]的格式不正确",experienceParam.getWorkTime());
            throw new JnSpringCloudException(AdvisorExceptionEnum.WORK_TIME_FORMAT_ERROR);
        }
        if(!experienceParam.getWorkEndTime().matches(regexp)){
            logger.warn("服务经历工作结束时间：[{}]的格式不正确",experienceParam.getWorkEndTime());
            throw new JnSpringCloudException(AdvisorExceptionEnum.WORK_END_TIME_FORMAT_ERROR);
        }
        int startTime=Integer.parseInt(experienceParam.getWorkTime());
        int endTime=Integer.parseInt(experienceParam.getWorkEndTime());
        if(startTime>endTime){
            logger.warn("服务经历工作开始时间：[{}]晚于工作结束时间：[{}]",experienceParam.getWorkTime(),experienceParam.getWorkEndTime());
            throw new JnSpringCloudException(AdvisorExceptionEnum.WORK_TIME_MORE_THAN_END_TIME);
        }
    }

    /**
     * 校验前端传递的荣誉资质信息
     * @param serviceHonorParam
     */
    @ServiceLog(doAction = "校验前端传递的荣誉资质信息")
    private void checkHonorsParam(ServiceHonorParam serviceHonorParam) {
        //颁发机构
        if(serviceHonorParam.getIssuingAgency().length()>ISSUING_AGENCY_LENGTH){
            logger.warn("荣誉资质颁发机构：[{}]的长度超过{}位",serviceHonorParam.getIssuingAgency(),ISSUING_AGENCY_LENGTH);
            throw new JnSpringCloudException(AdvisorExceptionEnum.ISSUING_AGENCY_LENGTH_TOO_LONG);
        }
        //颁发时间
        String regexp = "((19[2-9][0-9])|(20[0-3][0-9]))((0[1-9])|(1[0-2]))";
        if(!serviceHonorParam.getGetTime().matches(regexp)){
            logger.warn("荣誉资质颁发时间：[{}]格式不正确",serviceHonorParam.getGetTime());
            throw new JnSpringCloudException(AdvisorExceptionEnum.GET_TIME_FORMAT_ERROR);
        }
    }


}
