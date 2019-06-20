package com.jn.enterprise.company.dao;

import com.jn.enterprise.company.entity.TbServiceRecruit;
import com.jn.enterprise.company.entity.TbServiceRecruitCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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