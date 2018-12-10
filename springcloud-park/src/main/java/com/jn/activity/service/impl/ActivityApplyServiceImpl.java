package com.jn.activity.service.impl;

import com.jn.activity.dao.TbActivityApplyMapper;
import com.jn.activity.entity.TbActivity;
import com.jn.activity.entity.TbActivityApply;
import com.jn.activity.entity.TbActivityApplyCriteria;
import com.jn.activity.enums.ActivityExceptionEnum;
import com.jn.activity.model.ApplyUserInfo;
import com.jn.activity.service.ActivityApplyService;
import com.jn.activity.service.ActivityDetailsService;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Page;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.AnnotatedParameterizedType;
import java.lang.reflect.Field;
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
    private UserExtensionClient userExtensionClient;

    /**
     * 快速报名
     * @param id        活动id
     * @param account   报名人账号
     * @return
     */
    @ServiceLog(doAction = "快速报名")
    @Override
    public void quickApply(String id, String account) {
        //校验是否可以报名/取消报名
        checkIsApply(id);
        //获取用户拓展信息，判断信息是否完整，若不完整，需要完善信息
        Result<UserExtension> list = userExtensionClient.getUserExtension(account);
        //判断人员头像、名称、性别、公司名称、岗位名称是否都有
        UserExtension userExtension=list.getData();
        //个人用户
        if(userExtension.getUserPersonInfo()!=null){
            ApplyUserInfo applyUserInfo=new ApplyUserInfo();
            BeanUtils.copyProperties(userExtension.getUserPersonInfo(), applyUserInfo);
            if(StringUtils.isBlank(applyUserInfo.getAvatar()) || StringUtils.isBlank(applyUserInfo.getCompany())
                ||StringUtils.isBlank(applyUserInfo.getName()) || StringUtils.isBlank(applyUserInfo.getPost())
                || StringUtils.isBlank(applyUserInfo.getSex())){
                //用户信息不完善，跳转到信息完善页
                throw new JnSpringCloudException(ActivityExceptionEnum.INCOMPLETE_INFORMATION);
            }
        }else if(userExtension.getUserCompanyInfo()!=null){
            //企业用户
            //todo:有争议，待完善
        }
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
        String applyState="1";
        activityApply.setApplyState(applyState);
        tbActivityApplyMapper.insertSelective(activityApply);
    }


    /**
     * 取消报名
     * @param id        活动id
     * @param account   报名人账号
     * @return
     */
    @ServiceLog(doAction = "取消报名")
    @Override
    public void cancelApply(String id, String account) {
        //校验是否可以报名/取消报名
        checkIsApply(id);
        //数据校验通过，取消报名
        TbActivityApplyCriteria example=new TbActivityApplyCriteria();
        example.createCriteria().andActivityIdEqualTo(account);
        TbActivityApply activityApply=new TbActivityApply();
        //报名状态设置为"0"，取消报名
        activityApply.setApplyState("0");
        tbActivityApplyMapper.updateByExampleSelective(activityApply, example);
    }

    /**
     * 校验是否可以报名/取消报名
     * @param id
     * @return
     */
    @ServiceLog(doAction = "校验是否可以报名/取消报名")
    private void checkIsApply(String id){
        //获取获取园区活动信息
        TbActivity activityInfo = activityDetailsService.getActivityInfo(id);
        if(activityInfo==null){
            logger.info("活动未发布在或已被删除");
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_NOT_EXIST);
        }
        //只有当前时间未超过报名截止时间，是否可以报名的状态为"是"才可以报名
        if(activityInfo.getActiEndTime()==null){
            logger.info("活动报名截止时间为空");
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_CANNOT_EMPTY);

        }
        LocalDateTime actiEndTime = DateUtils.parseDate(activityInfo.getActiEndTime());
        LocalDateTime nowDate = DateUtils.parseDate(DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd HH:mm:ss")));
        //计算时间差
        long diffTime = Duration.between(nowDate, actiEndTime).toMillis();
        //不能报名状态标识
        String isApply="0";
        if(diffTime<0 || isApply.equals(activityInfo.getIsApply())){
            logger.info("报名已截止，不能报名或取消报名");
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_CUTOFF);

        }
    }

    /**
     * 后台管理-查询活动报名信息列表
     * @param activityId
     * @param page
     * @return
     */
    @Override
    public List<TbActivityApply> applyActivityList(String activityId, Page page){
        TbActivityApplyCriteria applyCriteria = new TbActivityApplyCriteria();
        applyCriteria.createCriteria().andActivityIdEqualTo(activityId);
        List<TbActivityApply> tbActivityApplies = tbActivityApplyMapper.selectByExample(applyCriteria);
        return tbActivityApplies;
    }

}
