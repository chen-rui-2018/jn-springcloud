package com.jn.enterprise.company.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.company.enums.RecruitDataTypeEnum;
import com.jn.enterprise.company.enums.RecruitExceptionEnum;
import com.jn.enterprise.company.model.ServiceRecruitParam;
import com.jn.enterprise.company.model.ServiceWebRecruitParam;
import com.jn.enterprise.company.service.RecruitService;
import com.jn.enterprise.company.vo.RecruitDetailsVO;
import com.jn.enterprise.company.vo.RecruitVO;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author： huxw
 * @date： Created on 2019-3-29 15:20:58
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "用户中心-我的企业-招聘管理")
@RestController
@RequestMapping("/guest/RecruitController")
public class RecruitGuestController extends BaseController {

    @Autowired
    private RecruitService recruitService;

    @ControllerLog(doAction = "招聘列表（门户首页）")
    @ApiOperation(value = "招聘列表（门户首页）", notes = "分页查询[默认15条]")
    @RequestMapping(value = "/getWebRecruitList",method = RequestMethod.GET)
    public Result<PaginationData<List<RecruitVO>>> getWebRecruitList(@Validated ServiceWebRecruitParam serviceWebRecruitParam){
        ServiceRecruitParam serviceRecruitParam = new ServiceRecruitParam();
        BeanUtils.copyProperties(serviceWebRecruitParam, serviceRecruitParam);

        //前台查询只能查有效数据
        serviceRecruitParam.setStatus(RecruitDataTypeEnum.ON_SHELVES.getCode());
        return new Result(recruitService.getRecruitList(serviceRecruitParam, RecruitDataTypeEnum.APPROVAL_STATUS_PASS.getCode()));
    }

    @ControllerLog(doAction = "招聘详情")
    @ApiOperation(value = "招聘详情（app/pc-招聘详情）", notes = "必传招聘ID")
    @RequestMapping(value = "/viewRecruitDetails",method = RequestMethod.GET)
    public Result<RecruitDetailsVO> addRecruitClick(@Validated @RequestParam @ApiParam(name="recruitId",value = "招聘ID", required = true) String recruitId){
        Assert.notNull(recruitId, RecruitExceptionEnum.RECRUIT_ID_IS_NULL.getMessage());
        return new Result(recruitService.getRecruitDetailsById(recruitId));
    }

}
