package com.jn.enterprise.servicemarket.advisor.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.servicemarket.advisor.dao.*;
import com.jn.enterprise.servicemarket.advisor.entity.*;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorBaseInfo;
import com.jn.enterprise.servicemarket.advisor.model.ServiceExperienceParam;
import com.jn.enterprise.servicemarket.advisor.model.ServiceHonorParam;
import com.jn.enterprise.servicemarket.advisor.model.ServiceProjectExperienceParam;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorEditService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 编辑顾问资料
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

    private static final String PATTERN="yyyy-MM-dd HH:mm:ss";

    /**
     * 基本信息保存并更新
     * @param advisorBaseInfo  顾问资料基本信息
     */
    @ServiceLog(doAction = "基本信息保存并更新")
    @Override
    public void saveOrUpdateAdvisorBaseInfo(AdvisorBaseInfo advisorBaseInfo) {
        //根据账号查询是否存在顾问信息
        //数据状态  0：删除  1：正常
        byte recordStatus=1;
        TbServiceAdvisorCriteria example=new TbServiceAdvisorCriteria();
        example.createCriteria().andAdvisorAccountEqualTo(advisorBaseInfo.getAdvisorAccount()).andRecordStatusEqualTo(recordStatus);
        //根据账号获取数据库现有顾问信息
        List<TbServiceAdvisor> tbServiceAdvisorList = tbServiceAdvisorMapper.selectByExample(example);
        if(tbServiceAdvisorList.isEmpty()){
            insertServiceAdvisorInfo(advisorBaseInfo);
        }else{
            TbServiceAdvisor tbServiceAdvisor = tbServiceAdvisorList.get(0);
            //把id,orgId,orgName,businessArea保留,防止copy时被覆盖
            advisorBaseInfo.setId(tbServiceAdvisor.getId());
            advisorBaseInfo.setOrgId(tbServiceAdvisor.getOrgId());
            advisorBaseInfo.setOrgName(tbServiceAdvisor.getOrgName());
            advisorBaseInfo.setBusinessArea(tbServiceAdvisor.getBusinessArea());
            //页面传递基本信息覆盖之前基本信息，非基本信息保持不变
            BeanUtils.copyProperties(advisorBaseInfo, tbServiceAdvisor);
            //修改人
            tbServiceAdvisor.setModifierAccount(advisorBaseInfo.getAdvisorAccount());
            //修改时间
            tbServiceAdvisor.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            //更新全部的字段（基本信息有的字段可能为空，不能使用selective更新方式）
            tbServiceAdvisorMapper.updateByExample(tbServiceAdvisor, example);
        }
    }

    /**
     * 新增顾问信息
     * @param advisorBaseInfo
     */
    @ServiceLog(doAction = "新增顾问信息")
    private void insertServiceAdvisorInfo(AdvisorBaseInfo advisorBaseInfo) {
        if(StringUtils.isBlank(advisorBaseInfo.getOrgId()) || StringUtils.isBlank(advisorBaseInfo.getOrgName())){
            logger.warn("基本信息保存并更新，机构id或机构名称不能为空");
            throw new JnSpringCloudException(AdvisorExceptionEnum.ORG_INFO_NOT_NULL);
        }
        //没有顾问信息，添加顾问
        TbServiceAdvisor tbServiceAdvisor=new TbServiceAdvisor();
        BeanUtils.copyProperties(advisorBaseInfo,tbServiceAdvisor);
        //主键id
        tbServiceAdvisor.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        //机构id、机构名称
        tbServiceAdvisor.setOrgId(advisorBaseInfo.getOrgId());
        tbServiceAdvisor.setOrgName(advisorBaseInfo.getOrgName());
        //根据顾问账号获取顾问信息
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(advisorBaseInfo.getAdvisorAccount());
        if(userExtension==null ||userExtension.getData()==null){
            logger.warn("基本信息保存并更新顾问：[{}]的信息失败",advisorBaseInfo.getAdvisorAccount());
            throw new JnSpringCloudException(AdvisorExceptionEnum.GET_ADVISOR_INFO_FAIL);
        }
        //顾问账号
        tbServiceAdvisor.setAdvisorAccount(userExtension.getData().getAccount());
        //顾问姓名
        tbServiceAdvisor.setAdvisorName(userExtension.getData().getName());
        //头像
        tbServiceAdvisor.setAvatar(userExtension.getData().getAvatar());
        //是否认证 0：未认证     1：已认证
        tbServiceAdvisor.setIsCertification("0");
        //审核状态  - 1：已拒绝    0：未反馈   1：待审批   2：审批通过  3：审批不通过  4：已解除
        tbServiceAdvisor.setApprovalStatus("0");
        //创建时间
        tbServiceAdvisor.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        //创建人
        tbServiceAdvisor.setCreatorAccount(advisorBaseInfo.getAdvisorAccount());
        //记录状态 0标记删除，1正常
        tbServiceAdvisor.setRecordStatus((byte)1);
        tbServiceAdvisorMapper.insertSelective(tbServiceAdvisor);
    }

    /**
     * 荣誉资质保存并更新
     * @param serviceHonorParam  荣誉资质信息
     */
    @ServiceLog(doAction = "荣誉资质保存并更新")
    @Override
    public void saveOrUpdateAdvisorHonor(ServiceHonorParam serviceHonorParam) {
        //判断证书类型是否在系统中
        boolean isExist=false;
        //证件类型分类 荣誉资质：honor
        String certificateType="honor";
        List<TbServiceCertificateType> certificateTypeList = getCertificateTypeList(certificateType);
        for(TbServiceCertificateType tbServiceCertificateType:certificateTypeList){
            if(serviceHonorParam.getCertificateType().equalsIgnoreCase(tbServiceCertificateType.getCertificateCode())){
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
        if(StringUtils.isNotBlank(serviceHonorParam.getId())){
            byte recordStatus=1;
            TbServiceHonorCriteria example=new TbServiceHonorCriteria();
            example.createCriteria().andIdEqualTo(serviceHonorParam.getId())
                    .andAdvisorAccountEqualTo(serviceHonorParam.getAdvisorAccount())
                    .andRecordStatusEqualTo(recordStatus);
            List<TbServiceHonor> tbServiceHonorList = tbServiceHonorMapper.selectByExample(example);
             if(tbServiceHonorList.isEmpty()){
                logger.warn("当前荣誉资质信息[id:{},account:{}]在系统中已失效或已删除",serviceHonorParam.getId(),serviceHonorParam.getAdvisorAccount());
                throw new JnSpringCloudException(AdvisorExceptionEnum.HONOR_INFO_NOT_EXIST);
            }
            TbServiceHonor tbServiceHonor=tbServiceHonorList.get(0);
            BeanUtils.copyProperties(serviceHonorParam, tbServiceHonor);
            //修改时间
            tbServiceHonor.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            //修改人
            tbServiceHonor.setModifierAccount(serviceHonorParam.getAdvisorAccount());
            tbServiceHonorMapper.updateByExample(tbServiceHonor, example);
        }else{
            //没有主键id，新增
            TbServiceHonor tbServiceHonor=new TbServiceHonor();
            BeanUtils.copyProperties(serviceHonorParam, tbServiceHonor);
            //主键id
            tbServiceHonor.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            //创建时间
            tbServiceHonor.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            //创建人
            tbServiceHonor.setCreatorAccount(serviceHonorParam.getAdvisorAccount());
            //数据状态
            byte recordStatus=1;
            tbServiceHonor.setRecordStatus(recordStatus);
            tbServiceHonorMapper.insertSelective(tbServiceHonor);
        }
    }

    /**
     * 获取指定证件类型
     * @param certificateType 证件类型分类
     * @return
     */
    @ServiceLog(doAction = "获取指定证件类型")
    @Override
    public List<TbServiceCertificateType> getCertificateTypeList(String certificateType) {
        byte recordStatus=1;
        TbServiceCertificateTypeCriteria example=new TbServiceCertificateTypeCriteria();
        if(StringUtils.isBlank(certificateType)){
            example.createCriteria().andRecordStatusEqualTo(recordStatus);
        }else{
            example.createCriteria().andCertificateTypeEqualTo(certificateType).andRecordStatusEqualTo(recordStatus);
        }
        return tbServiceCertificateTypeMapper.selectByExample(example);
    }

    /**
     * 服务经历保存并更新
     * @param serviceExperienceParam 服务经历信息
     */
    @ServiceLog(doAction = "服务经历保存并更新")
    @Override
    public void saveOrUpdateAdvisorExperience(ServiceExperienceParam serviceExperienceParam) {
        //有主键id,更据主键id和账号更新服务经历
        if(StringUtils.isNotBlank(serviceExperienceParam.getId())){
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
            tbServiceExperienceMapper.updateByExample(tbServiceExperience, example);
        }else{
            //没有主键id,新增
            TbServiceExperience tbServiceExperience=new TbServiceExperience();
            BeanUtils.copyProperties(serviceExperienceParam, tbServiceExperience);
            //主键id
            tbServiceExperience.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            //创建时间
            tbServiceExperience.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            //创建人
            tbServiceExperience.setCreatorAccount(serviceExperienceParam.getAdvisorAccount());
            //数据状态
            byte recordStatus=1;
            tbServiceExperience.setRecordStatus(recordStatus);
            tbServiceExperienceMapper.insertSelective(tbServiceExperience);
        }
    }

    /**
     * 项目经验保存并更新
     * @param serviceProjectExperienceParam  项目经验信息
     */
    @ServiceLog(doAction = "项目经验保存并更新")
    @Override
    public void saveOrUpdateAdvisorProjectExperience(ServiceProjectExperienceParam serviceProjectExperienceParam) {
        //有主键id,更据主键id和账号更新服务经历
        if(StringUtils.isNotBlank(serviceProjectExperienceParam.getId())){
            byte recordStatus=1;
            TbServiceProExperCriteria example=new TbServiceProExperCriteria();
            example.createCriteria().andIdEqualTo(serviceProjectExperienceParam.getId())
                    .andAdvisorAccountEqualTo(serviceProjectExperienceParam.getAdvisorAccount())
                    .andRecordStatusEqualTo(recordStatus);
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
            tbServiceProExper.setRecordStatus(recordStatus);
            tbServiceProExperMapper.updateByExample(tbServiceProExper, example);
        }else{
            //没有主键id,新增
            TbServiceProExper tbServiceProExper=new TbServiceProExper();
            BeanUtils.copyProperties(serviceProjectExperienceParam, tbServiceProExper);
            //主键id
            tbServiceProExper.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            //创建时间
            tbServiceProExper.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            //创建人
            tbServiceProExper.setCreatorAccount(serviceProjectExperienceParam.getAdvisorAccount());
            //数据状态
            byte recordStatus=1;
            tbServiceProExper.setRecordStatus(recordStatus);
            tbServiceProExperMapper.insertSelective(tbServiceProExper);
        }
    }
}
