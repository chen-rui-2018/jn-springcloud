package com.jn.enterprise.servicemarket.org.dao;

import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgTeam;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgTeamCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceOrgTeamMapper {
    long countByExample(TbServiceOrgTeamCriteria example);

    int deleteByExample(TbServiceOrgTeamCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceOrgTeam record);

    int insertSelective(TbServiceOrgTeam record);

    List<TbServiceOrgTeam> selectByExample(TbServiceOrgTeamCriteria example);

    TbServiceOrgTeam selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceOrgTeam record, @Param("example") TbServiceOrgTeamCriteria example);

    int updateByExample(@Param("record") TbServiceOrgTeam record, @Param("example") TbServiceOrgTeamCriteria example);

    int updateByPrimaryKeySelective(TbServiceOrgTeam record);

    int updateByPrimaryKey(TbServiceOrgTeam record);
}