package com.jn.park.notice.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.park.enums.NoticeExceptionEnum;
import com.jn.park.notice.dao.NoticeWebDao;
import com.jn.park.notice.model.NoticeDetailShow;
import com.jn.park.notice.service.NoticeWebService;
import com.jn.park.notice.vo.IntegrationListVo;
import com.jn.park.utils.HtmlUtils;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<IntegrationListVo> integrationList() {
        List<IntegrationListVo> integrationList=noticeWebDao.integrationList();
        //把简介中的HTML去除掉.
        for (int i = 0;i<integrationList.size();i++){
            IntegrationListVo integrationListVo=integrationList.get(i);
            String intro = integrationListVo.getIntro();
            //设置简要内容
            String briefContent= HtmlUtils.getBriefIntroduction(integrationListVo.getIntro());
            if(StringUtils.isNotBlank(briefContent)){
                String briefSummaries=briefContent.substring(0,briefContent.length()>100?100:briefContent.length());
                briefSummaries=briefContent.length()>100?briefSummaries+"......":briefSummaries;
                integrationListVo.setNoticeBiref(briefSummaries);
                //清空详情
                integrationListVo.setIntro("");
            }

        }

        return integrationList;
    }

    @ServiceLog(doAction = "app首页弹出公告列表")
    @Override
    public List<NoticeDetailShow> popupNoticeListForApp() {
        List<NoticeDetailShow> noticeList =  noticeWebDao.popupNoticeListForApp();
        noticeList = addNoticeBrief(noticeList);
        return noticeList;
    }
    @ServiceLog(doAction = "门户首页弹出公告列表")
    @Override
    public List<NoticeDetailShow> popupNoticeListForPortal() {
        List<NoticeDetailShow> noticeList =  noticeWebDao.popupNoticeListForPortal();
        noticeList = addNoticeBrief(noticeList);
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

        noticeList = addNoticeBrief(noticeList);
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
        noticeList = addNoticeBrief(noticeList);
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
        noticeList = addNoticeBrief(noticeList);
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
        noticeList = addNoticeBrief(noticeList);
        return new PaginationData(noticeList,objects==null?0:objects.getTotal());
    }
    @ServiceLog(doAction = "公告详情查看")
    @Override
    public NoticeDetailShow findNoticeDetailsByNoticeId(String noticeId) {
        NoticeDetailShow  notice=  noticeWebDao.findNoticeDetailsByNoticeId(noticeId);
        if(notice==null){
            throw new JnSpringCloudException(NoticeExceptionEnum.NOTICE_NOT_EXIST);
        }
        List<NoticeDetailShow> noticeList= new ArrayList<>();
        noticeList.add(notice);
        noticeList = addNoticeBrief(noticeList);
        notice = noticeList.get(0);
        return notice;
    }

    /**
     * 公告添加内容简介
     * @param noticeList
     * @return
     */
    private List<NoticeDetailShow> addNoticeBrief(List<NoticeDetailShow> noticeList) {
        for (NoticeDetailShow show : noticeList) {
            String briefContent = show.getNoticeDetails();
            if(StringUtils.isNotBlank(briefContent)){
                briefContent = briefContent.replaceAll("</?[^>]+>", "");
                if (StringUtils.isNotBlank(briefContent)) {
                    String briefSummaries = briefContent.substring(0, briefContent.length() > 100 ? 100 : briefContent.length());
                    briefSummaries = briefContent.length() > 100 ? briefSummaries + "......" : briefSummaries;
                    show.setNoticeBiref(briefSummaries);
                }
            }
        }
         return  noticeList;
    }
}
