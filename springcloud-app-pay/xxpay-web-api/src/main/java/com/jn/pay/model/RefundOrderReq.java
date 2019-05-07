package com.jn.pay.model;

import java.io.Serializable;

/**
 * 请求退款接口实体类
 *
 * @author： hey
 * @date： Created on 2019/05/06 16:52
 * @version： v1.0
 * @modified By:
 **/
public class RefundOrderReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 缴费类型
     * （详情请查看 MchPayTypeEnum 枚举类）
     * */
    private String payType;
    /**
     * 支付订单号
     */
    private String payOrderId;
    /**
     * 商户支付订单号
     */
    private String mchOrderNo;
    /**
     * 商户退款单号
     */
    private String mchRefundNo;
    /**
     * 渠道ID
     */
    private String channelId;
    /**
     * 退款金额,单位分
     */
    private Long amount;
    /**
     * 客户端IP
     */
    private String clientIp;
    /**
     * 设备
     */
    private String device;
    /**
     * 退款结果回调URL
     */
    private String notifyUrl;
    /**
     * 渠道用户标识,如微信openId,支付宝账号
     */
    private String channelUser;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 备注
     */
    private String remarkInfo;
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


    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

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

    public String getMchRefundNo() {
        return mchRefundNo;
    }

    public void setMchRefundNo(String mchRefundNo) {
        this.mchRefundNo = mchRefundNo;
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

    public String getChannelUser() {
        return channelUser;
    }

    public void setChannelUser(String channelUser) {
        this.channelUser = channelUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRemarkInfo() {
        return remarkInfo;
    }

    public void setRemarkInfo(String remarkInfo) {
        this.remarkInfo = remarkInfo;
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