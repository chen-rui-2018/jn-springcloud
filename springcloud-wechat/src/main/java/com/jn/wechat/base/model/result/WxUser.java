package com.jn.wechat.base.model.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.json.simple.JSONObject;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 微信用户信息
 *
 * @Author： cm
 * @Date： Created on 2019/1/7 17:23
 * @Version： v1.0
 * @Modified By:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WxUser implements Serializable {
    private static final long serialVersionUID = -9003889469412819918L;
    /**
     * 用户的唯一标识
     */
    private String openid;
    /**
     * //用户昵称
     */
    private String nickname;
    /**
     * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    private String sex;
    /**
     * 用户个人资料填写的省份
     */
    private String province;
    /**
     * 普通用户个人资料填写的城市
     */
    private String city;
    /**
     * 国家，如中国为CN
     */
    private String country;
    /**
     * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
     */
    private String headimgurl;
    /**
     * 语言
     */
    private String language;
    /**
     * 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
     */
    private String subscribe;
    /**
     * 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
     */
    private String subscribe_time;
    /**
     * 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）.
     */
    private String[] privileges;
    /**
     * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。详见：获取用户个人信息（UnionID机制）
     */
    private String unionid;
    /**
     * 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
     */
    private String remark;
    /**
     * 用户所在的分组ID
     */
    private String groupid;
    /**
     * 用户被打上的标签id列表
     */
    private Long[] tagid_list;
    /**
     * 授权方式snsapi_base / snsapi_userinfo
     */
    private String scope;
    /**
     * 获取不到userinfo返回的json
     */
    private JSONObject errorjson;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }

    public String getSubscribe_time() {
        return subscribe_time;
    }

    public void setSubscribe_time(String subscribe_time) {
        this.subscribe_time = subscribe_time;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public Long[] getTagid_list() {
        return tagid_list;
    }

    public void setTagid_list(Long[] tagid_list) {
        this.tagid_list = tagid_list;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public JSONObject getErrorjson() {
        return errorjson;
    }

    public void setErrorjson(JSONObject errorjson) {
        this.errorjson = errorjson;
    }

    public String[] getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String[] privileges) {
        this.privileges = privileges;
    }

    @Override
    public String toString() {
        return "WxUser{" +
                "openid='" + openid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", headimgurl='" + headimgurl + '\'' +
                ", language='" + language + '\'' +
                ", subscribe='" + subscribe + '\'' +
                ", subscribe_time='" + subscribe_time + '\'' +
                ", privileges=" + Arrays.toString(privileges) +
                ", unionid='" + unionid + '\'' +
                ", remark='" + remark + '\'' +
                ", groupid='" + groupid + '\'' +
                ", tagid_list=" + Arrays.toString(tagid_list) +
                ", scope='" + scope + '\'' +
                ", errorjson=" + errorjson +
                '}';
    }
}
