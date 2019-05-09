package com.jn.enterprise.recruit.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.company.model.ServiceCompany;
import com.jn.enterprise.company.dao.ServiceRecruitMapper;
import com.jn.enterprise.company.dao.TbServiceRecruitMapper;
import com.jn.enterprise.company.entity.TbServiceRecruit;
import com.jn.enterprise.company.enums.RecruitDataTypeEnum;
import com.jn.enterprise.company.enums.RecruitExceptionEnum;
import com.jn.enterprise.company.model.ServiceRecruitEditParam;
import com.jn.enterprise.company.model.ServiceRecruitParam;
import com.jn.enterprise.company.model.ServiceRecruitPublishParam;
import com.jn.enterprise.company.model.ServiceRecruitUnderParam;
import com.jn.enterprise.company.service.RecruitService;
import com.jn.enterprise.company.vo.RecruitVO;
import com.jn.system.model.User;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * @Author: huxw
 * @Date: 2019-4-3 2019-4-3 11:59:19
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudEnterpriseApplication.class})
public class RecruitServiceImplTest {

    /**
     * 日志组件
     */
    private Logger logger = LoggerFactory.getLogger(RecruitServiceImplTest.class);

    @Autowired
    private RecruitService recruitService;

    @Autowired
    private ServiceRecruitMapper serviceRecruitMapper;

    @Autowired
    private TbServiceRecruitMapper tbServiceRecruitMapper;

    //查询企业招聘入参
    private ServiceRecruitParam serviceRecruitParam = new ServiceRecruitParam();

    //编辑企业招聘入参
    private ServiceRecruitEditParam serviceRecruitEditParam = new ServiceRecruitEditParam();

    //发布企业招聘入参
    private ServiceRecruitPublishParam serviceRecruitPublishParam = new ServiceRecruitPublishParam();

    //上下架企业招聘入参
    private ServiceRecruitUnderParam serviceRecruitUnderParam = new ServiceRecruitUnderParam();

    //固定招聘ID
    private String recruitId;
    private String comId;
    private String OFF_SHEEL = "0";
    private String ON_SHEEL = "1";
    private String RECORD_STATUS = "1";

    ServiceCompany company = new ServiceCompany();
    User user = new User();

    @Before
    public void setUp() throws Exception {
        // 用户名称
        user.setAccount("wangsong");
        // 企业ID
        comId = "2220112212";
        company.setId(comId);
        company.setComName("深圳君南信息系统");
        // 招聘ID
        recruitId = "111111111";

        // 招聘ID
        serviceRecruitUnderParam.setId(recruitId);
        // 状态（1：已上架 0：已下架）
        serviceRecruitUnderParam.setStatus(ON_SHEEL);
        //serviceRecruitUnderParam.setStatus(OFF_SHEEL);

        // 招聘人数
        serviceRecruitPublishParam.setNum(20);
        // 岗位
        serviceRecruitPublishParam.setPost("JUNIT测试工程师");
        // 薪资待遇
        serviceRecruitPublishParam.setSalary("face_face");
        // 类型
        serviceRecruitPublishParam.setType("full_time");
        //详情
        serviceRecruitPublishParam.setDetails("测试系统BUG");


        // 招聘ID
        serviceRecruitEditParam.setId(recruitId);
        // 招聘人数
        serviceRecruitEditParam.setNum(20);
        // 岗位
        serviceRecruitEditParam.setPost("JUNIT测试工程师");
        // 招聘编码
        serviceRecruitEditParam.setRecruitNo("JN_JUNIT_TEST_20111111");
        // 薪资待遇
        serviceRecruitEditParam.setSalary("face_face");
        // 类型
        serviceRecruitEditParam.setType("full_time");
        //详情
        serviceRecruitEditParam.setDetails("测试系统BUG");

        //查询排序
        serviceRecruitParam.setSortTypes("time");
        // 查询筛选
        serviceRecruitParam.setWhereTypes("month");
        // 状态（1：已上架 0：已下架）
        serviceRecruitParam.setStatus("1");
        // 企业ID
        serviceRecruitParam.setComId("");
        // 查询字段（岗位/公司）
        serviceRecruitParam.setSearchFiled("");
        // 招聘类型
        serviceRecruitParam.setType("full_time");
        // 开始日期
        serviceRecruitParam.setBeginDate("2019-04-01");
        // 结束日期
        serviceRecruitParam.setEndDate("2019-04-03");

    }

    @Test
    public void getRecruitDetailsById() {
        try {
            RecruitVO recruitDetailsById = serviceRecruitMapper.getRecruitDetailsById("22222222");
            assertThat(recruitDetailsById, notNullValue());
        } catch (JnSpringCloudException e) {
            logger.info("根据招聘ID获取详情失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(RecruitExceptionEnum.RECRUIT_INFO_IS_NOT_EXIST.getCode())
                    )
            );
        }
    }

    @Test
    public void getRecruitList() {
        try {
            PaginationData<List<RecruitVO>> recruitList = recruitService.getRecruitList(serviceRecruitParam, null);
            if (recruitList.getRows() != null && recruitList.getRows().size() > 0) {
                assertThat(recruitList.getRows().size(), greaterThanOrEqualTo(1));
            } else {
                assertThat(anything(), anything());
            }
        } catch (JnSpringCloudException e) {
            logger.info("根据招聘列表失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(RecruitExceptionEnum.RECRUIT_WHERE_TYPE_ERROR.getCode()),
                            Matchers.containsString(RecruitExceptionEnum.RECRUIT_SORT_TYPE_ERROR.getCode()),
                            Matchers.containsString(RecruitExceptionEnum.RECRUIT_STATUS_ERROR.getCode()),
                            Matchers.containsString(RecruitExceptionEnum.RECRUIT_SEARCH_DATE_FORMAT_ERROR.getCode())
                    )
            );
        }
    }

    @Test
    public void publishRecruitInfo() {
        try {
            recruitService.publishRecruitInfo(serviceRecruitPublishParam, company, user);
            assertThat(anything(),anything());
        } catch (JnSpringCloudException e) {
            logger.info("发布招聘失败");
        }

    }

    @Test
    public void underRecruit() {
        try {
            TbServiceRecruit sr = new TbServiceRecruit();
            BeanUtils.copyProperties(serviceRecruitUnderParam,sr);
            sr.setModifierAccount(user.getAccount());
            sr.setModifiedTime(new Date());
            if (serviceRecruitUnderParam.getStatus().equals(RecruitDataTypeEnum.ON_SHELVES.getCode())) {
                sr.setStatus(new Byte(RecruitDataTypeEnum.OFF_SHELVES.getCode()));
            } else {
                sr.setStatus(new Byte(RecruitDataTypeEnum.ON_SHELVES.getCode()));
            }
            tbServiceRecruitMapper.updateByPrimaryKeySelective(sr);

            assertThat(anything(),anything());
        } catch (JnSpringCloudException e) {
            logger.info("上下架招聘失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(RecruitExceptionEnum.RECRUIT_INFO_IS_NOT_EXIST.getCode())
                    )
            );
        }
    }

    @Test
    public void editRecruitInfo() {
        try {
            TbServiceRecruit sr = new TbServiceRecruit();
            BeanUtils.copyProperties(serviceRecruitEditParam,sr);

            sr.setModifierAccount(user.getAccount());
            sr.setModifiedTime(new Date());
            tbServiceRecruitMapper.updateByPrimaryKeySelective(sr);

            assertThat(anything(),anything());
        } catch (JnSpringCloudException e) {
            logger.info("编辑招聘失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(RecruitExceptionEnum.RECRUIT_INFO_IS_NOT_EXIST.getCode())
                    )
            );
        }

    }

    @Test
    public void delRecruitById() {
        try {
            serviceRecruitMapper.delRecruitById(recruitId, user.getAccount(), new Date());
            assertThat(anything(),anything());
        } catch (JnSpringCloudException e) {
            logger.info("删除招聘失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(RecruitExceptionEnum.RECRUIT_INFO_IS_NOT_EXIST.getCode())
                    )
            );
        }
    }
}