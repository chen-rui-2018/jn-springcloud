package com.jn.enterprise.servicemarket.product.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 服务产品 状态/类型常量枚举
 * @author： chenr
 * @date： Created on 2019/4/22 9:40
 * @version： v1.0
 * @modified By:
 */
public enum  ProductConstantEnum  implements CodeAndMsg {

    RECORD_STATUS_EFFECTIVE("1","记录状态(1:有效)"),
    RECORD_STATUS_INVALID("0","记录状态(0:无效/删除)"),
    PRODUCT_STATUS_EFFECTIVE("1","产品状态(1:有效/审核通过)"),
    PRODUCT_STATUS_APPROVAL("0","产品状态(0:待审核)"),
    PRODUCT_STATUS_INVALID("-1","(产品状态(-1:无效)"),
    PRODUCT_STATUS_APPROVAL_NOT_PASS("2","(产品状态(2:审核不通过)"),
    PRODUCT_COMMENT_TYPE("0","(产品类型(0:常规服务产品)"),
    PRODUCT_FEATURE_TYPE("1","(产品状态(1:特色服务产品)")
    ;



    private String  code;
    private String  message;
    ProductConstantEnum(String code,String message){
        this.code=code;
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
