package com.jn.oa.item.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.oa.item.entity.TbOaWorkPlanRecord;
import com.jn.oa.item.model.WorkPlanRecord;
import com.jn.system.model.User;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 工作计划工作记录单元测试
 *
 * @author： shaobao
 * @date： Created on 2019/2/17 17:03
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WorkPlanRecordServiceTest {

    @Autowired
    private WorkPlanRecordService workPlanRecordService;

    private static User user;

    private static WorkPlanRecord workPlanRecord;

    private static String workPlanRecordId;

    @BeforeClass
    public static void init() {
        //初始化添加用户
        user = new User();
        user.setAccount("wangsong");

        workPlanRecordId = UUID.randomUUID().toString();
        workPlanRecord = new WorkPlanRecord();
        workPlanRecord.setId(workPlanRecordId);
        workPlanRecord.setWorkPlanId("10000");
        workPlanRecord.setSort(1);
        workPlanRecord.setCreatorAccount(user.getAccount());
        workPlanRecord.setConsumeTime(10);
        workPlanRecord.setRemainTime(10);
        workPlanRecord.setRemark("备注测试");
        workPlanRecord.setRecordDate(new Date());
    }

    @Test
    public void addBatch() {
        List<WorkPlanRecord> workPlanRecords = new ArrayList<WorkPlanRecord>();
        workPlanRecords.add(workPlanRecord);
        workPlanRecordService.addBatch(workPlanRecords, user);
    }

    @Test
    public void update() {
        try {
            workPlanRecord.setRemainTime(20);
            workPlanRecord.setConsumeTime(20);
            workPlanRecord.setRemark("修改备注测试");
            workPlanRecordService.update(workPlanRecord, user);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void zDelete() {
        workPlanRecordService.delete(workPlanRecordId,user);
    }

    @Test
    public void list() {
        List<TbOaWorkPlanRecord> list = workPlanRecordService.list("10000");
        Assert.assertThat(list, Matchers.anything());
    }
}