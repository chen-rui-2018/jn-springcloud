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
    SERVICE_PRODUCT_TEMPLE_ID_EMPTY("5020216","常规产品模板id不能为空"),
    SERVICE_PRODUCT_ORG_OWNED_PRODUCT("5020217","机构已上架此产品"),
    SERVICE_PRODUCT_PRODUCT_SHELF("5020218","此产品已有机构上架,不能进行修改"),

    CURRENT_ACCOUNT_NOT_ORG_USER("5020219","当前用户不是机构用户"),
    CURRENT_ORG_PUBLISH_PRODUCT("5020220","当前机构已发布或正在审批该模板产品，请勿重复操作"),
    PRODUCT_TEMPLATE_NOT_EXIST("5020221","常规产品模板不存在"),
    PRODUCT_NOT_EXIST("5020222","查询的产品不存在或未通过审核"),
    PRODUCT_SEND_ERROR("5020223","编辑产品操作失败"),
    PRODUCT_SUBMIT_IBPS_ERROR("5020224","服务产品提交审核出错，请检查提交数据"),
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
