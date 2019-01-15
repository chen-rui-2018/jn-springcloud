package com.jn.park.activity.service.impl;

import com.jn.SpringCloudParkApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.park.activity.dao.TbActivityFileMapper;
import com.jn.park.activity.dao.TbActivityTypeMapper;
import com.jn.park.activity.entity.TbActivityFileCriteria;
import com.jn.park.activity.entity.TbActivityType;
import com.jn.park.activity.entity.TbActivityTypeCriteria;
import com.jn.park.activity.service.ActivityTypeService;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.park.model.ActivityType;
import com.jn.park.model.ActivityTypeAdd;
import com.jn.park.model.ActivityTypeQuery;
import com.jn.park.model.ActivityTypeUpdate;
import com.jn.system.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

/**
 * @author： chenr
 * @date： Created on 2018/12/20 10:42
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringCloudParkApplication.class})
public class ActivityTypeServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(ActivityTypeServiceImplTest.class);

    @Autowired
    private ActivityTypeService activityTypeService;

    @Autowired
    private TbActivityTypeMapper typeMapper;
    @Autowired
    private TbActivityFileMapper fileMapper;


    private String typeId;
    private String templateList;
    private String status;
    private String typeName;
    private Integer page;
    private Integer rows;
    private User user;
    private String typeIds;
    private ActivityTypeAdd activityTypeAdd;
    private ActivityTypeUpdate activityTypeUpdate;
    private ActivityTypeQuery activityTypeQuery;

    @Before
    public void setUp() throws Exception {

        typeId = "aeaa1a3bbd0141cb93e7a5dbd12973dd";
        typeName = "junit活动类型测试";

        status = "1";
        templateList = "http://192.168.10.20:2020/group2/M00/00/1F/wKgKFFwbRa6AJ_ucAAFG1sygtYE708.jpg," +
                "http://192.168.10.20:2020/group2/M00/00/1F/wKgKFFwbR0CAbcVwAACTbiUHV4g697.jpg," +
                "http://192.168.10.20:2020/group2/M00/00/1F/wKgKFFwbR2iAIJ7HAACAPkYqwSw461.jpg";
        user = new User();
        user.setAccount("wangsong");
        typeIds = "f0396c4fd4d1462b8a4142f395d1e914,aeaa1a3bbd0141cb93e7a5dbd12973dd";
        page = 1;
        rows = 15;
        TbActivityTypeCriteria criteria = new TbActivityTypeCriteria();
        criteria.createCriteria().andTypeNameEqualTo(typeName);
        List<TbActivityType>  activityTypes = typeMapper.selectByExample(criteria);
        if(activityTypes!= null && activityTypes.size()>0){
            typeId = activityTypes.get(0).getTypeId();
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * 添加活动类型
     */
    @Test
    public void insertActivityType() {
        activityTypeAdd = new ActivityTypeAdd();
        activityTypeAdd.setStatus(status);
        activityTypeAdd.setTypeName(typeName);
        activityTypeAdd.setTemplateList(templateList);
        //活动名称重复
        try {
            typeId = activityTypeService.insertActivityType(activityTypeAdd, user);
        } catch (JnSpringCloudException e) {
            logger.info("info>>>>>>>>>>>code:" + e.getCode() + "- - - -message:" + e.getMsg());
            assertThat(e.getCode(), equalTo(ActivityExceptionEnum.ACTIVITY_TYPE_NAME_REPEAT.getCode()));
        }
    }

    /**
     * 查询活动类型列表
     */
    @Test
    public void findActivityTypeListByState() {
        activityTypeQuery = new ActivityTypeQuery();
        activityTypeQuery.setStatus(status);
        activityTypeQuery.setPage(page);
        activityTypeQuery.setRows(rows);
        PaginationData data = activityTypeService.findActivityTypeListByState(activityTypeQuery, true);
        int length = (int) data.getTotal();
        assertThat(length, greaterThanOrEqualTo(0));
    }

    /**
     * 查看具体的活动类型信息
     */
    @Test
    public void findActivityTypeById() {
        ActivityType activityType = activityTypeService.findActivityTypeById(typeId);
        assertThat(activityType.getTypeId(), notNullValue());
    }

    /**
     * 更新活动类型
     */
    @Test
    public void updateActivityType() {
        activityTypeUpdate = new ActivityTypeUpdate();
        activityTypeUpdate.setTypeId(typeId);
        activityTypeUpdate.setStatus(status);
        activityTypeUpdate.setTemplateList(templateList);
        activityTypeUpdate.setTypeName(typeName);
        try {
            activityTypeService.updateActivityType(activityTypeUpdate, user);
        } catch (JnSpringCloudException e) {
            logger.info("info>>>>>>>>>>>code:" + e.getCode() + "- - - -message:" + e.getMsg());
            assertThat(e.getCode(), equalTo(ActivityExceptionEnum.ACTIVITY_TYPE_ALREADY_ASSOCIATED.getCode()));
        }

    }

    /**
     * 删除活动类型,逻辑删除;
     * 可进行批量删除
     */
    @Test
    public void deleteActivityTypeList() {
        try {
            typeIds = typeIds + ",956dc8ab83f84c0cbb6b6cea2547f449";
            activityTypeService.deleteActivityTypeList(typeIds);
        } catch (JnSpringCloudException e) {
            logger.info("info>>>>>>>>>>>code:" + e.getCode() + "- - - -message:" + e.getMsg());
            assertThat(e.getCode(), equalTo(ActivityExceptionEnum.ACTIVITY_TYPE_ALREADY_ASSOCIATED.getCode()));
        }

    }

    /**
     * 物理删除添加的测试数据
     */
    @Test
    public void deleteActivity(){
        try {
            //根据id删除添加的测试数据
            typeMapper.deleteByPrimaryKey(typeId);
            TbActivityFileCriteria criteria = new TbActivityFileCriteria();
            criteria.createCriteria().andTypeIdEqualTo(typeId);
            fileMapper.deleteByExample(criteria);
        } catch (JnSpringCloudException e) {
            logger.info("info>>>>>>>>>>>code:" + e.getCode() + "- - - -message:" + e.getMsg());
            assertThat(e.getCode(), equalTo(ActivityExceptionEnum.ACTIVITY_TYPE_ALREADY_ASSOCIATED.getCode()));
        }
    }


}