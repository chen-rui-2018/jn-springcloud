package com.jn.oa.dingTalk.service;


import com.jn.oa.dingTalk.entity.TbOaDingTalkUser;

import java.util.Date;

/**
 * @author： yuanyy
 * @date： Created on 2019/4/16 15:32
 * @version： v1.0
 * @modified By:
 **/
public interface DingTalkAttendanceService {

    /**
     * 批量更新钉钉考勤
     * @param workDateFrom 开始时间
     * @param workDateTo 结束时间
     */
    void batchInsertDingTalkAttendance(String workDateFrom, String workDateTo);



}
