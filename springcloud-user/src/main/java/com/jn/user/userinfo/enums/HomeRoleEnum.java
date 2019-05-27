package com.jn.user.userinfo.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 门户可展示用户角色
 * @Author: huxw
 * @Date: 2019-5-25 15:41:41
 * @Version v1.0
 * @modified By:
 */
public enum HomeRoleEnum implements CodeAndMsg {

    NORMAL_USER("普通用户","NORMAL_USER"),
    INVESTOR_USER("投资人","INVESTOR_USER"),

    ORG_ADMIN("机构管理员","ORG_ADMIN"),
    ORG_CONTACTS("机构联系人","ORG_CONTACTS"),
    ORG_ADVISER("机构顾问","ORG_ADVISER"),

    COM_ADMIN("企业管理员","COM_ADMIN"),
    COM_CONTACTS("企业联系人","COM_CONTACTS"),
    COM_EMPLOYEE("企业员工","COM_EMPLOYEE"),
    ;

    /**
     * 编码
     */
    private String code;

    /**
     * 信息
     */
    private String message;

    HomeRoleEnum(String code, String message) {
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
