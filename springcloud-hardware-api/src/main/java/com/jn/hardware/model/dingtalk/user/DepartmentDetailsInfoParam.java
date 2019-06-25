package com.jn.hardware.model.dingtalk.user;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @ClassName： 钉钉 ：获取部门详情入参实体类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/23 14:40
 * @Version： v1.0
 * @Modified By:
 */
public class DepartmentDetailsInfoParam implements Serializable {

    private static final long serialVersionUID = 1478056648389945967L;

    @NotBlank(message = "部门ID不能为空")
    private String id;
    /**
     * 通讯录语言(默认zh_CN另外支持en_US)
     */
    private String lang = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "DepartmentDetailsInfoParam{" +
                "id='" + id + '\'' +
                ", lang='" + lang + '\'' +
                '}';
    }
}
