package com.jn.activity.service.impl;

import com.jn.activity.dao.TbActivityApplyMapper;
import com.jn.activity.entity.TbActivity;
import com.jn.activity.entity.TbActivityApply;
import com.jn.activity.entity.TbActivityApplyCriteria;
import com.jn.activity.enums.ActivityExceptionEnum;
import com.jn.activity.service.ActivityApplyService;
import com.jn.activity.service.ActivityDetailsService;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.StringUtils;
import com.jn.portals.user.api.PortalLoginClient;
import com.jn.portals.user.enums.PortalsLoginExceptionEnum;
import com.jn.portals.user.model.PortalsUser;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * 活动报名
 * @Author: yangph
 * @Date: 2018/12/6 14:06
 * @Version v1.0
 * @modified By:
 */
@Service
public class ActivityApplyServiceImpl implements ActivityApplyService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityApplyServiceImpl.class);

    @Autowired
    private TbActivityApplyMapper tbActivityApplyMapper;

    @Autowired
    private ActivityDetailsService activityDetailsService;

    @Autowired
    private PortalLoginClient portalLoginClient;

    /**
     * 快速报名
     * @param id        活动id
     * @param account   报名人账号
     * @return
     */
    @ServiceLog(doAction = "快速报名")
    @Override
    public Result quickApply(String id, String account) {
        //前端参数非空校验
        Result result=checkDataEmpty(id,account);
        if (!GlobalConstants.SUCCESS_CODE.equals(result.getCode())) {
            return result;
        }
        //校验是否可以报名/取消报名
        result=checkIsApply(id);
        if (!GlobalConstants.SUCCESS_CODE.equals(result.getCode())) {
            return result;
        }
        //获取用户拓展信息，判断信息是否完整，若不完整，需要完善信息
        Result<PortalsUser> userExtension = portalLoginClient.getUserExtension(account);
        //判断人员头像、名称、性别、公司名称、岗位名称、签到状态是否都有
        //todo:完善

        //数据校验通过，可以报名，往活动表插入报名数据
        TbActivityApply activityApply=new TbActivityApply();
        //主键id
        activityApply.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        //活动id
        activityApply.setActivityId(id);
        //报名人
        activityApply.setAccount(account);
        //报名时间
        activityApply.setApplyTime(DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd HH:mm:ss")));
        //报名状态   0：取消报名，1：报名成功
        activityApply.setApplyState("1");
        tbActivityApplyMapper.insertSelective(activityApply);
        return result;
    }



    /**
     * 取消报名
     * @param id        活动id
     * @param account   报名人账号
     * @return
     */
    @ServiceLog(doAction = "取消报名")
    @Override
    public Result cancelApply(String id, String account) {
        //前端参数非空校验
        Result result=checkDataEmpty(id, account);
        if (!GlobalConstants.SUCCESS_CODE.equals(result.getCode())) {
            return result;
        }
        //校验是否可以报名/取消报名
        result=checkIsApply(id);
        if (!GlobalConstants.SUCCESS_CODE.equals(result.getCode())) {
            return result;
        }
        //数据校验通过，取消报名
        TbActivityApplyCriteria example=new TbActivityApplyCriteria();
        example.createCriteria().andActivityIdEqualTo(account);
        TbActivityApply activityApply=new TbActivityApply();
        //报名状态设置为"0"，取消报名
        activityApply.setApplyState("0");
        tbActivityApplyMapper.updateByExampleSelective(activityApply, example);

        return null;
    }

    /**
     * 前端参数非空校验
     * @param id      活动id
     * @param account 用户账号
     * @return
     */
    @ServiceLog(doAction = "前端参数非空校验")
    @Override
    public  Result checkDataEmpty(String id,String account){
        //只有当前时间未超过报名截止时间，是否可以报名的状态为"是"才可以取消报名
        Result result=new Result();
        //非空校验
        if(StringUtils.isBlank(id)){
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getCode());
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
            logger.info(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
            return result;
        }
        if(StringUtils.isBlank(account)){
            result.setCode(PortalsLoginExceptionEnum.ACCOUNT_CANNOT_EMPTY.getCode());
            result.setCode(PortalsLoginExceptionEnum.ACCOUNT_CANNOT_EMPTY.getMessage());
            logger.info(PortalsLoginExceptionEnum.ACCOUNT_CANNOT_EMPTY.getMessage());
            return result;
        }
        return result;
    }

    /**
     * 校验是否可以报名/取消报名
     * @param id
     * @return
     */
    @ServiceLog(doAction = "校验是否可以报名/取消报名")
    private Result checkIsApply(String id){
        //获取获取园区活动信息
        Result result= activityDetailsService.getActivityInfo(id);
        if (!GlobalConstants.SUCCESS_CODE.equals(result.getCode())) {
            return result;
        }
        if(result.getData()==null){
            result.setCode(ActivityExceptionEnum.ACTIVITY_NOT_EXIST.getCode());
            result.setCode(ActivityExceptionEnum.ACTIVITY_NOT_EXIST.getMessage());
            logger.info("活动未发布在或已被删除");
            return result;
        }
        //只有当前时间未超过报名截止时间，是否可以报名的状态为"是"才可以报名
        TbActivity tbActivity = (TbActivity)result.getData();
        if(tbActivity.getActiEndTime()==null){
            result.setCode(ActivityExceptionEnum.ACTIVITY_CANNOT_EMPTY.getCode());
            result.setCode(ActivityExceptionEnum.ACTIVITY_CANNOT_EMPTY.getMessage());
            logger.info("活动报名截止时间为空");
            return result;
        }
        LocalDateTime actiEndTime = DateUtils.parseDate(tbActivity.getActiEndTime());
        LocalDateTime nowDate = DateUtils.parseDate(DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd HH:mm:ss")));
        //计算时间差
        long diffTime = Duration.between(nowDate, actiEndTime).toMillis();
        //不能报名状态标识
        String isApply="0";
        if(diffTime<0 || isApply.equals(tbActivity.getIsApply())){
            result.setCode(ActivityExceptionEnum.ACTIVITY_CUTOFF.getCode());
            result.setCode(ActivityExceptionEnum.ACTIVITY_CUTOFF.getMessage());
            logger.info("报名已截止，不能报名或取消报名");
            return result;
        }
        return  result;
    }

    @Override
    public List<TbActivityApply> applyActivityList(String activityId, com.jn.common.model.Page page){
        TbActivityApplyCriteria applyCriteria = new TbActivityApplyCriteria();
        applyCriteria.createCriteria().andActivityIdEqualTo(activityId);
        List<TbActivityApply> tbActivityApplies = tbActivityApplyMapper.selectByExample(applyCriteria);
        return tbActivityApplies;
    }

}
