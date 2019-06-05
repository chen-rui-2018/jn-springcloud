package com.jn.park.video.service;

import com.jn.park.video.vo.PmVideoVo;
import com.jn.system.model.User;

/**
 * 物业-安防录像设备管理service层
 *
 * @author： shaobao
 * @date： Created on 2019/5/17 9:45
 * @version： v1.0
 * @modified By:
 **/
public interface PmVideoService {

    /**
     * 添加安防录像设备信息
     */
    void insertVideoInfos();

    /**
     * 物业-安防录像申请赋权处理
     *
     * @param pmVideoVo
     * @param user
     * @return
     */
    Integer pmVideoApplyHandler(PmVideoVo pmVideoVo, User user);

    /**
     * 对录像赋权超过7天的录像,清除查看权限
     */
    void updateVideoInfo();
}
