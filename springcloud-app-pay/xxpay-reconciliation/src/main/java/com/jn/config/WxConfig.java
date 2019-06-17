package com.jn.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 *
 * @Author： hey
 * @Date： Created on 2019/1/7 11:08
 * @Version： v1.0
 * @Modified By:
 */

@Component
@ConfigurationProperties(prefix = "reconciliation.wx")
@RefreshScope
public class WxConfig {

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
    /**
     * 公众账号ID
     */
    private String appId;
    /**
     * 微信商户号
     */
    private String channelMchId;
    /**
     * 微信支付密钥
     */
    private String partnerKey;


    /**
     * 初始化微信配置
     * @param configParam
     * @param channelMchId 微信商户号
     * @return
     */
    public WxConfig init(String configParam,String channelMchId) {
        Assert.notNull(configParam, "init WX config error");
        JSONObject paramObj = JSON.parseObject(configParam);
        this.setAppId(paramObj.getString("appId"));
        this.setChannelMchId(channelMchId);
        this.setPartnerKey(paramObj.getString("key"));

        return this;
    }


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getChannelMchId() {
        return channelMchId;
    }

    public void setChannelMchId(String channelMchId) {
        this.channelMchId = channelMchId;
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
