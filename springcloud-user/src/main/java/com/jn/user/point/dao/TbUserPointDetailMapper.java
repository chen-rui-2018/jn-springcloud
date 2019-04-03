package com.jn.user.point.dao;

import com.jn.user.point.entity.TbUserPointDetail;
import com.jn.user.point.entity.TbUserPointDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserPointDetailMapper {
    long countByExample(TbUserPointDetailCriteria example);

    int deleteByExample(TbUserPointDetailCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbUserPointDetail record);

    int insertSelective(TbUserPointDetail record);

    List<TbUserPointDetail> selectByExample(TbUserPointDetailCriteria example);

    TbUserPointDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbUserPointDetail record, @Param("example") TbUserPointDetailCriteria example);

    int updateByExample(@Param("record") TbUserPointDetail record, @Param("example") TbUserPointDetailCriteria example);

    int updateByPrimaryKeySelective(TbUserPointDetail record);

    int updateByPrimaryKey(TbUserPointDetail record);
}