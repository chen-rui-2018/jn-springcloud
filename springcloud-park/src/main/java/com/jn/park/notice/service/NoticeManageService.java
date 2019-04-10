package com.jn.park.notice.service;

import com.jn.common.model.PaginationData;
import com.jn.park.notice.model.*;

import java.util.List;

/**
 * 园区公告
 * @author： chenr
 * @date： Created on 2019/4/1 9:19
 * @version： v1.0
 * @modified By:
 */
public interface NoticeManageService {
    /**
     * 添加公告信息
     * @param param
     * @param account
     * @return
     */
   int addNotice(NoticeModifyParam param,String account);

    /**
     * 后台公告列表
     * @param queryParam
     * @return
     */
   PaginationData<List<NoticeManageShow>> findNoticeList(NoticeQueryParam queryParam);

    /**
     * 更新公告信息
     * @param param
     * @param account
     * @return
     */
   int  modifyNotice(NoticeModifyParam param,String account);

    /**
     * 公告详情
     * @param noticeId
     * @return
     */
   NoticeManageShow findNoticeDetails(String noticeId);

    /**
     * 公告上架/下架操作
     * @param shelfParam
     * @param account
     * @return
     */
   int noticeShelfOperate( NoticeShelfParam shelfParam,String account);

    /**
     * 平台列表
     * @param codeType
     * @return
     */
   List<NoticePlatformShow> findPlatformList(String codeType);
}

