package com.jn.reconciliation.service;

import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationNoticeUser;

import java.util.List;


/**
 * @ClassName：对账通知service
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/20 15:54
 * @Version： v1.0
 * @Modified By:
 */
public interface ReconciliationNoticeUserService {

    /**
     * 查询通知状态为有效的用户
    * */
    List<TbPayReconciliationNoticeUser> getEffectiveUserList();
}
