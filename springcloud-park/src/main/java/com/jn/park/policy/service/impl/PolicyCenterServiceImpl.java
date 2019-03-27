package com.jn.park.policy.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.park.enums.PolicyCenterExceptionEnum;
import com.jn.park.policy.dao.TbPolicyClassMapper;
import com.jn.park.policy.dao.TbPolicyLevelMapper;
import com.jn.park.policy.dao.TbPolicyMapper;
import com.jn.park.policy.entity.TbPolicyClass;
import com.jn.park.policy.entity.TbPolicyClassCriteria;
import com.jn.park.policy.entity.TbPolicyLevel;
import com.jn.park.policy.entity.TbPolicyLevelCriteria;
import com.jn.park.policy.model.PolicyClassShow;
import com.jn.park.policy.model.PolicyLevelShow;
import com.jn.park.policy.service.PolicyCenterService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/3/27 14:07
 * @Version v1.0
 * @modified By:
 */
@Service
public class PolicyCenterServiceImpl implements PolicyCenterService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(PolicyCenterServiceImpl.class);

    /**
     * 是否删除  0：已删除    1：有效
     */
    private static final byte RECORD_STATUS=1;

    @Autowired
    private TbPolicyMapper tbPolicyMapper;

    @Autowired
    private TbPolicyLevelMapper tbPolicyLevelMapper;

    @Autowired
    private TbPolicyClassMapper tbPolicyClassMapper;

    /**
     * 政策级别列表
     * @return
     */
    @ServiceLog(doAction = "政策级别列表")
    @Override
    public List<PolicyLevelShow> getPolicyLevelList() {
        TbPolicyLevelCriteria example=new TbPolicyLevelCriteria();
        example.createCriteria().andPolicyLevelCodeIsNotNull().andRecordStatusEqualTo(RECORD_STATUS);
        List<TbPolicyLevel> tbPolicyLevelList = tbPolicyLevelMapper.selectByExample(example);
        if(tbPolicyLevelList.isEmpty()){
            logger.warn("政策级别列表获取数据失败，系统中没有政策级别的数据");
            throw new JnSpringCloudException(PolicyCenterExceptionEnum.POLICY_LEVEL_NOT_EXIST);
        }
        List<PolicyLevelShow> resultList=new ArrayList<>(16);
        for (TbPolicyLevel tbPolicyLevel : tbPolicyLevelList) {
            PolicyLevelShow policyLevelShow=new PolicyLevelShow();
            policyLevelShow.setPolicyLevelCode(tbPolicyLevel.getPolicyLevelCode());
            policyLevelShow.setPolicyLevelName(tbPolicyLevel.getPolicyLevelName());
            resultList.add(policyLevelShow);
        }
        return resultList;
    }

    /**
     * 政策分类列表
     * @return
     */
    @ServiceLog(doAction = "政策分类列表")
    @Override
    public List<PolicyClassShow> getPolicyClassList() {
        TbPolicyClassCriteria example=new TbPolicyClassCriteria();
        example.createCriteria().andPolicyClassCodeIsNotNull().andRecordStatusEqualTo(RECORD_STATUS);
        List<TbPolicyClass> tbPolicyClassList = tbPolicyClassMapper.selectByExample(example);
        if(tbPolicyClassList.isEmpty()){
            logger.warn("政策分类列表获取数据失败，系统中没有政策分类的数据");
            throw new JnSpringCloudException(PolicyCenterExceptionEnum.POLICY_CLASS_NOT_EXIST);
        }
        List<PolicyClassShow> resultList=new ArrayList<>(16);
        for (TbPolicyClass tbPolicyClass : tbPolicyClassList) {
            PolicyClassShow policyClassShow=new PolicyClassShow();
            policyClassShow.setPolicyClassCode(tbPolicyClass.getPolicyClassCode());
            policyClassShow.setPolicyClassName(tbPolicyClass.getPolicyClassName());
            resultList.add(policyClassShow);
        }
        return resultList;
    }
}
