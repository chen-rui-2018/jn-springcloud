package com.jn.domain;

import java.io.Serializable;

/**
 * 下载实体
 *
 * @author： fengxh
 * @date： Created on 2018/12/6 15:15
 * @version： v1.0
 * @modified By:
 */
public class DownLoad implements Serializable {
    /**
     * 上传时的路径
     */
    private String url;
    /**
     * 是否为加密token
     */
    private Boolean isToken;

    public DownLoad(String url, Boolean isToken) {
        this.url = url;
        this.isToken = isToken;
    }

    public DownLoad() {
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Boolean getToken() {
        return isToken;
    }
    public void setToken(Boolean token) {
        isToken = token;
    }
    @Override
    public String toString() {
        return "DownLoad{" +
                "url='" + url + '\'' +
                ", isToken=" + isToken +
                '}';
    }
}
