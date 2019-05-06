package org.xxpay.shop.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PayOrder implements Serializable {
    /**
     * 支付订单号
     *
     * @mbggenerated
     */
    private String payOrderId;

    /**
     * 商户ID
     *
     * @mbggenerated
     */
    private String mchId;

    /**
     * 商户订单号
     *
     * @mbggenerated
     */
    private String mchOrderNo;

    /**
     * 渠道ID
     *
     * @mbggenerated
     */
    private String channelId;

    /**
     * 支付金额,单位分
     *
     * @mbggenerated
     */
    private Long amount;

    /**
     * 三位货币代码,人民币:cny
     *
     * @mbggenerated
     */
    private String currency;

    /**
     * 支付状态,0-订单生成,1-支付中(目前未使用),2-支付成功,3-业务处理完成
     *
     * @mbggenerated
     */
    private Byte status;

    /**
     * 客户端IP
     *
     * @mbggenerated
     */
    private String clientIp;

    /**
     * 设备
     *
     * @mbggenerated
     */
    private String device;

    /**
     * 商品标题
     *
     * @mbggenerated
     */
    private String subject;

    /**
     * 商品描述信息
     *
     * @mbggenerated
     */
    private String body;

    /**
     * 特定渠道发起时额外参数
     *
     * @mbggenerated
     */
    private String extra;

    /**
     * 渠道商户ID
     *
     * @mbggenerated
     */
    private String channelMchId;

    /**
     * 渠道订单号
     *
     * @mbggenerated
     */
    private String channelOrderNo;

    /**
     * 渠道支付错误码
     *
     * @mbggenerated
     */
    private String errCode;

    /**
     * 渠道支付错误描述
     *
     * @mbggenerated
     */
    private String errMsg;

    /**
     * 扩展参数1
     *
     * @mbggenerated
     */
    private String param1;

    /**
     * 扩展参数2
     *
     * @mbggenerated
     */
    private String param2;

    /**
     * 通知地址
     *
     * @mbggenerated
     */
    private String notifyUrl;

    /**
     * 通知次数
     *
     * @mbggenerated
     */
    private Byte notifyCount;

    /**
     * 最后一次通知时间
     *
     * @mbggenerated
     */
    private Long lastNotifyTime;

    /**
     * 订单失效时间
     *
     * @mbggenerated
     */
    private Long expireTime;

    /**
     * 订单支付成功时间
     *
     * @mbggenerated
     */
    private Long paySuccTime;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 签名
     * */
    private String sign;

    /**
     *  返回通知类型 1：前台页面；2：后台接口
     * */
    private String backType;

    /**
     * 缴费类型
     * （详情请查看 MchPayTypeEnum 枚举类）
    * */
    private String payType;

    private static final long serialVersionUID = 1L;

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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
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

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
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

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public Byte getNotifyCount() {
        return notifyCount;
    }

    public void setNotifyCount(Byte notifyCount) {
        this.notifyCount = notifyCount;
    }

    public Long getLastNotifyTime() {
        return lastNotifyTime;
    }

    public void setLastNotifyTime(Long lastNotifyTime) {
        this.lastNotifyTime = lastNotifyTime;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public Long getPaySuccTime() {
        return paySuccTime;
    }

    public void setPaySuccTime(Long paySuccTime) {
        this.paySuccTime = paySuccTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    @Override
    public String toString() {
        return "PayOrder{" +
                "payOrderId='" + payOrderId + '\'' +
                ", mchId='" + mchId + '\'' +
                ", mchOrderNo='" + mchOrderNo + '\'' +
                ", channelId='" + channelId + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", status=" + status +
                ", clientIp='" + clientIp + '\'' +
                ", device='" + device + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", extra='" + extra + '\'' +
                ", channelMchId='" + channelMchId + '\'' +
                ", channelOrderNo='" + channelOrderNo + '\'' +
                ", errCode='" + errCode + '\'' +
                ", errMsg='" + errMsg + '\'' +
                ", param1='" + param1 + '\'' +
                ", param2='" + param2 + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", notifyCount=" + notifyCount +
                ", lastNotifyTime=" + lastNotifyTime +
                ", expireTime=" + expireTime +
                ", paySuccTime=" + paySuccTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", sign='" + sign + '\'' +
                ", backType='" + backType + '\'' +
                ", payType='" + payType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PayOrder payOrder = (PayOrder) o;
        return Objects.equals(payOrderId, payOrder.payOrderId) &&
                Objects.equals(mchId, payOrder.mchId) &&
                Objects.equals(mchOrderNo, payOrder.mchOrderNo) &&
                Objects.equals(channelId, payOrder.channelId) &&
                Objects.equals(amount, payOrder.amount) &&
                Objects.equals(currency, payOrder.currency) &&
                Objects.equals(status, payOrder.status) &&
                Objects.equals(clientIp, payOrder.clientIp) &&
                Objects.equals(device, payOrder.device) &&
                Objects.equals(subject, payOrder.subject) &&
                Objects.equals(body, payOrder.body) &&
                Objects.equals(extra, payOrder.extra) &&
                Objects.equals(channelMchId, payOrder.channelMchId) &&
                Objects.equals(channelOrderNo, payOrder.channelOrderNo) &&
                Objects.equals(errCode, payOrder.errCode) &&
                Objects.equals(errMsg, payOrder.errMsg) &&
                Objects.equals(param1, payOrder.param1) &&
                Objects.equals(param2, payOrder.param2) &&
                Objects.equals(notifyUrl, payOrder.notifyUrl) &&
                Objects.equals(notifyCount, payOrder.notifyCount) &&
                Objects.equals(lastNotifyTime, payOrder.lastNotifyTime) &&
                Objects.equals(expireTime, payOrder.expireTime) &&
                Objects.equals(paySuccTime, payOrder.paySuccTime) &&
                Objects.equals(createTime, payOrder.createTime) &&
                Objects.equals(updateTime, payOrder.updateTime) &&
                Objects.equals(sign, payOrder.sign) &&
                Objects.equals(backType, payOrder.backType) &&
                Objects.equals(payType, payOrder.payType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payOrderId, mchId, mchOrderNo, channelId, amount, currency, status, clientIp, device, subject, body, extra, channelMchId, channelOrderNo, errCode, errMsg, param1, param2, notifyUrl, notifyCount, lastNotifyTime, expireTime, paySuccTime, createTime, updateTime, sign, backType, payType);
    }
}