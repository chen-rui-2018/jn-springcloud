package com.jn.park.asset.dao;

import com.jn.park.asset.entity.TbRoomOrdersItem;
import com.jn.park.asset.entity.TbRoomOrdersItemCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRoomOrdersItemMapper {
    long countByExample(TbRoomOrdersItemCriteria example);

    int deleteByExample(TbRoomOrdersItemCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbRoomOrdersItem record);

    int insertSelective(TbRoomOrdersItem record);

    List<TbRoomOrdersItem> selectByExample(TbRoomOrdersItemCriteria example);

    TbRoomOrdersItem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbRoomOrdersItem record, @Param("example") TbRoomOrdersItemCriteria example);

    int updateByExample(@Param("record") TbRoomOrdersItem record, @Param("example") TbRoomOrdersItemCriteria example);

    int updateByPrimaryKeySelective(TbRoomOrdersItem record);

    int updateByPrimaryKey(TbRoomOrdersItem record);
}