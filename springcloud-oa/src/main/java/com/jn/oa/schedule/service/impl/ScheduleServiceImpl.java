package com.jn.oa.schedule.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.Assert;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.oa.common.enums.OaExceptionEnums;
import com.jn.oa.common.enums.OaStatusEnums;
import com.jn.oa.common.util.DelaySendMessageUtil;
import com.jn.oa.schedule.dao.ScheduleMapper;
import com.jn.oa.schedule.dao.TbOaScheduleMapper;
import com.jn.oa.schedule.entity.TbOaSchedule;
import com.jn.oa.schedule.enums.ScheduleExceptionEnums;
import com.jn.oa.schedule.enums.ScheduleRemindEnums;
import com.jn.oa.schedule.model.Schedule;
import com.jn.oa.schedule.model.ScheduleEdit;
import com.jn.oa.schedule.model.ScheduleQuery;
import com.jn.oa.schedule.service.ScheduleService;
import com.jn.send.api.DelaySendMessageClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * TODO:未编写消息提醒功能
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

            //判断是都修改定时时间
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
            BeanUtils.copyProperties(schedule, tbOaSchedule);
        } else {
            BeanUtils.copyProperties(schedule, tbOaSchedule);
            setScheduleRemindMethod(tbOaSchedule);
        }

        //修改数据
        tbOaSchedule.setModifiedTime(new Date());
        tbOaSchedule.setModifierAccount(account);
        tbOaScheduleMapper.updateByPrimaryKeySelective(tbOaSchedule);
        logger.info("[日程管理] 日程修改成功,scheduleId:{}", scheduleId);
    }

    /**
     * 当采用不提醒时,设置提醒方式全为否
     *
     * @param tbOaSchedule
     */
    private void setScheduleRemindMethod(TbOaSchedule tbOaSchedule) {
        tbOaSchedule.setPcRemind(ScheduleRemindEnums.NO.getCode());
        tbOaSchedule.setAppRemind(ScheduleRemindEnums.NO.getCode());
        tbOaSchedule.setWechatRemind(ScheduleRemindEnums.NO.getCode());
        tbOaSchedule.setMessageRemind(ScheduleRemindEnums.NO.getCode());
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
        Date startTime = schedule.getStartTime();
        Assert.notNull(remindTime, ScheduleExceptionEnums.REMIND_TIME_NOT_NULL.getMessage());
        //必须要选择一种提醒方式
        Boolean remindMethod = StringUtils.equals(ScheduleRemindEnums.YES.getCode(), schedule.getAppRemind())
                || StringUtils.equals(ScheduleRemindEnums.YES.getCode(), schedule.getPcRemind())
                || StringUtils.equals(ScheduleRemindEnums.YES.getCode(), schedule.getWechatRemind())
                || StringUtils.equals(ScheduleRemindEnums.YES.getCode(), schedule.getMessageRemind());
        if (!remindMethod) {
            logger.warn("[日程管理] 日程修改/添加失败,scheduleId:{}", scheduleId);
            throw new JnSpringCloudException(ScheduleExceptionEnums.REMIND_METHOD_NOT_EMPTY);
        }
        if (startTime.before(remindTime)) {
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
        } else {
            setScheduleRemindMethod(tbOaSchedule);
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
