package com.jn.enterprise.api;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.model.PersonnelProject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 人才服务客户端
 *
 * @author： wzy
 * @date： Created on 2019/4/28 15:00
 * @version： v1.0
 * @modified By:
 */
@FeignClient("springcloud-enterprise")
public interface PersonnelClient {

    /**
     * 获取申报人才企业的数据
     *
     * @return
     */
    @RequestMapping(value = "/api/pd/personnel", method = RequestMethod.POST)
    Result<List<PersonnelProject>> selectByPersonnelProjectList(@Validated @RequestBody PersonnelProject personnelProject);
}
