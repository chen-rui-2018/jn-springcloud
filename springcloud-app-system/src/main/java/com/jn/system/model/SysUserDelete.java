package com.jn.system.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author： shaobao
 * @date： Created on 2018/11/12 14:07
 * @version： v1.0
 * @modified By:
 **/
public class SysUserDelete implements Serializable {
    private static final long serialVersionUID = -2909828054438675570L;
    private String[] userIds;

    public SysUserDelete() {
    }

    public SysUserDelete(String[] userIds) {
        this.userIds = userIds;
    }

    public String[] getUserIds() {
        return userIds;
    }

    public void setUserIds(String[] userIds) {
        this.userIds = userIds;
    }

    @Override
    public String toString() {
        return "SysUserDelete{" +
                "userIds=" + Arrays.toString(userIds) +
                '}';
    }
}
