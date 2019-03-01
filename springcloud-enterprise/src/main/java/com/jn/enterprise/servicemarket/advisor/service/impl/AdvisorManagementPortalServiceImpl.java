package com.jn.enterprise.servicemarket.advisor.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.servicemarket.advisor.dao.AdvisorManagementPortalMapper;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceAdvisor;
import com.jn.enterprise.servicemarket.advisor.model.*;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorManagementPortalService;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorService;
import com.jn.enterprise.servicemarket.advisor.vo.AdvisroManagementDetailsVo;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务顾问管理(后台门户管理)
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
     * 服务顾问管理列表查询
     * @param advisorManagementParam  服务顾问管理列表查询入参
     * @return
     */
    @ServiceLog(doAction = "服务顾问管理列表查询")
    @Override
    public PaginationData getAdvisorManagementInfoList(AdvisorManagementPortalParam advisorManagementParam) {
        com.github.pagehelper.Page<Object> objects = null;
        if(advisorManagementParam==null){
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
                logger.warn("服务顾问管理提交开始时间：[{}]晚于提交结束时间：[{}]",advisorManagementParam.getSubmitStartTime(),advisorManagementParam.getSubmitEndTime());
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
     * 服务顾问详情
     * @param advisorAccount  顾问账号
     * @return
     */
    @ServiceLog(doAction = "服务顾问详情")
    @Override
    public AdvisroManagementDetailsVo getAdvisorManagementDetails(String advisorAccount) {
        //根据顾问账号获取顾问简介信息
        AdvisorServiceManagementInfo advisorIntroduction = advisorManagementPortalMapper.getAdvisorIntroduction(advisorAccount);
        if(advisorIntroduction==null){
            throw new JnSpringCloudException(AdvisorExceptionEnum.SERVICE_ORG_NOT_EXIST);
        }
        AdvisroManagementDetailsVo advisroManagementDetailsVo=new AdvisroManagementDetailsVo();
        advisroManagementDetailsVo.setAdvisorIntroduction(advisorIntroduction);
        //顾问基本资料
        TbServiceAdvisor tbServiceAdvisor = advisorService.getAdvisorInfoByAccount(advisorAccount);
        AdvisorBaseInfo advisorBaseInfo=new AdvisorBaseInfo();
        BeanUtils.copyProperties(tbServiceAdvisor, advisorBaseInfo);
        advisroManagementDetailsVo.setAdvisorBaseInfo(advisorBaseInfo);
        //荣誉资质
        List<ServiceHonor> advisorHonorInfo = advisorService.getAdvisorHonorInfo(advisorAccount);
        if(!advisorHonorInfo.isEmpty()){
            advisroManagementDetailsVo.setServiceHonorList(advisorHonorInfo);
        }
        //服务经历
        List<ServiceExperience> serviceExperienceInfo = advisorService.getServiceExperienceInfo(advisorAccount);
        if(!serviceExperienceInfo.isEmpty()){
            advisroManagementDetailsVo.setServiceExperienceList(serviceExperienceInfo);
        }
        //项目经验
        List<ServiceProjectExperience> projectExperienceInfo = advisorService.getProjectExperienceInfo(advisorAccount);
        if(!projectExperienceInfo.isEmpty()){
            advisroManagementDetailsVo.setServiceProjectExperienceList(projectExperienceInfo);
        }
        return advisroManagementDetailsVo;
    }
}

