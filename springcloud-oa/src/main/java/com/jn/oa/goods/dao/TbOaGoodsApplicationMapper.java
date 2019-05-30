package com.jn.oa.goods.dao;

import com.jn.oa.goods.entity.TbOaGoodsApplication;
import com.jn.oa.goods.entity.TbOaGoodsApplicationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOaGoodsApplicationMapper {
    long countByExample(TbOaGoodsApplicationCriteria example);

    int deleteByExample(TbOaGoodsApplicationCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbOaGoodsApplication record);

    int insertSelective(TbOaGoodsApplication record);

    List<TbOaGoodsApplication> selectByExample(TbOaGoodsApplicationCriteria example);

    TbOaGoodsApplication selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbOaGoodsApplication record, @Param("example") TbOaGoodsApplicationCriteria example);

    int updateByExample(@Param("record") TbOaGoodsApplication record, @Param("example") TbOaGoodsApplicationCriteria example);

    int updateByPrimaryKeySelective(TbOaGoodsApplication record);

    int updateByPrimaryKey(TbOaGoodsApplication record);
}