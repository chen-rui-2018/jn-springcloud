package com.jn.enterprise.servicemarket.advisor.dao;

import com.jn.enterprise.servicemarket.advisor.entity.TbServiceProExper;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceProExperCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceProExperMapper {
    long countByExample(TbServiceProExperCriteria example);

    int deleteByExample(TbServiceProExperCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceProExper record);

    int insertSelective(TbServiceProExper record);

    List<TbServiceProExper> selectByExample(TbServiceProExperCriteria example);

    TbServiceProExper selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceProExper record, @Param("example") TbServiceProExperCriteria example);

    int updateByExample(@Param("record") TbServiceProExper record, @Param("example") TbServiceProExperCriteria example);

    int updateByPrimaryKeySelective(TbServiceProExper record);

    int updateByPrimaryKey(TbServiceProExper record);
}