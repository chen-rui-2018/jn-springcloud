package com.jn.pay.model.wx;

/**
 * @ClassName：微信支付参数
 * @Descript：此参数用于客户端与微信服务器交互
 * @Author： hey
 * @Date： Created on 2019/5/6 10:13
 * @Version： v1.0
 * @Modified By:
 */
public class PayParams {

    /**
     * 应用ID
     * 微信开放平台审核通过的应用APPID
    * */
    private String appId;

    /**
     * 商户号
     * 微信支付分配的商户号
     * */
    private String partnerId;

    /**
     * 预支付交易会话ID
     * 微信返回的支付交易会话ID
     * */
    private String prepayId;

    /**
     * 扩展字段
     * 暂填写固定值Sign=WXPay
     * */
    private String packageValue;

    /**
     * 随机字符串
     * 随机字符串，不长于32位。推荐随机数生成算法
     * */
    private String nonceStr;

    /**
     * 时间戳（10位）
     * */
    private String timeStamp;

    /**
     *微信签名
     *签名,详见签名算法,调取微信支付时用到的签名值
     * */
    private String paySign;

   /**
    * 签名算法
    * 暂支持MD5
   * */
   private String  signType;


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getPackageValue() {
        return packageValue;
    }

    public void setPackageValue(String packageValue) {
        this.packageValue = packageValue;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPaySign() {
        return paySign;
    }

    public void setPaySign(String paySign) {
        this.paySign = paySign;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }
}
