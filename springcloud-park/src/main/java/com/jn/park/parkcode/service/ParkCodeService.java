package com.jn.park.parkcode.service;

import com.jn.park.parkcode.entity.TbParkCode;

import java.util.List;

/**
 * 园区字典
 *
 * @author： jiangyl
 * @date： Created on 2018/12/17 10:14
 * @version： v1.0
 * @modified By:
 */
public interface ParkCodeService {
    /**
     * 根据字典类型查询字典数据
     * @param codeType
     * @return
     */
    List<TbParkCode> getParkCodeByType(String codeType);
}
