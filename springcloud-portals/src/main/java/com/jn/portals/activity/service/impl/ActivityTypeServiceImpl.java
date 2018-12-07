package com.jn.portals.activity.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.StringUtils;
import com.jn.portals.activity.dao.ActivityFileMapper;
import com.jn.portals.activity.dao.ActivityTypeMapper;
import com.jn.portals.activity.dao.TbActivityTypeMapper;
import com.jn.portals.activity.entity.TbActivityFile;
import com.jn.portals.activity.entity.TbActivityType;
import com.jn.portals.activity.entity.TbActivityTypeCriteria;
import com.jn.portals.activity.enums.ActivityExceptionEnum;
import com.jn.portals.activity.service.ActivityTypeService;
import com.jn.portals.activity.vo.ActivityTypeVO;
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
    public void insertActivityType(String typeName, String state, List<String> templateList, User user ) {
        if (StringUtils.isBlank(typeName)) {
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_TYPE_NAME_EMPTY, "活动类型名称不能为空");
        }
        if (StringUtils.isBlank(state)) {
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_TYPE_NAME_EMPTY, "活动类型名称不能为空");
        }
        TbActivityTypeCriteria criteria = new TbActivityTypeCriteria();
        criteria.createCriteria().andTypeNameEqualTo(typeName);
        List<TbActivityType> activityTypesList = tbActivityTypeMapper.selectByExample(criteria);
        if(activityTypesList.size()>0){
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_TYPE_NAME_REPEAT, "活动类型名称不能重复");
        }
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
        if (templateList.size() > 0) {
            List<TbActivityFile> activityFileList = new ArrayList<>();
            for (String tempUrl : templateList) {
                TbActivityFile activityFile = new TbActivityFile();
                activityFile.setCreateTime(new Date());
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

    @ServiceLog(doAction = "查询活动类型列表")
    @Override
    public PageInfo findActivityTypeListByState(String state,String page,String rows) {
        int pageNumber = 0;
        int pageSize = 15;
       if(StringUtils.isNotBlank(page)){
           pageNumber = Integer.parseInt(page);
       }
       if(StringUtils.isNotBlank(rows)){
           pageSize = Integer.parseInt(rows);
       }
        PageHelper.startPage(pageNumber,pageSize,true);
        List<ActivityTypeVO> activityTypeList =  activityTypeMapper.findActivityTypeListByState(state);
        return new PageInfo<ActivityTypeVO>(activityTypeList);
    }
}
