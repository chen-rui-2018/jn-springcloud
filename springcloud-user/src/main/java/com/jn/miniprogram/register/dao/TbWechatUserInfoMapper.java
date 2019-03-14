package com.jn.miniprogram.register.dao;

import com.jn.miniprogram.register.entity.TbWechatUserInfo;
import com.jn.miniprogram.register.entity.TbWechatUserInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbWechatUserInfoMapper {
    long countByExample(TbWechatUserInfoCriteria example);

    int deleteByExample(TbWechatUserInfoCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbWechatUserInfo record);

    int insertSelective(TbWechatUserInfo record);

    List<TbWechatUserInfo> selectByExample(TbWechatUserInfoCriteria example);

    TbWechatUserInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbWechatUserInfo record, @Param("example") TbWechatUserInfoCriteria example);

    int updateByExample(@Param("record") TbWechatUserInfo record, @Param("example") TbWechatUserInfoCriteria example);

    int updateByPrimaryKeySelective(TbWechatUserInfo record);

    int updateByPrimaryKey(TbWechatUserInfo record);
}