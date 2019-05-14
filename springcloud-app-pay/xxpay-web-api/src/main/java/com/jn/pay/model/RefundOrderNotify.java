package com.jn.pay.model;

import java.io.Serializable;
import java.util.Date;

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
     * 支付系统支付订单号
     * */
    private String payOrderId;
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
    private String mchRefundNo;
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
    private Byte status;
    /**
     * 退款结果:0-不确认结果,1-等待手动处理,2-确认成功,3-确认失败
     * */
    private Byte result;
    /**
     * 客户端IP
     */
    private String clientIp;
    /**
     * 设备
     */
    private String device;
    /**
     * 第三方支付渠道退款订单号(微信,支付宝)
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
    private Date refundSuccTime;
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
     * 第三方渠道错误码
    * */
    private String  channelErrCode;
    /**
     * 第三方渠道错误描述
     * */
    private String  channelErrMsg;
    /**
     * 支付订单的支付金额
    * */
    private Long payAmount;


    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getResult() {
        return result;
    }

    public void setResult(Byte result) {
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

    public Date getRefundSuccTime() {
        return refundSuccTime;
    }

    public void setRefundSuccTime(Date refundSuccTime) {
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

    public String getChannelErrCode() {
        return channelErrCode;
    }

    public void setChannelErrCode(String channelErrCode) {
        this.channelErrCode = channelErrCode;
    }

    public String getChannelErrMsg() {
        return channelErrMsg;
    }

    public void setChannelErrMsg(String channelErrMsg) {
        this.channelErrMsg = channelErrMsg;
    }

    public Long getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    @Override
    public String toString() {
        return "RefundOrderNotify{" +
                "payOrderId='" + payOrderId + '\'' +
                ", refundOrderId='" + refundOrderId + '\'' +
                ", mchId='" + mchId + '\'' +
                ", mchRefundNo='" + mchRefundNo + '\'' +
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
                ", serviceId='" + serviceId + '\'' +
                ", serviceUrl='" + serviceUrl + '\'' +
                ", channelErrCode='" + channelErrCode + '\'' +
                ", channelErrMsg='" + channelErrMsg + '\'' +
                ", payAmount=" + payAmount +
                '}';
    }
}