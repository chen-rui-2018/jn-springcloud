package com.jn.common.enums;


import com.jn.common.api.CodeAndMsg;

/**
 * Excel异常枚举
 *
 * @author： shenph
 * @date： Created on 2019/1/16 15:33
 * @version： v1.0
 * @modified By:
 */
public enum CommonExcelExceptionEnum implements CodeAndMsg {

    EXCEL_CREATE_FAIL("1000801","创建文件失败"),
    EXCEL_FORMAT_ERROR("1000802","文件格式错误");
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

    CommonExcelExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }




}
