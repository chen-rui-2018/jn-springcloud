package com.jn.hardware.model.dingtalk.user;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @ClassName：钉钉：获取用户详情入参
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/23 12:06
 * @Version： v1.0
 * @Modified By:
 */
public class UserDetailsInfoParam implements Serializable {

    private static final long serialVersionUID = -8265840244081747151L;

    @NotBlank(message = "员工ID不能为空")
    private String userid;
    /**
     * 通讯录语言(默认zh_CN另外支持en_US)
     */
    private String lang = "";

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "UserInfoParam{" +
                "userid='" + userid + '\'' +
                ", lang='" + lang + '\'' +
                '}';
    }
}
