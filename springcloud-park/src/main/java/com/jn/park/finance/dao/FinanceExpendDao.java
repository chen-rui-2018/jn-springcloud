package com.jn.park.finance.dao;

import com.jn.park.finance.model.FinanceExpendHistoryPageModel;
import com.jn.park.finance.model.FinanceExpendPageModel;
import com.jn.park.finance.model.FinanceExpendTypeNameModel;
import com.jn.park.finance.vo.FinanceExpendFinanceTypeVo;
import com.jn.park.finance.vo.FinanceExpendFindImportDataVo;
import com.jn.park.finance.vo.FinanceExpendHistoryVo;
import com.jn.park.finance.vo.FinanceExpendVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 支出录入
 * @author： tangry
 * @date： Created on 2019/3/11
 * @version： v1.0
 * @modified By:
 */
@Component("FinanceExpendDao")
public interface FinanceExpendDao {
    /**
     * 支出录入分页查询
     * @param financeExpendPageModel
     * @return
     */
    List<FinanceExpendVo> findAll(FinanceExpendPageModel financeExpendPageModel);

    /**
     * 支出录入历史分页查询
     * @param financeExpendHistoryPageModel
     * @return
     */
    List<FinanceExpendHistoryVo> findHistoryAll(FinanceExpendHistoryPageModel financeExpendHistoryPageModel);


    /**
     * 导入
     * @param map 集合
     */
    void importData(Map<String,Object> map);

    /**
     * 查询本次导入的支出信息
     * @param excelId 批次号
     * @return
     */
    List<FinanceExpendFindImportDataVo> findImportData(@Param("excelId") String excelId);


    /**
     * 保存打标数据
     * @param map
     */
    void saveMarkData(Map<String,Object> map);

    /**
     * 查询财务类型
     * @return
     */
    List<FinanceExpendFinanceTypeVo> selectFinanceType();

    /**
     * 根据导入的费用类型对比，看是否有相同的费用类型
     * @param costBeforeTypeName 部门名称
     * @return
     */
    List<FinanceExpendTypeNameModel> selectAfterTypeName(@Param("costBeforeTypeName") String costBeforeTypeName);
}
