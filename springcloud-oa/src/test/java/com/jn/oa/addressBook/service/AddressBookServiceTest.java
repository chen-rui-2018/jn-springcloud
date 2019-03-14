package com.jn.oa.addressBook.service;

import com.jn.common.model.Result;
import com.jn.system.model.User;
import com.jn.system.model.UserPage;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 通讯录管理Junit测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressBookServiceTest {

    @Autowired
    private AddressBookService addressBookService;

    private static String userAccount;

    @BeforeClass
    private void init() {
        userAccount = "wangsong";
    }

    @Test
    public void getUserInfo() {
        Result<User> userInfo = addressBookService.getUserInfo(userAccount);
        Assert.assertThat(userInfo, Matchers.anything());
    }

    @Test
    public void list() {
        UserPage page = new UserPage();
        page.setPage(1);
        page.setRows(10);
        Result list = addressBookService.list(page);
        Assert.assertThat(list, Matchers.anything());
    }

    @Test
    public void getDeptTree() {
        Result deptTree = addressBookService.getDeptTree();
        Assert.assertThat(deptTree, Matchers.anything());
    }
}