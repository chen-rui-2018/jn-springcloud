package com.jn.park.enviroment.dao;

import com.jn.park.enviroment.entity.TbEnviDeviceRecord;
import com.jn.park.enviroment.entity.TbEnviDeviceRecordCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbEnviDeviceRecordMapper {
    long countByExample(TbEnviDeviceRecordCriteria example);

    int deleteByExample(TbEnviDeviceRecordCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbEnviDeviceRecord record);

    int insertSelective(TbEnviDeviceRecord record);

    List<TbEnviDeviceRecord> selectByExample(TbEnviDeviceRecordCriteria example);

    TbEnviDeviceRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbEnviDeviceRecord record, @Param("example") TbEnviDeviceRecordCriteria example);

    int updateByExample(@Param("record") TbEnviDeviceRecord record, @Param("example") TbEnviDeviceRecordCriteria example);

    int updateByPrimaryKeySelective(TbEnviDeviceRecord record);

    int updateByPrimaryKey(TbEnviDeviceRecord record);
}