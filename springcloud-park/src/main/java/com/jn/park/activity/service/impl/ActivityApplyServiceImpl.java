package com.jn.park.activity.service.impl;

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
import com.jn.park.model.ActivityApplyParment;
import com.jn.park.model.ActivityQueryPaging;
import com.jn.park.model.ApplyUserInfo;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserCompany;
import com.jn.user.model.UserExtension;
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
import java.util.Date;
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
    @Autowired
    private ActivityApplyMapper activityApplyMapper;

    @Autowired
    private TbActivityMapper tbActivityMapper;

    /**
     * 报名已签到
     */
    private static final String ACTIVITY_APPLYED_SIGN_CODE="1";
    /**
     * 已报名
     */
    private static final String ACTIVITY_APPLYED_STATED="1";

    /**
     * 快速报名
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
        Result<UserExtension> list = userExtensionClient.getUserExtension(account);
        //判断人员头像、名称、性别、公司名称、岗位名称是否都有
        UserExtension userExtension=list.getData();
        if(userExtension==null){
            //用户信息不完善，跳转到信息完善页
            throw new JnSpringCloudException(ActivityExceptionEnum.INCOMPLETE_INFORMATION);
        }
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
            UserCompany userCompanyInfo = userExtension.getUserCompanyInfo();
            //判断手机号和企业名称不为空
            if(StringUtils.isBlank(userCompanyInfo.getPhone()) || StringUtils.isBlank(userCompanyInfo.getComName())){
                //用户信息不完善，跳转到信息完善页
                throw new JnSpringCloudException(ActivityExceptionEnum.INCOMPLETE_INFORMATION);
            }
        }else{
            //用户信息不完善，跳转到信息完善页
            throw new JnSpringCloudException(ActivityExceptionEnum.INCOMPLETE_INFORMATION);
        }
        //根据id和account，通过状态（0：取消报名，1：报名成功））查询用户信息是否已存在
        boolean existApplyFlag = existApplyInfo(activityId, account);
        //已报名状态
        String applyState="1";
        //判断是否已报名，主要是防止重复报名/取消报名
        boolean existStateFlag = existApplyOrCancelApply(activityId, account, applyState);
        //没有报名
        if(!existStateFlag){
            //用户信息已存在
            if(existApplyFlag){
                //更新报名状态为报名成功   0：取消报名  1：报名成功
                String status="1";
                updateApplyState(activityId, account, status);
            }else{
                //新增活动报名信息
                addApplyInfo(activityId, account);
            }
            //修改园区活动的报名人数  报名成功一个加1
            int change=1;
            updateActivityApplyNum(activityId,change);
        }
    }

    /**
     * 取消报名
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
        String applyState="0";
        //判断是否已报名，主要是防止重复报名/取消报名
        boolean existStateFlag = existApplyOrCancelApply(activityId, account, applyState);
        //没有取消报名
        if(!existStateFlag){
            //用户信息已存在
            if(existApplyFlag){
                //更新报名状态为取消报名  0：取消报名  1：报名成功
                String status="0";
                updateApplyState(activityId, account, status);
            }else{
                //删除活动报名信息
                deleteApplyInfo(activityId,account);
            }
            //修改园区活动的报名人数  取消一个报名减1
            int change=-1;
            updateActivityApplyNum(activityId,change);
        }
    }

    /**
     * 更新报名状态
     * @param id       活动id
     * @param account  用户账号
     * @param status    状态
     */
    @ServiceLog(doAction = "更新报名状态")
    private void updateApplyState(String id, String account, String status) {
        TbActivityApplyCriteria example=new TbActivityApplyCriteria();
        example.createCriteria().andAccountEqualTo(account).andActivityIdEqualTo(id);
        TbActivityApply tbActivityApply=new TbActivityApply();
        tbActivityApply.setApplyStatus(status);
        tbActivityApplyMapper.updateByExampleSelective(tbActivityApply, example);
    }

    /**
     * 是否存在当前活动的用户信息
     * @param id        活动id
     * @param account   用户账号
     * @return
     */
    @ServiceLog(doAction = "是否存在当前活动的用户信息")
    private boolean existApplyInfo(String id,String account){
        TbActivityApplyCriteria example=new TbActivityApplyCriteria();
        example.createCriteria().andAccountEqualTo(account).andActivityIdEqualTo(id);
        long applyInfoNum=tbActivityApplyMapper.countByExample(example);
        if(applyInfoNum>0){
            return true;
        }
        return false;
    }

    /**
     * 是否已报名或取消报名
     * @param id        活动id
     * @param account   用户账号
     * @param status     报名状态   0：取消报名，1：报名成功
     * @return
     */
    @ServiceLog(doAction = "是否已存在报名或取消报名信息")
    private boolean  existApplyOrCancelApply(String id, String account,String status) {
        TbActivityApplyCriteria example=new TbActivityApplyCriteria();
        example.createCriteria().andAccountEqualTo(account).andActivityIdEqualTo(id).andApplyStatusEqualTo(status);
        long applyInfoNum = tbActivityApplyMapper.countByExample(example);
        if(applyInfoNum>0){
            return true;
        }
        return false;
    }

    /**
     * 新增活动报名信息
     * @param id        活动id
     * @param account   用户账号
     */
    @ServiceLog(doAction = "新增活动报名信息")
    @Override
    public void addApplyInfo(String id, String account) {
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
        activityApply.setApplyStatus(applyState);
        //签到状态  0：未签到，1：已签到
        String notSignedIn="0";
        activityApply.setSignStatus(notSignedIn);
        tbActivityApplyMapper.insertSelective(activityApply);
    }

    /**
     * 修改园区活动报名人数
     * @param id      活动id
     * @param change  增加人数为正数，减少人数为负数
     */
    @ServiceLog(doAction = "修改园区活动报名人数")
    private void updateActivityApplyNum(String id,int change) {
        TbActivity tbActivity = tbActivityMapper.selectByPrimaryKey(id);
        TbActivityCriteria example =new TbActivityCriteria();
        example.createCriteria().andIdEqualTo(id);
        Integer applyNum = tbActivity.getApplyNum();
        //若报名人数为0，更新为1，否则加1
        int aciApplyNum=applyNum!=null?tbActivity.getApplyNum()+change:change;
        //若是报名人数更新后，为负数，强制转换为0
        aciApplyNum=aciApplyNum<0?0:aciApplyNum;
        tbActivity.setApplyNum(aciApplyNum);
        tbActivityMapper.updateByExampleSelective(tbActivity, example);
    }




    /**
     * 逻辑删除用户报名信息
     * @param id        活动id
     * @param account   用户账号
     */
    @ServiceLog(doAction = "逻辑删除用户报名信息")
    private void deleteApplyInfo(String id,String account) {
        TbActivityApplyCriteria example=new TbActivityApplyCriteria();
        example.createCriteria().andActivityIdEqualTo(id).andAccountEqualTo(account);
        TbActivityApply activityApply=new TbActivityApply();
        //报名状态设置为"0"，取消报名
        activityApply.setApplyStatus("0");
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
        LocalDateTime applyEndTime = DateUtils.parseDate(activityInfo.getActiEndTime());
        LocalDateTime nowDate = DateUtils.parseDate(DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd HH:mm:ss")));
        //计算时间差
        long diffTime = Duration.between(nowDate, applyEndTime).toMillis();
        //不能报名状态标识
        String isApply="0";
        if(diffTime<0 || isApply.equals(activityInfo.getIsApply())){
            logger.info("报名已截止，不能报名或取消报名");
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_CUTOFF);

        }
    }

    /**
     * 查询表名信息列表（后台）
     * @param activityApplyParment
     * @param needPage  是否需要分页
     * @return
     */
    @ServiceLog(doAction = "查询表名信息列表（后台）")
    @Override
    public PaginationData applyActivityList(ActivityApplyParment activityApplyParment, Boolean needPage){
        com.github.pagehelper.Page<Object> objects=null;
        if(needPage){
            objects = PageHelper.startPage(activityApplyParment.getPage() ,activityApplyParment.getRows()==0?15:activityApplyParment.getRows(), true);
        }
        List<ActivityApplyDetail> activityApplyList =  activityApplyMapper.findApplyActivityList(activityApplyParment.getActivityId(),null);
        return new PaginationData(activityApplyList,objects==null?0:objects.getTotal());
    }

    /**
     * 二维码生成
     * @param outputStream
     * @param data :需要生成二维码的数据
     * @throws IOException
     */
    @ServiceLog(doAction = "二维码生成")
    @Override
    public void getQrCode (OutputStream outputStream, String data) throws IOException{
        try {

            String dataHandle = new String(data.getBytes("UTF-8"),"UTF-8");
            BitMatrix bitMatrix = new MultiFormatWriter().encode(dataHandle, BarcodeFormat.QR_CODE, 800, 800);

            //取得输出流
            //写入文件刷新
            MatrixToImageWriter.writeToStream(bitMatrix, "png", outputStream);
            outputStream.flush();
            //关闭输出流
            outputStream.close();
        }catch (WriterException e){
            logger.error("[二维码生成],WriterException，URL:{}", data,e);
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_APPLY_CODE_DOWN_WRITER_EXPEPTION);
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
    public int signInActivity(String account, String activityId){
        if(StringUtils.isEmpty(account)){
            logger.warn("[活动签到]，用户未登录，不允许签到：activityId: {}",activityId);
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_USER_LOGIN_EXPEPTION);
        }
        TbActivityApplyCriteria applyCriteria = new TbActivityApplyCriteria();
        applyCriteria.createCriteria().andActivityIdEqualTo(activityId);
        List<TbActivityApply> applies = tbActivityApplyMapper.selectByExample(applyCriteria);
        if(applies == null || applies.size() == 0){
            logger.warn("[活动签到]，活动报名信息列表为空，不允许签到：activityId: {}",activityId);
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_APPLY_INFO_IS_NULL);
        }
        TbActivityApply activityApply = null;
        for(TbActivityApply apply:applies){
            if(StringUtils.equals(apply.getAccount(),account)){
                activityApply = apply;
            }
        }
        int i ;
        //activityApply !=null ,代表该用户已报名参加活动，可以进行签到
        if(activityApply == null){
            logger.warn("[活动签到]，用户{}未报名活动：activityId: {},不能进行签到", account,activityId);
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_USER_NOT_APPLY);
        }else{
            if(StringUtils.equals(activityApply.getSignType(),ACTIVITY_APPLYED_SIGN_CODE)){
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_APPLYED_SIGN_CODE_EXPEPTION);
            }
            if(!StringUtils.equals(activityApply.getApplyStatus(),ACTIVITY_APPLYED_STATED)){
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_APPLYED_CODE_EXPEPTION);
            }else{
                activityApply.setSignType("0");
                activityApply.setSignStatus("1");
                activityApply.setSignTime(new Date());
                i = tbActivityApplyMapper.updateByPrimaryKeySelective(activityApply);
            }
        }
        return i;
    }

    /**
     * 报名人列表信息
     * @param activityQueryPaging
     * @param isPage  true：分页  false:不分页
     * @return
     */
    @ServiceLog(doAction = "报名人列表信息")
    @Override
    public PaginationData findApplyActivityList(ActivityQueryPaging activityQueryPaging,Boolean isPage) {
        com.github.pagehelper.Page<Object> objects=null;
        if(isPage){
            //默认查询前15条
            objects = PageHelper.startPage(activityQueryPaging.getPage(), activityQueryPaging.getRows() == 0 ? 15 :activityQueryPaging.getRows(), true);
        }
        //前端查询有效报名状态数据
        String status = "1";
        List<ActivityApplyDetail> activityApplyList =  activityApplyMapper.findApplyActivityList(activityQueryPaging.getActivityId(),status);
        return new PaginationData(activityApplyList,objects.getTotal());
    }

}
