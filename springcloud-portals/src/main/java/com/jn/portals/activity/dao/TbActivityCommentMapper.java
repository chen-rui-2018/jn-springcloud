package com.jn.portals.activity.dao;

import com.jn.portals.activity.entity.TbActivityComment;
import com.jn.portals.activity.entity.TbActivityCommentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbActivityCommentMapper {
    long countByExample(TbActivityCommentCriteria example);

    int deleteByExample(TbActivityCommentCriteria example);

    int insert(TbActivityComment record);

    int insertSelective(TbActivityComment record);

    List<TbActivityComment> selectByExample(TbActivityCommentCriteria example);

    int updateByExampleSelective(@Param("record") TbActivityComment record, @Param("example") TbActivityCommentCriteria example);

    int updateByExample(@Param("record") TbActivityComment record, @Param("example") TbActivityCommentCriteria example);
}