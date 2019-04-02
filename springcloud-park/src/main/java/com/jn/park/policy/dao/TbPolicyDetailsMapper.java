package com.jn.park.policy.dao;

import com.jn.park.policy.entity.TbPolicyDetails;
import com.jn.park.policy.entity.TbPolicyDetailsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPolicyDetailsMapper {
    long countByExample(TbPolicyDetailsCriteria example);

    int deleteByExample(TbPolicyDetailsCriteria example);

    int insert(TbPolicyDetails record);

    int insertSelective(TbPolicyDetails record);

    List<TbPolicyDetails> selectByExampleWithBLOBs(TbPolicyDetailsCriteria example);

    List<TbPolicyDetails> selectByExample(TbPolicyDetailsCriteria example);

    int updateByExampleSelective(@Param("record") TbPolicyDetails record, @Param("example") TbPolicyDetailsCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbPolicyDetails record, @Param("example") TbPolicyDetailsCriteria example);

    int updateByExample(@Param("record") TbPolicyDetails record, @Param("example") TbPolicyDetailsCriteria example);
}