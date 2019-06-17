package com.jn.oa.leave.dao;

import com.jn.oa.leave.entity.TbOaLeave;
import com.jn.oa.leave.entity.TbOaLeaveCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOaLeaveMapper {
    long countByExample(TbOaLeaveCriteria example);

    int deleteByExample(TbOaLeaveCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbOaLeave record);

    int insertSelective(TbOaLeave record);

    List<TbOaLeave> selectByExample(TbOaLeaveCriteria example);

    TbOaLeave selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbOaLeave record, @Param("example") TbOaLeaveCriteria example);

    int updateByExample(@Param("record") TbOaLeave record, @Param("example") TbOaLeaveCriteria example);

    int updateByPrimaryKeySelective(TbOaLeave record);

    int updateByPrimaryKey(TbOaLeave record);
}