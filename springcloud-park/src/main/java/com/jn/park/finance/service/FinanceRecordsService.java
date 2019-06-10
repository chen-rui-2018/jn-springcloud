package com.jn.park.finance.service;

import com.jn.common.model.PaginationData;
import com.jn.park.finance.model.FinanceRecordsFindAllModel;
import com.jn.park.finance.model.FinanceRecordsFindDetailModel;

/**
 * 财务备案
 * @author： tangry
 * @date： Created on 2019/3/20
 * @version： v1.0
 * @modified By:
 */
public interface FinanceRecordsService {

    /**
     * 备案项,需录入项等查询
     * @return
     */
    FinanceRecordsFindDetailModel findDetail();

    /**
     * 备案查询
     * @param financeRecordsFindAllModel
     * @return
     */
    PaginationData findAll(FinanceRecordsFindAllModel financeRecordsFindAllModel);
}
