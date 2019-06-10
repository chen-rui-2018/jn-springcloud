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
import com.jn.news.config.NewsSwitchProperties;
import com.jn.news.enums.NewsExceptionEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private NewsSwitchProperties newsSwitchProperties;

    private static String APP_KEY = JPushEnum.J_PUSH_APP_KEY.getMessage();
    private static String  MASTER_SECRET = JPushEnum.J_PUSH_MASTER_SECRET.getMessage();

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
        //判断app消息推送发送状态，如果是关闭状态则发送至配置的测试的ids
        ids = this.appSwitchJudge(ids);
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


    /**
     * 判断app消息推送发送状态，如果是关闭状态则发送至配置的测试的ids
     * @param ids
     * @return
     */
    public List<String> appSwitchJudge(List<String> ids) {
        //防止app消息推送不走mq，故在此判断是否开启邮件发送
        if(!newsSwitchProperties.getApp()) {
            logger.info("\napp消息推送开关未开启,如有需要请向组长申请开启.");
            //关闭状态，设置app消息推送接收者
            if(null == newsSwitchProperties.getIds() || newsSwitchProperties.getIds().size()==0) {
                throw new JnSpringCloudException(JPushExceptionEnum.JPUSH_SWITCH_NOTNULL_IDS);
            }
            ids = newsSwitchProperties.getIds();
        }
        return ids;
    }

}
