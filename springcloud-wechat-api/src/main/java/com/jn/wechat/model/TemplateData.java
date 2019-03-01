package com.jn.wechat.model;

import java.io.Serializable;

/**
 * 发送模板消息所需数据
 *
 * @Author： cm
 * @Date： Created on 2019/2/27 20:04
 * @Version： v1.0
 * @Modified By:
 */
public class TemplateData implements Serializable {

    private static final long serialVersionUID = 2701467255846462795L;

    /**
     * 对象模板data数据中key的值
     */
    private String value;

    /**
     * 对象模板data数据中key的值的字体颜色
     */
    private String color;

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

    @Override
    public String toString() {
        return "TemplateData{" +
                "value='" + value + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
