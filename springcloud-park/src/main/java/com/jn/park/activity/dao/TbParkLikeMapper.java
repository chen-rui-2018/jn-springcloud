package com.jn.park.activity.dao;

import com.jn.park.activity.entity.TbParkLike;
import com.jn.park.activity.entity.TbParkLikeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbParkLikeMapper {
    long countByExample(TbParkLikeCriteria example);

    int deleteByExample(TbParkLikeCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbParkLike record);

    int insertSelective(TbParkLike record);

    List<TbParkLike> selectByExample(TbParkLikeCriteria example);

    TbParkLike selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbParkLike record, @Param("example") TbParkLikeCriteria example);

    int updateByExample(@Param("record") TbParkLike record, @Param("example") TbParkLikeCriteria example);

    int updateByPrimaryKeySelective(TbParkLike record);

    int updateByPrimaryKey(TbParkLike record);
}