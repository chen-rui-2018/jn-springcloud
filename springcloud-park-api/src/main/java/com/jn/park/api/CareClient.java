package com.jn.park.api;

import com.jn.common.model.Result;
import com.jn.park.care.model.CareParam;
import com.jn.park.care.model.ServiceEnterpriseCompany;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 点评
 * @author： jiangyl
 * @date： Created on 2019/4/25 15:30
 * @version： v1.0
 * @modified By:
 */
@FeignClient("springcloud-park")
public interface CareClient {

    /**
     * 获取评论信息
     * @param careParam
     * @return
     */
    @RequestMapping(value = "/api/care/findCompanyCareInfo", method = RequestMethod.POST)
    Result findCompanyCareInfo(@RequestBody CareParam careParam);

    /**
     * 查询关注的企业
     * @param careParam
     * @return
     */
    @RequestMapping(value = "/api/care/findCareCompanyList", method = RequestMethod.POST)
    Result<List<String>> findCareCompanyList(@RequestBody CareParam careParam);


    /**
     *根据企业ID 查询相关联的评论和关注数
     */
    @RequestMapping(value = "/api/care/getCompanyNewList", method = RequestMethod.POST)
    List<ServiceEnterpriseCompany> getCompanyNewList(@RequestBody List<ServiceEnterpriseCompany> serviceEnterpriseCompany,@RequestParam("account") String account);

}
