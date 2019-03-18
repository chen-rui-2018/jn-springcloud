package com.jn.enterprise.pd.personnel.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
import com.jn.enterprise.pd.personnel.vo.PersonnelFlow1010Vo;
import com.jn.enterprise.pd.personnel.vo.PersonnelFlow1020Vo;
import com.jn.enterprise.pd.personnel.vo.PersonnelFlow2010Vo;
import com.jn.enterprise.pd.personnel.vo.PersonnelFlow2020Vo;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 *
 * @author： huangbq
 * @date： Created on 2019/3/18 9:41
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "项目申报-人才申报")
@RestController
@RequestMapping("/pd/personnel")
public class PersonnelController extends BaseController {

    @ControllerLog(doAction = "提交流程")
    @ApiOperation(value = "提交流程", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/flow/submit")
    @RequiresPermissions("/pd/personnel/flow/submit")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "表单ID",required = true,example = "2"),
            @ApiImplicitParam(name = "isPass",value = "是否同意",required = true,example = "true"),
            @ApiImplicitParam(name = "comments",value = "审批意见",required = true,example = "同意")
    })
    public Result FlowSubmit(Integer id,Boolean isPass, String comments,@ApiParam("表单数据(JSON格式)") Map<String,Object> variables){

        //todo 限制提交权限


        return new Result<>();
    }

    @ControllerLog(doAction = "企业-人才意向申报")
    @ApiOperation(value = "企业-人才意向申报", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/flow/1010")
    @RequiresPermissions("/pd/personnel/flow/1010")
    public Result<PersonnelFlow1010Vo> flow1010(){
        PersonnelFlow1010Vo model =new PersonnelFlow1010Vo();

        return new Result<>(model);
    }

    @ControllerLog(doAction = "人才中心-人才意向申报审核")
    @ApiOperation(value = "人才中心-人才意向申报审核", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/flow/1020")
    @RequiresPermissions("/pd/personnel/flow/1020")
    public Result<PersonnelFlow1020Vo> flow1020(@ApiParam(value = "表单ID",required = true,example = "2") Integer id){
        PersonnelFlow1020Vo model =new PersonnelFlow1020Vo();
        //todo 根据ID查库的数据回显给前端
        return new Result<>(model);
    }

    @ControllerLog(doAction = "人才中心-上传人才申报书模板")
    @ApiOperation(value = "人才中心-上传人才申报书模板", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/flow/2010")
    @RequiresPermissions("/pd/personnel/flow/2010")
    public Result<PersonnelFlow2010Vo> flow2010(@ApiParam(value = "表单ID",required = true,example = "2") Integer id){
        PersonnelFlow2010Vo model =new PersonnelFlow2010Vo();

        //todo 根据ID查库的数据回显给前端
        return new Result<>(model);
    }

    @ControllerLog(doAction = "企业-上传人才申报书")
    @ApiOperation(value = "企业-上传人才申报书", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/flow/2020")
    @RequiresPermissions("/pd/personnel/flow/2020")
    public Result<PersonnelFlow2020Vo> flow2020(@ApiParam(value = "表单ID",required = true,example = "2") Integer id){
        PersonnelFlow2020Vo model =new PersonnelFlow2020Vo();
        //todo 根据ID查库的数据回显给前端
        return new Result<>(model);
    }










}
