package com.jn.park.connect.dao;

import com.jn.park.connect.entity.TbServiceConnectManage;
import com.jn.park.connect.entity.TbServiceConnectManageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceConnectManageMapper {
    long countByExample(TbServiceConnectManageCriteria example);

    int deleteByExample(TbServiceConnectManageCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceConnectManage record);

    int insertSelective(TbServiceConnectManage record);

    List<TbServiceConnectManage> selectByExample(TbServiceConnectManageCriteria example);

    TbServiceConnectManage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceConnectManage record, @Param("example") TbServiceConnectManageCriteria example);

    int updateByExample(@Param("record") TbServiceConnectManage record, @Param("example") TbServiceConnectManageCriteria example);

    int updateByPrimaryKeySelective(TbServiceConnectManage record);

    int updateByPrimaryKey(TbServiceConnectManage record);
}