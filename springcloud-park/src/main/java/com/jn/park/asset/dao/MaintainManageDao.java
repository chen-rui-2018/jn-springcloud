package com.jn.park.asset.dao;

import com.jn.park.asset.model.MaintainManageModel;

/**
* 维保管理dao
* @author： zhuyz
* @date： Created on 2019/5/5 16:36
* @version： v1.0
* @modified By:
*/
public interface MaintainManageDao {
    /**
     * 根据维保信息id获取维保信息
     * @param id
     * @return
     */
    MaintainManageModel getMaintain(String id);
}
