package com.jn.park.connect.service;

import com.jn.park.connect.model.ServiceConnectModel;

/**
 * @Author: tangry
 * @Date: 2019/4/26
 * @Version 1.0
 */
public interface ServiceConnectService {

    /**
     * 获取连接及图片
     * @param entranceNameCode
     * @return
     */
    ServiceConnectModel  getImgAndAddress(String entranceNameCode);
}
