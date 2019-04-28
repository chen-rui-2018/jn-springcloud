package com.jn.park.asset.dao;

import com.jn.park.asset.model.TowerInformationModel;

import java.util.List;

/**
* @author： zhuyz
* @date： Created on 2019/4/19 16:21
* @version： v1.0
* @modified By:
*/
public interface TowerInformationDao {

    /**
     * 通过园区id查询楼宇列表
     * @param parkId
     * @return
     */
    List<TowerInformationModel> towerList(String parkId);
}
