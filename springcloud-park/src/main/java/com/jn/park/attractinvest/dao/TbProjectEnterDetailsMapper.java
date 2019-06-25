package com.jn.park.attractinvest.dao;

import com.jn.park.attractinvest.entity.TbProjectEnterDetails;
import com.jn.park.attractinvest.entity.TbProjectEnterDetailsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbProjectEnterDetailsMapper {
    long countByExample(TbProjectEnterDetailsCriteria example);

    int deleteByExample(TbProjectEnterDetailsCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbProjectEnterDetails record);

    int insertSelective(TbProjectEnterDetails record);

    List<TbProjectEnterDetails> selectByExample(TbProjectEnterDetailsCriteria example);

    TbProjectEnterDetails selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbProjectEnterDetails record, @Param("example") TbProjectEnterDetailsCriteria example);

    int updateByExample(@Param("record") TbProjectEnterDetails record, @Param("example") TbProjectEnterDetailsCriteria example);

    int updateByPrimaryKeySelective(TbProjectEnterDetails record);

    int updateByPrimaryKey(TbProjectEnterDetails record);
}