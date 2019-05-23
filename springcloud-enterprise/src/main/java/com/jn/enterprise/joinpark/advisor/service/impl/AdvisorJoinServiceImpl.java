package com.jn.enterprise.joinpark.advisor.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.joinpark.advisor.service.AdvisorJoinService;
import com.jn.enterprise.servicemarket.advisor.dao.AdvisorMapper;
import com.jn.enterprise.servicemarket.advisor.dao.TbServiceExperienceMapper;
import com.jn.enterprise.servicemarket.advisor.dao.TbServiceHonorMapper;
import com.jn.enterprise.servicemarket.advisor.dao.TbServiceProExperMapper;
import com.jn.enterprise.servicemarket.advisor.entity.*;
import com.jn.enterprise.servicemarket.advisor.model.*;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorEditService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 顾问认证
 * @author： jiangyl
 * @date： Created on 2019/3/4 16:33
 * @version： v1.0
 * @modified By:
 */
@Service
public class AdvisorJoinServiceImpl implements AdvisorJoinService {
    private static Logger logger = LoggerFactory.getLogger(AdvisorJoinServiceImpl.class);

    @Autowired
    private AdvisorMapper advisorMapper;
    @Autowired
    private TbServiceExperienceMapper tbServiceExperienceMapper;
    @Autowired
    private TbServiceProExperMapper tbServiceProExperMapper;
    @Autowired
    private TbServiceHonorMapper tbServiceHonorMapper;
    @Autowired
    private AdvisorEditService advisorEditService;


    /**
     * 数据状态 1:有效
     */
    private final static String RECORD_STATUS_VALID = "1";

    @Override
    @ServiceLog(doAction = "顾问认证保存/更新")
    public int saveOrUpdateAdvisorDetail(AdvisorDetailParam advisorDetailParam, String account){

        TbServiceHonorCriteria serviceHonorCriteria = new TbServiceHonorCriteria();
        serviceHonorCriteria.createCriteria().andAdvisorAccountEqualTo(account).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        int deleteServiceHonorCount = tbServiceHonorMapper.deleteByExample(serviceHonorCriteria);
        logger.info("问荣誉资质历史数据删除成功，响应条数-{}",deleteServiceHonorCount);
        List<ServiceHonorParam> serviceHonorParams = advisorDetailParam.getServiceHonors();
        List<TbServiceHonor> serviceHonors = new ArrayList<>(16);
        for(ServiceHonorParam param:serviceHonorParams){
            TbServiceHonor serviceHonor = new TbServiceHonor();
            BeanUtils.copyProperties(param,serviceHonor);
            serviceHonor.setAdvisorAccount(account);
            serviceHonor.setCreatedTime(new Date());
            serviceHonor.setCreatorAccount(account);
            serviceHonor.setModifiedTime(new Date());
            serviceHonor.setModifierAccount(account);
            serviceHonor.setId(UUID.randomUUID().toString().replaceAll("-",""));
            serviceHonors.add(serviceHonor);
        }
        int i = advisorMapper.insertServiceHonorList(serviceHonors);
        logger.info("批量插入顾问荣誉资质成功，响应条数{}",i);

        TbServiceProExperCriteria serviceProExperCriteria = new TbServiceProExperCriteria();
        serviceProExperCriteria.createCriteria().andAdvisorAccountEqualTo(account).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        int deleteServiceProCount = tbServiceProExperMapper.deleteByExample(serviceProExperCriteria);
        logger.info("顾问项目经验数据删除成功，响应条数--{}",deleteServiceProCount);
        List<ServiceProjectExperienceParam> projectExperiences = advisorDetailParam.getProjectExperiences();
        List<TbServiceProExper> serviceProExpers = new ArrayList<>(16);
        for (ServiceProjectExperienceParam param:projectExperiences) {
            TbServiceProExper serviceProExper = new TbServiceProExper();
            BeanUtils.copyProperties(param,serviceProExper);
            serviceProExper.setAdvisorAccount(account);
            serviceProExper.setCreatedTime(new Date());
            serviceProExper.setCreatorAccount(account);
            serviceProExper.setModifiedTime(new Date());
            serviceProExper.setModifierAccount(account);
            serviceProExper.setId(UUID.randomUUID().toString().replaceAll("-",""));
            serviceProExpers.add(serviceProExper);
        }
        int i1 = advisorMapper.insertServiceProjectList(serviceProExpers);
        logger.info("批量插入顾问项目经验成功，响应条数{}",i1);

        TbServiceExperienceCriteria serviceExperienceCriteria = new TbServiceExperienceCriteria();
        serviceExperienceCriteria.createCriteria().andAdvisorAccountEqualTo(account).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        int deleteServiceExperienceCount = tbServiceExperienceMapper.deleteByExample(serviceExperienceCriteria);
        logger.info("顾问服务经验数据删除成功，响应条数---{}",deleteServiceExperienceCount);
        List<ServiceExperienceParam> serviceExperiences = advisorDetailParam.getServiceExperiences();
        List<TbServiceExperience> tbServiceExperiences = new ArrayList<>(16);
        for (ServiceExperienceParam param:serviceExperiences) {
            TbServiceExperience serviceExperience = new TbServiceExperience();
            BeanUtils.copyProperties(param,serviceExperience);
            serviceExperience.setCreatedTime(new Date());
            serviceExperience.setAdvisorAccount(account);
            serviceExperience.setCreatorAccount(account);
            serviceExperience.setModifiedTime(new Date());
            serviceExperience.setModifierAccount(account);
            serviceExperience.setId(UUID.randomUUID().toString().replaceAll("-",""));
            tbServiceExperiences.add(serviceExperience);
        }
        int i2 = advisorMapper.insertServiceExperienceList(tbServiceExperiences);
        logger.info("批量插入顾问服务经验成功，响应条数{}",i2);
        AdvisorBaseInfoParam advisorBaseInfoParam = new AdvisorBaseInfoParam();
        BeanUtils.copyProperties(advisorDetailParam, advisorBaseInfoParam);
        advisorBaseInfoParam.setAdvisorAccount(account);
        try {
            advisorBaseInfoParam.setWorkingYears(advisorDetailParam.getWorkingYears());
        }catch (Exception e){
            logger.error("时间转换出错，请核对参数,{}",e.getMessage(),e);
            throw new JnSpringCloudException(AdvisorExceptionEnum.HONOR_INFO_NOT_EXIST);
        }
        advisorEditService.saveOrUpdateAdvisorBaseInfo(advisorBaseInfoParam);
        return 1;
    }


}
