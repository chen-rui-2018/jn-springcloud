package com.jn.pay.model;

import java.io.Serializable;

/**
 * 支付订单查询返回结果实体类
 *
 * @author： hey
 * @date： Created on 2019/05/06 16:52
 * @version： v1.0
 * @modified By:
 **/
public class PayOrderQueryRsp implements Serializable  {

    private static final long serialVersionUID = 1L;

    /**
     * 支付系统生成的订单号
     * */
    private String payOrderId;
    /**
     * 商户订单号
     */
    private String mchOrderNo;
    /**
     * 商户ID(支付系统分配的商户号)
     */
    private String mchId;
    /**
     * 渠道商户ID(第三方支付渠道申请的商户ID)
     */
    private String channelMchId;
    /**
     *渠道订单号（第三方支付订单号）
     * */
    private String channelOrderNo;
    /**
     * 支付渠道ID
     */
    private String channelId;
    /**
     * 币种(人民币:cny)
     */
    private String currency;
    /**
     * 支付金额(单位:分)
     */
    private Long amount;
    /**
     * 支付结果回调URL
     */
    private String notifyUrl;
    /**
     * 商品主题
     */
    private String subject;
    /**
     * 商品描述信息
     */
    private String body;
    /**
     * 支付状态
     * 0-订单生成,1-支付中,2-支付成功,3-业务处理完成
     */
    private Integer status;
    /**
     * 附加参数
     */
    private String extra;
    /**
     * 订单创建时间
    * */
    private Long createTime;
    /**
     * 支付成功时间
     * */
    private Long paySuccTime;
    /**
     * 更新时间
     * */
    private Long updateTime;
    /**
     * 最后通知商户时间
     * */
    private Long lastNotifyTime;
    /**
     * 通知商户次数
     * */
    private Integer notifyCount;
    /**
     *扩展参数1
    * */
    private String param1;
    /**
     *扩展参数2
     * */
    private String param2;
    /**
     *客户端IP
    * */
    private String clientIp;
    /**
     *设备
     * */
    private String device;


    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    public String getMchOrderNo() {
        return mchOrderNo;
    }

    public void setMchOrderNo(String mchOrderNo) {
        this.mchOrderNo = mchOrderNo;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getChannelMchId() {
        return channelMchId;
    }

    public void setChannelMchId(String channelMchId) {
        this.channelMchId = channelMchId;
    }

    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    public void setChannelOrderNo(String channelOrderNo) {
        this.channelOrderNo = channelOrderNo;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getPaySuccTime() {
        return paySuccTime;
    }

    public void setPaySuccTime(Long paySuccTime) {
        this.paySuccTime = paySuccTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getLastNotifyTime() {
        return lastNotifyTime;
    }

    public void setLastNotifyTime(Long lastNotifyTime) {
        this.lastNotifyTime = lastNotifyTime;
    }

    public Integer getNotifyCount() {
        return notifyCount;
    }

    public void setNotifyCount(Integer notifyCount) {
        this.notifyCount = notifyCount;
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

    @Override
    public String toString() {
        return "PayOrderQueryRsp{" +
                "payOrderId='" + payOrderId + '\'' +
                ", mchOrderNo='" + mchOrderNo + '\'' +
                ", mchId='" + mchId + '\'' +
                ", channelMchId='" + channelMchId + '\'' +
                ", channelOrderNo='" + channelOrderNo + '\'' +
                ", channelId='" + channelId + '\'' +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", status=" + status +
                ", extra='" + extra + '\'' +
                ", createTime=" + createTime +
                ", paySuccTime=" + paySuccTime +
                ", updateTime=" + updateTime +
                ", lastNotifyTime=" + lastNotifyTime +
                ", notifyCount=" + notifyCount +
                ", param1='" + param1 + '\'' +
                ", param2='" + param2 + '\'' +
                ", clientIp='" + clientIp + '\'' +
                ", device='" + device + '\'' +
                '}';
    }
}