package com.jn.park.asset.service;

import com.jn.park.asset.model.MaintainRecordModel;
import com.jn.system.model.User;

/**
* 维保记录service
* @author： zhuyz
* @date： Created on 2019/5/5 20:23
* @version： v1.0
* @modified By:
*/
public interface MaintainRecordService {

    /**
     * 新增维保记录
     * @param user
     * @param maintainRecordModel
     * @return
     */
    Integer addRecord(User user, MaintainRecordModel maintainRecordModel);
}
