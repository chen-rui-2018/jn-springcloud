package com.jn.park.message.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.park.finance.enums.FinanceBudgetExceptionEnums;
import com.jn.park.finance.vo.FinanceExpendHistoryVo;
import com.jn.park.message.dao.MessageListDao;
import com.jn.park.message.model.*;
import com.jn.park.message.service.MessageListService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
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


    @ServiceLog(doAction = "获取二级消息类别")
    @Override
    public List<MessageTowListModel> getMessageOneTort(String messageOneTort,User user) {
        if(StringUtils.isBlank(messageOneTort)){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"请输入一级类型");
        }
        List<MessageTowListModel> messageTowListModels=new ArrayList<>();

        List<MessageTowModel> lists=messageListDao.getMessageOneTort(user.getAccount(),messageOneTort);
        for (int i=0;i<lists.size();i++){
            //1：个人动态，2：企业订单，3：信息发布动态，4：交费提醒，5：访客留言，6：数据上报提醒，7：机构邀请，8：企业邀请，9：机构邀请，10：私人订单
            MessageTowListModel messageTowListModel=new MessageTowListModel();
            if(lists.get(i).getMessageOneTortCode().equals("1")){
                messageTowListModel.setMessageOneTortCode(lists.get(i).getMessageOneTortCode());
                messageTowListModel.setMessageOneTortName("个人动态");
            }
            if(lists.get(i).getMessageOneTortCode().equals("2")){
                messageTowListModel.setMessageOneTortCode(lists.get(i).getMessageOneTortCode());
                messageTowListModel.setMessageOneTortName("企业订单");
            }
            if(lists.get(i).getMessageOneTortCode().equals("3")){
                messageTowListModel.setMessageOneTortCode(lists.get(i).getMessageOneTortCode());
                messageTowListModel.setMessageOneTortName("信息发布动态");
            }
            if(lists.get(i).getMessageOneTortCode().equals("4")){
                messageTowListModel.setMessageOneTortCode(lists.get(i).getMessageOneTortCode());
                messageTowListModel.setMessageOneTortName("交费提醒");
            }
            if(lists.get(i).getMessageOneTortCode().equals("5")){
                messageTowListModel.setMessageOneTortCode(lists.get(i).getMessageOneTortCode());
                messageTowListModel.setMessageOneTortName("访客留言");
            }
            if(lists.get(i).getMessageOneTortCode().equals("6")){
                messageTowListModel.setMessageOneTortCode(lists.get(i).getMessageOneTortCode());
                messageTowListModel.setMessageOneTortName("数据上报提醒");
            }
            if(lists.get(i).getMessageOneTortCode().equals("7")){
                messageTowListModel.setMessageOneTortCode(lists.get(i).getMessageOneTortCode());
                messageTowListModel.setMessageOneTortName("机构邀请");
            }
            if(lists.get(i).getMessageOneTortCode().equals("8")){
                messageTowListModel.setMessageOneTortCode(lists.get(i).getMessageOneTortCode());
                messageTowListModel.setMessageOneTortName("企业邀请");
            }
            if(lists.get(i).getMessageOneTortCode().equals("9")){
                messageTowListModel.setMessageOneTortCode(lists.get(i).getMessageOneTortCode());
                messageTowListModel.setMessageOneTortName("机构邀请");
            }
            if(lists.get(i).getMessageOneTortCode().equals("10")){
                messageTowListModel.setMessageOneTortCode(lists.get(i).getMessageOneTortCode());
                messageTowListModel.setMessageOneTortName("私人订单");
            }
            messageTowListModels.add(messageTowListModel);
        }


        return messageTowListModels;
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
        messageListDao.addMessage(model);
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
    public void updateIsReadStatus(String id) {
        messageListDao.updateIsReadStatus(id);
    }
}
