package com.jn.pay.api;

import com.jn.common.model.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 宣传费用支付回调调接口
 * @Author: yangph
 * @Date: 2019/5/27 16:29
 * @Version v1.0
 * @modified By:
 */
@FeignClient("springcloud-enterprise")
public interface PropagandaClient {
    @ApiOperation(value = "根据账单号修改支付状态")
    @RequestMapping(value = "/api/propaganda/propagandaController/updatePayStatus",method = RequestMethod.POST)
    Result<Integer> updatePayStatus(@RequestBody String orderCode);

}
