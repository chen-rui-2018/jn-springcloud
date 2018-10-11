package com.jn.common.model;

/**
 * json的树形结构的数据数据
 *
 * @author： fengxh
 * @date： Created on 2018/9/20 15:31
 * @version： v1.0
 * @modified By:
 */
public class Attributes {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Attributes(String url) {
        super();
        this.url = url;
    }

    public Attributes() {

    }
}
