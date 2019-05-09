package com.jn.enterprise.company.dao;

import com.jn.enterprise.company.entity.TbServiceCompanyModify;
import com.jn.enterprise.company.entity.TbServiceCompanyModifyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceCompanyModifyMapper {
    long countByExample(TbServiceCompanyModifyCriteria example);

    int deleteByExample(TbServiceCompanyModifyCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceCompanyModify record);

    int insertSelective(TbServiceCompanyModify record);

    List<TbServiceCompanyModify> selectByExample(TbServiceCompanyModifyCriteria example);

    TbServiceCompanyModify selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceCompanyModify record, @Param("example") TbServiceCompanyModifyCriteria example);

    int updateByExample(@Param("record") TbServiceCompanyModify record, @Param("example") TbServiceCompanyModifyCriteria example);

    int updateByPrimaryKeySelective(TbServiceCompanyModify record);

    int updateByPrimaryKey(TbServiceCompanyModify record);
}