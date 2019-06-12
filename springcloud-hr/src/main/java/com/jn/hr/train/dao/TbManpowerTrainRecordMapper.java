package com.jn.hr.train.dao;

import com.jn.hr.train.entity.TbManpowerTrainRecord;
import com.jn.hr.train.entity.TbManpowerTrainRecordCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerTrainRecordMapper {
    long countByExample(TbManpowerTrainRecordCriteria example);

    int deleteByExample(TbManpowerTrainRecordCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerTrainRecord record);

    int insertSelective(TbManpowerTrainRecord record);

    List<TbManpowerTrainRecord> selectByExample(TbManpowerTrainRecordCriteria example);

    TbManpowerTrainRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerTrainRecord record, @Param("example") TbManpowerTrainRecordCriteria example);

    int updateByExample(@Param("record") TbManpowerTrainRecord record, @Param("example") TbManpowerTrainRecordCriteria example);

    int updateByPrimaryKeySelective(TbManpowerTrainRecord record);

    int updateByPrimaryKey(TbManpowerTrainRecord record);
}