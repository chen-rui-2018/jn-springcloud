package com.jn.servicemarket.advisor.dao;

import com.jn.servicemarket.advisor.entity.TbServiceAdvisor;
import com.jn.servicemarket.advisor.entity.TbServiceAdvisorCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceAdvisorMapper {
    long countByExample(TbServiceAdvisorCriteria example);

    int deleteByExample(TbServiceAdvisorCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceAdvisor record);

    int insertSelective(TbServiceAdvisor record);

    List<TbServiceAdvisor> selectByExampleWithBLOBs(TbServiceAdvisorCriteria example);

    List<TbServiceAdvisor> selectByExample(TbServiceAdvisorCriteria example);

    TbServiceAdvisor selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceAdvisor record, @Param("example") TbServiceAdvisorCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbServiceAdvisor record, @Param("example") TbServiceAdvisorCriteria example);

    int updateByExample(@Param("record") TbServiceAdvisor record, @Param("example") TbServiceAdvisorCriteria example);

    int updateByPrimaryKeySelective(TbServiceAdvisor record);

    int updateByPrimaryKeyWithBLOBs(TbServiceAdvisor record);

    int updateByPrimaryKey(TbServiceAdvisor record);
}