package com.jn.enterprise.api;

import com.jn.enterprise.model.CompanyInfoModel;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 企业服务客户端
 * @Author: yangph
 * @Date: 2019/2/14 10:25
 * @Version v1.0
 * @modified By:
 */
@FeignClient("springcloud-enterprise")
public interface EnterpriseClient {

    /**
     * 创建任务
     */
    @RequestMapping(value = "/api/task/createTask", method = RequestMethod.GET)
    void createTask();

    /**
     * 更新任务状态
     */
    @RequestMapping(value = "/api/task/updateTask", method = RequestMethod.GET)
    void updateTask();


    /**
     * 任务预警
     */
    @RequestMapping(value = "/api/task/taskWarning", method = RequestMethod.GET)
    void taskWarning();

}
