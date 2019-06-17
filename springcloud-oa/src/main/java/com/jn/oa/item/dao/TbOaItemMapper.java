package com.jn.oa.item.dao;

import com.jn.oa.item.entity.TbOaItem;
import com.jn.oa.item.entity.TbOaItemCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOaItemMapper {
    long countByExample(TbOaItemCriteria example);

    int deleteByExample(TbOaItemCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbOaItem record);

    int insertSelective(TbOaItem record);

    List<TbOaItem> selectByExampleWithBLOBs(TbOaItemCriteria example);

    List<TbOaItem> selectByExample(TbOaItemCriteria example);

    TbOaItem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbOaItem record, @Param("example") TbOaItemCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbOaItem record, @Param("example") TbOaItemCriteria example);

    int updateByExample(@Param("record") TbOaItem record, @Param("example") TbOaItemCriteria example);

    int updateByPrimaryKeySelective(TbOaItem record);

    int updateByPrimaryKeyWithBLOBs(TbOaItem record);

    int updateByPrimaryKey(TbOaItem record);
}