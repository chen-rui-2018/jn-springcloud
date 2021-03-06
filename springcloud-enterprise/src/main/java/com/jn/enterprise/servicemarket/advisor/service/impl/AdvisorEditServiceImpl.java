package com.jn.enterprise.servicemarket.advisor.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.propaganda.enums.ApprovalStatusEnum;
import com.jn.enterprise.servicemarket.advisor.dao.*;
import com.jn.enterprise.servicemarket.advisor.entity.*;
import com.jn.enterprise.servicemarket.advisor.model.*;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorEditService;
import com.jn.enterprise.servicemarket.industryarea.model.IndustryDictParameter;
import com.jn.enterprise.servicemarket.industryarea.model.IndustryDictionary;
import com.jn.enterprise.servicemarket.industryarea.service.IndustryService;
import com.jn.enterprise.servicemarket.org.dao.TbServiceOrgMapper;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrg;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgCriteria;
import com.jn.enterprise.usercenterindex.enums.UserCenterExceptionEnum;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 编辑专员资料
 * @Author: yangph
 * @Date: 2019/2/27 10:13
 * @Version v1.0
 * @modified By:
 */
@Service
public class AdvisorEditServiceImpl implements AdvisorEditService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(AdvisorEditServiceImpl.class);

    @Autowired
    private TbServiceAdvisorMapper tbServiceAdvisorMapper;

    @Autowired
    private TbServiceHonorMapper tbServiceHonorMapper;

    @Autowired
    private TbServiceExperienceMapper tbServiceExperienceMapper;

    @Autowired
    private TbServiceProExperMapper tbServiceProExperMapper;

    @Autowired
    private TbServiceCertificateTypeMapper tbServiceCertificateTypeMapper;

    @Autowired
    private UserExtensionClient userExtensionClient;

    @Autowired
    private IndustryService industryService;

    @Autowired
    private TbServiceOrgMapper tbServiceOrgMapper;
    /**
     * 日期格式
     */
    private static final String PATTERN="yyyy-MM-dd HH:mm:ss";

    /**
     * 参数示例，swagger注解默认example值
     */
    private static final String PARAM_EXAMPLE="string";

    /**
     * 判断当前登录用户认证专员的状态
     * @param loginAccount 当前登录用户
     * @return
     */
    @ServiceLog(doAction = "判断当前登录用户认证专员的状态")
    @Override
    public  AdvisorApprovalStatus getUserApprovalStatus(String loginAccount) {
        //已拒绝和已解除可以再次认证
        List<String> noApprovalStatus= Arrays.asList(ApprovalStatusEnum.REFUSED.getValue(),ApprovalStatusEnum.LIFTED.getValue());
        TbServiceAdvisorCriteria example=new TbServiceAdvisorCriteria();
        example.createCriteria().andAdvisorAccountEqualTo(loginAccount)
                .andApprovalStatusNotIn(noApprovalStatus)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbServiceAdvisor> tbServiceAdvisors = tbServiceAdvisorMapper.selectByExample(example);
        AdvisorApprovalStatus advisorApprovalStatus=new AdvisorApprovalStatus();
        if(tbServiceAdvisors.isEmpty()){
            advisorApprovalStatus.setApprovalStatus(0);
            advisorApprovalStatus.setApprovalDesc("未认证");
            return advisorApprovalStatus;
        }
        //审批状态
        String approvalStatus=tbServiceAdvisors.get(0).getApprovalStatus();
        if(StringUtils.equals(ApprovalStatusEnum.NOT_APPROVED.getValue(),approvalStatus)){
            //未认证
            advisorApprovalStatus.setApprovalStatus(0);
            advisorApprovalStatus.setApprovalDesc("未认证");
        }else if(StringUtils.equals(ApprovalStatusEnum.APPROVAL.getValue(),approvalStatus)){
            //认证中
            advisorApprovalStatus.setApprovalStatus(1);
            advisorApprovalStatus.setApprovalDesc("认证中");
        }else if(StringUtils.equals(ApprovalStatusEnum.APPROVED.getValue(),approvalStatus)){
            //认证通过
            advisorApprovalStatus.setApprovalStatus(2);
            advisorApprovalStatus.setApprovalDesc("认证通过");
        }else if(StringUtils.equals(ApprovalStatusEnum.APPROVAL_NOT_PASSED.getValue(),approvalStatus)){
            //认证不通过
            advisorApprovalStatus.setApprovalStatus(3);
            advisorApprovalStatus.setApprovalDesc("认证不通过");
        }
        return advisorApprovalStatus;
    }

    /**
     * 基本信息保存并更新
     * @param advisorBaseInfoParam  专员资料基本信息
     */
    @ServiceLog(doAction = "基本信息保存并更新")
    @Override
    public int saveOrUpdateAdvisorBaseInfo(AdvisorBaseInfoParam advisorBaseInfoParam) {
        //校验操作是否允许
        checkOptionIsAllow(advisorBaseInfoParam.getAdvisorAccount(),false);
        //校验业务领域
        checkBusinessArea(advisorBaseInfoParam.getBusinessAreas());
        //校验机构id并获取机构信息
        TbServiceOrg tbServiceOrg = checkOrgIdAdnGetOrgInfo(advisorBaseInfoParam.getOrgId());

        //根据账号查询是否存在专员信息
        TbServiceAdvisorCriteria example=new TbServiceAdvisorCriteria();
        example.createCriteria().andAdvisorAccountEqualTo(advisorBaseInfoParam.getAdvisorAccount())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        //根据账号获取数据库现有专员信息
        List<TbServiceAdvisor> tbServiceAdvisorList = tbServiceAdvisorMapper.selectByExample(example);
        if(tbServiceAdvisorList.isEmpty()){
            //通过账号获取到用户头像
            Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(advisorBaseInfoParam.getAdvisorAccount());
            if(userExtension==null || userExtension.getData()==null){
                logger.warn("机构专员认证基本信息保存并更新失败，失败原因，获取用户扩展信息失败");
                throw new JnSpringCloudException(ApprovalStatusEnum.NETWORK_ANOMALY);
            }
            return insertServiceAdvisorInfo(advisorBaseInfoParam,tbServiceOrg.getOrgName(),userExtension.getData().getAvatar());
        }else{
            TbServiceAdvisor tbServiceAdvisor = tbServiceAdvisorList.get(0);
            //把id备份,防止copy时被覆盖
            advisorBaseInfoParam.setId(tbServiceAdvisor.getId());
            //页面传递基本信息覆盖之前基本信息，非基本信息保持不变
            BeanUtils.copyProperties(advisorBaseInfoParam, tbServiceAdvisor);
            //工作年限
            tbServiceAdvisor.setWorkingYears(Float.parseFloat(advisorBaseInfoParam.getWorkingYears()));
            //机构名称
            tbServiceAdvisor.setOrgName(tbServiceOrg.getOrgName());
            //业务领域
            tbServiceAdvisor.setBusinessArea(StringUtils.join(advisorBaseInfoParam.getBusinessAreas(), ","));
            //修改人
            tbServiceAdvisor.setModifierAccount(advisorBaseInfoParam.getAdvisorAccount());
            //修改时间
            tbServiceAdvisor.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            //更新全部的字段（基本信息有的字段可能为空，不能使用selective更新方式）
            return tbServiceAdvisorMapper.updateByExample(tbServiceAdvisor, example);
        }
    }

    /**
     * 校验orgId并获取机构信息
     * @param orgId
     */
    @ServiceLog(doAction = "校验orgId并获取机构信息")
    private TbServiceOrg checkOrgIdAdnGetOrgInfo(String orgId) {
        TbServiceOrgCriteria example=new TbServiceOrgCriteria();
        example.createCriteria().andOrgIdEqualTo(orgId).andOrgStatusEqualTo("1")
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbServiceOrg> tbServiceOrgList = tbServiceOrgMapper.selectByExample(example);
        if(tbServiceOrgList.isEmpty()){
            logger.warn("基本信息保存并更新的机构id:[{}]在系统中不存在",orgId);
            throw new JnSpringCloudException(AdvisorExceptionEnum.ORG_ID_NOT_EXIT);
        }
        return tbServiceOrgList.get(0);
    }

    /**
     * 校验业务领域
     * @param businessAreaArray
     */
    @ServiceLog(doAction = "校验业务领域")
    private void checkBusinessArea(String[] businessAreaArray) {
        if(businessAreaArray.length<1){
            logger.warn("业务领域不能传空");
            throw new JnSpringCloudException(AdvisorExceptionEnum.BUSINESS_AREA_NOT_EXIT);
        }
        //获取系统所有业务领域
        IndustryDictParameter industryDictParameter=new IndustryDictParameter();
        //领域类型[0业务领域1行业领域2发展阶段3企业性质]
        industryDictParameter.setPreType("0");
        List<IndustryDictionary> industryDictionaryList = industryService.getIndustryDictionary(industryDictParameter);
        List<String> businessAreaList=new ArrayList<>();
        for(IndustryDictionary industryDictionary:industryDictionaryList){
            businessAreaList.add(industryDictionary.getId());
        }
        for(int i=0;i<businessAreaArray.length;i++) {
            if (!businessAreaList.contains(businessAreaArray[i])) {
                logger.warn("基本信息保存并更新的业务领域：[{}]在系统中不存在",businessAreaArray[i]);
                throw new JnSpringCloudException(AdvisorExceptionEnum.BUSINESS_AREA_NOT_EXIT);
            }
        }
    }

    /**
     * 新增专员信息
     * @param advisorBaseInfoParam
     */
    @ServiceLog(doAction = "新增专员信息")
    private int insertServiceAdvisorInfo(AdvisorBaseInfoParam advisorBaseInfoParam,String orgName,String avatar) {
        if(StringUtils.isBlank(advisorBaseInfoParam.getOrgId()) || StringUtils.isBlank(orgName)){
            logger.warn("基本信息保存并更新，机构id或机构名称不能为空");
            throw new JnSpringCloudException(AdvisorExceptionEnum.ORG_INFO_NOT_NULL);
        }
        //没有专员信息，添加专员
        TbServiceAdvisor tbServiceAdvisor=new TbServiceAdvisor();
        BeanUtils.copyProperties(advisorBaseInfoParam,tbServiceAdvisor);
        //主键id
        tbServiceAdvisor.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        //机构id、机构名称
        tbServiceAdvisor.setOrgId(advisorBaseInfoParam.getOrgId());
        tbServiceAdvisor.setOrgName(orgName);
        //工作年限
        tbServiceAdvisor.setWorkingYears(Float.parseFloat(advisorBaseInfoParam.getWorkingYears()));
        //浏览量
        tbServiceAdvisor.setPageViews(0);
        //业务领域
        tbServiceAdvisor.setBusinessArea(StringUtils.join(advisorBaseInfoParam.getBusinessAreas(), ","));
        //根据专员账号获取专员信息
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(advisorBaseInfoParam.getAdvisorAccount());
        if(userExtension==null ||userExtension.getData()==null){
            logger.warn("基本信息保存并更新专员：[{}]的信息失败", advisorBaseInfoParam.getAdvisorAccount());
            throw new JnSpringCloudException(AdvisorExceptionEnum.GET_ADVISOR_INFO_FAIL);
        }
        //专员账号
        tbServiceAdvisor.setAdvisorAccount(userExtension.getData().getAccount());
        //专员姓名
        tbServiceAdvisor.setAdvisorName(userExtension.getData().getName());
        //头像
        tbServiceAdvisor.setAvatar(userExtension.getData().getAvatar());
        //是否认证 0：未认证     1：已认证
        tbServiceAdvisor.setIsCertification("0");
        //审核状态  - 1：已拒绝    0：未反馈   1：待审批   2：审批通过  3：审批不通过  4：已解除
        tbServiceAdvisor.setApprovalStatus(ApprovalStatusEnum.NOT_APPROVED.getValue());
        //创建时间
        tbServiceAdvisor.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        //创建人
        tbServiceAdvisor.setCreatorAccount(advisorBaseInfoParam.getAdvisorAccount());
        //记录状态 0标记删除，1正常
        tbServiceAdvisor.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
        //设置头像
        tbServiceAdvisor.setAvatar(avatar);
        return tbServiceAdvisorMapper.insertSelective(tbServiceAdvisor);
    }

    /**
     * 荣誉资质保存并更新
     * @param serviceHonorParam  荣誉资质信息
     */
    @ServiceLog(doAction = "荣誉资质保存并更新")
    @Override
    public int saveOrUpdateAdvisorHonor(ServiceHonorParam serviceHonorParam) {
        //校验操作是否允许
        checkOptionIsAllow(serviceHonorParam.getAdvisorAccount(),true);
        //判断证书类型是否在系统中
        boolean isExist=false;
        //证件类型分类 荣誉资质：honor
        String certificateType="honor";
        List<AdvisorCertificateTypeShow> certificateTypeList = getCertificateTypeList(certificateType);
        for(AdvisorCertificateTypeShow advisorCertificateTypeShow:certificateTypeList){
            if(serviceHonorParam.getCertificateCode().equalsIgnoreCase(advisorCertificateTypeShow.getCertificateCode())){
                isExist=true;
                break;
            }
        }
        //证书类型存在
        if(!isExist) {
            //证书类型不存在
            throw new JnSpringCloudException(AdvisorExceptionEnum.CREDENTIALS_TYPE_ENUM_NOT_EXIST);
        }
        //有主键id,根据主键id和账号更新荣誉资质信息
        if(StringUtils.isNotBlank(serviceHonorParam.getId())&& !PARAM_EXAMPLE.equals(serviceHonorParam.getId())){
            TbServiceHonorCriteria example=new TbServiceHonorCriteria();
            example.createCriteria().andIdEqualTo(serviceHonorParam.getId())
                    .andAdvisorAccountEqualTo(serviceHonorParam.getAdvisorAccount())
                    .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
            List<TbServiceHonor> tbServiceHonorList = tbServiceHonorMapper.selectByExample(example);
             if(tbServiceHonorList.isEmpty()){
                logger.warn("当前荣誉资质信息[id:{},account:{}]在系统中已失效或已删除",serviceHonorParam.getId(),serviceHonorParam.getAdvisorAccount());
                throw new JnSpringCloudException(AdvisorExceptionEnum.HONOR_INFO_NOT_EXIST);
            }
            TbServiceHonor tbServiceHonor=tbServiceHonorList.get(0);
            BeanUtils.copyProperties(serviceHonorParam, tbServiceHonor);
            //证书类型
            tbServiceHonor.setCertificateType(serviceHonorParam.getCertificateCode());
            //修改时间
            tbServiceHonor.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            //修改人
            tbServiceHonor.setModifierAccount(serviceHonorParam.getAdvisorAccount());
            return tbServiceHonorMapper.updateByExample(tbServiceHonor, example);
        }else{
            //没有主键id，新增
            TbServiceHonor tbServiceHonor=new TbServiceHonor();
            BeanUtils.copyProperties(serviceHonorParam, tbServiceHonor);
            //证书类型
            tbServiceHonor.setCertificateType(serviceHonorParam.getCertificateCode());
            //主键id
            tbServiceHonor.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            //创建时间
            tbServiceHonor.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            //创建人
            tbServiceHonor.setCreatorAccount(serviceHonorParam.getAdvisorAccount());
            //数据状态
            tbServiceHonor.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
            return tbServiceHonorMapper.insertSelective(tbServiceHonor);
        }
    }

    /**
     * 获取指定证件类型
     * @param certificateType 证件类型分类
     * @return
     */
    @ServiceLog(doAction = "获取指定证件类型")
    @Override
    public List<AdvisorCertificateTypeShow> getCertificateTypeList(String certificateType) {
        TbServiceCertificateTypeCriteria example=new TbServiceCertificateTypeCriteria();
        if(StringUtils.isBlank(certificateType)){
            example.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        }else{
            example.createCriteria().andCertificateTypeEqualTo(certificateType).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        }
        List<TbServiceCertificateType> tbServiceCertificateTypeList = tbServiceCertificateTypeMapper.selectByExample(example);
        if(tbServiceCertificateTypeList.isEmpty()){
            logger.warn("获取指定证件类型失败，系统中没有证书类型");
            throw new JnSpringCloudException(AdvisorExceptionEnum.CERTIFICATE_TYPE_NOT_EXIST);
        }
        List<AdvisorCertificateTypeShow> resultList=new ArrayList<>(16);
        for(TbServiceCertificateType tbServiceCertificateType:tbServiceCertificateTypeList){
            AdvisorCertificateTypeShow advisorCertificateTypeShow=new AdvisorCertificateTypeShow();
            advisorCertificateTypeShow.setCertificateCode(tbServiceCertificateType.getCertificateCode());
            advisorCertificateTypeShow.setCertificateName(tbServiceCertificateType.getCertificateName());
            resultList.add(advisorCertificateTypeShow);
        }
        return resultList;
    }

    /**
     * 判断当前登录用户是否为专员
     * @param loginAccount  用户账号
     */
    @ServiceLog(doAction = "判断当前登录用户是否为专员")
    @Override
    public void currentUserIsAdvisor(String loginAccount) {
        TbServiceAdvisorCriteria example=new TbServiceAdvisorCriteria();
        example.createCriteria().andAdvisorAccountEqualTo(loginAccount)
                .andApprovalStatusEqualTo(ApprovalStatusEnum.APPROVED.getValue())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        long existNum = tbServiceAdvisorMapper.countByExample(example);
        if(existNum>0){
            logger.warn("当前用户[{}]已经是审批通过的机构专员，不允许编辑专员信息",loginAccount);
            throw new JnSpringCloudException(AdvisorExceptionEnum.ADVISOR_HAS_EXIST);
        }
    }

    /**
     * 发送申请/提交审批
     * @param loginAccount
     * @return
     */
    @Override
    public int sendApproval(String loginAccount) {
        checkOptionIsAllow(loginAccount,true);
        TbServiceAdvisorCriteria example=new TbServiceAdvisorCriteria();
        example.createCriteria().andAdvisorAccountEqualTo(loginAccount);
        TbServiceAdvisor tbServiceAdvisor=new TbServiceAdvisor();
        tbServiceAdvisor.setApprovalStatus(ApprovalStatusEnum.APPROVAL.getValue());
        tbServiceAdvisor.setModifierAccount(loginAccount);
        tbServiceAdvisor.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        return tbServiceAdvisorMapper.updateByExampleSelective(tbServiceAdvisor, example);
    }

    /**
     * 校验当前操作是否允许
     * @param loginAccount
     * @param emptyAllow 是否允许基本信息为空（基本信息保存时值为false,其他为true）
     */
    @ServiceLog(doAction = "校验当前操作是否允许")
    private void checkOptionIsAllow(String loginAccount,boolean emptyAllow) {
        TbServiceAdvisorCriteria example=new TbServiceAdvisorCriteria();
        example.createCriteria().andAdvisorAccountEqualTo(loginAccount)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbServiceAdvisor> advisorList = tbServiceAdvisorMapper.selectByExample(example);
        if(advisorList.isEmpty()){
            if(emptyAllow){
                logger.warn("当前用户基本信息在系统中不存在，请添加专员基本信息");
                throw new JnSpringCloudException(AdvisorExceptionEnum.ADVISOR_BASE_INFO_NOT_EXIST);
            }
        }else if(StringUtils.equals(advisorList.get(0).getApprovalStatus(), ApprovalStatusEnum.APPROVED.getValue())
                || StringUtils.equals(advisorList.get(0).getApprovalStatus(), ApprovalStatusEnum.APPROVAL.getValue())){
            logger.warn("机构专员认证发送申请异常，当前专员审批状态为认证中或认证通过,不允许编辑");
            throw new JnSpringCloudException(AdvisorExceptionEnum.ADVISOR_HAS_EXIST);
        }
    }

    /**
     * 服务经历保存并更新
     * @param serviceExperienceParam 服务经历信息
     */
    @ServiceLog(doAction = "服务经历保存并更新")
    @Override
    public int saveOrUpdateAdvisorExperience(ServiceExperienceParam serviceExperienceParam) {
        //校验操作是否允许
        checkOptionIsAllow(serviceExperienceParam.getAdvisorAccount(),true);
        //有主键id,更据主键id和账号更新服务经历
        if(StringUtils.isNotBlank(serviceExperienceParam.getId()) && !PARAM_EXAMPLE.equals(serviceExperienceParam.getId())){
            byte recordStatus=1;
            TbServiceExperienceCriteria example=new TbServiceExperienceCriteria();
            example.createCriteria().andIdEqualTo(serviceExperienceParam.getId())
                    .andAdvisorAccountEqualTo(serviceExperienceParam.getAdvisorAccount())
                    .andRecordStatusEqualTo(recordStatus);
                List<TbServiceExperience> tbServiceExperienceList = tbServiceExperienceMapper.selectByExample(example);
            if(tbServiceExperienceList.isEmpty()){
                logger.warn("当前服务经历信息[id:{},account:{}]在系统中已失效或已删除",serviceExperienceParam.getId(),serviceExperienceParam.getAdvisorAccount());
                throw new JnSpringCloudException(AdvisorExceptionEnum.EXPERIENCE_INFO_NOT_EXIST);
            }
            TbServiceExperience tbServiceExperience = tbServiceExperienceList.get(0);
            BeanUtils.copyProperties(serviceExperienceParam, tbServiceExperience);
            //修改时间
            tbServiceExperience.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            //修改人
            tbServiceExperience.setModifierAccount(serviceExperienceParam.getAdvisorAccount());
            return tbServiceExperienceMapper.updateByExample(tbServiceExperience, example);
        }else{
            //没有主键id,新增
            TbServiceExperience tbServiceExperience=new TbServiceExperience();
            BeanUtils.copyProperties(serviceExperienceParam, tbServiceExperience);
            //主键id
            tbServiceExperience.setId(UUID.randomUUID().toString());
            //创建时间
            tbServiceExperience.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            //创建人
            tbServiceExperience.setCreatorAccount(serviceExperienceParam.getAdvisorAccount());
            //数据状态
            tbServiceExperience.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
            return tbServiceExperienceMapper.insertSelective(tbServiceExperience);
        }
    }

    /**
     * 项目经验保存并更新
     * @param serviceProjectExperienceParam  项目经验信息
     */
    @ServiceLog(doAction = "项目经验保存并更新")
    @Override
    public int saveOrUpdateAdvisorProjectExperience(ServiceProjectExperienceParam serviceProjectExperienceParam) {
        //校验操作是否允许
        checkOptionIsAllow(serviceProjectExperienceParam.getAdvisorAccount(),true);
        //有主键id,更据主键id和账号更新服务经历
        if(StringUtils.isNotBlank(serviceProjectExperienceParam.getId())&& !PARAM_EXAMPLE.equals(serviceProjectExperienceParam.getId())){
            TbServiceProExperCriteria example=new TbServiceProExperCriteria();
            example.createCriteria().andIdEqualTo(serviceProjectExperienceParam.getId())
                    .andAdvisorAccountEqualTo(serviceProjectExperienceParam.getAdvisorAccount())
                    .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
            List<TbServiceProExper> tbServiceProExperList = tbServiceProExperMapper.selectByExample(example);
            if(tbServiceProExperList.isEmpty()){
                logger.warn("当前项目经验信息[id:{},account:{}]在系统中已失效或已删除",serviceProjectExperienceParam.getId(),serviceProjectExperienceParam.getAdvisorAccount());
                throw new JnSpringCloudException(AdvisorExceptionEnum.PROJECT_EXPERIENCE_INFO_NOT_EXIST);
            }
            TbServiceProExper tbServiceProExper = tbServiceProExperList.get(0);
            BeanUtils.copyProperties(serviceProjectExperienceParam, tbServiceProExper);
            //修改时间
            tbServiceProExper.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            //修改人
            tbServiceProExper.setModifierAccount(tbServiceProExper.getAdvisorAccount());
            //数据状态
            tbServiceProExper.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
            return tbServiceProExperMapper.updateByExample(tbServiceProExper, example);
        }else{
            //没有主键id,新增
            TbServiceProExper tbServiceProExper=new TbServiceProExper();
            BeanUtils.copyProperties(serviceProjectExperienceParam, tbServiceProExper);
            //主键id
            tbServiceProExper.setId(UUID.randomUUID().toString());
            //创建人
            tbServiceProExper.setCreatorAccount(serviceProjectExperienceParam.getAdvisorAccount());
            //创建时间
            tbServiceProExper.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            //数据状态
            tbServiceProExper.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
            return tbServiceProExperMapper.insertSelective(tbServiceProExper);
        }
    }
}
