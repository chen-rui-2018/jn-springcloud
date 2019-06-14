package com.jn.reconciliation.service;

import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationInterface;

import java.util.List;

/**
 * @ClassName：对账接口
 * @Descript：根据数据库有效的数据，进行批次对账
 * @Author： hey
 * @Date： Created on 2019/6/13 17:21
 * @Version： v1.0
 * @Modified By:
 */
public interface ReconciliationInterfaceService {

    /**
     * 获取有效的对账批次接口
    * */
    List<TbPayReconciliationInterface> getEffectiveList();
}
