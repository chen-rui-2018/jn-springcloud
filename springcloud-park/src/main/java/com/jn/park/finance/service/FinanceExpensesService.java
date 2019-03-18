package com.jn.park.finance.service;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.finance.model.FinanceExpendHistoryPageModel;
import com.jn.park.finance.model.FinanceExpendPageModel;
import com.jn.park.finance.model.FinanceExpendTypeNameModel;
import com.jn.park.finance.vo.FinanceExpendFinanceTypeVo;
import com.jn.park.finance.vo.FinanceExpendFindImportDataVo;
import com.jn.park.finance.vo.FinanceExpendImportDataVo;
import com.jn.system.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

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
     * @param financeExpendPageModel
     * @return
     */
    PaginationData findAll(FinanceExpendPageModel financeExpendPageModel);

    /**
     * 支出录入历史查询分页查询
     * @param financeExpendHistoryPageModel
     * @return
     */
    PaginationData findHistoryAll(FinanceExpendHistoryPageModel financeExpendHistoryPageModel);


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
    List<FinanceExpendTypeNameModel> selectAfterTypeName(String costBeforeTypeName);
}
