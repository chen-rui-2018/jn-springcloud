package com.jn.hr.train.dao;

import com.jn.hr.train.entity.TbManpowerTrainInvestiga;
import com.jn.hr.train.entity.TbManpowerTrainInvestigaCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerTrainInvestigaMapper {
    long countByExample(TbManpowerTrainInvestigaCriteria example);

    int deleteByExample(TbManpowerTrainInvestigaCriteria example);

    int deleteByPrimaryKey(String projectId);

    int insert(TbManpowerTrainInvestiga record);

    int insertSelective(TbManpowerTrainInvestiga record);

    List<TbManpowerTrainInvestiga> selectByExampleWithBLOBs(TbManpowerTrainInvestigaCriteria example);

    List<TbManpowerTrainInvestiga> selectByExample(TbManpowerTrainInvestigaCriteria example);

    TbManpowerTrainInvestiga selectByPrimaryKey(String projectId);

    int updateByExampleSelective(@Param("record") TbManpowerTrainInvestiga record, @Param("example") TbManpowerTrainInvestigaCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbManpowerTrainInvestiga record, @Param("example") TbManpowerTrainInvestigaCriteria example);

    int updateByExample(@Param("record") TbManpowerTrainInvestiga record, @Param("example") TbManpowerTrainInvestigaCriteria example);

    int updateByPrimaryKeySelective(TbManpowerTrainInvestiga record);

    int updateByPrimaryKeyWithBLOBs(TbManpowerTrainInvestiga record);

    int updateByPrimaryKey(TbManpowerTrainInvestiga record);
}