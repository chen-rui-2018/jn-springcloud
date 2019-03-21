package com.jn.park.finance.dao;

import com.jn.park.finance.model.FinanceDocumentsFindAllModel;
import com.jn.park.finance.model.FinanceRecordsFindAllModel;
import com.jn.park.finance.model.FinanceRecordsFindDetailModel;
import com.jn.park.finance.vo.FinanceRecordsFindAllVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 财务备案
 * @author： tangry
 * @date： Created on 2019/3/20
 * @version： v1.0
 * @modified By:
 */
@Component("FinanceRecordsDao")
public interface FinanceRecordsDao {

    /**
     * 备案项,需录入项等查询
     * @return
     */
    FinanceRecordsFindDetailModel findDetail();

    /**
     * 财务文档查询
     * @param financeRecordsFindAllModel
     * @return
     */
    List<FinanceRecordsFindAllVo> findAll(FinanceRecordsFindAllModel financeRecordsFindAllModel );
}
