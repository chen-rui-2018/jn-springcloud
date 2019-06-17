package com.jn.miniprogram.register.dao;

import com.jn.miniprogram.register.entity.TbWechatPublicUserInfo;
import com.jn.miniprogram.register.entity.TbWechatPublicUserInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbWechatPublicUserInfoMapper {
    long countByExample(TbWechatPublicUserInfoCriteria example);

    int deleteByExample(TbWechatPublicUserInfoCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbWechatPublicUserInfo record);

    int insertSelective(TbWechatPublicUserInfo record);

    List<TbWechatPublicUserInfo> selectByExample(TbWechatPublicUserInfoCriteria example);

    TbWechatPublicUserInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbWechatPublicUserInfo record, @Param("example") TbWechatPublicUserInfoCriteria example);

    int updateByExample(@Param("record") TbWechatPublicUserInfo record, @Param("example") TbWechatPublicUserInfoCriteria example);

    int updateByPrimaryKeySelective(TbWechatPublicUserInfo record);

    int updateByPrimaryKey(TbWechatPublicUserInfo record);
}