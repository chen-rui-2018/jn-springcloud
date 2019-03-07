package com.jn.park.finance.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.park.finance.model.FinanceDepartmentToTypeModel;
import com.jn.park.finance.model.FinanceTypeModel;
import com.jn.park.finance.service.FinanceTypeService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.system.vo.SysDepartmentPostVO;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 财务项目类型controller
 * @author： huangbq
 * @date： Created on 2019/3/7 1:06
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "财务项目类型维护")
@RestController
@RequestMapping("/finance/type")
public class FinanceTypeController extends FinanceBaseController {
    @Autowired
    private FinanceTypeService financeTypeService;

    @ControllerLog(doAction = "新增财务项目类型")
    @ApiOperation(value = "新增财务项目类型", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "")
    @RequiresPermissions("/finance/type/addType")
    public Result<FinanceTypeModel> addType(@Validated FinanceTypeModel financeTypeModel){

        financeTypeModel.setId(null);
        Integer integer=financeTypeService.saveOrUpdate(financeTypeModel,getUser().getAccount());
        if(integer>0){
            return new Result(integer);
        }
        return new Result("-1","新增了0条数据");
    }

    @ControllerLog(doAction = "修改财务项目类型")
    @ApiOperation(value = "修改财务项目类型", httpMethod = "PUT", response = Result.class)
    @PutMapping(value = "")
    @RequiresPermissions("/finance/type/updateType")
    public Result<FinanceTypeModel> updateType(@Validated FinanceTypeModel financeTypeModel){
        if(null==financeTypeModel.getId()){
            return new Result("-1","ID不能为空");
        }
        Integer integer=financeTypeService.saveOrUpdate(financeTypeModel,getUser().getAccount());
        if(integer>0){
            return new Result<>();
        }
        return new Result("-1","更新了0条数据");
    }

    @ControllerLog(doAction = "更新财务项目类型对应的部门")
    @ApiOperation(value = "更新财务项目类型对应的部门", httpMethod = "PUT", response = Result.class)
    @PutMapping(value = "/updateDepartmentByType")
    @RequiresPermissions("/finance/type/updateDepartmentByType")
    public Result updateDepartmentByType(Integer typeId,@RequestBody List<String> departmentIdList){

        //todo 是否要做数据权限控制
        financeTypeService.updateDepartmentByType(typeId,departmentIdList,getUser().getAccount());
        return new Result();
    }

    @ControllerLog(doAction = "查看所有财务项目类型")
    @ApiOperation(value = "查看所有财务项目类型", httpMethod = "GET", response = Result.class)
    @GetMapping(value = "selectTypeByDepartmentId")
    @RequiresPermissions("/finance/type/selectTypeByDepartmentId")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "departmentId",value = "部门ID",dataType = "String",paramType = "query")
    )
    public Result selectTypeByDepartmentId(@ApiParam(name = "departmentId",value = "部门ID")String departmentId){
        //财务部能看所有部门的数据，非财务部的用户，需要校验下要查询的部门是否属于用户所属的部门
        if(!isFinanceDepartment(getUser())){
            checkDepartmentId(getUser(),departmentId);
        }

        List<FinanceTypeModel>typeModelList=financeTypeService.selectTypeByDepartmentId(departmentId);
        return new Result(typeModelList);
    }

    @ControllerLog(doAction = "查看类型对应的所有部门")
    @ApiOperation(value = "查看类型对应的所有部门", httpMethod = "GET", response = Result.class)
    @GetMapping(value = "selectDepartmentByTypeId")
    @RequiresPermissions("/finance/type/selectDepartmentByTypeId")
    @ApiImplicitParam(name = "typeId",value = "类型ID",dataType = "Integer",paramType = "query")
    public Result selectDepartmentByTypeId(Integer typeId){
        List<FinanceDepartmentToTypeModel>typeModelList=financeTypeService.selectDepartmentByTypeId(typeId);
        return new Result(typeModelList);
    }


}
