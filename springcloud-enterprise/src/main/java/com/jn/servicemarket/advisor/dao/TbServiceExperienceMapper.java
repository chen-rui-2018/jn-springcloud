package com.jn.servicemarket.advisor.dao;

import com.jn.servicemarket.advisor.entity.TbServiceExperience;
import com.jn.servicemarket.advisor.entity.TbServiceExperienceCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceExperienceMapper {
    long countByExample(TbServiceExperienceCriteria example);

    int deleteByExample(TbServiceExperienceCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceExperience record);

    int insertSelective(TbServiceExperience record);

    List<TbServiceExperience> selectByExample(TbServiceExperienceCriteria example);

    TbServiceExperience selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceExperience record, @Param("example") TbServiceExperienceCriteria example);

    int updateByExample(@Param("record") TbServiceExperience record, @Param("example") TbServiceExperienceCriteria example);

    int updateByPrimaryKeySelective(TbServiceExperience record);

    int updateByPrimaryKey(TbServiceExperience record);
}