package com.jn.enterprise.data.dao;

import com.jn.enterprise.data.entity.TbDataReportingGroupStruct;
import com.jn.enterprise.data.entity.TbDataReportingGroupStructCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDataReportingGroupStructMapper {
    long countByExample(TbDataReportingGroupStructCriteria example);

    int deleteByExample(TbDataReportingGroupStructCriteria example);

    int deleteByPrimaryKey(String groupId);

    int insert(TbDataReportingGroupStruct record);

    int insertSelective(TbDataReportingGroupStruct record);

    List<TbDataReportingGroupStruct> selectByExample(TbDataReportingGroupStructCriteria example);

    TbDataReportingGroupStruct selectByPrimaryKey(String groupId);

    int updateByExampleSelective(@Param("record") TbDataReportingGroupStruct record, @Param("example") TbDataReportingGroupStructCriteria example);

    int updateByExample(@Param("record") TbDataReportingGroupStruct record, @Param("example") TbDataReportingGroupStructCriteria example);

    int updateByPrimaryKeySelective(TbDataReportingGroupStruct record);

    int updateByPrimaryKey(TbDataReportingGroupStruct record);
}