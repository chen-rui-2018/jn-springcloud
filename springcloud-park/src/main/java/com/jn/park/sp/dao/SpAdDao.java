package com.jn.park.sp.dao;

import com.jn.park.sp.model.SpAdModel;

import java.util.List;

/**
*
* @author： zhuyz
* @date： Created on 2019/4/11 17:51
* @version： v1.0
* @modified By:
*/
public interface SpAdDao {

    /**
     * 获取最新的5例广告图
     *
     * @return
     */
    List<SpAdModel> getAdvertising();
}
