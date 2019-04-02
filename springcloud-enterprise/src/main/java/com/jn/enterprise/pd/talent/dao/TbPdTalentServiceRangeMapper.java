package com.jn.enterprise.pd.talent.dao;

import com.jn.enterprise.pd.talent.entity.TbPdTalentServiceRange;
import com.jn.enterprise.pd.talent.entity.TbPdTalentServiceRangeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdTalentServiceRangeMapper {
    long countByExample(TbPdTalentServiceRangeCriteria example);

    int deleteByExample(TbPdTalentServiceRangeCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPdTalentServiceRange record);

    int insertSelective(TbPdTalentServiceRange record);

    List<TbPdTalentServiceRange> selectByExample(TbPdTalentServiceRangeCriteria example);

    TbPdTalentServiceRange selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPdTalentServiceRange record, @Param("example") TbPdTalentServiceRangeCriteria example);

    int updateByExample(@Param("record") TbPdTalentServiceRange record, @Param("example") TbPdTalentServiceRangeCriteria example);

    int updateByPrimaryKeySelective(TbPdTalentServiceRange record);

    int updateByPrimaryKey(TbPdTalentServiceRange record);
}