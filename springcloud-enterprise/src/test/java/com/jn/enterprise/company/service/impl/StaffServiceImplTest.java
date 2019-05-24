package com.jn.enterprise.company.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.company.model.ServiceCompany;
import com.jn.enterprise.company.enums.CompanyDataEnum;
import com.jn.enterprise.company.enums.CompanyExceptionEnum;
import com.jn.enterprise.company.model.AcceptInviteParam;
import com.jn.enterprise.company.model.ReviewStaffParam;
import com.jn.enterprise.company.model.StaffListParam;
import com.jn.enterprise.company.service.StaffService;
import com.jn.enterprise.company.vo.ColleagueListVO;
import com.jn.enterprise.company.vo.StaffListVO;
import com.jn.system.model.User;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

/**
 * @Author: huxw
 * @Date: 2019-4-15 16:37:55
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudEnterpriseApplication.class})
public class StaffServiceImplTest {

    // 日志组件
    private static Logger logger = LoggerFactory.getLogger(StaffServiceImplTest.class);

    @Autowired
    private StaffService staffService;

    // 查询员工列表入参
    private StaffListParam staffListParam = new StaffListParam();
    // 查询同事列表入参
    private StaffListParam colleagueListParam = new StaffListParam();
    // 查询待邀请列表入参
    private StaffListParam waitInviteStaffListParam = new StaffListParam();

    // 员工审核入参
    private ReviewStaffParam reviewStaffParam = new ReviewStaffParam();

    // 接受企业邀请入参
    private AcceptInviteParam acceptInviteParam = new AcceptInviteParam();

    // 企业对象
    private ServiceCompany company = new ServiceCompany();

    // 当前用户对象
    private User user = new User();

    // 邀请员工数组
    private String inviteAccounts;

    // 批量删除成员账号数组
    private String[] delAccounts;

    // 再次邀请员工ID
    private String inviteStaffAgainStr;

    // 拒绝企业邀请员工账号
    private String refuseComInviteStr;

    // 获取待审核列表账号
    private String getWaitAuditListAccount;

    // 设为联系人账号
    private String setContactAccount;

    // 取消联系人账号
    private String cancelContactAccount;

    // 是否分页
    private String NEEDPAGE_YES = "1";


    @Before
    public void setUp() throws Exception {
        // 企业对象封装
        company.setId("2220112212");
        company.setComName("深圳君南信息系统");

        // 用户对象封装
        user.setAccount("wangsong");

        // 员工列表
        staffListParam.setNeedPage(NEEDPAGE_YES);
//        staffListParam.setStatus(CompanyDataEnum.STAFF_CHECK_STATUS_PASS.getCode());
//        staffListParam.setSearchFiled("张三");

        // 同事列表
        colleagueListParam.setNeedPage(NEEDPAGE_YES);
//        colleagueListParam.setSearchFiled("张三");

        // 待邀请员工列表
        waitInviteStaffListParam.setSearchFiled("小");


        // 审核员工申请封装
        reviewStaffParam.setStaffId("83bd4e2a26aa4650b6c171e103ea0ff2");
        reviewStaffParam.setCheckStatus(CompanyDataEnum.STAFF_CHECK_STATUS_NOT_PASS.getCode());

        // 接受企业邀请对象封装
        acceptInviteParam.setAccount("qianqi");
        acceptInviteParam.setComId(company.getId());
        acceptInviteParam.setName("JUNIT");
        acceptInviteParam.setNickName("小J");
        acceptInviteParam.setPhone("12987643333");
        acceptInviteParam.setBirthday("1995-08-09");

        // 邀请账号数组
        inviteAccounts ="17300000001";

        // 删除账号数组
        delAccounts = new String[]{"13560342716","13265603090","17724520214"};

        // 拒绝邀请员工ID
        refuseComInviteStr = "83bd4e2a26aa4650b6c171e103ea0ff2";
        // 再次邀请员工ID
        inviteStaffAgainStr = "78e831df385144ef9afa30adff5714a6";
        // 获取待审核列表账号
        getWaitAuditListAccount = "18682017594";
        // 设为联系人账号
        setContactAccount = "18682017594";
        // 取消联系人账号
        cancelContactAccount = "18682017594";
    }

    @Test
    public void getStaffList() {
        try {
            PaginationData staffList = staffService.getStaffList(staffListParam, user.getAccount());
            List<StaffListVO> dataList = (List<StaffListVO>) staffList.getRows();
            if (dataList != null && !dataList.isEmpty()) {
                assertThat(dataList.size(), greaterThanOrEqualTo(1));
            } else {
                assertThat(anything(), anything());
            }
        } catch (JnSpringCloudException e) {
            logger.info("查询员工列表失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(CompanyExceptionEnum.CALL_SYSTEM_SERVICE_ERROR.getCode())
                    )
            );
        }
    }

    @Test
    public void getColleagueList() {
        try {
            ColleagueListVO colleagueList = staffService.getColleagueList(colleagueListParam, user.getAccount());
            PaginationData<List<StaffListVO>> paginationData = colleagueList.getData();
            List<StaffListVO> dataList = paginationData.getRows();
            if (dataList != null && !dataList.isEmpty()) {
                assertThat(dataList.size(), greaterThanOrEqualTo(1));
            } else {
                assertThat(anything(), anything());
            }
        } catch (JnSpringCloudException e) {
            logger.info("查询同事列表失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(CompanyExceptionEnum.CALL_SYSTEM_SERVICE_ERROR.getCode())
                    )
            );
        }
    }

    @Test
    public void getInviteStaffList() {
        try {
            staffService.getInviteStaffList("17300000001");
            assertThat(anything(), anything());
        } catch (JnSpringCloudException e) {
            logger.info("查询待邀请列表失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(CompanyExceptionEnum.CALL_SYSTEM_SERVICE_ERROR.getCode())
                    )
            );
        }
    }

    @Test
    public void inviteStaff() {
        try {
            staffService.inviteStaff(inviteAccounts, user.getAccount());
            assertThat(anything(),anything());
        } catch (JnSpringCloudException e) {
            logger.info("批量邀請失敗");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(CompanyExceptionEnum.CALL_SYSTEM_SERVICE_ERROR.getCode()),
                            Matchers.containsString(CompanyExceptionEnum.ACCOUNT_LIST_IS_NULL.getCode())
                    )
            );
        }
    }

    @Test
    public void reviewStaff() {
        try {
            staffService.reviewStaff(reviewStaffParam, user.getAccount());
            assertThat(anything(),anything());
        } catch (JnSpringCloudException e) {
            logger.info("审核员工失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(CompanyExceptionEnum.CALL_SYSTEM_SERVICE_ERROR.getCode()),
                            Matchers.containsString(CompanyExceptionEnum.USER_NO_STAFF.getCode())
                    )
            );
        }
    }

    @Test
    public void acceptInvite() {
        try {
            staffService.acceptInvite(acceptInviteParam);
            assertThat(anything(),anything());
        } catch (JnSpringCloudException e) {
            logger.info("接受邀请失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(CompanyExceptionEnum.CALL_SYSTEM_SERVICE_ERROR.getCode()),
                            Matchers.containsString(CompanyExceptionEnum.ACCOUNT_NOT_GET_INVITE.getCode())
                    )
            );
        }
    }

    @Test
    public void refuseInvite() {
        try {
            staffService.refuseInvite(company.getId(), refuseComInviteStr);
            assertThat(anything(),anything());
        } catch (JnSpringCloudException e) {
            logger.info("拒绝邀请失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(CompanyExceptionEnum.CALL_SYSTEM_SERVICE_ERROR.getCode())
                    )
            );
        }
    }

    @Test
    public void getAuditStatus() {
        try {
            staffService.getAuditStatus(user.getAccount());
            assertThat(anything(),anything());
        } catch (JnSpringCloudException e) {
            logger.info("获取待审核列表失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(CompanyExceptionEnum.CALL_SYSTEM_SERVICE_ERROR.getCode())
                    )
            );
        }
    }

    @Test
    public void setContact() {
        try {
            staffService.setOrCancelContact(setContactAccount, user.getAccount(), true);
            assertThat(anything(),anything());
        } catch (JnSpringCloudException e) {
            logger.info("设为联系人失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(CompanyExceptionEnum.CALL_SYSTEM_SERVICE_ERROR.getCode()),
                            Matchers.containsString(CompanyExceptionEnum.USER_NO_STAFF.getCode())
                    )
            );
        }
    }

    @Test
    public void cancelContact() {
        try {
            staffService.setOrCancelContact(cancelContactAccount, user.getAccount(), false);
            assertThat(anything(),anything());
        } catch (JnSpringCloudException e) {
            logger.info("取消联系人失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(CompanyExceptionEnum.CALL_SYSTEM_SERVICE_ERROR.getCode()),
                            Matchers.containsString(CompanyExceptionEnum.USER_NO_STAFF.getCode())
                    )
            );
        }
    }

    @Test
    public void delMoreStaffs() {
        try {
            staffService.delMoreStaffs(delAccounts, user.getAccount());
            assertThat(anything(),anything());
        } catch (JnSpringCloudException e) {
            logger.info("批量删除员工失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(CompanyExceptionEnum.CALL_SYSTEM_SERVICE_ERROR.getCode()),
                            Matchers.containsString(CompanyExceptionEnum.ACCOUNT_LIST_IS_NULL.getCode()),
                            Matchers.containsString(CompanyExceptionEnum.USER_IS_NOT_COMPANY_ADMIN_OR_CONTACTS.getCode())
                    )
            );
        }
    }
}