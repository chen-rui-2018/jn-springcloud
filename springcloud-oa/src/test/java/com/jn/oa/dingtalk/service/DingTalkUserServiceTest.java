package com.jn.oa.dingtalk.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.enums.EnumUtil;
import com.jn.oa.dingTalk.service.DingTalkUserService;
import com.jn.oa.enums.AddressBookEventTypeEnum;
import com.jn.oa.model.AddressBookNotice;
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

/**
 * 钉钉用户service单元测试
 *
 * @author： yuanyy
 * @date： Created on 2019/2/17 17:03
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DingTalkUserServiceTest {

    @Autowired
    public DingTalkUserService dingTalkUserService;

    private static AddressBookNotice addressBookNotice;



    @BeforeClass
    public static void init() {
        addressBookNotice=new AddressBookNotice();
        List<String> userIds=new ArrayList<>();
        userIds.add("181632132826086887");
        addressBookNotice.setUserId(userIds);
        addressBookNotice.setEventType(EnumUtil.getByCode(AddressBookEventTypeEnum.USER_MODIFY_ORG.getCode(),AddressBookEventTypeEnum.class));

    }

    /**
     * 批量插入数据
     */
    @Test
    public void batchInsertDingTalkUser() {
        try {
            dingTalkUserService.batchInsertDingTalkUser();
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    /**
     * 批量插入数据
     */
    @Test
    public void updateOrInsertDingTalkUser() {
        try {
            dingTalkUserService.updateOrInsertDingTalkUser(addressBookNotice);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }







}
