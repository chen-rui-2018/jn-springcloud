package com.jn.park.parkCode.service;

import com.jn.park.parkCode.entity.TbParkCode;

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
    public List<TbParkCode> getParkCodeByType(String codeType);

}
