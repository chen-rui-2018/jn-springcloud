package com.jn.park.asset.dao;

import com.jn.park.asset.model.RoomInformationModel;

import java.util.List;
import java.util.Map;

/**
* 房间信息dao
* @author： zhuyz
* @date： Created on 2019/5/7 19:20
* @version： v1.0
* @modified By:
*/
public interface RoomInformationDao {


    /**
     * 更改房间信息租借状态
     * @param map
     */
    void updateStatus(Map<String, Object> map);

    /**
     * 返回可租借的房间列表(可搜索)
     * @param name
     * @return
     */
    List<RoomInformationModel> getRoomLeaseList(String name);
}
