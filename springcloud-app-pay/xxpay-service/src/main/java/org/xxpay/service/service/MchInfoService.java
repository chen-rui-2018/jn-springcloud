package org.xxpay.service.service;

import org.xxpay.dal.dao.model.MchInfo;

/**
 * @ClassName：商户信息service层
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/5 10:05
 * @Version： v1.0
 * @Modified By:
 */
public interface MchInfoService {

    /**
     * 根据商户ID获取商户信息
     * @param mchId
    * */
    MchInfo selectMchInfo(String mchId);
}
