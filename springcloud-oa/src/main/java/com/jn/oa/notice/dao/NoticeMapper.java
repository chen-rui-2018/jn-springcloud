package com.jn.oa.notice.dao;

import com.jn.oa.notice.model.Notice;
import com.jn.oa.notice.model.NoticePage;

import java.util.List;

/**
 * @author： shaobao
 * @date： Created on 2019/2/12 20:07
 * @version： v1.0
 * @modified By:
 **/
public interface NoticeMapper {
    /**
     * 条件分页查询公告管理列表信息
     *
     * @param noticePage
     * @return
     */
    List<Notice> list(NoticePage noticePage);
}
