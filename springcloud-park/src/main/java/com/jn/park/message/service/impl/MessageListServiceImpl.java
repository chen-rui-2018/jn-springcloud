package com.jn.park.message.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.channel.MessageSource;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.news.enums.JPushEnum;
import com.jn.news.vo.AppSinkVo;
import com.jn.park.finance.enums.FinanceBudgetExceptionEnums;
import com.jn.park.message.dao.MessageListDao;
import com.jn.park.message.model.*;
import com.jn.park.message.service.MessageListService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: tangry
 * @Date: 2019/4/19
 * @Version 1.0
 */
@Service
@Transactional
public class MessageListServiceImpl implements MessageListService {

    @Autowired
    private MessageListDao messageListDao;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserExtensionClient userExtensionClient;

    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(MessageListServiceImpl.class);

    @Override
    public List<MessageListModel> findAllList(String messageOneSort,String isRead, User user) {
        List<MessageListModel> findAllList=messageListDao.findAllList(messageOneSort,isRead,user.getAccount());
        return findAllList;
    }

    @ServiceLog(doAction = "获取二级消息类别")
    @Override
    public List<MessageTowListModel> getMessageOneTort(String messageOneTort,User user) {
        if(StringUtils.isBlank(messageOneTort)){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"请输入一级类型");
        }
        List<MessageTowListModel> lists=messageListDao.getMessageOneTort(user.getAccount(),messageOneTort);
        return lists;
    }


    @Override
    public PaginationData<List<MessageListModel>> findAllApp(findAllAppMessageListModel fModel, User user) {
        if(StringUtils.isBlank(fModel.getMessageOneSort())){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"请输入一级类型");
        }
        Page<Object> objects = PageHelper.startPage(fModel.getPage(), fModel.getRows());
        List<MessageListModel> findAllApp = messageListDao.findAllApp(fModel.getMessageOneSort(),fModel.getIsRead(),user.getAccount());

        return new PaginationData(findAllApp,objects.getTotal());
    }

    @ServiceLog(doAction = "消息列表")
    @Override
    public PaginationData<List<MessageListModel>> findAll(findAllMessageListModel fModel, User user) {

        if(StringUtils.isBlank(fModel.getMessageTowTort())){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"请输入二级类型");
        }
        Page<Object> objects = PageHelper.startPage(fModel.getPage(), fModel.getRows());

        List<MessageListModel> findAllMessageListVoList = messageListDao.findAll(fModel.getMessageTowTort(),fModel.getIsRead(),user.getAccount());
        return new  PaginationData(findAllMessageListVoList,objects.getTotal());
    }

    @Override
    public int getIsRead(String messageOneTort,String messageTowTort,User user) {
        //一级是二级的前提条件
        if(messageTowTort != null){
            if(messageOneTort == null){
                throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"请先输入一级类型");
            }
        }
        //
        if(messageOneTort == null){
            messageOneTort="";
        }
        if(messageTowTort == null){
            messageTowTort="";
        }

        int getIsRead=messageListDao.getIsRead(messageOneTort,messageTowTort,user.getAccount());
        if(getIsRead>0){
            getIsRead=0;
        }else{
            getIsRead=1;
        }
        return getIsRead;
    }

    @ServiceLog(doAction = "添加消息")
    @Override
    public void addMessage(AddMessageModel model) {
       //设置创建人
        model.setCreatorAccount(model.getCreatorAccount());
        //设置UUID作为ID
        model.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        int isSuccess = messageListDao.addMessage(model);

        // 消息添加成功后APP推送消息
        if (isSuccess == 1 && !StringUtils.isAnyBlank(model.getMessageTitle(), model.getMessageContent(), model.getMessageRecipien())) {
            jpushSendMessage(model);
        }
    }

    @ServiceLog(doAction = "根据ID查询单个消息")
    @Override
    public MessageListModel findByMessage(String id) {
        return messageListDao.findByMessage(id);
    }


    @ServiceLog(doAction = "修改消息")
    @Override
    public void updateMessage(MessageListModel messageListModel) {
        //获取用户信息
        User user= (User) SecurityUtils.getSubject().getPrincipal();
        messageListModel.setCreatorAccount(user.getAccount());
        messageListDao.updateMessage(messageListModel);
    }


    @ServiceLog(doAction = "删除消息")
    @Override
    public void deleteMessage(String id) {
        messageListDao.deleteMessage(id);

    }

    @ServiceLog(doAction = "修改已读状态")
    @Override
    public String updateIsReadStatus(String id) {
        try {
            messageListDao.updateIsReadStatus(id);
            return "0";
        }catch (Exception e){
            logger.info("标记已读失败:{}",e);
        }
        return "1";
    }

    /**
     * 消息极光推送
     * @param model
     */
    private void jpushSendMessage(AddMessageModel model) {
        AppSinkVo appSinkVo = new AppSinkVo();
        appSinkVo.setTitle(model.getMessageTitle());
        appSinkVo.setContent(model.getMessageContent());

        String pushType = JPushEnum.J_PUSH_TYPE_DEVICE.getCode();
        String noticeType = JPushEnum.J_PUSH_NOTICE_TYPE_ALL.getCode();
        String message = "{\"type\":\"messageCenter\",\"data\":{\"messageId\":\"" + model.getId() + "\"}}";

        Result<UserExtensionInfo> userResult = userExtensionClient.getUserExtension(model.getMessageRecipien());
        if (userResult == null || userResult.getData() == null) {
            logger.warn("[消息极光推送] 获取用户信息失败，account：{}", model.getMessageRecipien());
            return;
        }

        String registrationId = userResult.getData().getRegistrationId();
        if (StringUtils.isBlank(registrationId)) {
            logger.warn("[消息极光推送] 用户未绑定设备ID，account：{}", model.getMessageRecipien());
            return;
        }

        List<String> registrationIdList = new ArrayList<>();
        registrationIdList.add(registrationId);

        appSinkVo.setIds(registrationIdList);
        appSinkVo.setPushType(pushType);
        appSinkVo.setNoticeType(noticeType);
        appSinkVo.setPlatFromType(null);
        appSinkVo.setMessage(message);
        boolean isSuccess = messageSource.outputApp().send(MessageBuilder.withPayload(appSinkVo).build());
        logger.info("[消息极光推送] 调用消息推送返回：{}", isSuccess);
    }

}
