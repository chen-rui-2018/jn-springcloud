package com.jn.oa.goods.dao;

import com.jn.oa.goods.entity.TbOaGoods;
import com.jn.oa.goods.entity.TbOaGoodsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOaGoodsMapper {
    long countByExample(TbOaGoodsCriteria example);

    int deleteByExample(TbOaGoodsCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbOaGoods record);

    int insertSelective(TbOaGoods record);

    List<TbOaGoods> selectByExample(TbOaGoodsCriteria example);

    TbOaGoods selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbOaGoods record, @Param("example") TbOaGoodsCriteria example);

    int updateByExample(@Param("record") TbOaGoods record, @Param("example") TbOaGoodsCriteria example);

    int updateByPrimaryKeySelective(TbOaGoods record);

    int updateByPrimaryKey(TbOaGoods record);
}