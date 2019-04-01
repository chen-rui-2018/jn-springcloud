package com.jn.park.notice.service;

import com.jn.park.notice.model.NoticeModifyParam;

/**
 * 园区公告
 * @author： chenr
 * @date： Created on 2019/4/1 9:19
 * @version： v1.0
 * @modified By:
 */
public interface NoticeService {
    /**
     * 添加公告信息
     * @param param
     * @param account
     * @return
     */
   int addNotice(NoticeModifyParam param,String account);
}

