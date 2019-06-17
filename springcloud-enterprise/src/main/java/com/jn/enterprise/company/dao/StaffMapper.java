package com.jn.enterprise.company.dao;

import com.jn.enterprise.company.entity.TbServiceCompanyStaff;
import com.jn.enterprise.company.model.StaffListInParam;
import com.jn.enterprise.company.model.StaffStatusList;
import com.jn.enterprise.company.vo.StaffAuditVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author： huxw
 * @date： Created on 2019-4-9 14:47:19
 * @version： v1.0
 * @modified By:
 */
public interface StaffMapper {

    /**
     * 员工邀请状态列表
     * @param staffListInParam 查询列表入参
     * @return
     */
    List<StaffStatusList> getStaffStatusList(StaffListInParam staffListInParam);

    /**
     * 批量邀请企业成员
     * @param list
     * @return
     */
    Integer inviteStaffs(@Param("staffList") List<TbServiceCompanyStaff> list);

    /**
     * 根据账号获取审核信息
     * @param account
     * @return
     */
    StaffAuditVO getAuditStatus(@Param("account") String account);
}
