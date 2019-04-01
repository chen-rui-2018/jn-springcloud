package com.jn.park.notice.service.impl;

import com.jn.SpringCloudParkApplication;
import com.jn.park.notice.model.NoticeModifyParam;
import com.jn.park.notice.service.NoticeService;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.IsAnything.anything;
import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudParkApplication.class})
@FixMethodOrder(MethodSorters.JVM)
public class NoticeServiceImplTest {
    @Autowired
    private NoticeService noticeService;

    private NoticeModifyParam param ;
    private String noticeId;
    private String account;
    @Before
    public void setUp() throws Exception {
        account = "wangsong";
        param = new NoticeModifyParam();
        noticeId = "1063bdd13de64123abaecdd96b3269dc";
        param.setNoticeId(noticeId);
        param.setNoticeTitle("公告标题...圣旨");
        param.setStartTime("2019-04-01");
        param.setEndTime("2019-04-01");
        param.setPlatformType("1");
        param.setNoticeSerial("GGBH110112119");
        param.setSortField("1");
        param.setHomePopup("0");
        param.setHomeShow("0");
        param.setNoticeContent("公告内容...奉天承运,皇帝诏曰..........");

    }

    @Test
    public void addNotice() {
       int i =  noticeService.addNotice(param,account);
       assertThat(i,greaterThanOrEqualTo(1));
    }
}