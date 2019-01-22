package com.jn.park.activity.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.park.activity.dao.*;
import com.jn.park.activity.entity.*;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.park.model.ActivityType;
import com.jn.park.activity.service.ActivityTypeService;
import com.jn.park.model.ActivityTypeAdd;
import com.jn.park.model.ActivityTypeQuery;
import com.jn.park.model.ActivityTypeUpdate;
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


    @ServiceLog(doAction = "新增活动类型")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String insertActivityType(ActivityTypeAdd activityTypeAdd, User user) {
        String typeName = activityTypeAdd.getTypeName();
        String status = activityTypeAdd.getStatus();
        String templateList = activityTypeAdd.getTemplateList();
        List<String> list= new ArrayList<>();
        TbActivityTypeCriteria criteria= new TbActivityTypeCriteria();
        criteria.createCriteria().andTypeNameEqualTo(typeName);
        List<TbActivityType> activityTypeList =  tbActivityTypeMapper.selectByExample(criteria);
        if(activityTypeList != null){
            if(activityTypeList.size()>0){
                logger.warn("[活动类型添加]，活动类型{}已关存在：typeName: {},不能重复添加",typeName,activityTypeList.get(0).getTypeName());
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_TYPE_NAME_REPEAT, "活动类型"+typeName+"已存在,不能重复添加");
            }
        }
        // 插入活动类型基本信息
        Byte recordStatus = 1;
        TbActivityType activityType = new TbActivityType();
        String typeId = UUID.randomUUID().toString().replaceAll("-", "");
        activityType.setTypeId(typeId);
        activityType.setCreatedTime(new Date());
        activityType.setCreatorAccount(user.getAccount());
        activityType.setTypeName(typeName);
        activityType.setTypeStatus(status);
        activityType.setRecordStatus(recordStatus);
        tbActivityTypeMapper.insertSelective(activityType);

        // 使用map封装,有多个模板时进行批量插入
        if(StringUtils.isNotBlank(templateList)){
            list=Arrays.asList(templateList.split(","));
        }
        insertActivityTypeFile(list, typeId, user.getAccount());
        return typeId;

    }

    @ServiceLog(doAction = "查询活动类型列表")
    @Override
    public PaginationData findActivityTypeListByState(ActivityTypeQuery activityTypeQuery, boolean isPage) {
        String valid = "1";
        Page<Object> objects=null;
        if(isPage) {
            int pageSize = activityTypeQuery.getRows() == 0 ? 15 : activityTypeQuery.getRows();
            int pageNumber= activityTypeQuery.getPage();
            objects  = PageHelper.startPage(pageNumber, pageSize, true);
        }
        //不分页,则表示前端获取列表作为活动的查询条件或添加时的活动类型,只返回有效的活动类型
        if(!isPage){
            activityTypeQuery.setStatus(valid);
        }
            String status = activityTypeQuery.getStatus();
            List<ActivityType> activityTypeList = activityTypeMapper.findActivityTypeListByState(status);
            return new PaginationData(activityTypeList,objects==null?0:objects.getTotal());
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
    public void updateActivityType(ActivityTypeUpdate activityTypeUpdate, User user) {
        //修改为无效
        String invalid="0";
        String typeId = activityTypeUpdate.getTypeId();
        String  typeName = activityTypeUpdate.getTypeName();
        String status = activityTypeUpdate.getStatus();
        String templateList = activityTypeUpdate.getTemplateList();
        List<String> list= new ArrayList<>();
        TbActivityType activityType = new TbActivityType();
        activityType.setTypeId(typeId);
        activityType.setModifiedTime(new Date());
        activityType.setModifierAccount(user.getAccount());
        activityType.setTypeName(typeName);
        activityType.setTypeStatus(status);
        TbActivityCriteria criteria = new TbActivityCriteria();
        criteria.createCriteria().andActiTypeEqualTo(typeId);
        List<TbActivity> activities = tbActivityMapper.selectByExample(criteria);
        if(activities.size()>0 && status.equals(invalid)){
            logger.warn("[活动类型编辑]，活动类型{}已关联活动：typeId: {},不能修改为失效",activityType.getTypeName(),typeId);
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_TYPE_ALREADY_ASSOCIATED, "活动类型'"+activityType.getTypeName()+"'已关联活动,不能修改为失效");
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
        insertActivityTypeFile(list, typeId, user.getAccount());
    }

    @ServiceLog(doAction = "删除活动类型")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteActivityTypeList(String typeId) {
        if(StringUtils.isEmpty(typeId)){
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY);
        }
        List<String> list = Arrays.asList(typeId.split(","));
        TbActivityCriteria criteria = new TbActivityCriteria();
        criteria.createCriteria().andActiTypeIn(list);
        List<TbActivity> activities = tbActivityMapper.selectByExample(criteria);
        if (activities.size() > 0) {
            for (TbActivity activity: activities) {
                String actiType= activity.getActiType();
                ActivityType vo=   findActivityTypeById(actiType);
                logger.warn("[活动类型删除]，活动类型{}已关联活动：typeId: {},不能进行删除",vo.getTypeName(),vo.getTypeId());
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_TYPE_ALREADY_ASSOCIATED, "活动类型'"+vo.getTypeName()+"'已关联活动,不能删除");
            }
        }
        activityTypeMapper.deleteActivityTypeList(list);
        activityFileMapper.deleteActivityTypeTemp(list);
    }

    /**
     * 批量插入活动类型模板
     * @param templateList
     * @param typeId
     * @param account
     */
    private void insertActivityTypeFile(List<String> templateList, String typeId, String account) {
        if (templateList != null && templateList.size() > 0) {
            List<TbActivityFile> activityFileList = new ArrayList<>();
            Byte recordStatus = 1;
            for (String tempUrl : templateList) {
                TbActivityFile activityFile = new TbActivityFile();
                activityFile.setCreatedTime(new Date());
                activityFile.setCreatorAccount(account);
                activityFile.setTypeId(typeId);
                activityFile.setFileStatus("1");
                activityFile.setRecordStatus(recordStatus);
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
