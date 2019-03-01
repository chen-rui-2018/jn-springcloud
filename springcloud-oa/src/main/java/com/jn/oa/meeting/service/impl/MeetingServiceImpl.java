package com.jn.oa.meeting.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.common.util.file.MultipartFileUtil;
import com.jn.common.util.zxing.QRCodeUtils;
import com.jn.oa.common.enums.OaExceptionEnums;
import com.jn.oa.common.enums.OaReturnMessageEnum;
import com.jn.oa.common.enums.OaStatusEnums;
import com.jn.oa.meeting.dao.*;
import com.jn.oa.meeting.entity.TbOaMeeting;
import com.jn.oa.meeting.entity.TbOaMeetingContent;
import com.jn.oa.meeting.entity.TbOaMeetingCriteria;
import com.jn.oa.meeting.entity.TbOaMeetingParticipants;
import com.jn.oa.meeting.enums.OaMeetingApproveStatusEnums;
import com.jn.oa.meeting.enums.OaMeetingStatusEnums;
import com.jn.oa.meeting.model.OaMeeting;
import com.jn.oa.meeting.model.OaMeetingAdd;
import com.jn.oa.meeting.model.OaMeetingApprove;
import com.jn.oa.meeting.model.OaMeetingPage;
import com.jn.oa.meeting.service.MeetingService;
import com.jn.oa.meeting.vo.OaMeetingParticipantVo;
import com.jn.oa.meeting.vo.OaMeetingVo;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.upload.api.UploadClient;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * 会议申请service
 * @author： yuanyy
 * @date： Created on 2019/1/29 17:01
 * @version： v1.0
 * @modified By:
 */
@Service
public class MeetingServiceImpl implements MeetingService {
    private static Logger logger = LoggerFactory.getLogger(MeetingServiceImpl.class);

    @Resource
    private TbOaMeetingMapper tbOaMeetingMapper;

    @Resource
    private OaMeetingMapper oaMeetingMapper;

    @Resource
    private TbOaMeetingContentMapper tbOaMeetingContentMapper;

    @Resource
    private TbOaMeetingParticipantsMapper tbOaMeetingParticipantsMapper;

    @Resource
    private OaMeetingParticipantMapper oaMeetingParticipantMapper;

    @Autowired
    private UploadClient uploadClient;



    /**
     * 根据关键字分页查询会议申请列表
     *
     * @param oaMeetingPage
     * @return
     */
    @Override
    @ServiceLog(doAction = "关键字分页查询会议申请列表")
    public PaginationData selectOaMeetingListBySearchKey(OaMeetingPage oaMeetingPage) {
        Page<Object> objects = PageHelper.startPage(oaMeetingPage.getPage(), oaMeetingPage.getRows());
        return new PaginationData(oaMeetingMapper.selectMeetingListByCondition(oaMeetingPage)
                , objects.getTotal());


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
        //名称校验
        List<TbOaMeeting> tbSysFileGroups = checkName(tbOaMeeting.getTitle());
        if (tbSysFileGroups != null && tbSysFileGroups.size() > 0) {
            logger.warn("[会议申请] 添加会议申请失败，该会议申请名称已存在！,tbOaMeetingName: {}", tbOaMeeting.getTitle());
            throw new JnSpringCloudException(OaExceptionEnums.ADDERR_NAME_EXIST);
        }
        //保存会议申请内容
        TbOaMeetingContent tbOaMeetingContent=new TbOaMeetingContent();
        tbOaMeetingContent.setContent(oaMeetingAdd.getOaMeetingContent());
        tbOaMeetingContent.setCreatedTime(new Date());
        tbOaMeetingContent.setCreatorAccount(oaMeetingAdd.getCreatorAccount());
        tbOaMeetingContent.setId(UUID.randomUUID().toString());
        tbOaMeetingContent.setMeetingId(oaMeetingAdd.getId());
        Byte status = Byte.parseByte(OaStatusEnums.EFFECTIVE.getCode());
        tbOaMeetingContent.setRecordStatus(status);
        tbOaMeetingContentMapper.insert(tbOaMeetingContent);
        //保存参会人员信息
        saveOaMeetingParticipant(oaMeetingAdd.getParticipantsId(),oaMeetingAdd.getCreatorAccount(),oaMeetingAdd.getId());

        //默认提交为审批状态为“审批中”，会议状态是“待开始”
        tbOaMeeting.setApprovalStatus(OaMeetingApproveStatusEnums.APPROVAL.getCode());
        tbOaMeeting.setMeetingStatus(OaMeetingStatusEnums.TO_BEGIN.getCode());
        tbOaMeetingMapper.insert(tbOaMeeting);
        logger.info("[会议申请] 添加会议申请成功！,tbOaMeetingId: {}", tbOaMeeting.getId());
    }

    /**
     * 保存用户参会人员信息
     * @param participantsIds
     */
    private  void saveOaMeetingParticipant(String[] participantsIds,String creatorAccount,String meetingId){
        if(participantsIds!=null&&participantsIds.length>0) {
            //保存参会人员信息
            for (String participantsId : participantsIds) {
                TbOaMeetingParticipants tbOaMeetingParticipants = new TbOaMeetingParticipants();
                tbOaMeetingParticipants.setId(UUID.randomUUID().toString());
                tbOaMeetingParticipants.setMeetingUserId(participantsId);
                tbOaMeetingParticipants.setCreatedTime(new Date());
                tbOaMeetingParticipants.setCreatorAccount(creatorAccount);
                Byte status = Byte.parseByte(OaStatusEnums.EFFECTIVE.getCode());
                tbOaMeetingParticipants.setRecordStatus(status);
                tbOaMeetingParticipants.setMeetingId(meetingId);
                tbOaMeetingParticipantsMapper.insert(tbOaMeetingParticipants);

            }
        }
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
        String tbOaMeetingTitle = oaMeetingAdd.getTitle();
        //判断修改信息是否存在
        TbOaMeeting oaMeetingSelect = tbOaMeetingMapper.selectByPrimaryKey(oaMeetingAdd.getId());
        if (oaMeetingSelect == null || OaStatusEnums.DELETED.getCode().equals(oaMeetingSelect.getRecordStatus())) {
            logger.warn("[会议申请] 会议修改失败,修改信息不存在,oaMeetingId: {}", oaMeetingAdd.getId());
            throw new JnSpringCloudException(OaExceptionEnums.UPDATEDATA_NOT_EXIST);
        } else {
            //判断名称是否修改
            if (!oaMeetingSelect.getTitle().equals(tbOaMeetingTitle)) {
                //校验名称是否已经在数据库中存在
                List<TbOaMeeting> tbOaMeetings = checkName(tbOaMeetingTitle);
                if (tbOaMeetings != null && tbOaMeetings.size() > 0) {
                    logger.warn("[会议申请] 更新会议申请失败，该会议申请名称已存在！,oaMeetingTitle: {}", tbOaMeetingTitle);
                    throw new JnSpringCloudException(OaExceptionEnums.UPDATEERR_NAME_EXIST);
                }
            }
        }
        //根据会议id删除参会人员
        oaMeetingParticipantMapper.deleteBranchByMeetingIds( getDeleteMap( user, null, oaMeetingAdd.getId()));
        //保存参会人员的信息
        saveOaMeetingParticipant(oaMeetingAdd.getParticipantsId(),oaMeetingAdd.getCreatorAccount(),oaMeetingAdd.getId());

        TbOaMeeting tbOaMeeting = new TbOaMeeting();
        BeanUtils.copyProperties(oaMeetingAdd, tbOaMeeting);
        //设置最近更新人信息
        tbOaMeeting.setModifiedTime(new Date());
        tbOaMeeting.setModifierAccount(user.getId());
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

        OaMeetingParticipantVo oaMeetingParticipantVo= oaMeetingMapper.selectMeetingById(id);


        logger.info("[会议申请] 根据Id查询会议申请成功！,tbOaMeetingId: {}", id);
        return oaMeetingParticipantVo;
    }

    /**
     * 审批会议审核
     * @param oaMeetingApprove
     * @param approveUser
     */
    @Override
    public void approveOaMeeting(OaMeetingApprove oaMeetingApprove, User approveUser) {
        TbOaMeeting tbOaMeeting =new TbOaMeeting();
        tbOaMeeting.setApprovalUser(approveUser.getId());
        tbOaMeeting.setId(oaMeetingApprove.getId());
        tbOaMeeting.setApprovalStatus(oaMeetingApprove.getApprovalStatus());
        tbOaMeeting.setModifiedTime(new Date());
        tbOaMeeting.setModifierAccount(approveUser.getId());
        tbOaMeeting.setApprovalOpinion(oaMeetingApprove.getApprovalOpinion());

        //审核通过
        if(OaMeetingApproveStatusEnums.APPROVAL_PASS.getCode().equals(oaMeetingApprove.getApprovalStatus())){
            try {
                //1、生成二维码
                File file = ResourceUtils.getFile("classpath:zxing");
                String contents = "http://www.baidu.com";
                String fileName= "QRCode.png";
                String outFilePath = file.getPath() + File.separator +fileName;
                String logoFilePath = file.getPath() + File.separator + "logo.png";
                QRCodeUtils.EncodeHelper(QRCodeUtils.width, QRCodeUtils.height, contents, outFilePath, logoFilePath);

                //2、上传至fastdfs
                // File QRCodeFile = ResourceUtils.getFile("classpath:zxing/QRCode.png");
                // FileInputStream fileInputStream = new FileInputStream(QRCodeFile);
                MultipartFile multipartFile =  MultipartFileUtil.from(file,fileName);

                Result<String> result = uploadClient.uploadFile(multipartFile, false);
                tbOaMeeting.setSignInQr(result.getData());
            }catch (Exception e){
                e.printStackTrace();
                logger.warn("生成会议签到二维码失败！,oaMeetingId: {}",oaMeetingApprove.getId() );
                throw new JnSpringCloudException(OaExceptionEnums.CTEATE_QRCODE_FAIL);
            }

        }
        //作废的会议状态，设置为已取消
        if(OaMeetingApproveStatusEnums.INVALID.getCode().equals(oaMeetingApprove.getApprovalStatus())){
            tbOaMeeting.setMeetingStatus(OaMeetingStatusEnums.CANCELLED.getCode());
        }
        tbOaMeetingMapper.updateByPrimaryKeySelective(tbOaMeeting);
    }

    /**
     * 结束会议
     * @param meetingId
     * @param approveUser
     */
    @Override
    public void finishOaMeeting(String meetingId, User approveUser) {
        TbOaMeeting tbOaMeeting =new TbOaMeeting();
        tbOaMeeting.setId(meetingId);
        tbOaMeeting.setMeetingStatus(OaMeetingStatusEnums.COMPLETED.getCode());
        tbOaMeeting.setModifiedTime(new Date());
        tbOaMeeting.setModifierAccount(approveUser.getId());
        tbOaMeetingMapper.updateByPrimaryKeySelective(tbOaMeeting);
    }

    /**
     * 取消会议
     * @param meetingId
     * @param user
     */
    @Override
    public void cancelOaMeeting(String meetingId, User user) {
        TbOaMeeting tbOaMeeting =new TbOaMeeting();
        tbOaMeeting.setId(meetingId);
        tbOaMeeting.setApprovalStatus(OaMeetingApproveStatusEnums.CANCELLED.getCode());
        tbOaMeeting.setModifiedTime(new Date());
        tbOaMeeting.setModifierAccount(user.getId());
        tbOaMeetingMapper.updateByPrimaryKeySelective(tbOaMeeting);
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
        if (ids.length == 0){
            return;
        }
        //封装用户组id及最近更新人信息
        Map<String, Object> map = getDeleteMap(user, ids,null);
        oaMeetingMapper.deleteBranchByIds(map);
    }
    /**
     * 封装删除信息
     * @param user 当前用户
     * @param ids 用户组id数组
     * @return
     */
    private Map<String, Object> getDeleteMap(User user, String[] ids,String meetingId) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("ids", ids);
        map.put("account", user.getAccount());
        map.put("meetingId",meetingId);
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
        //筛选已取消的数据
        Byte cancelledStatus = Byte.parseByte(OaMeetingApproveStatusEnums .CANCELLED.getCode());
        //        //过滤已作废的数据
         //Byte invalidStatus = Byte.parseByte(OaMeetingStatusEnums.INVALID.getCode());
        criteria.andRecordStatusEqualTo(cancelledStatus);
       // criteria.andRecordStatusEqualTo(invalidStatus);
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
