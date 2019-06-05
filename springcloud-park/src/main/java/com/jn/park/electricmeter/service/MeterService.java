package com.jn.park.electricmeter.service;

import com.jn.common.model.Result;
import com.jn.hardware.model.electricmeter.ElectricMeterDataCollectionParam;
import com.jn.hardware.model.electricmeter.ElectricMeterWaterOrElectricShow;
import com.jn.park.electricmeter.model.MeterInfoModel;
import com.jn.park.electricmeter.model.TodayElectro;
import com.jn.park.electricmeter.model.TrendChartPageParam;
import com.jn.park.electricmeter.model.TrendChartParam;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

/**
 * @author： yangh
 * @date： Created on 2019/5/15 11:26
 * @version： v1.0
 * @modified By:
 */

public interface MeterService {

    /**
     * 电表数据采集接口
     */
    void getDataFromHardare();

    /**
     * 保存流程
     * @param dataList
     * @param dealDate
     * @param hour
     * @return
     */
    public Result saveData(List<ElectricMeterWaterOrElectricShow> dataList, Date dealDate, String hour, String taskBatch);


    /**
     * 手动处理指定的电表读数定时入库失败的数据
     * @param dealDate
     * @param dealHour
     */
    void dealSomeOneFailByHandle(Date dealDate,String dealHour);

    /**
     * 手动处理所有电表读数定时入库失败的数据
     */
    Result dealAllFailByHandle();


    /**
     * 电表业主维护
     * @param user
     * @param model
     * @return
     */
    Result insertMeterInfo(User user, MeterInfoModel model);

    /**
     * 电表信息作废
     * @param id
     * @return
     */
    Result deleteMeterInfo(User user,String id);

    /**
     * 电表信息更新
     * @param user
     * @param model
     * @return
     */
    Result updateMeterInfo(User user, MeterInfoModel model);

    /**
     * 电表每日的业主信息日志
     */
    void setHostForMeter();


    /**
     * 分组统计图表
     * @return
     */
    Result groupChart();

    /**
     * 分类统计图表
     * @return
     */
    Result categaryChart();

    /**
     * 趋势明细图表
     * @param param
     * @return
     */
    Result trendChartDetail(@RequestBody @Validated TrendChartPageParam param);

    /**
     * 趋势图表
     * @param param
     * @return
     */
    Result trendChart(TrendChartParam param);


    /**
     * 今日用电情况
     * @param companyid
     * @return
     */
    Result todayelectro(String companyid);

    /**
     * 本月用电情况
     * @param companyid
     * @return
     */
    Result monthelectro(String companyid);

    /**
     * 今年用电情况
     * @param companyid
     * @return
     */
    Result yearelectro(String companyid);



}
