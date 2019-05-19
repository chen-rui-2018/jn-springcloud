package com.jn.enterprise.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * IBPS流程ID配置文件
 * @author： huxw
 * @date： Created on 2019-5-14 15:49:29
 * @version： v1.0
 * @modified By:
 */
@Configuration
public class IBPSDefIdConfig implements Serializable {

    // 企业招聘流程ID
    @Value("${ibps.bpmnDefId.companyRecruit}")
    private String companyRecruit;

    // 编辑企业信息流程ID
    @Value("${ibps.bpmnDefId.updateCompanyInfo}")
    private String updateCompanyInfo;

    // 上架/编辑产品流程ID
    @Value("${ibps.bpmnDefId.product}")
    private String product;

    // 上架/编辑科技金融产品流程ID
    @Value("${ibps.bpmnDefId.technologyProduct}")
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
