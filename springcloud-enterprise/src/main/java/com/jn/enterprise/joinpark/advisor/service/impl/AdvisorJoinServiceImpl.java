package com.jn.enterprise.joinpark.advisor.service.impl;

import com.jn.enterprise.joinpark.advisor.service.AdvisorJoinService;
import com.jn.enterprise.servicemarket.advisor.dao.AdvisorMapper;
import com.jn.enterprise.servicemarket.advisor.dao.TbServiceExperienceMapper;
import com.jn.enterprise.servicemarket.advisor.dao.TbServiceHonorMapper;
import com.jn.enterprise.servicemarket.advisor.dao.TbServiceProExperMapper;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceExperienceCriteria;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceHonorCriteria;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceProExperCriteria;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorDetailParam;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
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
        int i = advisorMapper.insertServiceHonorList(advisorDetailParam.getServiceHonors());
        logger.info("批量插入顾问荣誉资质成功，响应条数{}",i);

        TbServiceProExperCriteria serviceProExperCriteria = new TbServiceProExperCriteria();
        serviceProExperCriteria.createCriteria().andAdvisorAccountEqualTo(account).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        int deleteServiceProCount = tbServiceProExperMapper.deleteByExample(serviceProExperCriteria);
        logger.info("顾问项目经验数据删除成功，响应条数--{}",deleteServiceProCount);
        int i1 = advisorMapper.insertServiceProjectList(advisorDetailParam.getProjectExperiences());
        logger.info("批量插入顾问项目经验成功，响应条数{}",i1);

        TbServiceExperienceCriteria serviceExperienceCriteria = new TbServiceExperienceCriteria();
        serviceExperienceCriteria.createCriteria().andAdvisorAccountEqualTo(account).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        int deleteServiceExperienceCount = tbServiceExperienceMapper.deleteByExample(serviceExperienceCriteria);
        logger.info("顾问服务经验数据删除成功，响应条数---{}",deleteServiceExperienceCount);
        int i2 = advisorMapper.insertServiceExperienceList(advisorDetailParam.getServiceExperiences());
        logger.info("批量插入顾问服务经验成功，响应条数{}",i2);

        

        return 1;
    }


}
