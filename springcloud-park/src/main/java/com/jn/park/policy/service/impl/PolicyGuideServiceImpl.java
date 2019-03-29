package com.jn.park.policy.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.park.enums.PolicyInfoExceptionEnum;
import com.jn.park.policy.dao.PolicyGuideMapper;
import com.jn.park.policy.dao.TbPolicyMapper;
import com.jn.park.policy.entity.TbPolicy;
import com.jn.park.policy.entity.TbPolicyCriteria;
import com.jn.park.policy.model.*;
import com.jn.park.policy.service.PolicyCenterService;
import com.jn.park.policy.service.PolicyGuideService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: yangph
 * @Date: 2019/3/29 10:52
 * @Version v1.0
 * @modified By:
 */
@Service
public class PolicyGuideServiceImpl implements PolicyGuideService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(PolicyGuideServiceImpl.class);

    @Autowired
    private PolicyGuideMapper policyGuideMapper;

    @Autowired
    private PolicyCenterService policyCenterService;

    @Autowired
    private TbPolicyMapper tbPolicyMapper;
    /**
     * 日期格式
     */
    private static final String PATTERN="yyyy-MM-dd HH:mm:ss";
    /**
     * 是否删除  0：已删除  1：有效
     */
    private static final byte RECORD_STATUS=1;

    /**
     * 政策管理
     * @param policyManagementParam
     * @return
     */
    @ServiceLog(doAction = "政策管理")
    @Override
    public PaginationData getPolicyManagementList(PolicyManagementParam policyManagementParam) {
        com.github.pagehelper.Page<Object> objects = null;
        if(StringUtils.isBlank(policyManagementParam.getNeedPage())){
            //默认查询第1页的15条数据
            int pageNum=1;
            int pageSize=15;
            objects = PageHelper.startPage(pageNum,pageSize, true);
            List<PolicyManagementShow> resultList=policyGuideMapper.getPolicyManagementList(policyManagementParam);
            return new PaginationData(resultList, objects == null ? 0 : objects.getTotal());
        }
        //需要分页标识
        String isPage="1";
        if(isPage.equals(policyManagementParam.getNeedPage())){
            objects = PageHelper.startPage(policyManagementParam.getPage(),
                    policyManagementParam.getRows() == 0 ? 15 : policyManagementParam.getRows(), true);
        }
        List<PolicyManagementShow> policyManagementList = policyGuideMapper.getPolicyManagementList(policyManagementParam);
        return new PaginationData(policyManagementList, objects == null ? 0 : objects.getTotal());
    }

    /**
     * 政策管理编辑（新增/修改）
     * @param policyInfoEditParam
     * @param account 当前登录用户账号
     * @return
     */
    @ServiceLog(doAction = "政策管理编辑（新增/修改）")
    @Override
    public int saveOrUpdatePolicyInfo(PolicyInfoEditParam policyInfoEditParam,String account) {
        //数据校验
        checkPolicyInfoEdit(policyInfoEditParam);
        //是否有政策id
        if(StringUtils.isBlank(policyInfoEditParam.getPolicyId())){
            //新增
            return policyInfoAdd(policyInfoEditParam, account);
        }else{
            //修改
            policyInfoUpdate(policyInfoEditParam, account);
        }
        return 0;
    }

    /**
     * 修改普通政策信息
     * @param policyInfoEditParam 入参
     * @param account 用户账号
     */
    @ServiceLog(doAction = "修改普通政策信息")
    private void policyInfoUpdate(PolicyInfoEditParam policyInfoEditParam, String account) {
        TbPolicyCriteria example=new TbPolicyCriteria();
        example.createCriteria().andPolicyIdEqualTo(policyInfoEditParam.getPolicyId()).andRecordStatusEqualTo(RECORD_STATUS);
        TbPolicy tbPolicy=new TbPolicy();
        BeanUtils.copyProperties(policyInfoEditParam, tbPolicy);
        //修改人
        tbPolicy.setModifierAccount(account);
        //修改时间
        tbPolicy.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        //发布时间
        tbPolicy.setReleaseDate(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        tbPolicyMapper.updateByExampleSelective(tbPolicy, example);
    }

    /**
     * 新增普通政策信息
     * @param policyInfoEditParam 入参
     * @param account 用户账号
     * @return
     */
    @ServiceLog(doAction = "新增普通政策信息")
    private int policyInfoAdd(PolicyInfoEditParam policyInfoEditParam, String account) {
        TbPolicy tbPolicy=new TbPolicy();
        BeanUtils.copyProperties(policyInfoEditParam, tbPolicy);
        //政策id
        tbPolicy.setPolicyId(UUID.randomUUID().toString().replaceAll("-", ""));
        //政策编码
        tbPolicy.setPolicyCode(getPolicyCode());
        //阅读次数
        tbPolicy.setReadNum(0);
        //发布日期
        tbPolicy.setReleaseDate(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        //创建人
        tbPolicy.setCreatorAccount(account);
        //创建时间
        tbPolicy.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        //是否删除
        tbPolicy.setRecordStatus(RECORD_STATUS);
        return tbPolicyMapper.insertSelective(tbPolicy);
    }

    /**
     * 校验政策管理编辑（新增/修改）数据
     * @param policyInfoEditParam
     */
    @ServiceLog(doAction = "校验政策管理编辑（新增/修改）数据")
    private void checkPolicyInfoEdit(PolicyInfoEditParam policyInfoEditParam) {
        List<PolicyLevelShow> policyLevelList = policyCenterService.getPolicyLevelList();
        PolicyLevelShow policyLevelShow=new PolicyLevelShow();
        policyLevelShow.setPolicyLevelCode(policyInfoEditParam.getPolicyLevelCode());
        policyLevelShow.setPolicyLevelName(policyInfoEditParam.getPolicyLevelName());
        if(policyLevelList.isEmpty() || !policyLevelList.contains(policyLevelShow)){
            logger.warn("政策管理编辑（新增/修改）入参，政策级别编码：[{}]或政策级别名称:[{}]在系统中不存在"
                    ,policyInfoEditParam.getPolicyLevelCode(),policyInfoEditParam.getPolicyLevelName());
            throw new JnSpringCloudException(PolicyInfoExceptionEnum.POLICY_INFO_LEVEL_NOT_EXIST);
        }
        List<PolicyClassShow> classList = policyCenterService.getPolicyClassList();
        PolicyClassShow policyClassShow=new PolicyClassShow();
        policyClassShow.setPolicyClassCode(policyInfoEditParam.getPolicyClassCode());
        policyClassShow.setPolicyClassName(policyInfoEditParam.getPolicyClassName());
        if(classList.isEmpty() || !classList.contains(policyClassShow)){
            logger.warn("政策管理编辑（新增/修改）入参，政策分类编码：[{}]或政策分类名称:[{}]在系统中不存在"
                    ,policyInfoEditParam.getPolicyClassCode(),policyInfoEditParam.getPolicyClassName());
            throw new JnSpringCloudException(PolicyInfoExceptionEnum.POLICY_INFO_CLASS_NOT_EXIST);
        }
        //有关联图解id
        String isPolicyDiagram="1";
        if(isPolicyDiagram.equals(policyInfoEditParam.getIsPolicyDiagram())){
            if(StringUtils.isBlank(policyInfoEditParam.getRelationPolicyDiagramId())){
                logger.warn("有关联政策图解，政策图解id不能为空");
                throw new JnSpringCloudException(PolicyInfoExceptionEnum.POLICY_DIAGRAM_ID_NOT_NULL);
            }
            //校验关联的政策图解id在系统中是否存在
            //0:普通政策/政策原文   1：图解政策
            String policyType="1";
            List<PolicyInfoShow> policyInfoShowList = getPolicyInfo(policyType);
            if(policyInfoShowList.isEmpty()){
                logger.warn("有关联政策图解，政策图解id在系统中不存在");
                throw new JnSpringCloudException(PolicyInfoExceptionEnum.POLICY_DIAGRAM_ID_NOT_EXIST);
            }
            List<String> policyIdList=new ArrayList<>(16);
            for(PolicyInfoShow policyInfoShow:policyInfoShowList){
                policyIdList.add(policyInfoShow.getPolicyId());
            }
            if(!policyIdList.contains(policyInfoEditParam.getRelationPolicyDiagramId())){
                logger.warn("有关联政策图解，政策图解id在系统中不存在");
                throw new JnSpringCloudException(PolicyInfoExceptionEnum.POLICY_DIAGRAM_ID_NOT_EXIST);
            }
        }else{
            if(StringUtils.isNotBlank(policyInfoEditParam.getRelationPolicyDiagramId())){
                logger.warn("没有关联政策图解，政策图解id必须为空");
                throw new JnSpringCloudException(PolicyInfoExceptionEnum.POLICY_DIAGRAM_ID_NOT_NULL);
            }
        }

        //若政策id有值，判断政策id在系统中是否存在
        if(StringUtils.isNotBlank(policyInfoEditParam.getPolicyId())){
            TbPolicyCriteria example=new TbPolicyCriteria();
            example.createCriteria().andPolicyIdEqualTo(policyInfoEditParam.getPolicyId()).andRecordStatusEqualTo(RECORD_STATUS);
            long existNum = tbPolicyMapper.countByExample(example);
            if(existNum==0){
                logger.warn("当前政策id在系统中不存在");
                throw new JnSpringCloudException(PolicyInfoExceptionEnum.POLICY_ID_NOT_EXIST);
            }
        }

    }

    /**
     * 获取政策编号
     * @return
     */
    @ServiceLog(doAction = "获取政策编号")
    @Override
    public String getPolicyCode() {
        return "GDNJ"+ DateUtils.getDate("yyyyMMddHHmmss");
    }

    /**
     * 关联图解政策信息/关联政策原文信息
     * @param policyType  政策类型  0:普通政策/政策原文   1：图解政策
     * @return
     */
    @ServiceLog(doAction = "关联图解政策信息/关联政策原文信息")
    @Override
    public List<PolicyInfoShow> getPolicyInfo(String policyType) {
        return policyGuideMapper.getPolicyInfo(policyType);
    }


}
