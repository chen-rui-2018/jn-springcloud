package com.jn.park.policy.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.park.enums.PolicyInfoExceptionEnum;
import com.jn.park.policy.dao.PolicyGuideMapper;
import com.jn.park.policy.dao.TbPolicyDetailsMapper;
import com.jn.park.policy.dao.TbPolicyMapper;
import com.jn.park.policy.entity.TbPolicy;
import com.jn.park.policy.entity.TbPolicyCriteria;
import com.jn.park.policy.entity.TbPolicyDetails;
import com.jn.park.policy.entity.TbPolicyDetailsCriteria;
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

    @Autowired
    private TbPolicyDetailsMapper tbPolicyDetailsMapper;
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
            TbPolicy tbPolicy=new TbPolicy();
            BeanUtils.copyProperties(policyInfoEditParam, tbPolicy);
            //政策id
            String policyId=UUID.randomUUID().toString().replaceAll("-", "");
            tbPolicy.setPolicyId(policyId);
            //政策类型 0:普通政策   1：图解政策
            String policyType="0";
            tbPolicy.setPolicyType(policyType);
            //有无关联政策原文  0:无  1：有
            tbPolicy.setIsPolicyOriginal("0");
            int responseNum = policyInfoAdd(tbPolicy, account);
            //添加政策内容
            responseNum+=addPolicyDetails(policyId,account, policyInfoEditParam.getPolicyContent());
            return responseNum;
        }else{
            //修改
            TbPolicy tbPolicy=new TbPolicy();
            BeanUtils.copyProperties(policyInfoEditParam, tbPolicy);
            int responseNum= policyInfoUpdate(tbPolicy, account);
            //修改政策内容
            responseNum+=updatePolicyDetails(policyInfoEditParam.getPolicyId(),account,policyInfoEditParam.getPolicyContent());
            return responseNum;
        }
    }

    /**
     * 修改政策详情
     * @param policyId
     * @param account
     * @param policyContent
     * @return
     */
    @ServiceLog(doAction = "修改政策详情")
    private int updatePolicyDetails(String policyId, String account, String policyContent) {
        TbPolicyDetails tbPolicyDetails=new TbPolicyDetails();
        //政策内容
        tbPolicyDetails.setPolicyContent(policyContent);
        //修改时间
        tbPolicyDetails.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        //修改人
        tbPolicyDetails.setModifierAccount(account);
        TbPolicyDetailsCriteria example=new TbPolicyDetailsCriteria();
        example.createCriteria().andPolicyIdEqualTo(policyId).andRecordStatusEqualTo(RECORD_STATUS);
        return tbPolicyDetailsMapper.updateByExampleSelective(tbPolicyDetails, example);
    }

    /**
     * 新增政策详情
     * @param policyId
     * @param account
     * @param policyContent
     * @return
     */
    @ServiceLog(doAction = "新增政策详情")
    private int addPolicyDetails( String policyId,String account,String policyContent) {
        //新增政策内容
        TbPolicyDetails tbPolicyDetails=new TbPolicyDetails();
        //政策id
        tbPolicyDetails.setPolicyId(policyId);
        //政策内容
        tbPolicyDetails.setPolicyContent(policyContent);
        //创建时间
        tbPolicyDetails.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        //创建人
        tbPolicyDetails.setCreatorAccount(account);
        //是否删除
        tbPolicyDetails.setRecordStatus(RECORD_STATUS);
        return tbPolicyDetailsMapper.insert(tbPolicyDetails);
    }

    /**
     * 修改政策信息
     * @param tbPolicy 入参
     * @param account 用户账号
     */
    @ServiceLog(doAction = "修改政策信息")
    private int policyInfoUpdate(TbPolicy tbPolicy, String account) {
        TbPolicyCriteria example=new TbPolicyCriteria();
        example.createCriteria().andPolicyIdEqualTo(tbPolicy.getPolicyId()).andRecordStatusEqualTo(RECORD_STATUS);
        //修改人
        tbPolicy.setModifierAccount(account);
        //修改时间
        tbPolicy.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        //发布时间
        tbPolicy.setReleaseDate(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        return tbPolicyMapper.updateByExampleSelective(tbPolicy, example);
    }

    /**
     * 新增政策信息
     * @param tbPolicy 包含前端传递信息的政策对象
     * @param account 用户账号
     * @return
     */
    @ServiceLog(doAction = "新增普通政策信息")
    private int policyInfoAdd(TbPolicy tbPolicy, String account) {
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
     * 校验政策管理编辑（新增/修改）入参数据
     * @param policyInfoEditParam
     */
    @ServiceLog(doAction = "校验政策管理编辑（新增/修改）入参数据")
    private void checkPolicyInfoEdit(PolicyInfoEditParam policyInfoEditParam) {
        List<PolicyLevelShow> policyLevelList = policyCenterService.getPolicyLevelList();
        PolicyLevelShow policyLevelShow=new PolicyLevelShow();
        policyLevelShow.setPolicyLevelCode(policyInfoEditParam.getPolicyLevelCode());
        policyLevelShow.setPolicyLevelName(policyInfoEditParam.getPolicyLevelName());
        //测试标志
        boolean checkFlag=true;
        for(PolicyLevelShow ps:policyLevelList){
            if(policyLevelShow.toString().equals(ps.toString())){
                checkFlag=false;
                break;
            }
        }
        if(policyLevelList.isEmpty()|| checkFlag){
            logger.warn("政策管理编辑（新增/修改）入参，政策级别编码：[{}]或政策级别名称:[{}]在系统中不存在"
                    ,policyInfoEditParam.getPolicyLevelCode(),policyInfoEditParam.getPolicyLevelName());
            throw new JnSpringCloudException(PolicyInfoExceptionEnum.POLICY_INFO_LEVEL_NOT_EXIST);
        }
        //清空复位
        checkFlag=true;
        List<PolicyClassShow> classList = policyCenterService.getPolicyClassList();
        PolicyClassShow policyClassShow=new PolicyClassShow();
        policyClassShow.setPolicyClassCode(policyInfoEditParam.getPolicyClassCode());
        policyClassShow.setPolicyClassName(policyInfoEditParam.getPolicyClassName());
        for(PolicyClassShow pc:classList){
            if(StringUtils.equals(policyClassShow.toString(),pc.toString())){
                checkFlag=false;
                break;
            }
        }
        if(classList.isEmpty()|| checkFlag){
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
            List<String> policyIdList=new ArrayList<>(16);
            for(PolicyInfoShow policyInfoShow:policyInfoShowList){
                policyIdList.add(policyInfoShow.getPolicyId());
            }
            if(policyInfoShowList.isEmpty() || !policyIdList.contains(policyInfoEditParam.getRelationPolicyDiagramId())){
                logger.warn("有关联政策图解，政策图解id在系统中不存在");
                throw new JnSpringCloudException(PolicyInfoExceptionEnum.POLICY_DIAGRAM_ID_NOT_EXIST);
            }
        }else{
            if(StringUtils.isNotBlank(policyInfoEditParam.getRelationPolicyDiagramId())){
                logger.warn("没有关联政策图解，政策图解id必须为空");
                throw new JnSpringCloudException(PolicyInfoExceptionEnum.POLICY_DIAGRAM_ID_MUST_NULL);
            }
        }
        if(StringUtils.isNotBlank(policyInfoEditParam.getPolicyId())){
            //若政策id有值，判断政策id在系统中是否存在
            String msg="校验政策管理编辑（新增/修改）入参数据";
            policyIdIsExist(policyInfoEditParam.getPolicyId(),msg);
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

    /**
     * 政策上架/下架上架/下架
     * @param policyId 政策id
     * @param status  状态值，0：下架   1：上架
     * @param account 登录用户账号
     * @return
     */
    @ServiceLog(doAction = "政策上架/下架上架/下架")
    @Override
    public int shelfOrObtained(String policyId,String status, String account) {
        //根据政策id判断政策是否存在
        String msg="政策管理上架/下架";
        policyIdIsExist(policyId,msg);
        //防止重复操作(上架/下架)
        long existNum = getStatusExistNum(policyId, status);
        if(existNum>0){
            //状态标志  1：上架
            String flag="1";
            if(status.equals(flag)){
                logger.warn("当前政策已上架,请不要重复操作");
                throw new JnSpringCloudException(PolicyInfoExceptionEnum.POLICY_EXIST_SHELF);
            }
            logger.warn("当前政策已下架,请不要重复操作");
            throw new JnSpringCloudException(PolicyInfoExceptionEnum.POLICY_EXIST_OBTAINED);
        }
        TbPolicyCriteria example = new TbPolicyCriteria();
        example.createCriteria().andPolicyIdEqualTo(policyId).andRecordStatusEqualTo(RECORD_STATUS);
        TbPolicy tbPolicy=new TbPolicy();
        tbPolicy.setStatus(status);
        tbPolicy.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        tbPolicy.setModifierAccount(account);
        return tbPolicyMapper.updateByExampleSelective(tbPolicy, example);
    }

    /**
     * 根据政策id和状态判断政策在系统中是否存在
     * @param policyId
     * @param status
     * @return
     */
    @ServiceLog(doAction = "根据政策id和状态判断政策在系统中是否存在")
    private long getStatusExistNum(String policyId, String status) {
        long existNum;
        TbPolicyCriteria example = new TbPolicyCriteria();
        example.createCriteria().andPolicyIdEqualTo(policyId).andStatusEqualTo(status).andRecordStatusEqualTo(RECORD_STATUS);
        existNum= tbPolicyMapper.countByExample(example);
        return existNum;
    }

    /**
     * 根据政策id判断政策在系统中是否存在
     * @param policyId
     * @return
     */
    @ServiceLog(doAction = "根据政策id判断政策在系统中是否存在")
    private void policyIdIsExist(String policyId,String msg) {
        if(StringUtils.isNotBlank(policyId)){
            TbPolicyCriteria example = new TbPolicyCriteria();
            example.createCriteria().andPolicyIdEqualTo(policyId).andRecordStatusEqualTo(RECORD_STATUS);
            long existNum = tbPolicyMapper.countByExample(example);
            if (existNum == 0) {
                logger.warn("{},当前政策id在系统中不存在",msg);
                throw new JnSpringCloudException(PolicyInfoExceptionEnum.POLICY_ID_NOT_EXIST);
            }
        }else{
            logger.warn("当前政策id为不能为空");
            throw new JnSpringCloudException(PolicyInfoExceptionEnum.POLICY_ID_NOT_NULL);
        }

    }


    /**
     * 获取普通政策详情
     * @param policyId 政策id
     * @return
     */
    @ServiceLog(doAction = "获取普通政策详情")
    @Override
    public PolicyGuideDetailsShow getPolicyGuidDetails(String policyId) {
        String msg="获取普通政策详情";
        policyIdIsExist(policyId,msg);
        return policyGuideMapper.getPolicyGuidDetails(policyId);
    }

    /**
     * 图解政策管理
     * @param policyManagementParam
     * @return
     */
    @ServiceLog(doAction = "图解政策管理")
    @Override
    public PaginationData getDiagramPolicyManagementList(PolicyManagementParam policyManagementParam) {
        com.github.pagehelper.Page<Object> objects = null;
        if(StringUtils.isBlank(policyManagementParam.getNeedPage())){
            //默认查询第1页的15条数据
            int pageNum=1;
            int pageSize=15;
            objects = PageHelper.startPage(pageNum,pageSize, true);
            List<PolicyDiagramManagementShow> resultList=policyGuideMapper.getDiagramPolicyManagementList(policyManagementParam);
            return new PaginationData(resultList, objects == null ? 0 : objects.getTotal());
        }
        //需要分页标识
        String isPage="1";
        if(isPage.equals(policyManagementParam.getNeedPage())){
            objects = PageHelper.startPage(policyManagementParam.getPage(),
                    policyManagementParam.getRows() == 0 ? 15 : policyManagementParam.getRows(), true);
        }
        List<PolicyDiagramManagementShow> resultList = policyGuideMapper.getDiagramPolicyManagementList(policyManagementParam);
        return new PaginationData(resultList, objects == null ? 0 : objects.getTotal());
    }

    /**
     * 图解政策管理编辑（新增/修改）
     * @param policyDiagramInfoEditParam
     * @param account   当前登录用户账号
     * @return
     */
    @ServiceLog(doAction = "图解政策管理编辑（新增/修改）")
    @Override
    public int saveOrUpdateDiagramPolicyInfo(PolicyDiagramInfoEditParam policyDiagramInfoEditParam, String account) {
       //数据校验
        checkPolicyDiagramInfoEdit(policyDiagramInfoEditParam);
        //是否有政策id
        if(StringUtils.isBlank(policyDiagramInfoEditParam.getPolicyId())){
            //新增
            TbPolicy tbPolicy=new TbPolicy();
            BeanUtils.copyProperties(policyDiagramInfoEditParam, tbPolicy);
            //政策id
            String policyId=UUID.randomUUID().toString().replaceAll("-", "");
            tbPolicy.setPolicyId(policyId);
            //政策类型 0:普通政策   1：图解政策
            String policyType="1";
            tbPolicy.setPolicyType(policyType);
            return policyInfoAdd(tbPolicy, account);
        }else{
            //修改
            TbPolicy tbPolicy=new TbPolicy();
            BeanUtils.copyProperties(policyDiagramInfoEditParam, tbPolicy);
            return policyInfoUpdate(tbPolicy, account);
        }
    }

    /**
     * 校验图解政策管理编辑（新增/修改）入参数据
     * @param policyDiagramInfoEditParam
     */
    @ServiceLog(doAction = "校验图解政策管理编辑（新增/修改）入参数据")
    private void checkPolicyDiagramInfoEdit(PolicyDiagramInfoEditParam policyDiagramInfoEditParam) {
        //有关联图解id
        String isPolicyDiagram="1";
        if(isPolicyDiagram.equals(policyDiagramInfoEditParam.getIsPolicyOriginal())){
            if(StringUtils.isBlank(policyDiagramInfoEditParam.getRelationPolicyOriginalId())){
                logger.warn("有关联政策原文，政策原文id不能为空");
                throw new JnSpringCloudException(PolicyInfoExceptionEnum.POLICY_ORIGINAL_ID_NOT_NULL);
            }
            //校验关联的政策原文id在系统中是否存在
            //0:普通政策/政策原文   1：图解政策
            String policyType="0";
            List<PolicyInfoShow> policyInfoShowList = getPolicyInfo(policyType);
            if(policyInfoShowList.isEmpty()){
                logger.warn("有关联政策图解，政策图解id在系统中不存在");
                throw new JnSpringCloudException(PolicyInfoExceptionEnum.POLICY_DIAGRAM_ID_NOT_EXIST);
            }
            List<String> policyIdList=new ArrayList<>(16);
            for(PolicyInfoShow policyInfoShow:policyInfoShowList){
                policyIdList.add(policyInfoShow.getPolicyId());
            }
            if(!policyIdList.contains(policyDiagramInfoEditParam.getRelationPolicyOriginalId())){
                logger.warn("有关联政策原文，政策原文id在系统中不存在");
                throw new JnSpringCloudException(PolicyInfoExceptionEnum.POLICY_ORIGINAL_ID_NOT_EXIST);
            }
        }else{
            if(StringUtils.isNotBlank(policyDiagramInfoEditParam.getRelationPolicyOriginalId())){
                logger.warn("没有关联政策原文，政策原文id必须为空");
                throw new JnSpringCloudException(PolicyInfoExceptionEnum.POLICY_ORIGINAL_ID_MUST_NULL);
            }
        }
        if(StringUtils.isNotBlank(policyDiagramInfoEditParam.getPolicyId())){
            //若政策id有值，判断政策id在系统中是否存在
            String msg="校验图解政策管理编辑（新增/修改）入参数据";
            policyIdIsExist(policyDiagramInfoEditParam.getPolicyId(),msg);
        }
    }

    /**
     * 获取图解政策详情
     * @param policyId 政策id
     * @return
     */
    @ServiceLog(doAction = "获取图解政策详情")
    @Override
    public PolicyGuideDiagramDetailsShow getPolicyGuidDiagramDetails(String policyId) {
        String msg="获取图解政策详情";
        policyIdIsExist(policyId,msg);
        return policyGuideMapper.getPolicyGuidDiagramDetails(policyId);
    }
}
