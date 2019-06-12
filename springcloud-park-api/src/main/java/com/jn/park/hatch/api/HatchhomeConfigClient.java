package com.jn.park.hatch.api;

import com.jn.common.model.Result;
import com.jn.park.hatch.model.HatchIncubatorEnterpriseParamModel;
import com.jn.park.hatch.model.HatchIncubatorTeamParamModel;
import com.jn.park.hatch.model.HatchUpdateRevenueParamModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 孵化企业客户端
 *
 * @author： wzy
 * @date： Created on 2019/4/28 15:00
 * @version： v1.0
 * @modified By:
 */
@FeignClient("springcloud-park")
public interface HatchhomeConfigClient {

    @ApiOperation(value = "孵化企业-新增入孵企业信息",notes = "孵化企业-新增入孵企业信息")
    @RequestMapping(value = "/api/hatch/incubator/insertEnterpriseInfo",method = RequestMethod.POST)
    Result insertEnterpriseInfo(@RequestBody @Validated HatchIncubatorEnterpriseParamModel hatchIncubatorEnterpriseParamModel);

    @ApiOperation(value = "孵化企业-新增入孵团队信息",notes = "孵化企业-新增入孵团队信息")
    @RequestMapping(value = "/api/hatch/incubator/insertTeamInfo",method = RequestMethod.POST)
    Result insertTeamInfo(@RequestBody @Validated HatchIncubatorTeamParamModel hatchIncubatorTeamParamModel);

    @ApiOperation(value = "孵化企业-通过数据上报企业（团队）更新在孵企业和团队信息",notes = "孵化企业-通过数据上报企业（团队）更新在孵企业和团队信息")
    @RequestMapping(value = "/api/hatch/incubator/updateRevenue",method = RequestMethod.POST)
    Result updateRevenue(@RequestBody @Validated HatchUpdateRevenueParamModel hatchUpdateRevenueParamModel);

    @ApiOperation(value = "孵化企业-更新在孵企业（团队）毕业条件【满足 企业注册时间超过6年】",notes = "孵化企业-更新在孵企业（团队）毕业条件【满足 企业注册时间超过6年】")
    @RequestMapping(value = "/api/hatch/incubator/updateGraduateRegister",method = RequestMethod.POST)
    Result updateGraduateRegister();

    @ApiOperation(value = "孵化企业-更新在孵企业（团队）毕业条件【满足 连续两年营收额达到500万】",notes = "孵化企业-更新在孵企业（团队）毕业条件【满足 连续两年营收额达到500万】")
    @RequestMapping(value = "/api/hatch/incubator/updateGraduateRevenue",method = RequestMethod.POST)
    Result updateGraduateRevenue();

    @ApiOperation(value = "孵化企业-更新在孵企业（团队）报名活动项",notes = "孵化企业-更新在孵企业（团队）报名活动项")
    @RequestMapping(value = "/api/hatch/incubator/updateEnrolmentActivit",method = RequestMethod.POST)
    Result updateEnrolmentActivit();

    @ApiOperation(value = "孵化企业-更新在孵企业（团队）政策申报项",notes = "孵化企业-更新在孵企业（团队）政策申报项")
    @RequestMapping(value = "/api/hatch/incubator/updatePolicyDeclarate",method = RequestMethod.POST)
    Result updatePolicyDeclarate();

}
