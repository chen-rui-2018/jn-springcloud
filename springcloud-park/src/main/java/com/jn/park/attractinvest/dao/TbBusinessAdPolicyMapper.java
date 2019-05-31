package com.jn.park.attractinvest.dao;

import com.jn.park.attractinvest.entity.TbBusinessAdPolicy;
import com.jn.park.attractinvest.entity.TbBusinessAdPolicyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbBusinessAdPolicyMapper {
    long countByExample(TbBusinessAdPolicyCriteria example);

    int deleteByExample(TbBusinessAdPolicyCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbBusinessAdPolicy record);

    int insertSelective(TbBusinessAdPolicy record);

    List<TbBusinessAdPolicy> selectByExampleWithBLOBs(TbBusinessAdPolicyCriteria example);

    List<TbBusinessAdPolicy> selectByExample(TbBusinessAdPolicyCriteria example);

    TbBusinessAdPolicy selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbBusinessAdPolicy record, @Param("example") TbBusinessAdPolicyCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbBusinessAdPolicy record, @Param("example") TbBusinessAdPolicyCriteria example);

    int updateByExample(@Param("record") TbBusinessAdPolicy record, @Param("example") TbBusinessAdPolicyCriteria example);

    int updateByPrimaryKeySelective(TbBusinessAdPolicy record);

    int updateByPrimaryKeyWithBLOBs(TbBusinessAdPolicy record);

    int updateByPrimaryKey(TbBusinessAdPolicy record);
}