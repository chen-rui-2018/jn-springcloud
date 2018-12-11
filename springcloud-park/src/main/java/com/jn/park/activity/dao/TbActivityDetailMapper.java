package com.jn.park.activity.dao;

import com.jn.park.activity.entity.TbActivityDetail;
import com.jn.park.activity.entity.TbActivityDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbActivityDetailMapper {
    long countByExample(TbActivityDetailCriteria example);

    int deleteByExample(TbActivityDetailCriteria example);

    int deleteByPrimaryKey(String activityId);

    int insert(TbActivityDetail record);

    int insertSelective(TbActivityDetail record);

    List<TbActivityDetail> selectByExampleWithBLOBs(TbActivityDetailCriteria example);

    List<TbActivityDetail> selectByExample(TbActivityDetailCriteria example);

    TbActivityDetail selectByPrimaryKey(String activityId);

    int updateByExampleSelective(@Param("record") TbActivityDetail record, @Param("example") TbActivityDetailCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbActivityDetail record, @Param("example") TbActivityDetailCriteria example);

    int updateByExample(@Param("record") TbActivityDetail record, @Param("example") TbActivityDetailCriteria example);

    int updateByPrimaryKeySelective(TbActivityDetail record);

    int updateByPrimaryKeyWithBLOBs(TbActivityDetail record);
}