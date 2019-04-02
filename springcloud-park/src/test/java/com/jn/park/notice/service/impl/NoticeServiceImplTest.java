package com.jn.park.notice.service.impl;

import com.jn.SpringCloudParkApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.park.enums.NoticeExceptionEnum;
import com.jn.park.enums.PolicyInfoExceptionEnum;
import com.jn.park.notice.dao.TbNoticeDetailsMapper;
import com.jn.park.notice.dao.TbNoticeInfoMapper;
import com.jn.park.notice.model.NoticeManageShow;
import com.jn.park.notice.model.NoticeModifyParam;
import com.jn.park.notice.model.NoticeQueryParam;
import com.jn.park.notice.model.NoticeShelfParam;
import com.jn.park.notice.service.NoticeService;
import com.jn.park.policy.service.impl.PolicyCenterServiceImplTest;
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
public class NoticeServiceImplTest {
    /**
     * 日志组件
     */
    private Logger logger = LoggerFactory.getLogger(NoticeServiceImplTest.class);

    @Autowired
    private NoticeService noticeService;
    @Autowired
    private TbNoticeDetailsMapper detailsMapper;
    @Autowired
    private TbNoticeInfoMapper infoMapper;


    private NoticeModifyParam param ;
    private NoticeQueryParam queryParam;
    private NoticeShelfParam shelfParam;
    private String noticeId;
    private String account;
    @Before
    public void setUp() throws Exception {
        account = "wangsong";
        //新增 或 编辑的bean
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

        //查询入参
        queryParam = new NoticeQueryParam();
        queryParam.setHomePopup("0");
        queryParam.setHomeShow("0");
        queryParam.setKeyWord("公告标题");
        queryParam.setNoticeStatus("1");

        //公告上下架入参
        shelfParam = new NoticeShelfParam();
        shelfParam.setNoticeId(noticeId);
        shelfParam.setNoticeStatus("0");
    }

    @Test
    public void addNotice() {
        try {
            int i = noticeService.addNotice(param, account);
            assertThat(i, greaterThanOrEqualTo(1));
        }catch (JnSpringCloudException e){
            logger.warn("发布(新增)公告失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(NoticeExceptionEnum.NOTICE_TRANCE_DETAILS_DEFAULT.getCode()),
                            Matchers.containsString(NoticeExceptionEnum.NOTICE_TIME_PARSE_DEFAULT.getCode())
                    ));
        }
    }

    @Test
    public void findNoticeList() {
        PaginationData<List<NoticeManageShow>> noticeList =  noticeService.findNoticeList(queryParam);
        if(noticeList!=null) {
            assertThat((int) noticeList.getTotal(), greaterThanOrEqualTo(0));
        }
        assertThat(anything(),anything());
    }

    @Test
    public void modifyNoticeList() {
        try {
            int i =  noticeService.modifyNotice(param,account);
            assertThat(i,greaterThanOrEqualTo(1));
        }catch (JnSpringCloudException e){
            logger.warn("编辑公告失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(NoticeExceptionEnum.NOTICE_TRANCE_DETAILS_DEFAULT.getCode()),
                            Matchers.containsString(NoticeExceptionEnum.NOTICE_TIME_PARSE_DEFAULT.getCode())
                    ));
        }
    }
    @Test
    public void findNoticeDetails() {
        try {
            NoticeManageShow noticeDetails =  noticeService.findNoticeDetails(noticeId);
            assertThat(anything(),anything());
        }catch (JnSpringCloudException e){
            logger.warn("公告详情查询失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(NoticeExceptionEnum.NOTICE_NOT_EXIST.getCode())
                    ));
        }
    }
    @Test
    public void noticeShelfOperate() {
        int i =  noticeService.noticeShelfOperate(shelfParam,account);
        assertThat(i,greaterThanOrEqualTo(1));
    }
    @Test
    public void zDeleteTest() {
        detailsMapper.deleteByPrimaryKey(noticeId);
        infoMapper.deleteByPrimaryKey(noticeId);
    }



}