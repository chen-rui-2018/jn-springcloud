package com.jn.enterprise.joinpark.company.dao;

import com.jn.enterprise.joinpark.company.entity.TbServiceCompany;
import com.jn.enterprise.joinpark.company.entity.TbServiceCompanyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceCompanyMapper {
    long countByExample(TbServiceCompanyCriteria example);

    int deleteByExample(TbServiceCompanyCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceCompany record);

    int insertSelective(TbServiceCompany record);

    List<TbServiceCompany> selectByExample(TbServiceCompanyCriteria example);

    TbServiceCompany selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceCompany record, @Param("example") TbServiceCompanyCriteria example);

    int updateByExample(@Param("record") TbServiceCompany record, @Param("example") TbServiceCompanyCriteria example);

    int updateByPrimaryKeySelective(TbServiceCompany record);

    int updateByPrimaryKey(TbServiceCompany record);
}