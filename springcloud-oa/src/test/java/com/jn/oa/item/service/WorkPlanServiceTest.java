package com.jn.oa.item.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.file.MultipartFileUtil;
import com.jn.oa.item.enmus.WorkPlanStatusEnums;
import com.jn.oa.item.model.*;
import com.jn.oa.item.vo.WorkPlanVO;
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
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * 工作计划单元测试
 *
 * @author： shaobao
 * @date： Created on 2019/2/17 17:03
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WorkPlanServiceTest {

    @Autowired
    private WorkPlanService workPlanService;

    @Autowired
    private ResourceLoader resourceLoader;

    private static User user;

    private static WorkPlanAdd workPlanAdd;

    private static String workPlanId;

    @BeforeClass
    public static void init() {
        //初始化添加用户
        user = new User();
        user.setAccount("wangsong");

        workPlanAdd = new WorkPlanAdd();
        workPlanId = UUID.randomUUID().toString();
        workPlanAdd.setId(workPlanId);
        workPlanAdd.setAttachment("[{\"title\":\"附件\",\"url\":\"https://www.baidu.com\"}]");
        workPlanAdd.setContent("工作计划内容测试");
        workPlanAdd.setDemandDescribe("工作计划描述测试");
        workPlanAdd.setItemId("10000");
        workPlanAdd.setPlanEndTime(new Date(System.currentTimeMillis() + 1000L));
        workPlanAdd.setPlanStartTime(new Date());
        workPlanAdd.setPlanTime(10);
        workPlanAdd.setResponsibleUserAccount("wangsong,liuxiong");
        workPlanAdd.setWorkPlanName("工作计划");
    }

    @Test
    public void t001_add() {
        try {
            workPlanService.add(workPlanAdd, user);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void t002_list() {
        WorkPlanPage workPlanPage = new WorkPlanPage();
        workPlanPage.setPage(1);
        workPlanPage.setRows(10);
        workPlanPage.setUserAccount("wangsong");
        workPlanPage.setItemId("10000");
        workPlanPage.setWorkPlanName("工作计划");
        workPlanPage.setWorkPlanStatus(WorkPlanStatusEnums.DOING.getCode());
        PaginationData list = workPlanService.list(workPlanPage);
        Assert.assertThat(list, Matchers.anything());

    }

    @Test
    public void t003_addRemark() {
        WorkPlanAddRemark workPlanAddRemark = new WorkPlanAddRemark();
        workPlanAddRemark.setId(workPlanId);
        workPlanAddRemark.setRemark("添加备注,备注测试");
        workPlanService.addRemark(workPlanAddRemark, user);
    }

    @Test
    public void t004_getWorkPlanById() {
        WorkPlanVO workPlanVO = workPlanService.getWorkPlanById(workPlanId);
        Assert.assertThat(workPlanVO, Matchers.notNullValue());
    }

    /**
     * 工作计划更新状态测试
     * 1.改为进行中状态
     * 2.改为已挂起状态
     * 3.改为以完成状态
     */
    @Test
    public void t005_updateWorkPlanStatus() {
        //1.修改为进行中
        WorkPlanUpdateStatus workPlanUpdateStatus = new WorkPlanUpdateStatus();
        workPlanUpdateStatus.setId(workPlanId);
        workPlanUpdateStatus.setTotalConsumeTime(10);
        workPlanUpdateStatus.setTotalRemainTime(10);
        workPlanUpdateStatus.setWorkPlanStatus(WorkPlanStatusEnums.DOING.getCode());
        workPlanUpdateStatus.setStartTime(new Date());
        workPlanUpdateStatus.setRemark("修改状态,备注测试1");
        workPlanService.updateWorkPlanStatus(workPlanUpdateStatus, user);

        //2.修改为已挂起
        WorkPlanUpdateStatus workPlanUpdateStatus1 = new WorkPlanUpdateStatus();
        workPlanUpdateStatus1.setId(workPlanId);
        workPlanUpdateStatus1.setWorkPlanStatus(WorkPlanStatusEnums.PAUSED.getCode());
        workPlanUpdateStatus1.setRemark("修改状态,备注测试3");
        workPlanService.updateWorkPlanStatus(workPlanUpdateStatus1, user);

        //3.修改为重新开始
        WorkPlanUpdateStatus workPlanUpdateStatus2 = new WorkPlanUpdateStatus();
        workPlanUpdateStatus2.setId(workPlanId);
        workPlanUpdateStatus2.setTotalConsumeTime(20);
        workPlanUpdateStatus2.setTotalRemainTime(20);
        workPlanUpdateStatus2.setWorkPlanStatus(WorkPlanStatusEnums.RESTART.getCode());
        workPlanUpdateStatus2.setRemark("修改状态,备注测试3");
        workPlanService.updateWorkPlanStatus(workPlanUpdateStatus2, user);

        //3.修改为已完成
        WorkPlanUpdateStatus workPlanUpdateStatus3 = new WorkPlanUpdateStatus();
        workPlanUpdateStatus3.setId(workPlanId);
        workPlanUpdateStatus3.setTotalConsumeTime(10);
        workPlanUpdateStatus3.setWorkPlanStatus(WorkPlanStatusEnums.COMPLETED.getCode());
        workPlanUpdateStatus3.setEndTime(new Date());
        workPlanUpdateStatus3.setRemark("修改状态,备注测试4");
        workPlanUpdateStatus3.setAttachment("[{\"title\":\"附件1\",\"url\":\"https://www.baidu.com\"}]");
        workPlanService.updateWorkPlanStatus(workPlanUpdateStatus3, user);
    }

    @Test
    public void t006_update() {
        try {
            WorkPlanEdit workPlanEdit = new WorkPlanEdit();
            workPlanEdit.setId(workPlanId);
            workPlanEdit.setAttachment("[{\"title\":\"附件2\",\"url\":\"https://www.baidu.com\"}]");
            workPlanEdit.setContent("修改内容");
            workPlanEdit.setDemandDescribe("修改需求");
            workPlanEdit.setEndTime(new Date());
            workPlanEdit.setPlanEndTime(new Date());
            workPlanEdit.setPlanStartTime(new Date(System.currentTimeMillis() - 1000L));
            workPlanEdit.setPlanTime(30);
            workPlanEdit.setRemark("修改备注");
            workPlanEdit.setResponsibleUserAccount("wangsong");
            workPlanEdit.setTotalConsumeTime(25);
            workPlanEdit.setWorkPlanName("修改工作计划名称");
            workPlanEdit.setWorkPlanStatus(WorkPlanStatusEnums.DOING.getCode());
            workPlanEdit.setTotalRemainTime(5);
            workPlanEdit.setItemId("10000");
            workPlanService.update(workPlanEdit, user);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }



    @Test
    public void t007_workPlanRemindEveryDay() {
        Boolean result = workPlanService.workPlanRemindEveryDay();
        Assert.assertThat(result, Matchers.is(Boolean.TRUE));
    }

    @Test
    public void t008_updateWorkPlanIsExpire() {
        workPlanService.updateWorkPlanIsExpire();
    }

    @Test
    public void t009_importExcelWorkPlanInfo() {

        try {
            Resource resource = resourceLoader.getResource("classpath:zxing/workplanExcle.xlsx");
            File file = resource.getFile();
            MultipartFile multipartFile = MultipartFileUtil.from(file, null);
            workPlanService.importExcelWorkPlanInfo(multipartFile,user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t010_delete() {
        workPlanService.delete(workPlanId,user);
    }
}