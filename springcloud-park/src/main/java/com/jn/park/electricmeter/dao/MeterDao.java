package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricReading;
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

    void insertReadingData(@Param("readings")  List<TbElectricReading> readings );
}
