package com.jn.park.wifi.dao;

import com.jn.common.model.Result;
import com.jn.park.wifi.entity.TbWifiHeatInfoRecord;
import com.jn.park.wifi.entity.TbWifiTowerHeatInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * WIFI热力图
 * <pre>
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/6/28
 * </pre>
 */
public interface WifiTowerHeatDao {

    /**
     * 统计各楼宇的热力图数据
     * @return
     */
    List<TbWifiTowerHeatInfo> recordGroupByBatchId(@Param("batchId") String batchId);

    /**
     * 批量插入采集记录
     * @param list
     * @return
     */
    int insertBatchRecord(@Param("list") List<TbWifiHeatInfoRecord> list);
}
