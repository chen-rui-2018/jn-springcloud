package com.jn.enterprise.servicemarket.product.dao;

import com.jn.enterprise.servicemarket.product.entity.TbServiceAndAdvisor;

import java.util.List;

/**
 * 服务顾问的关联操作
 * @author： chenr
 * @date： Created on 2019/2/15 11:30
 * @version： v1.0
 * @modified By:
 */
public interface ServiceAdvisorDao {
    /**
     * 服务和顾问关联插入
     * @param advisorList
     */
    void addServiceAdvisor(List<TbServiceAndAdvisor> advisorList);
}
