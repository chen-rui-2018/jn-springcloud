package com.jn.oa.notice.service;

import com.jn.common.model.PaginationData;
import com.jn.oa.notice.model.Notice;
import com.jn.oa.notice.model.NoticeAdd;
import com.jn.oa.notice.model.NoticePage;
import com.jn.system.model.User;

import java.util.List;

/**
 * @author： shaobao
 * @date： Created on 2019/2/12 15:32
 * @version： v1.0
 * @modified By:
 **/
public interface NoticeService {
    /**
     * 添加/修改公告
     *
     * @param noticeAdd
     * @param user      当前用户信息
     * @param flag      添加修改标记,true添加,false删除
     */
    void addOrUpdateNotice(NoticeAdd noticeAdd, User user, Boolean flag);

    /**
     * 分页获取公告列表信息
     *
     * @param noticePage 查询条件
     * @return
     */
    PaginationData list(NoticePage noticePage);

    /**
     * 查询公告详情
     *
     * @param noticeId 公告id
     * @return
     */
    Notice getNoticeById(String noticeId);

    /**
     * 发布公告
     *
     * @param platformType 平台类型
     * @return
     */
    List<Notice> publishNotice(String platformType);

    /**
     * @param noticeId 公告id
     * @param user     当前用户信息
     */
    void delete(String noticeId, User user);
}
