package com.jn.pay.enums;

/**
 * @ClassName：商户枚举类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/7 11:15
 * @Version： v1.0
 * @Modified By:
 */
public enum MchIdEnum {
    //目前只有一个商户  后期可能存在多个
    MCH_BASE("10000000", "bkQfoOf@uQMIAvgv*Ud3V1HvhDXaSb%9","0YjfL7%&Xh10Imq7t2fp6ZC4DLhi@PhP");

    /**
     * 商户id
     */
    private String code;
    /**
     * 请求密钥
     */
    private String reqKey;
    /**
     * 响应密钥
     */
    private String rspKey;



    MchIdEnum(String code, String reqKey, String rspKey) {
        this.code = code;
        this.reqKey = reqKey;
        this.rspKey = rspKey;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReqKey() {
        return reqKey;
    }

    public void setReqKey(String reqKey) {
        this.reqKey = reqKey;
    }

    public String getRspKey() {
        return rspKey;
    }

    public void setRspKey(String rspKey) {
        this.rspKey = rspKey;
    }

    public static MchIdEnum getCode(String channelId) {
        MchIdEnum channelIdEnum = null;
        for (MchIdEnum channelType : values()) {
            if (channelType.getCode().equals(channelId)) {
                //获取指定的枚举
                channelIdEnum = channelType;
                break;
            }
        }

        return channelIdEnum;
    }
}
