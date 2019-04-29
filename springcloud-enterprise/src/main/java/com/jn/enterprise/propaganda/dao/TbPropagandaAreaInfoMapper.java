package com.jn.enterprise.propaganda.dao;

import com.jn.enterprise.propaganda.entity.TbPropagandaAreaInfo;
import com.jn.enterprise.propaganda.entity.TbPropagandaAreaInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPropagandaAreaInfoMapper {
    long countByExample(TbPropagandaAreaInfoCriteria example);

    int deleteByExample(TbPropagandaAreaInfoCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPropagandaAreaInfo record);

    int insertSelective(TbPropagandaAreaInfo record);

    List<TbPropagandaAreaInfo> selectByExample(TbPropagandaAreaInfoCriteria example);

    TbPropagandaAreaInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPropagandaAreaInfo record, @Param("example") TbPropagandaAreaInfoCriteria example);

    int updateByExample(@Param("record") TbPropagandaAreaInfo record, @Param("example") TbPropagandaAreaInfoCriteria example);

    int updateByPrimaryKeySelective(TbPropagandaAreaInfo record);

    int updateByPrimaryKey(TbPropagandaAreaInfo record);
}