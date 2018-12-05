package com.jn.nodify.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 通知配置
 *
 * @author： fengxh
 * @date： Created on 2018/12/4 21:08
 * @version： v1.0
 * @modified By:
 */
@ConfigurationProperties(
        prefix = "jn"
)
@Component
@RefreshScope
public class NotifierProperties {

    private final NotifierProperties.Notifier notifier = new NotifierProperties.Notifier();


    public NotifierProperties.Notifier getNotifier() {
        return this.notifier;
    }

    public static class Notifier {
        /**
         * 发送开关
         */
        private boolean enabled = true;
        /**
         * 监控对象,对应的是停机、离线、上线、未知
         */
        private String[] notifierStatuses = new String[]{ "DOWN", "OFFLINE", "UP", "UNKNOWN" };
        /**
         * 发送端点
         */
        private String[] endpoints = new String[]{"app", "email", "wetChat", "sms"};
        /**
         * 发送主题
         */
        private String title = "南京项目节点异常";
        /**
         * 发送频率（分钟）
         */
        private Integer millis = 1;
        /**
         * 接收邮箱
         */
        private String[] receivedMail ;
        /**
         * 接收手机
         */
        private String[] receivedPhone ;
        /**
         * 接收APP
         */
        private String[] receivedApp ;
        /**
         * 接收微信
         */
        private String[] receivedWetChat;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String[] getEndpoints() {
            return endpoints;
        }

        public void setEndpoints(String[] endpoints) {
            this.endpoints = endpoints;
        }

        public Integer getMillis() {
            return millis;
        }

        public void setMillis(Integer millis) {
            this.millis = millis;
        }


        public String[] getReceivedMail() {
            return receivedMail;
        }

        public void setReceivedMail(String[] receivedMail) {
            this.receivedMail = receivedMail;
        }

        public String[] getReceivedPhone() {
            return receivedPhone;
        }

        public void setReceivedPhone(String[] receivedPhone) {
            this.receivedPhone = receivedPhone;
        }

        public String[] getReceivedApp() {
            return receivedApp;
        }

        public void setReceivedApp(String[] receivedApp) {
            this.receivedApp = receivedApp;
        }

        public String[] getReceivedWetChat() {
            return receivedWetChat;
        }

        public void setReceivedWetChat(String[] receivedWetChat) {
            this.receivedWetChat = receivedWetChat;
        }

        public String[] getNotifierStatuses() {
            return notifierStatuses;
        }

        public void setNotifierStatuses(String[] notifierStatuses) {
            this.notifierStatuses = notifierStatuses;
        }
    }
}
