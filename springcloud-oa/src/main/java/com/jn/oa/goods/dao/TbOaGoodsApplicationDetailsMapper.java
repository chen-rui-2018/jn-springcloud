package com.jn.oa.goods.dao;

import com.jn.oa.goods.entity.TbOaGoodsApplicationDetails;
import com.jn.oa.goods.entity.TbOaGoodsApplicationDetailsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOaGoodsApplicationDetailsMapper {
    long countByExample(TbOaGoodsApplicationDetailsCriteria example);

    int deleteByExample(TbOaGoodsApplicationDetailsCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbOaGoodsApplicationDetails record);

    int insertSelective(TbOaGoodsApplicationDetails record);

    List<TbOaGoodsApplicationDetails> selectByExample(TbOaGoodsApplicationDetailsCriteria example);

    TbOaGoodsApplicationDetails selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbOaGoodsApplicationDetails record, @Param("example") TbOaGoodsApplicationDetailsCriteria example);

    int updateByExample(@Param("record") TbOaGoodsApplicationDetails record, @Param("example") TbOaGoodsApplicationDetailsCriteria example);

    int updateByPrimaryKeySelective(TbOaGoodsApplicationDetails record);

    int updateByPrimaryKey(TbOaGoodsApplicationDetails record);
}