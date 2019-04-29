package com.jn.user.point.dao;

import com.jn.user.point.entity.TbUserPoint;
import com.jn.user.point.entity.TbUserPointCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserPointMapper {
    long countByExample(TbUserPointCriteria example);

    int deleteByExample(TbUserPointCriteria example);

    int deleteByPrimaryKey(String pointId);

    int insert(TbUserPoint record);

    int insertSelective(TbUserPoint record);

    List<TbUserPoint> selectByExample(TbUserPointCriteria example);

    TbUserPoint selectByPrimaryKey(String pointId);

    int updateByExampleSelective(@Param("record") TbUserPoint record, @Param("example") TbUserPointCriteria example);

    int updateByExample(@Param("record") TbUserPoint record, @Param("example") TbUserPointCriteria example);

    int updateByPrimaryKeySelective(TbUserPoint record);

    int updateByPrimaryKey(TbUserPoint record);
}