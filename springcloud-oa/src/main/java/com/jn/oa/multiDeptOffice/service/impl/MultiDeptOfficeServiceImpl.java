package com.jn.oa.multiDeptOffice.service.impl;

import com.jn.common.channel.MessageSource;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.news.vo.AppSinkVo;
import com.jn.news.vo.SmsTemplateVo;
import com.jn.oa.item.service.impl.WorkPlanServiceImpl;
import com.jn.oa.multiDeptOffice.dao.MultiDeptOfficeMapper;
import com.jn.oa.multiDeptOffice.enums.MultiDeptOfficeNoticesTemplateEnums;
import com.jn.oa.multiDeptOffice.enums.RemindWayEnums;
import com.jn.oa.multiDeptOffice.model.MultiDeptOffice;
import com.jn.oa.multiDeptOffice.service.MultiDeptOfficeService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 多部门协同service实现
 *
 * @author： shaobao
 * @date： Created on 2019/4/13 22:53
 * @version： v1.0
 * @modified By:
 **/
@Service
public class MultiDeptOfficeServiceImpl implements MultiDeptOfficeService {
    /**
     * 日志组件
     */
    private static final Logger logger = LoggerFactory.getLogger(WorkPlanServiceImpl.class);

    @Autowired
    private MultiDeptOfficeMapper multiDeptOfficeMapper;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserExtensionClient userExtensionClient;


    /**
     * 更新多部门协同状态信息
     */
    @Override
    @ServiceLog(doAction = "更新多部门协同状态信息")
    @Transactional(rollbackFor = Exception.class)
    public void updateMultiDeptOfficeStatus() {
        multiDeptOfficeMapper.updateMultiDeptOfficeStatus();
    }

    /**
     * 定时提醒功能
     */
    @Override
    @ServiceLog(doAction = "定时提醒功能")
    public void remind() {
        List<MultiDeptOffice> multiDeptOffices = multiDeptOfficeMapper.getMultiDeptOfficeByStatus();
        if (multiDeptOffices != null && multiDeptOffices.size() > 0) {
            for (MultiDeptOffice multiDeptOffice : multiDeptOffices) {
                //获取协调部门用户信息
                String[] ids = multiDeptOffice.getUserIds().split(",");
                List<User> userList = multiDeptOfficeMapper.getUser(ids);
                //判断协同任务的提醒方式
                String[] split = multiDeptOffice.getRemindWay().split(",");
                for (String way : split) {
                    if (RemindWayEnums.WE_CHAT.getCode().equals(way)) {
                        //TODO: 调用微信推动消息接口,等在接口提供在完善

                    } else if (RemindWayEnums.MESSAGE.getCode().equals(way)) {
                        //获取协同部门人员的手机号
                        List<String> phones = new ArrayList<String>(16);
                        for (User user : userList) {
                            if (StringUtils.isNotBlank(user.getPhone())) {
                                phones.add(user.getPhone());
                            }
                        }

                        if (phones.size() > 0) {
                            //发送短信通知
                            SmsTemplateVo smsTemplateVo = new SmsTemplateVo();
                            smsTemplateVo.setTemplateId(MultiDeptOfficeNoticesTemplateEnums.MESSAGE_TEMPLATE.getCode());
                            String[] m = phones.toArray(new String[phones.size()]);
                            smsTemplateVo.setMobiles(m);
                            String[] t = {multiDeptOffice.getTitle()};
                            smsTemplateVo.setContents(t);
                            messageSource.outputSms().send(MessageBuilder.withPayload(smsTemplateVo).build());
                        }

                        logger.info("[多部门协同] 短信提醒！,multiDeptOfficeId: {}，phone：{}",
                                multiDeptOffice.getId(), phones.toString());
                    } else if (RemindWayEnums.APP.getCode().equals(way)) {
                        //app推送通知
                        appSend(multiDeptOffice, userList);
                    }
                }
            }
        }
    }

    /**
     * app推送通知功能
     *
     * @param multiDeptOffice
     * @param userList
     */
    private void appSend(MultiDeptOffice multiDeptOffice, List<User> userList) {
        List<String> registrationIds = new ArrayList<>(16);
        //进行app功能提醒,获取协调用户app极光推送id
        for (User user : userList) {
            String account = user.getAccount();
            Result<UserExtensionInfo> userResult = userExtensionClient.getUserExtension(account);
            if (userResult == null || userResult.getData() == null) {
                logger.warn("[消息极光推送] 获取用户信息失败，account：{}", account);
                continue;
            }

            String registrationId = userResult.getData().getRegistrationId();
            if (StringUtils.isBlank(registrationId)) {
                logger.warn("[消息极光推送] 用户未绑定设备ID，account：{}", account);
                continue;
            } else {
                registrationIds.add(registrationId);
            }

        }

        //如果极光推送ids不为空,
        if (registrationIds != null && registrationIds.size() > 0) {
            //进行app功能推送
            AppSinkVo appSinkVo = new AppSinkVo();
            appSinkVo.setTitle("多部门协同事项提醒");
            appSinkVo.setContent(multiDeptOffice.getTitle());
            // 推送方式（DEVICE：设备 TAG：标签）
            String pushType = "DEVICE";
            // 平台类型 ANDROID/IOS/null  如果为null 则发送给所有平台
            String platFromType = null;
            // 推送通知类型（ALL：全部 NOTICE：通知 MESSAGE：透传消息）
            String noticeType = "NOTICE";
            // 透传消息内容
            String message = multiDeptOffice.getContent();
            appSinkVo.setIds(registrationIds);
            appSinkVo.setPushType(pushType);
            appSinkVo.setNoticeType(noticeType);
            appSinkVo.setPlatFromType(platFromType);
            appSinkVo.setMessage(message);
            boolean result = messageSource.outputApp().send(MessageBuilder.withPayload(appSinkVo).build());
            if (result){
                logger.info("[多部门协同] 为用户推送app消息通知成功，协调事项ID：{}",multiDeptOffice.getId());
            }else {
                logger.error("[多部门协同] 为用户推送app消息通知失败，协调事项ID：{}",multiDeptOffice.getId());
            }
        }
    }

}
