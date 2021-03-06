package com.jn.enterprise.servicemarket.advisor.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.propaganda.enums.ApprovalStatusEnum;
import com.jn.enterprise.servicemarket.advisor.dao.AdvisorManagementPortalMapper;
import com.jn.enterprise.servicemarket.advisor.model.*;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorManagementPortalService;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorService;
import com.jn.enterprise.servicemarket.advisor.vo.AdvisorManagementDetailsVo;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务专员管理(后台门户管理)
 * @Author: yangph
 * @Date: 2019/2/28 9:52
 * @Version v1.0
 * @modified By:
 */
@Service
public class AdvisorManagementPortalServiceImpl implements AdvisorManagementPortalService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(AdvisorManagementPortalServiceImpl.class);

    @Autowired
    private AdvisorManagementPortalMapper advisorManagementPortalMapper;

    @Autowired
    private AdvisorService advisorService;
    /**
     * 服务专员管理列表查询
     * @param advisorManagementParam  服务专员管理列表查询入参
     * @return
     */
    @ServiceLog(doAction = "服务专员管理列表查询")
    @Override
    public PaginationData getAdvisorManagementInfoList(AdvisorManagementPortalParam advisorManagementParam) {
        com.github.pagehelper.Page<Object> objects = null;
        if(StringUtils.isBlank(advisorManagementParam.getNeedPage())){
            //默认查询第1页的15条数据
            int pageNum=1;
            int pageSize=15;
            objects = PageHelper.startPage(pageNum,pageSize, true);
            List<AdvisorServiceManagementInfo> advisorManagementInfoList = advisorManagementPortalMapper.getAdvisorManagementInfoList(advisorManagementParam);
            return new PaginationData(advisorManagementInfoList, objects == null ? 0 : objects.getTotal());
        }
        if(StringUtils.isNotBlank(advisorManagementParam.getSubmitStartTime())
                && StringUtils.isNotBlank(advisorManagementParam.getSubmitEndTime())){
            int startTime = Integer.parseInt(advisorManagementParam.getSubmitStartTime());
            int endTime=Integer.parseInt(advisorManagementParam.getSubmitEndTime());
            if(startTime>endTime){
                logger.warn("服务专员管理提交开始时间：[{}]晚于提交结束时间：[{}]",advisorManagementParam.getSubmitStartTime(),advisorManagementParam.getSubmitEndTime());
                throw new JnSpringCloudException(AdvisorExceptionEnum.START_MORE_THEN_END);
            }
        }
        //需要分页标识
        String isPage="1";
        if(isPage.equals(advisorManagementParam.getNeedPage())){
            objects = PageHelper.startPage(advisorManagementParam.getPage(),
                    advisorManagementParam.getRows() == 0 ? 15 : advisorManagementParam.getRows(), true);
        }

        List<AdvisorServiceManagementInfo> advisorManagementInfoList = advisorManagementPortalMapper.getAdvisorManagementInfoList(advisorManagementParam);
        return new PaginationData(advisorManagementInfoList, objects == null ? 0 : objects.getTotal());
    }

    /**
     * 服务专员详情
     * @param advisorAccount  专员账号
     * @return
     */
    @ServiceLog(doAction = "服务专员详情")
    @Override
    public AdvisorManagementDetailsVo getAdvisorManagementDetails(String advisorAccount) {
        //根据专员账号获取专员简介信息
        AdvisorServiceManagementInfo advisorIntroduction = advisorManagementPortalMapper.getAdvisorIntroduction(advisorAccount);
        if(advisorIntroduction==null){
            throw new JnSpringCloudException(AdvisorExceptionEnum.SERVICE_ORG_NOT_EXIST);
        }
        AdvisorManagementDetailsVo advisorManagementDetailsVo =new AdvisorManagementDetailsVo();
        advisorManagementDetailsVo.setAdvisorIntroduction(advisorIntroduction);
        //专员基本资料
        AdvisorServiceInfo advisorServiceInfo = advisorService.getAdvisorInfoByAccount(advisorAccount, ApprovalStatusEnum.APPROVED.getValue());
        AdvisorBaseInfoParam advisorBaseInfoParam =new AdvisorBaseInfoParam();
        BeanUtils.copyProperties(advisorServiceInfo, advisorBaseInfoParam);
        advisorManagementDetailsVo.setAdvisorBaseInfoParam(advisorBaseInfoParam);
        //荣誉资质
        List<ServiceHonor> advisorHonorInfo = advisorService.getAdvisorHonorInfo(advisorAccount);
        if(!advisorHonorInfo.isEmpty()){
            advisorManagementDetailsVo.setServiceHonorList(advisorHonorInfo);
        }
        //服务经历
        List<ServiceExperience> serviceExperienceInfo = advisorService.getServiceExperienceInfo(advisorAccount);
        if(!serviceExperienceInfo.isEmpty()){
            advisorManagementDetailsVo.setServiceExperienceList(serviceExperienceInfo);
        }
        //项目经验
        List<ServiceProjectExperience> projectExperienceInfo = advisorService.getProjectExperienceInfo(advisorAccount);
        if(!projectExperienceInfo.isEmpty()){
            advisorManagementDetailsVo.setServiceProjectExperienceList(projectExperienceInfo);
        }
        return advisorManagementDetailsVo;
    }
}

