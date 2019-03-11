package com.jn.system.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.system.common.enums.SysLevelEnums;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.dept.entity.TbSysDepartment;
import com.jn.system.dept.model.SysDepartment;
import com.jn.system.dept.model.SysDepartmentCheckName;
import com.jn.system.dept.service.SysDepartmentService;
import com.jn.system.dept.vo.SysDepartmentVO;
import com.jn.system.model.User;
import org.apache.commons.lang.RandomStringUtils;
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

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SysDepartmentServiceTest {

    @Autowired
    public SysDepartmentService sysDepartmentService;

    //部门id
    private static String departmenId;
    //部门名称
    private static String departmentName;
    //创建者
    private static User user;
    //部门对象
    private static TbSysDepartment tbSysDepartment;

    @BeforeClass
    public static void init() {
        //初始化添加用户
        user = new User();
        user.setAccount("10000");

        //初始化部门部门id及部门名称
        departmenId = UUID.randomUUID().toString();
        departmentName = "测试部门" + RandomStringUtils.randomNumeric(4);

        //初始化部门对象
        tbSysDepartment = new TbSysDepartment();
        tbSysDepartment.setId(departmenId);
        tbSysDepartment.setDepartmentName(departmentName);
        tbSysDepartment.setParentId(SysLevelEnums.FIRST_LEVEL.getCode());
        tbSysDepartment.setCreatorAccount(user.getAccount());
        tbSysDepartment.setCreatedTime(new Date());
        Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
        tbSysDepartment.setRecordStatus(recordStatus);
    }

    @Test
    public void add() {
        try {
            sysDepartmentService.add(tbSysDepartment);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void selectByPrimaryKeyTest() {
        Result data = sysDepartmentService.selectDeptByKey(departmenId, false);
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void updateTest() {
        SysDepartment SysDepartment = new SysDepartment();
        SysDepartment.setId(departmenId);
        Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
        SysDepartment.setRecordStatus(recordStatus);
        SysDepartment.setDepartmentName(departmentName);
        SysDepartment.setParentId(SysLevelEnums.FIRST_LEVEL.getCode());
        try {
            sysDepartmentService.update(SysDepartment, user);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }


    @Test
    public void checkDepartmentName() {
        SysDepartmentCheckName department = new SysDepartmentCheckName();
        department.setDepartmentName(departmentName);
        department.setParentId(SysLevelEnums.FIRST_LEVEL.getCode());
        String result = sysDepartmentService.checkDepartmentName(department);
        Assert.assertThat(result, Matchers.anyOf(Matchers.equalTo(SysReturnMessageEnum.FAIL.getMessage()),
                Matchers.equalTo(SysReturnMessageEnum.SUCCESS.getMessage())));
    }

    @Test
    public void findDepartmentAllByLevel() {
        List<SysDepartmentVO> data = sysDepartmentService.findDepartmentAllByLevel();
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void updateDepartmentBatch() {
        List<SysDepartment> list = new ArrayList<SysDepartment>();
        SysDepartment department = new SysDepartment();
        department.setId(departmenId);
        department.setDepartmentName(departmentName);
        department.setParentId(SysLevelEnums.FIRST_LEVEL.getCode());
        list.add(department);
        try {
            sysDepartmentService.addDepartmentBatch(list, user);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void getChildDepartmentByParentId() {
        String parentId = SysLevelEnums.FIRST_LEVEL.getCode();
        List<SysDepartmentVO> data = sysDepartmentService.getChildDepartmentByParentId(parentId);
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void checkUserDept(){
        //1.判断用户id不为空情况,部门id不为空情况
        String userId = "10000";
        Boolean result2 = sysDepartmentService.checkUserDept(userId, departmenId);
        Assert.assertThat(result2, Matchers.anything());
    }

    @Test
    public void zDeleteTest() {
        sysDepartmentService.delete(departmenId, user);
    }
}
