package com.jn.hr.archives.controller;

import com.alibaba.excel.support.ExcelTypeEnum;
import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.common.util.DateUtils;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.hr.archives.model.EmployeeFile;
import com.jn.hr.archives.model.EmployeeFileAdd;
import com.jn.hr.archives.model.EmployeeFilePage;
import com.jn.hr.archives.model.FileAttachment;
import com.jn.hr.archives.service.EmployeeFileService;
import com.jn.hr.employee.enums.EmployeeExceptionEnums;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @author dt
 * @create 2019-04-17 上午 10:39
 */
@Api(tags = "员工档案管理")
@RestController
@RequestMapping("/hr/employeeFile")
public class EmployeeFileController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeFileController.class);
    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private EmployeeFileService employeeFileService;

    @ControllerLog(doAction = "添加员工档案")
    @RequiresPermissions("/hr/employeeFile/addEmployeeFile")
    @ApiOperation(value = "添加员工档案", notes = "添加员工档案")
    @PostMapping(value = "/addEmployeeFile")
    public Result addEmployeeFile(@Validated @RequestBody EmployeeFileAdd EmployeeFileAdd) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        employeeFileService.addEmployeeFile(EmployeeFileAdd,user);
        return new Result();
    }
    @ControllerLog(doAction = "修改员工档案")
    @RequiresPermissions("/hr/employeeFile/updateEmployeeFile")
    @ApiOperation(value = "修改员工档案", notes = "修改员工档案")
    @PostMapping(value = "/updateEmployeeFile")
    public Result updateResumeData(@Validated @RequestBody EmployeeFileAdd EmployeeFileAdd) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Assert.hasText(EmployeeFileAdd.getFileId(),"fileId不能为空");
        employeeFileService.updateEmployeeFile(EmployeeFileAdd,user);
        return new Result();
    }

    @ControllerLog(doAction = "员工档案列表")
    @RequiresPermissions("/hr/employeeFile/list")
    @ApiOperation(value = "员工档案列表", notes = "员工档案列表")
    @PostMapping(value = "/list")
    public Result<PaginationData<List<EmployeeFile>>> list(@Validated @RequestBody EmployeeFilePage employeeFilePage) {
        PaginationData<List<EmployeeFile>> data = employeeFileService.list(employeeFilePage);
        return new Result(data);
    }

    @ControllerLog(doAction = "查询员工档案详情")
    @RequiresPermissions("/hr/employeeFile/getEmployeeFile")
    @ApiOperation(value = "查询员工档案详情", notes = "查询员工档案详情")
    @GetMapping(value = "/getEmployeeFile")
    public Result<List<EmployeeFile>> getResumeDatabaseById(@RequestParam("id") String fileId) {
        Assert.hasText(fileId,"fileId不能为空");
        EmployeeFile resumeDatabase = employeeFileService.getEmployeeFileById(fileId);
        return new Result(resumeDatabase);
    }


    @ControllerLog(doAction = "删除员工档案")
    @RequiresPermissions("/hr/employeeFile/deleteEmployeeFile")
    @ApiOperation(value = "删除员工档案", notes = "删除员工档案")
    @GetMapping(value = "/deleteEmployeeFile")
    public Result delete(@RequestParam("id") String fileId) {
        Assert.hasText(fileId,"fileId不能为空");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        employeeFileService.delete(fileId, user);
        return new Result();
    }

    @ControllerLog(doAction = "附件上传")
    @RequiresPermissions("/hr/employeeFile/uploadAttachment")
    @ApiOperation(value = "附件上传", notes ="附件上传")
    @PostMapping("/uploadAttachment")
    public Result uploadAttachment(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        String fileId=request.getParameter("fileId");
        Assert.hasText(fileId,"fileId不能为空");
        Assert.notEmpty(files);
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<FileAttachment> attachments = employeeFileService.uploadAttachment(files,fileId,user);
        return new Result(attachments);
    }

    @ControllerLog(doAction = "附件删除")
    @RequiresPermissions("/hr/employeeFile/deleteAttachment")
    @ApiOperation(value = "附件删除", notes ="附件删除")
    @GetMapping("/deleteAttachment")
    public Result deleteAttachment(@RequestParam("id") String id) {
        Assert.hasText(id,"id不能为空");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
         employeeFileService.deleteAttachment(id,user);
        return new Result();
    }

    @ControllerLog(doAction = "导入员工档案")
    @RequiresPermissions("/hr/employeeFile/importEmployeeFile")
    @ApiOperation(value = "导入员工档案", notes = "导入员工档案")
    @PostMapping(value = "/importEmployeeFile")
    public Result<String> importEmployeeFile(@RequestParam("file") MultipartFile file) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String str= employeeFileService.importEmployeeFile(file,user);
        return new Result<String>(str);
    }

    @ControllerLog(doAction = "导出员工档案")
    @RequiresPermissions("/hr/employeeFile/exportEmployeeFile")
    @ApiOperation(value = "导出员工档案", notes = "导出员工档案")
    @GetMapping(value = "/exportEmployeeFile")
    public void exportEmployeeFile(EmployeeFilePage employeeFilePage,
                                     HttpServletResponse response) {
        employeeFilePage.setPage(1);
        employeeFilePage.setRows(200000);
        PaginationData<List<EmployeeFile>> pageList= employeeFileService.list(employeeFilePage);
        String exportTitle = "档号,分类名称,文号,题名,备注,创建日期,责任人,登记部门";
        String exportColName = "fileId,nodeName,symbol,titleName,remark,createdTimeStr,personLiable,regDepartment";
        String fileName = "员工档案"+ DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
        String sheetName = "员工档案";
        ExcelUtil.writeExcelWithCol(response, fileName, sheetName, exportTitle, exportColName, pageList.getRows());
    }
    @ControllerLog(doAction = "下载员工档案excel模板")
    @RequiresPermissions("/hr/employeeFile/downLoadEmployeeFileExcelTemplate")
    @ApiOperation(value = "下载员工档案excel模板", notes = "下载员工档案excel模板")
    @GetMapping(value = "/downLoadEmployeeFileExcelTemplate")
    public ResponseEntity<byte[]> downLoadEmployeeFileExcelTemplate() {
        try {
            Resource resource = resourceLoader.getResource(
                    "classpath:excelTemplate/employeeFileTemplate.xlsx");
            File file = resource.getFile();
            String name = "员工档案导入模板" + ExcelTypeEnum.XLSX.getValue();
            String fileName = new String(name.getBytes(), "ISO-8859-1");
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/octet-stream");
            headers.add("Content-Disposition", "attachment;filename=" + fileName);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("[员工档案] ,员工档案导入模板下载失败", e);
            throw new JnSpringCloudException(EmployeeExceptionEnums.DOWNLOAD_EXCEL_TEMPLATE_FAIL);
        }
    }
    @ControllerLog(doAction = "分页查询员工档案附件")
    @RequiresPermissions("/hr/employeeFile/getEmployeeFileAttachmentById")
    @ApiOperation(value = "分页查询员工档案附件", notes = "分页查询员工档案附件")
    @PostMapping(value = "/getEmployeeFileAttachmentById")
    public Result<List<EmployeeFile>> getResumeDatabaseById(@Validated @RequestBody
                                                                        EmployeeFilePage employeeFilePage) {
        Assert.hasText(employeeFilePage.getFileId(),"fileId不能为空");
        EmployeeFile resumeDatabase = employeeFileService.getEmployeeFileAttachmentById(employeeFilePage);
        return new Result(resumeDatabase);
    }

    @ControllerLog(doAction = "员工档案附件名称修改")
    @RequiresPermissions("/hr/employeeFile/updateEmployeeFileAttachment")
    @ApiOperation(value = "员工档案附件名称修改", notes = "员工档案附件名称修改")
    @PostMapping(value = "/updateEmployeeFileAttachment")
    public Result<List<EmployeeFile>> updateEmployeeFileAttachment(@Validated @RequestBody
                                                                        FileAttachment fileAttachment) {
        employeeFileService.updateEmployeeFileAttachmentById(fileAttachment);
        return new Result();
    }
}
