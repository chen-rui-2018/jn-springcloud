package com.jn.hr.increase.dao;

import com.jn.hr.increase.entity.TbManpowerInsuredDetail;
import com.jn.hr.increase.entity.TbManpowerInsuredDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerInsuredDetailMapper {
    long countByExample(TbManpowerInsuredDetailCriteria example);

    int deleteByExample(TbManpowerInsuredDetailCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerInsuredDetail record);

    int insertSelective(TbManpowerInsuredDetail record);

    List<TbManpowerInsuredDetail> selectByExample(TbManpowerInsuredDetailCriteria example);

    TbManpowerInsuredDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerInsuredDetail record, @Param("example") TbManpowerInsuredDetailCriteria example);

    int updateByExample(@Param("record") TbManpowerInsuredDetail record, @Param("example") TbManpowerInsuredDetailCriteria example);

    int updateByPrimaryKeySelective(TbManpowerInsuredDetail record);

    int updateByPrimaryKey(TbManpowerInsuredDetail record);
}