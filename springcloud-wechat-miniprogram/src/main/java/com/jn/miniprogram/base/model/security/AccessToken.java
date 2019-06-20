package com.jn.miniprogram.base.model.security;

import java.io.Serializable;

/**
 * 微信通用接口凭证access_token对象
 *
 * @Author： cm
 * @Date： Created on 2019/1/17 15:37
 * @Version： v1.0
 * @Modified By:
 */
public class AccessToken implements Serializable {

    private static final long serialVersionUID = 5782760997215757417L;

    /**
     * 凭证access_token
     */
    private String access_token;

    /**
     * 凭证有效时间，单位：秒
     */
    private int expires_in = -1;

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "access_token='" + access_token + '\'' +
                ", expires_in=" + expires_in +
                '}';
    }
}
