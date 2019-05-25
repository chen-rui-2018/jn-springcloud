package com.jn.park.video.dao;

import com.jn.park.video.entity.TbPmVideoItem;
import com.jn.park.video.entity.TbPmVideoItemCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPmVideoItemMapper {
    long countByExample(TbPmVideoItemCriteria example);

    int deleteByExample(TbPmVideoItemCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPmVideoItem record);

    int insertSelective(TbPmVideoItem record);

    List<TbPmVideoItem> selectByExample(TbPmVideoItemCriteria example);

    TbPmVideoItem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPmVideoItem record, @Param("example") TbPmVideoItemCriteria example);

    int updateByExample(@Param("record") TbPmVideoItem record, @Param("example") TbPmVideoItemCriteria example);

    int updateByPrimaryKeySelective(TbPmVideoItem record);

    int updateByPrimaryKey(TbPmVideoItem record);
}