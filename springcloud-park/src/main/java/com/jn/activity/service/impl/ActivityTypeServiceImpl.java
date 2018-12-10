package com.jn.activity.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jn.activity.dao.*;
import com.jn.activity.entity.*;
import com.jn.activity.enums.ActivityExceptionEnum;
import com.jn.activity.model.ActivityType;
import com.jn.activity.service.ActivityTypeService;
import com.jn.activity.vo.ActivityTypeVO;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.StringUtils;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 活动类型服务
 *
 * @Author: chenr
 * @Date: 2018/12/5 15:16
 * @Version v1.0
 * @modified By:
 */
@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {
    @Autowired
    private TbActivityTypeMapper tbActivityTypeMapper;
    @Autowired
    private ActivityFileMapper activityFileMapper;
    @Autowired
    private ActivityTypeMapper activityTypeMapper;
    @Autowired
    private TbActivityMapper tbActivityMapper;
    @Autowired
    private TbActivityFileMapper tbActivityFileMapper;

    /**
     * 新增活动类型
     *
     * @param typeName
     * @param state
     * @param templateList
     * @return
     */
    @ServiceLog(doAction = "新增活动类型")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertActivityType(String typeName, String state, List<String> templateList, User user) {
        String type = "insert";
        // 插入活动类型基本信息
        TbActivityType activityType = new TbActivityType();
        String typeId = UUID.randomUUID().toString().replaceAll("-", "");
        activityType.setTypeId(typeId);
        activityType.setCreateTime(new Date());
        activityType.setCreateAccount(user.getAccount());
        activityType.setTypeName(typeName);
        activityType.setState(state);
        tbActivityTypeMapper.insertSelective(activityType);

        // 使用map封装,有多个模板时进行批量插入
        insertActivityTypeFile(templateList, typeId, user,type);

    }

    @ServiceLog(doAction = "查询活动类型列表")
    @Override
    public PageInfo findActivityTypeListByState(String state, String page, String rows) {
        int pageNumber = 0;
        int pageSize = 15;
        if (StringUtils.isNotBlank(page)) {
            pageNumber = Integer.parseInt(page);
        }
        if (StringUtils.isNotBlank(rows)) {
            pageSize = Integer.parseInt(rows);
        }
        PageHelper.startPage(pageNumber, pageSize, true);
        List<ActivityType> activityTypeList = activityTypeMapper.findActivityTypeListByState(state);
        return new PageInfo<ActivityType>(activityTypeList);
    }

    @ServiceLog(doAction = "根据活动类型ID,获取活动类型内容")
    @Override
    public ActivityType findActivityTypeById(String typeId) {
        ActivityType activityType = activityTypeMapper.findActivityTypeById(typeId);
        return activityType;
    }

    @ServiceLog(doAction = "更新活动类型内容")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateActivityType(String typeId, String typeName, String state, List<String> templateList, User user) {
        //更新类型内容
        String type= "update";
        TbActivityType activityType = new TbActivityType();
        activityType.setTypeId(typeId);
        activityType.setUpdateTime(new Date());
        activityType.setUpdateAccount(user.getAccount());
        activityType.setTypeName(typeName);
        activityType.setState(state);
        tbActivityTypeMapper.updateByPrimaryKeySelective(activityType);
        //删除原先的模板
        TbActivityFileCriteria criteria = new TbActivityFileCriteria();
        criteria.createCriteria().andTypeIdEqualTo(typeId);
        tbActivityFileMapper.deleteByExample(criteria);
        //插入更新模板内容
        insertActivityTypeFile(templateList, typeId, user,type);
    }

    @ServiceLog(doAction = "删除活动类型")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteActivityTypeList(List<String> typeId) {
        TbActivityCriteria criteria = new TbActivityCriteria();
        criteria.createCriteria().andActiTypeIn(typeId);
        List<TbActivity> activities = tbActivityMapper.selectByExample(criteria);
        if (activities.size() > 0) {
            for (TbActivity activity: activities) {
                String actiType= activity.getActiType();
                ActivityType vo=   findActivityTypeById(actiType);
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_TYPE_ALREADY_ASSOCIATED, "活动类型"+vo.getTypeName()+"已关联活动,不能删除");
            }
        }
        activityTypeMapper.deleteActivityTypeList(typeId);

    }

    private void insertActivityTypeFile(List<String> templateList, String typeId, User user,String type) {
        if (templateList != null && templateList.size() > 0) {
            List<TbActivityFile> activityFileList = new ArrayList<>();
            for (String tempUrl : templateList) {
                TbActivityFile activityFile = new TbActivityFile();
                if("insert".equals(type)){
                activityFile.setCreateTime(new Date());
                }
                if("update".equals(type)){
                    activityFile.setUpdateTime(new Date());
                }
                activityFile.setTypeId(typeId);
                activityFile.setState("1");
                activityFile.setUpdateAccount(user.getAccount());
                activityFile.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                activityFile.setFileSrc(tempUrl);
                activityFileList.add(activityFile);
            }
            Map<String, Object> map = new HashMap<String, Object>(5);
            map.put("list", activityFileList);
            activityFileMapper.insertActivityTypeTemp(map);
        }
    }
}
