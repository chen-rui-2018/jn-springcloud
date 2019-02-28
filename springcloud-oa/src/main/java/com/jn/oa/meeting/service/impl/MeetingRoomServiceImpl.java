package com.jn.oa.meeting.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.oa.common.enums.OaExceptionEnums;
import com.jn.oa.common.enums.OaReturnMessageEnum;
import com.jn.oa.common.enums.OaStatusEnums;

import com.jn.oa.meeting.dao.OaMeetingRoomPhotoMapper;
import com.jn.oa.meeting.dao.TbOaMeetingRoomMapper;
import com.jn.oa.meeting.dao.OaMeetingRoomMapper;
import com.jn.oa.meeting.dao.TbOaMeetingRoomPhotoMapper;
import com.jn.oa.meeting.entity.TbOaMeetingRoom;
import com.jn.oa.meeting.entity.TbOaMeetingRoomCriteria;
import com.jn.oa.meeting.entity.TbOaMeetingRoomPhoto;
import com.jn.oa.meeting.enums.OaMeetingRoomStatusEnums;
import com.jn.oa.meeting.model.OaMeetingRoom;
import com.jn.oa.meeting.model.OaMeetingRoomAdd;
import com.jn.oa.meeting.model.OaMeetingRoomOrderPage;
import com.jn.oa.meeting.model.OaMeetingRoomPage;
import com.jn.oa.meeting.service.MeetingRoomService;
import com.jn.oa.meeting.vo.OaMeetingRoomVo;
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
 * 会议室service
 * @author： yuanyy
 * @date： Created on 2019/1/29 17:01
 * @version： v1.0
 * @modified By:
 */
@Service
public class MeetingRoomServiceImpl implements MeetingRoomService {
    private static Logger logger = LoggerFactory.getLogger(MeetingRoomServiceImpl.class);

    @Resource
    private TbOaMeetingRoomMapper tbOaMeetingRoomMapper;

    @Resource
    private OaMeetingRoomMapper oaMeetingRoomMapper;

    @Resource
    private TbOaMeetingRoomPhotoMapper tbOaMeetingRoomPhotoMapper;

    @Resource
    private OaMeetingRoomPhotoMapper oaMeetingRoomPhotoMapper;


    /**
     * 根据关键字分页查询会议室列表
     *
     * @param oaMeetingRoomPage
     * @return
     */
    @Override
    @ServiceLog(doAction = "关键字分页查询会议室列表")
    public PaginationData selectOaMeetingRoomListBySearchKey(OaMeetingRoomPage oaMeetingRoomPage) {
        Page<Object> objects = PageHelper.startPage(oaMeetingRoomPage.getPage(), oaMeetingRoomPage.getRows());
        return new PaginationData(oaMeetingRoomMapper.selectListByCondition(oaMeetingRoomPage)
                , objects.getTotal());

    }
    @Override
    @ServiceLog(doAction = "关键字分页查询会议室可用列表")
    public PaginationData selectAvailableMeetingRoomList(OaMeetingRoomPage oaMeetingRoomPage) {
        Page<Object> objects = PageHelper.startPage(oaMeetingRoomPage.getPage(), oaMeetingRoomPage.getRows());
        return new PaginationData(oaMeetingRoomMapper.selectAvailableMeetingRoomList(oaMeetingRoomPage)
                , objects.getTotal());

    }


    /**
     * 新增会议室
     *
     * @param tbOaMeetingRoom
     */
    @Override
    @ServiceLog(doAction = "新增会议室")
    @Transactional(rollbackFor = Exception.class)
    public void insertOaMeetingRoom(TbOaMeetingRoom tbOaMeetingRoom,String[] attachmentPaths) {
        //名称校验
        List<TbOaMeetingRoom> tbSysFileGroups = checkName(tbOaMeetingRoom.getName());
        if (tbSysFileGroups != null && tbSysFileGroups.size() > 0) {
            logger.warn("[会议室] 添加会议室失败，该会议室名称已存在！,tbOaMeetingRoomName: {}", tbOaMeetingRoom.getName());
            throw new JnSpringCloudException(OaExceptionEnums.ADDERR_NAME_EXIST);
        }

        if(attachmentPaths!=null&&attachmentPaths.length>0){
            //批量保存附件信息
            saveOaMeetingRoomPhoto(attachmentPaths,tbOaMeetingRoom.getCreatorAccount(),tbOaMeetingRoom.getId());
        }

        tbOaMeetingRoom.setRecordStatus(OaStatusEnums.EFFECTIVE.getCode());
        //设置会议室位置信息
        tbOaMeetingRoom.setPosition(tbOaMeetingRoom.getBuilding()+tbOaMeetingRoom.getFloor()+tbOaMeetingRoom.getRoomNumber());
        tbOaMeetingRoomMapper.insert(tbOaMeetingRoom);
        logger.info("[会议室] 添加会议室成功！,tbOaMeetingRoomId: {}", tbOaMeetingRoom.getId());
    }



    /**
     * 更新会议室信息
     *
     * @param oaMeetingRoom
     * @param user         当前用户信息
     */
    @Override
    @ServiceLog(doAction = "更新会议室信息")
    @Transactional(rollbackFor = Exception.class)
    public void updateOaMeetingRoomById(OaMeetingRoomAdd oaMeetingRoom, User user, String[] attachmentPaths) {
        String tbOaMeetingRoomName = oaMeetingRoom.getName();
        //判断修改信息是否存在
        TbOaMeetingRoom oaMeetingRoomSelect = tbOaMeetingRoomMapper.selectByPrimaryKey(oaMeetingRoom.getId());
        if (oaMeetingRoomSelect == null || OaStatusEnums.DELETED.getCode().equals(oaMeetingRoomSelect.getRecordStatus())) {
            logger.warn("[会议室] 会议室修改失败,修改信息不存在,oaMeetingRoomId: {}", oaMeetingRoom.getId());
            throw new JnSpringCloudException(OaExceptionEnums.UPDATEDATA_NOT_EXIST);
        } else {
            //判断名称是否修改
            if (!oaMeetingRoomSelect.getName().equals(tbOaMeetingRoomName)) {
                //校验名称是否已经在数据库中存在
                List<TbOaMeetingRoom> tbSysFileGroups = checkName(tbOaMeetingRoomName);
                if (tbSysFileGroups != null && tbSysFileGroups.size() > 0) {
                    logger.warn("[会议室] 更新会议室失败，该会议室名称已存在！,oaMeetingRoomName: {}", tbOaMeetingRoomName);
                    throw new JnSpringCloudException(OaExceptionEnums.UPDATEERR_NAME_EXIST);
                }
            }
        }
        //封装用户组id及最近更新人信息
        String[] ids={oaMeetingRoom.getId()};
        Map<String, Object> map = getDeleteMap(user, ids);
        //删除对应附件信息
        oaMeetingRoomPhotoMapper.deleteBranchByIds(map);
        if(attachmentPaths!=null&&attachmentPaths.length>0){

            //批量保存附件信息
            saveOaMeetingRoomPhoto(oaMeetingRoom.getAttachmentPaths(),user.getId(),oaMeetingRoom.getId());
        }
        //对文件组信息进行修改操作
        TbOaMeetingRoom tbOaMeetingRoom = new TbOaMeetingRoom();
        BeanUtils.copyProperties(oaMeetingRoom, tbOaMeetingRoom);
        //设置最近更新人信息
        tbOaMeetingRoom.setModifiedTime(new Date());
        tbOaMeetingRoom.setModifierAccount(user.getId());
        tbOaMeetingRoomMapper.updateByPrimaryKeySelective(tbOaMeetingRoom);
        logger.info("[会议室] 更新会议室成功！,tbOaMeetingRoomId: {}", tbOaMeetingRoom.getId());
    }

    /**
     * 保存附件信息
     * @param attachmentPaths
     */
    private void saveOaMeetingRoomPhoto(String[] attachmentPaths ,String userId,String meetingRoomId){
        for(String attachmentPath:attachmentPaths){
            TbOaMeetingRoomPhoto attachment=new TbOaMeetingRoomPhoto();
            attachment.setId(UUID.randomUUID().toString());
            attachment.setCreatedTime(new Date());
            attachment.setCreatorAccount(userId);
            attachment.setPhotoUrl(attachmentPath);
            attachment.setMeetingRoomId(meetingRoomId);
            Byte recordStatus = Byte.parseByte(OaStatusEnums.EFFECTIVE.getCode());
            attachment.setRecordStatus(recordStatus);
            tbOaMeetingRoomPhotoMapper.insert(attachment);
        }
    }

    /**
     * 根据id查询会议室
     *
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据id查询会议室")
    public OaMeetingRoomVo selectOaMeetingRoomByIds(String id) {
        OaMeetingRoomVo oaMeetingRoomVo = oaMeetingRoomMapper.selectMeetingRoomById(id);
        logger.info("[会议室] 根据Id查询会议室成功！,tbOaMeetingRoomId: {}", id);
        return oaMeetingRoomVo;
    }

    @Override
    public PaginationData selectMeetingRoomAndMeetingOrder(OaMeetingRoomOrderPage oaMeetingRoomOrderPage) {
        Page<Object> objects = PageHelper.startPage(oaMeetingRoomOrderPage.getPage(), oaMeetingRoomOrderPage.getRows());
        return new PaginationData(oaMeetingRoomMapper.selectMeetingRoomAndMeetingOrder(oaMeetingRoomOrderPage)
                , objects.getTotal());
    }


    /**
     * 逻辑删除会议室信息
     *
     * @param ids
     * @param user 当前用户信息
     */
    @Override
    @ServiceLog(doAction = "删除会议室信息")
    @Transactional(rollbackFor = Exception.class)
    public void deleteOaMeetingRoomByIds(String[] ids, User user) {
        if (ids.length == 0){
            return;
        }
        //封装用户组id及最近更新人信息
        Map<String, Object> map = getDeleteMap(user, ids);

        //删除对应附件信息
        oaMeetingRoomPhotoMapper.deleteBranchByIds(map);
        //删除会议室
        oaMeetingRoomMapper.deleteBranchByIds(map);
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
        map.put("account", user.getId());
        return map;
    }

    /**
     * 用于做名称校验
     *
     * @param tbOaMeetingRoomName
     * @return
     */

    private List<TbOaMeetingRoom> checkName(String tbOaMeetingRoomName) {
        TbOaMeetingRoomCriteria tbOaMeetingRoomCriteria = new TbOaMeetingRoomCriteria();
        TbOaMeetingRoomCriteria.Criteria criteria = tbOaMeetingRoomCriteria.createCriteria();
        criteria.andNameEqualTo(tbOaMeetingRoomName);
        //筛选已经删除的数据
        criteria.andRecordStatusNotEqualTo(OaMeetingRoomStatusEnums.DELETED.getCode());
        return tbOaMeetingRoomMapper.selectByExample(tbOaMeetingRoomCriteria);
    }

    /**
     * 校验文件组是否存在
     *
     * @param tbOaMeetingRoomName
     * @return
     */
    @Override
    @ServiceLog(doAction = "校验文件组是否存在")
    public String checkMeetingRoomName(String tbOaMeetingRoomName) {
        if (org.apache.commons.lang3.StringUtils.isNotBlank(tbOaMeetingRoomName)) {
            List<TbOaMeetingRoom> tbOaMeetingRoom = checkName(tbOaMeetingRoomName);
            if (tbOaMeetingRoom != null && tbOaMeetingRoom.size() > 0) {
                return OaReturnMessageEnum.FAIL.getMessage();
            }
        }
        return OaReturnMessageEnum.SUCCESS.getMessage();
    }

}
