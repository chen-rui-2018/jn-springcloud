package com.jn.reconciliation.service.impl;

import com.jn.reconciliation.service.PayReconciliationMistakeScratchPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationMistakeScratchPool;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationMistakeScratchPoolCriteria;
import org.xxpay.dal.dao.mapper.PayReconciliationMistakeScratchPoolMapper;
import org.xxpay.dal.dao.mapper.generator.reconciliation.TbPayReconciliationMistakeScratchPoolMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName：对账暂存池接口实现类
 * @Descript：
 *
 * @Author： hey
 * @Date： Created on 2019/5/21 10:29
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class PayReconciliationMistakeScratchPoolServiceImpl implements PayReconciliationMistakeScratchPoolService {


    @Autowired
    private TbPayReconciliationMistakeScratchPoolMapper tbPayReconciliationMistakeScratchPoolMapper;
    @Autowired
    private PayReconciliationMistakeScratchPoolMapper payReconciliationMistakeScratchPoolMapper;


    /**
     * 批量保存记录
     *
     * @param scratchPoolList
     */
    @Override
    public void savaListDate(List<TbPayReconciliationMistakeScratchPool> scratchPoolList) {
        for (TbPayReconciliationMistakeScratchPool record : scratchPoolList) {
            tbPayReconciliationMistakeScratchPoolMapper.insert(record);
        }
    }

    /**
     * 根据最大账期查询暂存池信息
     *
     * @param maxDate 最大账期
     */
    @Override
    public List<TbPayReconciliationMistakeScratchPool> listByMaxDate(String maxDate) {

        return payReconciliationMistakeScratchPoolMapper.listByMaxDate(maxDate);
    }

    /**
     * 从缓冲池中删除数据
     *
     * @param scratchPoolList
     */
    @Override
    public void deleteFromPool(List<TbPayReconciliationMistakeScratchPool> scratchPoolList) {
        for (TbPayReconciliationMistakeScratchPool record : scratchPoolList) {
            TbPayReconciliationMistakeScratchPoolCriteria example = new TbPayReconciliationMistakeScratchPoolCriteria();
            example.createCriteria().andIdEqualTo(record.getId());
            tbPayReconciliationMistakeScratchPoolMapper.deleteByExample(example);
        }
    }

    /**
     * 查询出缓存池中所有的数据
     *
     * @return
     */
    @Override
    public List<TbPayReconciliationMistakeScratchPool> listScratchPoolRecord() {

        TbPayReconciliationMistakeScratchPoolCriteria example = new TbPayReconciliationMistakeScratchPoolCriteria();
        return tbPayReconciliationMistakeScratchPoolMapper.selectByExample(example);
    }
}
