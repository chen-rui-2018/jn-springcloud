package com.jn.park.hatch.dao;

import com.jn.park.hatch.entity.TbHatchEnterpriseNature;
import com.jn.park.hatch.entity.TbHatchEnterpriseNatureCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbHatchEnterpriseNatureMapper {
    long countByExample(TbHatchEnterpriseNatureCriteria example);

    int deleteByExample(TbHatchEnterpriseNatureCriteria example);

    int deleteByPrimaryKey(String enterpriseNatureId);

    int insert(TbHatchEnterpriseNature record);

    int insertSelective(TbHatchEnterpriseNature record);

    List<TbHatchEnterpriseNature> selectByExample(TbHatchEnterpriseNatureCriteria example);

    TbHatchEnterpriseNature selectByPrimaryKey(String enterpriseNatureId);

    int updateByExampleSelective(@Param("record") TbHatchEnterpriseNature record, @Param("example") TbHatchEnterpriseNatureCriteria example);

    int updateByExample(@Param("record") TbHatchEnterpriseNature record, @Param("example") TbHatchEnterpriseNatureCriteria example);

    int updateByPrimaryKeySelective(TbHatchEnterpriseNature record);

    int updateByPrimaryKey(TbHatchEnterpriseNature record);
}