package com.jn.news.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 增加消息推送控制开关
 * 默认false为关，true为开
 *
 * @Author： cm
 * @Date： Created on 2019/6/10 17:03
 * @Version： v1.0
 * @Modified By:
 */

@Component
@ConfigurationProperties(prefix = "jn.news.switch")
@RefreshScope
public class NewsSwitchProperties {

    /**
     * app消息推送开关
     */
    private Boolean app;
    /**
     * app消息接收者id，这个需要app组提供
     */
    private List<String> ids;
    /**
     * email消息推送开关
     */
    private Boolean email;
    /**
     * 收件箱,多个邮箱以英文逗号隔开
     * java的RFC822规范中规定多个邮件分隔符是逗号","，outlook的分号";"不是规范的多邮件地址分隔符。
     */
    private String emailAddress;
    /**
     * sms消息推送开关
     */
    private Boolean sms;
    /**
     * 短息测试号码
     */
    private String[] mobiles;
    /**
     * wx消息推送开关
     */
    private Boolean wx;
    /**
     * 微信消息推送接收者openId
     */
    private String touser;

    public Boolean getApp() {
        return app;
    }

    public void setApp(Boolean app) {
        this.app = app;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public Boolean getEmail() {
        return email;
    }

    public void setEmail(Boolean email) {
        this.email = email;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Boolean getSms() {
        return sms;
    }

    public void setSms(Boolean sms) {
        this.sms = sms;
    }

    public String[] getMobiles() {
        return mobiles;
    }

    public void setMobiles(String[] mobiles) {
        this.mobiles = mobiles;
    }

    public Boolean getWx() {
        return wx;
    }

    public void setWx(Boolean wx) {
        this.wx = wx;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    @Override
    public String toString() {
        return "NewsSwitchProperties{" +
                "app=" + app +
                ", ids=" + ids +
                ", email=" + email +
                ", emailAddress='" + emailAddress + '\'' +
                ", sms=" + sms +
                ", mobiles=" + Arrays.toString(mobiles) +
                ", wx=" + wx +
                ", touser='" + touser + '\'' +
                '}';
    }
}
