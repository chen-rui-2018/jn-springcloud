package com.jn.news.sms.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.RestTemplateUtil;
import com.jn.common.util.StringUtils;
import com.jn.news.config.NewsSwitchProperties;
import com.jn.news.sms.dao.TbNewsSmsTemplateMapper;
import com.jn.news.sms.entity.TbNewsSmsTemplate;
import com.jn.news.sms.enums.SmsExceptionEnum;
import com.jn.news.sms.enums.SmsStateTypeEnum;
import com.jn.news.sms.model.SmsBaseResult;
import com.jn.news.sms.service.SmsService;
import com.jn.news.sms.vo.SmsAnswersResult;
import com.jn.news.sms.vo.SmsReportsResult;
import com.jn.news.utils.xml.XStreamTransformer;
import com.jn.news.vo.SmsTemplateVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.MissingFormatArgumentException;

/**
 * 短信接口实现类
 *
 * @Author： cm
 * @Date： Created on 2019/2/20 16:50
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class SmsServiceImpl implements SmsService {

    Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);

    /**
     * 表示已经获取过了，为空
     */
    private static final String  RETURN_SMS = "<returnsms/>";

    @Autowired
    private TbNewsSmsTemplateMapper tbNewsSmsTemplateMapper;
    @Autowired
    private NewsSwitchProperties newsSwitchProperties;

    @Override
    public SmsBaseResult sendMsgByTemplate(SmsTemplateVo smsTemplateVo) {
        //判断短信发送状态，如果是关闭状态则发送至配置的测试邮箱地址
        this.smsSwitchJudge(smsTemplateVo);
        TbNewsSmsTemplate tbNewsSmsTemplate = getSmsTemplateById(smsTemplateVo.getTemplateId());
        if(null == tbNewsSmsTemplate) {
            logger.error("根据短信模板ID:【{}】,找不到对应的模板信息.",smsTemplateVo.getTemplateId());
            throw new JnSpringCloudException(SmsExceptionEnum.SMS_NOT_TEMPLATE_ID);
        }
        logger.info("根据短信模板ID:【{}】,查询出的模板信息：【{}】.",smsTemplateVo.getTemplateId(),tbNewsSmsTemplate.toString());
        //获取短信接收号码
        String mobiles = StringUtils.join(smsTemplateVo.getMobiles(),",");
        //获取短信内容
        String templateContent = tbNewsSmsTemplate.getTemplateContent();
        try{
            templateContent = String.format(templateContent,smsTemplateVo.getContents());
        }catch (MissingFormatArgumentException e) {
            logger.error("短信模板缺少格式参数,短信模板内容：{},短信传来的格式参数{}.",templateContent,smsTemplateVo.getContents());
            throw new JnSpringCloudException(SmsExceptionEnum.SMS_MISSING_FORMAT_ARGUMENT);
        }
        logger.info("\n短信模板id:【{}】,短信下发内容:【{}】,短信接收人【{}】",smsTemplateVo.getTemplateId(),templateContent,Arrays.toString(smsTemplateVo.getMobiles()));
        String url = String.format(SmsService.SUBMIT_URL,SmsService.SP_ID,SmsService.PASS_WORD,SmsService.AC,mobiles,templateContent);
        String result = RestTemplateUtil.get(url);
        return XStreamTransformer.fromXml(SmsBaseResult.class, result);
    }

    @Override
    public SmsReportsResult getSmsReportInfo() {
        String url = String.format(SmsService.SMS_STATE_REPORT_URL,SmsService.SP_ID,SmsService.PASS_WORD);
        String result = RestTemplateUtil.get(url);
        if(result.indexOf(RETURN_SMS)>=0) {
            SmsReportsResult smsReportsResult = new SmsReportsResult();
            smsReportsResult.setResult(SmsStateTypeEnum.SMS_SEND_SUCCESS.getCode());
            smsReportsResult.setDesc(SmsStateTypeEnum.SMS_SEND_SUCCESS.getMessage());
            return smsReportsResult;
        }
        logger.info("主动获取短信状态报告接口返回参数：{}",result);
        SmsReportsResult smsReportsResult = XStreamTransformer.fromXml(SmsReportsResult.class, result);
        return smsReportsResult;
    }

    @Override
    public SmsAnswersResult getSmsAnswerInfo() {
        String url = String.format(SmsService.SMS_ANSWER_INFO_URL,SmsService.SP_ID,SmsService.PASS_WORD);
        String result = RestTemplateUtil.get(url);
        if(result.indexOf(RETURN_SMS)>=0) {
            SmsAnswersResult smsAnswersResult = new SmsAnswersResult();
            smsAnswersResult.setResult(SmsStateTypeEnum.SMS_SEND_SUCCESS.getCode());
            smsAnswersResult.setDesc(SmsStateTypeEnum.SMS_SEND_SUCCESS.getMessage());
            return smsAnswersResult;
        }
        logger.info("主动获取短信回复内容接口返回参数：{}",result);
        SmsAnswersResult smsAnswersResult = XStreamTransformer.fromXml(SmsAnswersResult.class, result);
        return smsAnswersResult;
    }

    /**
     * 根据模板id查询模板信息
     * @param templateId
     * @return
     */
    public TbNewsSmsTemplate getSmsTemplateById(String templateId) {
        if(StringUtils.isBlank(templateId)) {
            return null;
        }
        return tbNewsSmsTemplateMapper.selectByPrimaryKey(templateId);
    }

    /**
     * 判断短信发送状态，如果是关闭状态,则判断接收人手机号码是否在配置的测试地址中，没有配置则默认取配置的测试号码的第一个
     * @param smsTemplateVo
     * @return
     */
    public SmsTemplateVo smsSwitchJudge(SmsTemplateVo smsTemplateVo) {
        //防止发送短息不走mq，故在此判断是否开启邮件发送
        logger.info("\n判断短信发送开关状态,状态是:【{}】",newsSwitchProperties.getSms());
        if(!newsSwitchProperties.getSms()) {
            List<String> newMobiles = new ArrayList<>();
            logger.info("\n短息发送开关未开启,如有需要请向组长申请开启,测试环境测试可在配置中心springcloud-news文件中配置白名单.");
            //关闭状态，设置短息接收人
            if(null == newsSwitchProperties.getMobiles() || newsSwitchProperties.getMobiles().length==0) {
                throw new JnSpringCloudException(SmsExceptionEnum.SMS_SWITCH_NOTNULL_MOBILES);
            }
            List<String> mobileList = Arrays.asList(newsSwitchProperties.getMobiles());
            for(String mobile : smsTemplateVo.getMobiles()) {
                if(mobileList.contains(mobile)) {
                    newMobiles.add(mobile);
                }
            }
            if(newMobiles.size()==0) {
                newMobiles.add(mobileList.get(0));
            }
            smsTemplateVo.setMobiles(newMobiles.toArray(new String[newMobiles.size()]));
        }
        return smsTemplateVo;
    }

}
