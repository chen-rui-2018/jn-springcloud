package com.jn.hr.employee.dao;

import com.jn.hr.attendance.model.VacationManageVo;
import com.jn.hr.employee.model.VacationManage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dt
 * @create 2019-05-08 下午 4:24
 */
public interface VacationManageMapper {
    int insertBatch(List<VacationManage> list);
    int deleteByJobNumber(@Param("jobNumber") String jobNumber);
}
