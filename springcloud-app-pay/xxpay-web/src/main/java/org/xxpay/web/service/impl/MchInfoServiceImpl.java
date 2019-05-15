package org.xxpay.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xxpay.dal.dao.mapper.MchInfoMapper;
import org.xxpay.dal.dao.model.MchInfo;
import org.xxpay.web.service.MchInfoService;

/**
 * @ClassName：商户信息实现类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/11 15:58
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class MchInfoServiceImpl implements MchInfoService {

    @Autowired
    private MchInfoMapper mchInfoMapper;

    /**
     * 根据商户ID获取商户信息
     * @param mchId 商户ID
     * @return
     * */
    @Override
    public MchInfo getMchInfoById(String mchId) {
        return mchInfoMapper.selectByPrimaryKey(mchId);
    }
}
