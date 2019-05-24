package com.jn.hr.employee.dao;

import com.jn.hr.archives.model.EmployeeFilePage;
import com.jn.hr.archives.model.FileAttachment;

import java.util.List;

/**
 * @author dt
 * @create 2019-04-18 下午 2:17
 */
public interface FileAttachmentMapper {
    List<FileAttachment> list(EmployeeFilePage employeeFilePage);
}
