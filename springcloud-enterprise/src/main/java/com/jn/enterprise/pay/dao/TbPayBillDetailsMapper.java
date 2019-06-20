package com.jn.enterprise.pay.dao;

import com.jn.enterprise.pay.entity.TbPayBillDetails;
import com.jn.enterprise.pay.entity.TbPayBillDetailsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPayBillDetailsMapper {
    long countByExample(TbPayBillDetailsCriteria example);

    int deleteByExample(TbPayBillDetailsCriteria example);

    int deleteByPrimaryKey(String detailsId);

    int insert(TbPayBillDetails record);

    int insertSelective(TbPayBillDetails record);

    List<TbPayBillDetails> selectByExample(TbPayBillDetailsCriteria example);

    TbPayBillDetails selectByPrimaryKey(String detailsId);

    int updateByExampleSelective(@Param("record") TbPayBillDetails record, @Param("example") TbPayBillDetailsCriteria example);

    int updateByExample(@Param("record") TbPayBillDetails record, @Param("example") TbPayBillDetailsCriteria example);

    int updateByPrimaryKeySelective(TbPayBillDetails record);

    int updateByPrimaryKey(TbPayBillDetails record);
}