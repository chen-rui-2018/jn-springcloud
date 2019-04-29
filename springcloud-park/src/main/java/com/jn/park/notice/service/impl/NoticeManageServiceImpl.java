package com.jn.park.notice.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.park.activity.model.ParkCode;
import com.jn.park.enums.NoticeExceptionEnum;
import com.jn.park.notice.dao.NoticeInfoDao;
import com.jn.park.notice.dao.TbNoticeDetailsMapper;
import com.jn.park.notice.dao.TbNoticeInfoMapper;
import com.jn.park.notice.entity.TbNoticeDetails;
import com.jn.park.notice.entity.TbNoticeInfo;
import com.jn.park.notice.model.*;
import com.jn.park.notice.service.NoticeManageService;
import com.jn.park.parkcode.service.ParkCodeService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author： chenr
 * @date： Created on 2019/4/1 9:23
 * @version： v1.0
 * @modified By:
 */
@Service
public class NoticeManageServiceImpl implements NoticeManageService {
    /**
     * 日志组件
     */
    Logger logger = LoggerFactory.getLogger(NoticeManageServiceImpl.class);

    @Autowired
    private TbNoticeInfoMapper noticeInfoMapper;
    @Autowired
    private TbNoticeDetailsMapper noticeDetailsMapper;
    @Autowired
    private UserExtensionClient userClient;
    @Autowired
    private NoticeInfoDao noticeInfoDao;
    @Autowired
    private ParkCodeService parkCodeService;

    @ServiceLog(doAction = "添加(发布)公告信息")
    @Transactional(rollbackFor=Exception.class)
    @Override
    public int addNotice(NoticeModifyParam param,String account) {

        String noticeStatus = "1";
        byte recordStatus = 1;
        int i = 0;
        try {
        //1.保存传入基本信息
        TbNoticeInfo info =  new TbNoticeInfo();
        BeanUtils.copyProperties(param,info);
        //2.补充字段内容
        info.setId(param.getNoticeId());
        info.setStartTime(DateUtils.parseDate(param.getStartTime(),"yyyy-MM-dd"));
        info.setEndTime(DateUtils.parseDate(param.getEndTime(),"yyyy-MM-dd"));
        info.setCreatedTime(new Date());
        info.setRecordStatus(recordStatus);
        info.setCreatorAccount(account);
        info.setNoticeStatus(noticeStatus);
        Result<UserExtensionInfo> userResult =userClient.getUserExtension(account);
        if(userResult.getData()!=null){
            info.setPublishName(userResult.getData().getName());
        }
        //3.基本信息入库
        i =  noticeInfoMapper.insertSelective(info);
        //4.保存公告内容(详情)
        if(StringUtils.isNotBlank(param.getNoticeContent())) {

                TbNoticeDetails details = new TbNoticeDetails();
                details.setNoticeId(info.getId());
                details.setId((info.getId()));
                details.setNoticeDetails(param.getNoticeContent());
                noticeDetailsMapper.insert(details);
        }
            }catch (ParseException e){
                e.printStackTrace();
                logger.info("生效/失效日期格式不规范-转换错误");
                throw new JnSpringCloudException(NoticeExceptionEnum.NOTICE_TIME_PARSE_DEFAULT);
        }
        return i;
    }
    @ServiceLog(doAction = "查找对外公告管理列表")
    @Override
    public PaginationData<List<NoticeManageShow>> findNoticeList(NoticeQueryParam queryParam) {
        int pageSize = 15;
        int pageNmu = 0;
        if(queryParam != null ){
            pageNmu = queryParam.getPage();
            pageSize = queryParam.getRows();
        }
        Page<Object> objects =  PageHelper.startPage(pageNmu,pageSize==0?15:pageSize,true);

        List<NoticeManageShow> noticeList =  noticeInfoDao.findNoticeList(queryParam);

        return new PaginationData(noticeList,objects==null?0:objects.getTotal());
    }
    @ServiceLog(doAction = "编辑公告")
    @Transactional(rollbackFor=Exception.class)
    @Override
    public int modifyNotice(NoticeModifyParam param, String account) {
        int i = 0;
        try {
            //1.保存传入基本信息
            TbNoticeInfo info =  new TbNoticeInfo();
            BeanUtils.copyProperties(param,info);
            //2.补充字段内容
            info.setId(param.getNoticeId());
            info.setStartTime(DateUtils.parseDate(param.getStartTime(),"yyyy-MM-dd"));
            info.setEndTime(DateUtils.parseDate(param.getEndTime(),"yyyy-MM-dd"));
            info.setModifiedTime(new Date());
            info.setModifierAccount(account);

            //3.更新基本信息入库
            i =  noticeInfoMapper.updateByPrimaryKeySelective(info);
            //4.更新公告内容(详情)
            if(StringUtils.isNotBlank(param.getNoticeContent())) {

                TbNoticeDetails details = new TbNoticeDetails();
                details.setId(info.getId());
                details.setNoticeId(info.getId());
                details.setNoticeDetails(param.getNoticeContent());
                noticeDetailsMapper.updateByPrimaryKeySelective(details);
            }
        }catch (ParseException e){
            e.printStackTrace();
            logger.info("生效/失效日期格式不规范-转换错误");
            throw new JnSpringCloudException(NoticeExceptionEnum.NOTICE_TIME_PARSE_DEFAULT);
        }

        return i;
    }
    @ServiceLog(doAction = "后台产看公告详情(可用于编辑页面回显)")
    @Override
    public NoticeManageShow findNoticeDetails(String noticeId) {
        NoticeManageShow noticeDetails =  noticeInfoDao.findNoticeDetails(noticeId);
        if(noticeDetails == null ){
            throw new JnSpringCloudException(NoticeExceptionEnum.NOTICE_NOT_EXIST);
        }
        return noticeDetails;
    }
    @ServiceLog(doAction = "公告上下架操作")
    @Override
    public int noticeShelfOperate(NoticeShelfParam shelfParam,String account) {

        int i =  noticeInfoDao.noticeShelfOperate(shelfParam.getNoticeId(),shelfParam.getNoticeStatus(),account);
        return i;
    }
    @ServiceLog(doAction = "公告平台列表")
    @Override
    public List<NoticePlatformShow> findPlatformList(String codeType) {
       List<NoticePlatformShow> platformShows= new ArrayList<>(16);
       List<ParkCode> parkCodes = parkCodeService.getParkCodeByType(codeType);
       if(parkCodes!=null && parkCodes.size()>0){
           for(ParkCode parkCode : parkCodes){
               NoticePlatformShow show = new NoticePlatformShow();
               show.setPlatformType(parkCode.getCodeValue());
               show.setPlatformName(parkCode.getCodeName());
               platformShows.add(show);
           }
       }
        return platformShows;
    }



}
