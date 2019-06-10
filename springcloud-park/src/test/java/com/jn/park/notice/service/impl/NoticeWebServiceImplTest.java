package com.jn.park.notice.service.impl;
/**
 * @author： chenr
 * @date： Created on 2019/04/3 09:18
 * @version： v1.0
 * @modified By:
 */
import com.jn.SpringCloudParkApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.enums.NoticeExceptionEnum;
import com.jn.park.notice.model.NoticeDetailShow;
import com.jn.park.notice.model.NoticeManageShow;
import com.jn.park.notice.service.NoticeWebService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.IsAnything.anything;
import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudParkApplication.class})
@FixMethodOrder(MethodSorters.JVM)
public class NoticeWebServiceImplTest {
    /**
     * 日志组件
     */
    private Logger logger = LoggerFactory.getLogger(NoticeServiceImplTest.class);
    @Autowired
    private NoticeWebService noticeWebService;
    private String noticeId;
    private Page page;
    @Before
    public void setUp() throws Exception {
        noticeId="1063bdd13de64123abaecdd96b3269dc";
        page = new Page();
        page.setPage(0);
        page.setRows(15);
    }

    @Test
    public void popupNoticeListForApp() {
        List<NoticeDetailShow>  noticeList = noticeWebService.popupNoticeListForApp();
        if(noticeList!=null) {
            assertThat((int) noticeList.size(), greaterThanOrEqualTo(0));
        }
        assertThat(anything(),anything());
    }

    @Test
    public void popupNoticeListForPortal() {
        List<NoticeDetailShow>  noticeList = noticeWebService.popupNoticeListForPortal();
        if(noticeList!=null) {
            assertThat((int) noticeList.size(), greaterThanOrEqualTo(0));
        }
        assertThat(anything(),anything());
    }

    @Test
    public void showNoticeListForPortal() {
        PaginationData<List<NoticeDetailShow>> noticeList = noticeWebService.showNoticeListForPortal(page);
        if(noticeList!=null) {
            assertThat((int) noticeList.getTotal(), greaterThanOrEqualTo(0));
        }
        assertThat(anything(),anything());
    }

    @Test
    public void showNoticeListForApp() {
        PaginationData<List<NoticeDetailShow>>  noticeList = noticeWebService.showNoticeListForApp(page);
        if(noticeList!=null) {
            assertThat((int) noticeList.getTotal(), greaterThanOrEqualTo(0));
        }
        assertThat(anything(),anything());
    }

    @Test
    public void noticeListApp() {
        PaginationData<List<NoticeDetailShow>>   noticeList = noticeWebService.noticeListApp(page);
        if(noticeList!=null) {
            assertThat((int) noticeList.getTotal(), greaterThanOrEqualTo(0));
        }
        assertThat(anything(),anything());
    }

    @Test
    public void noticeListPortal() {
        PaginationData<List<NoticeDetailShow>>   noticeList = noticeWebService.noticeListPortal(page);
        if(noticeList!=null) {
            assertThat((int) noticeList.getTotal(), greaterThanOrEqualTo(0));
        }
        assertThat(anything(),anything());
    }

    @Test
    public void findNoticeDetailsByNoticeId() {
        try {
            NoticeDetailShow  notice = noticeWebService.findNoticeDetailsByNoticeId(noticeId);
            assertThat(anything(),anything());
        }catch (JnSpringCloudException e){
            logger.warn("公告详情查询失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(NoticeExceptionEnum.NOTICE_NOT_EXIST.getCode())
                    ));
        }
    }
}