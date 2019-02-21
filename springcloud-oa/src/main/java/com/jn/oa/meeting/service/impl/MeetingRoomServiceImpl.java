package com.jn.oa.meeting.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.oa.common.enums.OaExceptionEnums;
import com.jn.oa.common.enums.OaReturnMessageEnum;
import com.jn.oa.common.enums.OaStatusEnums;

import com.jn.oa.meeting.dao.TbOaMeetingRoomMapper;
import com.jn.oa.meeting.dao.OaMeetingRoomMapper;
import com.jn.oa.meeting.entity.TbOaMeetingRoom;
import com.jn.oa.meeting.entity.TbOaMeetingRoomCriteria;
import com.jn.oa.meeting.enums.OaMeetingRoomStatusEnums;
import com.jn.oa.meeting.model.OaMeetingRoom;
import com.jn.oa.meeting.model.OaMeetingRoomPage;
import com.jn.oa.meeting.service.MeetingRoomService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private TbOaMeetingRoomMapper tbOaMeetingRoomMapper;

    @Autowired
    private OaMeetingRoomMapper oaMeetingRoomMapper;


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
        TbOaMeetingRoomCriteria oaMeetingRoomCriteria = new TbOaMeetingRoomCriteria();
        oaMeetingRoomCriteria.setOrderByClause("created_time desc,id desc");
        TbOaMeetingRoomCriteria.Criteria criteria = oaMeetingRoomCriteria.createCriteria();
        if (!StringUtils.isEmpty(oaMeetingRoomPage.getName())) {
            //模糊查询搜索关键字
            criteria.andNameLike("%" + oaMeetingRoomPage.getName() + "%");
        }
        if (!StringUtils.isEmpty(oaMeetingRoomPage.getId())) {
            //根据id查询
            criteria.andIdEqualTo(oaMeetingRoomPage.getId());
        }
        if (oaMeetingRoomPage.getRecordStatus() != null) {
            //筛选条件：状态
            criteria.andRecordStatusEqualTo( oaMeetingRoomPage.getRecordStatus());
        }

        //过滤已删除的数据
        criteria.andRecordStatusNotEqualTo(OaMeetingRoomStatusEnums.DELETED.getCode());
        return new PaginationData(tbOaMeetingRoomMapper.selectByExample(oaMeetingRoomCriteria)
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
    public void insertOaMeetingRoom(TbOaMeetingRoom tbOaMeetingRoom) {
        //名称校验
        List<TbOaMeetingRoom> tbSysFileGroups = checkName(tbOaMeetingRoom.getName());
        if (tbSysFileGroups != null && tbSysFileGroups.size() > 0) {
            logger.warn("[会议室] 添加会议室失败，该会议室名称已存在！,tbOaMeetingRoomName: {}", tbOaMeetingRoom.getName());
            throw new JnSpringCloudException(OaExceptionEnums.ADDERR_NAME_EXIST);
        }
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
    public void updateOaMeetingRoomById(OaMeetingRoom oaMeetingRoom, User user) {
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
        //对文件组信息进行修改操作
        TbOaMeetingRoom tbOaMeetingRoom = new TbOaMeetingRoom();
        BeanUtils.copyProperties(oaMeetingRoom, tbOaMeetingRoom);
        //设置最近更新人信息
        tbOaMeetingRoom.setModifiedTime(new Date());
        tbOaMeetingRoom.setModifierAccount(user.getAccount());
        tbOaMeetingRoomMapper.updateByPrimaryKeySelective(tbOaMeetingRoom);
        logger.info("[会议室] 更新会议室成功！,tbOaMeetingRoomId: {}", tbOaMeetingRoom.getId());
    }

    /**
     * 根据id查询会议室
     *
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据id查询会议室")
    public OaMeetingRoom selectOaMeetingRoomByIds(String id) {
        TbOaMeetingRoom tbOaMeetingRoom = tbOaMeetingRoomMapper.selectByPrimaryKey(id);
        OaMeetingRoom oaMeetingRoom = new OaMeetingRoom();
        if (tbOaMeetingRoom != null) {
            BeanUtils.copyProperties(tbOaMeetingRoom, oaMeetingRoom);
        }
        logger.info("[会议室] 根据Id查询会议室成功！,tbOaMeetingRoomId: {}", id);
        return oaMeetingRoom;
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
        map.put("account", user.getAccount());
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
        criteria.andRecordStatusEqualTo(OaMeetingRoomStatusEnums.DELETED.getCode());
        return tbOaMeetingRoomMapper.selectByExample(tbOaMeetingRoomCriteria);
    }

    /**
     * 校验文件组是否存在
     *
     * @param fileGroupName
     * @return
     */
    @Override
    @ServiceLog(doAction = "校验文件组是否存在")
    public String checkMeetingRoomName(String fileGroupName) {
        if (org.apache.commons.lang3.StringUtils.isNotBlank(fileGroupName)) {
            List<TbOaMeetingRoom> tbSysFileGroups = checkName(fileGroupName);
            if (tbSysFileGroups != null && tbSysFileGroups.size() > 0) {
                return OaReturnMessageEnum.FAIL.getMessage();
            }
        }
        return OaReturnMessageEnum.SUCCESS.getMessage();
    }

}
