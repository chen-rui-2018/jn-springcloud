package com.jn.park.asset.service;

import com.jn.park.asset.model.TowerInformationModel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author： zhuyz
* @date： Created on 2019/4/19 12:18
* @version： v1.0
* @modified By:
*/

public interface TowerManageService {
    /**
     * 通过园区id获取楼宇列表
     * @param parkId
     * @return
     */
    List<TowerInformationModel> towerList(String parkId);
}
