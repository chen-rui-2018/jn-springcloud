package com.jn.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * TODO：未添加类描述
 *
 * @Author： cm
 * @Date： Created on 2019/1/7 11:08
 * @Version： v1.0
 * @Modified By:
 */

@Component
@ConfigurationProperties(prefix = "reconciliation.wx")
@RefreshScope
public class WxConfig {

    /**
     * 公众账号ID
     */
    private String appId;
    /**
     * 微信商户号
     */
    private String mchId;
    /**
     * 微信支付密钥
     */
    private String partnerKey;
    /**
     * 文件存放路径
     */
    private String dir;
    /**
     * 账单下载地址
    * */
    private String url;

    /**
     * 字符编码格式
     * */
    private String charset;

    /**
     *
      * ALL，返回当日所有订单信息，默认值
     *  SUCCESS，返回当日成功支付的订单
     *  REFUND，返回当日退款订单
    * */
    private String billType ;


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getPartnerKey() {
        return partnerKey;
    }

    public void setPartnerKey(String partnerKey) {
        this.partnerKey = partnerKey;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }
}
