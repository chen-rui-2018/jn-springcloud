package com.jn.wechat.base.service;

import com.jn.wechat.base.model.template.WxTemplateIndustrySet;
import com.jn.wechat.model.WxTemplateMessage;

/**
 * 模板消息接口
 *
 * @Author： cm
 * @Date： Created on 2019/1/24 11:09
 * @Version： v1.0
 * @Modified By:
 */
public interface WxTemplateMsgService {

    /**
     * 设置模板行业
     */
    String SET_TEMPLATE_INDUSTRY = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry";

    /**
     * 发送微信模板API接口地址
     */
    String SEND_TEMPLATE_MSG_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send";

    /**
     * 设置所属行业
     * @param wxTemplateIndustrySet
     * @return 是否成功
     */
    boolean setIndustry(WxTemplateIndustrySet wxTemplateIndustrySet);

    /**
     * 发送模板消息
     * @param wxTemplateMessage
     * @return
     */
    String sendTemplateMsg(WxTemplateMessage wxTemplateMessage);
}
