package com.jn.park.video.dao;

/**
 * 安防录像申请管理dao
 *
 * @author： shaobao
 * @date： Created on 2019/5/18 16:11
 * @version： v1.0
 * @modified By:
 **/
public interface PmVideoMapper {

    /**
     * 清除录像赋权超过7的录像播放信息
     *
     * @param playInfo
     */
    void updateVideoInfo(String playInfo);
}
