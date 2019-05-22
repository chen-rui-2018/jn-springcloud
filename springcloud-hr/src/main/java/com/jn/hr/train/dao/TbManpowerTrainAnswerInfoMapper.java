package com.jn.hr.train.dao;

import com.jn.hr.train.entity.TbManpowerTrainAnswerInfo;
import com.jn.hr.train.entity.TbManpowerTrainAnswerInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerTrainAnswerInfoMapper {
    long countByExample(TbManpowerTrainAnswerInfoCriteria example);

    int deleteByExample(TbManpowerTrainAnswerInfoCriteria example);

    int deleteByPrimaryKey(String answerId);

    int insert(TbManpowerTrainAnswerInfo record);

    int insertSelective(TbManpowerTrainAnswerInfo record);

    List<TbManpowerTrainAnswerInfo> selectByExample(TbManpowerTrainAnswerInfoCriteria example);

    TbManpowerTrainAnswerInfo selectByPrimaryKey(String answerId);

    int updateByExampleSelective(@Param("record") TbManpowerTrainAnswerInfo record, @Param("example") TbManpowerTrainAnswerInfoCriteria example);

    int updateByExample(@Param("record") TbManpowerTrainAnswerInfo record, @Param("example") TbManpowerTrainAnswerInfoCriteria example);

    int updateByPrimaryKeySelective(TbManpowerTrainAnswerInfo record);

    int updateByPrimaryKey(TbManpowerTrainAnswerInfo record);
}