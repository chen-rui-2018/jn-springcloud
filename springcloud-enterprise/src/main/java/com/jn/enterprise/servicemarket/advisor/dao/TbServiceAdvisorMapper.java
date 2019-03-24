package com.jn.enterprise.servicemarket.advisor.dao;

import com.jn.enterprise.servicemarket.advisor.entity.TbServiceAdvisor;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceAdvisorCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceAdvisorMapper {
    long countByExample(TbServiceAdvisorCriteria example);

    int deleteByExample(TbServiceAdvisorCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceAdvisor record);

    int insertSelective(TbServiceAdvisor record);

    List<TbServiceAdvisor> selectByExample(TbServiceAdvisorCriteria example);

    TbServiceAdvisor selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceAdvisor record, @Param("example") TbServiceAdvisorCriteria example);

    int updateByExample(@Param("record") TbServiceAdvisor record, @Param("example") TbServiceAdvisorCriteria example);

    int updateByPrimaryKeySelective(TbServiceAdvisor record);

    int updateByPrimaryKey(TbServiceAdvisor record);
}