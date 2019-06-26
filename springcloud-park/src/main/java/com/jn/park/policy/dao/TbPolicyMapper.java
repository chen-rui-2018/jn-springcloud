package com.jn.park.policy.dao;

import com.jn.park.policy.entity.TbPolicy;
import com.jn.park.policy.entity.TbPolicyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPolicyMapper {
    long countByExample(TbPolicyCriteria example);

    int deleteByExample(TbPolicyCriteria example);

    int deleteByPrimaryKey(String policyId);

    int insert(TbPolicy record);

    int insertSelective(TbPolicy record);

    List<TbPolicy> selectByExampleWithBLOBs(TbPolicyCriteria example);

    List<TbPolicy> selectByExample(TbPolicyCriteria example);

    TbPolicy selectByPrimaryKey(String policyId);

    int updateByExampleSelective(@Param("record") TbPolicy record, @Param("example") TbPolicyCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbPolicy record, @Param("example") TbPolicyCriteria example);

    int updateByExample(@Param("record") TbPolicy record, @Param("example") TbPolicyCriteria example);

    int updateByPrimaryKeySelective(TbPolicy record);

    int updateByPrimaryKeyWithBLOBs(TbPolicy record);

    int updateByPrimaryKey(TbPolicy record);
}