package com.jn.pay.model;

import java.io.Serializable;

/**
 * 统一支付下单实体类
 *
 * @author： hey
 * @date： Created on 2019/05/06 16:52
 * @version： v1.0
 * @modified By:
 **/
public class PayOrderReq implements Serializable  {

    private static final long serialVersionUID = 1L;

    /**
     * 缴费类型
     * （详情请查看 MchPayTypeEnum 枚举类）
     * */
    private String payType;
    /**
     * 商户订单号
     */
    private String mchOrderNo;
    /**
     * 渠道ID
     */
    private String channelId;
    /**
     * 支付金额,单位分
     */
    private Long amount;
    /**
     * 客户端IP
     *
     * @mbggenerated
     */
    private String clientIp;
    /**
     * 设备
     */
    private String device;
    /**
     * 支付系统回调通知业务系统地址
     */
    private String notifyUrl;
    /**
     * 商品标题
     */
    private String subject;
    /**
     * 商品描述信息
     */
    private String body;
    /**
     * 扩展参数1
     */
    private String param1;

    /**
     * 扩展参数2
     */
    private String param2;
    /**
     * 特定渠道发起时额外参数
     */
    private String extra;

    @Override
    public String toString() {
        return "PayOrderReq{" +
                "payType='" + payType + '\'' +
                ", mchOrderNo='" + mchOrderNo + '\'' +
                ", channelId='" + channelId + '\'' +
                ", amount=" + amount +
                ", clientIp='" + clientIp + '\'' +
                ", device='" + device + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", param1='" + param1 + '\'' +
                ", param2='" + param2 + '\'' +
                ", extra='" + extra + '\'' +
                '}';
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getMchOrderNo() {
        return mchOrderNo;
    }

    public void setMchOrderNo(String mchOrderNo) {
        this.mchOrderNo = mchOrderNo;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}