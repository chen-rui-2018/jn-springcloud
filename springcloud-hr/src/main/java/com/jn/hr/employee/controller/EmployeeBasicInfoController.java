package com.jn.hr.employee.controller;

import com.alibaba.excel.support.ExcelTypeEnum;
import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.common.util.DateUtils;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.hr.archives.model.TreeModel;
import com.jn.hr.employee.enums.EmployeeExceptionEnums;
import com.jn.hr.employee.model.EmployeeBasicInfo;
import com.jn.hr.employee.model.EmployeeBasicInfoAdd;
import com.jn.hr.employee.model.EmployeeBasicInfoPage;
import com.jn.hr.employee.service.EmployeeBasicInfoService;
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
 * @create 2019-04-19 上午 9:24
 */
@Api(tags = "员工花名册管理")
@RestController
@RequestMapping("/hr/employeeBasicInfo")
public class EmployeeBasicInfoController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeBasicInfoController.class);
    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private EmployeeBasicInfoService employeeBasicInfoService;

    @ControllerLog(doAction = "添加员工花名册")
    @RequiresPermissions("/hr/employeeBasicInfo/addEmployeeBasicInfo")
    @ApiOperation(value = "添加员工花名册", notes = "添加员工花名册")
    @PostMapping(value = "/addEmployeeBasicInfo")
    public Result addEmployeeBasicInfo(@Validated @RequestBody EmployeeBasicInfoAdd employeeBasicInfoAdd) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        employeeBasicInfoService.addEmployeeBasicInfo(employeeBasicInfoAdd,user);
        return new Result();
    }
    @ControllerLog(doAction = "修改员工花名册")
    @RequiresPermissions("/hr/employeeBasicInfo/updateEmployeeBasicInfo")
    @ApiOperation(value = "修改员工花名册", notes = "修改员工花名册")
    @PostMapping(value = "/updateEmployeeBasicInfo")
    public Result updateResumeData(@Validated @RequestBody EmployeeBasicInfoAdd employeeBasicInfoAdd) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Assert.hasText(employeeBasicInfoAdd.getId(),"id不能为空");
        employeeBasicInfoService.updateEmployeeBasicInfo(employeeBasicInfoAdd,user);
        return new Result();
    }

    @ControllerLog(doAction = "员工花名册列表")
    @RequiresPermissions("/hr/employeeBasicInfo/list")
    @ApiOperation(value = "员工花名册列表", notes = "员工花名册列表")
    @PostMapping(value = "/list")
    public Result<PaginationData<List<EmployeeBasicInfo>>> list(@Validated @RequestBody EmployeeBasicInfoPage employeeBasicInfoPage) {
        PaginationData<List<EmployeeBasicInfo>> data = employeeBasicInfoService.list(employeeBasicInfoPage,false);
        return new Result(data);
    }

    @ControllerLog(doAction = "查询员工花名册详情")
    @RequiresPermissions("/hr/employeeBasicInfo/getEmployeeBasicInfo")
    @ApiOperation(value = "查询员工花名册详情", notes = "查询员工花名册详情")
    @GetMapping(value = "/getEmployeeBasicInfo")
    public Result<List<EmployeeBasicInfo>> getResumeDatabaseById(@RequestParam("id") String id) {
        Assert.hasText(id,"id不能为空");
        EmployeeBasicInfo resumeDatabase = employeeBasicInfoService.getEmployeeBasicInfoById(id);
        return new Result(resumeDatabase);
    }


    @ControllerLog(doAction = "删除员工花名册")
    @RequiresPermissions("/hr/employeeBasicInfo/deleteEmployeeBasicInfo")
    @ApiOperation(value = "删除员工花名册", notes = "删除员工花名册")
    @GetMapping(value = "/deleteEmployeeBasicInfo")
    public Result delete(@RequestParam("id") String id) {
        Assert.hasText(id,"id不能为空");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        employeeBasicInfoService.delete(id, user);
        return new Result();
    }

    @ControllerLog(doAction = "导入员工花名册")
    @RequiresPermissions("/hr/employeeBasicInfo/importEmployeeBasicInfo")
    @ApiOperation(value = "导入员工花名册", notes = "导入员工花名册")
    @PostMapping(value = "/importEmployeeBasicInfo")
    public Result<String> importEmployeeBasicInfo(@RequestParam("file") MultipartFile file) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String str= employeeBasicInfoService.importEmployeeBasicInfo(file,user);
        return new Result<String>(str);
    }

    @ControllerLog(doAction = "导入直属领导")
    @RequiresPermissions("/hr/employeeBasicInfo/importDirectlyLeader")
    @ApiOperation(value = "导入直属领导", notes = "导入直属领导")
    @PostMapping(value = "/importDirectlyLeader")
    public Result<String> importDirectlyLeader(@RequestParam("file") MultipartFile file) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String str= employeeBasicInfoService.importDirectlyLeader(file,user);
        return new Result<String>(str);
    }

    @ControllerLog(doAction = "导入社保福利")
    @RequiresPermissions("/hr/employeeBasicInfo/importSocialSecurity")
    @ApiOperation(value = "导入社保福利", notes = "导入社保福利")
    @PostMapping(value = "/importSocialSecurity")
    public Result<String> importSocialSecurity(@RequestParam("file") MultipartFile file) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String str= employeeBasicInfoService.importSocialSecurity(file,user);
        return new Result<String>(str);
    }

    @ControllerLog(doAction = "导入教育经历")
    @RequiresPermissions("/hr/employeeBasicInfo/importEducationExperience")
    @ApiOperation(value = "导入教育经历", notes = "导入教育经历")
    @PostMapping(value = "/importEducationExperience")
    public Result<String> importEducationExperience(@RequestParam("file") MultipartFile file) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String str= employeeBasicInfoService.importEducationExperience(file,user);
        return new Result<String>(str);
    }

    @ControllerLog(doAction = "导入工作经历")
    @RequiresPermissions("/hr/employeeBasicInfo/importWorkExperience")
    @ApiOperation(value = "导入工作经历", notes = "导入工作经历")
    @PostMapping(value = "/importWorkExperience")
    public Result<String> importWorkExperience(@RequestParam("file") MultipartFile file) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String str= employeeBasicInfoService.importWorkExperience(file,user);
        return new Result<String>(str);
    }

    @ControllerLog(doAction = "导出员工花名册")
    @RequiresPermissions("/hr/employeeBasicInfo/exportEmployeeBasicInfo")
    @ApiOperation(value = "导出员工花名册", notes = "导出员工花名册")
    @GetMapping(value = "/exportEmployeeBasicInfo")
    public void exportEmployeeBasicInfo(EmployeeBasicInfoPage employeeBasicInfoPage,
                                   HttpServletResponse response) {
        employeeBasicInfoPage.setPage(1);
        employeeBasicInfoPage.setRows(200000);
        PaginationData<List<EmployeeBasicInfo>> pageList= employeeBasicInfoService.list(employeeBasicInfoPage,false);
        String exportTitle = "姓名,性别,手机号码,个人邮箱,部门名称,职级名称,证件类型,证件号码," +
                "岗位名称,工号,合同类型名称,员工类型,入职日期,出生日期,国籍名称,工作地址,联系地址," +
                "证件姓名,民族,户口类型,户口所在地,籍贯,居住地址,最高学历,政治面貌,婚姻状态,紧急联系人姓名," +
                "紧急联系人电话,QQ,微信,当前合同起始日,当前合同终止日,工作邮箱,工作电话,试用期到期日,试用期,员工状态";
        String exportColName = "name,sexStr,phone,mailbox,departmentName,jobName,certificateType,certificateNumber," +
                "postName,jobNumber,contractName,employeeTypeStr,entryDateStr,birthDateStr,nationalityName,workAddress," +
                "contactAddress,certificateName,nation,registeredTypeStr,registeredResidence,nativePlace," +
                "residentialAddress," +
                "highestAcademic,politicalOutlookStr,maritalStatusStr,emergencyContactName,emergencyContactPhone,qq,wechat," +
                "startCurrentStr,endCurrentStr,workMailbox,workPhone,expirationDateStr,probationPeriod,employStatusStr";
        String fileName = "员工花名册"+ DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
        String sheetName = "员工花名册";
        ExcelUtil.writeExcelWithCol(response, fileName, sheetName, exportTitle,
                exportColName, pageList.getRows());
    }

    @ControllerLog(doAction = "下载员工花名册excel模板")
    @RequiresPermissions("/hr/employeeBasicInfo/downLoadEmployeeBasicInfoExcelTemplate")
    @ApiOperation(value = "下载员工花名册excel模板", notes = "下载员工花名册excel模板")
    @GetMapping(value = "/downLoadEmployeeBasicInfoExcelTemplate")
    public ResponseEntity<byte[]> downLoadEmployeeBasicInfoExcelTemplate() {
        try {
            Resource resource = resourceLoader.getResource(
                    "classpath:excelTemplate/employeeBasicInfoTemplate.xlsx");
            File file = resource.getFile();
            String name = "员工花名册导入模板" + ExcelTypeEnum.XLSX.getValue();
            String fileName = new String(name.getBytes(), "ISO-8859-1");
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/octet-stream");
            headers.add("Content-Disposition", "attachment;filename=" + fileName);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("[员工花名册] ,员工花名册导入模板下载失败", e);
            throw new JnSpringCloudException(EmployeeExceptionEnums.DOWNLOAD_EXCEL_TEMPLATE_FAIL);
        }
    }

    @ControllerLog(doAction = "更新员工状态")
    @RequiresPermissions("/hr/employeeBasicInfo/updateEmployStatus")
    @ApiOperation(value = "更新员工状态", notes = "更新员工状态")
    @GetMapping(value = "/updateEmployStatus")
    public Result passResumeDatabase(@RequestParam("id") String id,@RequestParam("employStatus") String employStatus) {
        Assert.notNull(id,"id不能为空");
        Assert.notNull(employStatus,"员工状态不能为空");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        employeeBasicInfoService.updateEmployStatus(id,employStatus, user);
        return new Result();
    }
    @ControllerLog(doAction = "查询部门员工树")
    @RequiresPermissions("/hr/employeeBasicInfo/selectDepartEmployee")
    @ApiOperation(value = "查询部门员工树", notes = "查询部门员工树")
    @GetMapping(value = "/selectDepartEmployee")
    public Result selectDepartEmployee() {
        List<TreeModel> teeList=employeeBasicInfoService.selectDepartEmployee();
        return new Result(teeList);
    }

}
