package com.jn.user.usertag.dao;

import com.jn.user.usertag.entity.TbUserTag;
import com.jn.user.usertag.entity.TbUserTagCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserTagMapper {
    long countByExample(TbUserTagCriteria example);

    int deleteByExample(TbUserTagCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbUserTag record);

    int insertSelective(TbUserTag record);

    List<TbUserTag> selectByExample(TbUserTagCriteria example);

    TbUserTag selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbUserTag record, @Param("example") TbUserTagCriteria example);

    int updateByExample(@Param("record") TbUserTag record, @Param("example") TbUserTagCriteria example);

    int updateByPrimaryKeySelective(TbUserTag record);

    int updateByPrimaryKey(TbUserTag record);
}