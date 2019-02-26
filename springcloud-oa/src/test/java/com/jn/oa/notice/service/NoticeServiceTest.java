package com.jn.oa.notice.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.oa.common.enums.OaStatusEnums;
import com.jn.oa.notice.model.Notice;
import com.jn.oa.notice.model.NoticeAdd;
import com.jn.oa.notice.model.NoticePage;
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

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NoticeServiceTest {

    @Autowired
    private NoticeService noticeService;

    //公告id
    public static String noticeId;
    //创建者
    private static User user;
    //发布平台
    private static String platformType = "1";
    //添加对象
    private static NoticeAdd noticeAdd;

    @BeforeClass
    public static void init() {
        //初始化添加用户
        user = new User();
        user.setAccount("wangsong");

        //初始化公告id
        noticeId = UUID.randomUUID().toString();

        //初始化部门对象
        noticeAdd = new NoticeAdd();
        noticeAdd.setId(noticeId);
        noticeAdd.setWorkOrderNum("testworknum000");
        noticeAdd.setNoticeTitle("测试公告");
        noticeAdd.setNoticeContent("公告测试");
        noticeAdd.setPlatformType(platformType);
        noticeAdd.setRecordStatus(new Byte(OaStatusEnums.EFFECTIVE.getCode()));
        noticeAdd.setEffectiveTime("2019-02-01 10:10:10");
        noticeAdd.setFailureTime("2019-02-02 10:10:10");
    }


    @Test
    public void addOrUpdateNotice() {
        try {
            //添加公告
            Boolean flag = true;
            noticeService.addOrUpdateNotice(noticeAdd, user, flag);
            //修改工作
            noticeAdd.setNoticeContent("修改公告测试");
            flag = false;
            noticeService.addOrUpdateNotice(noticeAdd, user, flag);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void list() {
        NoticePage page = new NoticePage();
        page.setPage(1);
        page.setRows(10);
        PaginationData data = noticeService.list(page);
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void getNoticeById() {
        Notice notice = noticeService.getNoticeById(noticeId);
        Assert.assertThat(notice, Matchers.notNullValue());
    }

    @Test
    public void publishNotice() {
        List<Notice> noticeList = noticeService.publishNotice(platformType);
        Assert.assertThat(noticeList, Matchers.anything());
    }

    @Test
    public void zDelete() {
        noticeService.delete(noticeId, user);
    }
}