package com.jn.reconciliation.service.impl;

import com.jn.reconciliation.service.ReconciliationInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xxpay.common.constant.PayConstant;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationInterface;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationInterfaceCriteria;
import org.xxpay.dal.dao.mapper.generator.reconciliation.TbPayReconciliationInterfaceMapper;

import java.util.List;

/**
 * @ClassName：对账接口
 * @Descript：根据数据库有效的数据，进行批次对
 * @Author： hey
 * @Date： Created on 2019/6/13 17:26
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class ReconciliationInterfaceServiceImpl implements ReconciliationInterfaceService {

    @Autowired
    private TbPayReconciliationInterfaceMapper interfaceMapper;


    /**
     * 获取有效的对账批次接口
     * */
    @Override
    public List<TbPayReconciliationInterface> getEffectiveList() {
        TbPayReconciliationInterfaceCriteria example = new TbPayReconciliationInterfaceCriteria();
        example.createCriteria().andStatusEqualTo(PayConstant.RECONCILIATION_INTERFACE_EFFECTIVE_STATUS);
        return interfaceMapper.selectByExample(example);
    }
}
