package com.jn.park.comment.dao;

import com.jn.park.comment.entity.TbComment;
import com.jn.park.comment.entity.TbCommentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCommentMapper {
    long countByExample(TbCommentCriteria example);

    int deleteByExample(TbCommentCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbComment record);

    int insertSelective(TbComment record);

    List<TbComment> selectByExample(TbCommentCriteria example);

    TbComment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbComment record, @Param("example") TbCommentCriteria example);

    int updateByExample(@Param("record") TbComment record, @Param("example") TbCommentCriteria example);

    int updateByPrimaryKeySelective(TbComment record);

    int updateByPrimaryKey(TbComment record);
}