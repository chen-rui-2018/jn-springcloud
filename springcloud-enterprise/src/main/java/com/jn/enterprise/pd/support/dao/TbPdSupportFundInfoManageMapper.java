package com.jn.enterprise.pd.support.dao;

import com.jn.enterprise.pd.support.entity.TbPdSupportFundInfoManage;
import com.jn.enterprise.pd.support.entity.TbPdSupportFundInfoManageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdSupportFundInfoManageMapper {
    long countByExample(TbPdSupportFundInfoManageCriteria example);

    int deleteByExample(TbPdSupportFundInfoManageCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPdSupportFundInfoManage record);

    int insertSelective(TbPdSupportFundInfoManage record);

    List<TbPdSupportFundInfoManage> selectByExample(TbPdSupportFundInfoManageCriteria example);

    TbPdSupportFundInfoManage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPdSupportFundInfoManage record, @Param("example") TbPdSupportFundInfoManageCriteria example);

    int updateByExample(@Param("record") TbPdSupportFundInfoManage record, @Param("example") TbPdSupportFundInfoManageCriteria example);

    int updateByPrimaryKeySelective(TbPdSupportFundInfoManage record);

    int updateByPrimaryKey(TbPdSupportFundInfoManage record);
}