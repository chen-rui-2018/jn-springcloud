package com.jn.oa.dingTalk.service;


import java.util.Date;

/**
 * @author： yuanyy
 * @date： Created on 2019/4/16 15:32
 * @version： v1.0
 * @modified By:
 **/
public interface DingTalkLeaveService {

    /**
     * 批量更新钉钉考请假
     * @param workDateFrom 开始时间
     * @param workDateTo 结束时间
     */
    void batchInsertDingTalkLeave(Date workDateFrom, Date workDateTo);



}
