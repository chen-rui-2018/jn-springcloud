package com.jn.enterprise.pd.declaration.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 异常状态枚举
 *
 * @author： wzy
 * @date： Created on 2019/4/15 15:23
 * @version： v1.0
 * @modified By:
 */
public enum ExceptionStatusEnums implements CodeAndMsg {

    NOTICE_ID_NOT_NULL("5011301", "公告ID不能为空"),
    ITEMID_NOT_NULL("5011201", "预约项ID不能为空"),
    ITEMNAME_NOT_NULL("5011202", "预约项名称不能为空"),
    CONTACTNAME_NOT_NULL("5011203", "姓名不能为空"),
    CONTACTPHONE_NOT_NULL("5011204", "电话不能为空"),
    EMAIL_NOT_NULL("5011205", "邮箱不能为空"),
    DECLAREENTERPRISE_NOT_NULL("5011206", "申报企业不能为空"),
    DECLAREITEM_NOT_NULL("5011207", "申报项目名称不能为空"),
    DECLAREITEM_IS_NULL("5011208", "未查到符合条件的数据"),
    DECLAREITEM_IS_SUM_NULL("5011209", "查询数据异常，应该查询到1条，实际查询到多条"),
    DECLAREITEM_IS_SHEN("5011210", "您已预约申报过,请勿重复预约申报!")


    ;
    private String code;

    private String message;

    ExceptionStatusEnums(String code, String message) {
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
}
