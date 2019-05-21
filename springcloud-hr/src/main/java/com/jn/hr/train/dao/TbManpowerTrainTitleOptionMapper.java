package com.jn.hr.train.dao;

import com.jn.hr.train.entity.TbManpowerTrainTitleOption;
import com.jn.hr.train.entity.TbManpowerTrainTitleOptionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerTrainTitleOptionMapper {
    long countByExample(TbManpowerTrainTitleOptionCriteria example);

    int deleteByExample(TbManpowerTrainTitleOptionCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerTrainTitleOption record);

    int insertSelective(TbManpowerTrainTitleOption record);

    List<TbManpowerTrainTitleOption> selectByExample(TbManpowerTrainTitleOptionCriteria example);

    TbManpowerTrainTitleOption selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerTrainTitleOption record, @Param("example") TbManpowerTrainTitleOptionCriteria example);

    int updateByExample(@Param("record") TbManpowerTrainTitleOption record, @Param("example") TbManpowerTrainTitleOptionCriteria example);

    int updateByPrimaryKeySelective(TbManpowerTrainTitleOption record);

    int updateByPrimaryKey(TbManpowerTrainTitleOption record);
}