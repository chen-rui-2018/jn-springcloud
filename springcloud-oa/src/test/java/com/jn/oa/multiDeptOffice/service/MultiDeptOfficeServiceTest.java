package com.jn.oa.multiDeptOffice.service;

import com.jn.oa.notice.service.NoticeService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiDeptOfficeServiceTest {

    @Autowired
    private MultiDeptOfficeService multiDeptOfficeService;

    @Test
    public void updateMultiDeptOfficeStatus() {
        multiDeptOfficeService.updateMultiDeptOfficeStatus();
    }

    @Test
    public void remind() {
        multiDeptOfficeService.remind();
    }
}