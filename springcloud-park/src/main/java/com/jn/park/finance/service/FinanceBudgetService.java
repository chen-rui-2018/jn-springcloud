package com.jn.park.finance.service;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.finance.model.FinanceBudgetHistoryModel;
import com.jn.park.finance.model.FinanceBudgetHistoryQueryModel;
import com.jn.park.finance.model.FinanceBudgetQueryModel;
import com.jn.park.finance.vo.FinanceBudgetHistoryVo;
import com.jn.system.model.User;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * 预算录入service
 * @author： huangbq
 * @date： Created on 2019/3/4 14:41
 * @version： v1.0
 * @modified By:
 */
public interface FinanceBudgetService {

    /**
     * 总预算查询
     * @param financeBudgetQueryModel
     * @param userAccount
     * @return
     */
    Result totalList(FinanceBudgetQueryModel financeBudgetQueryModel, String userAccount);

    /**
     * 预算录入历史查询
     * @param financeBudgetHistoryQueryModel
     * @param userAccount
     * @return
     */
    PaginationData<List<FinanceBudgetHistoryVo>> historyList(FinanceBudgetHistoryQueryModel financeBudgetHistoryQueryModel, String userAccount);

    /**
     * 预算录入
     * @param financeBudgetHistoryVo
     * @param userAccount
     * @return
     */
    public Result add(FinanceBudgetHistoryVo financeBudgetHistoryVo, String userAccount) ;
}
