package com.jn.activity.dao;

import com.jn.activity.entity.TbActivity;
import com.jn.activity.entity.TbActivityCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbActivityMapper {
    long countByExample(TbActivityCriteria example);

    int deleteByExample(TbActivityCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbActivity record);

    int insertSelective(TbActivity record);

    List<TbActivity> selectByExample(TbActivityCriteria example);

    TbActivity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbActivity record, @Param("example") TbActivityCriteria example);

    int updateByExample(@Param("record") TbActivity record, @Param("example") TbActivityCriteria example);

    int updateByPrimaryKeySelective(TbActivity record);

    int updateByPrimaryKey(TbActivity record);
}