package com.jn.hardware.ding.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jn.hardware.model.dingtalk.BaseResult;

import java.io.Serializable;

/**
 * @ClassName：通讯录事件回调实体类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/20 16:19
 * @Version： v1.0
 * @Modified By:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressBookCallback extends BaseResult implements Serializable {

    private static final long serialVersionUID = 254200546564548636L;
    /**
     * 钉钉的加密签名，signature结合了开发者填写的token、请求中的timestamp、nonce参数、加密的消息体
    * */
    private String signature;
    /**
     * 时间戳
     * */
    private String timestamp;
    /**
     * 随机数
     * */
    private String nonce;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    @Override
    public String toString() {
        return "AddressBookCallback{" +
                "signature='" + signature + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", nonce='" + nonce + '\'' +
                '}';
    }
}
