package com.jn.wechat.base.model.template;

import java.io.Serializable;

/**
 * 设置所属行业，每月可更改1次所选行业
 *
 * @Author： cm
 * @Date： Created on 2019/1/24 14:40
 * @Version： v1.0
 * @Modified By:
 */
public class WxTemplateIndustrySet implements Serializable {
    private static final long serialVersionUID = 3107938078668473144L;

    /**
     * 公众账号服务所处行业1
     */
    private String industry_id1;
    /**
     * 公众账号服务所处行业2
     */
    private String industry_id2;

    public String getIndustry_id1() {
        return industry_id1;
    }

    public void setIndustry_id1(String industry_id1) {
        this.industry_id1 = industry_id1;
    }

    public String getIndustry_id2() {
        return industry_id2;
    }

    public void setIndustry_id2(String industry_id2) {
        this.industry_id2 = industry_id2;
    }

    @Override
    public String toString() {
        return "WxTemplateIndustrySet{" +
                "industry_id1='" + industry_id1 + '\'' +
                ", industry_id2='" + industry_id2 + '\'' +
                '}';
    }
}
