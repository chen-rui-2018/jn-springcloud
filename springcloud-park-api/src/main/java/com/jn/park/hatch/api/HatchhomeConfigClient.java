package com.jn.park.hatch.api;

import com.jn.common.model.Result;
import com.jn.park.hatch.model.HatchIncubatorEnterpriseParamModel;
import com.jn.park.hatch.model.HatchIncubatorTeamParamModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 孵化企业-众创空间客户端
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
    Result insertEnterpriseInfo(@RequestBody HatchIncubatorEnterpriseParamModel hatchIncubatorEnterpriseParamModel);

    @ApiOperation(value = "孵化企业-新增入孵团队信息",notes = "孵化企业-新增入孵团队信息")
    @RequestMapping(value = "/api/hatch/incubator/insertTeamInfo",method = RequestMethod.POST)
    Result insertTeamInfo(@RequestBody HatchIncubatorTeamParamModel hatchIncubatorTeamParamModel);

}
