package com.jn.hr.employee.controller;

import com.alibaba.excel.support.ExcelTypeEnum;
import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.common.util.DateUtils;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.hr.employee.enums.EmployeeExceptionEnums;
import com.jn.hr.employee.model.BackgroundInvestAdd;
import com.jn.hr.employee.model.ResumeDatabase;
import com.jn.hr.employee.model.ResumeDatabaseAdd;
import com.jn.hr.employee.model.ResumeDatabasePage;
import com.jn.hr.employee.service.ResumeDatabaseService;
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

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @author dt
 * @create 2019-04-15 上午 10:31
 */
@Api(tags = "简历库管理")
@RestController
@RequestMapping("/hr/resumeData")
public class ResumeDatabaseController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(ResumeDatabaseController.class);
    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private ResumeDatabaseService resumeDatabaseService;
    @ControllerLog(doAction = "添加简历库")
    @RequiresPermissions("/hr/resumeData/addResumeData")
    @ApiOperation(value = "添加简历库", notes = "添加简历库")
    @PostMapping(value = "/addResumeData")
    public Result addResumeData(@Validated @RequestBody ResumeDatabaseAdd resumeDatabaseAdd) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        resumeDatabaseService.addResumeDatabase(resumeDatabaseAdd,user);
        return new Result();
    }
    @ControllerLog(doAction = "修改简历库")
    @RequiresPermissions("/hr/resumeData/updateResumeData")
    @ApiOperation(value = "修改简历库", notes = "修改简历库")
    @PostMapping(value = "/updateResumeData")
    public Result updateResumeData(@Validated @RequestBody ResumeDatabaseAdd resumeDatabaseAdd) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Assert.notNull(resumeDatabaseAdd.getId(),"id不能为空");
        resumeDatabaseService.updateResumeDatabase(resumeDatabaseAdd,user);
        return new Result();
    }

    @ControllerLog(doAction = "简历库列表")
    @RequiresPermissions("/hr/resumeData/list")
    @ApiOperation(value = "简历库列表", notes = "简历库列表")
    @PostMapping(value = "/list")
    public Result<PaginationData<List<ResumeDatabase>>> list(@Validated @RequestBody ResumeDatabasePage
                                                                         resumeDatabasePage) {
        PaginationData<List<ResumeDatabase>> data = resumeDatabaseService.list(resumeDatabasePage);
        return new Result(data);
    }

    @ControllerLog(doAction = "查询简历库详情")
    @RequiresPermissions("/hr/resumeData/getResumeDatabaseById")
    @ApiOperation(value = "查询简历库详情", notes = "查询简历库详情")
    @GetMapping(value = "/getResumeDatabaseById")
    public Result<ResumeDatabase> getResumeDatabaseById(@RequestParam("id") String id) {
        Assert.notNull(id,"id不能为空");
        ResumeDatabase resumeDatabase = resumeDatabaseService.getResumeDatabaseById(id);
        return new Result(resumeDatabase);
    }


    @ControllerLog(doAction = "删除简历库")
    @RequiresPermissions("/hr/resumeData/delete")
    @ApiOperation(value = "删除简历库", notes = "删除简历库")
    @GetMapping(value = "/delete")
    public Result delete(@RequestParam("id") String id) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        resumeDatabaseService.delete(id, user);
        return new Result();
    }
    @ControllerLog(doAction = "通过简历")
    @RequiresPermissions("/hr/resumeData/passResumeDatabase")
    @ApiOperation(value = "通过简历", notes = "通过简历")
    @GetMapping(value = "/passResumeDatabase")
    public Result passResumeDatabase(@RequestParam("id") String id) {
        Assert.notNull(id,"id不能为空");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        resumeDatabaseService.passResumeDatabase(id, user);
        return new Result();
    }
    @ControllerLog(doAction = "淘汰简历")
    @RequiresPermissions("/hr/resumeData/notPassResumeDatabase")
    @ApiOperation(value = "淘汰简历", notes = "淘汰简历")
    @GetMapping(value = "/notPassResumeDatabase")
    public Result notPassResumeDatabase(@RequestParam("id") String id) {
        Assert.notNull(id,"id不能为空");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        resumeDatabaseService.notPassResumeDatabase(id, user);
        return new Result();
    }
    @ControllerLog(doAction = "完成简历背景调查")
    @RequiresPermissions("/hr/resumeData/finishBackgroundInvest")
    @ApiOperation(value = "完成简历背景调查", notes = "完成简历背景调查")
    @PostMapping(value = "/finishBackgroundInvest")
    public Result finishBackgroundInvest(@Validated @RequestBody BackgroundInvestAdd backgroundInvestAdd) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        resumeDatabaseService.finishBackgroundInvest(backgroundInvestAdd,user);
        return new Result();
    }
    @ControllerLog(doAction = "导出简历库")
    @RequiresPermissions("/hr/resumeData/exportResumeDatabase")
    @ApiOperation(value = "导出简历库", notes = "导出简历库")
    @GetMapping(value = "/exportResumeDatabase")
    public void exportResumeDatabase(ResumeDatabasePage resumeDatabasePage,
                                     HttpServletResponse response) {
        resumeDatabasePage.setPage(1);
        resumeDatabasePage.setRows(200000);
        PaginationData<List<ResumeDatabase>> pageList= resumeDatabaseService.list(resumeDatabasePage);
        String exportTitle = "姓名,性别,手机号码,个人邮箱,应聘部门,证件类型,证件号,学历," +
                "毕业院校,是否完成背景调查,应聘结果";
        String exportColName = "name,sexStr,phone,mailbox,departmentName,certificateType," +
                "certificateNumber,educationName,graduaAcademy,isBackgroundInvestStr,applicationResultStr";
        String fileName = "简历库"+ DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
        String sheetName = "简历库";
        ExcelUtil.writeExcelWithCol(response, fileName, sheetName, exportTitle,
                exportColName, pageList.getRows());
    }

    @ControllerLog(doAction = "导入简历库")
    @RequiresPermissions("/hr/resumeData/importResumeDatabase")
    @ApiOperation(value = "导入简历库", notes = "导入简历库")
    @PostMapping(value = "/importResumeDatabase")
    public Result<String> importResumeDatabase(@RequestParam("file") MultipartFile file) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String str= resumeDatabaseService.importResumeDatabase(file,user);
        return new Result<String>(str);
    }
    @ControllerLog(doAction = "下载简历库excel模板")
    @RequiresPermissions("/hr/resumeData/downLoadResumeDatabaseExcelTemplate")
    @ApiOperation(value = "下载简历库excel模板", notes = "下载简历库excel模板")
    @GetMapping(value = "/downLoadResumeDatabaseExcelTemplate")
    public ResponseEntity<byte[]> downLoadResumeDatabaseExcelTemplate() {
        try {
            Resource resource = resourceLoader.getResource(
                    "classpath:excelTemplate/resumeDatabaseTemplate.xlsx");
            File file = resource.getFile();
            String name = "简历库导入模板" + ExcelTypeEnum.XLSX.getValue();
            String fileName = new String(name.getBytes(), "ISO-8859-1");
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/octet-stream");
            headers.add("Content-Disposition", "attachment;filename=" + fileName);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("[简历库] ,简历库导入模板下载失败", e);
            throw new JnSpringCloudException(EmployeeExceptionEnums.DOWNLOAD_EXCEL_TEMPLATE_FAIL);
        }
    }

    @ControllerLog(doAction = "校验简历号码是否存在")
    @RequiresPermissions("/hr/resumeData/checkPhoneExist")
    @ApiOperation(value = "校验员工号码是否存在", notes = "校验简历号码是否存在")
    @GetMapping(value = "/checkPhoneExist")
    public Result checkPhoneExist(@RequestParam("phone") String phone,@RequestParam(value="id",required = false) String id){
        Assert.notNull(phone,"号码不能为空");
        boolean flag= resumeDatabaseService.checkPhoneExist(phone,id);
        return new Result(flag);
    }
    @ControllerLog(doAction = "校验简历邮箱是否存在")
    @RequiresPermissions("/hr/resumeData/checkMailboxExist")
    @ApiOperation(value = "校验简历邮箱是否存在", notes = "校验简历邮箱是否存在")
    @GetMapping(value = "/checkMailboxExist")
    public Result checkMailboxExist(@RequestParam("mailbox") String mailbox,@RequestParam(value="id",required = false) String id){
        Assert.notNull(mailbox,"邮箱不能为空");
        boolean flag= resumeDatabaseService.checkMailboxExist(mailbox,id);
        return new Result(flag);
    }
    @ControllerLog(doAction = "校验简历证件号码是否存在")
    @RequiresPermissions("/hr/resumeData/checkCertificateNumberExist")
    @ApiOperation(value = "校验简历证件号码是否存在", notes = "校验简历证件号码是否存在")
    @GetMapping(value = "/checkCertificateNumberExist")
    public Result checkCertificateNumberExist(@RequestParam("certificateNumber") String certificateNumber,
                                              @RequestParam(value="id",required = false) String id){
        Assert.notNull(certificateNumber,"证件号码不能为空");
        boolean flag= resumeDatabaseService.checkCertificateNumberExist(certificateNumber,id);
        return new Result(flag);
    }

}
