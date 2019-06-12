package com.jn.hr.employee.service;

import java.util.List;

import com.jn.common.model.PaginationData;
import com.jn.hr.attendance.model.VacationManagePage;
import com.jn.hr.attendance.model.VacationManageVo;
import com.jn.hr.employee.model.HolidayRule;
import com.jn.hr.employee.model.HolidayRuleAdd;
import com.jn.system.model.User;

/**
 * @author dt
 * @create 2019-04-23 下午 2:56
 */
public interface HolidayRuleService {
    //新增假期规则
    public String addHolidayRule(HolidayRuleAdd HolidayRuleAdd, User user);

    //修改假期规则
    public void updateHolidayRule(HolidayRuleAdd HolidayRuleAdd, User user);
    //删除假期规则
    public void delete(String id, User user);

    //查询假期规则
    public List<HolidayRule> getHolidayRules();
    
    //假期查询
  	public PaginationData<List<VacationManageVo>> inquireVacationManage(VacationManagePage vacationManagePage);
    //假期修改
  	public void updateVacationManage(VacationManagePage vacationManagePage);
}
