package com.jn.park.policy.dao;

import com.jn.park.policy.entity.TbPolicyLevel;
import com.jn.park.policy.entity.TbPolicyLevelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPolicyLevelMapper {
    long countByExample(TbPolicyLevelCriteria example);

    int deleteByExample(TbPolicyLevelCriteria example);

    int insert(TbPolicyLevel record);

    int insertSelective(TbPolicyLevel record);

    List<TbPolicyLevel> selectByExample(TbPolicyLevelCriteria example);

    int updateByExampleSelective(@Param("record") TbPolicyLevel record, @Param("example") TbPolicyLevelCriteria example);

    int updateByExample(@Param("record") TbPolicyLevel record, @Param("example") TbPolicyLevelCriteria example);
}