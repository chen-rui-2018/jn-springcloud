package com.jn.reconciliation.service;

import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationIdent;

import java.util.List;

/**
 * @ClassName：对账有效标识service
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/6 10:37
 * @Version： v1.0
 * @Modified By:
 */
public interface ReconciliationIdentService {

    /**
     * 根据 支付类型  查询出有效的对账标识
     * @param payType  支付类型
    * */
    List<TbPayReconciliationIdent> getListByPayType(String payType);
}
