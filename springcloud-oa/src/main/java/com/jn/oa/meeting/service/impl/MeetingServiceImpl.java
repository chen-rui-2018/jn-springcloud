package com.jn.oa.meeting.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.oa.common.enums.OaExceptionEnums;
import com.jn.oa.common.enums.OaReturnMessageEnum;
import com.jn.oa.common.enums.OaStatusEnums;
import com.jn.oa.meeting.dao.OaMeetingMapper;
import com.jn.oa.meeting.dao.TbOaMeetingContentMapper;
import com.jn.oa.meeting.dao.TbOaMeetingMapper;
import com.jn.oa.meeting.entity.TbOaMeeting;
import com.jn.oa.meeting.entity.TbOaMeetingContent;
import com.jn.oa.meeting.entity.TbOaMeetingCriteria;
import com.jn.oa.meeting.enums.OaMeetingApproveStatusEnums;
import com.jn.oa.meeting.model.OaMeeting;
import com.jn.oa.meeting.model.OaMeetingAdd;
import com.jn.oa.meeting.model.OaMeetingApprove;
import com.jn.oa.meeting.model.OaMeetingPage;
import com.jn.oa.meeting.service.MeetingService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
        TbOaMeetingCriteria oaMeetingCriteria = new TbOaMeetingCriteria();
        oaMeetingCriteria.setOrderByClause("created_time desc,id desc");
        TbOaMeetingCriteria.Criteria criteria = oaMeetingCriteria.createCriteria();
        if (!StringUtils.isEmpty(oaMeetingPage.getTitle())) {
            //模糊查询搜索关键字
            criteria.andTitleLike("%" + oaMeetingPage.getTitle() + "%");
        }
        if (!StringUtils.isEmpty(oaMeetingPage.getId())) {
            //根据id查询
            criteria.andIdEqualTo(oaMeetingPage.getId());
        }
        if (oaMeetingPage.getRecordStatus() != null) {
            //筛选条件：状态
            criteria.andRecordStatusEqualTo( oaMeetingPage.getRecordStatus());
        }

        //过滤已取消的数据
        Byte cancelledStatus = Byte.parseByte(OaMeetingApproveStatusEnums .CANCELLED.getCode());
        //过滤已作废的数据
        Byte invalidStatus = Byte.parseByte(OaMeetingApproveStatusEnums .INVALID.getCode());
        criteria.andRecordStatusNotEqualTo(cancelledStatus);
        criteria.andRecordStatusNotEqualTo(invalidStatus);
        return new PaginationData(tbOaMeetingMapper.selectByExample(oaMeetingCriteria)
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
        tbOaMeetingContentMapper.insert(tbOaMeetingContent);
        tbOaMeetingMapper.insert(tbOaMeeting);
        logger.info("[会议申请] 添加会议申请成功！,tbOaMeetingId: {}", tbOaMeeting.getId());
    }

    /**
     * 更新会议申请信息
     *
     * @param oaMeeting
     * @param user         当前用户信息
     */
    @Override
    @ServiceLog(doAction = "更新会议申请信息")
    @Transactional(rollbackFor = Exception.class)
    public void updateOaMeetingById(OaMeeting oaMeeting, User user) {
        String tbOaMeetingTitle = oaMeeting.getTitle();
        //判断修改信息是否存在
        TbOaMeeting oaMeetingSelect = tbOaMeetingMapper.selectByPrimaryKey(oaMeeting.getId());
        if (oaMeetingSelect == null || OaStatusEnums.DELETED.getCode().equals(oaMeetingSelect.getRecordStatus())) {
            logger.warn("[会议申请] 会议修改失败,修改信息不存在,oaMeetingId: {}", oaMeeting.getId());
            throw new JnSpringCloudException(OaExceptionEnums.UPDATEDATA_NOT_EXIST);
        } else {
            //判断名称是否修改
            if (!oaMeetingSelect.getTitle().equals(tbOaMeetingTitle)) {
                //校验名称是否已经在数据库中存在
                List<TbOaMeeting> tbSysFileGroups = checkName(tbOaMeetingTitle);
                if (tbSysFileGroups != null && tbSysFileGroups.size() > 0) {
                    logger.warn("[会议申请] 更新会议申请失败，该会议申请名称已存在！,oaMeetingTitle: {}", tbOaMeetingTitle);
                    throw new JnSpringCloudException(OaExceptionEnums.UPDATEERR_NAME_EXIST);
                }
            }
        }
        //对文件组信息进行修改操作
        TbOaMeeting tbOaMeeting = new TbOaMeeting();
        BeanUtils.copyProperties(oaMeeting, tbOaMeeting);
        //设置最近更新人信息
        tbOaMeeting.setModifiedTime(new Date());
        tbOaMeeting.setModifierAccount(user.getAccount());
        tbOaMeetingMapper.updateByPrimaryKeySelective(tbOaMeeting);
        logger.info("[会议申请] 更新会议申请成功！,tbOaMeetingId: {}", tbOaMeeting.getId());
    }

    /**
     * 根据id查询会议室
     *
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据id查询会议申请")
    public OaMeeting selectOaMeetingByIds(String id) {
        TbOaMeeting tbOaMeeting = tbOaMeetingMapper.selectByPrimaryKey(id);
        OaMeeting oaMeeting = new OaMeeting();
        if (tbOaMeeting != null) {
            BeanUtils.copyProperties(tbOaMeeting, oaMeeting);
        }
        logger.info("[会议申请] 根据Id查询会议申请成功！,tbOaMeetingRoomId: {}", id);
        return oaMeeting;
    }

    /**
     * 审批会议审核
     * @param oaMeetingApprove
     * @param approveUser
     */
    @Override
    public void approveOaMeeting(OaMeetingApprove oaMeetingApprove, User approveUser) {
        TbOaMeeting tbOaMeeting =new TbOaMeeting();
        tbOaMeeting.setApprovalUser(approveUser.getAccount());
        tbOaMeeting.setId(oaMeetingApprove.getId());
        tbOaMeeting.setApprovalStatus(oaMeetingApprove.getApprovalStatus());
        tbOaMeeting.setModifiedTime(new Date());
        tbOaMeeting.setModifierAccount(approveUser.getAccount());
        tbOaMeeting.setApprovalOpinion(oaMeetingApprove.getApprovalOpinion());
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
        tbOaMeeting.setApprovalStatus(OaMeetingApproveStatusEnums.CANCELLED.getCode());
        tbOaMeeting.setModifiedTime(new Date());
        tbOaMeeting.setModifierAccount(approveUser.getAccount());
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
        Map<String, Object> map = getDeleteMap(user, ids);
        oaMeetingMapper.deleteBranchByIds(map);
    }
    /**
     * 封装删除信息
     * @param user 当前用户
     * @param ids 用户组id数组
     * @return
     */
    private Map<String, Object> getDeleteMap(User user, String[] ids) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("ids", ids);
        map.put("account", user.getAccount());
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
