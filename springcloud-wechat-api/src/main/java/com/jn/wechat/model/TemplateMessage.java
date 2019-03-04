package com.jn.wechat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 发送模板消息所需信息
 *
 * @Author： cm
 * @Date： Created on 2019/2/27 16:11
 * @Version： v1.0
 * @Modified By:
 */
public class TemplateMessage implements Serializable {

    private static final long serialVersionUID = 8959938639987950856L;

    /**
     * 接收者openid
     */
    private String toUser;

    /**
     * 模板id
     */
    private String templateId;

    /**
     * 模板跳转链接（海外帐号没有跳转能力）
     */
    private String url;

    /**
     * 模板数据
     */
    private List<TemplateData> templateDataList = new ArrayList<>();

    public TemplateMessage addData(TemplateData datum) {
        if (this.templateDataList == null) {
            this.templateDataList = new ArrayList<>();
        }
        this.templateDataList.add(datum);
        return this;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<TemplateData> getTemplateDataList() {
        return templateDataList;
    }

    public void setTemplateDataList(List<TemplateData> templateDataList) {
        this.templateDataList = templateDataList;
    }

    @Override
    public String toString() {
        return "TemplateMessage{" +
                "toUser='" + toUser + '\'' +
                ", templateId='" + templateId + '\'' +
                ", url='" + url + '\'' +
                ", templateDataList=" + templateDataList +
                '}';
    }
}

