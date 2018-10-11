package com.jn.system.model;

import java.io.Serializable;

/**
 * 新增角色
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
public class RoleAdd extends Role implements Serializable {

    private String[] resourcesId;


    public String[] getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(String[] resourcesId) {
        this.resourcesId = resourcesId;
    }


}