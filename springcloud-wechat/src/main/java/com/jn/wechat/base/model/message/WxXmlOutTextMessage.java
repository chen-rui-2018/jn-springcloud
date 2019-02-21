package com.jn.wechat.base.model.message;

import com.jn.wechat.base.WxConsts;
import com.jn.wechat.base.utils.xml.XStreamDataConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * 文本消息推送
 *
 * @Author： cm
 * @Date： Created on 2019/1/7 15:19
 * @Version： v1.0
 * @Modified By:
 */
@XStreamAlias("xml")
public class WxXmlOutTextMessage extends WxXmlOutMessage {

    private static final long serialVersionUID = 6756940365032981336L;

    @XStreamAlias("Content")
    @XStreamConverter(value = XStreamDataConverter.class)
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public WxXmlOutTextMessage() {
        this.msgType = WxConsts.XmlMsgType.TEXT;
    }

    @Override
    public String toString() {
        return "WxXmlOutTextMessage{" +
                "content='" + content + '\'' +
                ", toUserName='" + toUserName + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", createTime=" + createTime +
                ", msgType='" + msgType + '\'' +
                '}';
    }
}
