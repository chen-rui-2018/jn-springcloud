package com.jn.park.finance.service;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.finance.model.FinanceExpensesHistoryPageModel;
import com.jn.park.finance.model.FinanceExpensesPageModel;
import com.jn.park.finance.model.FinanceExpensesTypeNameModel;
import com.jn.park.finance.vo.FinanceExpendFinanceTypeVo;
import com.jn.park.finance.vo.FinanceExpendFindImportDataVo;
import com.jn.park.finance.vo.FinanceExpendImportDataVo;
import com.jn.system.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 支出录入
 * @author： tangry
 * @date： Created on 2019/3/11
 * @version： v1.0
 * @modified By:
 */
public interface FinanceExpensesService {

    /**
     * 支出录入查询分页查询
     * @param financeExpensesPageModel
     * @return
     */
    PaginationData findAll(FinanceExpensesPageModel financeExpensesPageModel);

    /**
     * 支出录入历史查询分页查询
     * @param financeExpensesHistoryPageModel
     * @return
     */
    PaginationData findHistoryAll(FinanceExpensesHistoryPageModel financeExpensesHistoryPageModel);


    /**
     * 导入
     * @param file 文件
     * @param user 用户信息
     * @return
     */
    List<FinanceExpendImportDataVo> importData(MultipartFile file, User user);


    /**
     * 查询本次导入的支出信息
     * @param excelId 批次号
     * @return
     */
    List<FinanceExpendFindImportDataVo> findImportData(String excelId);

    /**
     * 保存打标数据
     * @param feList
     * @param user
     * @return
     */
    Result saveMarkData(List<FinanceExpendFindImportDataVo> feList,User user);

    /**
     * 查询财务类型
     * @return
     */
    List<FinanceExpendFinanceTypeVo> selectFinanceType();

    /**
     * 根据导入的费用类型对比，看是否有相同的费用类型
     * @param costBeforeTypeName
     * @return
     */
    List<FinanceExpensesTypeNameModel> selectAfterTypeName(String costBeforeTypeName);
}
