package com.jn.pay.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

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
     * 商户ID
     * （详情请查看 mchIdEnum 枚举类）
     * */
    @ApiModelProperty("商户ID")
    @NotBlank(message = "商户ID不能为空！")
    private String mchId;


    /**
     * 商户订单号
     */
    @ApiModelProperty("商户订单号")
    @NotBlank(message = "商户订单号不能为空！")
    private String mchOrderNo;

    /**
     * 渠道ID
     * 根据ChannelIdEnum枚举类获取
     */
    @ApiModelProperty("渠道ID,根据ChannelIdEnum枚举类获取")
    @NotBlank(message = "渠道ID不能为空！")
    private String channelId;

    /**
     * 支付金额,单位分
     */
    @ApiModelProperty("支付金额,单位分")
    @NotBlank(message = "支付金额不能为空！")
    private Long amount;

    /**
     * 客户端IP
     * 如：192.168.10.01
     */
    @ApiModelProperty("客户端IP")
    private String clientIp;

    /**
     * 设备
     * 如：web
     */
    @ApiModelProperty("设备")
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
     * 商品标题
     */
    @ApiModelProperty("商品标题")
    @NotBlank(message = "商品标题不能为空！")
    private String subject;

    /**
     * 商品描述信息
     */
    @ApiModelProperty("商品描述信息")
    @NotBlank(message = "商品描述信息不能为空！")
    private String body;

    /**
     * 扩展参数1
     */
    @ApiModelProperty("扩展参数1,回调业务系统时原样返回")
    private String param1;

    /**
     * 扩展参数2
     */
    @ApiModelProperty("扩展参数2,回调业务系统时原样返回")
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
    @ApiModelProperty(value = "特定渠道发起时额外参数 如：当channelId = ALIPAY_PC 返回{\"qr_pay_mode\":\"4\", \"qrcode_width\":\"200\"}",example = "{\"qr_pay_mode\":\"4\", \"qrcode_width\":\"200\"}")
    private String extra;

    /**
     * 签名
     */
    @ApiModelProperty("签名,可以通过API提供的工具生成")
    @NotBlank(message = "签名不能为空！")
    private String sign;

    /**
     * 支付完成跳转的页面(只有支付宝才有)
     * 买家在支付成功后会看到一个支付宝交易提示成功的页面，该页面会停留几秒，
     * 然后会自动跳转回商户指定的同步通知页面
    * */
    @ApiModelProperty("买家付款完成以后进行自动跳转 ，returnUrl为http方式 ,且外网可访问链接不能带任何参数")
    private String aliPayReturnUrl;

    @Override
    public String toString() {
        return "PayOrderReq{" +
                "mchId='" + mchId + '\'' +
                ", mchOrderNo='" + mchOrderNo + '\'' +
                ", channelId='" + channelId + '\'' +
                ", amount=" + amount +
                ", clientIp='" + clientIp + '\'' +
                ", device='" + device + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", serviceUrl='" + serviceUrl + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", param1='" + param1 + '\'' +
                ", param2='" + param2 + '\'' +
                ", extra='" + extra + '\'' +
                ", sign='" + sign + '\'' +
                ", aliPayReturnUrl='" + aliPayReturnUrl + '\'' +
                '}';
    }

    public String getAliPayReturnUrl() {
        return aliPayReturnUrl;
    }

    public void setAliPayReturnUrl(String aliPayReturnUrl) {
        this.aliPayReturnUrl = aliPayReturnUrl;
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
}