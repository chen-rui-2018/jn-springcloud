package com.jn.oa.item.dao;

import com.jn.oa.item.entity.TbOaItem;
import com.jn.oa.item.entity.TbOaItemCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOaItemMapper {
    long countByExample(TbOaItemCriteria example);

    int deleteByExample(TbOaItemCriteria example);

    int insert(TbOaItem record);

    int insertSelective(TbOaItem record);

    List<TbOaItem> selectByExample(TbOaItemCriteria example);

    int updateByExampleSelective(@Param("record") TbOaItem record, @Param("example") TbOaItemCriteria example);

    int updateByExample(@Param("record") TbOaItem record, @Param("example") TbOaItemCriteria example);
}