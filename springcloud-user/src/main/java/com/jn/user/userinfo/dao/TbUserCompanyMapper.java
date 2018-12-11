package com.jn.user.userinfo.dao;

import com.jn.user.userinfo.entity.TbUserCompany;
import com.jn.user.userinfo.entity.TbUserCompanyCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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