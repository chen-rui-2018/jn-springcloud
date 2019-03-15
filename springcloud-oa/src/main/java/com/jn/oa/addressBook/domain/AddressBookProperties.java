package com.jn.oa.addressBook.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 通讯录配置类
 *
 * @author： shaobao
 * @date： Created on 2019/3/14 16:48
 * @version： v1.0
 * @modified By:
 **/
@ConfigurationProperties(
        prefix = "oa.addressbook.information"
)
@Component
@RefreshScope
public class AddressBookProperties {

    /**
     * 用户组id，用于获取园区分组用户
     */
    private String userGroupId;

    public String getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(String userGroupId) {
        this.userGroupId = userGroupId;
    }
}
