package com.jn.enterprise.servicemarket.org.dao;

import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgElement;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgElementCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceOrgElementMapper {
    long countByExample(TbServiceOrgElementCriteria example);

    int deleteByExample(TbServiceOrgElementCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceOrgElement record);

    int insertSelective(TbServiceOrgElement record);

    List<TbServiceOrgElement> selectByExample(TbServiceOrgElementCriteria example);

    TbServiceOrgElement selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceOrgElement record, @Param("example") TbServiceOrgElementCriteria example);

    int updateByExample(@Param("record") TbServiceOrgElement record, @Param("example") TbServiceOrgElementCriteria example);

    int updateByPrimaryKeySelective(TbServiceOrgElement record);

    int updateByPrimaryKey(TbServiceOrgElement record);
}