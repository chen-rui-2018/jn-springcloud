package com.jn.reconciliation.service;

import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationMistake;

import java.util.List;


/**
 * @ClassName：对账差错接口
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/20 15:54
 * @Version： v1.0
 * @Modified By:
 */
public interface PayReconciliationMistakeService {


    /**
     * 批量保存差错记录
     *
     * @param mistakeList
     */
    void saveListDate(List<TbPayReconciliationMistake> mistakeList);

    /**
     * 根据id获取数据
     *
     * @param id
     * @return
     */
    TbPayReconciliationMistake getDataById(Integer id);

    /**
     * 更新
     * @param reconciliationMistake
     */
    void updateData(TbPayReconciliationMistake  reconciliationMistake);

    /**
     * 根据创建时间获取未处理差错记录数
     * @param date（yyyy-mm-dd）
     */
    Long getMistakeNumByDate(String date);
}
