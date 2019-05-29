package com.jn.miniprogram.base.model;

import java.io.Serializable;

/**
 * 小程序用户信息
 *
 * @Author： cm
 * @Date： Created on 2019/3/15 16:20
 * @Version： v1.0
 * @Modified By:
 */
public class WxMiniUserInfo implements Serializable {
    private static final long serialVersionUID = 3550969506169292058L;

    /**
     * 用户唯一标识
     */
    private String openId;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 性别
     */
    private String gender;
    /**
     * 所在地市语言
     */
    private String language;
    /**
     * 用户所在地市
     */
    private String city;
    /**
     * 用户所在省
     */
    private String province;
    /**
     * 用户所在国家
     */
    private String country;
    /**
     * 用户头像图片的 URL
     */
    private String avatarUrl;
    private String unionId;
    private Watermark watermark;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Watermark getWatermark() {
        return watermark;
    }

    public void setWatermark(Watermark watermark) {
        this.watermark = watermark;
    }

    public static class Watermark {
        private String timestamp;
        private String appid;

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }
    }
}
