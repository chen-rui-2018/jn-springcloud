package com.jn.park.notice.service.impl;

import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.park.notice.dao.TbNoticeDetailsMapper;
import com.jn.park.notice.dao.TbNoticeInfoMapper;
import com.jn.park.notice.entity.TbNoticeDetails;
import com.jn.park.notice.entity.TbNoticeInfo;
import com.jn.park.notice.model.NoticeModifyParam;
import com.jn.park.notice.service.NoticeService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;


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
    @ServiceLog(doAction = "添加(发布)公告信息")
    @Override
    public int addNotice(NoticeModifyParam param,String account) {
        String platformApp = "App";
        String platformPark = "门户";
        String platformAll = "全部";
        String noticeStatus = "1";
        byte recordStatus = 1;
        int i = 0;
        try {
        //1.保存传入基本信息
        TbNoticeInfo info =  new TbNoticeInfo();
        BeanUtils.copyProperties(param,info);
        //2.补充字段内容
        if(StringUtils.isNotBlank(info.getPlatformType())){
            String  type = info.getPlatformType();
            switch (type){
                case "0": info.setPlatformName(platformAll); break;
                case "1": info.setPlatformName(platformApp); break;
                case "2": info.setPlatformName(platformPark); break;
                default:
            }
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
            }catch(Exception e){
                e.printStackTrace();
                logger.info("公告详情转换为byte失败");
            }

        return i;
    }
}
