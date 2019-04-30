package com.jn.park.connect.dao;

import com.jn.park.connect.model.ServiceConnectModel;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: tangry
 * @Date: 2019/4/26
 * @Version 1.0
 */
public interface ServiceConnectDao {

    /**
     * 获取连接及图片
     * @param entranceNameCode
     * @return
     */
    ServiceConnectModel getImgAndAddress(@Param("entranceNameCode") String entranceNameCode);
}
