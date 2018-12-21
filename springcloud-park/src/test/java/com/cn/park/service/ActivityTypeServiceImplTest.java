package com.cn.park.service;

import com.jn.SpringCloudParkApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.park.activity.service.ActivityTypeService;
import com.jn.park.model.ActivityType;
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

import static org.hamcrest.CoreMatchers.anything;
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
@SpringBootTest(classes={SpringCloudParkApplication.class})
public class ActivityTypeServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(ActivityTypeServiceImplTest.class);

    @Autowired
    private ActivityTypeService activityTypeService;

     private String typeId;
     private String templateList;
     private String state;
     private String typeName;
     private Integer page;
     private Integer rows;
     private User user;
     private String typeIds;
    @Before
    public void setUp() throws Exception {
        typeId = "aeaa1a3bbd0141cb93e7a5dbd12973dd";
        typeName="圣诞活动";
        state = "1";
        templateList="http://192.168.10.20:2020/group2/M00/00/1F/wKgKFFwbRa6AJ_ucAAFG1sygtYE708.jpg," +
                "http://192.168.10.20:2020/group2/M00/00/1F/wKgKFFwbR0CAbcVwAACTbiUHV4g697.jpg," +
                "http://192.168.10.20:2020/group2/M00/00/1F/wKgKFFwbR2iAIJ7HAACAPkYqwSw461.jpg";
        page = 1;
        rows = 15;
        user = new User();
        user.setAccount("wangsong");
        typeIds="f0396c4fd4d1462b8a4142f395d1e914,aeaa1a3bbd0141cb93e7a5dbd12973dd";
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * 添加活动类型
     */
    @Test
    public void insertActivityType() {
        //活动名称重复
        try {
            activityTypeService.insertActivityType(typeName, state, templateList, user);
        }catch (JnSpringCloudException e){
            logger.info("info>>>>>>>>>>>code:"+e.getCode()+"- - - -message:"+e.getMsg());
            assertThat(e.getCode(),equalTo("1111201"));
        }
    }

    /**
     * 查询活动类型列表
     */
    @Test
    public void findActivityTypeListByState() {
        PaginationData data =  activityTypeService.findActivityTypeListByState(state,page,rows,true);
        int length =(int) data.getTotal();
        assertThat(length,greaterThanOrEqualTo(0));
    }

    /**
     * 查看具体的活动类型信息
     */
    @Test
    public void findActivityTypeById() {
        ActivityType activityType =  activityTypeService.findActivityTypeById(typeId);
        assertThat(activityType.getTypeId(),notNullValue());
    }

    /**
     * 更新活动类型
     */
    @Test
    public void updateActivityType() {
        try {
            typeId = "956dc8ab83f84c0cbb6b6cea2547f449";
            activityTypeService.updateActivityType(typeId, typeName, "0", templateList, user);
        }catch (JnSpringCloudException e){
            logger.info("info>>>>>>>>>>>code:"+e.getCode()+"- - - -message:"+e.getMsg());
            assertThat(e.getCode(),equalTo("11110202"));
        }

    }

    /**
     * 删除活动类型,可进行批量删除
     */
    @Test
    public void deleteActivityTypeList() {
        try {
            typeIds = typeIds+",956dc8ab83f84c0cbb6b6cea2547f449";
            activityTypeService.deleteActivityTypeList(typeIds);
        }catch (JnSpringCloudException e){
            logger.info("info>>>>>>>>>>>code:"+e.getCode()+"- - - -message:"+e.getMsg());
            assertThat(e.getCode(),equalTo("11110202"));
        }

    }
}