package com.jn.hardware.enums.dingtalk;

import com.jn.common.api.CodeAndMsg;

/**
 * @ClassName：钉钉:通讯录事件回调类型
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/20 15:11
 * @Version： v1.0
 * @Modified By:
 */
public enum AddressBookEventTypeEnum implements CodeAndMsg {

    USER_ADD_ORG("user_add_org","通讯录用户增加"),
    USER_MODIFY_ORG("user_modify_org","通讯录用户更改"),
    USER_LEAVE_ORG("user_leave_org"," 通讯录用户离职"),
    ORG_DEPT_CREATE("org_dept_create","通讯录企业部门创建"),
    ORG_DEPT_MODIFY("org_dept_modify"," 通讯录企业部门修改"),
    ORG_DEPT_REMOVE("org_dept_remove","通讯录企业部门删除");

    private String code;

    private String message;

    AddressBookEventTypeEnum(String key, String message) {
        this.code = key;
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
