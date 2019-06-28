package com.jn.park.api;

import com.jn.common.model.Result;
import com.jn.park.care.model.CareParam;
import com.jn.park.care.model.ServiceEnterpriseCompany;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * WIFI热点信息
 *<pre>
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：${DATE}
 *</pre>
 */
@FeignClient("springcloud-park")
public interface WifiTowerHeatClient {

    /**
     * 采集wifi热力图信息
     * @return
     */
    @RequestMapping(value = "/api/wifi/collectionHeatInfo", method = RequestMethod.POST)
    Result collectionHeatInfo();

}
