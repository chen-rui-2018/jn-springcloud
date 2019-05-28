package com.jn.miniprogram.base.model;

import java.io.Serializable;

/**
 * 登录凭证校验，通过 wx.login() 接口获得临时登录凭证 code 后传到开发者服务器调用此接口完成登录流程
 *
 * @Author： cm
 * @Date： Created on 2019/3/12 19:50
 * @Version： v1.0
 * @Modified By:
 */
public class WxMiniJscode2SessionResult implements Serializable {

    private static final long serialVersionUID = -7526930796162186438L;
    /**
     * 用户唯一标识
     */
    private String openid;
    /**
     * 会话密钥
     */
    private String session_key;
    /**
     * 用户在开放平台的唯一标识符
     */
    private String uinionid;
    /**
     * 错误码
     */
    private String errcode;
    /**
     * 错误信息
     */
    private String errMsg;

    public WxMiniJscode2SessionResult() {
    }

    public WxMiniJscode2SessionResult(String openid,String session_key) {
        this.openid = openid;
        this.session_key = session_key;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getUinionid() {
        return uinionid;
    }

    public void setUinionid(String uinionid) {
        this.uinionid = uinionid;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "WxMiniJscode2SessionResult{" +
                "openid='" + openid + '\'' +
                ", session_key='" + session_key + '\'' +
                ", uinionid='" + uinionid + '\'' +
                ", errcode='" + errcode + '\'' +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
