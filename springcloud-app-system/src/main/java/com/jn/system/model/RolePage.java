package com.jn.system.model;

import com.jn.common.model.Page;

import java.io.Serializable;

/**
 * 角色分页
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
public class RolePage extends Page implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 3582588209589180635L;
    private String id;

    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


}