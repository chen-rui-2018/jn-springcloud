package com.jn.enterprise.technologyfinancial.investors.dao;

import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceMainArea;
import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceMainAreaCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceMainAreaMapper {
    long countByExample(TbServiceMainAreaCriteria example);

    int deleteByExample(TbServiceMainAreaCriteria example);

    int deleteByPrimaryKey(String mainCode);

    int insert(TbServiceMainArea record);

    int insertSelective(TbServiceMainArea record);

    List<TbServiceMainArea> selectByExample(TbServiceMainAreaCriteria example);

    TbServiceMainArea selectByPrimaryKey(String mainCode);

    int updateByExampleSelective(@Param("record") TbServiceMainArea record, @Param("example") TbServiceMainAreaCriteria example);

    int updateByExample(@Param("record") TbServiceMainArea record, @Param("example") TbServiceMainAreaCriteria example);

    int updateByPrimaryKeySelective(TbServiceMainArea record);

    int updateByPrimaryKey(TbServiceMainArea record);
}