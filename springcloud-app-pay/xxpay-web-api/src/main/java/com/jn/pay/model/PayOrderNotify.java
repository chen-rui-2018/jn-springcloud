package com.jn.pay.model;

import java.io.Serializable;

/**
 * 支付通知实体类
 *
 * @author： hey
 * @date： Created on 2019/05/06 16:52
 * @version： v1.0
 * @modified By:
 **/
public class PayOrderNotify implements Serializable  {

    private static final long serialVersionUID = 1L;

    /**
     * 支付系统生成的订单号
     * */
    private String payOrderId;
    /**
     * 支付系统分配的商户号
     * */
    private String mchId;
    /**
     * 商户订单号
     */
    private String mchOrderNo;
    /**
     * 渠道ID
     */
    private String channelId;
    /**
     * 三位货币代码,人民币:cny
     */
    private String currency;
    /**
     * 支付金额,单位分
     */
    private Long amount;
    /**
     * 支付状态,0-订单生成,1-支付中,2-支付成功,3-业务处理完成
    * */
    private Byte status;
    /**
     * 客户端IP
     */
    private String clientIp;
    /**
     * 设备
     */
    private String device;
    /**
     * 商品标题
     */
    private String subject;
    /**
     * 商品描述
    * */
    private String body;
    /**
     * 第三方支付渠道订单号(微信,支付宝)
    * */
    private String channelOrderNo;
    /**
     * 扩展参数1
     */
    private String param1;
    /**
     * 扩展参数2
     */
    private String param2;
    /**
     *支付成功时间（精确到毫秒）
    * */
    private Long paySuccTime;
    /**
     *通知类型，1-前台通知，2-后台通知
     * */
    private String backType;
    /**
     * 签名
     * */
    private String sign;
    /**
     * 回调springCloud服务名称ID
     * serviceId和serviceUrl如果为空,notifyUrl为必传
     */
    private String serviceId;

    /**
     * 回调springCloud服务URL
     * serviceId和serviceUrl如果为空,notifyUrl为必传
     */
    private String serviceUrl;
    /**
     * 第三方支付渠道交易单号
    * */
    private String channelMchId;

    @Override
    public String toString() {
        return "PayOrderNotify{" +
                "payOrderId='" + payOrderId + '\'' +
                ", mchId='" + mchId + '\'' +
                ", mchOrderNo='" + mchOrderNo + '\'' +
                ", channelId='" + channelId + '\'' +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                ", status=" + status +
                ", clientIp='" + clientIp + '\'' +
                ", device='" + device + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", channelOrderNo='" + channelOrderNo + '\'' +
                ", param1='" + param1 + '\'' +
                ", param2='" + param2 + '\'' +
                ", paySuccTime=" + paySuccTime +
                ", backType='" + backType + '\'' +
                ", sign='" + sign + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", serviceUrl='" + serviceUrl + '\'' +
                ", channelMchId='" + channelMchId + '\'' +
                '}';
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getChannelMchId() {
        return channelMchId;
    }

    public void setChannelMchId(String channelMchId) {
        this.channelMchId = channelMchId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    public void setChannelOrderNo(String channelOrderNo) {
        this.channelOrderNo = channelOrderNo;
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

    public Long getPaySuccTime() {
        return paySuccTime;
    }

    public void setPaySuccTime(Long paySuccTime) {
        this.paySuccTime = paySuccTime;
    }

    public String getBackType() {
        return backType;
    }

    public void setBackType(String backType) {
        this.backType = backType;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}