package com.jn.enterprise.data.dao;

import com.jn.enterprise.data.entity.TbDataReportingModelStruct;
import com.jn.enterprise.data.entity.TbDataReportingModelStructCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDataReportingModelStructMapper {
    long countByExample(TbDataReportingModelStructCriteria example);

    int deleteByExample(TbDataReportingModelStructCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbDataReportingModelStruct record);

    int insertSelective(TbDataReportingModelStruct record);

    List<TbDataReportingModelStruct> selectByExample(TbDataReportingModelStructCriteria example);

    TbDataReportingModelStruct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbDataReportingModelStruct record, @Param("example") TbDataReportingModelStructCriteria example);

    int updateByExample(@Param("record") TbDataReportingModelStruct record, @Param("example") TbDataReportingModelStructCriteria example);

    int updateByPrimaryKeySelective(TbDataReportingModelStruct record);

    int updateByPrimaryKey(TbDataReportingModelStruct record);
}