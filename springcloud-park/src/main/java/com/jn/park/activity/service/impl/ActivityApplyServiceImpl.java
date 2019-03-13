package com.jn.park.activity.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.park.activity.dao.ActivityApplyMapper;
import com.jn.park.activity.dao.TbActivityApplyMapper;
import com.jn.park.activity.dao.TbActivityMapper;
import com.jn.park.activity.entity.TbActivity;
import com.jn.park.activity.entity.TbActivityApply;
import com.jn.park.activity.entity.TbActivityApplyCriteria;
import com.jn.park.activity.entity.TbActivityCriteria;
import com.jn.park.activity.service.ActivityApplyService;
import com.jn.park.activity.service.ActivityDetailsService;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.park.model.ActivityApplyDetail;
import com.jn.park.model.ActivityApplyParam;
import com.jn.park.model.ActivityQueryPaging;
import com.jn.park.model.ApplyUserInfo;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.OutputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 活动报名
 *
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
    @Autowired
    private ActivityApplyMapper activityApplyMapper;

    @Autowired
    private TbActivityMapper tbActivityMapper;


    /**
     * 报名已签到
     */
    private static final String ACTIVITY_APPLYED_SIGN_CODE = "1";
    /**
     * 已报名
     */
    private static final String ACTIVITY_APPLYED_STATED = "1";
    /**
     * 报名待审核
     */
    private static final String ACTIVITY_APPLYED_CHECKED = "2";

    /**
     * 快速报名
     *
     * @param activityId 活动id
     * @param account    报名人账号
     * @return
     */
    @ServiceLog(doAction = "快速报名")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void quickApply(String activityId, String account) {
        //校验是否可以报名/取消报名
        checkIsApply(activityId);
        //获取用户拓展信息，判断信息是否完整，若不完整，需要完善信息
        Result<UserExtensionInfo> list = userExtensionClient.getUserExtension(account);
        //判断人员头像、名称、性别、公司名称、岗位名称是否都有
        UserExtensionInfo userExtension = list.getData();
        if (userExtension == null) {
            //用户信息不完善，跳转到信息完善页
            throw new JnSpringCloudException(ActivityExceptionEnum.INCOMPLETE_INFORMATION);
        }
        ApplyUserInfo applyUserInfo = new ApplyUserInfo();
        BeanUtils.copyProperties(userExtension, applyUserInfo);
        if (StringUtils.isBlank(applyUserInfo.getAvatar()) || StringUtils.isBlank(applyUserInfo.getCompany())
                || StringUtils.isBlank(applyUserInfo.getName()) || StringUtils.isBlank(applyUserInfo.getPost())
                || StringUtils.isBlank(applyUserInfo.getSex())) {
            //用户信息不完善，跳转到信息完善页
            throw new JnSpringCloudException(ActivityExceptionEnum.INCOMPLETE_INFORMATION);
        }
        //根据id和account，通过状态（0：取消报名，1：报名成功））查询用户信息是否已存在
        boolean existApplyFlag = existApplyInfo(activityId, account);
        //已报名状态
        String applyState = "1";
        //判断是否已报名，主要是防止重复报名/取消报名
        boolean existStateFlag = existApplyOrCancelApply(activityId, account, applyState);
        //没有报名
        if (!existStateFlag) {
            //判断当前活动报名是否需要审核
            boolean needToReview = activityNeddToReview(activityId);
            //报名状态   0：取消报名  1：报名成功  2：待审核
            String status = "1";
            //判断当前活动报名是否需要审核
            if (needToReview) {
                status = "2";
            }
            //用户信息已存在
            if (existApplyFlag) {
                updateApplyState(activityId, account, status);
            } else {
                //新增活动报名信息
                addApplyInfo(activityId, account, status);
            }
            //修改园区活动的报名人数  报名成功一个加1
            int change = 1;
            updateActivityApplyNum(activityId, change);
        }
    }

    /**
     * 判断当前活动报名是否需要审核
     *
     * @param activityId
     * @return true:需要审核  false:不需要审核
     */
    @ServiceLog(doAction = "判断当前活动报名是否需要审核")
    private boolean activityNeddToReview(String activityId) {
        TbActivity tbActivity = tbActivityMapper.selectByPrimaryKey(activityId);
        //报名是否需要审核   0：不需要审核   1：需要审核
        String applyCheck = "1";
        return applyCheck.equals(tbActivity.getApplyCheck());
    }

    /**
     * 取消报名
     *
     * @param activityId 活动id
     * @param account    报名人账号
     * @return
     */
    @ServiceLog(doAction = "取消报名")
    @Override
    public void cancelApply(String activityId, String account) {
        //校验是否可以报名/取消报名
        checkIsApply(activityId);
        //根据id和account，通过状态（0：取消报名，1：报名成功））查询用户信息是否已存在
        boolean existApplyFlag = existApplyInfo(activityId, account);
        //取消报名状态
        String applyState = "0";
        //判断是否已报名，主要是防止重复报名/取消报名
        boolean existStateFlag = existApplyOrCancelApply(activityId, account, applyState);
        //没有取消报名
        if (!existStateFlag) {
            //用户信息已存在
            if (existApplyFlag) {
                //更新报名状态为取消报名  0：取消报名  1：报名成功
                String status = "0";
                updateApplyState(activityId, account, status);
            } else {
                //删除活动报名信息
                deleteApplyInfo(activityId, account);
            }
            //修改园区活动的报名人数  取消一个报名减1
            int change = -1;
            updateActivityApplyNum(activityId, change);
        }
    }

    /**
     * 更新报名状态
     *
     * @param id      活动id
     * @param account 用户账号
     * @param status  状态
     */
    @ServiceLog(doAction = "更新报名状态")
    private void updateApplyState(String id, String account, String status) {
        TbActivityApplyCriteria example = new TbActivityApplyCriteria();
        example.createCriteria().andCreatorAccountEqualTo(account).andActivityIdEqualTo(id);
        TbActivityApply tbActivityApply = new TbActivityApply();
        tbActivityApply.setApplyStatus(status);
        tbActivityApplyMapper.updateByExampleSelective(tbActivityApply, example);
    }

    /**
     * 是否存在当前活动的用户信息
     *
     * @param id      活动id
     * @param account 用户账号
     * @return
     */
    @ServiceLog(doAction = "是否存在当前活动的用户信息")
    private boolean existApplyInfo(String id, String account) {
        TbActivityApplyCriteria example = new TbActivityApplyCriteria();
        example.createCriteria().andCreatorAccountEqualTo(account).andActivityIdEqualTo(id);
        long applyInfoNum = tbActivityApplyMapper.countByExample(example);
        return applyInfoNum > 0;
    }

    /**
     * 是否已报名或取消报名
     *
     * @param id      活动id
     * @param account 用户账号
     * @param status  报名状态   0：取消报名，1：报名成功
     * @return
     */
    @ServiceLog(doAction = "是否已存在报名或取消报名信息")
    private boolean existApplyOrCancelApply(String id, String account, String status) {
        TbActivityApplyCriteria example = new TbActivityApplyCriteria();
        example.createCriteria().andCreatorAccountEqualTo(account).andActivityIdEqualTo(id).andApplyStatusEqualTo(status);
        long applyInfoNum = tbActivityApplyMapper.countByExample(example);
        return applyInfoNum > 0;
    }

    /**
     * 新增活动报名信息
     *
     * @param activityId 活动id
     * @param account    用户账号
     * @param status     报名状态
     */
    @ServiceLog(doAction = "新增活动报名信息")
    @Override
    public void addApplyInfo(String activityId, String account, String status) {
        //数据校验通过，可以报名，往活动表插入报名数据
        TbActivityApply activityApply = new TbActivityApply();
        //主键id
        activityApply.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        //活动id
        activityApply.setActivityId(activityId);
        //报名人
        activityApply.setCreatorAccount(account);
        //报名时间
        activityApply.setCreatedTime(DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd HH:mm:ss")));
        //报名状态
        activityApply.setApplyStatus(status);
        //签到状态  0：未签到，1：已签到
        String notSignedIn = "0";
        activityApply.setSignStatus(notSignedIn);
        //是否已删除 0:已删除   1：正常
        byte recordStatrus=1;
        activityApply.setRecordStatus(recordStatrus);
        tbActivityApplyMapper.insertSelective(activityApply);
    }

    /**
     * 修改园区活动报名人数
     *
     * @param id     活动id
     * @param change 增加人数为正数，减少人数为负数
     */
    @ServiceLog(doAction = "修改园区活动报名人数")
    private void updateActivityApplyNum(String id, int change) {
        TbActivity tbActivity = tbActivityMapper.selectByPrimaryKey(id);
        TbActivityCriteria example = new TbActivityCriteria();
        example.createCriteria().andIdEqualTo(id);
        Integer applyNum = tbActivity.getApplyNum();
        //若报名人数为0，更新为1，否则加1
        int aciApplyNum = applyNum != null ? tbActivity.getApplyNum() + change : change;
        //若是报名人数更新后，为负数，强制转换为0
        aciApplyNum = aciApplyNum < 0 ? 0 : aciApplyNum;
        tbActivity.setApplyNum(aciApplyNum);
        tbActivityMapper.updateByExampleSelective(tbActivity, example);
    }


    /**
     * 逻辑删除用户报名信息
     *
     * @param id      活动id
     * @param account 用户账号
     */
    @ServiceLog(doAction = "逻辑删除用户报名信息")
    private void deleteApplyInfo(String id, String account) {
        TbActivityApplyCriteria example = new TbActivityApplyCriteria();
        example.createCriteria().andActivityIdEqualTo(id).andCreatorAccountEqualTo(account);
        TbActivityApply activityApply = new TbActivityApply();
        //是否删除设置为0    0：删除    1：正常
        byte recordStatus=0;
        activityApply.setRecordStatus(recordStatus);
        tbActivityApplyMapper.updateByExampleSelective(activityApply, example);
    }

    /**
     * 校验是否可以报名/取消报名
     *
     * @param id
     * @return
     */
    @ServiceLog(doAction = "校验是否可以报名/取消报名")
    private void checkIsApply(String id) {
        //获取获取园区活动信息
        TbActivity activityInfo = activityDetailsService.getActivityInfo(id);
        if (activityInfo == null) {
            logger.info("活动未发布或已被删除");
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_NOT_EXIST);
        }
        //只有当前时间未超过报名截止时间，是否可以报名的状态为"是"才可以报名
        if (activityInfo.getActiEndTime() == null) {
            logger.info("活动报名截止时间为空");
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_CANNOT_EMPTY);

        }
        LocalDateTime applyEndTime = DateUtils.parseDate(activityInfo.getActiEndTime());
        LocalDateTime nowDate = DateUtils.parseDate(DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd HH:mm:ss")));
        //计算时间差
        long diffTime = Duration.between(nowDate, applyEndTime).toMillis();
        //不能报名状态标识
        String isApply = "0";
        if (diffTime < 0 || isApply.equals(activityInfo.getIsApply())) {
            logger.info("报名已截止，不能报名或取消报名");
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_CUTOFF);

        }
    }

    /**
     * 查询表名信息列表（后台）
     *
     * @param activityApplyParam
     * @param needPage             是否需要分页
     * @return
     */
    @ServiceLog(doAction = "查询表名信息列表（后台）")
    @Override
    public PaginationData applyActivityList(ActivityApplyParam activityApplyParam, Boolean needPage) {
        com.github.pagehelper.Page<Object> objects = null;
        if (needPage) {
            objects = PageHelper.startPage(activityApplyParam.getPage(), activityApplyParam.getRows() == 0 ? 15 : activityApplyParam.getRows(), true);
        }
        List<ActivityApplyDetail> activityApplyList = activityApplyMapper.findApplyActivityList(activityApplyParam.getActivityId(), null);
        return new PaginationData(activityApplyList, objects == null ? 0 : objects.getTotal());
    }

    /**
     * 二维码生成
     *
     * @param outputStream
     * @param data         :需要生成二维码的数据
     * @throws IOException
     */
    @ServiceLog(doAction = "二维码生成")
    @Override
    public void getQrCode(OutputStream outputStream, String data) throws IOException {
        try {

            String dataHandle = new String(data.getBytes("UTF-8"), "UTF-8");
            BitMatrix bitMatrix = new MultiFormatWriter().encode(dataHandle, BarcodeFormat.QR_CODE, 800, 800);

            //取得输出流
            //写入文件刷新
            MatrixToImageWriter.writeToStream(bitMatrix, "png", outputStream);
            outputStream.flush();
            //关闭输出流
            outputStream.close();
        } catch (WriterException e) {
            logger.error("[二维码生成],WriterException，URL:{}", data, e);
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_APPLY_CODE_DOWN_WRITER_EXCEPTION);
        }

    }

    /***
     * 前台用户签到
     * @param account
     * @param activityId
     * @return
     */
    @ServiceLog(doAction = "前台用户签到")
    @Override
    public int signInActivity(String account, String activityId) {
        if (StringUtils.isEmpty(account)) {
            logger.warn("[活动签到]，用户未登录，不允许签到：activityId: {}", activityId);
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_USER_LOGIN_EXCEPTION);
        }
        TbActivityApplyCriteria applyCriteria = new TbActivityApplyCriteria();
        applyCriteria.createCriteria().andActivityIdEqualTo(activityId);
        List<TbActivityApply> applies = tbActivityApplyMapper.selectByExample(applyCriteria);
        if (applies == null || applies.isEmpty()) {
            logger.warn("[活动签到]，活动报名信息列表为空，不允许签到：activityId: {}", activityId);
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_APPLY_INFO_IS_NULL);
        }
        TbActivityApply activityApply = null;
        for (TbActivityApply apply : applies) {
            if (StringUtils.equals(apply.getCreatorAccount(), account)) {
                activityApply = apply;
            }
        }
        int i;
        //activityApply !=null ,代表该用户已报名参加活动，可以进行签到
        if (activityApply == null) {
            logger.warn("[活动签到]，用户{}未报名活动：activityId: {},不能进行签到", account, activityId);
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_USER_NOT_APPLY);
        } else {
            if (StringUtils.equals(activityApply.getSignType(), ACTIVITY_APPLYED_SIGN_CODE)) {
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_APPLYED_SIGN_CODE_EXCEPTION);
            }
            if (!StringUtils.equals(activityApply.getApplyStatus(), ACTIVITY_APPLYED_STATED)) {
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_APPLYED_CODE_EXCEPTION);
            } else {
                activityApply.setSignType("0");
                activityApply.setSignStatus("1");
                activityApply.setSignTime(new Date());
                i = tbActivityApplyMapper.updateByPrimaryKeySelective(activityApply);
            }
        }
        return i;
    }

    /**
     * 后台管理签到接口
     *
     * @param applyId
     * @return
     */
    @ServiceLog(doAction = "后台管理签到")
    @Override
    public int signInActivityBackend(String applyId,String account) {
        TbActivityApply tbActivityApply = tbActivityApplyMapper.selectByPrimaryKey(applyId);
        if (null == tbActivityApply) {
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_APPLY_IS_NULL);
        } else if (!StringUtils.equals(tbActivityApply.getApplyStatus(), ACTIVITY_APPLYED_STATED)) {
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_APPLYED_CODE_EXCEPTION);
        } else if (StringUtils.equals(tbActivityApply.getSignStatus(), ACTIVITY_APPLYED_SIGN_CODE)) {
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_APPLYED_SIGN_CODE_EXCEPTION);
        }
        tbActivityApply.setSignStatus("1");
        tbActivityApply.setSignType("1");
        tbActivityApply.setSignTime(new Date());
        tbActivityApply.setSignAccount(account);
        return tbActivityApplyMapper.updateByPrimaryKeySelective(tbActivityApply);
    }

    /**
     * 后台管理报名审核接口
     *
     * @param applyId
     * @return
     */
    @ServiceLog(doAction = "后台管理报名审核")
    @Override
    public int signInActivityCheck(String applyId,String account) {
        TbActivityApply tbActivityApply = tbActivityApplyMapper.selectByPrimaryKey(applyId);
        if (null == tbActivityApply) {
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_APPLY_IS_NULL);
        } else if (!StringUtils.equals(tbActivityApply.getApplyStatus(), ACTIVITY_APPLYED_CHECKED)) {
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_APPLYED_NOT_CHECKED);
        }
        tbActivityApply.setApplyStatus("1");
        tbActivityApply.setCheckAccount(account);
        tbActivityApply.setCheckTime(new Date());
        return tbActivityApplyMapper.updateByPrimaryKeySelective(tbActivityApply);
    }

    /**
     * 报名人列表信息
     *
     * @param activityQueryPaging
     * @param isPage              true：分页  false:不分页
     * @return
     */
    @ServiceLog(doAction = "报名人列表信息(前台)")
    @Override
    public PaginationData findApplyActivityList(ActivityQueryPaging activityQueryPaging, Boolean isPage) {
        Page<Object> objects = null;
        List<ActivityApplyDetail> activityApplyList;
            if (isPage) {
                //默认查询前15条
                objects = PageHelper.startPage(activityQueryPaging.getPage(), activityQueryPaging.getRows() == 0 ? 15 : activityQueryPaging.getRows(), true);
            }
            //前端查询有效报名状态数据
            String status = "1";
            if(!StringUtils.isNotEmpty(activityQueryPaging.getActivityId())){
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY);
            }
            activityApplyList = activityApplyMapper.findApplyActivityList(activityQueryPaging.getActivityId(), status);
            return new PaginationData(findUserExtension(activityApplyList), objects == null ? 0 : objects.getTotal());
    }

    /**
     * 活动列表的报名人账号信息
     *
     * @param activityIdList
     * @return
     */
    @ServiceLog(doAction = "活动列表的报名人账号信息")
    @Override
    public List<ActivityApplyDetail> findApplyAccountList(List<String> activityIdList) {
        List<ActivityApplyDetail> accountList = activityApplyMapper.findApplyAccountList(activityIdList);
        return findUserExtension(accountList);
    }

    /**
     * 完善报名人详细信息
     * @param activityApplyList
     * @return
     */
    private List<ActivityApplyDetail> findUserExtension(List<ActivityApplyDetail> activityApplyList) {
        List<String> accountList = new ArrayList<>();
        if (!activityApplyList.isEmpty()) {
            for (ActivityApplyDetail detail : activityApplyList) {
                accountList.add(detail.getAccount());
            }
            Result<List<UserExtensionInfo>> userResult = userExtensionClient.getMoreUserExtension(accountList);
            List<UserExtensionInfo> userList = userResult.getData();
            if (!userList.isEmpty()) {
                for (UserExtensionInfo user : userList) {
                    for (ActivityApplyDetail detail : activityApplyList) {
                        if (user!= null && user.getAccount().equals(detail.getAccount())) {
                            BeanUtils.copyProperties(user, detail);
                        }
                    }
                }
            }
        }
        return activityApplyList;
    }
}
