package com.jn.hardware.model.dingtalk.user;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty("fetch_child")
    private Boolean fetchChild;
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



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getFetchChild() {
        return fetchChild;
    }

    public void setFetchChild(Boolean fetchChild) {
        this.fetchChild = fetchChild;
    }

    @Override
    public String toString() {
        return "DepartmentListParam{" +
                "lang='" + lang + '\'' +
                ", fetchChild=" + fetchChild +
                ", id='" + id + '\'' +
                '}';
    }
}
