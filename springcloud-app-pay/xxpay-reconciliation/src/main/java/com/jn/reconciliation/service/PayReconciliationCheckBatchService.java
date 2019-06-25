package com.jn.reconciliation.service;

import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationCheckBatch;

import java.util.List;
import java.util.Map;


/**
 * @ClassName：对账批次接口
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/20 15:54
 * @Version： v1.0
 * @Modified By:
 */
public interface PayReconciliationCheckBatchService {

    /**
     * 保存
     * @param reconciliationBatch  对账批次实体类
     */
    void saveData(TbPayReconciliationCheckBatch reconciliationBatch);


    /**
     * 根据条件查询对账批次
     * @param  paramMap billDate 账单日期(格式 ：yyyy-MM-dd)
     * @param  paramMap createTime 创建时间 (格式 ：yyyy-MM-dd)
     * @param  paramMap interfaceCode 支付类型
     * @param  paramMap notInStatus 不在该状态内如：a,b
     * @param  paramMap inStatus 在该状态内如：a,b
     * */
     List<TbPayReconciliationCheckBatch> listByCondition(Map<String,Object> paramMap);
}
