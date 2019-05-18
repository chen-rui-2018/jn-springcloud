package com.jn.news.app.model;

import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.audience.Audience;

import java.io.Serializable;

public class JPushData implements Serializable{

    private String title;
    private String content;
    private Platform platform;
    private Audience audience;
    private String message;
    private boolean sendNotify;
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

}
