package com.jn.park.comment.dao;

import com.jn.park.comment.entity.TbCommentSensitiveWord;
import com.jn.park.comment.entity.TbCommentSensitiveWordCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCommentSensitiveWordMapper {
    long countByExample(TbCommentSensitiveWordCriteria example);

    int deleteByExample(TbCommentSensitiveWordCriteria example);

    int insert(TbCommentSensitiveWord record);

    int insertSelective(TbCommentSensitiveWord record);

    List<TbCommentSensitiveWord> selectByExampleWithBLOBs(TbCommentSensitiveWordCriteria example);

    List<TbCommentSensitiveWord> selectByExample(TbCommentSensitiveWordCriteria example);

    int updateByExampleSelective(@Param("record") TbCommentSensitiveWord record, @Param("example") TbCommentSensitiveWordCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbCommentSensitiveWord record, @Param("example") TbCommentSensitiveWordCriteria example);

    int updateByExample(@Param("record") TbCommentSensitiveWord record, @Param("example") TbCommentSensitiveWordCriteria example);
}