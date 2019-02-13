package com.jn.oa.common.service;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CommServiceTest {

    @Autowired
    private CommService commService;

    @Test
    public void getOrderNum() {
        String orderNum = commService.getOrderNum();
        Assert.assertThat(orderNum, Matchers.notNullValue());
    }
}