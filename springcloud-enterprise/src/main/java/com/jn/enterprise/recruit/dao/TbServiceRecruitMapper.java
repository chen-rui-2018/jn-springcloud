package com.jn.enterprise.recruit.dao;

import com.jn.enterprise.recruit.entity.TbServiceRecruit;
import com.jn.enterprise.recruit.entity.TbServiceRecruitCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbServiceRecruitMapper {
    long countByExample(TbServiceRecruitCriteria example);

    int deleteByExample(TbServiceRecruitCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceRecruit record);

    int insertSelective(TbServiceRecruit record);

    List<TbServiceRecruit> selectByExample(TbServiceRecruitCriteria example);

    TbServiceRecruit selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceRecruit record, @Param("example") TbServiceRecruitCriteria example);

    int updateByExample(@Param("record") TbServiceRecruit record, @Param("example") TbServiceRecruitCriteria example);

    int updateByPrimaryKeySelective(TbServiceRecruit record);

    int updateByPrimaryKey(TbServiceRecruit record);
}