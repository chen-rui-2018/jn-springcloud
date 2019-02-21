package com.jn.wechat.base.model.template;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 模板消息
 *
 * @Author： cm
 * @Date： Created on 2019/1/24 14:12
 * @Version： v1.0
 * @Modified By:
 */
public class WxTemplateMessage implements Serializable {
    private static final long serialVersionUID = 8494027973381753241L;

    /**
     * 接收者openid
     */
    private String touser;

    /**
     * 模板ID
     */
    private String template_id;

    /**
     * 模板跳转链接（海外帐号没有跳转能力）
     */
    private String url;

    /**
     * 模板数据
     */
    private List<WxTemplateData> data = new ArrayList<>();

    public WxTemplateMessage addData(WxTemplateData datum) {
        if (this.data == null) {
            this.data = new ArrayList<>();
        }
        this.data.add(datum);
        return this;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<WxTemplateData> getData() {
        return data;
    }

    public void setData(List<WxTemplateData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WxTemplateMessage{" +
                "touser='" + touser + '\'' +
                ", template_id='" + template_id + '\'' +
                ", url='" + url + '\'' +
                ", data=" + data +
                '}';
    }
}
