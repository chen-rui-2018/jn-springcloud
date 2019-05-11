package com.jn.enterprise.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author： chenr
 * @date： Created on 2019/02/13 15:04
 * @version： v1.0
 * @modified By:
 */
public enum ServiceProductExceptionEnum  implements CodeAndMsg {
    SERVICE_PRODUCT_NAME_EMPTY("5020201","服务产品名称不能为空!"),
    SERVICE_PRODUCT_SERIALNUMBER_EMPTY("5020202","服务产品编号不能为空!"),
    SERVICE_PRODUCT_REFER_PRICE_EMPTY("5020203","服务产品参考价格不能为空!"),
    SERVICE_PRODUCT_SERVICE_CYCLE_EMPTY("5020204","服务产品服务周期不能为空!"),
    SERVICE_PRODUCT_SIGNORY_ID_EMPTY("5020205","服务产品领域id不能为空!"),
    SERVICE_PRODUCT_SIGNORY_NAME_EMPTY("5020206","服务产品领域名称不能为空!"),
    SERVICE_PRODUCT_PRODUCT_TYPE_EMPTY("5020207","服务产品类型不能为空!"),
    SERVICE_PRODUCT_REFER_PRICE_WRONG_FORMAT("5020208","服务产品参考价格格式错误,只能为纯数字或数字范围'min-max'"),
    SERVICE_PRODUCT_REFER_PRICE_NUMBER_EXCEPTION("5020209","价格区间的最大值('-'后的值)不能比最小值('-'前的值)小!"),
    SERVICE_PRODUCT_ORG_ID_EMPTY("5020210","机构ID不能为空!"),
    SERVICE_PRODUCT_ID_EMPTY("5020211","服务产品ID不能为空!"),
    SERVICE_PRODUCT_APPROVALCOMMENTS_EMPTY("5020212","审批不通过时审批意见不能为空!"),
    SERVICE_PRODUCT_ADVISOR_ACCOUNT_EMPTY("5020214","顾问账号不能为空!"),
    SERVICE_PRODUCT_NAME_DUPLICATE("5020215","服务产品名称重复!"),
    SERVICE_PRODUCT_TEMPLE_ID_EMPTY("5020216","上架常规产品时模板id不能为空"),
    SERVICE_PRODUCT_ORG_OWNED_PRODUCT("5020217","机构已上架此产品"),
    SERVICE_PRODUCT_PRODUCT_SHELF("5020217","此产品已有机构上架,不能进行修改")
    ;


    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    ServiceProductExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

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
}
