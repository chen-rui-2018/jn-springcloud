package com.jn.park.activity.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.park.activity.dao.*;
import com.jn.park.activity.entity.*;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.park.activity.model.ActivityType;
import com.jn.park.activity.service.ActivityTypeService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityTypeServiceImpl.class);

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
    public void insertActivityType(String typeName, String state,String templateList, User user) {
        String type = "insert";
        List<String> list= new ArrayList<>();
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
        if(StringUtils.isNotBlank(templateList)){
            list=Arrays.asList(templateList.split(","));
        }
        insertActivityTypeFile(list, typeId, user,type);

    }

    @ServiceLog(doAction = "查询活动类型列表")
    @Override
    public PaginationData findActivityTypeListByState(String state,com.jn.common.model.Page page) {
        int pageNumber = page.getPage();
        int pageSize = page.getRows()==0?15:page.getRows();
        Page<Object> pages= PageHelper.startPage(pageNumber, pageSize, true);
        List<ActivityType> activityTypeList = activityTypeMapper.findActivityTypeListByState(state);
        return new PaginationData(activityTypeList,pages.getTotal());
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
    public void updateActivityType(String typeId, String typeName, String state, String templateList, User user) {
        //更新类型内容
        String type= "update";
        String invalid="-1";
        List<String> list= new ArrayList<>();
        TbActivityType activityType = new TbActivityType();
        activityType.setTypeId(typeId);
        activityType.setUpdateTime(new Date());
        activityType.setUpdateAccount(user.getAccount());
        activityType.setTypeName(typeName);
        activityType.setState(state);
        TbActivityCriteria criteria = new TbActivityCriteria();
        criteria.createCriteria().andActiTypeEqualTo(typeId);
        List<TbActivity> activities = tbActivityMapper.selectByExample(criteria);
        if(activities.size()>0 && state.equals(invalid)){
            logger.warn("[活动类型删除]，活动类型{}已关联活动：typeId: {},不能修改为失效",activityType.getTypeName(),typeId);
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_TYPE_ALREADY_ASSOCIATED, "活动类型"+activityType.getTypeName()+"已关联活动,不能修改为失效");
        }
        tbActivityTypeMapper.updateByPrimaryKeySelective(activityType);
        //删除原先的模板
        TbActivityFileCriteria criteriaFile = new TbActivityFileCriteria();
        criteriaFile.createCriteria().andTypeIdEqualTo(typeId);
        tbActivityFileMapper.deleteByExample(criteriaFile);
        //插入更新模板内容
        if(StringUtils.isNotBlank(templateList)){
            list=Arrays.asList(templateList.split(","));
        }
        insertActivityTypeFile(list, typeId, user,type);
    }

    @ServiceLog(doAction = "删除活动类型")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteActivityTypeList(String typeId) {
        List<String> list= new ArrayList<>();
        if(StringUtils.isNotBlank(typeId)){
            list = Arrays.asList(typeId.split(","));
        }
        TbActivityCriteria criteria = new TbActivityCriteria();
        criteria.createCriteria().andActiTypeIn(list);
        List<TbActivity> activities = tbActivityMapper.selectByExample(criteria);
        if (activities.size() > 0) {
            for (TbActivity activity: activities) {
                String actiType= activity.getActiType();
                ActivityType vo=   findActivityTypeById(actiType);
                logger.warn("[活动类型删除]，活动类型{}已关联活动：typeId: {},不能进行删除",vo.getTypeName(),typeId);
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_TYPE_ALREADY_ASSOCIATED, "活动类型"+vo.getTypeName()+"已关联活动,不能删除");
            }
        }
        activityTypeMapper.deleteActivityTypeList(list);
    }

    /**
     * 批量插入活动类型模板
     * @param templateList
     * @param typeId
     * @param user
     * @param type
     */
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

    @ServiceLog(doAction = "返回所有有效活动类型")
    @Override
    public List<ActivityType> findAllActivityType() {
        //返回所有有效的活动类型
        String state = "1";
        List<ActivityType> activityTypeList = activityTypeMapper.findActivityTypeListByState(state);
        return activityTypeList;
    }

}
