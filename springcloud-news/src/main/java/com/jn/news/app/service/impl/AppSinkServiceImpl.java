package com.jn.news.app.service.impl;

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
import com.jn.common.enums.CommonExceptionEnum;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.StringUtils;
import com.jn.news.app.enums.JPushEnum;
import com.jn.news.app.enums.JPushExceptionEnum;
import com.jn.news.app.model.JPushData;
import com.jn.news.app.model.JPushResult;
import com.jn.news.app.service.AppSinkService;
import com.jn.news.app.utils.JPushUtil;
import com.jn.news.enums.NewsExceptionEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/5/11 17:16
 * @version： v1.0
 * @modified By:
 */
@Service
public class AppSinkServiceImpl implements AppSinkService {

    Logger logger = LoggerFactory.getLogger(AppSinkServiceImpl.class);

    private static String APP_KEY = JPushEnum.J_PUSH_APP_KEY.getMessage();
    private static String  MASTER_SECRET = JPushEnum.J_PUSH_MASTER_SECRET.getMessage();

    /**
     * 消息推送
     * @param content 推送的消息内容
     * @param title   推送的消息标题
     * @param ids     推送的目标id列表
     * @param platFromType 平台类型 ANDROID/IOS/null  如果为null 则发送给所有平台
     */
    //@Override
    public void pushMessage(String content, String title, List<String> ids, String platFromType) {
        try {
            //所有人所有平台
            if (ids.isEmpty() && StringUtils.isBlank(platFromType)) {
                pushAll(content, title);
            }
            //指定人所有平台
            if (ids!=null && ids .size()>0  && StringUtils.isBlank(platFromType)) {
                pushAll(content, title, ids);
            }
            //所有人Android平台
            if(ids.isEmpty() && JPushEnum.J_PUSH_MASTER_ANDROID.getMessage().equals(platFromType)){
                pushAllForAndroid(content,title);
            }
            //指定人Android平台
            if(ids!=null && ids .size()>0   && JPushEnum.J_PUSH_MASTER_ANDROID.getMessage().equals(platFromType)){
                pushToIdsForAndroid(content,title,ids);
            }
            //所有人IOS平台
            if(ids.isEmpty() && JPushEnum.J_PUSH_MASTER_IOS.getMessage().equals(platFromType)){
                pushAllForIOS(content,title);
            }
            //指定人IOS平台
            if(ids!=null && ids .size()>0  && JPushEnum.J_PUSH_MASTER_IOS.getMessage().equals(platFromType)){
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
    private  void pushAll(String content,String title) throws Exception {
        try {
            JPushClient jPushClient=new JPushClient(MASTER_SECRET,APP_KEY);
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
    private  void pushAll(String content,String title,List<String> ids) throws Exception {
        try {
            JPushClient jPushClient=new JPushClient(MASTER_SECRET,APP_KEY);
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

            PushResult result = jPushClient.sendPush(payload);
            logger.info("极光推送返回result:{}", result.toString());
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
    private  void pushAllForAndroid(String content,String title) throws Exception {
        try {
            JPushClient jPushClient=new JPushClient(MASTER_SECRET,APP_KEY);
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
    private  void pushAllForIOS(String content,String title) throws Exception {
        try {
            JPushClient jPushClient=new JPushClient(MASTER_SECRET,APP_KEY);
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
    private  void pushToIdsForIOS(String content,String title,List<String> ids) throws Exception {
        try {
            JPushClient jPushClient=new JPushClient(MASTER_SECRET,APP_KEY);
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
    private void pushToIdsForAndroid(String content,String title,List<String> ids) throws Exception {
        try {
            JPushClient jPushClient=new JPushClient(MASTER_SECRET,APP_KEY);
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

    /**
     * 推送消息
     * @param title   推送的消息标题
     * @param content 推送的消息内容
     * @param ids     推送的目标列表
     * @param pushType  推送方式（DEVICE：设备 TAG：标签）
     * @param platFromType 平台类型 ANDROID/IOS/null  如果为null 则发送给所有平台
     * @param noticeType 推送通知类型（ALL：全部 NOTICE：通知 MESSAGE：透传消息）
     * @param message 透传消息内容（用户APP处理业务）
     */
    @Override
    public JPushResult pushMessage(String title, String content, List<String> ids, String pushType, String platFromType,
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
}
