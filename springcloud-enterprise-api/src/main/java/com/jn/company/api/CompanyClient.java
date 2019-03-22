package com.jn.company.api;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.company.model.ServiceCompany;
import com.jn.company.model.ServiceCompanyParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 用户信息客户端
 *
 * @Author: yangph
 * @Date: 2018/11/28 19:30
 * @Version v1.0
 * @modified By:
 */
@FeignClient("springcloud-enterprise")
public interface CompanyClient {
    /**
     * 查询企业列表
     *
     * @param serviceCompanyParam
     * @return
     */
    @RequestMapping(value = "/api/company/getCompanyList", method = RequestMethod.POST)
    Result<PaginationData<List<ServiceCompany>>> getCompanyList(@RequestBody ServiceCompanyParam serviceCompanyParam);

    /**
     * 根据用户账号/企业ID查询企业信息（用户为企业管理员）
     * @param accountOrCompanyId
     * @return
     */
    @RequestMapping(value = "/api/company/getCompanyDetailByAccountOrCompanyId", method = RequestMethod.POST)
    Result<ServiceCompany> getCompanyDetailByAccountOrCompanyId(@RequestBody String accountOrCompanyId);

}
