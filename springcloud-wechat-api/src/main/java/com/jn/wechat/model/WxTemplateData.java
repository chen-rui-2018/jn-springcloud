package com.jn.wechat.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 模板数据
 *
 * @Author： cm
 * @Date： Created on 2019/1/24 14:17
 * @Version： v1.0
 * @Modified By:
 */
public class WxTemplateData implements Serializable {
    private static final long serialVersionUID = -1914472832072572505L;

    /**
     * 对应模板data数据中的key
     */
    @NotNull(message = "消息模板key不能为空")
    private String name;

    /**
     * 对象模板data数据中key的值
     */
    @NotNull(message = "消息模板value不能为空")
    private String value;
    /**
     * 对象模板data数据中key的值的字体颜色
     */
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public WxTemplateData() {
    }

    public WxTemplateData(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public WxTemplateData(String name, String value, String color) {
        this.name = name;
        this.value = value;
        this.color = color;
    }

    @Override
    public String toString() {
        return "WxTemplateData{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
