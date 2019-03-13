package com.jn.park.finance.dao;

import com.jn.park.finance.entity.TbFinanceRecordInformation;
import com.jn.park.finance.entity.TbFinanceRecordInformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFinanceRecordInformationMapper {
    long countByExample(TbFinanceRecordInformationExample example);

    int deleteByExample(TbFinanceRecordInformationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFinanceRecordInformation record);

    int insertSelective(TbFinanceRecordInformation record);

    List<TbFinanceRecordInformation> selectByExample(TbFinanceRecordInformationExample example);

    TbFinanceRecordInformation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFinanceRecordInformation record, @Param("example") TbFinanceRecordInformationExample example);

    int updateByExample(@Param("record") TbFinanceRecordInformation record, @Param("example") TbFinanceRecordInformationExample example);

    int updateByPrimaryKeySelective(TbFinanceRecordInformation record);

    int updateByPrimaryKey(TbFinanceRecordInformation record);
}