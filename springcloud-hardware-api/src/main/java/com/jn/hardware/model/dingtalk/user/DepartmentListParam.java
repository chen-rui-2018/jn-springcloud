package com.jn.hardware.model.dingtalk.user;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 钉钉：获取部门列表信息入参实体类
 *
 * @Author： cm
 * @Date： Created on 2019/6/17 10:55
 * @Version： v1.0
 * @Modified By:
 */
public class DepartmentListParam implements Serializable {
    private static final long serialVersionUID = 327388957851304925L;

    /**
     * 不必填:通讯录语言（默认zh_CN，未来会支持en_US）
     */
    private String lang;
    /**
     * 不必填:是否递归部门的全部子部门，ISV微应用固定传递false
     */
    private String fetch_child;
    /**
     * 必填：父部门id（如果不传，默认部门为根部门，根部门ID为1）
     */
    private String id = "1";

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getFetch_child() {
        return fetch_child;
    }

    public void setFetch_child(String fetch_child) {
        this.fetch_child = fetch_child;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DepartmentListParam{" +
                "lang='" + lang + '\'' +
                ", fetch_child='" + fetch_child + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
