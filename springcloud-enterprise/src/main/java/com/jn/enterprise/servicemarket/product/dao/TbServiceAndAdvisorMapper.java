package com.jn.enterprise.servicemarket.product.dao;

import com.jn.enterprise.servicemarket.product.entity.TbServiceAndAdvisor;
import com.jn.enterprise.servicemarket.product.entity.TbServiceAndAdvisorCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceAndAdvisorMapper {
    long countByExample(TbServiceAndAdvisorCriteria example);

    int deleteByExample(TbServiceAndAdvisorCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceAndAdvisor record);

    int insertSelective(TbServiceAndAdvisor record);

    List<TbServiceAndAdvisor> selectByExample(TbServiceAndAdvisorCriteria example);

    TbServiceAndAdvisor selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceAndAdvisor record, @Param("example") TbServiceAndAdvisorCriteria example);

    int updateByExample(@Param("record") TbServiceAndAdvisor record, @Param("example") TbServiceAndAdvisorCriteria example);

    int updateByPrimaryKeySelective(TbServiceAndAdvisor record);

    int updateByPrimaryKey(TbServiceAndAdvisor record);
}