package com.jn.park.sp.dao;

import com.jn.park.sp.entity.TbSpPowerBusiWithBLOBs;

/**
 *
 *
 * @author： zhuyz
 * @date： Created on 2019/3/27 17:50
 * @version： v1.0
 * @modified By:
 */
public interface SpPowerBusiDao {

    /**
     * 通过主键查询业务对象
     *
     * @param id
     * @return
     */
    TbSpPowerBusiWithBLOBs selectBusiByKey(String id);
}
