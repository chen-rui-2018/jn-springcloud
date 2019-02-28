package com.jn.news.vo;

import java.io.Serializable;
import java.util.Arrays;

/**
 * TODO：未添加类描述
 *
 * @Author： cm
 * @Date： Created on 2019/2/25 19:01
 * @Version： v1.0
 * @Modified By:
 */
public class SmsTemplateVo implements Serializable {
    private static final long serialVersionUID = -941425101719174970L;

    private String templateId;

    private String[] mobiles;

    private String[] contents;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String[] getMobiles() {
        return mobiles;
    }

    public void setMobiles(String[] mobiles) {
        this.mobiles = mobiles;
    }

    public String[] getContents() {
        return contents;
    }

    public void setContents(String[] contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "SmsTemplateVo{" +
                "templateId='" + templateId + '\'' +
                ", mobiles=" + Arrays.toString(mobiles) +
                ", contents=" + Arrays.toString(contents) +
                '}';
    }
}
