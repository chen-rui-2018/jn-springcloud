package com.jn.news.app.utils;

import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import com.jn.news.app.model.JPushData;

/**
 * 极光推送工具类
 * @author： huxw
 * @date： Created on 2019-5-18 10:36:51
 * @version： v1.0
 * @modified By:
 */
public class JPushUtil {

    /**
     * 推送app消息并返回结果
     * @param jPushData
     * @return
     */
    public static PushPayload buildPushObject(JPushData jPushData) {
        AndroidNotification android = AndroidNotification.newBuilder()
                .addExtra("data",jPushData.getMessage())
                .setTitle(jPushData.getTitle())
                .build();
        IosNotification ios = IosNotification.newBuilder()
                .addExtra("data",jPushData.getMessage())
                .setSound("default")
                .incrBadge(1)
                .build();

        Notification notification = Notification.newBuilder()
                .setAlert(jPushData.getContent())
                .addPlatformNotification(android)
                .addPlatformNotification(ios)
                .build();

        Message message = Message.newBuilder()
                .setTitle(jPushData.getTitle())
                .setMsgContent(jPushData.getContent())
                .addExtra("data",jPushData.getMessage())
                .build();

        PushPayload.Builder builder = PushPayload.newBuilder();
        builder.setPlatform(jPushData.getPlatform())
                .setAudience(jPushData.getAudience())
                .setOptions(Options.newBuilder()
                .setApnsProduction(false)
                .build());

        if(jPushData.isSendNotify()) {
            builder.setNotification(notification);
        }
        if(jPushData.isSendMessage()) {
            builder.setMessage(message);
        }
        return builder.build();
    }
}