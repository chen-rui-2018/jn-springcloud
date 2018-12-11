package com.jn.portals.user.dao;

import com.jn.portals.user.entity.TbUserPerson;
import com.jn.portals.user.entity.TbUserPersonCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserPersonMapper {
    long countByExample(TbUserPersonCriteria example);

    int deleteByExample(TbUserPersonCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbUserPerson record);

    int insertSelective(TbUserPerson record);

    List<TbUserPerson> selectByExample(TbUserPersonCriteria example);

    TbUserPerson selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbUserPerson record, @Param("example") TbUserPersonCriteria example);

    int updateByExample(@Param("record") TbUserPerson record, @Param("example") TbUserPersonCriteria example);

    int updateByPrimaryKeySelective(TbUserPerson record);

    int updateByPrimaryKey(TbUserPerson record);
}