package com.jn.reconciliation.service.impl;

import com.jn.reconciliation.service.PayReconciliationMistakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationMistake;
import org.xxpay.dal.dao.mapper.generator.reconciliation.TbPayReconciliationMistakeMapper;

import java.util.List;

/**
 * @ClassName：对账差错接口实现类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/21 19:49
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class PayReconciliationMistakeServiceImpl implements PayReconciliationMistakeService {

    @Autowired
    private TbPayReconciliationMistakeMapper tbPayReconciliationMistakeMapper;

    /**
     * 批量保存差错记录
     *
     * @param mistakeList
     */
    @Override
    public void saveListDate(List<TbPayReconciliationMistake> mistakeList) {
        for (TbPayReconciliationMistake mistake : mistakeList) {
            tbPayReconciliationMistakeMapper.insert(mistake);
        }
    }

    /**
     * 根据id获取数据
     *
     * @param id
     * @return
     */
    @Override
    public TbPayReconciliationMistake getDataById(String id) {
        return tbPayReconciliationMistakeMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新
     * @param reconciliationMistake
     */
    @Override
    public void updateData(TbPayReconciliationMistake reconciliationMistake) {
        tbPayReconciliationMistakeMapper.updateByPrimaryKeySelective(reconciliationMistake);
    }


}
