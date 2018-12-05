package com.jn.portals.activity.dao;

import com.jn.portals.activity.entity.TbActivityApply;
import com.jn.portals.activity.entity.TbActivityApplyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbActivityApplyMapper {
    long countByExample(TbActivityApplyCriteria example);

    int deleteByExample(TbActivityApplyCriteria example);

    int insert(TbActivityApply record);

    int insertSelective(TbActivityApply record);

    List<TbActivityApply> selectByExample(TbActivityApplyCriteria example);

    int updateByExampleSelective(@Param("record") TbActivityApply record, @Param("example") TbActivityApplyCriteria example);

    int updateByExample(@Param("record") TbActivityApply record, @Param("example") TbActivityApplyCriteria example);
}