package com.jn.park.policy.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.park.enums.PolicyCenterExceptionEnum;
import com.jn.park.policy.dao.PolicyCenterMapper;
import com.jn.park.policy.dao.TbPolicyClassMapper;
import com.jn.park.policy.dao.TbPolicyLevelMapper;
import com.jn.park.policy.entity.TbPolicyClass;
import com.jn.park.policy.entity.TbPolicyClassCriteria;
import com.jn.park.policy.entity.TbPolicyLevel;
import com.jn.park.policy.entity.TbPolicyLevelCriteria;
import com.jn.park.policy.enums.PolicyTableTypeEnum;
import com.jn.park.policy.model.PolicyCenterHomeParam;
import com.jn.park.policy.model.PolicyCenterHomeShow;
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
    private TbPolicyLevelMapper tbPolicyLevelMapper;

    @Autowired
    private TbPolicyClassMapper tbPolicyClassMapper;

    @Autowired
    private PolicyCenterMapper policyCenterMapper;



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

    /**
     * 政策中心首页--政策一览
     * @param policyCenterHomeParam
     * @return
     */
    @ServiceLog(doAction = "政策中心首页")
    @Override
    public PaginationData getPolicyCenterList(PolicyCenterHomeParam policyCenterHomeParam) {
        //专题类型(0：一号专题   1：民营专题)  默认为空
        String thematicType="";
        //政策一览  政策类型必传
        if(PolicyTableTypeEnum.ALL_POLICY.getCode().equals(policyCenterHomeParam.getTableType())){
            if(StringUtils.isBlank(policyCenterHomeParam.getPolicyType())){
                logger.warn("政策中心首页，政策一览table页政策类型不能为空");
                throw new JnSpringCloudException(PolicyCenterExceptionEnum.POLICY_TYPE_NOT_NULL);
            }
        }else if(PolicyTableTypeEnum.DIAGRAM_POLICY.getCode().equals(policyCenterHomeParam.getTableType())){
            //图解政策 政策类型为图解政策（"1"）
            policyCenterHomeParam.setPolicyType("1");
        }else if(PolicyTableTypeEnum.FIRST_TOPIC.getCode().equals(policyCenterHomeParam.getTableType())){
            //一号专题
            thematicType="0";
        }else if(PolicyTableTypeEnum.PRIVATE_TOPIC.getCode().equals(policyCenterHomeParam.getTableType())){
            //民营专题
            thematicType="1";
        }
        //非政策一览table页，政策级别，政策分类，发布时间，政策检索等查询条件全部清空
        if(!PolicyTableTypeEnum.ALL_POLICY.getCode().equals(policyCenterHomeParam.getTableType())){
            //政策级别清空
            policyCenterHomeParam.setPolicyClassCode("");
            //政策分类清空
            policyCenterHomeParam.setPolicyClassCode("");
            //发布时间清空
            policyCenterHomeParam.setReleaseDate("");
            //政策检索清空
            policyCenterHomeParam.setPolicySearch("");
        }

        com.github.pagehelper.Page<Object> objects = null;
        if(StringUtils.isBlank(policyCenterHomeParam.getNeedPage())){
            //默认查询第1页的15条数据
            int pageNum=1;
            int pageSize=15;
            objects = PageHelper.startPage(pageNum,pageSize, true);

            List<PolicyCenterHomeShow> resultList=policyCenterMapper.getPolicyCenterList(policyCenterHomeParam,thematicType);
            return new PaginationData(resultList, objects == null ? 0 : objects.getTotal());
        }
        //需要分页标识
        String isPage="1";
        if(isPage.equals(policyCenterHomeParam.getNeedPage())){
            objects = PageHelper.startPage(policyCenterHomeParam.getPage(),
                    policyCenterHomeParam.getRows() == 0 ? 15 : policyCenterHomeParam.getRows(), true);
        }
        List<PolicyCenterHomeShow> investorInfoList = policyCenterMapper.getPolicyCenterList(policyCenterHomeParam,thematicType);
        return new PaginationData(investorInfoList, objects == null ? 0 : objects.getTotal());
    }
}
