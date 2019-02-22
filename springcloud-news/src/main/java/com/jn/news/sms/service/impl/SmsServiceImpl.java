package com.jn.news.sms.service.impl;

import com.jn.common.util.RestTemplateUtil;
import com.jn.common.util.xml.XmlUtils;
import com.jn.news.sms.service.SmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

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

    @Override
    public String sendMsgByTemplate(String mobile, String content) {
        logger.info("下发短信，手机号码:{},短信内容:{}",mobile,content);
        String url = String.format(SmsService.SUBMIT_URL,SmsService.SP_ID,SmsService.PASS_WORD,SmsService.AC,mobile,content);
        String result = RestTemplateUtil.get(url);
        logger.info("下发短信接口返回数据：{}",result);
        Map map = XmlUtils.xml2Map(result);
        return RestTemplateUtil.get(url);
    }

    @Override
    public String getSmsStateReport() {
        String url = String.format(SmsService.SMS_STATE_REPORT_URL,SmsService.SP_ID,SmsService.PASS_WORD);
        String result = RestTemplateUtil.get(url);
        Map map = XmlUtils.xml2Map(result);
        logger.info("主动获取短信状态报告接口返回参数：{}",result);
        return result;
    }

    @Override
    public String getSmsAnswerInfo() {
        String url = String.format(SmsService.SMS_ANSWER_INFO_URL,SmsService.SP_ID,SmsService.PASS_WORD);
        String result = RestTemplateUtil.get(url);
        logger.info("主动获取短信状态报告接口返回参数：{}",result);
        return result;
    }

}
