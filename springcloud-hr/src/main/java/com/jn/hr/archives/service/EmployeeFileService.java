package com.jn.hr.archives.service;

import com.jn.common.model.PaginationData;
import com.jn.hr.archives.model.EmployeeFile;
import com.jn.hr.archives.model.EmployeeFileAdd;
import com.jn.hr.archives.model.EmployeeFilePage;
import com.jn.hr.archives.model.FileAttachment;
import com.jn.system.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author dt
 * @create 2019-04-16 下午 7:01
 */
public interface EmployeeFileService {
    //新增员工档案
    public void addEmployeeFile(EmployeeFileAdd employeeFileAdd, User user);

    //修改员工档案
    public void updateEmployeeFile(EmployeeFileAdd employeeFileAdd, User user);
    //删除员工档案
    public void delete(String id, User user);

    //查询员工档案详情
    public EmployeeFile getEmployeeFileById(String id);
    //分页查询
    public PaginationData<List<EmployeeFile>> list(EmployeeFilePage employeeFilePage);

    //导入excel
    public String importEmployeeFile(MultipartFile file, User user);
    //附件上传
    public List<FileAttachment> uploadAttachment(List<MultipartFile> files, String fileId, User user);
    public void deleteAttachment(String id, User user);
    //查询员工档案附件详情
    public EmployeeFile getEmployeeFileAttachmentById(EmployeeFilePage employeeFilePage);
    //修改附件名称
    public void updateEmployeeFileAttachmentById(FileAttachment fileAttachment);
}
