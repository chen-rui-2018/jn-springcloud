package org.xxpay.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xxpay.dal.dao.mapper.MchInfoMapper;
import org.xxpay.dal.dao.model.MchInfo;
import org.xxpay.service.service.MchInfoService;

/**
 * @ClassName：商户信息service层
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/5 10:07
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class MchInfoServiceImpl implements MchInfoService {

    @Autowired
    private MchInfoMapper mchInfoMapper;

    /**
     * 根据商户ID获取商户信息
     * @param mchId
     * */
    @Override
    public MchInfo selectMchInfo(String mchId) {
        return mchInfoMapper.selectByPrimaryKey(mchId);
    }
}
