package com.jn.news.message;

import com.jn.common.channel.MessageSink;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.news.config.NewsSwitchProperties;
import com.jn.news.enums.NewsExceptionEnum;
import com.jn.news.sms.enums.SmsExceptionEnum;
import com.jn.wechat.api.WechatClient;
import com.jn.wechat.model.WxTemplateMessage;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * 消息处理
 * 需要自己捕获异常，打印
 *
 * @author： cm
 * @date： Created on 2018/11/8 16:53
 * @version： v1.0
 * @modified By:
 */
@EnableBinding({MessageSink.class })
public class WetChatSink {

    @Autowired
    private NewsSwitchProperties newsSwitchProperties;
    @Autowired
    private WechatClient wechatClient;

    private static Logger log = LoggerFactory.getLogger(WetChatSink.class);

    @StreamListener(MessageSink.WET_CHAT)
    public void listenWetChat(WxTemplateMessage wxTemplateMessage) {
        log.info("收到WET_CHAT的信息:{}",wxTemplateMessage.toString()) ;
        if(!newsSwitchProperties.getWx()) {
            log.info("\n微信模板消息推送开关未开启,如有需要请向组长申请开启,测试环境测试可在配置中心springcloud-news文件中配置白名单.");
            //关闭状态，设置接收人
            if(StringUtils.isBlank(newsSwitchProperties.getTouser())) {
                throw new JnSpringCloudException(NewsExceptionEnum.WX_SWITCH_NOTNULL_TOUSER);
            }
            wxTemplateMessage.setTouser(newsSwitchProperties.getTouser());
        }
        Result<String> result = wechatClient.pushTemplateInfo(wxTemplateMessage);
        log.info("推送模板消息接口返回结果:{}",result.getResult());
    }


}
