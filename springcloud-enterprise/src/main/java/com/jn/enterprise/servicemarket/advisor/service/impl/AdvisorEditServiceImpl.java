package com.jn.enterprise.servicemarket.advisor.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.servicemarket.advisor.dao.*;
import com.jn.enterprise.servicemarket.advisor.entity.*;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorBaseInfo;
import com.jn.enterprise.servicemarket.advisor.model.ServiceExperience;
import com.jn.enterprise.servicemarket.advisor.model.ServiceHonor;
import com.jn.enterprise.servicemarket.advisor.model.ServiceProjectExperience;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorEditService;
import com.jn.system.log.annotation.ServiceLog;
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

    private static final String PATTERN="yyyy-MM-dd HH:mm:ss";

    /**
     * 基本信息保存并更新
     * @param advisorBaseInfo  顾问资料基本信息
     */
    @ServiceLog(doAction = "基本信息保存并更新")
    @Override
    public void saveOrUpdateAdvisorBaseInfo(AdvisorBaseInfo advisorBaseInfo) {
        //数据状态  0：删除  1：正常
        byte recordStatus=1;
        TbServiceAdvisorCriteria example=new TbServiceAdvisorCriteria();
        example.createCriteria().andAdvisorAccountEqualTo(advisorBaseInfo.getAdvisorAccount()).andRecordStatusEqualTo(recordStatus);
        //根据账号获取数据库现有顾问信息
        List<TbServiceAdvisor> tbServiceAdvisorList = tbServiceAdvisorMapper.selectByExample(example);
        if(tbServiceAdvisorList.isEmpty()){
            logger.warn("基本信息保存并更新失败，顾问[{}]信息在系统中不存在",advisorBaseInfo.getAdvisorAccount());
            throw new JnSpringCloudException(AdvisorExceptionEnum.SERVICE_ORG_NOT_EXIST);
        }
        TbServiceAdvisor tbServiceAdvisor = tbServiceAdvisorList.get(0);
        //页面传递基本信息覆盖之前基本信息，非基本信息保持不变
        BeanUtils.copyProperties(advisorBaseInfo, tbServiceAdvisor);
        //修改人
        tbServiceAdvisor.setModifierAccount(advisorBaseInfo.getAdvisorAccount());
        //修改时间
        tbServiceAdvisor.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        //更新全部字段
        tbServiceAdvisorMapper.updateByExample(tbServiceAdvisor, example);

    }

    /**
     * 荣誉资质保存并更新
     * @param serviceHonor  荣誉资质信息
     */
    @ServiceLog(doAction = "荣誉资质保存并更新")
    @Override
    public void saveOrUpdateAdvisorHonor(ServiceHonor serviceHonor) {
        //判断证书类型是否在系统中
        boolean isExist=false;
        //证件类型分类 荣誉资质：honor
        String certificateType="honor";
        List<TbServiceCertificateType> certificateTypeList = getCertificateTypeList(certificateType);
        for(TbServiceCertificateType tbServiceCertificateType:certificateTypeList){
            if(serviceHonor.getCertificateType().equalsIgnoreCase(tbServiceCertificateType.getCertificateCode())){
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
        if(StringUtils.isNotBlank(serviceHonor.getId())){
            byte recordStatus=1;
            TbServiceHonorCriteria example=new TbServiceHonorCriteria();
            example.createCriteria().andIdEqualTo(serviceHonor.getId())
                    .andAdvisorAccountEqualTo(serviceHonor.getAdvisorAccount())
                    .andRecordStatusEqualTo(recordStatus);
            List<TbServiceHonor> tbServiceHonorList = tbServiceHonorMapper.selectByExample(example);
             if(tbServiceHonorList.isEmpty()){
                logger.warn("当前荣誉资质信息[id:{},account:{}]在系统中已失效或已删除",serviceHonor.getId(),serviceHonor.getAdvisorAccount());
                throw new JnSpringCloudException(AdvisorExceptionEnum.HONOR_INFO_NOT_EXIST);
            }
            TbServiceHonor tbServiceHonor=tbServiceHonorList.get(0);
             //把创建时间，创建人，数据状态取出赋值给前端传递对象
            serviceHonor.setCreatedTime(tbServiceHonor.getCreatedTime());
            serviceHonor.setCreatorAccount(tbServiceHonor.getCreatorAccount());
            serviceHonor.setRecordStatus(tbServiceHonor.getRecordStatus());
            BeanUtils.copyProperties(serviceHonor, tbServiceHonor);
            //修改时间
            tbServiceHonor.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            //修改人
            tbServiceHonor.setModifierAccount(serviceHonor.getAdvisorAccount());
            tbServiceHonorMapper.updateByExample(tbServiceHonor, example);
        }else{
            //没有主键id，新增
            TbServiceHonor tbServiceHonor=new TbServiceHonor();
            BeanUtils.copyProperties(serviceHonor, tbServiceHonor);
            //主键id
            tbServiceHonor.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            //创建时间
            tbServiceHonor.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            //创建人
            tbServiceHonor.setCreatorAccount(serviceHonor.getAdvisorAccount());
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
     * @param serviceExperience 服务经历信息
     */
    @ServiceLog(doAction = "服务经历保存并更新")
    @Override
    public void saveOrUpdateAdvisorExperience(ServiceExperience serviceExperience) {
        //有主键id,更据主键id和账号更新服务经历
        if(StringUtils.isNotBlank(serviceExperience.getId())){
            byte recordStatus=1;
            TbServiceExperienceCriteria example=new TbServiceExperienceCriteria();
            example.createCriteria().andIdEqualTo(serviceExperience.getId())
                    .andAdvisorAccountEqualTo(serviceExperience.getAdvisorAccount())
                    .andRecordStatusEqualTo(recordStatus);
                List<TbServiceExperience> tbServiceExperienceList = tbServiceExperienceMapper.selectByExample(example);
            if(tbServiceExperienceList.isEmpty()){
                logger.warn("当前服务经历信息[id:{},account:{}]在系统中已失效或已删除",serviceExperience.getId(),serviceExperience.getAdvisorAccount());
                throw new JnSpringCloudException(AdvisorExceptionEnum.EXPERIENCE_INFO_NOT_EXIST);
            }
            TbServiceExperience tbServiceExperience = tbServiceExperienceList.get(0);
            //把创建时间，创建人，数据状态取出赋值给前端传递对象
            serviceExperience.setCreatedTime(tbServiceExperience.getCreatedTime());
            serviceExperience.setCreatorAccount(tbServiceExperience.getCreatorAccount());
            serviceExperience.setRecordStatus(tbServiceExperience.getRecordStatus());
            BeanUtils.copyProperties(serviceExperience, tbServiceExperience);
            //修改时间
            tbServiceExperience.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            //修改人
            tbServiceExperience.setModifierAccount(serviceExperience.getAdvisorAccount());
            tbServiceExperienceMapper.updateByExample(tbServiceExperience, example);
        }else{
            //没有主键id,新增
            TbServiceExperience tbServiceExperience=new TbServiceExperience();
            BeanUtils.copyProperties(serviceExperience, tbServiceExperience);
            //主键id
            tbServiceExperience.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            //创建时间
            tbServiceExperience.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            //创建人
            tbServiceExperience.setCreatorAccount(serviceExperience.getAdvisorAccount());
            //数据状态
            byte recordStatus=1;
            tbServiceExperience.setRecordStatus(recordStatus);
            tbServiceExperienceMapper.insertSelective(tbServiceExperience);
        }
    }

    /**
     * 项目经验保存并更新
     * @param serviceProjectExperience  项目经验信息
     */
    @ServiceLog(doAction = "项目经验保存并更新")
    @Override
    public void saveOrUpdateAdvisorProjectExperience(ServiceProjectExperience serviceProjectExperience) {
        //有主键id,更据主键id和账号更新服务经历
        if(StringUtils.isNotBlank(serviceProjectExperience.getId())){
            byte recordStatus=1;
            TbServiceProExperCriteria example=new TbServiceProExperCriteria();
            example.createCriteria().andIdEqualTo(serviceProjectExperience.getId())
                    .andAdvisorAccountEqualTo(serviceProjectExperience.getAdvisorAccount())
                    .andRecordStatusEqualTo(recordStatus);
            List<TbServiceProExper> tbServiceProExperList = tbServiceProExperMapper.selectByExample(example);
            if(tbServiceProExperList.isEmpty()){
                logger.warn("当前项目经验信息[id:{},account:{}]在系统中已失效或已删除",serviceProjectExperience.getId(),serviceProjectExperience.getAdvisorAccount());
                throw new JnSpringCloudException(AdvisorExceptionEnum.PROJECT_EXPERIENCE_INFO_NOT_EXIST);
            }
            TbServiceProExper tbServiceProExper = tbServiceProExperList.get(0);
            //把创建时间，创建人，数据状态取出赋值给前端传递对象
            serviceProjectExperience.setCreatedTime(tbServiceProExper.getCreatedTime());
            serviceProjectExperience.setCreatorAccount(tbServiceProExper.getCreatorAccount());
            serviceProjectExperience.setRecordStatus(tbServiceProExper.getRecordStatus());
            BeanUtils.copyProperties(serviceProjectExperience, tbServiceProExper);
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
            BeanUtils.copyProperties(serviceProjectExperience, tbServiceProExper);
            //主键id
            tbServiceProExper.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            //创建时间
            tbServiceProExper.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            //创建人
            tbServiceProExper.setCreatorAccount(serviceProjectExperience.getAdvisorAccount());
            //数据状态
            byte recordStatus=1;
            tbServiceProExper.setRecordStatus(recordStatus);
            tbServiceProExperMapper.insertSelective(tbServiceProExper);
        }
    }
}
