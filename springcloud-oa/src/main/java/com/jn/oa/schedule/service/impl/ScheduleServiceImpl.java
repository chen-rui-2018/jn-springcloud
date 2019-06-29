package com.jn.oa.schedule.service.impl;

import com.jn.common.channel.MessageSource;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.news.vo.AppSinkVo;
import com.jn.news.vo.SmsTemplateVo;
import com.jn.oa.common.enums.OaExceptionEnums;
import com.jn.oa.common.enums.OaStatusEnums;
import com.jn.oa.common.util.DelaySendMessageUtil;
import com.jn.oa.model.Schedule;
import com.jn.oa.schedule.dao.ScheduleMapper;
import com.jn.oa.schedule.dao.TbOaScheduleMapper;
import com.jn.oa.schedule.entity.TbOaSchedule;
import com.jn.oa.schedule.enums.RemindWayEnums;
import com.jn.oa.schedule.enums.ScheduleExceptionEnums;
import com.jn.oa.schedule.enums.ScheduleMessageTemplateEnums;
import com.jn.oa.schedule.enums.ScheduleRemindEnums;
import com.jn.oa.schedule.model.ScheduleEdit;
import com.jn.oa.schedule.model.ScheduleQuery;
import com.jn.oa.schedule.service.ScheduleService;
import com.jn.send.api.DelaySendMessageClient;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.user.api.MiniProgramRegisterClient;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 日程管理服务层
 *
 * @author： shaobao
 * @date： Created on 2019/3/22 16:57
 * @version： v1.0
 * @modified By:
 **/
@Service
public class ScheduleServiceImpl implements ScheduleService {

    /**
     * 日子组件
     */
    private static final Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);

    /**
     * 获取OA的服务ID
     */
    private final static String OA_CLIENT = "springcloud-oa";
    /**
     * 获取定时发送的服务地址
     */
    private final static String OA_CLIENT_SCHEDULE_REMIND = "/api/oa/scheduleRemind";

    @Autowired
    private TbOaScheduleMapper tbOaScheduleMapper;

    @Autowired
    private DelaySendMessageClient delaySendMessageClient;

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Autowired
    private SystemClient systemClient;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserExtensionClient userExtensionClient;

    @Autowired
    private MiniProgramRegisterClient miniProgramRegisterClient;

    /**
     * 添加/编辑日程
     *
     * @param schedule 日程管理数据
     * @param isAdd    是否添加
     * @param user     当前用户
     */
    @Override
    @ServiceLog(doAction = "添加/编辑日程")
    @Transactional(rollbackFor = Exception.class)
    public void addOrUpdate(ScheduleEdit schedule, Boolean isAdd, User user) {
        String scheduleId = schedule.getId();

        //1.对开始时间,截止时间进行判断
        Date startTime = schedule.getStartTime();
        if (startTime.after(schedule.getEndTime())) {
            logger.warn("[日程管理] 日程添加失败,scheduleId:{}", scheduleId);
            throw new JnSpringCloudException(ScheduleExceptionEnums.SCHEDULE_TIME_ERROR);
        }

        //2.添加/编辑日程
        if (isAdd) {
            //添加操作
            addSchedule(schedule, user);

        } else {
            //编辑数据
            updateSchedule(schedule, user);
        }

    }

    /**
     * (逻辑)删除日程
     *
     * @param scheduleId 日程id
     * @param user       当前用户
     */
    @Override
    @ServiceLog(doAction = "(逻辑)删除日程")
    @Transactional(rollbackFor = Exception.class)
    public void delete(String scheduleId, User user) {
        TbOaSchedule tbOaSchedule = tbOaScheduleMapper.selectByPrimaryKey(scheduleId);
        if (tbOaSchedule != null &&
                StringUtils.equals(OaStatusEnums.EFFECTIVE.getCode(), tbOaSchedule.getRecordStatus().toString())) {

            tbOaSchedule.setRecordStatus(new Byte(OaStatusEnums.DELETED.getCode()));
            tbOaSchedule.setModifiedTime(new Date());
            tbOaSchedule.setModifierAccount(user.getAccount());
            tbOaScheduleMapper.updateByPrimaryKeySelective(tbOaSchedule);
            logger.info("[日程管理] 日程删除成功,scheduleId:{}", scheduleId);
        }
        logger.info("[日程管理] 日程删除成功,scheduleId:{}", scheduleId);
    }

    /**
     * 查询日程
     *
     * @param scheduleQuery 查询条件
     * @return
     */
    @Override
    @ServiceLog(doAction = "查询条件")
    public List<Schedule> list(ScheduleQuery scheduleQuery) {
        Date endTime = scheduleQuery.getEndTime();
        Date startTime = scheduleQuery.getStartTime();
        Boolean flag = (endTime == null && startTime != null) || (endTime != null && startTime == null);
        if (flag) {
            logger.warn("[日程管理] 日程查询失败");
            throw new JnSpringCloudException(ScheduleExceptionEnums.QUERY_DATE_NOT_EMPTY);
        }
        List<Schedule> scheduleList = scheduleMapper.list(scheduleQuery);
        return scheduleList;
    }

    @Override
    @ServiceLog(doAction = "查询条件")
    public Schedule getScheduleById(String id) {
        TbOaSchedule tbOaSchedule = tbOaScheduleMapper.selectByPrimaryKey(id);
        if (tbOaSchedule != null &&
                StringUtils.equals(OaStatusEnums.EFFECTIVE.getCode(), tbOaSchedule.getRecordStatus().toString())) {
            Schedule schedule = new Schedule();
            BeanUtils.copyProperties(tbOaSchedule, schedule);
            schedule.setDate(tbOaSchedule.getStartTime());
            schedule.setStart(tbOaSchedule.getStartTime());
            schedule.setEnd(tbOaSchedule.getEndTime());
            return schedule;
        }
        return null;
    }

    /**
     * 定时提醒功能
     *
     * @param schedule
     */
    @Override
    @ServiceLog(doAction = "定时提醒功能")
    public void scheduleRemind(Schedule schedule) {
        String id = schedule.getId();
        TbOaSchedule tbOaSchedule = tbOaScheduleMapper.selectByPrimaryKey(id);
        //判断当前查询信息是否存在或则时候被删除
        if (tbOaSchedule == null ||
                StringUtils.equals(OaStatusEnums.DELETED.getCode(), tbOaSchedule.getRecordStatus().toString())) {
            logger.info("[日程管理] 日程管理提醒用户信息已删除或信息不存在,日程id:{}", id);
            return;
        } else {
            //判断当前信息,是否设置提醒功能
            String isRemind = tbOaSchedule.getIsRemind();
            if (StringUtils.equals(ScheduleRemindEnums.YES.getCode(), isRemind)) {
                //获取提醒时间
                String remindTime1 = DateUtils.formatDate(tbOaSchedule.getRemindTime(), "yyyy-MM-dd HH:mm");
                String remindTime2 = DateUtils.formatDate(schedule.getRemindTime(), "yyyy-MM-dd HH:mm");
                //判断是狗修改提醒时间
                if (!StringUtils.equals(remindTime2, remindTime1)) {
                    logger.info("[日程管理] 用户日程提醒时间不是当前时间,日程id:{}", id);
                    return;
                } else {
                    //获取用户提醒方式
                    String remindWay = tbOaSchedule.getRemindWay();
                    String[] remindWays = remindWay.split(",");
                    String account = tbOaSchedule.getCreatorAccount();

                    //遍历提醒方式进行提醒
                    for (String way : remindWays) {
                        //1.如果是微信提醒,进行微信提醒功能
                        if (StringUtils.equals(RemindWayEnums.WE_CHAT.getCode(), way)) {
                            //TODO 暂时没有微信模板,等有微信模板再完成微信推送
//                            Result openIdResult = miniProgramRegisterClient.getOpenIdByAccount(account);
//                            if (openIdResult == null || openIdResult.getData() == null) {
//                                logger.warn("[日程管理] 获取用户openId失败，account：{}", account);
//                            }else{
//                                String openId = (String)openIdResult.getData();
//                            }
                        } else if (StringUtils.equals(RemindWayEnums.MESSAGE.getCode(), way)) {
                            //进行短信功能提醒
                            messageRemind(id, tbOaSchedule, account);

                        } else if (StringUtils.equals(RemindWayEnums.APP.getCode(), way)) {
                            //进行APP功能提醒
                            appRemind(id, tbOaSchedule, account);
                        }
                    }
                }
            }
        }
    }

    /**
     * 短信提醒
     *
     * @param id           日程id
     * @param tbOaSchedule 日程信息
     * @param account      用户账号
     */
    private void messageRemind(String id, TbOaSchedule tbOaSchedule, String account) {
        User user = new User();
        user.setAccount(account);
        Result<User> userResult = systemClient.getUser(user);

        if (userResult == null || userResult.getData() == null) {
            logger.warn("[日程管理] 获取用户信息失败，account：{}", account);
        } else {
            //获取用户手机号
            String phone = userResult.getData().getPhone();
            if (StringUtils.isNotBlank(phone)) {
                //发送短信通知
                SmsTemplateVo smsTemplateVo = new SmsTemplateVo();
                smsTemplateVo.setTemplateId(ScheduleMessageTemplateEnums.MESSAGE_TEMPLATE.getCode());
                String[] m = {phone};
                smsTemplateVo.setMobiles(m);
                String[] t = {tbOaSchedule.getTitle()};
                smsTemplateVo.setContents(t);
                boolean result = messageSource.outputSms().send(MessageBuilder.withPayload(smsTemplateVo).build());
                if (result) {
                    logger.info("[日程管理] 为用户推送短信通知成功，日程ID：{}", id);
                } else {
                    logger.error("[日程管理] 为用户推送短信通知失败，日程ID：{}", id);
                }
            }
        }
    }

    /**
     * app通知功能
     *
     * @param id           日程id
     * @param tbOaSchedule 日程内容
     * @param account      用户账号
     */
    private void appRemind(String id, TbOaSchedule tbOaSchedule, String account) {
        Result<UserExtensionInfo> userResult = userExtensionClient.getUserExtension(account);
        if (userResult == null || userResult.getData() == null) {
            logger.warn("[日程管理] 获取用户信息扩展信息失败，account：{}", account);
        } else {
            //获取用户appid
            String registrationId = userResult.getData().getRegistrationId();
            if (StringUtils.isNotBlank(registrationId)) {
                List<String> registrationIds = new ArrayList<>(16);
                //进行app提醒功能推送
                AppSinkVo appSinkVo = new AppSinkVo();
                appSinkVo.setTitle("日程提醒");
                appSinkVo.setContent(tbOaSchedule.getTitle());
                // 推送方式（DEVICE：设备 TAG：标签）
                String pushType = "DEVICE";
                // 平台类型 ANDROID/IOS/null  如果为null 则发送给所有平台
                String platFromType = null;
                // 推送通知类型（ALL：全部 NOTICE：通知 MESSAGE：透传消息）
                String noticeType = "NOTICE";
                // 透传消息内容
                String message = tbOaSchedule.getContent();
                appSinkVo.setIds(registrationIds);
                appSinkVo.setPushType(pushType);
                appSinkVo.setNoticeType(noticeType);
                appSinkVo.setPlatFromType(platFromType);
                appSinkVo.setMessage(message);
                boolean result = messageSource.outputApp().send(MessageBuilder.withPayload(appSinkVo).build());
                if (result) {
                    logger.info("[日程管理] 为用户推送app通知成功，日程ID：{}", id);
                } else {
                    logger.error("[日程管理] 为用户推送app通知失败，日程ID：{}", id);
                }
            }
        }
    }

    /**
     * 修改日程
     *
     * @param schedule
     * @param user
     */
    private void updateSchedule(ScheduleEdit schedule, User user) {
        String scheduleId = schedule.getId();
        String account = user.getAccount();
        Date remindTime = schedule.getRemindTime();

        //1.校验修改信息是否存在
        TbOaSchedule tbOaSchedule = checkScheduleExist(scheduleId);

        //设置定时,判断修改数据要求设置定时,且修改了之前定时时间,重新发送定时请求
        if (StringUtils.equals(ScheduleRemindEnums.YES.getCode(), schedule.getIsRemind())) {
            //校验发送
            checkRemind(schedule, user);

            //判断是否修改定时时间
            Date oldRemindTime = tbOaSchedule.getRemindTime();
            if (oldRemindTime != null) {
                String oldRemind = DateUtils.formatDate(oldRemindTime, "yyyy-MM-dd HH:mm");
                String newRemind = DateUtils.formatDate(remindTime, "yyyy-MM-dd HH:mm");
                if (!StringUtils.equals(newRemind, oldRemind)) {
                    //设置定时发送
                    DelaySendMessageUtil.delaySend(OA_CLIENT, OA_CLIENT_SCHEDULE_REMIND,
                            remindTime, tbOaSchedule, delaySendMessageClient);
                }
            }
        }
        BeanUtils.copyProperties(schedule, tbOaSchedule);
        //修改数据
        tbOaSchedule.setModifiedTime(new Date());
        tbOaSchedule.setModifierAccount(account);
        tbOaScheduleMapper.updateByPrimaryKeySelective(tbOaSchedule);
        logger.info("[日程管理] 日程修改成功,scheduleId:{}", scheduleId);
    }

    /**
     * 校验发送
     *
     * @param schedule
     * @param user
     */
    private void checkRemind(ScheduleEdit schedule, User user) {
        String scheduleId = schedule.getId();
        Date remindTime = schedule.getRemindTime();
        Assert.notNull(remindTime, ScheduleExceptionEnums.REMIND_TIME_NOT_NULL.getMessage());
        if (remindTime.before(new Date())) {
            logger.warn("[日程管理] 日程修改/添加失败,scheduleId:{}", scheduleId);
            throw new JnSpringCloudException(ScheduleExceptionEnums.REMIND_TIME_ERROR);
        }
    }

    /**
     * 添加日程
     *
     * @param schedule
     * @param user
     */
    private void addSchedule(ScheduleEdit schedule, User user) {
        String scheduleId = schedule.getId();
        String account = user.getAccount();
        Date remindTime = schedule.getRemindTime();

        TbOaSchedule tbOaSchedule = new TbOaSchedule();
        BeanUtils.copyProperties(schedule, tbOaSchedule);

        //设置创建人及创建时间
        tbOaSchedule.setCreatorAccount(account);
        tbOaSchedule.setCreatedTime(new Date());
        tbOaSchedule.setRecordStatus(new Byte(OaStatusEnums.EFFECTIVE.getCode()));

        //3.发送定时提醒信息
        if (StringUtils.equals(ScheduleRemindEnums.YES.getCode(), schedule.getIsRemind())) {
            //校验发送
            checkRemind(schedule, user);
            //设置定时发送
            DelaySendMessageUtil.delaySend(OA_CLIENT, OA_CLIENT_SCHEDULE_REMIND,
                    remindTime, tbOaSchedule, delaySendMessageClient);
        }

        //保存数据
        tbOaScheduleMapper.insertSelective(tbOaSchedule);
        logger.info("[日程管理] 日程添加成功,scheduleId:{}", scheduleId);

    }

    /**
     * 校验日程信息是否存在
     *
     * @param scheduleId 日程id
     * @return
     */
    private TbOaSchedule checkScheduleExist(String scheduleId) {
        TbOaSchedule tbOaSchedule = tbOaScheduleMapper.selectByPrimaryKey(scheduleId);
        if (tbOaSchedule == null ||
                StringUtils.equals(OaStatusEnums.DELETED.getCode(), tbOaSchedule.getRecordStatus().toString())) {
            logger.warn("[日程管理] 日程修改失败,修改信息不存在scheduleId:{}", scheduleId);
            throw new JnSpringCloudException(OaExceptionEnums.UPDATEDATA_NOT_EXIST);
        } else {
            return tbOaSchedule;
        }
    }
}
