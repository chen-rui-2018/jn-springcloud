package com.jn.park.hatch.dao;

import com.jn.park.hatch.entity.TbHatchEnterpriseType;
import com.jn.park.hatch.entity.TbHatchEnterpriseTypeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbHatchEnterpriseTypeMapper {
    long countByExample(TbHatchEnterpriseTypeCriteria example);

    int deleteByExample(TbHatchEnterpriseTypeCriteria example);

    int deleteByPrimaryKey(String enterpriseTypeId);

    int insert(TbHatchEnterpriseType record);

    int insertSelective(TbHatchEnterpriseType record);

    List<TbHatchEnterpriseType> selectByExample(TbHatchEnterpriseTypeCriteria example);

    TbHatchEnterpriseType selectByPrimaryKey(String enterpriseTypeId);

    int updateByExampleSelective(@Param("record") TbHatchEnterpriseType record, @Param("example") TbHatchEnterpriseTypeCriteria example);

    int updateByExample(@Param("record") TbHatchEnterpriseType record, @Param("example") TbHatchEnterpriseTypeCriteria example);

    int updateByPrimaryKeySelective(TbHatchEnterpriseType record);

    int updateByPrimaryKey(TbHatchEnterpriseType record);
}