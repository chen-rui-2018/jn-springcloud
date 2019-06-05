package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.*;
import com.jn.park.electricmeter.model.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author： yangh
 * @date： Created on 2019/5/15 22:33
 * @version： v1.0
 * @modified By:
 */
@Repository
public interface MeterDao {

    /**
     * 保存电表的采集读数到源表中
     * @param readings
     */
    int insertReadingData(@Param("readings")  List<TbElectricReadingSource> readings );

    /**
     * 将源表中过滤的数据，写入到正式的读数表中
     * @param taskBatch
     * @return
     */
    int insertData(@Param("taskBatch") String taskBatch);

    /**
     * 更新正式表中的度数
     * @return
     */
    int updateDegreeDiff();

    /**
     * 删除一些数据【朱成报表使用】
     */
    void deleteElectricDay();
    /**
     * 插入一些数据【朱成报表使用】
     */
    void insertElectricDay();



    /*计价规则SQL*/

    /**
     * 保存计价规则内容
     * @param saveData
     */
    void saveRulesContent(@Param("saveData") List<TbElectricRulesContent> saveData);

    /**
     * 保存计价规则和企业之间的关系
     * @param saveData
     */
    void saveCompanyLinks(@Param("saveData") List<TbElectricPriceruleCompany> saveData);

    /**
     * 保存计价规则和企业之间每日的关系
     * @param saveData
     */
    void saveCompanyLinksInDay(@Param("saveData") List<TbElectricPriceruleCompanyInDay> saveData);

    /**
     * 保存企业和计价规则之间的每日关系表
     * @param day
     */
    void saveCompanyLinkInDay(@Param("day") Date day);

    /**
     * 检测企业是否需要进行电费不足预警
     * @param companyId
     */
    List<TbElectricCost> checkCompanyIsNeedWarning(@Param("companyId") String companyId);

    /**
     * saveWarningRecord
     */
    void saveWarningRecord(@Param("saveData") List<TbElectricWarningRecord> saveData);

    /**
     * 获取电表的业主集合
     * @param companyId
     * @param day
     * @return
     */
    List<String> getMeterHost(@Param("companyId") String companyId,@Param("day") Date day);

    /**
     * 获取企业的所有电表
     * @param companyId
     * @param day
     * @return
     */
    List<String> getElectricMeterByCompanyId(@Param("companyId") String companyId,@Param("day") Date day);

    /**
     * 获取企业的计价规则
     * @param companyId
     * @param day
     * @return
     */
    List<String> getRuleIdByCompanyId(@Param("companyId") String companyId,@Param("day") Date day);

    /**
     * 获取企业的电表用电量
     * @param meterCode
     * @param dealDate
     * @return
     */
    List<TbElectricReading> getDegreeByMeterCode(@Param("meterCode") String meterCode,@Param("dealDate") Date dealDate);

    /**
     * 获取一块电表当天按计价规则分组的费用
     * @param saveData
     * @return
     */
    void saveGroupLogs(@Param("saveData") List<TbElectricEnergyGroupLog> saveData);

    /**
     * 保存账单明细
     * @param saveData
     */
    void saveBillDetail(@Param("saveData") List<TbElectricEnergyBillDetail> saveData);

    /**
     * 保存表的每日业主关系
     * @param saveData
     */
    void saveMeterLinkInDay(@Param("saveData") List<TbElectricMeterCompanyDay> saveData);

    /**
     * 停电的企业
     */
    List<SwitchModel> stopElectric();

    /**
     * 有电的企业
     */
    List<SwitchModel> getElectric();

    /**
     * 查询所有企业的电表
     * @param companyId
     * @return
     */
    List<String> getHostsMeter(@Param("companyId") String companyId);

    /**
     * 保存电表转换的日志
     * @param saveData
     */
    void saveMeterSwitchLog(@Param("saveData") List<TbElectricMeterSwitchLog> saveData);

    //能耗统计
    /**
     * 分组统计
     * @return
     */
    List<GroupChartStatisticsModel> groupChart();

    /**
     * 分类统计
     * @return
     */
    List<GategaryEnergyStatisticsModel> categaryChart() ;

    /**
     * 趋势明细图
     * @param param
     * @return
     */
    List<TrendChartDetailStatisticsModel> trendChartDetail(TrendChartPageParam param) ;

    /**
     * 趋势图
     * @param param
     * @return
     */
    List<TrendChartStatisticsModel> trendChart(TrendChartParam param);

    /**
     * 今日用电情况
     * @param companyid
     * @return
     */
    List<ConditionElectro> todayelectro(@Param("companyid") String companyid);

    /**
     * 当月用电情况
     * @param companyid
     * @return
     */
    List<ConditionElectro> monthelectro(@Param("companyid") String companyid);

    /**
     * 今年用电情况
     * @param companyid
     * @return
     */
    List<YearElectro> yearelectro(@Param("companyid") String companyid);



}
