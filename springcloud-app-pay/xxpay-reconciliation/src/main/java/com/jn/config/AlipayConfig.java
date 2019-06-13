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
 * @Date： Created on 2019/05/23 11:08
 * @Version： v1.0
 * @Modified By:
 */

@Component
@ConfigurationProperties(prefix = "reconciliation.alipay")
@RefreshScope
public class AlipayConfig {

    /**
     * 支付网关
     */
    private String url;
    /**
     * 文件存放路径
     */
    private String dir;
    /**
     * 加密方式
     * */
    private String signType;
    /**
     * 字符编码格式
     * */
    private String charset ;
    /**
     * 字符格式
    * */
    private String format;
    /**
     * 私钥 pkcs8格式的
    * */
    private String privateKey;
    /**
     * 支付宝公钥
     * */
    private String publicKey;
    /**
     * 应用ID
     * */
    private String appId;
    /**
     *  是否沙箱环境,1:沙箱,0:正式环境
    * */
    private Short isSandbox = 0;

    /**
     * 初始化支付宝配置
     * @param configParam
     * @return
     */
    public AlipayConfig init(String configParam) {
        Assert.notNull(configParam, "init alipay config error");
        JSONObject paramObj = JSON.parseObject(configParam);
        this.setAppId(paramObj.getString("appid"));
        this.setPrivateKey(paramObj.getString("private_key"));
        this.setPublicKey(paramObj.getString("alipay_public_key"));
        this.setIsSandbox(paramObj.getShortValue("isSandbox"));
        if(this.getIsSandbox() == 1) {
            this.setUrl("https://openapi.alipaydev.com/gateway.do");
        }
        return this;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Short getIsSandbox() {
        return isSandbox;
    }

    public void setIsSandbox(Short isSandbox) {
        this.isSandbox = isSandbox;
    }
}
