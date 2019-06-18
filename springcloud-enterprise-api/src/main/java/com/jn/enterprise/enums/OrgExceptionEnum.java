package com.jn.enterprise.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author： jiangyl
 * @date： Created on 2019/2/15 11:38
 * @version： v1.0
 * @modified By:
 */
public enum OrgExceptionEnum  implements CodeAndMsg {
    NETWORK_ANOMALY("5020901", "网络异常，请稍后重试。"),
    ORG_TIME_PARSE_ERROR("5020501", "时间转换错误，请核实时间为：yyyy-MM-dd。"),
    ORG_ID_IS_NOT_NULL("5020502", "机构ID不能为空"),
    USER_EXTENSION_IS_NULL("5020503","用户登录异常，请重新登录"),
    NON_OGR_USER("5020504","用户为非机构用户"),
    ACCOUNT_NOT_NULL("5020505","账号不能为空"),
    ORG_DATA_IS_ERROR("5020506", "机构状态为非审核中状态，请核实机构数据"),
    ORG_DATA_STATUS_IS_NOT_CHECKING("5020507", "机构状态非审核中，请核实数据"),
    COMMENT_ID_IS_NOT_NULL("5020508", "点评ID不能为空"),
    REQUIRE_IS_NOT_EXIT("5020509", "需求不存在，请核实数据"),
    PRE_VALUE_IS_NOT_NULL("5020510", "行业领域值不能为空"),
    PRE_ID_IS_NOT_NULL("5020511", "行业ID不能为空"),
    ORG_IS_NOT_EXIT("5020512", "机构不存在"),
    COMMENT_IS_EXIST("5020513", "该需求已评论，无需再次提交"),
    TEAM_ELEMENTS_IS_EXIST("5020514", "机构团队信息已存在，无需再次添加"),
    SAVE_ORG_BASIC_DATA_ERROR("5020515", "保存服务机构基本信息失败"),
    SAVE_ORG_LICENSE_DATA_ERROR("5020516", "保存服务机构资质信息失败"),
    SAVE_ORG_TEAM_DATA_ERROR("5020517", "保存服务机构团队信息失败"),
    SAVE_ORG_CONTACT_DATA_ERROR("5020518", "保存服务机构联系信息失败"),
    LOGIN_ACCOUNT_NOT_ORG_MANAGE("5020519","当前登录用户不是机构管理员，不能把顾问设为联系人"),
    ACCOUNT_NOT_ORG_ADVISOR("5020519","设为联系人的账号不是机构顾问"),
    ACCOUNT_NOT_ORG_CONTACT("5020520","取消联系人的账号不是机构联系人"),
    ORG_APPLY_PARAM_NOT_NULL("5020521","机构认证流程后置处理入参不能为空"),
    ORG_INFO_NOT_EXIST("5020522","机构信息在系统中不存在或已失效"),
    ORG_INFO_HAS_EXIST("5020523","当前用户信息已存在，请不要重复进行机构认证"),
    ORG_HONOR_NAME_NOT_NULL("5020524","机构荣誉资质名称不能为空"),
    ORG_NAME_NOT_NULL("5020525","机构名称不能为空"),
    SEARCH_TYPE_NOT_ALLOW("5020526","机构名称查询类型在系统中不存在"),
    ORG_ID_IS_NOT_EXIST("5020527","机构id在系统中不存在"),
    ;

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    OrgExceptionEnum(String code, String message) {
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
