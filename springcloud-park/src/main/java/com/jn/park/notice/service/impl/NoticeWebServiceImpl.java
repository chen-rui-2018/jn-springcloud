package com.jn.park.notice.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.enums.NoticeExceptionEnum;
import com.jn.park.notice.controller.NoticeManageController;
import com.jn.park.notice.dao.NoticeWebDao;
import com.jn.park.notice.model.NoticeDetailShow;
import com.jn.park.notice.model.NoticeManageShow;
import com.jn.park.notice.service.NoticeWebService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/2 16:10
 * @version： v1.0
 * @modified By:
 */
@Service
public class NoticeWebServiceImpl  implements NoticeWebService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(NoticeWebServiceImpl.class);

    @Autowired
    private NoticeWebDao noticeWebDao;

    @ServiceLog(doAction = "app首页弹出公告列表")
    @Override
    public List<NoticeDetailShow> popupNoticeListForApp() {
        List<NoticeDetailShow> noticeList =  noticeWebDao.popupNoticeListForApp();

        return noticeList;
    }
    @ServiceLog(doAction = "门户首页弹出公告列表")
    @Override
    public List<NoticeDetailShow> popupNoticeListForPortal() {
        List<NoticeDetailShow> noticeList =  noticeWebDao.popupNoticeListForPortal();

        return noticeList;
    }
    @ServiceLog(doAction = "门户首页展示(轮播)公告列表")
    @Override
    public PaginationData<List<NoticeDetailShow>> showNoticeListForPortal(Page page) {
        int pageNum = 0;
        int pageSize = 15;
        if(page != null){
            pageNum= page.getPage();
            pageSize = page.getRows();
        }
        com.github.pagehelper.Page<Object> objects = PageHelper.startPage(pageNum,pageSize==0?pageSize:page.getRows());
        List<NoticeDetailShow> noticeList =  noticeWebDao.showNoticeListForPortal();


        return new PaginationData(noticeList,objects==null?0:objects.getTotal()) ;
    }
    @ServiceLog(doAction = "app首页展示(轮播)公告列表")
    @Override
    public PaginationData<List<NoticeDetailShow>> showNoticeListForApp(Page page) {
        int pageNum = 0;
        int pageSize = 15;
        if(page != null){
            pageNum= page.getPage();
            pageSize = page.getRows();
        }
        com.github.pagehelper.Page<Object> objects = PageHelper.startPage(pageNum,pageSize==0?pageSize:page.getRows());
        List<NoticeDetailShow> noticeList =  noticeWebDao.showNoticeListForApp();

        return  new PaginationData(noticeList,objects==null?0:objects.getTotal());
    }
    @ServiceLog(doAction = "app公告列表")
    @Override
    public  PaginationData<List<NoticeDetailShow>> noticeListApp(Page page) {
        int pageNum = 0;
        int pageSize = 15;
        if(page != null){
            pageNum= page.getPage();
            pageSize = page.getRows();
        }
        com.github.pagehelper.Page<Object> objects = PageHelper.startPage(pageNum,pageSize==0?pageSize:page.getRows());
        List<NoticeDetailShow> noticeList =  noticeWebDao.noticeListApp();

        return new PaginationData(noticeList,objects==null?0:objects.getTotal());
    }
    @ServiceLog(doAction = "门户公告列表")
    @Override
    public PaginationData<List<NoticeDetailShow>> noticeListPortal(Page page) {
        int pageNum = 0;
        int pageSize = 15;
        if(page != null){
            pageNum= page.getPage();
            pageSize = page.getRows();
        }
        com.github.pagehelper.Page<Object> objects = PageHelper.startPage(pageNum,pageSize==0?pageSize:page.getRows());
        List<NoticeDetailShow> noticeList =  noticeWebDao.noticeListPortal();

        return new PaginationData(noticeList,objects==null?0:objects.getTotal());
    }
    @ServiceLog(doAction = "公告详情查看")
    @Override
    public NoticeDetailShow findNoticeDetailsByNoticeId(String noticeId) {
        NoticeDetailShow  notice=  noticeWebDao.findNoticeDetailsByNoticeId(noticeId);
        if(notice==null){
            throw new JnSpringCloudException(NoticeExceptionEnum.NOTICE_NOT_EXIST);
        }


        return notice;
    }



}
