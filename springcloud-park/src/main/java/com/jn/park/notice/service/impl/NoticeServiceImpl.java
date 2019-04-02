package com.jn.park.notice.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.park.enums.NoticeExceptionEnum;
import com.jn.park.notice.dao.NoticeInfoDao;
import com.jn.park.notice.dao.TbNoticeDetailsMapper;
import com.jn.park.notice.dao.TbNoticeInfoMapper;
import com.jn.park.notice.entity.TbNoticeDetails;
import com.jn.park.notice.entity.TbNoticeInfo;
import com.jn.park.notice.model.NoticeManageShow;
import com.jn.park.notice.model.NoticeModifyParam;
import com.jn.park.notice.model.NoticeQueryParam;
import com.jn.park.notice.model.NoticeShelfParam;
import com.jn.park.notice.service.NoticeService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.callback.Callback;
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
public class NoticeServiceImpl implements NoticeService {
    /**
     * 日志组件
     */
    Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);
    @Autowired
    private TbNoticeInfoMapper noticeInfoMapper;

    @Autowired
    private TbNoticeDetailsMapper noticeDetailsMapper;
    @Autowired
    private UserExtensionClient userClient;
    @Autowired
    private NoticeInfoDao noticeInfoDao;

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
        if(StringUtils.isNotBlank(info.getPlatformType())){
            info.setPlatformName(getPlatformName(info.getPlatformType()));
            }
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
                details.setNoticeId(info.getNoticeId());
                details.setNoticeDetails(param.getNoticeContent().getBytes("UTF-8"));
                noticeDetailsMapper.insert(details);
        }
            }catch(UnsupportedEncodingException e){
                e.printStackTrace();
                logger.info("公告详情转换为byte失败");
                throw new JnSpringCloudException(NoticeExceptionEnum.NOTICE_TRANCE_DETAILS_DEFAULT);

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
        if(noticeList != null && noticeList.size()>0){
            transfromNoticeDetails(noticeList);
        }
        return new PaginationData(noticeList,objects==null?0:objects.getTotal());
    }
    @ServiceLog(doAction = "查找对外公告管理列表")
    @Transactional(rollbackFor=Exception.class)
    @Override
    public int modifyNotice(NoticeModifyParam param, String account) {
        int i = 0;
        try {
            //1.保存传入基本信息
            TbNoticeInfo info =  new TbNoticeInfo();
            BeanUtils.copyProperties(param,info);
            //2.补充字段内容

            info.setStartTime(DateUtils.parseDate(param.getStartTime(),"yyyy-MM-dd"));
            info.setEndTime(DateUtils.parseDate(param.getEndTime(),"yyyy-MM-dd"));
            info.setModifiedTime(new Date());
            info.setModifierAccount(account);

            //3.更新基本信息入库
            i =  noticeInfoMapper.updateByPrimaryKeySelective(info);
            //4.更新公告内容(详情)
            if(StringUtils.isNotBlank(param.getNoticeContent())) {

                TbNoticeDetails details = new TbNoticeDetails();
                details.setNoticeId(info.getNoticeId());
                details.setNoticeDetails(param.getNoticeContent().getBytes("UTF-8"));
                noticeDetailsMapper.updateByPrimaryKeySelective(details);
            }
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
            logger.info("公告详情转换为byte失败");
            throw new JnSpringCloudException(NoticeExceptionEnum.NOTICE_TRANCE_DETAILS_DEFAULT);
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
        List<NoticeManageShow> list= new ArrayList<>();
        list.add(noticeDetails);
        list = transfromNoticeDetails(list);
        return list.get(0);
    }

    @Override
    public int noticeShelfOperate(NoticeShelfParam shelfParam,String account) {

        int i =  noticeInfoDao.noticeShelfOperate(shelfParam.getNoticeId(),shelfParam.getNoticeStatus(),account);
        return i;
    }


    /**
     * 公告内容转换
     * @param noticeList
     * @return
     */
    private List<NoticeManageShow> transfromNoticeDetails(List<NoticeManageShow> noticeList){
        try{
            for (NoticeManageShow show : noticeList){
                if(show.getNoticeDetails() != null){
                    show.setNoticeContent(new String(show.getNoticeDetails(),"UTF-8"));
                    show.setNoticeDetails(null);
                }
            }
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
            logger.info("公告详情byte转换为字符串失败");
            throw new JnSpringCloudException(NoticeExceptionEnum.NOTICE_TRANCE_DETAILS_DEFAULT);
        }
        return noticeList;
    }

    /**
     * 获取平台名称
     * @param platformType
     * @return
     */
    private String getPlatformName(String platformType){
        String platformApp = "App";
        String platformPark = "门户";
        String platformAll = "全部";
        String typeName = null;
        switch (platformType){
                case "0": typeName=platformAll; break;
                case "1": typeName=platformApp; break;
                case "2": typeName=platformPark; break;
                default:
            }
       return typeName;
    }
}
