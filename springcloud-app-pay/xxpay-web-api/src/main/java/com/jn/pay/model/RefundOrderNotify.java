package com.jn.pay.model;

import java.io.Serializable;

/**
 * 退款通知实体类
 *
 * @author： hey
 * @date： Created on 2019/05/06 16:52
 * @version： v1.0
 * @modified By:
 **/
public class RefundOrderNotify implements Serializable  {

    private static final long serialVersionUID = 1L;

    /**
     * 支付系统生成的退款订单号
    * */
    private String refundOrderId;
    /**
     * 支付系统分配的商户号
     * */
    private String mchId;
    /**
     * 商户生成的退款订单号
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
     * 退款金额,单位分(不能有小数点)
    * */
    private Long refundAmount;
    /**
     * 退款状态:0-订单生成,1-退款中,2-退款成功,3-退款失败,4-业务处理完成
     * */
    private Integer status;
    /**
     * 退款结果:0-不确认结果,1-等待手动处理,2-确认成功,3-确认失败
     * */
    private Integer result;
    /**
     * 客户端IP
     */
    private String clientIp;
    /**
     * 设备
     */
    private String device;
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
     *退款成功时间（精确到毫秒）
     * */
    private Long refundSuccTime;
    /**
     *通知类型，1-前台通知，2-后台通知
     * */
    private String backType;
    /**
     * 签名
     * */
    private String sign;

    @Override
    public String toString() {
        return "RefundOrderNotify{" +
                "refundOrderId='" + refundOrderId + '\'' +
                ", mchId='" + mchId + '\'' +
                ", mchOrderNo='" + mchOrderNo + '\'' +
                ", channelId='" + channelId + '\'' +
                ", currency='" + currency + '\'' +
                ", refundAmount=" + refundAmount +
                ", status=" + status +
                ", result=" + result +
                ", clientIp='" + clientIp + '\'' +
                ", device='" + device + '\'' +
                ", channelOrderNo='" + channelOrderNo + '\'' +
                ", param1='" + param1 + '\'' +
                ", param2='" + param2 + '\'' +
                ", refundSuccTime=" + refundSuccTime +
                ", backType='" + backType + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }

    public String getRefundOrderId() {
        return refundOrderId;
    }

    public void setRefundOrderId(String refundOrderId) {
        this.refundOrderId = refundOrderId;
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

    public Long getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Long refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
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

    public Long getRefundSuccTime() {
        return refundSuccTime;
    }

    public void setRefundSuccTime(Long refundSuccTime) {
        this.refundSuccTime = refundSuccTime;
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