package com.jn.enterprise.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * IBPS流程ID配置文件
 * @author： huxw
 * @date： Created on 2019-5-14 15:49:29
 * @version： v1.0
 * @modified By:
 */
@ConfigurationProperties(
    prefix = "jn.ibps.bpmnDefId"
)
@Component
@RefreshScope
public class IBPSDefIdConfig implements Serializable {

    // 企业招聘流程ID
    private String companyRecruit;

    // 编辑企业信息流程ID
    private String updateCompanyInfo;

    // 上架/编辑产品流程ID
    private String product;

    // 上架/编辑科技金融产品流程ID
    private String technologyProduct;

    public String getTechnologyProduct() {
        return technologyProduct;
    }

    public void setTechnologyProduct(String technologyProduct) {
        this.technologyProduct = technologyProduct;
    }

    public String getCompanyRecruit() {
        return companyRecruit;
    }

    public void setCompanyRecruit(String companyRecruit) {
        this.companyRecruit = companyRecruit;
    }

    public String getUpdateCompanyInfo() {
        return updateCompanyInfo;
    }

    public void setUpdateCompanyInfo(String updateCompanyInfo) {
        this.updateCompanyInfo = updateCompanyInfo;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
