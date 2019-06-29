package com.jn.wechat.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信开发所使用到的常量类.
 *
 * @Author： cm
 * @Date： Created on 2019/1/7 11:38
 * @Version： v1.0
 * @Modified By:
 */
public class WxConsts {

    /**
     * 微信推送过来的消息的类型，和发送给微信xml格式消息的消息类型.
     * 1、此类所有静态字符串常量将用于处理消息对应的handel类，不允许多个handel类使用同一个常量
     * 2、目前定义的消息类型不全，按需进行添加
     */
    public static class XmlMsgType {
        public static final String TEXT = "text";
        public static final String EVENT = "event";
    }

    /**
     * 微信端推送过来的事件类型.
     * 1、针对消息类似是event时，此类所有静态字符串常量将用于处理消息事件对应的handel类，不允许多个handel类使用同一个常量
     * 2、目前定义的消息类型不全，按需进行添加
     */
    public static class EventType {
        public static final String SUBSCRIBE = "subscribe";
        public static final String UNSUBSCRIBE = "unsubscribe";
        public static final String MENU_VIEW="VIEW";
    }

    /**
     * 自定义菜单的按钮类型.
     * 不全，按需添加
     */
    public static class MenuButtonType {
        /**
         * 点击推事件.
         */
        public static final String CLICK = "click";
        /**
         * 跳转URL.
         */
        public static final String VIEW = "view";
    }

    /**
     * oauth2网页授权的scope.
     */
    public static class OAuth2Scope {
        /**
         * 不弹出授权页面，直接跳转，只能获取用户openid.
         */
        public static final String SNSAPI_BASE = "snsapi_base";

        /**
         * 弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息.
         */
        public static final String SNSAPI_USERINFO = "snsapi_userinfo";

    }

}
