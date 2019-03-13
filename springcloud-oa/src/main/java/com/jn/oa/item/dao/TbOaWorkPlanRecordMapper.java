package com.jn.oa.item.dao;

import com.jn.oa.item.entity.TbOaWorkPlanRecord;
import com.jn.oa.item.entity.TbOaWorkPlanRecordCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOaWorkPlanRecordMapper {
    long countByExample(TbOaWorkPlanRecordCriteria example);

    int deleteByExample(TbOaWorkPlanRecordCriteria example);

    int insert(TbOaWorkPlanRecord record);

    int insertSelective(TbOaWorkPlanRecord record);

    List<TbOaWorkPlanRecord> selectByExample(TbOaWorkPlanRecordCriteria example);

    int updateByExampleSelective(@Param("record") TbOaWorkPlanRecord record, @Param("example") TbOaWorkPlanRecordCriteria example);

    int updateByExample(@Param("record") TbOaWorkPlanRecord record, @Param("example") TbOaWorkPlanRecordCriteria example);
}