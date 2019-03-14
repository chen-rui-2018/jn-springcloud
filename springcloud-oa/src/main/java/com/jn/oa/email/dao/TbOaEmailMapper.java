package com.jn.oa.email.dao;

import com.jn.oa.email.entity.TbOaEmail;
import com.jn.oa.email.entity.TbOaEmailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOaEmailMapper {
    long countByExample(TbOaEmailCriteria example);

    int deleteByExample(TbOaEmailCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbOaEmail record);

    int insertSelective(TbOaEmail record);

    List<TbOaEmail> selectByExample(TbOaEmailCriteria example);

    TbOaEmail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbOaEmail record, @Param("example") TbOaEmailCriteria example);

    int updateByExample(@Param("record") TbOaEmail record, @Param("example") TbOaEmailCriteria example);

    int updateByPrimaryKeySelective(TbOaEmail record);

    int updateByPrimaryKey(TbOaEmail record);
}