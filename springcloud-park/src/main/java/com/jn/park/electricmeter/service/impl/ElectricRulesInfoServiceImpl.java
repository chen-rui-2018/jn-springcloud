package com.jn.park.electricmeter.service.impl;

import com.google.common.collect.Lists;
import com.jn.common.channel.MessageSource;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.news.vo.AppSinkVo;
import com.jn.news.vo.EmailVo;
import com.jn.news.vo.SmsTemplateVo;
import com.jn.park.electricmeter.dao.TbElectricEnergyControlPushLogMapper;
import com.jn.park.electricmeter.dao.TbElectricMeterInfoMapper;
import com.jn.park.electricmeter.dao.VElectricRulesInfoMapper;
import com.jn.park.electricmeter.entity.TbElectricEnergyControlPushLog;
import com.jn.park.electricmeter.entity.TbElectricMeterInfo;
import com.jn.park.electricmeter.entity.VElectricRulesInfo;
import com.jn.park.electricmeter.entity.VElectricRulesInfoCriteria;
import com.jn.park.electricmeter.service.ElectricRulesInfoService;
import com.jn.park.electricmeter.service.MeterService;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <pre>
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/6/4
 * </pre>
 */
@Service
@EnableBinding(value = MessageSource.class)
public class ElectricRulesInfoServiceImpl implements ElectricRulesInfoService {
    private static Logger logger = LoggerFactory.getLogger(ElectricRulesInfoServiceImpl.class);
    @Autowired
    private VElectricRulesInfoMapper vElectricRulesInfoMapper;
    @Autowired
    private TbElectricMeterInfoMapper tbElectricMeterInfoMapper;
    @Autowired
    private TbElectricEnergyControlPushLogMapper tbElectricEnergyControlPushLogMapper;

    @Autowired
    private MeterService meterService;
    @Autowired(required = false)
    private MessageSource messageSource;
    @Autowired
    private SystemClient systemClient;

    @ServiceLog(doAction = "电量规则监控程序")
    @Override
    public void monitor() {
        VElectricRulesInfoCriteria criteria=new VElectricRulesInfoCriteria();
        List<VElectricRulesInfo>list=vElectricRulesInfoMapper.selectByExample(criteria);
        if(list==null||list.size()<1)return;
        list.stream().forEach(e->{
            this.runRule(e);
        });
    }

    /**
     * 执行告警规则
     * @param vElectricRulesInfo
     */
    @ServiceLog(doAction = "执行告警规则")
    private void runRule(VElectricRulesInfo vElectricRulesInfo){
        if(StringUtils.isBlank(vElectricRulesInfo.getTypeCode()))return;
        if(StringUtils.isBlank(vElectricRulesInfo.getVal()))return;
        String typeCodeArr[] =vElectricRulesInfo.getTypeCode().split(",");
        String valArr[]=vElectricRulesInfo.getVal().split(",");
        if(typeCodeArr.length!=valArr.length)return;
        double threshold=Double.parseDouble(vElectricRulesInfo.getThreshold());//阀值

        StringBuffer typeCode=new StringBuffer();//需要告警的设备编码
        StringBuffer actualVal=new StringBuffer();//需要告警的设备真实数值
        for(int i=0;i<typeCodeArr.length;i++){
            double val=Double.parseDouble(valArr[i]);//实际值
            boolean monitorFlag=false;//是否要告警
            switch (vElectricRulesInfo.getOperation()){
                case ">":
                    monitorFlag=val>threshold;
                    break;
                case ">=":
                    monitorFlag=val>=threshold;
                    break;
                case "<":
                    monitorFlag=val<threshold;
                    break;
                case "<=":
                    monitorFlag=val<=threshold;
                    break;
                    default:
                        logger.info("操作符[{}]不合法",vElectricRulesInfo.getOperation());


            }
            if(monitorFlag){
                typeCode.append(",").append(typeCodeArr[i]);
                actualVal.append(",").append(valArr[i]);
            }
        }

        String monitorContent=this.monitorContent(typeCode.toString().replaceFirst(",",""),actualVal.toString().replaceFirst(",",""),vElectricRulesInfo);
        //发送告警
        this.sendMonitor(vElectricRulesInfo.getMonitorUserIds(),monitorContent);

    }

    /**
     * 发送告警内容
     * @param userIds
     * @param monitorContent
     */
    @ServiceLog(doAction = "发送告警内容")
    private void sendMonitor(String userIds,String monitorContent){
        List<String>ids=Lists.newArrayList(userIds.split(","));
        List<String> newId = new ArrayList<>();
        if(ids !=null && ids.size()>0){
            for(String id : ids){
                newId.add(id.replace("user",""));
            }
        }
        Result<List<User>> userResult= systemClient.getUserInfoByIds(newId);
        if(!StringUtils.equals(userResult.getCode(),"0000")){
            logger.info("未配置监控人员,userIds={}",userIds);
            return;
        }
        for(User u:userResult.getData()){
            SmsTemplateVo smsTemplateVo = new SmsTemplateVo();
            smsTemplateVo.setTemplateId("999");
            smsTemplateVo.setTemplateId(monitorContent);
            smsTemplateVo.setMobiles(new String[]{u.getPhone()});
            logger.info("短信推送{}",smsTemplateVo);
            messageSource.outputSms().send(MessageBuilder.withPayload(smsTemplateVo).build());
            TbElectricEnergyControlPushLog logSms=new TbElectricEnergyControlPushLog();
            logSms.setId(UUID.randomUUID().toString());
            logSms.setPushType(new Byte("1"));
            logSms.setPushContent(monitorContent);
            logSms.setAccountId(u.getId());
            logSms.setLinkAccount(u.getAccount());
            logSms.setRecordStatus(new Byte("1"));
            logSms.setCreatedTime(new Date());
            logSms.setAcceptPhone(u.getPhone());
            tbElectricEnergyControlPushLogMapper.insertSelective(logSms);


            AppSinkVo appSinkVo=new AppSinkVo();
            appSinkVo.setTitle("能耗监控告警提醒");
            appSinkVo.setContent(monitorContent);
            appSinkVo.setIds(Lists.newArrayList(u.getId()));
            appSinkVo.setPushType("DEVICE");
            appSinkVo.setNoticeType("NOTICE");
            logger.info("APP推送{}",appSinkVo);
            messageSource.outputApp().send(MessageBuilder.withPayload(appSinkVo).build());
            TbElectricEnergyControlPushLog logApp=new TbElectricEnergyControlPushLog();
            logApp.setId(UUID.randomUUID().toString());
            logApp.setPushType(new Byte("1"));
            logApp.setPushContent(monitorContent);
            logApp.setAccountId(u.getId());
            logApp.setLinkAccount(u.getAccount());
            logApp.setRecordStatus(new Byte("1"));
            logApp.setCreatedTime(new Date());
            tbElectricEnergyControlPushLogMapper.insertSelective(logApp);

            EmailVo emailVo=new EmailVo();
            emailVo.setEmailContent(monitorContent);
            emailVo.setEmailSubject("能耗监控告警提醒"+ DateUtils.getDate());
            emailVo.setEmail(u.getEmail());
            logger.info("邮件推送{}",emailVo);
            messageSource.outputEmail().send(MessageBuilder.withPayload(emailVo).build());
            TbElectricEnergyControlPushLog logEmail=new TbElectricEnergyControlPushLog();
            logEmail.setId(UUID.randomUUID().toString());
            logEmail.setPushType(new Byte("1"));
            logEmail.setPushContent(monitorContent);
            logEmail.setAccountId(u.getId());
            logEmail.setLinkAccount(u.getAccount());
            logEmail.setRecordStatus(new Byte("1"));
            logEmail.setCreatedTime(new Date());
            tbElectricEnergyControlPushLogMapper.insertSelective(logEmail);
        }
    }


    /**
     * 生成告警内容
     * @param typeCode
     * @param vElectricRulesInfo
     */
    @ServiceLog(doAction = "生成告警内容")
    private String monitorContent(String typeCode,String actualVal,VElectricRulesInfo vElectricRulesInfo){
        StringBuffer name=new StringBuffer(vElectricRulesInfo.getMonitorObject());//电表名
        if(!StringUtils.equals(vElectricRulesInfo.getMonitorObject(),"整个园区")){
            name.append("[").append(typeCode).append("]");
        }

        String msg=String.format("【白下高新区】系统监控通知：[%s]的电表触发了规则[%s]，实际值[%s],请知悉。",name,vElectricRulesInfo.getRuleShowValue(),actualVal);
        logger.info("告警内容：{}",msg);
        return msg;
    }



}
