package com.jn.news.app.service;

import com.jn.news.app.model.JPushResult;

import java.util.List;

/**
 * 极光消息推送接口
 * @author： chenr
 * @date： Created on 2019/5/11 17:15
 * @version： v1.0
 * @modified By:
 */
public interface AppSinkService {
    /**
     * 消息推送
     * @param content 推送的消息内容
     * @param title   推送的消息标题
     * @param ids     推送的目标列表
     * @param pushType  推送方式（DEVICE：设备 TAG：标签）
     * @param platFromType 平台类型 ANDROID/IOS/null  如果为null 则发送给所有平台
     * @param noticeType 推送通知类型（ALL：全部 NOTICE：通知 MESSAGE：透传消息）
     * @param message 透传消息内容（用户APP处理业务）
     */
    JPushResult pushMessage(String content, String title, List<String> ids, String pushType, String platFromType,
                            String noticeType, String message);
}
