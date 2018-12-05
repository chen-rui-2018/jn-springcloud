package com.jn.portals.activity.dao;

import com.jn.portals.activity.entity.TbActivity;
import com.jn.portals.activity.entity.TbActivityCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbActivityMapper {
    long countByExample(TbActivityCriteria example);

    int deleteByExample(TbActivityCriteria example);

    int insert(TbActivity record);

    int insertSelective(TbActivity record);

    List<TbActivity> selectByExample(TbActivityCriteria example);

    int updateByExampleSelective(@Param("record") TbActivity record, @Param("example") TbActivityCriteria example);

    int updateByExample(@Param("record") TbActivity record, @Param("example") TbActivityCriteria example);
}