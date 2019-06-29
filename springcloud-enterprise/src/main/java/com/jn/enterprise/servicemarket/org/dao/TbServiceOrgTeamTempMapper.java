package com.jn.enterprise.servicemarket.org.dao;

import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgTeamTemp;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgTeamTempCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceOrgTeamTempMapper {
    long countByExample(TbServiceOrgTeamTempCriteria example);

    int deleteByExample(TbServiceOrgTeamTempCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceOrgTeamTemp record);

    int insertSelective(TbServiceOrgTeamTemp record);

    List<TbServiceOrgTeamTemp> selectByExample(TbServiceOrgTeamTempCriteria example);

    TbServiceOrgTeamTemp selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceOrgTeamTemp record, @Param("example") TbServiceOrgTeamTempCriteria example);

    int updateByExample(@Param("record") TbServiceOrgTeamTemp record, @Param("example") TbServiceOrgTeamTempCriteria example);

    int updateByPrimaryKeySelective(TbServiceOrgTeamTemp record);

    int updateByPrimaryKey(TbServiceOrgTeamTemp record);
}