package com.jn.portals.activity.dao;

import com.jn.portals.activity.entity.TbActivityLike;
import com.jn.portals.activity.entity.TbActivityLikeCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbActivityLikeMapper {
    long countByExample(TbActivityLikeCriteria example);

    int deleteByExample(TbActivityLikeCriteria example);

    int insert(TbActivityLike record);

    int insertSelective(TbActivityLike record);

    List<TbActivityLike> selectByExample(TbActivityLikeCriteria example);

    int updateByExampleSelective(@Param("record") TbActivityLike record, @Param("example") TbActivityLikeCriteria example);

    int updateByExample(@Param("record") TbActivityLike record, @Param("example") TbActivityLikeCriteria example);
}