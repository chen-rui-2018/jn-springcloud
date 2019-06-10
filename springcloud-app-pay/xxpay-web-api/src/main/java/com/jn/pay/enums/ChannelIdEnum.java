package com.jn.pay.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @ClassName：支付渠道枚举类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/6 19:15
 * @Version： v1.0
 * @Modified By:
 */
public enum ChannelIdEnum implements CodeAndMsg {

    WX_JSAPI("WX_JSAPI", "微信公众号支付"),
    WX_NATIVE("WX_NATIVE", "微信原生扫码支付"),
    WX_APP("WX_APP", "微信APP支付"),
    WX_MWEB("WX_MWEB", "微信H5支付"),
    ALIPAY_MOBILE("ALIPAY_MOBILE", "支付宝移动支付"),
    ALIPAY_PC("ALIPAY_PC", "支付宝PC支付"),
    ALIPAY_WAP("ALIPAY_WAP", "支付宝H5支付"),
    ALIPAY_QR("ALIPAY_QR", "支付宝当面付之扫码支付"),
    WX_PROGRAM("WX_PROGRAM","微信小程序支付");
    private String code;
    private String message;

    ChannelIdEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }


    public static ChannelIdEnum getCode(String channelId) {
        ChannelIdEnum channelIdEnum = null;
        for (ChannelIdEnum channelType : values()) {
            if (channelType.getCode().equals(channelId)) {
                //获取指定的枚举
                channelIdEnum = channelType;
                break;
            }
        }

        return channelIdEnum;
    }
}
