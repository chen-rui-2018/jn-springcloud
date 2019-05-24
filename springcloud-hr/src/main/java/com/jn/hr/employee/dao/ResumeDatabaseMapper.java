package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerResumeDatabase;
import com.jn.hr.employee.model.ResumeDatabase;
import com.jn.hr.employee.model.ResumeDatabasePage;

import java.util.List;

/**
 * @author dt
 * @create 2019-04-15 下午 2:00
 */
public interface ResumeDatabaseMapper {
    List<ResumeDatabase> list(ResumeDatabasePage resumeDatabasePage);
    int insertBatch(List<TbManpowerResumeDatabase> list);
}
