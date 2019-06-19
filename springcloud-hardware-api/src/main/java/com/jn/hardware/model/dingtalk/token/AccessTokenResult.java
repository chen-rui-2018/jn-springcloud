package com.jn.hardware.model.dingtalk.token;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jn.hardware.model.dingtalk.BaseResult;

import java.io.Serializable;

/**
 * 钉钉：access_token实体bean
 * 正常情况下access_token有效期为7200秒，有效期内重复获取返回相同结果，并自动续期。
 * @Author： cm
 * @Date： Created on 2019/6/15 11:53
 * @Version： v1.0
 * @Modified By:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessTokenResult extends BaseResult implements Serializable {
    private static final long serialVersionUID = 7517373507699566065L;

    /**
     * access_token默认7200秒过期
     */
    public static final int expires_in = 7200;

    /**
     * access_token返回值
     */
    private String access_token;

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
                '}';
    }
}
