package com.jn.hardware.model.dingtalk.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @ClassName：钉钉 : 用户角色
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/23 12:30
 * @Version： v1.0
 * @Modified By:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRole implements Serializable {

    private static final long serialVersionUID = -3221605523568091268L;

    /**
     * 角色id
    * */
    private String id;
    /**
     * 	角色名称
     * */
    private String name;
    /**
     * 角色组名称
     * */
    private String groupName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
