package com.jn.enterprise.api;

import com.jn.enterprise.model.CompanyInfoModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/6/10 17:15
 * @version： v1.0
 * @modified By:
 */
@FeignClient("springcloud-enterprise")
public interface CompanyClient  {

    /**
     * 获取企业信息
     * @param companyId
     * @return
     */
    @RequestMapping(value = "/api/company/getCompanyInfoList", method = RequestMethod.GET)
    CompanyInfoModel getCompanyInfo(@RequestParam(value = "companyId") String companyId);

}
