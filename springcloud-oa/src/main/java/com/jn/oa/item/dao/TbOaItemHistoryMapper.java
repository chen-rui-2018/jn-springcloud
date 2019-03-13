package com.jn.oa.item.dao;

import com.jn.oa.item.entity.TbOaItemHistory;
import com.jn.oa.item.entity.TbOaItemHistoryCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOaItemHistoryMapper {
    long countByExample(TbOaItemHistoryCriteria example);

    int deleteByExample(TbOaItemHistoryCriteria example);

    int insert(TbOaItemHistory record);

    int insertSelective(TbOaItemHistory record);

    List<TbOaItemHistory> selectByExample(TbOaItemHistoryCriteria example);

    int updateByExampleSelective(@Param("record") TbOaItemHistory record, @Param("example") TbOaItemHistoryCriteria example);

    int updateByExample(@Param("record") TbOaItemHistory record, @Param("example") TbOaItemHistoryCriteria example);
}