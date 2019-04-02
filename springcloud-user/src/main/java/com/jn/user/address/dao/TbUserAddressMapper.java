package com.jn.user.address.dao;

import com.jn.user.address.entity.TbUserAddress;
import com.jn.user.address.entity.TbUserAddressCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserAddressMapper {
    long countByExample(TbUserAddressCriteria example);

    int deleteByExample(TbUserAddressCriteria example);

    int deleteByPrimaryKey(String addressId);

    int insert(TbUserAddress record);

    int insertSelective(TbUserAddress record);

    List<TbUserAddress> selectByExample(TbUserAddressCriteria example);

    TbUserAddress selectByPrimaryKey(String addressId);

    int updateByExampleSelective(@Param("record") TbUserAddress record, @Param("example") TbUserAddressCriteria example);

    int updateByExample(@Param("record") TbUserAddress record, @Param("example") TbUserAddressCriteria example);

    int updateByPrimaryKeySelective(TbUserAddress record);

    int updateByPrimaryKey(TbUserAddress record);
}