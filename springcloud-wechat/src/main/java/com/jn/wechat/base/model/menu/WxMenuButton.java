package com.jn.wechat.base.model.menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 按钮
 * @Author： cm
 * @Date： Created on 2019/1/21 16:25
 * @Version： v1.0
 * @Modified By:
 */
public class WxMenuButton implements Serializable {

    private static final long serialVersionUID = 2499469139873635681L;

    /**
     * 菜单的响应动作类型.
     * view表示网页类型，
     * click表示点击类型，
     * miniprogram表示小程序类型
     */
    private String type;

    /**
     * 菜单标题，不超过16个字节，子菜单不超过60个字节.
     */
    private String name;

    /**
     * 菜单KEY值，用于消息接口推送，不超过128字节.
     * click等点击类型必须
     */
    private String key;

    /**
     * 网页链接.
     * 用户点击菜单可打开链接，不超过1024字节。type为miniprogram时，不支持小程序的老版本客户端将打开本url。
     * view、miniprogram类型必须
     */
    private String url;

    private List<WxMenuButton> sub_button = new ArrayList<>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<WxMenuButton> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<WxMenuButton> sub_button) {
        this.sub_button = sub_button;
    }

    @Override
    public String toString() {
        return "WxMenuButton{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", url='" + url + '\'' +
                ", sub_button=" + sub_button +
                '}';
    }
}
