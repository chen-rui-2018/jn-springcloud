package com.jn.activity.dao;

import com.jn.activity.entity.TbComment;
import com.jn.activity.entity.TbCommentCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbCommentMapper {
    long countByExample(TbCommentCriteria example);

    int deleteByExample(TbCommentCriteria example);

    int insert(TbComment record);

    int insertSelective(TbComment record);

    List<TbComment> selectByExample(TbCommentCriteria example);

    int updateByExampleSelective(@Param("record") TbComment record, @Param("example") TbCommentCriteria example);

    int updateByExample(@Param("record") TbComment record, @Param("example") TbCommentCriteria example);
}