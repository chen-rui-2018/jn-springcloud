package com.jn.common.enums;


import com.jn.common.api.CodeAndMsg;

/**
 * 公共异常枚举
 *
 * @author： fengxh
 * @date： Created on 2018/9/20 16:21
 * @version： v1.0
 * @modified By:
 */
public enum CommonExceptionEnum implements CodeAndMsg {

    UN_KNOW("1000999","未知异常"),
    ARGS_ERROR("1000200","参数不合法"),
    UN_AUTH("1000201","鉴权失败"),
    FILE_ERROR("1000202","文件传输异常"),
    EMAIL_ERROR("1000301","邮件发送异常");
    /**
     * 编码
     */
   private String code;
    /**
     * 信息
     */
   private String message;
    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    CommonExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }




}
