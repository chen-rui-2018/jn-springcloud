package com.jn.hardware.model.security;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/5/9 14:38
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SecurityPlayBackUrlShow", description = "获取监控点回放取流URL返回实体")
public class SecurityPlayBackUrlShow implements Serializable {

    private static final long serialVersionUID = -9045743762460183219L;
    @ApiModelProperty(value = "分页标记 标记本次查询的全部标识符，用于查询分片时的多次查询")
    private String  uuid;
    @ApiModelProperty(value = "取流短url")
    private String  url;
    @ApiModelProperty(value = "监控点回放取流URL 列表")
    List<SecurityPlayBackUrl>  list;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<SecurityPlayBackUrl> getList() {
        return list;
    }

    public void setList(List<SecurityPlayBackUrl> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "SecurityPlayBackUrlShow{" +
                "uuid='" + uuid + '\'' +
                ", url='" + url + '\'' +
                ", list=" + list +
                '}';
    }
}
