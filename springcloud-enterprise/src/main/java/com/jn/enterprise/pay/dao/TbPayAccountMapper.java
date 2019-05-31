package com.jn.enterprise.pay.dao;

import com.jn.enterprise.pay.entity.TbPayAccount;
import com.jn.enterprise.pay.entity.TbPayAccountCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPayAccountMapper {
    long countByExample(TbPayAccountCriteria example);

    int deleteByExample(TbPayAccountCriteria example);

    int deleteByPrimaryKey(String userId);

    int insert(TbPayAccount record);

    int insertSelective(TbPayAccount record);

    List<TbPayAccount> selectByExample(TbPayAccountCriteria example);

    TbPayAccount selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") TbPayAccount record, @Param("example") TbPayAccountCriteria example);

    int updateByExample(@Param("record") TbPayAccount record, @Param("example") TbPayAccountCriteria example);

    int updateByPrimaryKeySelective(TbPayAccount record);

    int updateByPrimaryKey(TbPayAccount record);
}