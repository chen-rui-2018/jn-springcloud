package com.jn.park.notice.dao;

import com.jn.park.notice.model.NoticeDetailShow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/2 16:11
 * @version： v1.0
 * @modified By:
 */
public interface NoticeWebDao {
    /**
     * app首页弹出公告列表
     * @return
     */
    List<NoticeDetailShow> popupNoticeListForApp();

    /**
     * 门户首页弹出公告列表
     * @return
     */
    List<NoticeDetailShow> popupNoticeListForPortal();
    /**
     * 门户首页展示(轮播)公告列表
     * @return
     */
    List<NoticeDetailShow> showNoticeListForPortal();
    /**
     * App首页展示(轮播)公告列表
     * @return
     */
    List<NoticeDetailShow> showNoticeListForApp();
    /**
     * app公告列表
     * @return
     */
    List<NoticeDetailShow>  noticeListApp();

    /**
     * 门户公告列表
     * @return
     */
    List<NoticeDetailShow>  noticeListPortal();
    /**
     * 公告详情查看
     * @param noticeId
     * @return
     */
    NoticeDetailShow findNoticeDetailsByNoticeId(@Param("noticeId") String noticeId);
}
