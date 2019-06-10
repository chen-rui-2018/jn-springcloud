package com.jn.enterprise.api;

import com.jn.common.model.Result;
import com.jn.enterprise.model.DataTargetModel;
import com.jn.enterprise.model.LoadCompanyDataTargetReq;
import com.jn.enterprise.model.PersonnelProject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 数据上报查询报表相关
 *<pre>
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：${DATE}
 *</pre>
 */
@FeignClient("springcloud-enterprise")
public interface DataReportClient {


    /**
     * 查询企业的上报数据
     * @param loadCompanyDataTargetReq
     * @return
     */
    @RequestMapping(value = "/api/data/report/loadCompanyDataTarget", method = RequestMethod.POST)
    Result<List<DataTargetModel>> loadCompanyDataTarget(@RequestBody LoadCompanyDataTargetReq loadCompanyDataTargetReq);

    /**
     * 企业的营收额达是否连续两年达到500万
     * @param enterpriseId 企业ID （必传）
     * @return
     */
    @RequestMapping(value = "/api/data/report/loadCompanyByRevenue", method = RequestMethod.POST)
    Result<Boolean> loadCompanyByRevenue(String enterpriseId);
}
