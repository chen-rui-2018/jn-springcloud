package com.jn.park.asset.dao;

import com.jn.park.asset.model.MaintainManageModel;

import java.util.List;

/**
* 维保管理dao
* @author： zhuyz
* @date： Created on 2019/5/5 16:36
* @version： v1.0
* @modified By:
*/
public interface MaintainManageDao {
    /**
     * 根据资产编号id获取维保信息
     * @param assetNumber
     * @return
     */
    MaintainManageModel getMaintain(String assetNumber);

    /**
     * 分页获取维保设备列表
     * @return
     */
    List<MaintainManageModel> getMaintainList();
}
