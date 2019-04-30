package com.jn.enterprise.company.service;

import com.jn.common.model.PaginationData;
import com.jn.company.model.ServiceCompany;
import com.jn.enterprise.company.model.AcceptInviteParam;
import com.jn.enterprise.company.model.ReviewStaffParam;
import com.jn.enterprise.company.model.StaffListParam;
import com.jn.enterprise.company.vo.StaffAuditVO;
import com.jn.system.model.User;

import java.util.List;
import java.util.Map;

/**
 * 企业人员Service
 * @author： huxw
 * @date： Created on 2019-4-9 11:07:45
 * @version： v1.0
 * @modified By:
 */
public interface StaffService {

    /**
     * 获取员工列表
     * @param staffListParam 列表查询入参
     * @return
     */
    PaginationData getStaffList(StaffListParam staffListParam, String curAccount);

    /**
     * 获取同事列表
     * @param staffListParam 列表查询入参
     * @return
     */
    Map<String, Object> getColleagueList(StaffListParam staffListParam, String curAccount);

    /**
     * 邀请新成员列表
     * @param staffListParam 列表查询入参
     * @return
     */
    PaginationData getInviteStaffList(StaffListParam staffListParam, String curAccount);

    /**
     * 邀请员工
     * @param account 受邀请账号
     * @return
     */
    Integer inviteStaff(String[] account, User user);

    /**
     * 再次邀请员工
     * @param staffId 员工ID
     * @return
     */
    Integer inviteStaffAgain(String staffId, String curAccount);

    /**
     * 审核员工申请
     * @param reviewStaffParam 入参
     * @return
     */
    Integer reviewStaff(ReviewStaffParam reviewStaffParam, String curAccount);

    /**
     * 接受邀请
     * @param acceptInviteParam 入参
     * @return
     */
    Integer acceptInvite(AcceptInviteParam acceptInviteParam);

    /**
     * 拒绝邀请
     * @param staffId 员工ID
     * @return
     */
    Integer refuseInvite(String staffId);

    /**
     * 获取审核信息
     * @return
     */
    List<StaffAuditVO> getAuditStatus(String curAccount);

    /**
     * 批量删除员工
     * @param accounts 账号列表
     * @return
     */
    Integer delMoreStaffs(String[] accounts, String curAccount);

    /**
     * 设为/取消联系人
     * @param account 联系人账号
     * @param isSet 是否设为联系人
     * @return
     */
    Integer setOrCancelContact(String account, String curAccount, boolean isSet);

}
