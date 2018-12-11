package com.jn.portals.user.dao;

import com.jn.portals.user.entity.TbUserCompany;
import com.jn.portals.user.entity.TbUserCompanyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserCompanyMapper {
    long countByExample(TbUserCompanyCriteria example);

    int deleteByExample(TbUserCompanyCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbUserCompany record);

    int insertSelective(TbUserCompany record);

    List<TbUserCompany> selectByExample(TbUserCompanyCriteria example);

    TbUserCompany selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbUserCompany record, @Param("example") TbUserCompanyCriteria example);

    int updateByExample(@Param("record") TbUserCompany record, @Param("example") TbUserCompanyCriteria example);

    int updateByPrimaryKeySelective(TbUserCompany record);

    int updateByPrimaryKey(TbUserCompany record);
}