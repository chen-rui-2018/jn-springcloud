package com.jn.park.finance.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.down.api.DownLoadClient;
import com.jn.down.model.DownLoad;
import com.jn.park.finance.dao.TbFinanceDocumentMapper;
import com.jn.park.finance.entity.TbFinanceDocument;
import com.jn.park.finance.enums.FinanceBudgetExceptionEnums;
import com.jn.park.finance.enums.FinanceExceptionEnums;
import com.jn.park.finance.model.FinanceDerpartmentModel;
import com.jn.park.finance.model.FinanceDocumentsFindAllModel;
import com.jn.park.finance.model.FinanceDocumentsUploadingModel;
import com.jn.park.finance.service.FinanceDocumentsService;
import com.jn.park.finance.vo.FinanceDocumentsFindAllVo;
import com.jn.park.finance.vo.FinanceTotalBudgetVo;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.system.vo.SysDepartmentPostVO;
import com.jn.upload.api.UploadClient;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author： tangry
 * @date： Created on 2019/3/5
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "财务协同-财务文档")
@RestController
@RequestMapping("/finance/documents")
public class FinanceDocumentsController extends BaseController {

    @Autowired
    private FinanceDocumentsService financeDocumentsService;
    @Autowired
    private DownLoadClient downLoadClient;
    @Autowired
    private TbFinanceDocumentMapper tbFinanceDocumentMapper;

    protected User getUser(){
        return  (User) SecurityUtils.getSubject().getPrincipal();
    }



    @ControllerLog(doAction = "财务文档查询")
    @ApiOperation(value = "财务文档查询",notes = "财务文档查询", httpMethod = "GET", response = Result.class)
    @GetMapping(value = "/findAll")
    @RequiresPermissions("/finance/documents/findAll")
    public Result<PaginationData<List<FinanceDocumentsFindAllVo>>> findAll(@RequestBody FinanceDocumentsFindAllModel financeDocumentsFindAllModel){
        //todo
        this.checkIsSomeYear(financeDocumentsFindAllModel.getStartTime(),financeDocumentsFindAllModel.getEndTime());
        PaginationData findAll=financeDocumentsService.findAll(financeDocumentsFindAllModel);
        return new Result(findAll);
    }

    @ControllerLog(doAction = "文档上传")
    @ApiOperation(value = "文档上传", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/uploading")
    @RequiresPermissions("/finance/documents/uploading")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "docId",value = "文件编号",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "docName",value = "文件名称",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "comment",value = "文件说明",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "departmentId",value = "部门ID",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "departmentName",value = "部门名称",dataType = "String",paramType = "query")
    })
    public Result uploading(@ApiParam(value = "Excel模板文件",required = true) MultipartFile file,String docId,String docName,String comment,String departmentId,String departmentName){
        //todo
        String uploading=financeDocumentsService.uploading(file,docId,docName,comment,departmentId,departmentName,getUser().getAccount());
        return new Result(uploading);
    }

    @ControllerLog(doAction = "下载")
    @ApiOperation(value = "下载", httpMethod = "GET", response = Result.class)
    @GetMapping(value = "/download")
    @RequiresPermissions("/finance/documents/download")
    @ApiImplicitParam(name = "id",value = "id",dataType = "Integer",paramType = "query")
    public ResponseEntity<byte[]> download(Integer id,HttpServletResponse response){
        //todo 检验下载权限
        TbFinanceDocument document =tbFinanceDocumentMapper.selectByPrimaryKey(id);
        if(null==document
            ||!document.getRecordStatus().equals(new Byte("1"))){
            throw new JnSpringCloudException(FinanceExceptionEnums.UN_KNOW,"文件不存在");
        }
        response.setHeader("content-disposition", "attachment;filename="+document.getDocFilename());
        DownLoad downLoad=new DownLoad(document.getDocFilecode(),false);
        ResponseEntity<byte[]> entity= downLoadClient.downLoad(downLoad);
        return entity;
    }


    @ControllerLog(doAction = "获取部门信息")
    @ApiOperation(value = "获取部门信息",notes = "获取部门信息",httpMethod = "GET", response = Result.class)
    @GetMapping(value = "/getUserDepartment")
    @RequiresPermissions("/finance/documents/getUserDepartment")
    public Result<List<SysDepartmentPostVO>> getUserDepartment(){
        //todo
        //部门信息
        List<SysDepartmentPostVO> sysDepartmentPostVO = getUser().getSysDepartmentPostVO();
        //保存要返回的結果
        List<FinanceDerpartmentModel> financeDerpartmentModelList=new ArrayList<>();
        //遍历
        Map<String,String> idSet=new HashMap();
        sysDepartmentPostVO.stream().forEach(e->{
            if(!idSet.containsKey(e.getDepartmentId())){
                FinanceDerpartmentModel model=new FinanceDerpartmentModel();
                model.setDepartmentId(e.getDepartmentId());
                model.setDepartmentName(e.getDepartmentName());
                financeDerpartmentModelList.add(model);
            }
            idSet.put(e.getDepartmentId(),null);
        });

        return new Result(financeDerpartmentModelList);
    }


    /**
     * 校验开始结束日期是否为同一年
     * @param startMonth
     * @param endMonth
     */
    private void checkIsSomeYear(String startMonth,String endMonth){
        if(StringUtils.isBlank(startMonth)||startMonth.length()!=6){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"开始月份格式必须是YYYYMM");
        }
        if(null!=endMonth&&endMonth.length()!=6){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"结束月份格式必须是YYYYMM");
        }
        if((startMonth.compareTo(endMonth))>0){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"结束月份必须大于等于开始月份");
        }
        if(!startMonth.substring(0,4).equals(endMonth.substring(0,4))){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"只能查同一年的数据");
        }
    }
}
