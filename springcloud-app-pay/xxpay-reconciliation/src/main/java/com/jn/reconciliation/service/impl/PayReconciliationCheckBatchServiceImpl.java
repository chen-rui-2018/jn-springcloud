package com.jn.reconciliation.service.impl;

import com.jn.reconciliation.service.PayReconciliationCheckBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationCheckBatch;
import org.xxpay.dal.dao.mapper.PayReconciliationCheckBatchMapper;
import org.xxpay.dal.dao.mapper.generator.reconciliation.TbPayReconciliationCheckBatchMapper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @ClassName：对账批次接口实现类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/20 15:54
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class PayReconciliationCheckBatchServiceImpl implements PayReconciliationCheckBatchService {

    @Autowired
    private PayReconciliationCheckBatchMapper payReconciliationCheckBatchMapper;

    @Autowired
    private TbPayReconciliationCheckBatchMapper tbPayReconciliationCheckBatchMapper;


    /**
     * 保存
     * @param reconciliationBatch  对账批次实体类
     */
    @Override
    public void saveData(TbPayReconciliationCheckBatch reconciliationBatch) {
        reconciliationBatch.setCreateTime(new Date());
        tbPayReconciliationCheckBatchMapper.insert(reconciliationBatch);
    }

    /**
     * 根据条件查询对账批次
     * @param  paramMap billDate 账单日期(格式 ：yyyy-MM-dd)
     * @param  paramMap createTime 创建时间 (格式 ：yyyy-MM-dd)
     * @param  paramMap interfaceCode 支付类型
     * @param  paramMap notInStatus 不在该状态内如：a,b
     * @param  paramMap inStatus 在该状态内如：a,b
     * */
    @Override
    public List<TbPayReconciliationCheckBatch> listByCondition(Map<String,Object> paramMap) {
        return payReconciliationCheckBatchMapper.listByCondition(paramMap);
    }
}
