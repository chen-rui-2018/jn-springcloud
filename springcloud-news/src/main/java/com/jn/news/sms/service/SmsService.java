package com.jn.news.sms.service;

import com.jn.news.sms.model.SmsBaseResult;
import com.jn.news.sms.vo.SmsAnswersResult;
import com.jn.news.sms.vo.SmsReportsResult;
import com.jn.news.vo.SmsTemplateVo;

/**
 * 发送短信接口
 *
 * @Author： cm
 * @Date： Created on 2019/2/20 16:32
 * @Version： v1.0
 * @Modified By:
 */
public interface SmsService {
    /**
     * 企业帐号/企业代码
     */
    String SP_ID = "719610";
    /**
     * 企业密码
     */
    String PASS_WORD = "7werew213";
    /**
     * 下发接入码
     */
    String AC = "719610";
    /**
     * 下发接口地址
     */
    String SUBMIT_URL = "http://47.100.243.159:27504/smsgwhttp/sms/submit?spid=%s&password=%s&ac=%s&mobiles=%s&content=%s";
    /**
     * 短信状态报告获取
     */
    String SMS_STATE_REPORT_URL = "http://47.100.243.159:27504/smsgwhttp/sms/report?spid=%s&password=%s";
    /**
     * 短信回复信息获取
     */
    String SMS_ANSWER_INFO_URL = "http://47.100.243.159:27504/smsgwhttp/sms/report?spid=%s&password=%s";

    /**
     * 下发短信
     * @param smsTemplateVo
     * @return
     */
    SmsBaseResult sendMsgByTemplate(SmsTemplateVo smsTemplateVo);

    /**
     * 主动获取短信状态报告（已获取的短信状态不会再拿到）
     * @return
     */
    SmsReportsResult getSmsReportInfo();

    /**
     * 主动获取回复信息（已获取的回复信息不会再拿到）
     * @return
     */
    SmsAnswersResult getSmsAnswerInfo();

}
