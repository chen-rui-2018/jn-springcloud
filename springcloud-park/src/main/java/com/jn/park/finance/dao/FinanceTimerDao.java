package com.jn.park.finance.dao;

import com.jn.park.finance.model.FinanceIncomeGetDaysModel;
import com.jn.park.finance.model.FinanceIncomeUpdateMonthModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author: tangry
 * @Date: 2019/3/21
 * @Version 1.0
 */
@Component("FinanceTimerDao")
public interface FinanceTimerDao {


    /**
     * 查询收入情况字典状态
     * @param dicKey 字典名称
     * @return
     */
    String getDictionaryStatus(@Param("dicKey") String dicKey);

    /**
     * 更新数据到月表
     * @param map 数据集合
     */
    void saveSummarizing(Map<String,Object> map);

    /**
     * 逻辑删除最大的账期
     * @param dicValue
     * @param dicKey
     */
    void  updateDictionary(@Param("dicValue") String dicValue,@Param("dicKey") String dicKey);

    /**
     * 新增字典变最大账期
     * @param dicValue
     * @param dicKey
     */
    void  insertDictionary(@Param("dicValue") String dicValue,@Param("dicKey") String dicKey);

    /**
     * 保存每天获取到的数据
     * @param map
     */
    void getDaysData(Map<String,Object> map);

    /**
     * 根据账期汇总月数据
     * @param maxValue 账期
     * @param lastYear 去年同期账期
     * @return
     */
    List<FinanceIncomeUpdateMonthModel>  selectSummarizing(@Param("maxValue") String maxValue, @Param("lastYear") String lastYear);
}
