package com.jn.park.finance.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.park.finance.model.FinanceTypeModel;
import com.jn.park.finance.service.FinanceTypeService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.system.vo.SysDepartmentPostVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.http.HttpMethod;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 财务项目类型controller
 * @author： huangbq
 * @date： Created on 2019/3/7 1:06
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "财务项目类型管理")
@RestController
@RequestMapping("/finance/type")
public class FinanceTypeController extends BaseController {
    private FinanceTypeService financeTypeService;

    @ControllerLog(doAction = "新增财务项目类型")
    @ApiOperation(value = "新增财务项目类型", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "")
    @RequiresPermissions("/finance/type/add")
    public Result<FinanceTypeModel> add(@Validated FinanceTypeModel financeTypeModel){

        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        financeTypeModel.setId(null);
        Integer integer=financeTypeService.saveOrUpdate(financeTypeModel,user.getAccount());
        if(integer>0){
            return new Result<>();
        }
        return new Result("-1","新增了0条数据");
    }

    @ControllerLog(doAction = "修改财务项目类型")
    @ApiOperation(value = "修改财务项目类型", httpMethod = "PUT", response = Result.class)
    @PutMapping(value = "")
    @RequiresPermissions("/finance/type/update")
    public Result<FinanceTypeModel> update(@Validated FinanceTypeModel financeTypeModel){
        if(null==financeTypeModel.getId()){
            return new Result("-1","ID不能为空");
        }
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        financeTypeModel.setId(null);
        Integer integer=financeTypeService.saveOrUpdate(financeTypeModel,user.getAccount());
        if(integer>0){
            return new Result<>();
        }
        return new Result("-1","更新了0条数据");
    }

    @ControllerLog(doAction = "查看所有财务项目类型")
    @ApiOperation(value = "查看所有财务项目类型", httpMethod = "PUT", response = Result.class)
    @PutMapping(value = "selectByDepart")
    @RequiresPermissions("/finance/type/selectByDepart")
    public Result selectByDepart(String departmentId){
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //财务部能看所有部门的数据，非财务部的用户，需要校验下要查询的部门是否属于用户所属的部门
        if(!isFinanceDepartment(user)){
            checkDepartmentId(user,departmentId);
        }

        List<FinanceTypeModel>typeModelList=financeTypeService.selectByDepart(departmentId);
        return new Result(typeModelList);
    }

    /**
     * 校验departmentId是否属于用户所属的部门
     * @param user
     * @param departmentId
     */
    private void checkDepartmentId(User user,String departmentId){
        boolean flag=false;
        for(SysDepartmentPostVO departmentPostVO:user.getSysDepartmentPostVO()){
            if(StringUtils.equals(departmentId,departmentPostVO.getDepartmentId())){
                flag=true;
                break;
            }
        }
        if(!flag){
            throw new JnSpringCloudException(new Result("-1","你不属于此部门"));
        }
    }

    /**
     * 是否为财务部
     * @param user
     * @return
     */
    private boolean isFinanceDepartment(User user){
        //todo
        for(SysDepartmentPostVO departmentPostVO:user.getSysDepartmentPostVO()){
            if(departmentPostVO.getDepartmentId().indexOf("财务部")>-1){
                return true;
            }
        }
        return false;
    }
}
