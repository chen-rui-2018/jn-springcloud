package com.jn.oa.dingTalk.dao;

import com.jn.oa.dingTalk.entity.TbOaDingTalkUser;
import com.jn.oa.dingTalk.entity.TbOaDingTalkUserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOaDingTalkUserMapper {
    long countByExample(TbOaDingTalkUserCriteria example);

    int deleteByExample(TbOaDingTalkUserCriteria example);

    int deleteByPrimaryKey(String userId);

    int insert(TbOaDingTalkUser record);

    int insertSelective(TbOaDingTalkUser record);

    List<TbOaDingTalkUser> selectByExample(TbOaDingTalkUserCriteria example);

    TbOaDingTalkUser selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") TbOaDingTalkUser record, @Param("example") TbOaDingTalkUserCriteria example);

    int updateByExample(@Param("record") TbOaDingTalkUser record, @Param("example") TbOaDingTalkUserCriteria example);

    int updateByPrimaryKeySelective(TbOaDingTalkUser record);

    int updateByPrimaryKey(TbOaDingTalkUser record);
}