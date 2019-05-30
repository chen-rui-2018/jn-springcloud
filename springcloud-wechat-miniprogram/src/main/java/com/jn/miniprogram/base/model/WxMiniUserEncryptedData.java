package com.jn.miniprogram.base.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 包括敏感数据在内的完整用户信息的加密数据
 *
 * @Author： cm
 * @Date： Created on 2019/3/15 14:49
 * @Version： v1.0
 * @Modified By:
 */
public class WxMiniUserEncryptedData implements Serializable {

    private static final long serialVersionUID = -3136103897927353398L;

    /**
     * 自定义登陆状态
     */
    @ApiModelProperty("自定义登陆状态")
    @NotNull(message = "自定义登陆状态字符串不能为空")
    private String loginStatusFlag;

    /**
     * 不包括敏感信息的原始数据字符串，用于计算签名
     */
    @ApiModelProperty("原始数据字符串，见微信小程序API wx.getUserInfo参数描述")
    @NotNull(message = "原始数据字符串不能为空")
    private String rawData;
    /**
     * 使用 sha1( rawData + sessionkey ) 得到字符串，用于校验用户信息
     */
    @ApiModelProperty("加密字符串，见微信小程序API wx.getUserInfo参数描述")
    @NotNull(message = "加密字符串不能为空")
    private String signature;
    /**
     * 包括敏感数据在内的完整用户信息的加密数据
     */
    @ApiModelProperty("用户加密信息，见微信小程序API wx.getUserInfo参数描述")
    @NotNull(message = "用户加密信息不能为空")
    private String encryptedData;
    /**
     * 加密算法的初始向量
     */
    @ApiModelProperty("加密算法的初始向量，见微信小程序API wx.getUserInfo参数描述")
    @NotNull(message = "加密算法的初始向量不能为空")
    private String iv;

    public String getLoginStatusFlag() {
        return loginStatusFlag;
    }

    public void setLoginStatusFlag(String loginStatusFlag) {
        this.loginStatusFlag = loginStatusFlag;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    @Override
    public String toString() {
        return "WxMiniUserEncryptedData{" +
                "loginStatusFlag='" + loginStatusFlag + '\'' +
                ", rawData='" + rawData + '\'' +
                ", signature='" + signature + '\'' +
                ", encryptedData='" + encryptedData + '\'' +
                ", iv='" + iv + '\'' +
                '}';
    }
}
