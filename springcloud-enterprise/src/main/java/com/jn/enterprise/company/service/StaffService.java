package com.jn.enterprise.company.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.company.model.AcceptInviteParam;
import com.jn.enterprise.company.model.ReviewStaffParam;
import com.jn.enterprise.company.model.StaffListParam;
import com.jn.enterprise.company.vo.ColleagueListVO;
import com.jn.enterprise.company.vo.StaffAuditVO;
import com.jn.enterprise.company.vo.UserExtensionInfoVO;

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
     * @return
     */
    PaginationData getStaffList(StaffListParam staffListParam, String curAccount);

    /**
     * 获取同事列表
     * @param staffListParam 列表查询入参
     * @return
     */
    ColleagueListVO getColleagueList(StaffListParam staffListParam, String curAccount);

    /**
     * 根据手机号或账号查询用户信息
     * @param phone 手机号
     * @return
     */
    UserExtensionInfoVO getInviteStaffList(String phone, String curAccount);

    /**
     * 邀请员工
     * @param inviteAccount 受邀请账号
     * @param curAccount 当前账号
     * @return
     */
    Integer inviteStaff(String inviteAccount, String curAccount);

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
     * @param comId 企业ID
     * @param account 账号
     * @return
     */
    Integer refuseInvite(String comId, String account);

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
