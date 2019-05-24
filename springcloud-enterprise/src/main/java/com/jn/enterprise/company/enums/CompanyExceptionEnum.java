package com.jn.enterprise.company.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 企业服务异常枚举
 * @Author: huxw
 * @Date: 2019-4-9 11:22:18
 * @Version v1.0
 * @modified By:
 */
public enum CompanyExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("5020901", "网络异常，请稍后重试。"),
    USER_LOGIN_IS_INVALID("5020503","登录已失效，请重新登录"),
    USER_IS_COMPANY_EXIST("5020580","该用户已是员工账号或有待处理的企业邀请，不能再次邀请"),
    USER_IS_NOT_EXIST("5020581","用户不存在"),
    USER_IS_NOT_COMPANY_ADMIN("5020582","用户不是企业管理员"),
    USER_NO_STAFF("5020583","用户非企业用户"),
    ACCOUNT_LIST_IS_NULL("5020584","账号列表不能为空"),
    USER_IS_NOT_COMPANY_ADMIN_OR_CONTACTS("5020585","用户不是企业管理员或企业联系人，没有操作权限"),
    ACCOUNT_NOT_GET_INVITE("5020586","该账号未收到企业邀请"),
    USER_NOT_HAS_PERMISSIONS("5020587","用户没有操作权限"),
    ACCOUNT_IS_CURRENT_COMPANY_CONTACTS_NOW("5020588","该账号已经是企业联系人"),
    ACCOUNT_IS_NOT_CURRENT_COMPANY_CONTACTS("5020589","该账号不是企业联系人"),
    USER_NOT_INVITE_AGAIN("5020590","员工不符合再次邀请条件"),
    PARAM_IS_NULL("5020591","请求参数不能为空"),
    COMPANY_CHECK_ING("5020592","企业信息正在审核中，请勿重复提交"),
    COMPANY_CHECK_ERROR("5020593","企业信息提交审核出错，请检查提交数据"),
    USER_IS_COMPANY_ADMIN("5020594","该账号是企业管理员，不能发出邀请"),
    GET_USER_EXTENSION_INFO_ERROR("5020595","获取用户信息发生错误"),
    UPDATE_USER_EXTENSION_INFO_ERROR("5020596","更新用户信息发生错误"),

    CALL_SYSTEM_SERVICE_ERROR("5020401","调用system服务出错"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    CompanyExceptionEnum(String code, String message) {
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
