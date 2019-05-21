package com.jn.park.customer.dao;

import com.jn.park.customer.entity.TbClientRolePersonInfo;
import com.jn.park.customer.entity.TbClientRolePersonInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbClientRolePersonInfoMapper {
    long countByExample(TbClientRolePersonInfoCriteria example);

    int deleteByExample(TbClientRolePersonInfoCriteria example);

    int insert(TbClientRolePersonInfo record);

    int insertSelective(TbClientRolePersonInfo record);

    List<TbClientRolePersonInfo> selectByExample(TbClientRolePersonInfoCriteria example);

    int updateByExampleSelective(@Param("record") TbClientRolePersonInfo record, @Param("example") TbClientRolePersonInfoCriteria example);

    int updateByExample(@Param("record") TbClientRolePersonInfo record, @Param("example") TbClientRolePersonInfoCriteria example);
}