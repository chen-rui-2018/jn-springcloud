package com.jn.park.policy.dao;

import com.jn.park.policy.entity.TbPolicyClass;
import com.jn.park.policy.entity.TbPolicyClassCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPolicyClassMapper {
    long countByExample(TbPolicyClassCriteria example);

    int deleteByExample(TbPolicyClassCriteria example);

    int insert(TbPolicyClass record);

    int insertSelective(TbPolicyClass record);

    List<TbPolicyClass> selectByExample(TbPolicyClassCriteria example);

    int updateByExampleSelective(@Param("record") TbPolicyClass record, @Param("example") TbPolicyClassCriteria example);

    int updateByExample(@Param("record") TbPolicyClass record, @Param("example") TbPolicyClassCriteria example);
}