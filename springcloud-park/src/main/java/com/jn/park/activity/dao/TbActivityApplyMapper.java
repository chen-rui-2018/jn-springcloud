package com.jn.park.activity.dao;

import com.jn.park.activity.entity.TbActivityApply;
import com.jn.park.activity.entity.TbActivityApplyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbActivityApplyMapper {
    long countByExample(TbActivityApplyCriteria example);

    int deleteByExample(TbActivityApplyCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbActivityApply record);

    int insertSelective(TbActivityApply record);

    List<TbActivityApply> selectByExample(TbActivityApplyCriteria example);

    TbActivityApply selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbActivityApply record, @Param("example") TbActivityApplyCriteria example);

    int updateByExample(@Param("record") TbActivityApply record, @Param("example") TbActivityApplyCriteria example);

    int updateByPrimaryKeySelective(TbActivityApply record);

    int updateByPrimaryKey(TbActivityApply record);
}