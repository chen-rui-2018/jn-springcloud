package com.jn.enterprise.servicemarket.product.dao;

import com.jn.enterprise.servicemarket.product.entity.TbServiceAndAdvisor;
import com.jn.enterprise.servicemarket.product.model.AdvisorProductInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 服务专员的关联操作
 * @author： chenr
 * @date： Created on 2019/2/15 11:30
 * @version： v1.0
 * @modified By:
 */
public interface ServiceAdvisorDao {
    /**
     * 服务和专员关联插入
     * @param advisorList
     */
    void addServiceAdvisor(List<TbServiceAndAdvisor> advisorList);

    /**
     * 专员-服务产品列表
     * @param advisorAccount
     * @param productType
     * @param praise
     * @return
     */
    List<AdvisorProductInfo> advisorProductList(@Param("advisorAccount") String advisorAccount, @Param("productType") String productType, @Param("praise") String praise);
}
