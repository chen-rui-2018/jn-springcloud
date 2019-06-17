package org.xxpay.common.enumm;

/**
 * 支付系统短信通知模板枚举
 * @author： hey
 * @date： Created on 2019/05/30 17:03
 * @version： v1.0
 * @modified By:
 */
public enum MessageNoticesTemplateEnums {

    RECONCILIATION_TEMPLATE("1007", "支付系统对账通知模板");


    private String code;
    private String message;

    MessageNoticesTemplateEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }


    public static MessageNoticesTemplateEnums getEnumByCode(String code) {
        MessageNoticesTemplateEnums enumBean = null;
        for (MessageNoticesTemplateEnums enumType : values()) {
            if (enumType.getCode().equals(code)) {
                //获取指定的枚举
                enumBean = enumType;
                break;
            }
        }

        return enumBean;
    }

}
