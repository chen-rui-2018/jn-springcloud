package com.jn.oa.item.controller;

import com.alibaba.excel.support.ExcelTypeEnum;
import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.oa.item.enmus.WorkPlanExceptionEnmus;
import com.jn.oa.item.entity.TbOaItem;
import com.jn.oa.item.model.*;
import com.jn.oa.item.service.WorkPlanService;
import com.jn.oa.item.vo.WorkPlanVO;
import com.jn.oa.notice.service.impl.NoticeServiceImpl;
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
import java.util.List;
import java.util.UUID;

/**
 * 工作计划管理
 *
 * @author： shaobao
 * @date： Created on 2019/2/20 oa:42
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "工作计划管理")
@RestController
@RequestMapping("/oa/workPlan")
public class WorkPlanController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private WorkPlanService workPlanService;

    @ControllerLog(doAction = "工作计划列表")
    @RequiresPermissions("/oa/workPlan/list")
    @ApiOperation(value = "工作计划列表", notes = "工作计划列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result<PaginationData<List<WorkPlanVO>>> list(WorkPlanPage workPlanPage) {
        PaginationData<List<WorkPlanVO>> data = workPlanService.list(workPlanPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "添加工作计划")
    @RequiresPermissions("/oa/workPlan/add")
    @ApiOperation(value = "添加工作计划", notes = "添加工作计划")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@Validated @RequestBody WorkPlanAdd workPlanAdd) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //设置工作计划id
        workPlanAdd.setId(UUID.randomUUID().toString());
        workPlanService.add(workPlanAdd, user);
        return new Result();
    }

    @ControllerLog(doAction = "查询工作计划详情")
    @RequiresPermissions("/oa/workPlan/getWorkPlanById")
    @ApiOperation(value = "查询工作计划详情", notes = "查询工作计划详情")
    @RequestMapping(value = "/getWorkPlanById", method = RequestMethod.GET)
    public Result<WorkPlanVO> getWorkPlanById(@RequestParam String workPlanId) {
        WorkPlanVO workPlanVO = workPlanService.getWorkPlanById(workPlanId);
        return new Result(workPlanVO);
    }

    @ControllerLog(doAction = "编辑工作计划")
    @RequiresPermissions("/oa/workPlan/update")
    @ApiOperation(value = "编辑工作计划", notes = "编辑工作计划")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update(@Validated @RequestBody WorkPlanEdit workPlanEdit) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        workPlanService.update(workPlanEdit, user);
        return new Result();
    }

    @ControllerLog(doAction = "修改任务状态")
    @RequiresPermissions("/oa/workPlan/updateWorkPlanStatus")
    @ApiOperation(value = "修改任务状态", notes = "修改工作计划任务状态")
    @RequestMapping(value = "/updateWorkPlanStatus", method = RequestMethod.POST)
    public Result updateWorkPlanStatus(@Validated @RequestBody WorkPlanUpdateStatus workPlanUpdateStatus) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        workPlanService.updateWorkPlanStatus(workPlanUpdateStatus, user);
        return new Result();
    }

    @ControllerLog(doAction = "添加备注")
    @RequiresPermissions("/oa/workPlan/addRemark")
    @ApiOperation(value = "添加备注", notes = "添加备注")
    @RequestMapping(value = "/addRemark", method = RequestMethod.POST)
    public Result addRemark(@Validated @RequestBody WorkPlanAddRemark workPlanAddRemark) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        workPlanService.addRemark(workPlanAddRemark, user);
        return new Result();
    }

    @ControllerLog(doAction = "删除工作计划")
    @RequiresPermissions("/oa/workPlan/deleteBatch")
    @ApiOperation(value = "删除工作计划", notes = "(逻辑)删除工作计划")
    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    public Result delete(@RequestParam String workPlanId) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        workPlanService.delete(workPlanId, user);
        return new Result();
    }

    @ControllerLog(doAction = "获取所有项目信息")
    @RequiresPermissions("/oa/workPlan/getItemAll")
    @ApiOperation(value = "获取所有项目信息", notes = "获取所有项目信息")
    @RequestMapping(value = "/getItemAll", method = RequestMethod.GET)
    public Result<List<TbOaItem>> getItemAll() {
        List<TbOaItem> itemList = workPlanService.getItemAll();
        return new Result(itemList);
    }


    @ControllerLog(doAction = "导出工作计划")
    @RequiresPermissions("/oa/workPlan/exportExcelWorkPlanInfo")
    @ApiOperation(value = "导出工作计划", notes = "导出工作计划")
    @RequestMapping(value = "/exportExcelWorkPlanInfo", method = RequestMethod.GET)
    public void exportExcelWorkPlanInfo(WorkPlanPage workPlanPage, HttpServletResponse response) {
        String exportTitle = "项目名称,任务名称,负责人,任务状态,计划工时,消耗工时,剩余工时," +
                "预计开始时间,截止时间,实际开始时间,实际截止时间,是否延期";
        String exportColName = "itemName,workPlanName,responsibleUserName,workPlanStatusMessage,planTime," +
                "totalConsumeTime,totalRemainTime,planStartTime,planEndTime,startTime,endTime,isExpireMessage";
        workPlanPage.setPage(1);
        workPlanPage.setRows(200000);
        PaginationData data = workPlanService.list(workPlanPage);
        List dataRows = (List) data.getRows();
        String fileName = "工作计划";
        String sheetName = "工作计划";
        ExcelUtil.writeExcelWithCol(response, fileName, sheetName, exportTitle, exportColName, dataRows);
    }

    @ControllerLog(doAction = "导入工作计划")
    @RequiresPermissions("/oa/workPlan/importExcelWorkPlanInfo")
    @ApiOperation(value = "导入工作计划", notes = "导入工作计划")
    @RequestMapping(value = "/importExcelWorkPlanInfo", method = RequestMethod.POST)
    public Result importExcelWorkPlanInfo(@RequestParam("file") MultipartFile file) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String result = workPlanService.importExcelWorkPlanInfo(file, user);
        return new Result(result);
    }

    @ControllerLog(doAction = "下载工作计划excel模板")
    @RequiresPermissions("/oa/workPlan/downLoadWorkPlanExcelTemplateInfo")
    @ApiOperation(value = "下载工作计划excel模板", notes = "下载工作计划excel模板")
    @RequestMapping(value = "/downLoadWorkPlanExcelTemplateInfo", method = RequestMethod.GET)
    public ResponseEntity<byte[]> downLoadWorkPlanExcelTemplateInfo() {
        try {
            Resource resource = resourceLoader.getResource("classpath:excelTemplate/workplanTemplate.xlsx");
            File file = resource.getFile();

            //处理名称乱码问题
            String name = "工作计划导入模板" + ExcelTypeEnum.XLSX.getValue();
            String fileName = new String(name.getBytes(), "ISO-8859-1");

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/octet-stream");
            headers.add("Content-Disposition", "attachment;filename=" + fileName);

            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("[工作计划] ,工作计划导入模板下载失败", e);
            throw new JnSpringCloudException(WorkPlanExceptionEnmus.DOWNLOAD_EXCEL_TEMPLATE_FAIL);
        }
    }
}
