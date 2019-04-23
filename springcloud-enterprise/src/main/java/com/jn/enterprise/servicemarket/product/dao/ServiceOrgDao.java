package com.jn.enterprise.servicemarket.product.dao;

import com.jn.enterprise.servicemarket.product.model.OrgCountProductInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/15 11:49
 * @version： v1.0
 * @modified By:
 */
public interface ServiceOrgDao {
    /**
     * 机构(查看)-服务产品列表
     * @param orgId
     * @param productType
     * @param praise
     * @return
     */

    List<OrgCountProductInfo>  findOrgCountProductList(@Param("orgId") String orgId, @Param("productType") String productType, @Param("praise") String praise);
}
