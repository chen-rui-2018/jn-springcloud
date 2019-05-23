package com.jn.hr.increase.dao;

import com.jn.hr.increase.entity.TbManpowerInsuredSchemeDetailed;
import com.jn.hr.increase.entity.TbManpowerInsuredSchemeDetailedCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerInsuredSchemeDetailedMapper {
    long countByExample(TbManpowerInsuredSchemeDetailedCriteria example);

    int deleteByExample(TbManpowerInsuredSchemeDetailedCriteria example);

    int deleteByPrimaryKey(String projectId);

    int insert(TbManpowerInsuredSchemeDetailed record);

    int insertSelective(TbManpowerInsuredSchemeDetailed record);

    List<TbManpowerInsuredSchemeDetailed> selectByExample(TbManpowerInsuredSchemeDetailedCriteria example);

    TbManpowerInsuredSchemeDetailed selectByPrimaryKey(String projectId);

    int updateByExampleSelective(@Param("record") TbManpowerInsuredSchemeDetailed record, @Param("example") TbManpowerInsuredSchemeDetailedCriteria example);

    int updateByExample(@Param("record") TbManpowerInsuredSchemeDetailed record, @Param("example") TbManpowerInsuredSchemeDetailedCriteria example);

    int updateByPrimaryKeySelective(TbManpowerInsuredSchemeDetailed record);

    int updateByPrimaryKey(TbManpowerInsuredSchemeDetailed record);
}