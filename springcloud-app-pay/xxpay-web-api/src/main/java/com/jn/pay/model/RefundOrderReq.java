package com.jn.pay.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
     * 商户ID
     * （详情请查看 mchIdEnum 枚举类）
     * */
    @NotBlank(message = "商户ID不能为空！")
    private String mchId;
    /**
     * 支付订单号(支付系统返回的订单号)
     */
    @NotBlank(message = "支付订单号(支付系统返回的订单号)不能为空！")
    private String payOrderId;
    /**
     * 商户支付订单号
     */
    @NotBlank(message = "商户支付订单号不能为空！")
    private String mchOrderNo;
    /**
     * 商户退款单号
     */
    @NotBlank(message = "商户退款单号不能为空！")
    private String mchRefundNo;
    /**
     * 渠道ID
     * 根据ChannelIdEnum枚举类获取
     */
    @NotBlank(message = "渠道ID不能为空！")
    private String channelId;
    /**
     * 退款金额,单位分
     */
    @NotNull(message = "支付金额不能为空！")
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
     * 回调地址
     * 支付系统回调通知业务系统地址(http方式)
     * notifyUrl如果为空,serviceId和serviceUrl为必传
     */
    @ApiModelProperty("支付系统回调通知业务系统地址(http方式)，notifyUrl如果为空,serviceId和serviceUrl为必传")
    private String notifyUrl;
    /**
     * 回调springCloud服务名称ID
     * serviceId和serviceUrl如果为空,notifyUrl为必传
     */
    @ApiModelProperty("支付系统回调通知业务系统地址，serviceId和serviceUrl如果为空,notifyUrl为必传")
    private String serviceId;

    /**
     * 回调springCloud服务URL
     * serviceId和serviceUrl如果为空,notifyUrl为必传
     */
    @ApiModelProperty("支付系统回调通知业务系统地址，serviceId和serviceUrl如果为空,notifyUrl为必传")
    private String serviceUrl;
    /**
     * 渠道用户标识,如微信openId,支付宝账号
     */
    @NotBlank(message = "渠道用户标识不能为空！")
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
     *    当请求参数channelId = WX_JSAPI （微信公众号支付）时，openId参数必填，对应用户所在微信公众号的openId。
     * 如：{"openId":"o2RvowBf7sOVJf8kJksUEMceaDqo"}
     *
     *    当请求参数channelId = WX_NATIVE （微信原生扫码支付）时，productId参数必填，对应业务系统定义的商品ID。
     * 如：{"productId":"120989823"}
     *
     *    当请求参数channelId = ALIPAY_WAP （支付宝WAP支付）时，可传参数ali_show_url，表示用户付款中途退出返回商户网站的地址。不传默认地址为：www.xxpay.org。
     * 如：{"ali_show_url":"http://www.xiaoshuding.com"}
     *
     *    当请求参数channelId = ALIPAY_PC （支付宝PC支付）时，可传参数qr_pay_mode、qrcode_width。
     * 如： {"qr_pay_mode":"4", "qrcode_width":"200"}
     * qr_pay_mode：扫码支付的方式，支持前置模式和跳转模式(4：直接显示二维码，2：跳转模式)默认为4。
     * qrcode_width：当qr_pay_mode=4时，该参数生效，表示二维码宽度。
     */
    private String extra ;

    /**
     * 签名
     */
    @ApiModelProperty("签名,可以通过API提供的工具生成")
    @NotBlank(message = "签名不能为空！")
    private String sign;

    @Override
    public String toString() {
        return "RefundOrderReq{" +
                "mchId='" + mchId + '\'' +
                ", payOrderId='" + payOrderId + '\'' +
                ", mchOrderNo='" + mchOrderNo + '\'' +
                ", mchRefundNo='" + mchRefundNo + '\'' +
                ", channelId='" + channelId + '\'' +
                ", amount=" + amount +
                ", clientIp='" + clientIp + '\'' +
                ", device='" + device + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", serviceUrl='" + serviceUrl + '\'' +
                ", channelUser='" + channelUser + '\'' +
                ", userName='" + userName + '\'' +
                ", remarkInfo='" + remarkInfo + '\'' +
                ", param1='" + param1 + '\'' +
                ", param2='" + param2 + '\'' +
                ", extra='" + extra + '\'' +
                ", sign='" + sign + '\'' +
                '}';
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

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
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

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}