package com.jn.reconciliation.service.impl;

import com.jn.reconciliation.service.ReconciliationIdentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xxpay.common.constant.PayConstant;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationIdent;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationIdentCriteria;
import org.xxpay.dal.dao.mapper.generator.reconciliation.TbPayReconciliationIdentMapper;
import org.xxpay.dal.dao.model.PayOrderExample;

import java.util.List;

/**
 * @ClassName：
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/6 10:41
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class ReconciliationIdentImpl implements ReconciliationIdentService {

    @Autowired
    private TbPayReconciliationIdentMapper tbPayReconciliationIdentMapper;

    /**
     * 根据 支付类型  查询出有效的对账标识
     * @param payType  支付类型
     * */
    @Override
    public List<TbPayReconciliationIdent> getListByPayType(String payType) {
        TbPayReconciliationIdentCriteria example = new TbPayReconciliationIdentCriteria();
        TbPayReconciliationIdentCriteria.Criteria criteria = example.createCriteria();
        //支付类型
        criteria.andPayTypeEqualTo(payType);
        //状态有效的
        criteria.andStatusEqualTo(PayConstant.RECONCILIATION_IDENT_EFFECTIVE_STATUS);
        return tbPayReconciliationIdentMapper.selectByExample(example);
    }



}
