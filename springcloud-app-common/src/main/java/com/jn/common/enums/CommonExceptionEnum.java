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

    UN_KNOW("9999","未知异常"),VALID_ERROR("9998","参数异常"),UN_AUTH("9997","鉴权失败"),FILE_ERROR("9996","文件上传异常"),
    NOT_NULL("8001","不能为空");
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
