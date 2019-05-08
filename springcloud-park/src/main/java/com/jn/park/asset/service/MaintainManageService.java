package com.jn.park.asset.service;

import com.jn.park.asset.model.MaintainManageModel;

/**
* 维保管理service
* @author： zhuyz
* @date： Created on 2019/5/5 16:33
* @version： v1.0
* @modified By:
*/
public interface MaintainManageService {
    /**
     * 根据维保信息id获取维保信息
     * @param id
     * @return
     */
    MaintainManageModel getMaintain(String id);

    /**
     * 维保信息录入
     * @param maintainManageModel
     * @return
     */
    Integer updateMaintain(MaintainManageModel maintainManageModel);
}
