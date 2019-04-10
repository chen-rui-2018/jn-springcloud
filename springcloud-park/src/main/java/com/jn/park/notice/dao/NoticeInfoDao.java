package com.jn.park.notice.dao;

import com.jn.park.notice.model.NoticeManageShow;
import com.jn.park.notice.model.NoticeQueryParam;
import com.jn.park.notice.model.NoticeShelfParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 对外公告dao
 * @author： chenr
 * @date： Created on 2019/4/1 16:15
 * @version： v1.0
 * @modified By:
 */
public interface NoticeInfoDao {
    /**
     * 查找对外公告管理列表
     * @param queryParam
     * @return
     */
    List<NoticeManageShow> findNoticeList(NoticeQueryParam queryParam);

    /**
     * 后台产看公告详情(可用于编辑页面回显)
     * @param noticeId
     * @return
     */
    NoticeManageShow findNoticeDetails(@Param("noticeId") String noticeId);

    /**
     * 公告上架/下架操作
     * @param noticeId
     * @param noticeStatus
     * @param account
     * @return
     */

    int noticeShelfOperate(@Param("noticeId")String noticeId,@Param("noticeStatus")String noticeStatus,@Param("account")String account);
}
