package com.jn.news.app.model;

import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.audience.Audience;

import java.io.Serializable;

/**
 * 极光推送入参
 * @author： huxw
 * @date： Created on 2019-5-18 10:36:51
 * @version： v1.0
 * @modified By:
 */
public class JPushData implements Serializable{

    private static final long serialVersionUID = -13779011141645438L;
    // 标题
    private String title;
    // 内容
    private String content;
    // 平台
    private Platform platform;
    // 方式
    private Audience audience;
    // 自定义消息内容
    private String message;
    // 是否发送通知
    private boolean sendNotify;
    // 是否发送消息
    private boolean sendMessage;

    public JPushData(){
        this.sendNotify = true;
        this.sendMessage = true;
        this.message = "";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(boolean sendMessage) {
        this.sendMessage = sendMessage;
    }

    public boolean isSendNotify() {
        return sendNotify;
    }

    public void setSendNotify(boolean sendNotify) {
        this.sendNotify = sendNotify;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Audience getAudience() {
        return audience;
    }

    public void setAudience(Audience audience) {
        this.audience = audience;
    }

    @Override
    public String toString() {
        return "JPushData{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", platform=" + platform +
                ", audience=" + audience +
                ", message='" + message + '\'' +
                ", sendNotify=" + sendNotify +
                ", sendMessage=" + sendMessage +
                '}';
    }
}
