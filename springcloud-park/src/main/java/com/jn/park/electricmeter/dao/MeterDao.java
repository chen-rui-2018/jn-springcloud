package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricReading;
import com.jn.park.electricmeter.entity.TbElectricReadingSource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
     * @param taskBatch
     * @return
     */
    int updateDegreeDiff(@Param("taskBatch") String taskBatch);
}
