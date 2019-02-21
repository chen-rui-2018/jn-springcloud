package com.jn.wechat.base.model.message;

import com.jn.wechat.base.utils.xml.XStreamDataConverter;
import com.jn.wechat.base.utils.xml.XStreamTransformer;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import java.io.Serializable;

/**
 * 消息基类（公众帐号 -> 普通用户）
 *
 * @Author： cm
 * @Date： Created on 2019/1/7 14:54
 * @Version： v1.0
 * @Modified By:
 */
@XStreamAlias("xml")
public class WxXmlOutMessage implements Serializable {

    private static final long serialVersionUID = -4198909597679873346L;
    @XStreamAlias("ToUserName")
    @XStreamConverter(value = XStreamDataConverter.class)
    protected String toUserName;

    @XStreamAlias("FromUserName")
    @XStreamConverter(value = XStreamDataConverter.class)
    protected String fromUserName;

    @XStreamAlias("CreateTime")
    protected Long createTime;

    @XStreamAlias("MsgType")
    @XStreamConverter(value = XStreamDataConverter.class)
    protected String msgType;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    @Override
    public String toString() {
        return "WxXmlOutMessage{" +
                "toUserName='" + toUserName + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", createTime=" + createTime +
                ", msgType='" + msgType + '\'' +
                '}';
    }

    public String toXml() {
        return XStreamTransformer.toXml((Class<WxXmlOutMessage>) this.getClass(), this);
    }
}
