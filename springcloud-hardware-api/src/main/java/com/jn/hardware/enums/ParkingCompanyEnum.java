package com.jn.hardware.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * TODO：未添加类描述
 *
 * @Author： cm
 * @Date： Created on 2019/4/18 9:23
 * @Version： v1.0
 * @Modified By:
 */
public enum ParkingCompanyEnum implements CodeAndMsg {

    DOOR_COMPANY("1", "道尔公司"),
    FUSHI_COMPANY("2", "富士公司"),
    ALL_COMPANY("9", "全部"),
    SIGNATURE_KEY ("SIGNATURE_KEY", "R7ZPB6EEZZZGE762BJC57PW68ZXX3SNH"),
    REPLACE_ALL ("&quot;", "将转义的\" 转换为\""),
    REPLACE_ALL_SLASH ("\\\\", "将转义的单 转换为双斜杠"),
    REPLACE_PAY_DATE_U ("PayDate", "首字母大写转换为小写"),
    REPLACE_PAY_DATE_L ("payDate", "首字母大写转换为小写");



    private String code;
    private String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    ParkingCompanyEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
