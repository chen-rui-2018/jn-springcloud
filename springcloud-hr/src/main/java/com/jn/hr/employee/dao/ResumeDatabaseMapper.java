package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerEmployeeBasicInfo;
import com.jn.hr.employee.entity.TbManpowerResumeDatabase;
import com.jn.hr.employee.model.ResumeDatabase;
import com.jn.hr.employee.model.ResumeDatabasePage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dt
 * @create 2019-04-15 下午 2:00
 */
public interface ResumeDatabaseMapper {
    List<ResumeDatabase> list(ResumeDatabasePage resumeDatabasePage);
    int insertBatch(List<TbManpowerResumeDatabase> list);
    ResumeDatabase selectByPhone(@Param("phone")String phone,@Param("id")String id);
    ResumeDatabase selectByMailbox(@Param("mailbox")String mailbox,@Param("id")String id);
    ResumeDatabase selectByCertificateNumber(@Param("certificateNumber")String certificateNumber,@Param("id")String id);
}
