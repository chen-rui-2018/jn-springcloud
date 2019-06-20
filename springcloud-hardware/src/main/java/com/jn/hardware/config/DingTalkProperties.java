package com.jn.hardware.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 钉钉配置属性
 *
 * @Author： cm
 * @Date： Created on 2019/6/14 21:47
 * @Version： v1.0
 * @Modified By:
 */
@Component
@ConfigurationProperties(prefix = "jn.ding")
@RefreshScope
public class DingTalkProperties {
    /**
     * 钉钉：企业内部应用appkey
     */
    private String appkey;
    /**
     * 钉钉：企业内部应用appsecret
     */
    private String appsecret;
    /**
     * 钉钉：企业ID
     */
    private String corpId;
    /**
     * 钉钉：通讯录事件回调Token
     */
    private String addressBookToken;
    /**
     * 钉钉：通讯录事件回调Aeskey
     */
    private String addressBookAeskey;


    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public String getAddressBookToken() {
        return addressBookToken;
    }

    public void setAddressBookToken(String addressBookToken) {
        this.addressBookToken = addressBookToken;
    }

    public String getAddressBookAeskey() {
        return addressBookAeskey;
    }

    public void setAddressBookAeskey(String addressBookAeskey) {
        this.addressBookAeskey = addressBookAeskey;
    }
}
