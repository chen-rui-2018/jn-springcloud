package com.jn.park.policy.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.utils.IBPSFileUtils;
import com.jn.park.enums.PolicyInfoExceptionEnum;
import com.jn.park.policy.dao.PolicyCenterMapper;
import com.jn.park.policy.dao.TbPolicyClassMapper;
import com.jn.park.policy.dao.TbPolicyLevelMapper;
import com.jn.park.policy.dao.TbPolicyMapper;
import com.jn.park.policy.entity.*;
import com.jn.park.policy.enums.PolicyTableTypeEnum;
import com.jn.park.policy.model.*;
import com.jn.park.policy.service.PolicyCenterService;
import com.jn.park.policy.vo.PolicyDiagramDetailsVo;
import com.jn.park.utils.HtmlUtils;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private PolicyCenterMapper policyCenterMapper;

    private static final String  PATTERN="yyyy-MM-dd HH:mm:ss";


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
            throw new JnSpringCloudException(PolicyInfoExceptionEnum.POLICY_LEVEL_NOT_EXIST);
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
            throw new JnSpringCloudException(PolicyInfoExceptionEnum.POLICY_CLASS_NOT_EXIST);
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
     * 政策中心首页
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
                throw new JnSpringCloudException(PolicyInfoExceptionEnum.POLICY_TYPE_NOT_NULL);
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
        }else{
            logger.warn("政策中心首页的table类型在系统中不存在");
            throw new JnSpringCloudException(PolicyInfoExceptionEnum.TABLE_TYPE_IS_NOT_EXIST);
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

        // 处理图片格式和简要内容
        if (!investorInfoList.isEmpty()) {
            for (PolicyCenterHomeShow policy : investorInfoList){
                //处理图片
                if (StringUtils.isNotBlank(policy.getPolicyDiagramUrl())) {
                    policy.setPolicyDiagramUrl(IBPSFileUtils.getFilePath(policy.getPolicyDiagramUrl()));
                }
                //设置简要内容
                String briefContent= HtmlUtils.getBriefIntroduction(policy.getPolicyContent());
                if(StringUtils.isNotBlank(briefContent)){
                    String briefSummaries=briefContent.substring(0,briefContent.length()>100?100:briefContent.length());
                    briefSummaries=briefContent.length()>100?briefSummaries+"......":briefSummaries;
                    policy.setBriefContent(briefSummaries);
                    //清空详情
                    policy.setPolicyContent("");
                }
            }
        }
        return new PaginationData(investorInfoList, objects == null ? 0 : objects.getTotal());
    }

    /**
     * 政策指南详情
     * @param policyId  政策id
     * @return
     */
    @ServiceLog(doAction = "政策指南详情")
    @Override
    public PolicyDetailsShow getPolicyDetails(String policyId) {
        //判断当前政策id在系统中是否存在，且政策类型是普通政策
        String policyType="0";
        TbPolicyCriteria example = getTbPolicyCriteria(policyId, policyType);
        List<TbPolicy> tbPolicyList = tbPolicyMapper.selectByExample(example);
        //没有数据
        if(tbPolicyList.isEmpty()){
            logger.warn("政策id为[{}的政策在系统中不存在或当前政策类型不是普通政策]");
            throw new JnSpringCloudException(PolicyInfoExceptionEnum.POLICY_DETAILS_NOT_EXIST);
        }
        //根据政策id查询详情
        PolicyDetailsShow policyDetails = policyCenterMapper.getPolicyDetails(policyId);
        updatePolicyReadNum(example, tbPolicyList.get(0).getReadNum()==null?0:tbPolicyList.get(0).getReadNum());
        return policyDetails;
    }

    /**
     * 更新阅读次数
     * @param example
     * @param oldReadNum
     */
    private void updatePolicyReadNum(TbPolicyCriteria example, int oldReadNum) {
        //更新阅读次数
        TbPolicy tbPolicy=new TbPolicy();
        tbPolicy.setReadNum(oldReadNum+1);
        tbPolicyMapper.updateByExampleSelective(tbPolicy, example);
    }

    /**
     * 获取政策详情查询条件
     * @param policyId  政策id
     * @param policyType   政策类型
     * @return
     */
    @ServiceLog(doAction = "获取政策详情查询条件")
    private TbPolicyCriteria getTbPolicyCriteria(String policyId, String policyType) {
        TbPolicyCriteria example = new TbPolicyCriteria();
        //根据政策id，有效状态（status="1"）,政策类型为普通政策（policyType="0"）,是否删除（recordStatus="1"）来判断
        example.createCriteria().andPolicyIdEqualTo(policyId).andStatusEqualTo("1")
                .andPolicyTypeEqualTo(policyType).andRecordStatusEqualTo(RECORD_STATUS);
        return example;
    }

    /**
     * 图解政策详情
     * @param policyId 政策id
     * @return
     */
    @ServiceLog(doAction = "图解政策详情")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PolicyDiagramDetailsVo getPolicyDiagramDetails(String policyId) {
        //判断当前政策id在系统中是否存在，且政策类型是图解政策
        String policyType="1";
        TbPolicyCriteria example = getTbPolicyCriteria(policyId, policyType);
        List<TbPolicy> tbPolicyList = tbPolicyMapper.selectByExample(example);
        //没有数据
        if(tbPolicyList.isEmpty()){
            logger.warn("政策id为[{}的政策在系统中不存在或当前政策类型不是图解政策]");
            throw new JnSpringCloudException(PolicyInfoExceptionEnum.POLICY_DIAGRAM_DETAILS_NOT_EXIST);
        }
        TbPolicy tbPolicy = tbPolicyList.get(0);
        //设置图解政策前端展示字段的值
        PolicyDiagramDetailsVo policyDiagramDetailsVo=new PolicyDiagramDetailsVo();
        BeanUtils.copyProperties(tbPolicy, policyDiagramDetailsVo);
        //发布日期
        policyDiagramDetailsVo.setReleaseDate(DateUtils.formatDate(tbPolicyList.get(0).getReleaseDate(),PATTERN));
        //更新阅读次数
        updatePolicyReadNum(example,tbPolicy.getReadNum()==null?0:tbPolicy.getReadNum());
        //有无关联政策原文  0：无  1：有
        String isPolicyOriginal="1";
        if(isPolicyOriginal.equals(tbPolicy.getIsPolicyDiagram())){
            //设置政策原文  获取绑定的普通政策的id
            String relationPolicyOriginalId = tbPolicy.getRelationPolicyOriginalId();
            policyType="0";
            //查询政策原文的名称
            //PolicyDetailsShow policyDetails = policyCenterMapper.getPolicyDetails(relationPolicyOriginalId);
            //获取普通政策的名称
            //String policyTitle=policyDetails.getPolicyTitle();
            example = getTbPolicyCriteria(relationPolicyOriginalId, policyType);
            long existNum = tbPolicyMapper.countByExample(example);
            if(existNum>0){
                policyDiagramDetailsVo.setPolicyDetailsShow(getPolicyDetails(relationPolicyOriginalId));
            }
        }

        // 处理图片格式
        if (StringUtils.isNotBlank(policyDiagramDetailsVo.getPolicyDiagramUrl())) {
            policyDiagramDetailsVo.setPolicyDiagramUrl(IBPSFileUtils.getFilePath(policyDiagramDetailsVo.getPolicyDiagramUrl()));
        }
        return policyDiagramDetailsVo;
    }
}
