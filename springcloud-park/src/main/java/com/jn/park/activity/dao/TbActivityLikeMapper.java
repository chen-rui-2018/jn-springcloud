package com.jn.park.activity.dao;

import com.jn.park.activity.entity.TbActivityLike;
import com.jn.park.activity.entity.TbActivityLikeCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TbActivityLikeMapper {
    long countByExample(TbActivityLikeCriteria example);

    int deleteByExample(TbActivityLikeCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbActivityLike record);

    int insertSelective(TbActivityLike record);

    List<TbActivityLike> selectByExample(TbActivityLikeCriteria example);

    TbActivityLike selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbActivityLike record, @Param("example") TbActivityLikeCriteria example);

    int updateByExample(@Param("record") TbActivityLike record, @Param("example") TbActivityLikeCriteria example);

    int updateByPrimaryKeySelective(TbActivityLike record);

    int updateByPrimaryKey(TbActivityLike record);
}