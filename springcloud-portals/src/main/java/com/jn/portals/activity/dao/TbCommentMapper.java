package com.jn.portals.activity.dao;

import com.jn.portals.activity.entity.TbComment;
import com.jn.portals.activity.entity.TbCommentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCommentMapper {
    long countByExample(TbCommentCriteria example);

    int deleteByExample(TbCommentCriteria example);

    int insert(TbComment record);

    int insertSelective(TbComment record);

    List<TbComment> selectByExample(TbCommentCriteria example);

    int updateByExampleSelective(@Param("record") TbComment record, @Param("example") TbCommentCriteria example);

    int updateByExample(@Param("record") TbComment record, @Param("example") TbCommentCriteria example);
}