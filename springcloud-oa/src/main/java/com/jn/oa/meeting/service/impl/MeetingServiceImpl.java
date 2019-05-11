package com.jn.oa.meeting.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.channel.MessageSource;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.file.MultipartFileUtil;
import com.jn.common.util.zxing.QRCodeUtils;
import com.jn.news.vo.SmsTemplateVo;
import com.jn.oa.common.enums.OaExceptionEnums;
import com.jn.oa.common.enums.OaReturnMessageEnum;
import com.jn.oa.common.enums.OaStatusEnums;
import com.jn.oa.meeting.dao.*;
import com.jn.oa.meeting.entity.*;
import com.jn.oa.meeting.enums.*;
import com.jn.oa.meeting.model.*;
import com.jn.oa.meeting.service.MeetingService;
import com.jn.oa.meeting.vo.OaMeetingParticipantVo;
import com.jn.oa.meeting.vo.OaMeetingVo;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysDictInvoke;
import com.jn.system.model.SysRole;
import com.jn.system.model.User;
import com.jn.upload.api.UploadClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.core.io.ResourceLoader;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.*;

/**
 * 会议申请service
 *
 * @author： yuanyy
 * @date： Created on 2019/1/29 17:01
 * @version： v1.0
 * @modified By:
 */
@Service
@EnableBinding(value = {MessageSource.class})
public class MeetingServiceImpl implements MeetingService {
    private static Logger logger = LoggerFactory.getLogger(MeetingServiceImpl.class);

    @Resource
    private TbOaMeetingMapper tbOaMeetingMapper;

    @Resource
    private MeetingMapper oaMeetingMapper;

    @Resource
    private TbOaMeetingContentMapper tbOaMeetingContentMapper;

    @Autowired
    private UploadClient uploadClient;


    private ResourceLoader resourceLoader;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private SystemClient systemClient;

    @Autowired
    public MeetingServiceImpl(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * 根据关键字分页查询会议申请列表
     *
     * @param oaMeetingPage
     * @return
     */
    @Override
    @ServiceLog(doAction = "关键字分页查询会议申请列表")
    public PaginationData selectOaMeetingListBySearchKey(OaMeetingPage oaMeetingPage, User user) {
        String roleId = "531a2a04-be44-4239-a36b-5b09aac3499d";
        int count = 0;
        if (user.getSysRole() != null && user.getSysRole().size() != 0) {
            for (SysRole role : user.getSysRole()) {
                if (!role.getId().equals(roleId)) {
                    count++;
                }
            }
        } else {
            count++;
        }
        if (count > 0) {
            //没有角色信息
            oaMeetingPage.setApplicant(user.getId());
        }

        Page<Object> objects = PageHelper.startPage(oaMeetingPage.getPage(), oaMeetingPage.getRows());
        return new PaginationData(oaMeetingMapper.selectMeetingListByCondition(oaMeetingPage)
                , objects.getTotal());


    }
    /**
     * 查询会议室展示信息
     *
     * @param oaMeetingPage
     * @return
     */
    @Override
    @ServiceLog(doAction = " 查询会议室展示信息")
    public List<OaMeetingVo> selectShowOaMeetingListBySearchKey(OaMeetingPage oaMeetingPage) {

        List<OaMeetingVo> list= oaMeetingMapper.selectMeetingListByCondition(oaMeetingPage);
        return list;


    }

    /**
     * 新增会议申请
     *
     * @param oaMeetingAdd
     */
    @Override
    @ServiceLog(doAction = "新增会议申请")
    @Transactional(rollbackFor = Exception.class)
    public void insertOaMeeting(OaMeetingAdd oaMeetingAdd) {
        TbOaMeeting tbOaMeeting = new TbOaMeeting();
        BeanUtils.copyProperties(oaMeetingAdd, tbOaMeeting);

        if(tbOaMeeting.getStartTime()!=null&&(tbOaMeeting.getStartTime().getTime() < new Date().getTime())){
            logger.warn("[会议申请] 会议申请失败,会议开始时间不能小于当前时间,oaMeetingId: {},oaMeetingRoomId:{}", oaMeetingAdd.getId(),oaMeetingAdd.getMeetingRoomId());
            throw new JnSpringCloudException(MeetingExceptionEnums.ADD_MEETING_TIME_CONFLICT);
        }

        List<TbOaMeeting> tbOaMeetingList= oaMeetingMapper.selectNotCompleteMeetingByTimeAndMeetingRoomId(tbOaMeeting);
        if(tbOaMeetingList!=null&&tbOaMeetingList.size()>0){
            logger.warn("[会议申请] 会议申请失败,会议室冲突,oaMeetingId: {},oaMeetingRoomId:{}", oaMeetingAdd.getId(),oaMeetingAdd.getMeetingRoomId());
            throw new JnSpringCloudException(MeetingExceptionEnums.ADD_MEETINGROOM_CONFLICT);
        }

        //保存会议申请内容
        TbOaMeetingContent tbOaMeetingContent = new TbOaMeetingContent();
        tbOaMeetingContent.setContent(oaMeetingAdd.getOaMeetingContent());
        tbOaMeetingContent.setCreatedTime(new Date());
        tbOaMeetingContent.setCreatorAccount(oaMeetingAdd.getCreatorAccount());
        tbOaMeetingContent.setId(UUID.randomUUID().toString());
        tbOaMeetingContent.setMeetingId(oaMeetingAdd.getId());
        Byte status = Byte.parseByte(OaStatusEnums.EFFECTIVE.getCode());
        tbOaMeetingContent.setRecordStatus(status);
        tbOaMeetingContentMapper.insert(tbOaMeetingContent);

        //默认会议状态是“待开始”
        tbOaMeeting.setMeetingStatus(MeetingStatusEnums.TO_BEGIN.getCode());
        //重新生成二维码
        saveQRCode(tbOaMeeting);
        tbOaMeetingMapper.insert(tbOaMeeting);
        logger.info("[会议申请] 添加会议申请成功！,tbOaMeetingId: {}", tbOaMeeting.getId());
    }

    /**
     * 更新会议申请信息
     *
     * @param oaMeetingAdd
     * @param user         当前用户信息
     */
    @Override
    @ServiceLog(doAction = "更新会议申请信息")
    @Transactional(rollbackFor = Exception.class)
    public void updateOaMeetingById(OaMeetingAdd oaMeetingAdd, User user) {
        TbOaMeeting tbOaMeeting = new TbOaMeeting();
        BeanUtils.copyProperties(oaMeetingAdd, tbOaMeeting);

        if(tbOaMeeting.getStartTime()!=null&&(tbOaMeeting.getStartTime().getTime() < new Date().getTime())){
            logger.warn("[会议申请] 更改会议申请失败,会议开始时间不能小于当前时间,oaMeetingId: {},oaMeetingRoomId:{}", oaMeetingAdd.getId(),oaMeetingAdd.getMeetingRoomId());
            throw new JnSpringCloudException(MeetingExceptionEnums.UPDATE_MEETING_TIME_CONFLICT);
        }

        //判断修改信息是否存在
        TbOaMeeting oaMeetingSelect = tbOaMeetingMapper.selectByPrimaryKey(oaMeetingAdd.getId());
        if (oaMeetingSelect == null || OaStatusEnums.DELETED.getCode().equals(oaMeetingSelect.getRecordStatus())) {
            logger.warn("[会议申请] 会议修改失败,修改信息不存在,oaMeetingId: {}", oaMeetingAdd.getId());
            throw new JnSpringCloudException(OaExceptionEnums.UPDATEDATA_NOT_EXIST);
        }

        //修改时，判断会议申请的开始时间与结束时间是否与数据库中的开始时间与结束时间一致，不一致则进行会议冲突判断
        TbOaMeeting tbOaMeetingDB =tbOaMeetingMapper.selectByPrimaryKey(tbOaMeeting.getId());
        if(tbOaMeetingDB!=null&&tbOaMeetingDB.getStartTime().compareTo(tbOaMeeting.getStartTime())!=0&&tbOaMeetingDB.getEndTime().compareTo(tbOaMeeting.getEndTime())!=0){
            List<TbOaMeeting> tbOaMeetingList= oaMeetingMapper.selectNotCompleteMeetingByTimeAndMeetingRoomId(tbOaMeeting);
            if(tbOaMeetingList!=null&&tbOaMeetingList.size()>0){
                logger.warn("[会议申请] 会议申请修改失败,会议室冲突,oaMeetingId: {},oaMeetingRoomId:{}", oaMeetingAdd.getId(),oaMeetingAdd.getMeetingRoomId());
                throw new JnSpringCloudException(MeetingExceptionEnums.UPDATE_MEETINGROOM_CONFLICT);
            }
        }


        //保存会议申请内容
        TbOaMeetingContent tbOaMeetingContent = new TbOaMeetingContent();
        tbOaMeetingContent.setModifiedTime(new Date());
        tbOaMeetingContent.setModifierAccount(user.getAccount());
        tbOaMeetingContent.setContent(oaMeetingAdd.getOaMeetingContent());
        TbOaMeetingContentCriteria contentCriteria=new TbOaMeetingContentCriteria();
        TbOaMeetingContentCriteria.Criteria criteria1=contentCriteria.createCriteria();
        criteria1.andMeetingIdEqualTo(oaMeetingAdd.getId());
        tbOaMeetingContentMapper.updateByExampleSelective(tbOaMeetingContent,contentCriteria);

        //设置最近更新人信息
        tbOaMeeting.setModifiedTime(new Date());
        tbOaMeeting.setModifierAccount(user.getId());
        //重新生成二维码
        saveQRCode(tbOaMeeting);
        tbOaMeetingMapper.updateByPrimaryKeySelective(tbOaMeeting);
        logger.info("[会议申请] 更新会议申请成功！,tbOaMeetingId: {}", tbOaMeeting.getId());
    }

    /**
     * 根据id查询会议
     *
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据id查询会议申请")
    public OaMeetingParticipantVo selectOaMeetingById(String id) {

        OaMeetingParticipantVo oaMeetingParticipantVo = oaMeetingMapper.selectMeetingById(id);


        logger.info("[会议申请] 根据Id查询会议申请成功！,tbOaMeetingId: {}", id);
        return oaMeetingParticipantVo;
    }

    private void saveQRCode(TbOaMeeting tbOaMeeting) {
        try {
            //1、二维码logo
            //org.springframework.core.io.Resource resource = resourceLoader.getResource("classpath:zxing/logo.png");
            //String logoFilePath = resource.getFile().getPath();

            //2、获取输出temp目录
            File tempPath = new File(ResourceUtils.getURL("classpath:").getPath());
            if (!tempPath.exists()) {
                tempPath = new File("");
            }
            File tempUpload = new File(tempPath.getAbsolutePath(), "temp/upload/");
            if (!tempUpload.exists()) {
                tempUpload.mkdirs();
            }

            //3、输出文件及路径
            String fileName = "QRCode.png";
            String outFilePath = tempUpload.getAbsolutePath() + File.separator + fileName;  

            //4、二维码连接
            String contents = "会议室二维码签到开发中";

            //5、调用工具类生成二维码
            QRCodeUtils.EncodeHelper(QRCodeUtils.width, QRCodeUtils.height, contents, outFilePath, "");

            //6、File转换为MultipartFile
            MultipartFile multipartFile = MultipartFileUtil.from(ResourceUtils.getFile(outFilePath), null);

            SysDictInvoke sysDictInvoke=new SysDictInvoke();
            //数据字典模块编码
            sysDictInvoke.setModuleCode(MeetingQRCodeFileEnums.MEETING_UPLOAD_MODULE_CODE.getCode());
            //数据字典父分组编码
            sysDictInvoke.setParentGroupCode(MeetingQRCodeFileEnums.MEETING_UPLOAD_PARENT_GROUP_CODE.getCode());
            //数据字典分组编码
            sysDictInvoke.setGroupCode(MeetingQRCodeFileEnums.MEETING_UPLOAD_GROUP_CODE.getCode());
            //数据字典key
            sysDictInvoke.setKey(MeetingQRCodeFileEnums.MEETING_UPLOAD_KEY.getCode());

            //根据条件查询数据字典的值,查询默认“访客文件组”
            Result data=systemClient.selectDictValueByCondition(sysDictInvoke);
            if (data == null || data.getData() == null) {
                logger.warn("[服务调用] 调用内部服务出现未知错误");
                throw new JnSpringCloudException(OaExceptionEnums.CALL_SERVICE_ERROR);
            }
           String fileGroupId=(String) data.getData();


            //7、上传文件至fastdfs
            Result<String> result = uploadClient.uploadFile(multipartFile, false,fileGroupId);

            tbOaMeeting.setSignInQr(result.getData());
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("生成会议签到二维码失败！,oaMeetingId: {}", tbOaMeeting.getId());
            throw new JnSpringCloudException(MeetingExceptionEnums.CTEATE_QRCODE_FAIL);
        }
    }

    /**
     * 审批会议审核
     *
     * @param oaMeetingApprove
     * @param approveUser
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void approveOaMeeting(OaMeetingApprove oaMeetingApprove, User approveUser) {
        TbOaMeeting tbOaMeeting = new TbOaMeeting();

        tbOaMeeting.setId(oaMeetingApprove.getId());

        tbOaMeeting.setModifiedTime(new Date());
        tbOaMeeting.setModifierAccount(approveUser.getId());
        //作废的会议状态，设置为已取消
        if (MeetingApproveStatusEnums.INVALID.getCode().equals(oaMeetingApprove.getApprovalStatus())) {
            tbOaMeeting.setMeetingStatus(MeetingStatusEnums.CANCELLED.getCode());
        }
        tbOaMeetingMapper.updateByPrimaryKeySelective(tbOaMeeting);
    }

    /**
     * 结束会议
     *
     * @param meetingId
     * @param approveUser
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @ServiceLog(doAction = "结束会议")
    public void finishOaMeeting(String meetingId, User approveUser) {
        TbOaMeeting tbOaMeeting = new TbOaMeeting();
        tbOaMeeting.setId(meetingId);
        tbOaMeeting.setMeetingStatus(MeetingStatusEnums.COMPLETED.getCode());
        tbOaMeeting.setModifiedTime(new Date());
        tbOaMeeting.setModifierAccount(approveUser.getAccount());
        tbOaMeetingMapper.updateByPrimaryKeySelective(tbOaMeeting);
    }

    /**
     * 取消会议
     *
     * @param meetingId
     * @param user
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @ServiceLog(doAction = "取消会议")
    public void cancelOaMeeting(String meetingId, User user) {
        TbOaMeeting tbOaMeeting = new TbOaMeeting();
        tbOaMeeting.setId(meetingId);
        tbOaMeeting.setMeetingStatus(MeetingStatusEnums.CANCELLED.getCode());
        tbOaMeeting.setModifiedTime(new Date());
        tbOaMeeting.setModifierAccount(user.getAccount());
        tbOaMeetingMapper.updateByPrimaryKeySelective(tbOaMeeting);
    }

    /**
     * 定时十分钟通知会议申请人
     */
    @Override
    @ServiceLog(doAction = "定时十分钟通知会议申请人")
    public void noticesApplicationMeeting() {
        List<OaMeetingNotice> oaMeetingNoticeList =oaMeetingMapper.noticesApplicationMeeting();
        for(OaMeetingNotice oaMeetingNotice:oaMeetingNoticeList){

            //短信通知
            SmsTemplateVo smsTemplateVo = new SmsTemplateVo();
            smsTemplateVo.setTemplateId(MeetingNoticesTemplateEnums.MESSAGE_TEMPLATE.getCode());
            String[] m = {oaMeetingNotice.getApplicantPhone()};
            smsTemplateVo.setMobiles(m);
            String[] t = {oaMeetingNotice.getMeetingRoomName(),oaMeetingNotice.getTitle()};
            smsTemplateVo.setContents(t);
            messageSource.outputSms().send(MessageBuilder.withPayload(smsTemplateVo).build());
            logger.info("[会议申请] 定时十分钟通知会议申请人！,Contents: {}，phone：{}",Arrays.toString(t),oaMeetingNotice.getApplicantPhone());
            //更新会议通知状态

            TbOaMeeting oaMeeting=new TbOaMeeting();
            oaMeeting.setId(oaMeetingNotice.getId());
            oaMeeting.setIsRemind( MeetingNoticesStatusEnums.HAVE_INFORMED.getCode());
            oaMeeting.setModifiedTime(new Date());
            logger.info("[会议申请] 修改提醒！,meetingId: {}",oaMeetingNotice.getId());
            tbOaMeetingMapper.updateByPrimaryKeySelective(oaMeeting);
        }
    }



    /**
     * 更新会议状态进行中、已完成
     */
    @Override
    @ServiceLog(doAction = "更新会议状态进行中、已完成")
    public void updateMeetingStatusByTime() {
        //更新会议状态为“进行中”
        oaMeetingMapper.updateMeetingRunningStatusByTime();
        //更新会议状态为“已完成”
        oaMeetingMapper.updateMeetingCompleteStatusByTime();
    }


    /**
     * 逻辑删除会议室信息
     *
     * @param ids
     * @param user 当前用户信息
     */
    @Override
    @ServiceLog(doAction = "删除会议申请信息")
    @Transactional(rollbackFor = Exception.class)
    public void deleteOaMeetingByIds(String[] ids, User user) {
        if (ids.length == 0) {
            return;
        }
        //封装用户组id及最近更新人信息
        Map<String, Object> map = getDeleteMap(user, ids, null);
        oaMeetingMapper.deleteBranchByIds(map);
    }

    /**
     * 封装删除信息
     *
     * @param user 当前用户
     * @param ids  用户组id数组
     * @return
     */
    private Map<String, Object> getDeleteMap(User user, String[] ids, String meetingId) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("ids", ids);
        map.put("account", user.getAccount());
        map.put("meetingId", meetingId);
        return map;
    }

    /**
     * 用于做名称校验
     *
     * @param tbOaMeetingTitle
     * @return
     */

    private List<TbOaMeeting> checkName(String tbOaMeetingTitle) {
        TbOaMeetingCriteria tbOaMeetingCriteria = new TbOaMeetingCriteria();
        TbOaMeetingCriteria.Criteria criteria = tbOaMeetingCriteria.createCriteria();
        criteria.andTitleEqualTo(tbOaMeetingTitle);

        return tbOaMeetingMapper.selectByExample(tbOaMeetingCriteria);
    }

    /**
     * 校验会议申请名称是否存在
     *
     * @param tbOaMeetingTitle
     * @return
     */
    @Override
    @ServiceLog(doAction = "校验是否存在")
    public String checkMeetingName(String tbOaMeetingTitle) {
        if (org.apache.commons.lang3.StringUtils.isNotBlank(tbOaMeetingTitle)) {
            List<TbOaMeeting> tbSysFileGroups = checkName(tbOaMeetingTitle);
            if (tbSysFileGroups != null && tbSysFileGroups.size() > 0) {
                return OaReturnMessageEnum.FAIL.getMessage();
            }
        }
        return OaReturnMessageEnum.SUCCESS.getMessage();
    }

}
