package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerBackgroundInvest;
import com.jn.hr.employee.entity.TbManpowerBackgroundInvestCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerBackgroundInvestMapper {
    long countByExample(TbManpowerBackgroundInvestCriteria example);

    int deleteByExample(TbManpowerBackgroundInvestCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerBackgroundInvest record);

    int insertSelective(TbManpowerBackgroundInvest record);

    List<TbManpowerBackgroundInvest> selectByExample(TbManpowerBackgroundInvestCriteria example);

    TbManpowerBackgroundInvest selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerBackgroundInvest record, @Param("example") TbManpowerBackgroundInvestCriteria example);

    int updateByExample(@Param("record") TbManpowerBackgroundInvest record, @Param("example") TbManpowerBackgroundInvestCriteria example);

    int updateByPrimaryKeySelective(TbManpowerBackgroundInvest record);

    int updateByPrimaryKey(TbManpowerBackgroundInvest record);
}