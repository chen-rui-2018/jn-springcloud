package com.jn.park.feedback.dao;

import com.jn.park.feedback.entity.TbUserFeedback;
import com.jn.park.feedback.entity.TbUserFeedbackCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserFeedbackMapper {
    long countByExample(TbUserFeedbackCriteria example);

    int deleteByExample(TbUserFeedbackCriteria example);

    int deleteByPrimaryKey(String feedId);

    int insert(TbUserFeedback record);

    int insertSelective(TbUserFeedback record);

    List<TbUserFeedback> selectByExample(TbUserFeedbackCriteria example);

    TbUserFeedback selectByPrimaryKey(String feedId);

    int updateByExampleSelective(@Param("record") TbUserFeedback record, @Param("example") TbUserFeedbackCriteria example);

    int updateByExample(@Param("record") TbUserFeedback record, @Param("example") TbUserFeedbackCriteria example);

    int updateByPrimaryKeySelective(TbUserFeedback record);

    int updateByPrimaryKey(TbUserFeedback record);
}