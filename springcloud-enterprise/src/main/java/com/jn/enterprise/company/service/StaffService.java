package com.jn.enterprise.company.service;

import com.jn.common.model.PaginationData;
import com.jn.company.model.ServiceCompany;
import com.jn.enterprise.company.model.AcceptInviteParam;
import com.jn.enterprise.company.model.ReviewStaffParam;
import com.jn.enterprise.company.model.StaffListParam;
import com.jn.enterprise.company.vo.StaffAuditVO;
import com.jn.system.model.User;

import java.util.List;

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
     * @param comId 企业ID
     * @return
     */
    PaginationData getStaffList(StaffListParam staffListParam, String comId);

    /**
     * 获取同事列表
     * @param staffListParam 列表查询入参
     * @param comId 企业ID
     * @return
     */
    PaginationData getColleagueList(StaffListParam staffListParam, String comId);

    /**
     * 邀请新成员列表
     * @param staffListParam 列表查询入参
     * @param comId 企业ID
     * @return
     */
    PaginationData getInviteStaffList(StaffListParam staffListParam, String comId);

    /**
     * 邀请员工
     * @param account 受邀请账号
     * @param company 当前企业
     * @param user 当前用户
     * @return
     */
    Integer inviteStaff(String[] account, ServiceCompany company, User user);

    /**
     * 再次邀请员工
     * @param staffId 员工ID
     * @return
     */
    Integer inviteStaffAgain(String staffId);

    /**
     * 审核员工申请
     * @param reviewStaffParam 入参
     * @param company 企业对象
     * @param user 当前用户
     * @return
     */
    Integer reviewStaff(ReviewStaffParam reviewStaffParam, ServiceCompany company, User user);

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
     * @param account 账号
     * @return
     */
    List<StaffAuditVO> getAuditStatus(String account);

    /**
     * 批量删除员工
     * @param accountList 账号列表
     * @param comId 企业ID
     * @param curAccount 当前账号
     * @return
     */
    Integer delMoreStaffs(String[] accountList, String comId, String curAccount);

    /**
     * 设为联系人
     * @param account 联系人账号
     * @param comId 企业ID
     * @return
     */
    Integer setContact(String account, String comId);

    /**
     * 取消联系人
     * @param account 联系人账号
     * @param comId 企业ID
     * @return
     */
    Integer cancelContact(String account, String comId);

}
