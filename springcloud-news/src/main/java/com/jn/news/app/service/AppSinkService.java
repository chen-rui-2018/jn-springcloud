package com.jn.news.app.service;

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
     * @param ids     推送的目标id列表
     * @param platfromType 平台类型 ANDROID/IOS/null  如果为null 则发送给所有平台
     */
     void  pushMessage(String content, String title, List<String> ids, String platfromType);
}
