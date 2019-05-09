package com.jn.news.utils.jpush;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
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
import com.jn.common.util.StringUtils;
import com.jn.news.utils.enums.JPushEnum;
import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/29 16:48
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "JPushUtils", description = "极光推送工具类")
public class JPushUtils {

    private static String APPKEY = JPushEnum.J_PUSH_APP_KEY.getMessage();
    private static String  MASTER_SECRET = JPushEnum.J_PUSH_MASTER_SECRET.getMessage();

    /**
     * 消息推送
     * @param content 推送的消息内容
     * @param title   推送的消息标题
     * @param ids     推送的目标id列表
     * @param platfromType 平台类型 ANDROID/IOS/null  如果为null 则发送给所有平台
     */
    public static void  pushMessage(String content, String title, List<String> ids, String platfromType){
        try {
            //所有人所有平台
            if (ids.isEmpty() && StringUtils.isBlank(platfromType)) {
                pushAll(content, title);
            }
            //指定人所有平台
            if (ids!=null && ids .size()>0  && StringUtils.isBlank(platfromType)) {
                pushAll(content, title,ids);
            }
            //所有人Android平台
            if(ids.isEmpty() && JPushEnum.J_PUSH_MASTER_ANDROID.getMessage().equals(platfromType)){
                pushAllForAndroid(content,title);
            }
            //指定人Android平台
            if(ids!=null && ids .size()>0   && JPushEnum.J_PUSH_MASTER_ANDROID.getMessage().equals(platfromType)){
                pushToIdsForAndroid(content,title,ids);
            }
            //所有人IOS平台
            if(ids.isEmpty() && JPushEnum.J_PUSH_MASTER_IOS.getMessage().equals(platfromType)){
                pushAllForIOS(content,title);
            }
            //指定人IOS平台
            if(ids!=null && ids .size()>0  && JPushEnum.J_PUSH_MASTER_IOS.getMessage().equals(platfromType)){
                pushToIdsForIOS(content,title,ids);
            }

        }catch (APIConnectionException e) {
                System.out.println("connection err");
                e.printStackTrace();
        } catch (APIRequestException e) {
                System.out.println("request error");
                e.printStackTrace();
        } catch (Exception e) {
                e.printStackTrace();
        }

    }

    /**
     * 发给所有用户 所有平台
     * @param content
     * @param title
     * @throws Exception
     */
    public static void pushAll(String content,String title) throws Exception {
        try {
            JPushClient jPushClient=new JPushClient(MASTER_SECRET,APPKEY);
            PushPayload payload=PushPayload.newBuilder().setPlatform(Platform.all())
                    .setAudience(Audience.all())
                    .setNotification(Notification.newBuilder()
                            .setAlert(content)
                            .addPlatformNotification(AndroidNotification.newBuilder()
                                    .setTitle(title)
                                    .build())
                            .addPlatformNotification(IosNotification.newBuilder()
                                    .incrBadge(1)
                                    .setSound("happy")
                                    .build())
                            .build()).setNotification(
                            Notification.newBuilder()
                                    .setAlert(content)
                                    .build())
                    .setOptions(Options.newBuilder()
                            //此字段的值是用来指定本推送要推送的apns环境，false表示开发，true表示生产；对android和自定义消息无意义
                            .setApnsProduction(true)
                            //此字段是给开发者自己给推送编号，方便推送者分辨推送记录
                            .setSendno(1)
                            //此字段的值是用来指定本推送的离线保存时长，如果不传此字段则默认保存一天，最多指定保留十天，单位为秒
                            .setTimeToLive(86400)
                            .build())
                    .build();

            PushResult result=jPushClient.sendPush(payload);
        } catch (APIConnectionException e) {
            System.out.println("connection err");
            e.printStackTrace();
        } catch (APIRequestException e) {
            System.out.println("request error");
            e.printStackTrace();
        }
    }
    /**
     * 发给指定用户 所有平台
     * @param content
     * @param title
     * @throws Exception
     */
    public static void pushAll(String content,String title,List<String> ids) throws Exception {
        try {
            JPushClient jPushClient=new JPushClient(MASTER_SECRET,APPKEY);
            PushPayload payload=PushPayload.newBuilder().setPlatform(Platform.all())
                    .setAudience(Audience.registrationId(ids))
                    .setNotification(Notification.newBuilder()
                            .setAlert(content)
                            .addPlatformNotification(AndroidNotification.newBuilder()
                                    .setTitle(title)
                                    .build())
                            .addPlatformNotification(IosNotification.newBuilder()
                                    .incrBadge(1)
                                    .setSound("happy")
                                    .build())
                            .build()).setNotification(
                            Notification.newBuilder()
                                    .setAlert(content)
                                    .build())
                    .setOptions(Options.newBuilder()
                            //此字段的值是用来指定本推送要推送的apns环境，false表示开发，true表示生产；对android和自定义消息无意义
                            .setApnsProduction(true)
                            //此字段是给开发者自己给推送编号，方便推送者分辨推送记录
                            .setSendno(1)
                            //此字段的值是用来指定本推送的离线保存时长，如果不传此字段则默认保存一天，最多指定保留十天，单位为秒
                            .setTimeToLive(86400)
                            .build())
                    .build();

            PushResult result=jPushClient.sendPush(payload);
        } catch (APIConnectionException e) {
            System.out.println("connection err");
            e.printStackTrace();
        } catch (APIRequestException e) {
            System.out.println("request error");
            e.printStackTrace();
        }
    }

    /**
     *所有人Android平台
     * @param content
     * @param title
     * @throws Exception
     */
    public static void pushAllForAndroid(String content,String title) throws Exception {
        try {
            JPushClient jPushClient=new JPushClient(MASTER_SECRET,APPKEY);
            PushPayload payload=PushPayload.newBuilder().setPlatform(Platform.android())
                    .setAudience(Audience.all())
                    .setNotification(Notification.newBuilder()
                            .setAlert(content)
                            .addPlatformNotification(AndroidNotification.newBuilder()
                                    .setTitle(title)
                                    .build())
                            .build())
                    .setOptions(Options.newBuilder()
                            //此字段的值是用来指定本推送要推送的apns环境，false表示开发，true表示生产；对android和自定义消息无意义
                            .setApnsProduction(true)
                            //此字段是给开发者自己给推送编号，方便推送者分辨推送记录
                            .setSendno(1)
                            //此字段的值是用来指定本推送的离线保存时长，如果不传此字段则默认保存一天，最多指定保留十天，单位为秒
                            .setTimeToLive(86400)
                            .build())
                    .build();

            PushResult result=jPushClient.sendPush(payload);
        } catch (APIConnectionException e) {
            System.out.println("connection err");
            e.printStackTrace();
        } catch (APIRequestException e) {
            System.out.println("request error");
            e.printStackTrace();
        }
    }
    /**
     *所有人IOS平台
     * @param content
     * @param title
     * @throws Exception
     */
    public static void pushAllForIOS(String content,String title) throws Exception {
        try {
            JPushClient jPushClient=new JPushClient(MASTER_SECRET,APPKEY);
            PushPayload payload=PushPayload.newBuilder().setPlatform(Platform.ios())
                    .setAudience(Audience.all())
                    .setNotification(Notification.newBuilder()
                            .addPlatformNotification(IosNotification.newBuilder()
                                    .setAlert(content)
                                    .build())
                            .build())
                    .setMessage(Message.newBuilder()
                            .setMsgContent(content)
                            .setTitle(title)
                            .build())
                    .setOptions(Options.newBuilder()
                            //此字段的值是用来指定本推送要推送的apns环境，false表示开发，true表示生产；对android和自定义消息无意义
                            .setApnsProduction(true)
                            //此字段是给开发者自己给推送编号，方便推送者分辨推送记录
                            .setSendno(1)
                            //此字段的值是用来指定本推送的离线保存时长，如果不传此字段则默认保存一天，最多指定保留十天，单位为秒
                            .setTimeToLive(86400)
                            .build())
                    .build();

            PushResult result=jPushClient.sendPush(payload);
        } catch (APIConnectionException e) {
            System.out.println("connection err");
            e.printStackTrace();
        } catch (APIRequestException e) {
            System.out.println("request error");
            e.printStackTrace();
        }
    }
    /**
     *z指定人员IOS平台
     * @param content
     * @param title
     * @throws Exception
     */
    public static void pushToIdsForIOS(String content,String title,List<String> ids) throws Exception {
        try {
            JPushClient jPushClient=new JPushClient(MASTER_SECRET,APPKEY);
            PushPayload payload=PushPayload.newBuilder().setPlatform(Platform.ios())
                    .setAudience(Audience.registrationId(ids))
                    .setNotification(Notification.newBuilder()
                            .addPlatformNotification(IosNotification.newBuilder()
                                    .setAlert(content)
                                    .incrBadge(1)
                                    .setSound("happy")
                                    .build())
                            .build())
                    .setMessage(Message.newBuilder()
                            .setMsgContent(content)
                            .setTitle(title)
                            .build())
                    .setOptions(Options.newBuilder()
                            //此字段的值是用来指定本推送要推送的apns环境，false表示开发，true表示生产；对android和自定义消息无意义
                            .setApnsProduction(true)
                            //此字段是给开发者自己给推送编号，方便推送者分辨推送记录
                            .setSendno(1)
                            //此字段的值是用来指定本推送的离线保存时长，如果不传此字段则默认保存一天，最多指定保留十天，单位为秒
                            .setTimeToLive(86400)
                            .build())
                    .build();

            PushResult result=jPushClient.sendPush(payload);
        } catch (APIConnectionException e) {
            System.out.println("connection err");
            e.printStackTrace();
        } catch (APIRequestException e) {
            System.out.println("request error");
            e.printStackTrace();
        }
    }
    /**
     *指定人员 Android平台
     * @param content
     * @param title
     * @throws Exception
     */
    public static void pushToIdsForAndroid(String content,String title,List<String> ids) throws Exception {
        try {
            JPushClient jPushClient=new JPushClient(MASTER_SECRET,APPKEY);
            PushPayload payload=PushPayload.newBuilder().setPlatform(Platform.android())
                    .setAudience(Audience.registrationId(ids))
                    .setNotification(Notification.newBuilder()
                            .setAlert(content)
                            .addPlatformNotification(AndroidNotification.newBuilder()
                                    .setTitle(title)
                                    .build())
                            .build())
                    .setOptions(Options.newBuilder()
                            //此字段的值是用来指定本推送要推送的apns环境，false表示开发，true表示生产；对android和自定义消息无意义
                            .setApnsProduction(true)
                            //此字段是给开发者自己给推送编号，方便推送者分辨推送记录
                            .setSendno(1)
                            //此字段的值是用来指定本推送的离线保存时长，如果不传此字段则默认保存一天，最多指定保留十天，单位为秒
                            .setTimeToLive(86400)
                            .build())
                    .build();

            PushResult result=jPushClient.sendPush(payload);
        } catch (APIConnectionException e) {
            System.out.println("connection err");
            e.printStackTrace();
        } catch (APIRequestException e) {
            System.out.println("request error");
            e.printStackTrace();
        }
    }
}

