package com.jn.park.notice.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.notice.model.NoticeDetailShow;
import com.jn.park.notice.vo.IntegrationListVo;

import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/2 16:09
 * @version： v1.0
 * @modified By:
 */
public interface NoticeWebService {


    /**
     * PC端整合接口
     * @return
     */
    List<IntegrationListVo> integrationList();
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
     * @param  page
     * @return
     */
    PaginationData<List<NoticeDetailShow>> showNoticeListForPortal(Page page);
    /**
     * App首页展示(轮播)公告列表
     *  @param  page
     * @return
     */
    PaginationData<List<NoticeDetailShow>> showNoticeListForApp(Page page);

    /**
     * app公告列表
     *  @param  page
     * @return
     */
    PaginationData<List<NoticeDetailShow>>  noticeListApp(Page page);

    /**
     * 门户公告列表
     *  @param  page
     * @return
     */
    PaginationData<List<NoticeDetailShow>>  noticeListPortal(Page page);

    /**
     * 公告详情查看
     * @param noticeId
     * @return
     */
    NoticeDetailShow findNoticeDetailsByNoticeId(String noticeId);
}
