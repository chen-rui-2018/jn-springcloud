package com.jn.oa.email.dao;

import com.jn.oa.email.entity.TbOaEmailUser;
import com.jn.oa.email.entity.TbOaEmailUserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOaEmailUserMapper {
    long countByExample(TbOaEmailUserCriteria example);

    int deleteByExample(TbOaEmailUserCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbOaEmailUser record);

    int insertSelective(TbOaEmailUser record);

    List<TbOaEmailUser> selectByExample(TbOaEmailUserCriteria example);

    TbOaEmailUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbOaEmailUser record, @Param("example") TbOaEmailUserCriteria example);

    int updateByExample(@Param("record") TbOaEmailUser record, @Param("example") TbOaEmailUserCriteria example);

    int updateByPrimaryKeySelective(TbOaEmailUser record);

    int updateByPrimaryKey(TbOaEmailUser record);
}