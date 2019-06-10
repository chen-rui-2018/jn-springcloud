package com.jn.miniprogram.base.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 微信公众号异常枚举
 *
 * @Author： cm
 * @Date： Created on 2019/1/23 10:50
 * @Version： v1.0
 * @Modified By:
 */
public enum WxExceptionEnums implements CodeAndMsg {

    WX_LOGIN_CODE_CHECK_FAIL("1400401","小程序登录凭证校验失败."),
    NOT_ALLOW_ACCESS_TOKEN("1400302","微信接口url参数中不允许有access_token."),
    JSON_PROCESS_FAIL("1400303","Json处理异常."),
    WX_NO_BING_USER("1400304","还未绑定微信用户信息"),
    GET_ENCRYPT_USER_INFO_FAIL("1400405","获取微信用户信息失败."),
    FAST_DFS_UPLOAD_FAIL("1400407","上传小程序二维码附件失败."),
    GET_WX_MINI_QR_CODE_FAIL("1400408","获取小程序码失败."),
    QR_CODE_CREATE_TEMP_FILE_FAIL("1400409","创建小程序码临时文件失败."),
    WX_USER_REGISTER_FAIL("1400410","微信注册绑定用户信息失败."),
    WX_GET_TOKEN_FAIL("1400411","获取TOKEN失败")
    ;
    private String code;
    private String message;

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    WxExceptionEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
