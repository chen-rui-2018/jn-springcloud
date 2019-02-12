package com.jn.servicemarket.advisor.dao;

import com.jn.servicemarket.advisor.entity.TbServiceHonor;
import com.jn.servicemarket.advisor.entity.TbServiceHonorCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceHonorMapper {
    long countByExample(TbServiceHonorCriteria example);

    int deleteByExample(TbServiceHonorCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceHonor record);

    int insertSelective(TbServiceHonor record);

    List<TbServiceHonor> selectByExample(TbServiceHonorCriteria example);

    TbServiceHonor selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceHonor record, @Param("example") TbServiceHonorCriteria example);

    int updateByExample(@Param("record") TbServiceHonor record, @Param("example") TbServiceHonorCriteria example);

    int updateByPrimaryKeySelective(TbServiceHonor record);

    int updateByPrimaryKey(TbServiceHonor record);
}