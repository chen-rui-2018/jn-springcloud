package com.jn.park.gamtopic.dao;

import com.jn.park.gamtopic.entity.TbPersonCare;
import com.jn.park.gamtopic.entity.TbPersonCareCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPersonCareMapper {
    long countByExample(TbPersonCareCriteria example);

    int deleteByExample(TbPersonCareCriteria example);

    int deleteByPrimaryKey(String careId);

    int insert(TbPersonCare record);

    int insertSelective(TbPersonCare record);

    List<TbPersonCare> selectByExample(TbPersonCareCriteria example);

    TbPersonCare selectByPrimaryKey(String careId);

    int updateByExampleSelective(@Param("record") TbPersonCare record, @Param("example") TbPersonCareCriteria example);

    int updateByExample(@Param("record") TbPersonCare record, @Param("example") TbPersonCareCriteria example);

    int updateByPrimaryKeySelective(TbPersonCare record);

    int updateByPrimaryKey(TbPersonCare record);
}