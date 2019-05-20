package com.jn.news.app.utils;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import com.jn.common.enums.CommonExceptionEnum;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.StringUtils;
import com.jn.news.app.enums.JPushEnum;
import com.jn.news.app.enums.JPushExceptionEnum;
import com.jn.news.app.model.JPushData;
import com.jn.news.app.model.JPushResult;
import com.jn.news.enums.NewsExceptionEnum;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 极光推送工具类
 * @author： huxw
 * @date： Created on 2019-5-18 10:36:51
 * @version： v1.0
 * @modified By:
 */
public class JPushUtil {

    private static String APP_KEY = JPushEnum.J_PUSH_APP_KEY.getMessage();
    private static String  MASTER_SECRET = JPushEnum.J_PUSH_MASTER_SECRET.getMessage();

    // 快速测试
    public static void main(String[] args) {
        List<String> ids = new ArrayList<>();
//        ids.add("140fe1da9ee30f8212f"); //xiangzk
        ids.add("140fe1da9ee7485a439"); //huxw
        ids.add("160a3797c877a89b4f6"); //tangry

        String title = "最新消息1";
        String content = "最新内容1";
        // 推送方式（DEVICE：设备 TAG：标签）
        String pushType = "DEVICE";
        // 平台类型 ANDROID/IOS/null  如果为null 则发送给所有平台
        String platFromType = null;
        // 推送通知类型（ALL：全部 NOTICE：通知 MESSAGE：透传消息）
        String noticeType = "ALL";
        // 透传消息内容
        String message = "看看消息过来1";
        JPushResult jPushResult = pushMessage(title,content, ids, pushType, platFromType, noticeType, message);
        System.out.println(jPushResult.toString());
    }

    public static JPushResult pushMessage(String title, String content, List<String> ids, String pushType, String platFromType,
                                   String noticeType, String message) {
        // 判断必传字段
        if (StringUtils.isBlank(content)) {
            throw new JnSpringCloudException(JPushExceptionEnum.JPUSH_NOTNULL_CONTENT);
        }
        if (StringUtils.isBlank(title)) {
            throw new JnSpringCloudException(JPushExceptionEnum.JPUSH_NOTNULL_TITLE);
        }
        if (StringUtils.isBlank(pushType) || (!pushType.equals(JPushEnum.J_PUSH_TYPE_DEVICE.getCode())
                && !pushType.equals(JPushEnum.J_PUSH_TYPE_TAG.getCode()))) {
            throw new JnSpringCloudException(JPushExceptionEnum.JPUSH_NOTNULL_PUSH_TYPE);
        }
        if (StringUtils.isBlank(noticeType) || (!noticeType.equals(JPushEnum.J_PUSH_NOTICE_TYPE_ALL.getCode())
                && !noticeType.equals(JPushEnum.J_PUSH_NOTICE_TYPE_NOTICE.getCode()) && !noticeType.equals(JPushEnum.J_PUSH_NOTICE_TYPE_MESSAGE.getCode()))) {
            throw new JnSpringCloudException(JPushExceptionEnum.JPUSH_NOTNULL_NOTICE_TYPE);
        }

        // 封装推送对象
        PushResult pushResult = null;
        JPushResult jPushResult = new JPushResult();
        JPushData jPushData = new JPushData();
        jPushData.setContent(content);
        jPushData.setTitle(title);

        if (StringUtils.isNotBlank(message)) {
            jPushData.setMessage(message);
        }
        if (noticeType.equals(JPushEnum.J_PUSH_NOTICE_TYPE_MESSAGE.getCode())) {
            jPushData.setSendNotify(false);
        }
        if (noticeType.equals(JPushEnum.J_PUSH_NOTICE_TYPE_NOTICE.getCode())) {
            jPushData.setSendMessage(false);
        }

        // 推送平台
        Platform platform;
        // 推送对象
        Audience audience;

        if (StringUtils.isBlank(platFromType)) {
            platform = Platform.all();
        } else if (platFromType.equals(JPushEnum.J_PUSH_MASTER_ANDROID.getCode())) {
            platform = Platform.android();
        } else {
            platform = Platform.ios();
        }
        jPushData.setPlatform(platform);

        if (ids == null || ids.isEmpty()) {
            audience = Audience.all();
        } else {
            // 推送对象
            if (pushType.equals(JPushEnum.J_PUSH_TYPE_DEVICE.getCode())) {
                audience = Audience.registrationId(ids);
            } else {
                audience = Audience.tag(ids);
            }
        }
        jPushData.setAudience(audience);

        PushPayload payload = JPushUtil.buildPushObject(jPushData);
        try {
            pushResult = new JPushClient(MASTER_SECRET, APP_KEY).sendPush(payload);
        } catch (Exception e) {
            throw new JnSpringCloudException(NewsExceptionEnum.JPUSH_ERROR);
        }
        BeanUtils.copyProperties(pushResult, jPushResult);
        return jPushResult;
    }

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