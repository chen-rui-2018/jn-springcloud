package org.xxpay.dal.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.xxpay.dal.dao.model.MchInfo;
import org.xxpay.dal.dao.model.MchInfoExample;

import java.util.List;

public interface MchInfoMapper {
    int countByExample(MchInfoExample example);

    int deleteByExample(MchInfoExample example);

    int deleteByPrimaryKey(String mchId);

    int insert(MchInfo record);

    int insertSelective(MchInfo record);

    List<MchInfo> selectByExample(MchInfoExample example);

    MchInfo selectByPrimaryKey(String mchId);

    int updateByExampleSelective(@Param("record") MchInfo record, @Param("example") MchInfoExample example);

    int updateByExample(@Param("record") MchInfo record, @Param("example") MchInfoExample example);

    int updateByPrimaryKeySelective(MchInfo record);

    int updateByPrimaryKey(MchInfo record);
    /**
     * 根据支付订单号获取商户信息
     * @param payOrderId
    * */
    MchInfo selectByPayOrderKey(String payOrderId);

}