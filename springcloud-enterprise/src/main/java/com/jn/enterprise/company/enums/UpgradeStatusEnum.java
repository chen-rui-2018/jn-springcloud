package com.jn.enterprise.company.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 用户认证状态枚举
 * @Author: huxw
 * @Date: 2019-6-20 09:12:44
 * @Version v1.0
 * @modified By:
 */
public enum UpgradeStatusEnum implements CodeAndMsg {

    UPGRADE_OK("0","允许认证", "允许认证"),
    UPGRADE_COMPANY("1","该账号正在认证企业中", "已认证企业或正在认证中"),
    UPGRADE_STAFF("2","该账号正在认证员工中", "已认证员工或正在认证中"),
    UPGRADE_ORG("3","该账号正在认证机构中", "已认证机构或正在认证中"),
    UPGRADE_INVESTOR("4","该账号正在认证投资人中", "已认证投资人或正在认证中"),
    UPGRADE_ADVISOR("5","该账号正在认证专员中", "已认证专员或正在认证中"),
    ;

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    // 发送邀请抛出的消息
    private String inviteMessage;

    UpgradeStatusEnum(String code, String message, String inviteMessage) {
        this.code = code;
        this.message = message;
        this.inviteMessage = inviteMessage;
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

    public String getInviteMessage() {
        return inviteMessage;
    }

    public void setInviteMessage(String inviteMessage) {
        this.inviteMessage = inviteMessage;
    }}
